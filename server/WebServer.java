package main;

import textsock.TextSock;

public class WebServer {
    public static void main(String[] args) {
        TextSock.Server svr = new TextSock.Server(3002);

        while (TextSock conn = svr.accept()) {
            // ...
        }
    }
}
