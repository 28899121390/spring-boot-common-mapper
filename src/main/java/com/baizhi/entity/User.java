package com.baizhi.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sm_user")
public class User implements Serializable {
    @Id
    @KeySql(sql = "select sm_user_seq.nextval from dual", order = ORDER.BEFORE)
    private Integer id;
    @Column(name ="username")
    private String name;
    private Integer userAge;
    @Transient
    private String  status;
    private Address address;
    public User(String name, Integer userAge) {
        this.name = name;
        this.userAge = userAge;
    }
}
