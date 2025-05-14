package com.cbiltps.aitool.model.dto.app;

import lombok.Data;

import java.io.Serializable;

/**
 * 创建应用请求
 *
 * @author 
 * @from 
 */
@Data
public class AppAddRequest implements Serializable {

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
     * 应用类型
     */
    private Integer appType;

    /**
     * 应用链接
     */
    private String appLink;

    private static final long serialVersionUID = 1L;
}