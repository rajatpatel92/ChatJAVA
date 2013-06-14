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
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Rajat
 */
public class ClientDemo {
    static Socket client;
    static InetAddress[] buf;
    static String[] a;
    public static void main (String[] args) throws UnknownHostException, IOException{
        client = new Socket("127.0.0.1", 3000);
        System.out.println("1");
        buf = new InetAddress[5];
        a = new String[5];
        System.out.println("1");
        PrintWriter pw = new PrintWriter(client.getOutputStream());
        System.out.println("1");
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        System.out.println("1");
        for(int i=0; i<5; i++){
           a[i] = br.read();
           System.out.println(a[i]);
        }
        System.out.println("1");
    }
}
