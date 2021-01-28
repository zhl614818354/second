package com.offcn;

import com.offcn.user.UserStartApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UserStartApplication.class})
public class ScwUserApplicationTest {
    Logger logger = LoggerFactory.getLogger(getClass());  //引入日志文件

    /*
        RedisTemplate和StringRedisTemplate二选一即可:

        RedisTemplate<Object,Object>:k,v都是Object
        StringRedisTemplate：操作String；k-v都可以转成String

        RedisTemplate(可以操作对象)、StringRedisTemplate(建议用这个,将对象转为json字符串对象)
        注意: RedisTemplate和StringRedisTemplate存储的数据之间不能互通！

     */

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void contextLoads(){
        //redisTemplate.opsForValue().set("msg1","欢迎来优就业学习");
        stringRedisTemplate.opsForValue().set("msg","欢迎来优就业学习！");
        logger.debug("操作成功");
    }

}
