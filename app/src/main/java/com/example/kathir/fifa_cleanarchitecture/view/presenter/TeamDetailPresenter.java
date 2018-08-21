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
import com.example.kathir.fifa_cleanarchitecture.domain.usecase.GetFifaTeamByFlag;
import com.example.kathir.fifa_cleanarchitecture.view.viewmodel.TeamViewModel;
import com.example.kathir.fifa_cleanarchitecture.view.viewmodel.mapper.TeamViewModelToTeamMapper;
import io.reactivex.observers.DisposableObserver;
import javax.inject.Inject;

public class TeamDetailPresenter extends Presenter<TeamDetailPresenter.View> {

  private final GetFifaTeamByFlag getFifaTeamByFlag;
  private final TeamViewModelToTeamMapper mapper;
  private String teamFlag;

  @Inject public TeamDetailPresenter(@NonNull GetFifaTeamByFlag getFifaTeamByFlag,
      @NonNull TeamViewModelToTeamMapper mapper) {
    this.getFifaTeamByFlag = getFifaTeamByFlag;
    this.mapper = mapper;
  }

  @SuppressWarnings("unchecked") @Override public void initialize() {
    super.initialize();
    getView().showLoading();
    getFifaTeamByFlag.searchTeamByFlag(teamFlag);
    getFifaTeamByFlag.execute(new DisposableObserver<Team>() {
      @Override public void onComplete() {
        getView().hideLoading();
      }

      @Override public void onError(Throwable e) {
        getView().hideLoading();
      }

      @Override public void onNext(Team team) {
        TeamViewModel teamViewModel = mapper.reverseMap(team);
        getView().showTeam(teamViewModel);
      }
    });
  }

  public void setTeamFlag(String teamFlag) {
    this.teamFlag = teamFlag;
  }

  public void destroy() {
    this.getFifaTeamByFlag.dispose();
    setView(null);
  }

  public interface View extends Presenter.View {
    void showTeam(TeamViewModel teamViewModel);
  }
}
