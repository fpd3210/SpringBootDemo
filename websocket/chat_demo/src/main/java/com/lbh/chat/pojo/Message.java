package com.lbh.chat.pojo;

import lombok.Data;

/**
 * @Author hong
 * @Date 19-10-17
 */
@Data
public class Message {
    private String fromName;
    private String toName;
    private String content;
}
