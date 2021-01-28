package com.offcn.user.controller;

import com.offcn.user.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/*
	@Api(tags="")
	    用在请求的类上，表示对类的说明
	    tags"说明该类的作用，可以在UI界面上看到的注解"

	@ApiOperation(value="")
    	用在请求的方法上，说明方法的用途、作用
    	value="说明方法的用途、作用"

	@ApiImplicitParams
    	用在请求的方法上，表示一组参数说明
   	    @ApiImplicitParam
    	    @ApiImplicitParam:指定一个请求参数的各个方面
    	    value：参数的汉字说明、解释
    	    required：参数是否必须传
    	    paramType：参数放在哪个地方
    	        header –> 请求头的获取：@RequestHeader
    	        query –> 请求参数的获取：@RequestParam
    	        path（用于restful接口）–> 请求路径变量的获取：@PathVariable
            	body（不常用）
               	form（不常用）
        	dataType：参数类型，默认String，其它值dataType="Integer"
        	defaultValue：参数的默认值

   	@ApiResponses
    	用在请求的方法上，表示一组响应
    	@ApiResponse
        	用在@ApiResponses中，一般用于表达一个错误的响应信息
        	code：数字，例如400
        	message：信息，例如"请求参数没填好"
        	response：抛出异常的类

   	@ApiModel
    	主要有两种用途：
    	用于响应类上，表示一个返回响应数据的信息
    	入参实体：使用@RequestBody这样的场景， 请求参数无法使用@ApiImplicitParam注解进行描述的时候

	@ApiModelProperty
    	用在属性上，描述响应类的属性
 */



@Api(tags = "第一个Swagger测试")
@RestController
public class HelloController {
    @ApiOperation("测试方法hello")
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="name",value="姓名",required = true),@ApiImplicitParam(name="age",value="年龄")
    })
    @GetMapping("/hello")
    public String hello(String name){
        return "OK:"+name;
    }

    @ApiOperation("保存用户")
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="name",value="姓名",required = true),@ApiImplicitParam(name="email",value="电子邮件")
    })
    @PostMapping("/user")
    public User save(String name, String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        return user;
    }
}

