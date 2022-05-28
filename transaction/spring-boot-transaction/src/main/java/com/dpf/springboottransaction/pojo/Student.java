package com.dpf.springboottransaction.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Pikachues
 * Created 2022/5/26
 */
@Entity(name = "t_student")
@Data
public class Student {


    @Id  //主键
    @GeneratedValue  //自增
    private long id;
    @Column(nullable = false, unique = true)  //定制列
    private String userName;
}
