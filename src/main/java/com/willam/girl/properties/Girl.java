package com.willam.girl.properties;/*
 *Created by William on 2017/11/11 0011
 */

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "girl")   //加载.yml文件属性
@Component  //加@Autowired必备
@Getter
@Setter
public class Girl {

    private String cupSize1;
    private Integer age;

}
