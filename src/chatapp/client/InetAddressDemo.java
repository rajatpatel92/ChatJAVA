/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp.client;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author Rajat
 */
public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException{
        InetAddress a = InetAddress.getLocalHost();
        InetAddress[] b = new InetAddress[10];
        for (int i=0; i<10; i++){
            b[i]=a;
            System.out.println("Added :"+b[i]);
            System.out.println(b.toString().toCharArray());
        }
        System.out.println();
    }
}
