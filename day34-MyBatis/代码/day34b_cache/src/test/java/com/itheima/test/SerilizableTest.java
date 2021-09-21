package com.itheima.test;

import com.itheima.bean.User;
import org.junit.Test;

import java.io.*;

public class SerilizableTest {

    @Test
    public void test01() throws Exception {
        File file = new File("user.txt");

        //序列化持久化对象
        /*ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        User user = new User();
        user.setUsername("zs");
        user.setAddress("深圳");
        out.writeObject(user);
        out.close();*/

        //反序列化，并得到对象
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Object obj = in.readObject();
        User newUser = (User) obj;
        in.close();
        System.out.println(newUser);
    }
}
