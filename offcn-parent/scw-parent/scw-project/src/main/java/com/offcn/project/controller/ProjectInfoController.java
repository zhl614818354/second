package com.offcn.project.controller;

import com.offcn.dycommon.response.AppResponse;
import com.offcn.utils.OssTemplate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "项目基本功能模块（文件上传、项目信息获取等）")
@Slf4j
@RequestMapping("/project")
@RestController
public class ProjectInfoController {

    @Autowired
    private OssTemplate ossTemplate;

    @ApiOperation("文件上传功能")
    @PostMapping("/upload")
    public AppResponse<Map<String, Object>> upload(@RequestParam("file") MultipartFile[] files) throws IOException {
        System.out.println("111");
        Map<String, Object> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        if (files != null && files.length > 0) {
            System.out.println("aaa");
            for (MultipartFile item : files) {
                System.out.println("bbb");
                if (!item.isEmpty()) {
                    System.out.println("ccc:"+item.getOriginalFilename());
                    String upload = ossTemplate.upload(item.getInputStream(), item.getOriginalFilename());
                    list.add(upload);
                }
            }
        }
        map.put("urls", list);
        log.debug("ossTemplate信息：{},文件上传成功访问路径{}", ossTemplate, list);
        return AppResponse.ok(map);
    }
}
