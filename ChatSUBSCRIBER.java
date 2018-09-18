/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatsubscriber;
import redis.clients.jedis.Jedis;
import java.util.Scanner;
import redis.clients.jedis.JedisPubSub;
/**
 *
 * @author Onkar Kadam
 */
public class ChatSUBSCRIBER {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Jedis jedis = new Jedis("localhost");
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter the channel name:");
        String channel = scanner.nextLine();
        System.out.println("Starting subscriber for channel " + channel);
        
         while (true) {
            jedis.subscribe(new JedisPubSub() {
                @Override
                public void onMessage(String channel, String message) {
                   // super.onMessage(channel, message);\
                   
                  
                   //onMessage(channel, message);
                    System.out.println("Received message:" + message);
                }

                @Override
                public void onSubscribe(String channel, int subscribedChannels) {
                }

                @Override
                public void onUnsubscribe(String channel, int subscribedChannels) {
                }

                @Override
                public void onPMessage(String pattern, String channel, String message) {
                }

                @Override
                public void onPUnsubscribe(String pattern, int subscribedChannels) {
                }
                
                @Override
                public void onPSubscribe(String pattern, int subscribedChannels) {
                }

            }, channel);
        }
        
        
        
        
    }
    
}
