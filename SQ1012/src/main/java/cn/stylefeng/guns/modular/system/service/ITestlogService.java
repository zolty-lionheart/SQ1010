package cn.stylefeng.guns.modular.system.service;

import cn.stylefeng.guns.modular.system.model.Testlog;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author stylefeng
 * @since 2019-10-08
 */
public interface ITestlogService extends IService<Testlog> {
    List<Map<String, Object>> selecttestlog(String condition);
}
