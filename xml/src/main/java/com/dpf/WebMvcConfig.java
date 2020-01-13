package com.dpf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 加载xml配置
 *
 * @author dpf
 * @create 2020-01-04 23:44
 * @email 446933040@qq.com
 */
@Configuration
@ImportResource(locations = "classpath:beans.xml")
public class WebMvcConfig {
}
