package com.offcn.user.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
	@Data：提供getter/setter
	@NoArgsConstructor, 无参构造器 @RequiredArgsConstructor   @AllArgsConstructor  全参数构造器
	@EqualsAndHashCode：提供equals和hashCode方法
	@Log：快速的使用slf4j日志
	@Log4j：快速使用log4j日志
	@Log4j2：快速使用log4j2
	@Getter/@Setter
	@Slf4j 内置log对象，直接调用日志方法输出日志
	@ToString
 */

@ApiModel("测试实体")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

 @ApiModelProperty(value = "主键")
 private int id;
 @ApiModelProperty(value = "姓名")
 private String name;
 @ApiModelProperty(value = "电子邮件")
 private String email;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
}
