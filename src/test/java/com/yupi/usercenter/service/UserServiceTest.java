package com.yupi.usercenter.service;

import java.util.Date;

import com.yupi.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    void testAddUser() {
        User user = new User();
        user.setUsername("yupi");
        user.setUserAccount("123");
        user.setAvatarUrl("https://tse2-mm.cn.bing.net/th/id/OIP-C.WrVEZiFiljCDFm0qFpyQSAAAAA?w=191&h=192&c=7&r=0&o=5&dpr=1.3&pid=1.7");
        user.setGender(0);
        user.setUserPassword("123");
        user.setPhone("123");
        user.setEmail("123");


        boolean result = userService.save(user);
        System.out.println(user.getId());
        assertTrue(result);
    }


}