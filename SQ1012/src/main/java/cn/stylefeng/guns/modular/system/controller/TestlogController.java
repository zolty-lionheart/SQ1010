package cn.stylefeng.guns.modular.system.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Testlog;
import cn.stylefeng.guns.modular.system.service.ITestlogService;

import java.util.List;
import java.util.Map;

/**
 * 测试详情控制器
 *
 * @author fengshuonan
 * @Date 2019-10-08 13:55:07
 */
@Controller
@RequestMapping("/testlog")
public class TestlogController extends BaseController {

    private String PREFIX = "/system/testlog/";

    @Autowired
    private ITestlogService testlogService;

    /**
     * 跳转到测试详情首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "testlog.html";
    }

    /**
     * 跳转到添加测试详情
     */
    @RequestMapping("/testlog_add")
    public String testlogAdd() {
        return PREFIX + "testlog_add.html";
    }

    /**
     * 跳转到修改测试详情
     */
    @RequestMapping("/testlog_update/{testlogId}")
    public String testlogUpdate(@PathVariable Integer testlogId, Model model) {
        Testlog testlog = testlogService.selectById(testlogId);
        model.addAttribute("item",testlog);
        LogObjectHolder.me().set(testlog);
        return PREFIX + "testlog_edit.html";
    }

    /**
     * 获取测试详情列表
     */
    @RequestMapping(value = "/list/{condition}")
    @ResponseBody
    public Object list(@PathVariable String condition) {
        List<Map<String,Object>> selecttestlog = this.testlogService.selecttestlog(condition);
        return selecttestlog;
    }

    /**
     * 新增测试详情
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Testlog testlog) {
        testlogService.insert(testlog);
        return SUCCESS_TIP;
    }

    /**
     * 删除测试详情
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer testlogId) {
        testlogService.deleteById(testlogId);
        return SUCCESS_TIP;
    }

    /**
     * 修改测试详情
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Testlog testlog) {
        testlogService.updateById(testlog);
        return SUCCESS_TIP;
    }

    /**
     * 测试详情详情
     */
    @RequestMapping(value = "/detail/{testlogId}")
    @ResponseBody
    public Object detail(@PathVariable("testlogId") Integer testlogId) {
        return testlogService.selectById(testlogId);
    }
}
