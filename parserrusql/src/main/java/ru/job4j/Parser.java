package ru.job4j;

//1. Реализовать модуль сборки анализа данных с sql.ru.
//2. Система должна использовать Jsoup для парсинга страниц.
//3. Система должна запускаться раз в день.
//4. Система должна собирать данные только про вакансии java. учесть что JavaScript не подходит. как и Java Script.
//5. Данные должны храниться в базе данных.
//В базе должна быть таблица vacancy (id, name, text, link)
//id - первичный ключ
//name - имя вакансии
//text - текст вакансии
//link - текст, ссылка на вакансию
//6. Учесть дубликаты. Вакансии с одинаковым именем считаются дубликатами.
//7. Учитывать время последнего запуска. если это первый запуск. то нужно собрать все объявления с начало года.
//8. В системе не должно быть вывода, либо ввода информации. все настройки должны быть в файле. app.properties.


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Parser {

    private static final Logger LOG = LogManager.getLogger(Parser.class);

    private DBConnect dbConnect;
    private String url;
    private Document doc;

    public Parser(String url) {
        this.url = url;
        try {
            this.doc = Jsoup.connect(this.url).get();
            this.dbConnect = new DBConnect();
        } catch (IOException e) {
            LOG.info(e);
        }
    }

    /**
     * Parses table of vacancies from the beginning of the year.
     * @throws IOException
     * @throws ParseException
     */
    public void parseTableFromBeginingOfTheYear() throws IOException, ParseException, SQLException {


    }

    private Date convertTodayOrYesterdayToDate(String day) throws ParseException {

        String stringResult = null;
        Date dateResult;
        String today = "сегодня";
        String yesterday = "вчера";
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yy, HH:mm");
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yy");

        if (day.contains(today)) {

            String mmss = day.substring(9, 14);
            Date date = new Date();
            stringResult = dateFormat.format(date) + ", " + mmss;
            dateResult = formatter.parse(stringResult);

        } else if (day.contains(yesterday)) {

            String mmss = day.substring(7, 12);
            Date date = yesterday();
            stringResult = dateFormat.format(date) + ", " + mmss;
            dateResult = formatter.parse(stringResult);
        } else {
            dateResult = formatter.parse(day);
        }
        return dateResult;
    }

    /**
     * Creates yesterday date
     * @return
     */
    private Date yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }
}
