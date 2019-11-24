package ru.job4j.quartzstarter;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class CronTrigger {

    private String cronScheduler;

    public CronTrigger(String cronScheduler) {
        this.cronScheduler = cronScheduler;
    }

    public void startSchedule() throws SchedulerException {

        //Quartz 1.6.3
        //JobDetail job = new JobDetail();
        //job.setName("dummyJobName");
        //job.setJobClass(HelloJob.class);
        JobDetail job = JobBuilder.newJob(ParserJob.class)
                .withIdentity("parse sql.ru", "group1").build();


        //CronTrigger trigger = new CronTrigger();
        //trigger.setName("dummyTriggerNSame");
        //trigger.setCronExpression(cronScheduler);

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("Once a day trigger", "group1")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule(this.cronScheduler))
                .build();

        //schedule it
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }
}
