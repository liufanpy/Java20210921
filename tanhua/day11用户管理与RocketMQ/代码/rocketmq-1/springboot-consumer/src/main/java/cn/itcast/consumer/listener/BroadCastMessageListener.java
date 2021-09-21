package cn.itcast.consumer.listener;

import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(
        topic = "broadCast36",consumerGroup = "broadCastGroup",
        messageModel= MessageModel.BROADCASTING
)
//messageModel == CLUSTERING 消息模式（集群模式）
//messageModel == BROADCASTING 广播模式（集群模式）
public class BroadCastMessageListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        System.out.println("消费者1获取消息="+s);
    }
}