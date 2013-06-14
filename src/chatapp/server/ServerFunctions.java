/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp.server;

import chatapp.general.Streams;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author Rajat
 */
public class ServerFunctions extends Streams {
    public InetAddress[] updateClientList(InetAddress[] clientList, InetAddress client, ServerWindow sw){
        InetAddress temp = client;
        for(int i=0; i<=clientList.length; i++){
            if(clientList[i] == null){
                clientList[i] = temp;
                break;
            }else{
                sw.jTextArea1.append("Oops...Server Limit Reached!! Try Again Later!!");
            }
        }
        return clientList;
    }
    
    public void broadcastClientList(InetAddress[] clientList, Socket[] clients) throws IOException{
        for(int i=0; i<clients.length; i++){
            openOutputStream(clients[i]);
            send.print(clientList);
            closeStreams(clients[i]);
        }
    }
    
    public void sendFriendIp(String FriendName, Socket clientSocket, InetAddress[] clientList) throws IOException{
        openOutputStream(clientSocket);
        for (int i=0; i<clientList.length; i++){
            if((clientList[i].getHostName().compareTo(FriendName))== 0){
                send.print(FriendName);
            }else{
                send.print("NoClientFound");
            }
        } 
        closeStreams(clientSocket);
    }
    
    public InetAddress[] removeClientFromList(String ClientName, InetAddress[] clientList){
        for(int i=0; i<clientList.length; i++){
            if(clientList[i].getHostName().equals(ClientName)){
                InetAddress[] temp = new InetAddress[clientList.length-1];
                System.arraycopy(clientList, 0, temp, 0, i);
                System.arraycopy(clientList, i+1, temp, i, clientList.length-i-1);
                return temp;
            }
        }
        return clientList;
    }
    
    public void sendInetAddress(InetAddress[] myByteArray, int start, int len) throws IOException {
    
    }
}
