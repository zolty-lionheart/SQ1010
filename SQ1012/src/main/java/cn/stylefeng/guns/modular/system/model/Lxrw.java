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
 * @author z
 * @since 2019-08-23
 */
public class Lxrw extends Model<Lxrw> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 创建时间
     */
    private String cjsj;
    /**
     * 任务名称
     */
    private String rwmc;
    /**
     * 状态
     */
    private String zt;
    /**
     * 场景总数
     */
    private String cjzs;
    /**
     * 通过否
     */
    private String tgf;
    /**
     * 通过数
     */
    private String tgs;
    /**
     * 未通过数
     */
    private String wtgs;
    /**
     * 通过率
     */
    private String tgl;
    /**
     * 总结
     */
    private String jg;
    /**
     * 运行时间
     */
    private String yxsj;
    /**
     * 丢包率
     */
    private String dbl;
    /**
     * 误报率
     */
    private String wbl;
    /**
     * 通信延迟
     */
    private String txyc;
    /**
     * 计算能力
     */
    private String jsnl;
    private String ddl5;
    private String ddl6;
    private String ddl7;
    private String ddl8;
    private String ddl9;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCjsj() {
        return cjsj;
    }

    public void setCjsj(String cjsj) {
        this.cjsj = cjsj;
    }

    public String getRwmc() {
        return rwmc;
    }

    public void setRwmc(String rwmc) {
        this.rwmc = rwmc;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getCjzs() {
        return cjzs;
    }

    public void setCjzs(String cjzs) {
        this.cjzs = cjzs;
    }

    public String getTgf() {
        return tgf;
    }

    public void setTgf(String tgf) {
        this.tgf = tgf;
    }

    public String getTgs() {
        return tgs;
    }

    public void setTgs(String tgs) {
        this.tgs = tgs;
    }

    public String getWtgs() {
        return wtgs;
    }

    public void setWtgs(String wtgs) {
        this.wtgs = wtgs;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public String getJg() {
        return jg;
    }

    public void setJg(String jg) {
        this.jg = jg;
    }

    public String getYxsj() {
        return yxsj;
    }

    public void setYxsj(String yxsj) {
        this.yxsj = yxsj;
    }

    public String getDbl() {
        return dbl;
    }

    public void setDbl(String dbl) {
        this.dbl = dbl;
    }

    public String getWbl() {
        return wbl;
    }

    public void setWbl(String wbl) {
        this.wbl = wbl;
    }

    public String getTxyc() {
        return txyc;
    }

    public void setTxyc(String txyc) {
        this.txyc = txyc;
    }

    public String getJsnl() {
        return jsnl;
    }

    public void setJsnl(String jsnl) {
        this.jsnl = jsnl;
    }

    public String getDdl5() {
        return ddl5;
    }

    public void setDdl5(String ddl5) {
        this.ddl5 = ddl5;
    }

    public String getDdl6() {
        return ddl6;
    }

    public void setDdl6(String ddl6) {
        this.ddl6 = ddl6;
    }

    public String getDdl7() {
        return ddl7;
    }

    public void setDdl7(String ddl7) {
        this.ddl7 = ddl7;
    }

    public String getDdl8() {
        return ddl8;
    }

    public void setDdl8(String ddl8) {
        this.ddl8 = ddl8;
    }

    public String getDdl9() {
        return ddl9;
    }

    public void setDdl9(String ddl9) {
        this.ddl9 = ddl9;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Lxrw{" +
        ", id=" + id +
        ", cjsj=" + cjsj +
        ", rwmc=" + rwmc +
        ", zt=" + zt +
        ", cjzs=" + cjzs +
        ", tgf=" + tgf +
        ", tgs=" + tgs +
        ", wtgs=" + wtgs +
        ", tgl=" + tgl +
        ", jg=" + jg +
        ", yxsj=" + yxsj +
        ", dbl=" + dbl +
        ", wbl=" + wbl +
        ", txyc=" + txyc +
        ", jsnl=" + jsnl +
        ", ddl5=" + ddl5 +
        ", ddl6=" + ddl6 +
        ", ddl7=" + ddl7 +
        ", ddl8=" + ddl8 +
        ", ddl9=" + ddl9 +
        "}";
    }
}
