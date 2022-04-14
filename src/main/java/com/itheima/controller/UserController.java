package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.io.BufferedReader;
// import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;


/**
 * @author 10908
 */
@Controller
@ResponseBody
public class UserController {

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    @ResponseBody
    public void test1() throws IOException {
        File oldName = new File("F:\\GithubRepo\\AscensionAGV\\src\\main\\java\\com\\itheima\\controller\\1.jpg");
        File newName = new File("F:\\GithubRepo\\AscensionAGV\\src\\main\\webapp\\img\\1.jpg");
        if(newName.exists()){
            newName.delete();
        }
        //System.out.println(oldName.renameTo(newName));//true
        oldName.renameTo(newName);
    }

//    @RequestMapping(value = "/test2", method = RequestMethod.GET)
//    @ResponseBody
//    public ModelAndView test2() throws IOException {
//            ModelAndView modelAndView = new ModelAndView();
//            modelAndView.setViewName("1");
//            return modelAndView;
//    }



    User p = new User();
    Returning r = new Returning();
    ArrayList<User> users = new ArrayList<>();
    String token = "asd";

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    @ResponseBody
    public String test2() throws IOException {
        return token;
    }

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
    public Returning coordinatesAgv(int userid, double x, double y, String ip) throws IOException {
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

     * @return 待定
     * @throws IOException 抛出异常
     */
    @RequestMapping(value = "/api/agv/apartmentRendering", method = RequestMethod.POST)
    @ResponseBody
    public Returning apartmentRenderingAgv(@RequestBody Map<String, Object> map) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //1、日期转字符串
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String dateStringParse = sdf.format(date);

        int userid = (int)map.get("userid");
        String imageEncoded = (String)map.get("imageEncoded");
        String ip = (String)map.get("ip");

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
    public Returning stateAgv(int userid, int state, String ip) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //1、日期转字符串
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String dateStringParse = sdf.format(date);

        String s="";

        User pp;
        for (int i = 0; i < users.size(); i++) {
            pp = users.get(i);
            if (pp.getId() == userid) {
                pp.setState(state);
                pp.setIp(ip);
                pp.setStateTime(dateStringParse);

                if(state==2){
                    get_Token(s);
                    pp.setToken(token);
                }

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

     * @return 待定
     * @throws IOException 抛出异常
     */
    @RequestMapping(value = "/api/agv/shot", method = RequestMethod.POST)
    @ResponseBody
    public Returning shotAgv(@RequestBody Map<String, Object> map) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //1、日期转字符串
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String dateStringParse = sdf.format(date);

        int userid = (int)map.get("userid");
        String imageEncoded = (String)map.get("imageEncoded");
        String ip = (String)map.get("ip");


        //这里解码
        String imageDecoded = picdecode(imageEncoded);

        User pp;
        for (int i = 0; i < users.size(); i++) {
            pp = users.get(i);
            if (pp.getId() == userid) {
                pp.setFellImageEncoded(imageDecoded);
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
                x.setimageUrl("/img/map.png");
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
                x.setimageFellUrl("/img/shot.png");
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


    /**
     * 获取变化的 access_token
     * @throws IOException
     */
    @PostMapping(value = "https:/api.weixin.qq.com/cgi-bin/token? grant_type=client_credential&appid=wx4872d0a989dff417&secret=e820823d842546ec479ac02ecbbccf83")
    @ResponseBody
    public void get_Token(@RequestBody String access_token) throws IOException {
        System.out.println(access_token);
        token = access_token;
        System.out.println(token);
    }



    public static String picdecode(String PicBefore) {

        Process proc;
        String res = null;
        try {
            proc = Runtime.getRuntime().exec("python D:\\demo1.py");// 执行py文件
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            res = null;
            while ((line = in.readLine()) != null) {
                // System.out.println(line);//打印输出结果
                res = res + line;
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return res;
    }
}
