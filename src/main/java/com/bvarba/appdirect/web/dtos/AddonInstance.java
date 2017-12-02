package com.bvarba.appdirect.web.dtos;

public class AddonInstance {
  private String id;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "AddonInstance: {id:" + id + "}";
  }

}
