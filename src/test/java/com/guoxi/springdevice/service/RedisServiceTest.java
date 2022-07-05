package com.guoxi.springdevice.service;

import com.guoxi.springdevice.mybatis.entity.UserEntity;
import com.guoxi.springdevice.utils.RedisUtil;
import io.jsonwebtoken.lang.Collections;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.Serializable;
import java.util.*;

/**
 * @author guoxi@tg-hd.com
 * @since 2022/6/24$
 */
@SpringBootTest
public class RedisServiceTest {
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void testRedis() {
        boolean keyFlag = redisUtil.set("guoxi", "Value");
        System.out.println(keyFlag);
    }

    /**
     * 设置过期时间
     */
    @Test
    public void testRedis1() {
        boolean flag = redisUtil.expire("guoxi", 1000L);
        System.out.println(flag);
    }

    /**
     * 获取过期时间
     */
    @Test
    public void testRedis2() {
        Long expire = redisUtil.getExpire("guoxi");
        System.out.println(expire);
    }

    /**
     * 删除key
     */
    @Test
    public void testRedis3() {
        redisUtil.del("guoxi");
    }

    /**
     * 删除key
     */
    @Test
    public void testRedis4() {
        Map<String, Object> map = new HashMap<>(16);
        map.put("a", new UserEntity("a", "b", "c", true));
        map.put("b", new UserEntity("d", "e", "f", true));
        map.put("c", new UserEntity("g", "h", "i", true));
        redisUtil.hmset("guoxi", map);
    }


    /**
     * hash
     */
    @Test
    public void testRedis5() {
        Map<Object, Object> guoxi = redisUtil.hmget("Hash");
        System.out.println(guoxi);
    }


    /**
     * list
     */
    @Test
    public void testRedis6() {
        List list = Arrays.asList("a", "b", "c", "d", new UserEntity("q", "w", "1", true));
        redisUtil.lSet("List", list);
        List<Object> list1 = redisUtil.lGet("List", 0, -1);
    }

    /**
     * set
     */
    @Test
    public void testRedis7() {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        redisUtil.sSet("Set", set);


        Set<Object> set1 = redisUtil.sGet("Set");

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        redisUtil.sSet("Set1", list);
        redisUtil.sGet("Set1");

        System.out.println(set1);
    }

}
