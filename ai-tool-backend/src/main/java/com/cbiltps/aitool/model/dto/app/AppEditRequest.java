package com.cbiltps.aitool.model.dto.app;

import lombok.Data;

import java.io.Serializable;

/**
 * 编辑应用请求
 *
 * @author 
 * @from 
 */
@Data
public class AppEditRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 应用名
     */
    private String appName;

    /**
     * 应用描述
     */
    private String appDesc;

    /**
     * 应用图标
     */
    private String appIcon;

    /**
     * 应用类型（0-得分类，1-测评类）
     */
    private Integer appType;

    private static final long serialVersionUID = 1L;
}