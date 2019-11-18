package ru.job4j.xmltask.xml;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.xmltask.sql.StoreSQL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

//Генерация XML из данных базы. Описывается классом StoreXML.
//StoreXML(File target) - target - Файл куда будет сохраняться данные.
//Метод save(List<Entry> list) - сохраняет данные из list в файл target.
//Данные нужно сохранить в виде XML.
//<entries>
//<entry>
//<field>значение поля field</field>
//</entry>
//...
//<entry>
//<field>значение поля field</field>
//</entry>
//</entries>
//Для создания xml файла нужно использовать технологию JAXB.


/**
 * Generates XML from database's data.
 *
 */
public class StoreXML {

    private static final Logger LOG = LogManager.getLogger(StoreXML.class.getName());

    private final File target;
    private StoreSQL storeSQL;

    /**
     * Constructor.
     * @param target file for save data.
     */
    public StoreXML(File target) {
        this.target = target;
    }

    /**
     * Save data from list to target file.
     * @param list
     */
    public void save(List<Field> list) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(StoreXML.Account.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(
                new StoreXML.Account(list),
                this.target
        );

    }



    @XmlRootElement
    public static class Account {

        private List<StoreXML.Field> values;

        public Account() {
        }

        public Account(List<StoreXML.Field> values) {
            this.values = values;
        }

        public List<StoreXML.Field> getValues() {
            return values;
        }

        public void setValues(List<StoreXML.Field> values) {
            this.values = values;
        }
    }

    @XmlRootElement
    public static class Field {
        private int value;

        public Field() {
        }

        public Field(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

}
