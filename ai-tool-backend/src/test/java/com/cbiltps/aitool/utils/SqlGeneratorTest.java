package com.cbiltps.aitool.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.cbiltps.aitool.common.ErrorCode;
import com.cbiltps.aitool.exception.ThrowUtils;
import com.cbiltps.aitool.model.entity.App;
import com.cbiltps.aitool.model.enums.AppTypeEnum;
import com.cbiltps.aitool.service.AppService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: lichengxiang
 * Date: 2025-05-15
 * Time: 12:15
 */
@SpringBootTest
public class SqlGeneratorTest {
    @Resource
    private AppService appService;

    @Test
    public void test() {
        // JSON 文件路径
        String jsonFilePath = "/Users/lichengxiang/Documents/Working/SCAI/Data/output.json";
        // 读取 JSON 文件内容
        String jsonContent = FileUtil.readString(jsonFilePath, "UTF-8");
        // 解析 JSON 数组内容
        JSONArray jsonArray = JSONUtil.parseArray(jsonContent);
        // 遍历 JSON 数组并输出每个 JSON 对象
        for (Object obj1 : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj1;

            // 获取 JSON 对象中的 title 字段值
            String appType = jsonObject.getStr("title");
            // 获取 JSON 对象中的 list 字段值
            JSONArray appListArray = jsonObject.getJSONArray("list");

            // 遍历 list 数组
            for (Object obj2 : appListArray) {
                // 将 list 数组中的每个元素转换为 JSON 对象
                JSONObject appListObject = (JSONObject) obj2;
                // 创建 App 对象
                App app = new App();
                // 设置 App 对象的 appType 属性
                app.setAppType(AppTypeEnum.getValueByName(appType));
                // 设置 App 对象的 appLink 属性
                app.setAppLink(appListObject.getStr("url"));
                // 设置 App 对象的 appName 属性
                app.setAppName(appListObject.getStr("h_title"));
                // 设置 App 对象的 appDesc 属性
                app.setAppDesc(appListObject.getStr("text"));
                // 设置 App 对象的 appIcon 属性
                String imageurl = appListObject.getStr("imageurl");
                String newString = imageurl.replace("./iconsimage", "https://www.cda.cn/static/aitools");
                app.setAppIcon(newString);
                // 设置 App 对象的 userId 属性, 建议从数据库获取, 或直接填写
//                app.setUserId();
                // 写入数据库
                boolean result = appService.save(app);
                ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
            }
        }
    }
}