package com.dpf;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author dpf
 * @create 2020-01-05 17:19
 * @email 446933040@qq.com
 */
@Component
@Order(100)
public class MyApplicationRunner02 implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        String[] sourceArgs = args.getSourceArgs();//获取启动的所有参数
        System.out.println("sourceArgs:" + Arrays.toString(sourceArgs));

        List<String> nonOptionArgs = args.getNonOptionArgs(); //获取无key参数
        System.out.println("nonOptionArgs:" + nonOptionArgs);


        Set<String> optionNames = args.getOptionNames();  //获取有key参数
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
        for (String optionName : optionNames) {
            System.out.println(optionName + ":" + args.getOptionValues(optionName));
        }
        System.out.println(">>>>>>>>>>>>>>>MyApplicationRunner02结束>>>>>>>>>>>>>>>>");
    }
}
