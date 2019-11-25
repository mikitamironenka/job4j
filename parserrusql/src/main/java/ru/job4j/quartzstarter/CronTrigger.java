package ru.job4j.quartzstarter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import ru.job4j.database.DBConnect;

import java.io.InputStream;
import java.util.Properties;

public class CronTrigger {

    private static final Logger LOG = LogManager.getLogger(CronTrigger.class);

    private String cronScheduler;

    public CronTrigger() {
        init();
    }

    public void init() {
        try (InputStream in = DBConnect.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            this.cronScheduler = properties.getProperty("cron.time");
//            this.cronScheduler = properties.getProperty("cron.timefirst");
        } catch (Exception e) {
            LOG.info(e);
        }
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
