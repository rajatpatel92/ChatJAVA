/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp.server;

import chatapp.general.Sender;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rajat
 */
public class Server extends ServerFunctions{
    public Socket[] connectorSocket = new Socket[500];
    public ServerSocket mainServer;
    public InetAddress[] connectedClients = new InetAddress[connectorSocket.length];
    public Sender sender;
    public ServerReceiver receiver;
    public Thread receiveactivity, clientactivity[] = new Thread[connectorSocket.length];
    public ServerWindow sw;
    
    public Server(int port, ServerWindow sw) throws IOException{
        mainServer = new ServerSocket(port);
        this.sw = sw;
    }
    
    public void runServer() {
        sw.setLogMessage("Server running on port "+mainServer.getLocalPort()+"\nWaiting for Clients to connect....");
        for (int i=0; i<=connectorSocket.length; i++){
            try {
                connectorSocket[i] = mainServer.accept();
                connectedClients[i] = connectorSocket[i].getInetAddress();
                //System.out.println(connectedClients);
                sender = new Sender(connectorSocket[i]);
                receiver = new ServerReceiver(connectorSocket[i], sender, sw, connectedClients);
                this.connectedClients = updateClientList(connectedClients, connectedClients[i], this.sw);
                String msg = "Client Connected : "+connectedClients[i].getHostName()+":"+connectorSocket[i]+"\n";
                broadcastClientList(connectedClients, connectorSocket);
                sw.setLogMessage(msg);
                receiveactivity = new Thread(receiver);
                receiveactivity.start();
            } catch (IOException ex) {
                Logger.getLogger(CentralizedServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }
}
