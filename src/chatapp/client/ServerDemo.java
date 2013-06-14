/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Rajat
 */
public class ServerDemo {
    static ServerSocket server;
    static Socket client;
    static InetAddress[] a;
    static String[] s;
    public static void main(String[] args) throws IOException{
        server = new ServerSocket(3000);
        System.out.println("1");
        while(true){
            client = server.accept();
            System.out.println("1");
            a = new InetAddress[5];
            s = new String[a.length];
            System.out.println("1");
            PrintWriter pw = new PrintWriter(client.getOutputStream());
            System.out.println("1");
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println("1");
            for (int i=0; i<5; i++){
                a[i] = client.getInetAddress();
                s[i] = a[i].toString();
            }
            System.out.println("1");
            pw.println(s);
            System.out.println("1");
        }
    }
}
