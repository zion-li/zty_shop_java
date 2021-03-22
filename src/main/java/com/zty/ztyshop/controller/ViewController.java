package com.zty.ztyshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 所有页面跳转都写在这
 * SpringBoot项目下的templates目录的资源默认是受保护的，没有开放访问权限。
 * 这是因为templates文件夹，是放置模板文件的，因此需要视图解析器来解析它。
 * 所以必须通过服务器内部进行访问，也就是要走控制器 → 服务 → 视图解析器这个流程才行。
 * 同时，存在安全问题，比如说，你把你后台的html文件放到templates，而这个文件夹对外又是开放的，
 * 就会存在安全隐患。
 *
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/3/21 15:59
 */
@Controller
public class ViewController {

    /**
     * 首页
     *
     * @param mv
     * @return
     */
    @RequestMapping(value = "/index")
    public ModelAndView test(ModelAndView mv) {
        mv.setViewName("index");
        return mv;
    }

}
