package com.itheima;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/*
需求:
    按照斗地主的规则，完成洗牌发牌看牌的动作，要求牌面按照大小排序
    具体规则：
        使用54张牌打乱顺序,三个玩家参与游戏，三人交替摸牌，每人17张牌，最后三张留作底牌
        牌面展示规则：大王,小王,2,A,K,Q,J,10,9,8,7,6,5,4,3...
        花色按照黑红梅方的顺序，优先花色排列。
分析:
    准备牌:见图。
    洗牌：
        对牌号操作即可
    发牌
        使用牌号作为发牌对象，使用单列集合作为玩家记录手中牌号
    看牌
        对单列集合排序
        遍历手中牌号,从牌盒中获取对应牌面并打印。


步骤:
准备牌
    将牌盒设计为一个HashMap<Integer，String>集合
    将牌号作为键，牌面(牌面由花色和数字组成)作为值，按照映射关系，放进牌盒集合
    使用一个ArrayList集合记录所有牌号
洗牌：
    使用Collections类的shuffle方法对牌号进行打乱
发牌
    为每个玩家和剩余底牌各分配一个ArrayList<Integer>记录牌号。
    将牌号通过对3取模判断，依次发牌，存入玩家集合中
    将最后3张牌号，直接存放于底牌集合中
看牌
    使用Collections类中的sort方法对玩家的牌号进行排序
    遍历手中牌号,从牌盒中获取对应牌面并打印。




 */
public class Test {
    public static void main(String[] args) {
        // 准备牌
        // 将牌盒设计为一个HashMap<Integer，String>集合
        HashMap<Integer, String> cardBox = new HashMap<>();
        // 使用一个ArrayList集合记录所有牌号
        ArrayList<Integer> list = new ArrayList<>();
        // 将牌号作为键，牌面(牌面由花色和数字组成)作为值，按照映射关系，放进牌盒集合
        int index = 1;
        String[] nums = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        String[] colors = "♦,♣,♥,♠".split(",");

        for (String num : nums) {
            for (String color : colors) {
                String card = color + num;
                cardBox.put(index, card);
                list.add(index);
                index++;
            }
        }
        cardBox.put(index, "小王");
        list.add(index);
        index++;
        cardBox.put(index, "大王");
        list.add(index);
        System.out.println(cardBox);

        // 洗牌：
        // 使用Collections类的shuffle方法对牌号进行打乱
        Collections.shuffle(list);
        //发牌
        // 为每个玩家和剩余底牌各分配一个ArrayList<Integer>记录牌号。
        ArrayList<Integer> player1 = new ArrayList<>();
        ArrayList<Integer> player2 = new ArrayList<>();
        ArrayList<Integer> player3 = new ArrayList<>();
        ArrayList<Integer> diPai = new ArrayList<>();
        // 将牌号通过对3取模判断，依次发牌，存入玩家集合中
        for (int i = 0; i < list.size(); i++) {
            int cardNum = list.get(i);
            if (i >= 51) {
                // 将最后3张牌号，直接存放于底牌集合中
                diPai.add(cardNum);
            } else {
                if (i % 3 == 0) {
                    player1.add(cardNum);
                } else if (i % 3 == 1) {
                    player2.add(cardNum);
                } else {
                    player3.add(cardNum);
                }
            }
        }

        //看牌
        // 使用Collections类中的sort方法对玩家的牌号进行排序
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        Collections.sort(diPai);
        // 遍历手中牌号,从牌盒中获取对应牌面并打印。
        showCard(player1, cardBox);
        showCard(player2, cardBox);
        showCard(player3, cardBox);
        showCard(diPai, cardBox);

    }

    public static void showCard(ArrayList<Integer> player, HashMap<Integer, String> cardBox) {
        System.out.print("[");
        for (int i = 0; i < player.size(); i++) {
            Integer cardNum = player.get(i);
            String card = cardBox.get(cardNum);
            if (i == player.size() - 1) {
                System.out.print(card);
            } else {
                System.out.print(card + ",");
            }
        }
        System.out.println("]");
    }
}
