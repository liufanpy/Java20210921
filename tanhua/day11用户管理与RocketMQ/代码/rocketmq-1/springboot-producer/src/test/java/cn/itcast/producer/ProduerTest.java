package cn.itcast.producer;

import cn.itcast.producer.pojo.Order;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 普通消息
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProduerTest {

    /**
     * 生产者发送消息：
     *   1、注入RocketMqTemplate
     *   2、调用方法发送消息
     */
    @Autowired
    private RocketMQTemplate template;

    //发送普通消息
    @Test
    public void testSendBaseMessage() {
        //D destination:主题  Object payload：发送到主题队列中消息
        template.convertAndSend("baseTopic36", "heima113 is ok123"); //消息主题，消息的内容
    }

    /**
     * 顺序消息
     */
    @Test
    public void testOrderlySendMessage() {
        //9条消息 3个订单4 5 6
        List<Order> orderList = Order.buildOrders();
        for (Order order : orderList) {
            //1、选择队列
            template.setMessageQueueSelector(new MessageQueueSelector() {
                //选择目标队列  list：所有队列，message：消息，key：需要进行取模的参数（订单ID）
                public MessageQueue select(List<MessageQueue> list, Message message, Object key) {
                    Long id = Long.valueOf((String)key);
                    int index = (int) (id % list.size());//队列的索引 从0 1 2 3开始（第一队列）
                    return list.get(index);
                }
            });
            //2、发送消息
            //destination 主题
            //payload:消息内容
            //hashKey:自定义值（订单号）
            template.syncSendOrderly("orderlyTopic36",order.toString(),order.getId().toString());
        }
    }

    /**
     * 发送延迟消息
     */
    @Test
    public void testDelaySendMessage() {
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        //topic:一级主题 tag:二级主题
       // Message message = new Message("delayTopic","tag",("延迟消息"+time).getBytes());
        //延迟级别messageDelayLevel=1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
        //参数1：主题名 参数2：延迟消息内容 参数3：超时时间 参数4：延迟级别（rocketmq默认18个级别）
        template.syncSend("delayTopic36", MessageBuilder.withPayload("延迟消息"+time).build(), 10000, 2);
        System.out.println("发送延迟消息。。。。"+time);
    }

    /**
     * 发送广播消息
     */
    @Test
    public void testSendBroadCastMessage() {
        for (int i = 0; i < 10; i++) {
            template.convertAndSend("broadCast36", "消息："+i); //消息主题，消息的内容
        }
    }

}