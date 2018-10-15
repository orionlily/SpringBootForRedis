package com.orion.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by LLC on 2018/7/15.
 */
@Service
public class RedisService {
        @Resource
        private RedisTemplate<String,Object> redisTemplate;

        @Resource
        private StringRedisTemplate stringRedisTemplate;
        /**
         * set存数据
         * @param key
         * @param value
         * @return
         */
        public void set(String key, String value){
              ValueOperations<String,String> vo =  stringRedisTemplate.opsForValue();
              vo.set(key,value);
        }

        /**
         * get获取数据
         * @param key
         * @return
         */
        public String get(String key){
                ValueOperations<String, String> vo = stringRedisTemplate.opsForValue();
                return vo.get(key);
        }

        /**
         * 设置有效秒数
         * @param key
         * @param expire
         * @return
         */
        public void expire(String key, long expire){
                redisTemplate.expire(key,expire, TimeUnit.SECONDS);
        }

        /**
         * 移除数据
         * @param key
         * @return
         */
        public void remove(String key){
                redisTemplate.delete(key);
        }

        /**
         * 获取有效时间
         */
        public  Long ttl(String key){
              return  redisTemplate.getExpire(key,TimeUnit.SECONDS);
        }
}
