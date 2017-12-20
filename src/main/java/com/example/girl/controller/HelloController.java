package com.example.girl.controller;

import com.example.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @RestController == @Controller+@ResponseBody组合
 */

@RestController
public class HelloController {

//    /**通过注解将配置文件里面的cupSize写到属性里 */
//    @Value("${cupSize}")
//    private String cupSize;
//
//    @Value("${age}")
//    private Integer age;
//
//    @Value("${content}")
//    private String content;

    @Autowired
    private GirlProperties girlProperties;

    /** value={"/string","/string",...} 映射多个 */
    /** 获取url中的id值*/
//    @RequestMapping(value = {"/hello/{id}", "/hi/{id}"}, method = RequestMethod.GET)
//    public String say(@PathVariable("id") Integer id){
//        return "id:" + id;
//        return girlProperties.getCupSize();
//    }

    /** 获取url中?id= 的值get and post 都可以 */
//    @RequestMapping(value = {"/hello", "/hi"}, method = RequestMethod.GET)
//    等同于下面的写法
    @GetMapping(value = {"/hello", "/hi"})
    /**@RequestParam(value = "id", required = false, defaultValue = "0")可以不传值，默认为0 @RequestParam("id")这种写法不传id值就报错 */
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0" ) Integer id){
        return "id:" + id;
//        return girlProperties.getCupSize();
    }


}
