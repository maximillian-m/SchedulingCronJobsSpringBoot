package com.example.javaschedulartutorial;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@EnableAsync
public class Scheduler {

    //you can use the ISO-8601 format to schedule the fixedDelayString, but then you can also pass the value as numbers
    //but basically the DelayString can be used when trying to inject from application.properties the values of which you want to execute.
    //so it can either be the fixedDelayString or fixeRateString against the fixedDelay and the fixedRate
    //The difference between the two fixedDelay and the fixedRate is that for the former if set minds the time the execution of the task takes
    //before starting another task e.g if the task is scheduled for 2secs and it takes the task 2secs to complete it considers that time and starts the
    //other task at the completion of the task

    //but for the fixedRate it does not mind the time of execution once the time elapses it begins the next task amidst the other task.

    //while using the cron to schedule for quartz java it has 7 stars * * * * * * * representing seconds(0 - 59),
    // minutes(0 -59), hour(0 - 23), day of the month (1 - 31), month of the year(1 - 12 or JAN-DEC), day of the week(0 - 6 or SAT - SUN),  year(optional field)
    // While writing your cron job you can have something like this cron = "0 */2 12 ? * FRI" this means you will have to run this ever 12 noon
    //friday every month regardless of the day friday falls in. mind you, you cannot use ? simultaneously in both
    // you can also use the taskScheduler to perform task. firstly you may want to create the taskScheduling bean then assign the threads that you
    //would want to perform the task and proceed from there
    @Async
    @Scheduled(cron = "*/2 * * * * *")
    public void schedule(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String format = localDateTime.format(formatter);
        System.out.println("I am scheduled to run for every 1milli second "+ format);
    }
}
