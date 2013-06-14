/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp.server;

import chatapp.general.Sender;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rajat
 */
public class ServerReceiver extends ServerFunctions implements Runnable {
    Thread receiveactivity;
    Sender sender;
    ServerWindow sw;
    //BufferedReader receive;
    Socket clientSocket;
    public InetAddress[] clientList;
    ChatProtocol protocol;
    
    ServerReceiver(Socket socket, Sender s, ServerWindow sw, InetAddress[] connectedClients) throws IOException{
        this.clientList = connectedClients;
        this.clientSocket = socket;
        this.sender = s;
        this.sw = sw;
        openInputStream(socket);
        //this.receive = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        protocol = new ChatProtocol(clientSocket, sender, this.sw, clientList);
    }

    @Override
    public void run() {
        try {
            String inStream;
            while (( inStream = receive.readLine()) != null) {
                protocol.processRequest(inStream);
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerReceiver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeInStream() throws IOException {
        if(receive !=null){
            receive.close();
        }
    }
}
