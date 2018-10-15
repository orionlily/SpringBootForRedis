package com.orion.controller;

import com.orion.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LLC on 2018/7/13.
 */
@RestController
@RequestMapping("/jedis")
public class JedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/set")
    public void set(String key, String value){
        redisService.set(key,value);
    }

    @RequestMapping("/get")
    public String get(String key){
       return redisService.get(key);
    }

    @RequestMapping("/expire")
    public void expire(String key, long expire){
        redisService.expire(key,expire);
    }

    @RequestMapping("/remove")
    public void remove(String key){
        redisService.remove(key);
    }

    @RequestMapping("/ttl")
    public Long ttl(String key){
        return redisService.ttl(key);
    }
}
