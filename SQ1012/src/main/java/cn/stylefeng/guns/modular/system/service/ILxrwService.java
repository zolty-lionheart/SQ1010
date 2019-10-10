package cn.stylefeng.guns.modular.system.service;

import cn.stylefeng.guns.modular.system.model.Lxrw;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author z
 * @since 2019-08-23
 */
public interface ILxrwService extends IService<Lxrw> {
    void testReport(@Param("xh") Integer xh);
}
