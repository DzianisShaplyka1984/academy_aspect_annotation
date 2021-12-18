package com.academy.service;

import org.springframework.stereotype.Service;

@Service
public class TaskService {

  public void performJob() {
    System.out.println("Perform job");
  }

  public void performJob(String test) {
    System.out.println("Perform job " + test);
  }

  public void performJob(String test, String hello) {
    System.out.println("Perform job " + test + " " + hello);
  }

  public void performExceptionJob() throws Exception {
    System.out.println("Perform exception job");

    throw new Exception();
  }

  public String performJobAround() {
    System.out.println("Perform Job around");
    return "SUCCESS";
  }

  public void performJobWithName(String name) {
    System.out.println("Perform Job with name");
  }
}
