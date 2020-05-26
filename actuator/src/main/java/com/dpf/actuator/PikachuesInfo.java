package com.dpf.actuator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author dpf
 * @create 2020-05-26 15:59
 * @email 446933040@qq.com
 * java方式配置info基本信息
 */
@Component
public class PikachuesInfo implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        HashMap<Object, Object> info = new HashMap<>();
        info.put("name","runn");
        info.put("email","pikachues@qq.com");
        builder.withDetail("author",info);
    }
}
