package com.demo.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.DemoApplication;
import com.demo.mybatisplus.entity.User;
import com.demo.mybatisplus.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@WebAppConfiguration
public class MpTest {

    @Resource
    UserMapper userMapper;

    /**
     * 增
     */
    @Test
    public void addUser() {
        User user = new User();
        user.setUsername("张三");
        user.setAge(12);
        userMapper.insert(user);
    }

    /**
     * 根据id查
     */
    @Test
    public void getUserById() {
        User user = userMapper.selectById(2);
        System.out.println(user.toString());
    }

    /**
     * 根据条件查
     */
    @Test
    public void selectByCondition() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", "张三");
        // 返回多条记录会报错
        // User user = userDao.selectOne(wrapper);
        // System.out.println(user);
        List<User> userList = userMapper.selectList(wrapper);
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }

    /**
     * 根据条件查
     */
    @Test
    public void selectByCondition2() {
        Map<String, Object> param = new HashMap<>();
        param.put("user_addr", "广西");
        List<User> userList = userMapper.selectByMap(param);
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }

    /**
     * 根据id删
     */
    @Test
    public void deleteById() {
        userMapper.deleteById(2);
    }

    /**
     * 根据条件删
     */
    @Test
    public void deleteByCondition() {
        Map<String, Object> param = new HashMap<>();
        param.put("user_addr", "广西");
        userMapper.deleteByMap(param);
    }

    /**
     * 分页，需要MpConfig配置分页拦截器
     */
    @Test
    public void selectByPage() {
        int pageNum = 1;
        int pageSize = 2;
        IPage<User> userPage = userMapper.selectPage(new Page<>(pageNum, pageSize),
                new QueryWrapper<User>()
                .eq("user_addr", "广东")
        );
        for (User user : userPage.getRecords()){
            System.out.println(user);
        }
        System.out.println("pages：" + userPage.getPages());
        System.out.println("pageNum：" + userPage.getCurrent());
        System.out.println("pageSize：" + userPage.getSize());
        System.out.println("total：" + userPage.getTotal());
    }

    @Test
    public void updateByCondition() {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.like("username", "张");
        // wrapper.likeRight("username", "张");
        User user = new User();
        user.setAge(23);
        userMapper.update(user, wrapper);

        User user2 = userMapper.selectById(2);
        user2.setUserAddr("abc");
        userMapper.updateById(user2);
    }

    /**
     * mapper-locations: classpath:mapper/*.xml
     */
    @Test
    public void selectByXml() {
        String username = "张三";
        List<User> userList = userMapper.selectUser(username);
        for (User user : userList) {
            System.out.println(user);
        }
    }



}
