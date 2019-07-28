package com.atguigu.springcloud.entity;

/**
 * @author zzl
 * @date 2019/7/14 0014- 15:08
 **/
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author zzl
 * @date 2019/7/14 0014- 13:58
 **/

@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Dept implements Serializable {//entity orm 类表关系映射

    private Long deptno;
    private String dname;
    private String db_source;//数据来源 微服多

    public Dept(String dname) {
        this.dname = dname;
    }


}
