package main;

import java.io.IOException;
import textsock.TextSocket;

public class WebServer {
    public static void main(String[] args) throws IOException {
        TextSocket.Server svr = new TextSocket.Server(3002);

        TextSocket conn;
        while (null != (conn = svr.accept())) {
            String req = conn.getln();
            while (!conn.getln().equals("")) {
                // skip it.
            }

            String[] parts = req.split(" ");
            if (!parts[0].equals("GET")) {
                throw new IOException("Expected GET");
            }
            if (!parts[2].equals("HTTP/1.1")) {
                throw new IOException("Expected HTTP/1.1");
            }

            String path = parts[1];

            conn.putln("HTTP/1.1 200 OK");
            conn.putln("Content-type: text/plain");
            conn.putln("");
            conn.putln("Hello, path = " + path);
            conn.close();
        }
    }
}
