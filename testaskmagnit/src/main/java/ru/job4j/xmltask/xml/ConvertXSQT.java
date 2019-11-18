package ru.job4j.xmltask.xml;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class ConvertXSQT {

    private static final Logger LOG = LogManager.getLogger(ConvertXSQT.class.getName());

    public void convert(File source, File dest, File scheme) {

        try {
            TransformerFactory tf =
                    TransformerFactory.newInstance();
            //установка используемого XSL-преобразования
            Transformer transformer =
                    tf.newTransformer(new StreamSource(scheme));
            //установка исходного XML-документа и конечного XML-файла
            transformer.transform(
                    new StreamSource(source),
                    new StreamResult(dest));
            System.out.print("complete");
        } catch(TransformerException e) {
            LOG.error(e.getMessage(), e);
        }

    }

//    public static void main(String[] args) {
//
//        ConvertXSQT convertXSQT = new ConvertXSQT();
//        convertXSQT.convert(new File("D:\\magnit\\magnit.xml"), new File("D:\\magnit\\newmagnit.xml"),
//                new File("D:\\magnit\\accounts.xsl"));
//
//    }

}
