package com.wharf.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/4/24.
 */
@Component
@ConfigurationProperties(value = "config")
public class Config {

    private String img_drive;
    private String http_img_url;

    /**
     * 上传图片的盘符
     * @return
     */
    public String getImg_drive() {
        return img_drive;
    }

    public void setImg_drive(String img_drive) {
        this.img_drive = img_drive;
    }

    public String getHttp_img_url() {
        return http_img_url;
    }

    public void setHttp_img_url(String http_img_url) {
        this.http_img_url = http_img_url;
    }
}
