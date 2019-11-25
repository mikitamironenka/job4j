package ru.job4j;

import org.junit.Test;
import ru.job4j.database.DBConnect;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DBConnectTest {

    @Test
    public void checkConnection() {
        DBConnect dbConnect = new DBConnect();
        assertThat(dbConnect.init(), is(true));
    }

}