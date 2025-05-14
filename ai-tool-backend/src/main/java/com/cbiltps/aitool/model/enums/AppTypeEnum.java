package com.cbiltps.aitool.model.enums;

import cn.hutool.core.util.ObjectUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * App 应用类型枚举
 *
 * @author 
 * @from 
 */
public enum AppTypeEnum {
    VIDEO("AI视频工具", 13),
    MODEL("AI训练模型", 12),
    FRAMEWORK("AI开发框架", 11),
    LEARNING("AI学习网站", 10),
    PROMPT("AI提示指令", 9),
    CONTENT_DETECTION("AI内容检测", 8),
    OFFICE("AI办公工具", 7),
    CHAT("AI对话聊天", 6),
    CODING("AI编程工具", 5),
    DESIGN("AI设计工具", 4),
    AUDIO("AI音频工具", 3),
    IMAGE("AI图像工具", 2),
    WRITING("AI写作工具", 1),
    POPULAR("AI热门网址", 0);

    private final String text;

    private final int value;

    AppTypeEnum(String text, int value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 根据 value 获取枚举
     *
     * @param value
     * @return
     */
    public static AppTypeEnum getEnumByValue(Integer value) {
        if (ObjectUtil.isEmpty(value)) {
            return null;
        }
        for (AppTypeEnum anEnum : AppTypeEnum.values()) {
            if (anEnum.value == value) {
                return anEnum;
            }
        }
        return null;
    }

    /**
     * 获取值列表
     *
     * @return
     */
    public static List<Integer> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
