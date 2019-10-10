package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.Lxrw;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author z
 * @since 2019-08-23
 */
public interface LxrwMapper extends BaseMapper<Lxrw> {
    void testReport(@Param("xh") Integer xh);
}
