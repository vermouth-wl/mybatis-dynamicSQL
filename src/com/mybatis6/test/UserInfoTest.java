package com.mybatis6.test;

import com.mybatis6.mapper.UserInfoMapper;
import com.mybatis6.pojo.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class UserInfoTest {

    // SqlSessionFactory 工厂
    private SqlSessionFactory sqlSessionFactory;

    // SqlSession
    private SqlSession sqlSession;

    @Before
    public void init() {
        // 设置mybatis配置文件
        String resource = "mybatis-config.xml";

        // 文件流
        InputStream inputStream;

        try {
            // 从配置文件中获取文件流
            inputStream = Resources.getResourceAsStream(resource);

            // 从文件流中获取SqlSessionFactory 工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            // 从SqlSessionFactory工厂中打开sqlSession
            sqlSession = sqlSessionFactory.openSession();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 根据用户名进行模糊查询，如果输入模糊用户名，则查询对应内容，如果没有输入，则查询全部内容
    @Test
    public void testFindUserInfoByUserNameLike() {

        // 获得UserInfoMapper的接口代理对象
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);

        // 创建UserInfo对象, 用于封装查询条件
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("王");

        // 调用接口方法查询
        List<UserInfo> userInfoList = userInfoMapper.findUserInfoByUserNameLike(userInfo);

        // 打印结果
        userInfoList.forEach(e -> System.out.println(e.userInfo()));

    }

     // 根据名字和班级号进行模糊查询，如果输入，返回关联用户信息，如果没有输入，返回所有用户信息
    @Test
    public void testFindUserInfoByName() {

        // 获得UserInfoMapper的接口代理对象
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);

        // 创建UserInfo对象, 用于封装查询条件
        UserInfo userInfo = new UserInfo();
        userInfo.setName("王");
        userInfo.setClassId(1);

        List<UserInfo> userInfoList = userInfoMapper.findUserInfoByName(userInfo);
        userInfoList.forEach(e -> System.out.println(e.userInfo()));

    }

    // 更新用户用户名及密码
    @Test
    public void testUpdateUserInfoUsernameAndPassword() {

        // 获取UserInfo的接口代理对象
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);

        // 实例化UserInfo对象，封装查询条件
        UserInfo userInfo = new UserInfo();
        userInfo.setId(13);
        userInfo.setUserName("测试");
        userInfo.setPassword("yyyyy");

        int result = userInfoMapper.updateUserInfoUsernameAndPassword(userInfo);
        if (result > 0) {
            System.out.println("更新成功");
            System.out.println("正在查询用户...");
            userInfo = userInfoMapper.findUserInfoById(13);
            System.out.println(userInfo.userInfo());
        } else {
            System.out.println("更新失败");
        }

    }


    //
    @After
    public void destroy() {
        // 提交事务
        sqlSession.commit();
        // 关闭事务
        sqlSession.close();
    }

}