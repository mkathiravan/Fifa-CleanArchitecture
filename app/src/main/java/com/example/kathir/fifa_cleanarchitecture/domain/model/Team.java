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

package com.example.kathir.fifa_cleanarchitecture.domain.model;

public class Team {

  private String flag;
  private String name;
  private String imageFlag;
  private String imageProfile;
  private String imageHeader;
  private String imageDetail;
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

  public String getImageFlag() {
    return imageFlag;
  }

  public void setImageFlag(String imageFlag) {
    this.imageFlag = imageFlag;
  }

  public String getImageProfile() {
    return imageProfile;
  }

  public void setImageProfile(String imageProfile) {
    this.imageProfile = imageProfile;
  }

  public String getImageHeader() {
    return imageHeader;
  }

  public void setImageHeader(String imageHeader) {
    this.imageHeader = imageHeader;
  }

  public String getImageDetail() {
    return imageDetail;
  }

  public void setImageDetail(String imageDetail) {
    this.imageDetail = imageDetail;
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
