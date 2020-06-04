package com.kendo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kendone
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate<String, Integer> redisTemplate;

    @RequestMapping("/save")
    public String save(@RequestParam("key") String key, @RequestParam("value") Integer value) {
        redisTemplate.opsForValue().set(key, value);
        return "ok";
    }

    @RequestMapping("/get/{key}")
    public Integer get(@PathVariable("key") String key) {
        return redisTemplate.opsForValue().get(key);
    }

}
