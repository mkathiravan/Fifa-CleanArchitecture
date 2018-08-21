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

package com.example.kathir.fifa_cleanarchitecture.data.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TeamEntity {

  @SerializedName("flag") private String teamFlag;
  @SerializedName("name") private String teamName;
  @SerializedName("images") private List<ImageEntity> images;
  @SerializedName("team_declaimer") private String disclaimer;
  @SerializedName("best_result") private String bestResult;
  @SerializedName("coach") private String coach;
  @SerializedName("leading_scorer") private String leadingScorer;
  @SerializedName("nick_name") private String nickName;


  public String getTeamFlag() {
    return teamFlag;
  }

  public void setTeamFlag(String teamFlag) {
    this.teamFlag = teamFlag;
  }

  public String getTeamName() {
    return teamName;
  }

  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }

  public List<ImageEntity> getImages() {
    return images;
  }

  public void setImages(List<ImageEntity> images) {
    this.images = images;
  }

  public String getDisclaimer() {
    return disclaimer;
  }

  public void setDisclaimer(String disclaimer) {
    this.disclaimer = disclaimer;
  }

  public String getBestResult() {
    return bestResult;
  }

  public void setBestResult(String bestResult) {
    this.bestResult = bestResult;
  }

  public String getCoach() {
    return coach;
  }

  public void setCoach(String coach) {
    this.coach = coach;
  }

  public String getLeadingScorer() {
    return leadingScorer;
  }

  public void setLeadingScorer(String leadingScorer) {
    this.leadingScorer = leadingScorer;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

}
