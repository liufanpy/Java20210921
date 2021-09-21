package com.itheima.security;

import com.itheima.health.pojo.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    主要是使用代码来完成认证和授权
        1. 实现接口 UserDetailsService
        2. 实现方法loadUserByUsername， 这个方法的作用就是根据用户名去查询出来用户，以及用户的权限。
        3. 这里并不真的去查询数据库，而是使用一个Map集合来伪造数据。

        4. 这个类其实就是我们写好了的认证和授权的提供者，里面包含了认证的功能和授权的功能。
 */
public class UserService implements UserDetailsService {

    //使用一个map集合来伪造一个数据库，里面有一些用户 Key: 就是用户名， value :用户对象！
    private static Map<String , User> map = new HashMap<>();

    private static BCryptPasswordEncoder pe = new BCryptPasswordEncoder();

    //使用静态代码块往map集合里面添加用户
    static {
        //第一个用户
        User user1 = new User();
        user1.setUsername("admin");
        //user1.setPassword("admin"); //使用明文密码
        user1.setPassword(pe.encode("admin")); //使用密文密码
        map.put(user1.getUsername() , user1);

        //第二个用户
        User user2 = new User();
        user2.setUsername("zhangsan");
        //user2.setPassword("123"); //使用明文密码
        user2.setPassword(pe.encode("123")); //使用密文密码
        map.put(user2.getUsername() , user2);
    }

    /**
     * 根据用户名查询用户的权限
     * @param username 登录页面提交上来的username
     * @return  UserDetails 用户的详情信息（用户的账号，密码，能使用的权限）;
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("访问了loadUserByUsername=" + username);

        //1. 拿着用户名去查询用户对象，(真实的情况，这里应该要查询数据库的。) ，下面进入认证的代码
        User user = map.get(username);


        //2. 要判断
        if(user == null){ //没有这个用户
            return null;
        }

        //3. 如果不为null，就进入这段代码。 下面进入授权代码、
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_ADMIN")); //它是一个管理员的权限
        list.add(new SimpleGrantedAuthority("add")); // 除了具备管理员的权限，还增加了一个可以添加的权限
        list.add(new SimpleGrantedAuthority("delete")); //除了以上的权限， 还增加了一个可以删除的权限

        //4. 返回用户的详细信息，springsecurity会拿着这份资料去和我们页面提交上来的密码做比较
        //如果一样，就授予这个用户 list集合里面包含的权限，如果不一样，那么就直接登录失败。
        //现在还没有使用到加密的密码，所以密码的前面还需要加上 {noop}
        //return new org.springframework.security.core.userdetails.User(user.getUsername() , "{noop}"+user.getPassword() , list);
        return new org.springframework.security.core.userdetails.User(user.getUsername() , user.getPassword() , list);
    }
}
