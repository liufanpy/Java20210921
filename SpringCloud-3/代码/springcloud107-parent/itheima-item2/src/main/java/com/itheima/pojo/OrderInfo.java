package com.itheima.pojo;

/**
 * @author ljh
 * @version 1.0
 * @date 2021/3/11 10:49
 * @description 标题
 * @package com.itheima.pojo
 */
public class OrderInfo {
    private String username;
    private String orderId;
    private String itemId;
    private String itemName;
    private Long price;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
