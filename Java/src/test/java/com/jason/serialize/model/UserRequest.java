package com.jason.serialize.model;

import java.io.Serializable;

/**
 * @Author: 小小千千
 * @CreateTime: 2023/8/19 17:36
 * @Description:
 */
public class UserRequest implements Serializable {

    private static final long serialVersionUID = -5567769020560997123L;

    private String name;
    private int age;

    public UserRequest(String name) {
        this.name = name;
    }

    /**
     * Gets the value of name.
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     * <p>You can use getName() to get the value of name</p>
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value of age.
     *
     * @return the value of age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age.
     * <p>You can use getAge() to get the value of age</p>
     *
     * @param age age
     */
    public void setAge(int age) {
        this.age = age;
    }
}
