/*
 * Copyright (C) 2016 Erik Jhordan Rey.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.kathir.fifa_cleanarchitecture.view.presenter;

import android.support.annotation.NonNull;
import com.example.kathir.fifa_cleanarchitecture.domain.model.Team;
import com.example.kathir.fifa_cleanarchitecture.domain.usecase.GetFifaTeams;
import com.example.kathir.fifa_cleanarchitecture.view.viewmodel.TeamViewModel;
import com.example.kathir.fifa_cleanarchitecture.view.viewmodel.mapper.TeamViewModelToTeamMapper;
import io.reactivex.observers.DisposableObserver;
import java.util.List;
import javax.inject.Inject;

public class TeamsPresenter extends Presenter<TeamsPresenter.View> {

  private GetFifaTeams getFifaTeams;
  private TeamViewModelToTeamMapper mapper;

  @Inject public TeamsPresenter(@NonNull GetFifaTeams getFifaTeams,
      @NonNull TeamViewModelToTeamMapper mapper) {
    this.getFifaTeams = getFifaTeams;
    this.mapper = mapper;
  }

  @SuppressWarnings("unchecked") @Override public void initialize() {
    super.initialize();
    getView().showLoading();
    getFifaTeams.execute(new DisposableObserver<List<Team>>() {

      @Override public void onNext(List<Team> teams) {
        List<TeamViewModel> teamViewModels = mapper.reverseMap(teams);
        getView().showFifaTeams(teamViewModels);
      }

      @Override public void onError(Throwable e) {
        getView().hideLoading();
        e.printStackTrace();
      }

      @Override public void onComplete() {
        getView().hideLoading();
      }
    });
  }

  public void onTeamClicked(TeamViewModel team) {
    getView().openTeamScreen(team);
  }

  public void destroy() {
    this.getFifaTeams.dispose();
    setView(null);
  }

  public interface View extends Presenter.View {

    void showFifaTeams(List<TeamViewModel> teamList);

    void openTeamScreen(TeamViewModel team);
  }
}
