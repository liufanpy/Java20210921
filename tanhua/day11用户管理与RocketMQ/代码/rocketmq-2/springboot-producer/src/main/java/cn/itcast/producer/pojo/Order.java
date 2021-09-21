package cn.itcast.producer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单实体对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;//订单id
    private String desc;

    /**
     * 构建3个订单
     * @return
     */
    public static List<Order> buildOrders(){
        List<Order> list = new ArrayList<Order>();
        Order order1a = new Order(4l, "创建订单a");
        Order order2a = new Order(5l, "创建订单b");
        Order order3a = new Order(6l, "创建订单c");
        list.add(order1a);
        list.add(order2a);
        list.add(order3a);

        Order order1b = new Order(4l, "付款a");
        Order order2b = new Order(5l, "付款b");
        Order order3b = new Order(6l, "付款c");
        list.add(order1b);
        list.add(order2b);
        list.add(order3b);


        Order order1c = new Order(4l, "完成a");
        Order order2c = new Order(5l, "完成b");
        Order order3c = new Order(6l, "完成b");
        list.add(order1c);
        list.add(order2c);
        list.add(order3c);
        return list;
    }
}