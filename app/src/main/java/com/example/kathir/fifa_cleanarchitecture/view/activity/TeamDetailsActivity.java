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

package com.example.kathir.fifa_cleanarchitecture.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.example.kathir.fifa_cleanarchitecture.FifaApplication;
import com.example.kathir.fifa_cleanarchitecture.R;
import com.example.kathir.fifa_cleanarchitecture.view.base.view.BaseActivity;
import com.example.kathir.fifa_cleanarchitecture.view.presenter.TeamDetailPresenter;
import com.example.kathir.fifa_cleanarchitecture.view.viewmodel.TeamViewModel;
import com.example.kathir.fifa_cleanarchitecture.view.widget.HeaderView;
import com.squareup.picasso.Picasso;
import javax.inject.Inject;

public class TeamDetailsActivity extends BaseActivity implements TeamDetailPresenter.View {

  private final static String TEAM_FLAG_KEY = "team_flag_key";
  @Inject TeamDetailPresenter presenter;

  @BindView(R.id.header_detail) HeaderView detailHeader;
  @BindView(R.id.image_detail_history) ImageView imageDetailHistory;
  @BindView(R.id.label_best_result) TextView labelBestResult;
  @BindView(R.id.label_coach) TextView labelCoach;
  @BindView(R.id.label_leading_scorer) TextView labelLeadingScorer;
  @BindView(R.id.image_detail_profile) ImageView imageDetailProfile;


  public static void open(Context context, String superHeroName) {
    Intent intent = new Intent(context, TeamDetailsActivity.class);
    intent.putExtra(TEAM_FLAG_KEY, superHeroName);
    context.startActivity(intent);
  }

  @Override public void initView() {
    super.initView();
    initializeToolbar();
    initializeDagger();
    initializePresenter();
  }

  @Override protected int getLayoutId() {
    return R.layout.activity_team_detail;
  }

  private void initializeDagger() {
    FifaApplication fifaApplication = (FifaApplication) getApplication();
    fifaApplication.getMainComponent().inject(this);
  }

  private void initializePresenter() {
    presenter.setView(this);
    String flag = getTeamFlagKey();
    presenter.setTeamFlag(flag);
    presenter.initialize();
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == android.R.id.home) {
      onBackPressed();
    }
    return super.onOptionsItemSelected(item);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    presenter.destroy();
  }

  private String getTeamFlagKey() {
    return getIntent().getExtras().getString(TEAM_FLAG_KEY);
  }

  @Override public void showTeam(TeamViewModel teamViewModel) {

    if (getToolbar() != null) {
      getToolbar().setTitle(teamViewModel.getName());
    }
    detailHeader.initializeHeader(teamViewModel.getDisclaimer(), teamViewModel.getNickName());
    getImage(teamViewModel.getPictureOfDetail(), imageDetailHistory);
    labelBestResult.setText(teamViewModel.getBestResult());
    labelCoach.setText(teamViewModel.getCoach());
    labelLeadingScorer.setText(teamViewModel.getLeadingScorer());
    getImage(teamViewModel.getPictureOfProfile(), imageDetailProfile);
    }

  private void getImage(String photo, ImageView photoImageView) {
    Picasso.with(photoImageView.getContext()).load(photo).fit().centerCrop().into(photoImageView);
  }

  private void initializeToolbar() {
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(
          ContextCompat.getColor(TeamDetailsActivity.this, R.color.colorPrimaryDark));
    }

    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
  }

  @Override public void showLoading() {
    // I´m thinking...
  }

  @Override public void hideLoading() {
    // I´m thinking...
  }
}
