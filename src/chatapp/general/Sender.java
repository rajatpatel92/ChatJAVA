/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp.general;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Rajat
 */
public class Sender extends Streams{
    //Streams streams;
    //PrintWriter send;
    
    public Sender(Socket socket) throws IOException{
        send = new PrintWriter(socket.getOutputStream(),true);
    }

    public void sendMessage(String msg) {
        if(send != null){
            send.println(msg);
        }
    }
    public void closeOutStream() {
        if(send != null) {
            send.close();
        }
    }
}
