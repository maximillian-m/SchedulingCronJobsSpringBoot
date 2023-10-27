package com.example.javaschedulartutorial;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskScheduler {
    private final ThreadPoolTaskScheduler threadPoolTaskScheduler;

    public void runningClass(){
        Runnable taskRunner = () ->{
            System.out.println("Derrick is the biggest man of our time yeah");
        };
        threadPoolTaskScheduler.schedule(taskRunner, new CronTrigger("*/2 * * * * *"));
    }
}
