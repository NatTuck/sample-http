package main;

import textsock.TextSock;

public class WebClient {
    public static void main(String[] args) {
        TextSock sock = new TextSock("localhost", 3002);
    }
}

