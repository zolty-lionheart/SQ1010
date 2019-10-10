package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author stylefeng
 * @since 2019-10-08
 */
public class Testlog extends Model<Testlog> {

    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 任务名称
     */
    private String rwmc;
    /**
     * 用例名
     */
    private String scenario;
    /**
     * 通过否
     */
    private Integer tgf;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRwmc() {
        return rwmc;
    }

    public void setRwmc(String rwmc) {
        this.rwmc = rwmc;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public Integer getTgf() {
        return tgf;
    }

    public void setTgf(Integer tgf) {
        this.tgf = tgf;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Testlog{" +
        ", id=" + id +
        ", rwmc=" + rwmc +
        ", scenario=" + scenario +
        ", tgf=" + tgf +
        "}";
    }
}
