package com.bvarba.appdirect.web.dtos;

public class OrderItem {
  private Integer quantity;
  private String orderItemUnit;

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public String getOrderItemUnit() {
    return orderItemUnit;
  }

  public void setOrderItemUnit(String orderItemUnit) {
    this.orderItemUnit = orderItemUnit;
  }
}
