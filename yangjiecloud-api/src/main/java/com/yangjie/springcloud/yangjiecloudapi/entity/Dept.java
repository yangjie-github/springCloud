package com.yangjie.springcloud.yangjiecloudapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author yangjie
 * 2019/8/4 11:47
 *
 * 注意： 使用lombok,需要在idea安装lombok插件, 需要在设置项里面设置Annotation Processing打钩
 */
//全参的构造函数
@AllArgsConstructor
//空参的构造函数
@NoArgsConstructor
//set get
@Data
//链式风格
@Accessors(chain = true)
public class Dept implements Serializable {

    private String id;
    private String name;

    /*测试lombok*/
    public static void main(String[] args) {
        Dept dept = new Dept();
        dept.setId("id").setName("name");
    }
}
