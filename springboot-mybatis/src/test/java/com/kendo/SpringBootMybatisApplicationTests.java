package com.kendo;

import com.kendo.domain.User;
import com.kendo.mapper.AnnotatedUserMapper;
import com.kendo.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kendone
 */
@SpringBootTest
public class SpringBootMybatisApplicationTests {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AnnotatedUserMapper annotatedUserMapper;

    @Test
    public void insertUser() {
        User user = new User();
        user.setName("霍华德");
        user.setEmail("Howord@163.com");
        annotatedUserMapper.insert(user);
    }

    @Test
    public void findAllUsers() {
        List<User> users = userMapper.findAll();
        assertNotNull(users);
        assertFalse(users.isEmpty());
    }

    @Test
    public void findAllUsersUsingAnnotatedUserMapper() {
        List<User> users = annotatedUserMapper.findAll();
        assertNotNull(users);
        assertFalse(users.isEmpty());
    }

    /**
     * 一级缓存测试
     */
    @Test
    public void firstLevelCacheTest() {
        SqlSession sessionOne = sqlSessionFactory.openSession();
        UserMapper userMapper = sessionOne.getMapper(UserMapper.class);
        User user = userMapper.get(1);
        // sessionOne.clearCache();
        UserMapper sameSessionUserMapper = sessionOne.getMapper(UserMapper.class);
        User anotherUser = sameSessionUserMapper.get(1);
        assertSame(user, anotherUser);

        // 开启另一个会话
        SqlSession anotherSession = sqlSessionFactory.openSession();
        UserMapper anotherSessionUserMapper = anotherSession.getMapper(UserMapper.class);
        User thirdUser = anotherSessionUserMapper.get(1);
        assertNotSame(user, thirdUser);
    }

    /**
     * 二级（会话级）缓存测试
     */
    @Test
    public void secondLevelCacheTest() {
        SqlSession sessionOne = sqlSessionFactory.openSession();
        UserMapper userMapper = sessionOne.getMapper(UserMapper.class);
        User user = userMapper.get(1);
        // 会话提交或关闭时会将数据放入二级缓存
        // sessionOne.close();
        sessionOne.commit();

        SqlSession anotherSession = sqlSessionFactory.openSession();
        UserMapper anotherSessionUserMapper = anotherSession.getMapper(UserMapper.class);
        User anotherUser = anotherSessionUserMapper.get(1);
        assertSame(user, anotherUser);
    }
}
