package com.dpf.token;

import com.dpf.exception.RepeatSubmitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author Pikachues
 * Created 2022/5/23
 */
@Component
public class TokenService {

    @Autowired
    private RedisService redisService;

    public String getToken(){
        String token = UUID.randomUUID().toString();
        redisService.setEx(token,token,60*60L);
        return token;
    }

    public boolean checkToken(HttpServletRequest request){
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)){
            token = request.getParameter("token");
            if(!StringUtils.hasText(token)){
                throw new RepeatSubmitException("token不存在");
            }
        }

        if(!redisService.exists(token)){
            throw new RepeatSubmitException("重复的操作...");
        }

        boolean remove = redisService.remove(token);
        if(!remove){
            throw new RepeatSubmitException("重复的操作...");
        }
        return true;

    }
}
