package com.guoxi.springdevice.service;

import com.guoxi.springdevice.utils.RedisUtil;
import io.jsonwebtoken.lang.Collections;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author guoxi@tg-hd.com
 * @since 2022/6/24$
 */
@SpringBootTest
public class RedisServiceTest {
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void testRedis(){
        boolean keyFlag = redisUtil.set("guoxi", "Value");
        System.out.println(keyFlag);
    }

    /**设置过期时间*/
    @Test
    public void testRedis1(){
        boolean flag = redisUtil.expire("guoxi",1000L);
        System.out.println(flag);
    }

    /**获取过期时间*/
    @Test
    public void testRedis2(){
        Long expire = redisUtil.getExpire("guoxi");
        System.out.println(expire);
    }

    /**获取过期时间*/
    @Test
    public void testRedis3(){
        redisUtil.del("guoxi");
    }

}
