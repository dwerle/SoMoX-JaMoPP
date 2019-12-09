package temp_controller;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class TempControllerJmsClient {
	
	 private Session session;
	 private Connection connection;
	 private MessageProducer producer;
	
	public void sendTemperature(float temperature) {
        // Create a messages
        String text = String.valueOf(temperature);
        TextMessage message;
		try {
			message = session.createTextMessage(text);
			
	        // Tell the producer to send the message
	        System.out.println("Sent message: Temperatur" + text);
	        producer.send(message);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void prepareCommunication () {
		try {
            // Create a ConnectionFactory
            //ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost:61616");
        	ConnectionFactory  connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);

            // Create a Connection
            connection = connectionFactory.createConnection();
            connection.start();

            // Create a Session
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (Topic or Queue)
            Destination destination = session.createQueue("TEMPERATURE.FOO");

            // Create a MessageProducer from the Session to the Topic or Queue
            producer = session.createProducer(destination);
            // producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        }
        catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
	}
	
	public void endCommunication () {
		// Clean up
       /* try {
        	//producer.close();
			//session.close();
			//connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
	}
}
