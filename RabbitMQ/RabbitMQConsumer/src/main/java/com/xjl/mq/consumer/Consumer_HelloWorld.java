package com.xjl.mq.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Classname Producer_HelloWorld
 * @Description TODO
 * @Date 2021/9/21 8:49
 * @Created by xjl
 */
public class Consumer_HelloWorld {
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

        // 6．接受消息
        /**
         * basicconsume ( String queue, boolean autoAck,Consumer callback)
         *   queue:队列的名称
         *   autoback:是否自动确认
         *   callback:回调对象
         *
         */
        DefaultConsumer Consumer = new DefaultConsumer(channel) {
            /**
             * @description 这是一个回调方法 收到消息后会自动的执行该方法
             * @param: consumerTag 标识
             * @param: envelope 获取一些信息 交换机的路由的key
             * @param: properties
             * @param: body
             * @date: 2021/9/21 9:24
             * @return: void
             * @author: xjl
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("consumerTag" + consumerTag);
                System.out.println("getExchange" + envelope.getExchange());
                System.out.println("getRoutingKey" + envelope.getRoutingKey());
                System.out.println("properties" + properties);
                System.out.println("body" + new String(body));
            }
        };
        channel.basicConsume("hello_world", true, Consumer);

        //7 释放资源
        // 不要关闭消费者 如果是关闭的资源，在下一次消息来的时候还怎么样的实现
    }
}
