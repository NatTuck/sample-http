package textsock;

import java.net.*;
import java.io.*;
import java.util.Iterator;

import org.apache.commons.io.LineIterator;

class TextSocket implements Iterable<String> {
    final Socket sock;
    final BufferedReader rdr;
    final BufferedWriter wtr;

    public TextSocket(String host, int port) {
        sock = new Socket(host, port);
        rdr = new BufferedReader(new InputStreamReader(sock.getInputStream(), "UTF-8"));
        wtr = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream(), "UTF-8"));
    }

    public String getLine() {
        return rdr.readLine();
    }

    public Iterator<String> iterator() {
        return new LineIterator(rdr); 
    }

    public void putLine(String line) {
        wtr.write(line, 0, line.length());
    }

    public static class Server {
        public Server(int port) {
            
        }
    }
}
