package com.dpf.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dpf
 * @create 2020-01-05 20:33
 * @email 446933040@qq.com
 */
@Component
public class DateConverter implements Converter<String, Date> {

     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date convert(String s) {
        if(s != null && !"".equals(s)){
            try {
                Date parse = null;
                parse = sdf.parse(s);
                return parse;
            } catch (ParseException e) {
                }

        }
        return null;
    }
}
