package com.jason.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @Author: 小小千千
 * @CreateTime: 2023/4/29 08:18
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -5606617662256295246L;

    public User(String name, int gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    private Long uid;
    private String name;
    private int gender;
    private int age;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
