package com.guoxi.springdevice.service;

import com.guoxi.springdevice.utils.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author guoxi@tg-hd.com
 * @since 2022/6/24$
 */
@Service
@RequiredArgsConstructor
public class RedisService {
    private final RedisUtil redisUtil;

}
