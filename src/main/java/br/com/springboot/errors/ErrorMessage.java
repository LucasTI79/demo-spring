package br.com.springboot.errors;

import java.util.Date;

public class ErrorMessage {
  private Date currentDate;
  private String message;
  private Integer status;

  public ErrorMessage() {
  }

  public ErrorMessage(Date currentDate, String message) {
    this.currentDate = currentDate;
    this.message = message;
    this.status = 400;
  }

  public ErrorMessage(Date currentDate, String message, Integer status) {
    this.currentDate = currentDate;
    this.message = message;
    this.status = status;
  }

  public Date getCurrentDate() {
    return this.currentDate;
  }

  public void setCurrentDate(Date currentDate) {
    this.currentDate = currentDate;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  
}
