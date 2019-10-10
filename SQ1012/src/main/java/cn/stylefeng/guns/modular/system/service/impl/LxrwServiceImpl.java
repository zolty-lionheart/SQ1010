package cn.stylefeng.guns.modular.system.service.impl;

import cn.stylefeng.guns.modular.system.model.Lxrw;
import cn.stylefeng.guns.modular.system.dao.LxrwMapper;
import cn.stylefeng.guns.modular.system.service.ILxrwService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author z
 * @since 2019-08-23
 */
@Service
public class LxrwServiceImpl extends ServiceImpl<LxrwMapper, Lxrw> implements ILxrwService {
    @Resource
    private LxrwMapper lxrwMapper;
    @Override
    public void testReport(Integer xh) {
        this.lxrwMapper.testReport(xh);
    }
}
