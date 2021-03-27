package com.zty.ztyshop.dao.entity;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
/**
 * <p>
 * 
 * </p>
 *
 * @author 李佳 zion
 * @since 2021-03-27
 */
public class ClientLevel extends Model<ClientLevel> {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 区间最小值（包含）
     */
    private Integer min;

    /**
     * 区间最大值（不包含)
     */
    private Integer max;

    /**
     * 级别名称
     */
    private String name;

    /**
     * 创建时间
     */
    private LocalDateTime creteAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreteAt() {
        return creteAt;
    }

    public void setCreteAt(LocalDateTime creteAt) {
        this.creteAt = creteAt;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "ClientLevel{" +
        ", id=" + id +
        ", min=" + min +
        ", max=" + max +
        ", name=" + name +
        ", creteAt=" + creteAt +
        "}";
    }
}
