package com.itheima;

import java.util.ArrayList;
import java.util.Collections;

/*
需求:按照斗地主的规则，完成洗牌发牌看牌的动作
具体规则：
    使用54张牌，将牌的顺序打乱，三个玩家参与游戏，三人交替摸牌，每人17张牌，最后三张留作底牌
    牌面展示规则：大王,小王,2,A,K,Q,J,10,9,8,7,6,5,4,3
分析:
    准备牌
        将牌可以设计为一个HashMap<String>,每个字符串为一张牌
        每张牌由花色和数字两部分组成，可以使用花色数组与数字数组嵌套迭代完成每张牌的组合
        将每张牌放进一个牌盒集合
    发牌
        为每个玩家和剩余底牌各分配一个ArrayList<Integer>记录牌牌号。
        将剩余牌号通过对3取模判断，依次发牌，存入玩家集合中
        将最后3张牌号，直接存放于底牌中
    看牌
        打印玩家集合
        打印底牌集合
实现:
    准备牌思路
        创建集合作为牌盒
        创建数组或集合分别存储花色和数字
        使用循环遍历组合出所有牌号增加到牌盒
        增加大小王牌号
    发牌思路
        定义三个集合作为玩家
        定义一个集合作为底牌
        遍历牌盒中的牌号，利用对3取余分发牌
        将剩余3张牌放到底牌集合中
    看牌思路
        通过遍历玩家的牌号，取出对应的牌面进行展示

 */
public class Test {
    public static void main(String[] args) {
        // 准备牌思路
        // 创建集合作为牌盒
        ArrayList<String> cardBox = new ArrayList<>();
        // 创建数组或集合分别存储花色和数字
        String[] colors = {"♠", "♥", "♣", "♦"};
        String[] nums = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        // 使用循环遍历组合出所有牌号增加到牌盒
        for (String cardColro : colors) {
            for (String cardNum : nums) {
                String card = cardColro + cardNum;
                cardBox.add(card);
            }
        }
        // 增加大小王牌号
        cardBox.add("大王");
        cardBox.add("小王");
        //洗牌 Collections 静态 shuffle
        // Collections.shuffle(cardBox);
        //  发牌思路
        // 定义三个集合作为玩家
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        // 定义一个集合作为底牌
        ArrayList<String> diPai = new ArrayList<>();
        // 遍历牌盒中的牌号，利用对3取余分发牌
        for (int i = 0; i < cardBox.size(); i++) {//i  0-53
            String card = cardBox.get(i);
            // 将剩余3张牌放到底牌集合中
            if (i >= 51) {
                diPai.add(card);
            }else{
                if (i%3==0){
                    player1.add(card);
                }else if(i%3==1){
                    player2.add(card);
                }else{
                    player3.add(card);
                }
            }
        }
        // 看牌思路
        System.out.println("玩家1:"+player1);
        System.out.println("玩家2:"+player2);
        System.out.println("玩家3:"+player3);
        System.out.println("底牌:"+diPai);
    }
}
