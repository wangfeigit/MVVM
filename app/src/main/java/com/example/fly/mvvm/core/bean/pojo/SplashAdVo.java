package com.example.fly.mvvm.core.bean.pojo;

import com.example.fly.mvvm.core.bean.pojo.image.ImageInfoVo;

import java.io.Serializable;

public class SplashAdVo extends BaseVo {
    public Data data;

    public static class Data implements Serializable {
        public String desc;

        public String jumpurl;

        public String expiredate;

        public String status;

        public String ctime;

        public String pageid;

        public String startdate;

        public ImageInfoVo imginfo;
    }

}
