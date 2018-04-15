package com.ucmed.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 用户类
 * @Author: daifeifei
 * @CreateDate: 2018/4/11 0:59
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private String userName;
    private int age;
    private String sex;
}
