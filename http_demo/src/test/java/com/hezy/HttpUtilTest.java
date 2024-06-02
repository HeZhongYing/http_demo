package com.hezy;

import cn.hutool.http.HttpUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * 介绍发送Http请求的两种方式
 * @author 10765
 * @create 2024/5/26 19:00
 */
@SpringBootTest
public class HttpUtilTest {

    private final static String APP_ID = "app_id=";

    private final static String APP_SECRET = "app_secret=";

    /**
     * 方式一：通过restTemplate发送Http请求
     */
    @Test
    public void sendHttp() {
        // 创建RestTemplate对象
        RestTemplate restTemplate = new RestTemplate();

        // 请求地址
        String url = "https://www.mxnzp.com/api/idiom/search";

        // 请求参数
        String key = "key=一心一意";

        // 发送请求
        Map result = restTemplate.getForObject(url + "?" + key + "&" + APP_ID + "&" + APP_SECRET, Map.class);

        // 打印结果
        System.out.println(result.get("data"));
    }

    /**
     * 方式二：使用hutool发送Http请求
     */
    @Test
    public void sendHttp2() {
        // 请求地址
        String url = "https://www.mxnzp.com/api/idiom/search";

        // 请求参数
        String key = "key=一心一意";

        // 发送请求
        String result = HttpUtil.get(url + "?" + key + "&" + APP_ID + "&" + APP_SECRET);

        // 打印结果
        System.out.println(result);
    }
}
