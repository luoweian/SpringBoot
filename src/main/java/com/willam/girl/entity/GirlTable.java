package com.willam.girl.entity;/*
 *Created by William on 2017/11/11 0011
 */

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 自动在数据库建表,Entity
 */

@Entity //对应数据库里的表
@Data
public class GirlTable {

    @Id //PRI Key
    @GeneratedValue //auto_increment
    private Integer id;


    private String cupSize;

    @Min(value = 18, message = "年龄必须大于等于18")
    @NotNull(message = "age 不能为null")
    private Integer age;

    public GirlTable(){}
}
