package display_controller;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class DisplayControllerTemperatureJmsClient {
	 private Session session;
	 private Connection connection;
	 private MessageConsumer consumer;
	
	public float receiveTemperature() {
		String text = null;
       // Create a messages
		try {
	            // Wait for a message
	            Message message = consumer.receive();
	
	            if (message instanceof TextMessage) {
	                TextMessage textMessage = (TextMessage) message;
	                text = textMessage.getText();
	                System.out.println("Received: " + text);
	            } else {
	                System.out.println("Received: " + message);
	            }
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (text == null) {
			return 0;
		}
		return Float.parseFloat(text);
	}
	
	public void prepareDisplayTemperatureCommunication () {
		try {
           // Create a ConnectionFactory
       	   ConnectionFactory  connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);

           // Create a Connection
           connection = connectionFactory.createConnection();
           connection.start();
           
           // Create a Session
           session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

           // Create the destination (Topic or Queue)
           Destination destination = session.createQueue("TEMPERATURE.FOO");

           // Create a MessageProducer from the Session to the Topic or Queue
           consumer = session.createConsumer(destination);
       }
       catch (Exception e) {
           System.out.println("Caught: " + e);
           e.printStackTrace();
       }
	}
	
	public void endDisplayTemperatureCommunication () {
		// Clean up
 /*      try {
			//session.close();
			//connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
	} 
}
