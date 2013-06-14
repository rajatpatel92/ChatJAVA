/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp.client;

import chatapp.general.Sender;
import chatapp.general.Streams;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rajat
 */
public class ChatReceiver implements Runnable{
    Streams streams;
    Sender sender;
    ChatWindow cw;
    BufferedReader receive;
    boolean flag = false;;
    ChatReceiver(Socket socket, Sender s, ChatWindow chat) throws IOException{
        flag = true;
        sender = s;
        this.cw = chat;
        receive = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //ChatReceiverThread = new Thread(this);
    }
    @Override
    public void run() {
        try {
            String inStream;
            while (( inStream = receive.readLine()) != null) {
                cw.setIncomingMessage(inStream); 
            }
        } catch (IOException ex) {
            Logger.getLogger(ChatReceiver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeInStream() throws IOException {
        if(receive !=null){
            receive.close();
        }
    }
}
