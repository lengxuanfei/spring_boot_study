package com.dff.util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description: Constants
 * @Author: daifeifei
 * @CreateDate: 2018/4/11 2:07
 */
@Component
@Data
public class Constants {
    @Value("${com.app.name}")
    private String name;
    public static String title;

    @Value("${com.app.title}")
    public void setTitle(String title) {
        Constants.title = title;
    }
}
