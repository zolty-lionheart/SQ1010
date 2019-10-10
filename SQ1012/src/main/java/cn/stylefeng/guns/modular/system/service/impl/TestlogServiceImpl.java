package cn.stylefeng.guns.modular.system.service.impl;

import cn.stylefeng.guns.modular.system.model.Testlog;
import cn.stylefeng.guns.modular.system.dao.TestlogMapper;
import cn.stylefeng.guns.modular.system.service.ITestlogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2019-10-08
 */
@Service
public class TestlogServiceImpl extends ServiceImpl<TestlogMapper, Testlog> implements ITestlogService {
    @Override
    public List<Map<String, Object>> selecttestlog(String condition) {
        return this.baseMapper.selecttestlog(condition);
    }

}
