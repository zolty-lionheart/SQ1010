package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.Testlog;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-10-08
 */
public interface TestlogMapper extends BaseMapper<Testlog> {
    List<Map<String, Object>> selecttestlog(@Param("condition") String condition);
}
