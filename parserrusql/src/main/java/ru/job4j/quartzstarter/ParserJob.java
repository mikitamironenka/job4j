package ru.job4j.quartzstarter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import ru.job4j.database.DBConnect;
import ru.job4j.jsoupparser.JsoupParser;
import ru.job4j.jsoupparser.Vacancy;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class ParserJob implements Job {

    private static final Logger LOG = LogManager.getLogger(ParserJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        LOG.info("Start parsing");

        DBConnect dbConnect = new DBConnect();
        JsoupParser jsoupParser = new JsoupParser();
        String url = "https://www.sql.ru/forum/job-offers";
        List<Vacancy> list;
        try {
            if (dbConnect.isTableEmpty()) {
                list = jsoupParser.parseTableFromBeginingOfTheYear(url);
                dbConnect.insert(list);
            } else {
                list = jsoupParser.parse(url);
                dbConnect.insert(list);
            }
        } catch (SQLException e) {
            LOG.info(e);
        } catch (IOException e) {
            LOG.info(e);
        } catch (ParseException e) {
            LOG.info(e);
        }

        LOG.info("Finish parsing");
    }
}
