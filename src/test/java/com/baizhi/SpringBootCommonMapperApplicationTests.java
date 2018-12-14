package com.baizhi;

import com.baizhi.entity.User;

import com.baizhi.entity.UserExample;
import com.baizhi.mapper.UserMapper;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCommonMapperApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testSelectAll() {
        List<User> users = userMapper.selectAll();
        for (User user : users) {
            System.out.println(user);
        }

    }

    @Test
    public void testSelectByPrimaryKey() {
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }

    @Test
    public void testSelect() {
        User t = new User();
        t.setId(1);
        t.setName("翠花");
        t.setUserAge(1);
        t.setStatus("aaaa");
        List<User> select = userMapper.select(t);
        for (User user : select) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelectCount() {
        int i = userMapper.selectCount(new User());
        System.out.println(i);
    }

    @Test
    public void testInsert() {

        User user = new User("xiaohei", 1);
        int i = userMapper.insert(user);
        System.out.println(user.getId());
    }

    @Test
    public void testdeleteByPrimaryKey() {

        int i = userMapper.deleteByPrimaryKey(1);
        System.out.println(i);
    }


    @Test
    public void testU() {
        User user = new User(null, "翠花", 1, null, null);
        int i = userMapper.updateByPrimaryKeySelective(user);
    }

    @Test
    public void testLimit() {
        User user = new User(null, null, 1, null, null);
        RowBounds rowBounds = new RowBounds(4, 4);

        List<User> users = userMapper.selectByRowBounds(user, rowBounds);
        for (User user1 : users) {
            System.out.println(user1);
        }

    }

    //qbc
    @Test
    public void testExample() {
        UserExample userExample = new UserExample();
        Short s1 = 22;
        Short s2 = 30;

        userExample.createCriteria().andIdBetween(s1, s2).andUserAgeBetween(s1, s2);
        userExample.or().andIdLessThan(s2);
        List<User> users = userMapper.selectByExample(userExample);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
