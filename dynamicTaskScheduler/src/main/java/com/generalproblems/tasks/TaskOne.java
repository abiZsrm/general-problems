package com.generalproblems.tasks;

import org.springframework.stereotype.Component;

public class TaskOne implements java.lang.Runnable {

    @Override
    public void run() {
        System.out.println("Task One Executing.");
    }
}