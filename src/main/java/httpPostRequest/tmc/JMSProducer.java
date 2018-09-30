package httpPostRequest.tmc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class JMSProducer {
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
            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            //消息目的地
            Destination destination = session.createQueue("hello1");
            //消息生产者
            MessageProducer producer = session.createProducer(destination);
            //设置不持久化，此处学习，实际根据项目决定
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            //发送消息
            //for (int i = 0; i < 10; i++) {
                //创建一条文本消息
            	int  i = 0;            	
                DateFormat bf = new SimpleDateFormat("a HH:mm:ss yyyy-MM-dd E ");//多态
                Date date = new Date();//创建时间
                String format = bf.format(date);//格式化 bf.format(date);
                TextMessage message = session.createTextMessage(format+"生产MQ消息");
                //生产者发送消息
                producer.send(message);
            //}

            session.commit();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

 
}
