/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp.server;

import java.io.IOException;

/**
 *
 * @author Rajat
 */
public class CentralizedServer {
    public static void main(String[] args) throws IOException{
        ServerWindow sw = new ServerWindow();
        Server mainserver = new  Server(5000, sw);
        sw.setVisible(true);
        mainserver.runServer();
    }
}
