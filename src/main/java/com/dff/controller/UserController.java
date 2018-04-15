package com.dff.controller;

import com.dff.util.Constants;
import com.ucmed.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 用户登录
 * @Author: daifeifei
 * @CreateDate: 2018/4/8 23:49
 */
//@RestController
@Api(value = "用户操作", tags = {"用户操作接口"})
@RequestMapping("/user")
@Controller
public class UserController {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private Constants constants;

    @GetMapping("/")
    public String index(ModelMap map) {
        map.put("title", "spring boot welcome");
        return "index";
    }

    @ResponseBody
    @GetMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @ResponseBody
    @GetMapping("/getUser")
    public User getUser() {
        User user =  new User("张三", 24, "男");
        logger.info("获取到用户信息 : " + user.toString());
        return user;
    }

    @ResponseBody
    @ApiOperation(value = "创建用户信息", notes = "注意增加唯一判断")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "age", value = "年龄", required = true, dataType = "int"),
            @ApiImplicitParam(name = "sex", value = "性别。男、女、未知", required = true, dataType = "String")
    })
    @PostMapping("/postUser")
    public User postUser(@RequestParam String name, @RequestParam Integer age, @RequestParam String sex) {
        User user =  new User(name, age, sex);
        return user;
    }

    @ResponseBody
    @GetMapping("getConfig")
    public String getConfig() {
        return String.format("name: %s, title: %s", constants.getName(), Constants.title);
    }

    @ResponseBody
    @GetMapping("lambda")
    public List<Integer> lambda() {
        List<String> list = Arrays.asList("1", "2", "3", "4", "1", "3", "2", "4");
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 1, 3, 2, 4);
        List<String> distinct =  list.stream().distinct().collect(Collectors.toList());
        IntSummaryStatistics statistics = list.stream().mapToInt(i -> Integer.parseInt(i)).summaryStatistics();
        System.out.println("最大值 ：" + statistics.getMax());
        System.out.println("Sumary : " + list.stream().mapToInt(i -> Integer.parseInt(i)).
                reduce((sum, i) -> sum + i).getAsInt());
        List<Integer> distinct2 = list.stream().map(i -> Integer.parseInt(i)).filter(i -> i < 3).collect(Collectors.toList());
        return distinct2;
    }

    @GetMapping("/exception")
    public String exception() throws Exception {
        throw new Exception("网络请求失败");
    }

    @ResponseBody
    @GetMapping("/exceptionRest")
    public String exceptionRest() throws Exception {
        throw new Exception("网络请求失败");
    }
}
