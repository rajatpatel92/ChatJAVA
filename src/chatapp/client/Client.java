/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp.client;

import chatapp.general.Streams;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Rajat
 */
public class Client extends ClientFunctions{
    public Socket client;
    public ServerSocket chatSocket;
    public InetAddress[] OLList;
    public Streams streams;
    public Client(String ServerIp, int ServerPort, int LocalPort) throws UnknownHostException, IOException{
        chatSocket = new ServerSocket(LocalPort);
        client = new Socket(ServerIp, ServerPort);
        System.out.println("Connected To Server at :"+ client.getInetAddress());
        streams = new Streams();
        streams.openInputStream(client);
        streams.openInputStream(client);
    }
    
    public void runClient() throws IOException{
        
    }
}
