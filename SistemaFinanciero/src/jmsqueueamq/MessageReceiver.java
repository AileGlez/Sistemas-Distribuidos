/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jmsqueueamq;

/**
 *
 * @author JGUTIERRGARC
 */
import javax.jms.*;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageReceiver {

    // URL of the JMS server
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    // default broker URL is : tcp://localhost:61616"

    // Name of the queue we will receive messages from
    private static String subject = "JOGG_QUEUE";

    public void getMessages() {

        boolean goodByeReceived = false;

        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false /*Transacter*/, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue(subject);

            MessageConsumer messageConsumer = session.createConsumer(destination);

            while (!goodByeReceived) {
                System.out.println("Waiting for messages...");
                TextMessage textMessage = (TextMessage) messageConsumer.receive();
                if (textMessage != null) {
                    System.out.print("Received the following message: ");
                    System.out.println(textMessage.getText());
                    System.out.println();

                    //MEssage Sender
                   MessageProducer messageProducer;

                    String text = textMessage.getText();
                    String[] words = text.split("\\s+");
                    for (int i = 0; i < words.length; i++) {
                        words[i] = words[i].replaceAll("[^\\w]", "");
                    }

                    try {

                        messageProducer = session.createProducer(destination);
                        textMessage = session.createTextMessage();

                        textMessage.setText("I recieved bad news of level: "+ words[0]);
                        if(words[0].equals(5)){
                            textMessage.setText("Selling! Selling! Selling");
                            System.out.println("Selling! Selling! Selling");
                            messageProducer.send(textMessage);
                        } else{
                            textMessage.setText("I have to be patient. There is no such thing as economic crisis.");
                            System.out.println("I have to be patient. There is no such thing as economic crisis.");
                        }

                        messageProducer.close();
                        session.close();
                        connection.close();
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }

                }
                if (textMessage.getText() != null && textMessage.getText().equals("Good bye!")) {
                    goodByeReceived = true;
                }
            }

            messageConsumer.close();
            session.close();
            connection.close();




        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MessageReceiver().getMessages();
    }

}
