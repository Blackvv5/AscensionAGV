package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;

@Controller
//@RequestMapping("/user")
public class UserController {

    // 这里为什么是 8080？教程里的，我没改注释，这里只是注释
    // 请求地址  http://localhostzhser/quick你确定，你的Java是运行中的？上海翱翔i后向好像是……

//你确定怕rams是这么写的，老师这么教的欸，我看着觉得好奇怪，引号直接用逗号隔开各个参数？那我去百度一个

    @RequestMapping(value="/api/coordinates",method = RequestMethod.GET,params = {"userid=1", "time=2022"})
    @ResponseBody
    public ArrayList<User> test1() throws IOException {

        ArrayList<User> users = new ArrayList<>();
        User user1 = new User();
        user1.name = "ZhangSan";
        user1.age = 15;
        users.add(user1);
        return users;
    }

    @RequestMapping(value="/api/coordinates",method = RequestMethod.GET,params = {"userid=2","time=2023"})
    @ResponseBody
    public ArrayList<User> test2() throws IOException {

        ArrayList<User> users = new ArrayList<User>();
        User user1 = new User();
        user1.name = "LiSi";
        user1.age = 16;
        users.add(user1);
        return users;
    }

    @RequestMapping(value="/api/coordinates",method = RequestMethod.GET,params = {"userid=2","time=2024"})
    @ResponseBody
    public User controller1() throws IOException {

        User user1 = new User();
        user1.name = "LiSi";
        user1.age = 16;
        return user1;
    }

    @RequestMapping(value="/api/coordinates",method = RequestMethod.GET,params = {"userid=3","time=2025"})
    @ResponseBody
    public User controller2() throws IOException {

        User user1 = new User();
        user1.name = "ZhangSan";
        user1.age = 26;
        return user1;
    }

    @RequestMapping(value="/test",method = RequestMethod.GET)
    @ResponseBody
    public int controller3(int username,int age) throws IOException {
        if(username == 15 && age == 15){
            return 2;
        }else if(username == 12 && age == 14){
            return 3;
        }else{
            return 4;
        }
    }

     // ok
//    今天晚上差不多就这样，然后我简单说说其他的（
//    我先试一下 One dark 和你的背景会不会冲突
//            好像不冲突，我感觉 one dark 好看一点？
//
//    然后我简单讲讲快捷键
//    有两个很重要的快捷键（1）行删除（2）代码格式化，你自己可以设置一下快捷键，我分别设置的 CTRL+D，和 CTRL+L
//
//    然后你留意一下这个插件
    //前两个不变，你把这一个，修改为，如果不满足上面两种，就返回 error

//    @RequestMapping(value="/api/coordinates",method = RequestMethod.GET,params = {})
//    @ResponseBody
//    public String save4() throws IOException {
//        return "error.";
//    }

//    @RequestMapping(value="/api/coordinates",method = RequestMethod.GET,params = {"userid!=3","time!=2025"})
//    @ResponseBody
//    public String save5() throws IOException {
//        return "error.";
//    }





}
