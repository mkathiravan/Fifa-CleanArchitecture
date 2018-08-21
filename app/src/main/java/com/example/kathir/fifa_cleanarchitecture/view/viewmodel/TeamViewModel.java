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
package com.example.kathir.fifa_cleanarchitecture.view.viewmodel;

public class TeamViewModel {

  private String flag;
  private String name;
  private String pictureOfFlag;
  private String pictureOfProfile;
  private String pictureOfHeader;
  private String pictureOfDetail;
  private String disclaimer;
  private String bestResult;
  private String coach;
  private String leadingScorer;
  private String nickName;


  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPictureOfFlag() {
    return pictureOfFlag;
  }

  public void setPictureOfFlag(String pictureOfFlag) {
    this.pictureOfFlag = pictureOfFlag;
  }

  public String getPictureOfProfile() {
    return pictureOfProfile;
  }

  public void setPictureOfProfile(String pictureOfProfile) {
    this.pictureOfProfile = pictureOfProfile;
  }

  public String getPictureOfHeader() {
    return pictureOfHeader;
  }

  public void setPictureOfHeader(String pictureOfHeader) {
    this.pictureOfHeader = pictureOfHeader;
  }

  public String getPictureOfDetail() {
    return pictureOfDetail;
  }

  public void setPictureOfDetail(String pictureOfDetail) {
    this.pictureOfDetail = pictureOfDetail;
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
