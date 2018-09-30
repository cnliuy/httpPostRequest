package httpPostRequest.tmc;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
/**
 * mq 消费者
 * 
 * ActiveMQ
 * */
public class JMSConsumer {
	//默认连接用户名
    //private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    //默认连接密码
    //private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    //默认连接地址
    //private static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    
    
	//默认连接用户名
    private static final String USERNAME = "tvylmq";//ActiveMQConnection.DEFAULT_USER
    //默认连接密码
    private static final String PASSWORD = "tvylgsycl";//ActiveMQConnection.DEFAULT_PASSWORD
    //默认连接地址
    private static final String BROKER_URL ="tcp://202.99.114.63:18033" ; //ActiveMQConnection.DEFAULT_BROKER_URL


    public static void main(String[] args) {
        //连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKER_URL);
        try {
            //连接
            Connection connection = connectionFactory.createConnection();
            //启动连接
            connection.start();
            //创建session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //消息目的地
            Destination destination = session.createQueue("hello1");
            //destination = session.createQueue("promoteAct");
            
            
            //消息消费者
            MessageConsumer consumer = session.createConsumer(destination);
            while (true) {
                TextMessage message = (TextMessage) consumer.receive();
                if (message != null) {
                    System.out.println("接收到消息： " + message.getText());
                } else {
                    break;
                }
            }
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
        
        while(true) {
        	
        }
    }



}
