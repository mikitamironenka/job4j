package ru.job4j.socket;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.google.common.base.Joiner;


public class ServerSideTest {

    private static final String LN = System.getProperty("line.separator");

    @Test
    public void whenAskExitThenExit() throws IOException {
        this.testServer("exit", "");
    }

    @Test
    public void whenAskHelloThenAnswerHello() throws IOException {
        this.testServer(
                Joiner.on(LN).join(
                        "Hello",
                        "exit"
                ),
                Joiner.on(LN).join(
                        "Hello, dear friend, I'm a oracle.",
                        "",
                        ""
                )
        );

    }

    private void testServer(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        String file = "C:/projects/job4j/chapter_006_IO/src/main/java/ru/job4j/socket/file.txt";
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());

        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        ServerSide server = new ServerSide(socket, file);
        server.init();
        assertThat(out.toString(), is(expected)
        );
    }

}