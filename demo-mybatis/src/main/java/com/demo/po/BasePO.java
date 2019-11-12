package com.demo.po;
import com.demo.annotation.Column;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 说明
 *  @author maikec
 *  @date 2019/11/8
 */
@Data
public abstract class BasePO {
    protected Integer id;
    @Column("create_date")
    protected LocalDateTime createDate;
}
