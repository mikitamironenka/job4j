package ru.job4j.xmltask;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;
import ru.job4j.xmltask.sax.EntryHandler;
import ru.job4j.xmltask.sql.Config;
import ru.job4j.xmltask.sql.StoreSQL;
import ru.job4j.xmltask.xml.ConvertXSQT;
import ru.job4j.xmltask.xml.StoreXML;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MainTest {

    private static String xslSchemeFilePath;

    private int numberOfGeneratedItems = 10;
    private static String outXmlFileName;
    private static String newOutXmlFileName;
    private static String xslScheme;

    private static File outXmlFile;
    private static File newOutXmlFile;
    private static File xslSchemeFile;

    private static String outXmlFilePath;
    private static String newOutXmlFilePath;

    private static String outPutPath;
    private static String newOutPutPath;

    @Before
    public void init() {
        outXmlFileName = "src/test/java/ru/job4j/xmltask/tmpdir/out.xml";
        outXmlFile = new File(outXmlFileName);
        outXmlFilePath = outXmlFile.getAbsolutePath();

        newOutXmlFileName = "src/test/java/ru/job4j/xmltask/tmpdir/newout.xml";
        newOutXmlFile = new File(newOutXmlFileName);
        newOutXmlFilePath = newOutXmlFile.getAbsolutePath();

        xslScheme = "src/test/java/ru/job4j/xmltask/tmpdir/accounts.xsl";
        xslSchemeFile = new File(xslScheme);
        xslSchemeFilePath = xslSchemeFile.getAbsolutePath();

    }

    @Test
    public void mainTest() throws JAXBException, IOException, SAXException, ParserConfigurationException {

        long startTime = System.currentTimeMillis();

        //create db and generate entries
        StoreSQL storeSQL = new StoreSQL(new Config());
        storeSQL.generate(numberOfGeneratedItems);
        //convert data from database to xml
        StoreXML storeXML = new StoreXML(new File(outXmlFilePath));
        storeXML.save(storeSQL.readDataFromDBToList());

        //convert xml to other xml  file
        ConvertXSQT convertXSQT = new ConvertXSQT();
        convertXSQT.convert(new File(outXmlFilePath), new File(newOutXmlFilePath),
                new File(xslSchemeFilePath));

        int result = new EntryHandler(newOutXmlFilePath).parseXmlAndCountEntryValues();
        assertThat(result, is(45));

        long endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");
    }
}