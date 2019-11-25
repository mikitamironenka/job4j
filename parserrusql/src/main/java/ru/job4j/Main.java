package ru.job4j;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.SchedulerException;
import ru.job4j.quartzstarter.CronTrigger;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class Main {

    private static final Logger LOG = LogManager.getLogger(CronTrigger.class);

    public static void main(String[] args) throws ParseException, SQLException, IOException {

        CronTrigger cronTrigger = new CronTrigger();
        try {
            cronTrigger.startSchedule();
        } catch (SchedulerException e) {
            LOG.info(e);
        }

//        DBConnect dbConnect = new DBConnect();
//        JsoupParser jsoupParser = new JsoupParser();
//        String url = "https://www.sql.ru/forum/job-offers";
//        List<Vacancy> list = jsoupParser.parseTableFromBeginingOfTheYear(url);
//        for(Vacancy vacancy : list) {
//            System.out.println(vacancy);
//        }

//        if (dbConnect.isTableEmpty()) {
//            list = jsoupParser.parseTableFromBeginingOfTheYear(url);
//            dbConnect.insert(list);
//        } else {
//            list = jsoupParser.parse(url);
//            dbConnect.insert(list);
//        }
    }
}
