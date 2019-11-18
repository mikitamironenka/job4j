package ru.job4j.xmltask.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class EntryHandler extends DefaultHandler {

    private ArrayList<Integer> list = new ArrayList<>();
    private File fileForParse;

    public EntryHandler(File fileForParse) {
        this.fileForParse = fileForParse;
    }

    public ArrayList<Integer> getList() {
        return this.list;
    }

    public void startDocument() {
        System.out.println("parsing started");
    }

    public void startElement(String uri, String localName,
                             String qName, Attributes attrs) {
        if (qName.equals("entry")) {
            list.add((Integer.parseInt(attrs.getValue(0))));
        }

    }

    public void endElement(String uri, String localName,
                           String qName) {
    }

    public void characters(char[] ch, int start,
                           int length) {
    }

    @Override
    public void endDocument() {
        System.out.println("Stop parse XML...");
    }



    public int parseXmlAndCountEntryValues() throws ParserConfigurationException, SAXException, IOException {
        int result = -1;

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        parser.parse(new File("D:\\magnit\\newmagnit.xml"), this);
        result = this.list.stream().mapToInt(Integer::intValue).sum();
        return result;
    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        System.out.println(new EntryHandler(new File("D:\\magnit\\newmagnit.xml")).parseXmlAndCountEntryValues());
    }
}
