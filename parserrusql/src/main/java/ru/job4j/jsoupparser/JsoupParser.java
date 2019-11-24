package ru.job4j.jsoupparser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class JsoupParser {

    private String url;
    private Document document;
    private static final Logger LOG = LogManager.getLogger(JsoupParser.class);
    private final static String COLUMN_NAME = "table.forumTable";

    public JsoupParser() { }

    public Document getDocument() {
        return this.document;
    }

    public List<Vacancy> parse(String url) {

        List<Vacancy> result = new ArrayList<>();

        try {
            this.document = Jsoup.connect(url).get();
        } catch (IOException e) {
            LOG.info(e);
        }

        Element table = this.document.select(COLUMN_NAME).first();
        Elements rows = table.select("tr");

        for (int j = 4; j < rows.size(); j++) {
            Element row = rows.get(j);
            Elements cols = row.select("td");

            String position = cols.get(1).text(); //vacancy
            String link = cols.get(1).select("a").attr("href"); // link of vacancy
            String day = cols.get(5).text(); //day of vacancy's creation

            if (position.toLowerCase().contains("java")) {
                if (!position.toLowerCase().contains("script")) {
                    result.add(new Vacancy(position, link, day));
                }
            }
        }
        return result;
    }

    /**
     * Parses table of vacancies from the beginning of the year.
     * @throws IOException
     * @throws ParseException
     */
    public List<Vacancy> parseTableFromBeginingOfTheYear(String url) throws IOException, ParseException {

        List<Vacancy> result = new ArrayList<>();

        int i = 1;
        boolean flag = true;
        while (flag) {
            this.document = Jsoup.connect(url + "/" + i).get();
            Element table = this.document.select(COLUMN_NAME).first();
            Elements rows = table.select("tr");
            for (int j = 1; j < rows.size(); j++) {
                Element row = rows.get(j);
                Elements cols = row.select("td");
                String position = cols.get(1).text(); //vacancy
                String link = cols.get(1).select("a").attr("href"); // link of vacancy
                String day = cols.get(5).text(); //day of vacancy's creation
                if (position.toLowerCase().contains("java")) {
                    if (!position.toLowerCase().contains("script")) {
//                        Date date = convertTodayOrYesterdayToDate(day);
                        if (day.contains("дек")) {
                            flag = false;
                            break;
                        } else {
                            result.add(new Vacancy(position, link, day));
                        }
                    }
                }
            }
            i++;
        }
        return result;
    }

    /**
     * Checks is year begin
     * @param dateInput
     * @return true if year begin
     */
    private boolean isYearBegin(Date dateInput) {
        boolean result = true;

        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        String year = df.format(dateInput);
        if (year.equals("2018")) {
            result = false;
        }
        return result;
    }

    public static void main(String[] args) throws ParseException, IOException {
        String url = "https://www.sql.ru/forum/job-offers";
        JsoupParser jsoupParser = new JsoupParser();
        String date = "13 ноя 19, 20:15";
        System.out.println(jsoupParser.dateFormatter(date));
//        for (Vacancy vacancy : jsoupParser.parseTableFromBeginingOfTheYear(url)) {
//            System.out.println(vacancy);
//        }
    }

    private Date convertTodayOrYesterdayToDate(String line) throws ParseException {

        String stringResult = null;
        Date dateResult;
        String today = "сегодня";
        String yesterday = "вчера";
        SimpleDateFormat formatter = new SimpleDateFormat("dd mmm YY, HH:mm");
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yy");

        if (line.contains(today)) {
            String hhmm = line.substring(9, 14);
            Date date = new Date();
            stringResult = dateFormat.format(date) + ", " + hhmm;
            dateResult = formatter.parse(stringResult);
        } else if (line.contains(yesterday)) {
            String hhmm = line.substring(7, 12);
            Date date = yesterday();
            stringResult = dateFormat.format(date) + ", " + hhmm;
            dateResult = formatter.parse(stringResult);
        } else {
            dateResult = formatter.parse(line);
        }
        return dateResult;
    }

    /**
     * Creates yesterday date
     * @return date
     */
    private Date yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    private Date dateFormatter(String string) throws ParseException {

        String pattern = "dd MMM yy, HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        return simpleDateFormat.parse(string);
    }

}
