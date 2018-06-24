package com.example.heshu.parkmanage.bean;

import java.io.Serializable;

/**
 * Created by heshu on 2018/6/11.
 */

public class ParkBean implements Serializable {

    private String parkName; //停车场名
    private String parkSite; //停车场地址
    private int parkSelling; //停车场收费
    private int parkNum; //车位数目
    private int parkUsableNum; //可用车位数目
    private String parkPhone; //停车场电话
    private String parkImage; // 停车厂图片

    private double dlat; //维度
    private double dlon; //经度

    public double getDlat() {
        return dlat;
    }

    public void setDlat(double dlat) {
        this.dlat = dlat;
    }

    public double getDlon() {
        return dlon;
    }

    public void setDlon(double dlon) {
        this.dlon = dlon;
    }


    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getParkSite() {
        return parkSite;
    }

    public void setParkSite(String parkSite) {
        this.parkSite = parkSite;
    }

    public int getParkSelling() {
        return parkSelling;
    }

    public void setParkSelling(int parkSelling) {
        this.parkSelling = parkSelling;
    }

    public int getParkNum() {
        return parkNum;
    }

    public void setParkNum(int parkNum) {
        this.parkNum = parkNum;
    }

    public int getParkUsableNum() {
        return parkUsableNum;
    }

    public void setParkUsableNum(int parkUsableNum) {
        this.parkUsableNum = parkUsableNum;
    }

    public String getParkPhone() {
        return parkPhone;
    }

    public void setParkPhone(String parkPhone) {
        this.parkPhone = parkPhone;
    }

    public String getParkImage() {
        return parkImage;
    }

    public void setParkImage(String parkImage) {
        this.parkImage = parkImage;
    }
}
