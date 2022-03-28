package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


/**
 * @author 10908
 */
@Controller

public class UserController {

    User p = new User();
    Returning r = new Returning();
    ArrayList<User> users = new ArrayList<>();

    /**
     * 发送最新无人车坐标
     *
     * @param userid 老人的编号
     * @param ip     无人车的ip地址
     * @return 待定
     * @throws IOException 抛出异常
     */
    @RequestMapping(value = "/api/agv/coordinates", method = RequestMethod.GET)
    @ResponseBody
    public Returning coordinatesAgv(int userid, int x, int y, int ip) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //1、日期转字符串
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String dateStringParse = sdf.format(date);

        p.setId(userid);
        users.add(p);
        User pp;
        for (int i = 0; i < users.size(); i++) {
            pp = users.get(i);
            if (pp.getId() == userid) {
                pp.setX(x);
                pp.setY(y);
                pp.setIp(ip);
                pp.setLocationTime(dateStringParse);
                users.set(i, pp);
                r.setState("ok.");
                r.setMassage("received.");
                return r;
            }
        }
        return r;
    }

    /**
     * 发送编码后的户型图字符串
     *
     * @param userid       老人的编号
     * @param imageEncoded 户型图字符串
     * @param ip           无人车ip地址
     * @return 待定
     * @throws IOException 抛出异常
     */
    @RequestMapping(value = "/api/agv/apartmentRendering", method = RequestMethod.GET)
    @ResponseBody
    public Returning apartmentRenderingAgv(int userid, int imageEncoded, int ip) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //1、日期转字符串
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String dateStringParse = sdf.format(date);

        User pp;
        for (int i = 0; i < users.size(); i++) {
            pp = users.get(i);
            if (pp.getId() == userid) {
                pp.setHouseImageEncoded(imageEncoded);
                pp.setIp(ip);
                pp.setHouseImageTime(dateStringParse);
                users.set(i, pp);
                r.setState("ok.");
                r.setMassage("received and decoded successfully.");
                return r;
            }
        }
        r.setState("ok.");
        r.setMassage("received and decoded failed.");
        return r;
    }

    /**
     * @param userid 老人的编号
     * @param state  老人的状态
     * @param ip     无人车的ip地址
     * @return 待定
     * @throws IOException 抛出异常
     */
    @RequestMapping(value = "/api/agv/state", method = RequestMethod.GET)
    @ResponseBody
    public Returning stateAgv(int userid, int state, int ip) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //1、日期转字符串
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String dateStringParse = sdf.format(date);


        User pp;
        for (int i = 0; i < users.size(); i++) {
            pp = users.get(i);
            if (pp.getId() == userid) {
                pp.setState(state);
                pp.setIp(ip);
                pp.setStateTime(dateStringParse);
                users.set(i, pp);
                r.setState("ok.");
                r.setMassage("received");
                return r;
            }
        }
        r.setState("ok.");
        r.setMassage("invalid data");
        return r;
    }

    /**
     * 发送编码后的老人照片字符串
     *
     * @param userid       老人的编号
     * @param imageEncoded 照片编码后
     * @param ip           无人车的ip地址
     * @return 待定
     * @throws IOException 抛出异常
     */
    @RequestMapping(value = "/api/agv/shot", method = RequestMethod.GET)
    @ResponseBody
    public Returning shotAgv(int userid, int imageEncoded, int ip) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //1、日期转字符串
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String dateStringParse = sdf.format(date);

        User pp;
        for (int i = 0; i < users.size(); i++) {
            pp = users.get(i);
            if (pp.getId() == userid) {
                pp.setFellImageEncoded(imageEncoded);
                pp.setIp(ip);
                pp.setShotTime(dateStringParse);
                users.set(i, pp);
                r.setState("ok.");
                r.setMassage("received and decoded successfully.");
                return r;
            }
        }
        r.setState("ok.");
        r.setMassage("received and decoded failed.");
        return r;
    }

    /**
     * 小程序获取无人车的最新坐标
     *
     * @param userid 老人的编号
     * @return 待定
     * @throws IOException 抛出异常
     */

    @RequestMapping(value = "/api/miniprograms/coordinates", method = RequestMethod.GET)
    @ResponseBody
    public coordinatesMini1 coordinatesMini(int userid) throws IOException {
        coordinatesMini1 x = new coordinatesMini1();
        User pp;
        for (int i = 0; i < users.size(); i++) {
            pp = users.get(i);
            if (pp.getId() == userid) {
                x.setX(pp.getX());
                x.setY(pp.getY());
                x.setTime(pp.getLocationTime());
                return x;
            }
        }
        return x;
    }

    /**
     * 小程序获取最新户型图
     *
     * @param userid 老人的编号
     * @return 待定
     * @throws IOException 抛出异常
     */
    @RequestMapping(value = "/api/miniprograms/apartmentRendering", method = RequestMethod.GET)
    @ResponseBody
    public apartmentRenderingMini1 apartmentRenderingMini(int userid) throws IOException {
        apartmentRenderingMini1 x = new apartmentRenderingMini1();
        User pp;
        for (int i = 0; i < users.size(); i++) {
            pp = users.get(i);
            if (pp.getId() == userid) {
                x.setHouseImageEncoded(pp.getHouseImageEncoded());
                x.setTime(pp.getHouseImageTime());
                return x;
            }
        }
        return x;
    }

    /**
     * 获取无人车拍摄的图片（摔倒后）
     *
     * @param userid 老人的编号
     * @return 待定
     * @throws IOException 抛出异常
     */
    @RequestMapping(value = "/api/miniprograms/fell", method = RequestMethod.GET)
    @ResponseBody
    public fellMini1 fellMini(int userid) throws IOException {
        fellMini1 x = new fellMini1();
        User pp;
        for (int i = 0; i < users.size(); i++) {
            pp = users.get(i);
            if (pp.getId() == userid) {
                x.setFellImageEncoded(pp.getFellImageEncoded());
                x.setTime(pp.getShotTime());
                return x;
            }
        }
        return x;
    }

    /**
     * 状态确认：火灾、户外摔倒（搁置）、室内摔倒
     *
     * @param userid 老人的编号
     * @return 待定
     * @throws IOException 抛出异常
     */
    @RequestMapping(value = "/api/miniprograms/state", method = RequestMethod.GET)
    @ResponseBody
    public stateMini1 stateMini(int userid) throws IOException {
        stateMini1 x = new stateMini1();
        User pp;
        for (int i = 0; i < users.size(); i++) {
            pp = users.get(i);
            if (pp.getId() == userid) {
                x.setState(pp.getState());
                x.setTime(pp.getStateTime());
                return x;
            }
        }
        return x;
    }
}
