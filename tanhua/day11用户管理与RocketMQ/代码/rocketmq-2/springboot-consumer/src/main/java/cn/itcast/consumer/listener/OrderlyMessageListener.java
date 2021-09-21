package cn.itcast.consumer.listener;

import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;


/**
 * consumeMode:顺序消息
 *  消息消费者端：通过多线程获取消息的
 *      获取的消息顺序：保持一致
 *              4：创建订单a
 *              4：付款a
 *              4：完成a
 * consumeMode= ConsumeMode.ORDERLY:按照顺序进行消费
 */
@Component
@RocketMQMessageListener(
        topic = "orderlyTopic36",consumerGroup = "orderlyGroup",consumeMode= ConsumeMode.ORDERLY
)
public class OrderlyMessageListener implements RocketMQListener<String> {


    @Override
    public void onMessage(String message) {
        System.out.println("当前线程："+Thread.currentThread().getName()+",接收到消息：="+message);
    }
}