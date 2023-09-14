package com.generalproblems.config;

import com.generalproblems.tasks.TaskOne;
import com.generalproblems.tasks.TaskTwo;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Configuration
@EnableScheduling
public class TaskSchedulerConfig implements SchedulingConfigurer {

    //TODO: Need to paralleize.
    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {

        // Dynamic Trigger for 'Task One'.
        Trigger trigger = (TriggerContext triggerContext) -> {
            CronTrigger cronTrigger = new CronTrigger("0/30 * * * * ?");

            return cronTrigger.nextExecution(triggerContext);
        };

        // Register the trigger for 'Task One'.
        scheduledTaskRegistrar.addTriggerTask(new TaskOne(), trigger);

        // Dynamic Trigger for 'Task Two'.
        Trigger triggerTwo = (TriggerContext triggerContext) -> {
            CronTrigger cronTrigger = new CronTrigger("0/30 * * * * ?");

            return cronTrigger.nextExecution(triggerContext);
        };

        // Register triggerTwo for 'Task Two'.
        scheduledTaskRegistrar.addTriggerTask(new TaskTwo(), trigger);

        scheduledTaskRegistrar.setScheduler(executor);
        scheduledTaskRegistrar.afterPropertiesSet();
    }
}
