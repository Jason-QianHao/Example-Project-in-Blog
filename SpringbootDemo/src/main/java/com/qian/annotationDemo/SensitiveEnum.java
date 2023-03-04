package com.qian.annotationDemo;

/**
 * @Author: 小小千千
 * @CreateTime: 2023/3/4 14:06
 * @Description:
 */
public enum SensitiveEnum {

    /** 自定义（此项需设置脱敏的范围）*/
    CUSTOMER("customer"),

    /** 姓名 */
    NAME("name"),

    /** 身份证号 */
    ID_NO("idNo"),

    /** 手机号 */
    PHONE("phone"),

    /** 邮箱 */
    EMAIL("email");

    private String name;

    SensitiveEnum(String name){
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
}
