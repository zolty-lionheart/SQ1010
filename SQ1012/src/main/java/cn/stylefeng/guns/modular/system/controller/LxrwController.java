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
import cn.stylefeng.guns.modular.system.model.Lxrw;
import cn.stylefeng.guns.modular.system.service.ILxrwService;

/**
 * 例行任务控制器
 *
 * @author fengshuonan
 * @Date 2019-08-23 14:48:19
 */
@Controller
@RequestMapping("/lxrw")
public class LxrwController extends BaseController {

    private String PREFIX = "/system/lxrw/";

    @Autowired
    private ILxrwService lxrwService;

    /**
     * 跳转到例行任务首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "lxrw.html";
    }

    /**
     * 跳转到添加例行任务
     */
    @RequestMapping("/lxrw_add")
    public String lxrwAdd() {
        return PREFIX + "lxrw_add.html";
    }

    /**
     * 跳转到修改例行任务
     */
    @RequestMapping("/lxrw_update/{lxrwId}")
    public String lxrwUpdate(@PathVariable Integer lxrwId, Model model) {
        Lxrw lxrw = lxrwService.selectById(lxrwId);
        model.addAttribute("item",lxrw);
        LogObjectHolder.me().set(lxrw);
        return PREFIX + "lxrw_edit.html";
    }
    /**
     * 跳转到例行任务
     */
    @RequestMapping("/lxrw_update2/{lxrwId}")
    public String lxrwUpdate2(@PathVariable Integer lxrwId, Model model) {
        Lxrw lxrw = lxrwService.selectById(lxrwId);
        model.addAttribute("item",lxrw);
        LogObjectHolder.me().set(lxrw);
        return PREFIX + "lxrw_detail.html";
    }
    /**
     * 获取例行任务列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return lxrwService.selectList(null);
    }

    /**
     * 新增例行任务
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Lxrw lxrw) {
        lxrwService.insert(lxrw);
        return SUCCESS_TIP;
    }

    /**
     * 删除例行任务
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer lxrwId) {
        lxrwService.deleteById(lxrwId);
        return SUCCESS_TIP;
    }

    /**
     * 生成测试报告
     */
    @RequestMapping(value = "/testReport/{lxrwId}")
    @ResponseBody
    public Object testReport(@PathVariable("lxrwId") Integer lxrwId) {
        lxrwService.testReport(lxrwId);
        return SUCCESS_TIP;
    }

    /**
     * 修改例行任务
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Lxrw lxrw) {
        lxrwService.updateById(lxrw);
        return SUCCESS_TIP;
    }

    /**
     * 例行任务详情
     */
    @RequestMapping(value = "/detail/{lxrwId}")
    @ResponseBody
    public Object detail(@PathVariable("lxrwId") Integer lxrwId) {
        return lxrwService.selectById(lxrwId);
    }
}
