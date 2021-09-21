package cn.itcast.consumer.listener;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * RocketMQ监听器
 *  1、实现RocketMQListener接口
 *  2、实现onMessage方法，完成业务处理
 *  3、需要交给容器管理：@Component
 *  4、在监听器上通过注解配置，需要监听的topic和消费者的组名
 */
@Component
@RocketMQMessageListener(
        topic = "delayTopic36",consumerGroup = "delayGroup"
)
public class DelayMessageListener implements RocketMQListener<String> {


    /**
     * 当获取到中间中，最新消息时候
     * 自动的调用onMessage方法
     * 参数：发送的消息内容
     */
    public void onMessage(String s) {
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println(time+"消息中间件的内容；"+s);
    }
}