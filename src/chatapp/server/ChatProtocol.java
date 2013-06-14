/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp.server;

import chatapp.general.Sender;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author Rajat
 */
public class ChatProtocol extends ServerFunctions{
    Socket clientSocket;
    Sender s;
    ServerWindow sw;
    InetAddress[] clientList;
    
    private final String MSG_OK = "Success!!";
    private final String MSG_invalid = "Invalid Code";
    
    public ChatProtocol(Socket socket, Sender s, ServerWindow sw, InetAddress[] connectedClients){
        this.clientSocket = socket;
        this.s = s;
        this.sw = sw;
        this.clientList = connectedClients;
    }
    
    public String processRequest (String msg) throws IOException{
        String[] code = msg.split(":", 2); 
        switch (code[0]){
            case "100":
                //yet to implement..
            case "101": //code 101 : get IP address of friend
                String FriendName = code[1];
                sendFriendIp(FriendName, clientSocket, clientList);
                sw.setLogMessage("Friend Ip Sent to "+ clientSocket.getInetAddress().getHostName());
                return MSG_OK;
            case "102": //code 102 : remove disconnected Client from the list
                String ClientName = code[1];
                this.clientList = removeClientFromList(ClientName, clientList);
                return MSG_OK;
        }
        return MSG_invalid;
    }
}

