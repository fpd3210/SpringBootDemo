package com.dpf.cache.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Pikachues
 * Created 2022/5/17
 */
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Integer age;

}
