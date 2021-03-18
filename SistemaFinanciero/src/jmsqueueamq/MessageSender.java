/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jmsqueueamq;

/**
 *
 * @author JGUTIERRGARC
 */
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MessageSender {

    // A static manner to link jms resources with java objects
    //@Resource(mappedName = "jms/TestConnectionFactory")  
    //private static ConnectionFactory connectionFactory;  
    //@Resource(mappedName = "jms/TestQueue")  
    //private static Queue queue;  
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    // default broker URL is : tcp://localhost:61616"
    private static String subject = "JOGG_QUEUE"; // Queue Name. You can create any/many queue names as per your requirement. 

    public void produceMessages() {
        MessageProducer messageProducer;
        TextMessage textMessage;
        try {

            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false /*Transacter*/, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(subject);

            messageProducer = session.createProducer(destination);
            textMessage = session.createTextMessage();

            int level = (int) (Math.random()*10);
            String Categoria [] = {"Telecomunicaciones", "Educacion","Food Supply", "Transporte", "Bancos"};

            int num = (int)(Math.random()*(5-0)+0);
            for(int i = 0; i < 20; i++){
                switch(num) {
                    case 1:
                        textMessage.setText(level + " " + Categoria[1]);
                        System.out.println("Sending terrible market news. Level: " + level + " Category: "+ Categoria[1]);
                        messageProducer.send(textMessage);
                        break;
                    case 2:
                        textMessage.setText(level + " " + Categoria[2]);
                        System.out.println("Sending terrible market news. Level: " + level + " Category: "+ Categoria[2]);
                        messageProducer.send(textMessage);
                        break;
                    case 3:
                        textMessage.setText(level + " " + Categoria[3]);
                        System.out.println("Sending terrible market news. Level: " + level + " Category: "+ Categoria[3]);
                        messageProducer.send(textMessage);
                        break;
                    case 4:
                        textMessage.setText(level + " " + Categoria[4]);
                        System.out.println("Sending terrible market news. Level: " + level + " Category: "+ Categoria[4]);
                        messageProducer.send(textMessage);
                        break;
                    case 5:
                        textMessage.setText(level + " " + Categoria[5]);
                        System.out.println("Sending terrible market news. Level: " + level + " Category: "+ Categoria[5]);
                        messageProducer.send(textMessage);
                        break;

                }
            }

            messageProducer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MessageSender().produceMessages();
    }
}
