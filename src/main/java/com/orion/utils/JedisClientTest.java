package com.orion.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.*;

/**
 * Created by LLC on 2018/7/13.
 */
public class JedisClientTest {
    public static void main(String[] args) {
        /*Jedis jedis = new Jedis("192.168.1.102",6379);
        jedis.auth("123456");
        System.out.println(jedis.ping());

        jedis.close();*/
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(20);
        config.setMaxTotal(40);
        config.setMinIdle(10);
        JedisPool jedisPool = new JedisPool(config,"192.168.1.102",6379);
        Jedis jedis = jedisPool.getResource();
        jedis.auth("123456");
        System.out.println(jedis.ping());
        jedisPool.returnResource(jedis);
       /* //string
        jedis.set("guno","GUMP");

        System.out.println(jedis.get("guno"));

        Student student = new Student();
        student.setName("orion");
        student.setSex("男");
        student.setTime(new Date());
        student.setId(1);


        jedis.set("students".getBytes(),serialize(student));

        byte[] byt=jedis.get("students".getBytes());
        Object obj=unserizlize(byt);
        if(obj instanceof Student){
            System.out.println(obj);
        }

        //list
        jedis.lpush("gd","zq");
        jedis.lpush("gd","gz");

        System.out.println(jedis.lrange("gd",0,10));

        //set
        jedis.sadd("orion","li","li2","chu");

        System.out.println(jedis.smembers("orion"));



        //zset
        jedis.zadd("zsets",3,"first3");
        jedis.zadd("zsets",4,"first4");
        jedis.zadd("zsets",1,"first1");
        jedis.zadd("zsets",2,"first2");

        System.out.println(jedis.zrange("zsets",0,4));

        //hash
        Map<String,String> hm = new HashMap<>();
        hm.put("orion","lily");
        hm.put("li","lichu");
        jedis.hmset("orionlily2",hm);

        System.out.println(jedis.hvals("orionlily2"));*/
    }

    //序列化
    public static byte [] serialize(Object obj){
        ObjectOutputStream obi=null;
        ByteArrayOutputStream bai=null;
        try {
            bai=new ByteArrayOutputStream();
            obi=new ObjectOutputStream(bai);
            obi.writeObject(obj);
            byte[] byt=bai.toByteArray();
            return byt;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //反序列化
    public static Object unserizlize(byte[] byt){
        ObjectInputStream oii=null;
        ByteArrayInputStream bis=null;
        bis=new ByteArrayInputStream(byt);
        try {
            oii=new ObjectInputStream(bis);
            Object obj=oii.readObject();
            return obj;
        } catch (Exception e) {

            e.printStackTrace();
        }


        return null;
    }
}
