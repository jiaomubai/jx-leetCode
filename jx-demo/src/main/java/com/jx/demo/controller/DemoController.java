package com.jx.demo.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.UUID;

/**
 * @author jiaoxian
 * @name com.jx.demo.controller
 * @date 2022/12/2 16:33
 * @description 测试接口
 */

@RestController
public class DemoController {

    @GetMapping("hello")
    public String sayHello() {
        String data = null;
        try {
            data = getDataByType("");
        } catch (IOException ioException) {
            System.out.println("获取文件内容异常");
        }
        System.out.println("data = " + data);
        return data;
    }

    private String getDataByType(String type) throws IOException {
        String data = null;
        String filePath = null;
        if (StringUtils.isEmpty(type)) {
            filePath = "D:\\project\\myself\\jx-leetCode\\jx-demo\\src\\main\\resources\\file\\langfang.txt";
        }
        InputStream is = new FileInputStream(filePath);
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = in.readLine()) != null){
            buffer.append(line);
        }
        data = buffer.toString();
        return data;
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
    }


}
