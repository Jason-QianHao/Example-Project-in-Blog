package com.jason.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: 小小千千
 * @CreateTime: 2023/5/7 18:24
 * @Description:
 */
public class TbOrder implements Serializable {

    private static final long serialVersionUID = -3573710087400159229L;

    /**
     * id
     */
    private Long id;
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 购买数量
     */
    private Integer number;
    /**
     * 创建时间
     */
    private Date createTime;
}
