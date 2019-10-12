package felbakly;

import java.io.PrintWriter;
import java.net.ServerSocket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final var port = 8888;
        try {
            System.out.println("just entered try block");
            // step 1 create a server socket variable and set to port
            final var serverSocket = new ServerSocket(port);
            // step 2 listen to a connection using .accept()
            final var socket = serverSocket.accept();
            System.out.println("Connected.");
            // step 3 get output stream so that we can write data to client
            final var outputStream = socket.getOutputStream();
            // send the OK HTTP status code to the client
            var response = "HTTP/1.1 200 OK";

            var reader = new ReadHTMLFile("index.html");
            reader.read();
            var content = reader.getFileContent();
            var contentLength = content.length();
            // we need a printWriter because we can only write bytes to Streams
            // We use the printWriter so that it is easier for us to write string to
            // the outputStream
            var printWriter = new PrintWriter(outputStream);
            printWriter.println(response);
            // "Content-Length: num" required by the HTTP server Header
            printWriter.println("Content-Length: " + String.valueOf(contentLength));
            printWriter.println("");
            printWriter.println(content);
            // .flush() waits till  everything written prior to it's call
            printWriter.flush();
            System.out.println("Sent");
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }    }
}
