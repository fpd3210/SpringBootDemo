package com.dpf.cache.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Pikachues
 * Created 2022/5/17
 */
@Data
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = -4061889354222914154L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Integer age;

}
