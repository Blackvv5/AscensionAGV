package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class UserController {


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

    /**
     * 发送最新无人车坐标
     * @param userid 老人的编号
     * @param ip 无人车的ip地址
     * @return  待定
     * @throws IOException 抛出异常
     */
    @RequestMapping(value="/api/agv/coordinates",method = RequestMethod.GET)
    @ResponseBody
    public String coordinatesAgv(int userid,int x,int y,int ip) throws IOException {
        if (userid != 0000){
            return "invalid data";
        }
        return "successfully";
    }

    /**
     * 发送编码后的户型图字符串
     * @param userid 老人的编号
     * @param imageEncoded  户型图字符串
     * @param ip  无人车ip地址
     * @return 待定
     * @throws IOException 抛出异常
     */
    @RequestMapping(value="/api/agv/apartmentRendering",method = RequestMethod.GET)
    @ResponseBody
    public String apartmentRenderingAgv(int userid,int imageEncoded,int ip) throws IOException {
        if (userid != 0000){
            return "invalid data";
        }
        return "successfully";
    }

    /**
     *
     * @param userid 老人的编号
     * @param state  老人的状态
     * @param ip  无人车的ip地址
     * @return  待定
     * @throws IOException 抛出异常
     */
    @RequestMapping(value="/api/agv/state",method = RequestMethod.GET)
    @ResponseBody
    public String stateAgv(int userid,int state,int ip) throws IOException {
        if (userid != 0000){
            return "invalid data";
        }
        return "successfully";
    }

    /**
     * 发送编码后的老人照片字符串
     * @param userid 老人的编号
     * @param imageEncoded 照片编码后
     * @param ip  无人车的ip地址
     * @return 待定
     * @throws IOException  抛出异常
     */
    @RequestMapping(value="/api/agv/shot",method = RequestMethod.GET)
    @ResponseBody
    public String shotAgv(int userid,int imageEncoded,int ip) throws IOException {
        if (userid != 0000){
            return "invalid data";
        }
        return "successfully";
    }

    /**
     * 小程序获取无人车的最新坐标
     * @param userid  老人的编号
     * @return  待定
     * @throws IOException  抛出异常
     */
    @RequestMapping(value="/api/miniprograms/coordinates",method = RequestMethod.GET)
    @ResponseBody
    public String coordinatesMini(int userid) throws IOException {
        if (userid != 0000){
            return "invalid data";
        }
        return "successfully";
    }

    /**
     * 小程序获取最新户型图
     * @param userid  老人的编号
     * @return  待定
     * @throws IOException  抛出异常
     */
    @RequestMapping(value="/api/miniprograms/apartmentRendering",method = RequestMethod.GET)
    @ResponseBody
    public String apartmentRenderingMini(int userid) throws IOException {
        if (userid != 0000){
            return "invalid data";
        }
        return "successfully";
    }

    /**
     * 获取无人车拍摄的图片（摔倒后）
     * @param userid  老人的编号
     * @return 待定
     * @throws IOException 抛出异常
     */
    @RequestMapping(value="/api/miniprograms/fell",method = RequestMethod.GET)
    @ResponseBody
    public String fellMini(int userid) throws IOException {
        if (userid != 0000){
            return "invalid data";
        }
        return "successfully";
    }

    /**
     * 状态确认：火灾、户外摔倒（搁置）、室内摔倒
     * @param userid  老人的编号
     * @return 待定
     * @throws IOException  抛出异常
     */
    @RequestMapping(value="/api/miniprograms/state",method = RequestMethod.GET)
    @ResponseBody
    public String stateMini(int userid) throws IOException {
        if (userid != 0000){
            return "invalid data";
        }
        return "successfully";
    }

    /**
     * 获取数据更新时间
     * @param userid 老人的编号
     * @return 待定
     * @throws IOException 抛出异常
     */
    @RequestMapping(value="/api/miniprograms/updateTime",method = RequestMethod.GET)
    @ResponseBody
    public String updateTime(int userid) throws IOException {
        if (userid != 0000){
            return "invalid data";
        }
        return "successfully";
    }













}
