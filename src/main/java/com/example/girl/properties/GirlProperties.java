package com.example.girl.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 获取前缀是girl的配置
 */

@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {

    private String  cupSize;

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }
}
