/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatpublisher;

import java.util.Scanner;
import redis.clients.jedis.Jedis;

/**
 *
 * @author Onkar Kadam
 */
public class ChatPUBLISHER {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Jedis jedis = new Jedis("localhost");
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter the channel name:");
        String channel=scanner.nextLine();
        System.out.println("Starting publisher for channel "+ channel);

        while (true){
            System.out.println("Enter the string to Publish:");
            String msg = scanner.nextLine();
            jedis.publish(channel,msg);
        }
    }
    
}
