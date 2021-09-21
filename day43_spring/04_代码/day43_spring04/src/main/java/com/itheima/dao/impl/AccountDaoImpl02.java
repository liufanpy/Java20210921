package com.itheima.dao.impl;

import com.itheima.bean.Account;
import com.itheima.dao.AccountDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/*
    1. 其实这个类还是需要让spring注入进来jdbctemplate的
    2. 参照第一种写法，需要写上setJdbcTemplate方法。
    3. 但是这个方法的代码写的有点多，所以我们选择去继承JdbcDaoSupport ，因为这个JdbcDaoSupport里面
        已经写好了这个setJdbcTemplate方法。继承它了之后，等同于我们的这个类也就拥有了set方法
    4. 但是这个JdbcDaoSupport的jdbcTemplate属性是私有的，所以不能直接拿，需要通过getJdbcTemplate()来得到
    5. 继承并不是让AccountDaoImpl02 就拥有了jdbcTemplate这个对象，只是让我们这个类拥有了setJdbcTemplate方法
        所以还是需要注入进来的。
 */
public class AccountDaoImpl02 extends JdbcDaoSupport implements AccountDao {

    public List<Account> findAll() {
        String sql = "select * from t_account";
        return getJdbcTemplate().query(sql , new BeanPropertyRowMapper<Account>(Account.class));
    }
}
