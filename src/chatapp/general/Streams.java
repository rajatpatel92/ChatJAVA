/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Rajat
 */
public class Streams {
    //Socket client_socket;
    public PrintWriter send;
    public BufferedReader receive;
    
    public void openInputStream(Socket socket) throws IOException{
        receive = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    
    public void openOutputStream(Socket socket) throws IOException{
        send = new PrintWriter(socket.getOutputStream(),true);
    }
    
    public void closeStreams(Socket socket) throws IOException{
        send.close();
        receive.close();
   }
}

