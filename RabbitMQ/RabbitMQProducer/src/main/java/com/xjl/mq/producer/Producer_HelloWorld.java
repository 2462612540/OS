package com.xjl.mq.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Classname Producer_HelloWorld
 * @Description TODO
 * @Date 2021/9/21 8:49
 * @Created by xjl
 */
public class Producer_HelloWorld {
    public static void main(String[] args) throws IOException, TimeoutException {
        //1.创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //2．设置参数
        factory.setHost("192.168.25.128");//默认值localhost
        factory.setPort(5672);//设置的端口号
        factory.setVirtualHost("/"); //默认值是 /
        factory.setUsername("guest");
        factory.setPassword("guest");

        //3．创建连接connection
        Connection connection = factory.newConnection();

        //4．创建channel
        Channel channel = connection.createChannel();

        //5．创建队列Queue
        /**
         * (String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments)
         * queue 表示队列的名称
         * durable 表示的持久化 当MQ 重启之后还在
         * exclusive
         *      是否独占。只能有一个消费者监听这队列当connection关闭时,
         *      是否删除队列
         * autoDelete:是否自动删除。当没有consumer时，自动删除掉
         * arguments:参数。
         */
        //如果没有一个名字叫hello_worLd的队列，则会创建该队列，如果有则不会创建
        channel.queueDeclare("hello_world", true, false, false, null);

        // 6．发送消息
        /**
         * basicPublish(String exchange, String routingKey, BasicProperties props, byte[] body)
         *   exchange： 交换机的名称简单模式下交换机会使用默认
         *   routingKey：路由的名称
         *   props：配置信息
         *   body：发送的真实消息数据
         *
         */
        String body = "hello xjl……";
        channel.basicPublish("", "hello_world", null, body.getBytes());

        //7 释放资源
//        channel.close();
//        connection.close();
    }

}
