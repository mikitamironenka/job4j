package ru.job4j.jsoupparser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class JsoupParser {

    private String url;
    private Document document;
    private static final Logger LOG = LogManager.getLogger(JsoupParser.class);
    private final static String COLUMN_NAME = "table.forumTable";
    private static final String DATE_FORMAT = "dd MMM yy, HH:mm";

    public JsoupParser() { }

    public Document getDocument() {
        return this.document;
    }

    public List<Vacancy> parse(String url) throws IOException {

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
            String text = parseVacancy(link);
            if (position.toLowerCase().contains("java")) {
                if (!position.toLowerCase().contains("script")) {
                    result.add(new Vacancy(position, text, link));
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
                String text = parseVacancy(link);
                if (position.toLowerCase().contains("java")) {
                    if (!position.toLowerCase().contains("script")) {
                        Date date = convertTodayOrYesterdayToDate(day);
                        if (date.before(formatDate("01 янв 2019, 00:00"))) {
                            flag = false;
                            break;
                        } else {
//                            System.out.println(position + " " + text + " " + link);
                            result.add(new Vacancy(position, text, link));
                        }
                    }
                }
            }
            i++;
        }
        return result;
    }


    public static void main(String[] args) throws ParseException, IOException {
        String url = "https://www.sql.ru/forum/job-offers";
        String vacUrl = "https://www.sql.ru/forum/1319336/java-razrabotchik-junior-middle-senior-hadoop-hive-spark-100-220-t-r-m-tulskaya";
        JsoupParser jsoupParser = new JsoupParser();

        System.out.println(jsoupParser.parseVacancy(vacUrl));
    }

    private Date convertTodayOrYesterdayToDate(String line) throws ParseException {

        String stringResult = null;
        Date dateResult;
        String today = "сегодня";
        String yesterday = "вчера";
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
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
            dateResult = formatDate(line);
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


    public Date formatDate(String date) throws ParseException {
        Locale locale = new Locale("ru", "RU");
        DateFormatSymbols dfs = DateFormatSymbols.getInstance(locale);
        String[] shortMonths = {
                "янв", "фев", "мар", "апр", "май", "июн",
                "июл", "авг", "сен", "окт", "ноя", "дек"};
        dfs.setShortMonths(shortMonths);
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, locale);
        sdf.setDateFormatSymbols(dfs);
        Date date1 = sdf.parse(date);
        return date1;
    }


    public String parseVacancy(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Element table = doc.select("table.msgTable").first();
        Elements rows = table.select("tr");
        Element row = rows.get(1);
        Elements cols = row.select("td");
        return cols.get(1).text(); //text
    }

}
