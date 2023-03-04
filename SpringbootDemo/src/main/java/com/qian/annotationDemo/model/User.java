package com.qian.annotationDemo.model;

import com.qian.annotationDemo.FieldSensitive;
import com.qian.annotationDemo.SensitiveEnum;

/**
 * @Author: 小小千千
 * @CreateTime: 2023/3/4 15:00
 * @Description:
 */
public class User {

    public User() {
    }

    /**
     * 全参构造函数
     * @param userId
     * @param name
     * @param phone
     */
    public User(String userId, String name, String phone) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
    }

    /**
     * userId
     */
    private String userId;

    /**
     * 姓名
     */
    @FieldSensitive(type = SensitiveEnum.NAME)
    private String name;

    /**
     * 电话
     */
    @FieldSensitive(type = SensitiveEnum.PHONE)
    private String phone;

    /**
     * Gets the value of userId.
     *
     * @return the value of userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the userId.
     * <p>You can use getUserId() to get the value of userId</p>
     *
     * @param userId userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
     * Gets the value of phone.
     *
     * @return the value of phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone.
     * <p>You can use getPhone() to get the value of phone</p>
     *
     * @param phone phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
