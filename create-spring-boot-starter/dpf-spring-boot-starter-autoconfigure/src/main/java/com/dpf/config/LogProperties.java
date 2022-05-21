package com.dpf.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Pikachues
 * Created 2022/5/21
 */
@ConfigurationProperties(prefix = "com.dpf")
@Component
public class LogProperties {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
