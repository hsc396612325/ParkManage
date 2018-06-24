package com.example.heshu.parkmanage.bean;

import java.io.Serializable;

/**
 * Created by heshu on 2018/6/18.
 */

public class IndentBean implements Serializable {
    private String orderNumber;//订单号
    private int orderMoney;//订单金额
    private int realityMoney;//实际金额
    private ITEM_TYPE mITEM_type;//类型
    private ParkBean parkBean; //车厂
    private String car;// 车辆
    private int parkPlace;//车位

    private String orderDate;
    private String stopDate;
    private String leaveDate;

    public ParkBean getParkBean() {
        return parkBean;
    }

    public void setParkBean(ParkBean parkBean) {
        this.parkBean = parkBean;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStopDate() {
        return stopDate;
    }

    public void setStopDate(String stopDate) {
        this.stopDate = stopDate;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }


    public int getParkPlace() {
        return parkPlace;
    }

    public void setParkPlace(int parkPlace) {
        this.parkPlace = parkPlace;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(int orderMoney) {
        this.orderMoney = orderMoney;
    }

    public int getRealityMoney() {
        return realityMoney;
    }

    public void setRealityMoney(int realityMoney) {
        this.realityMoney = realityMoney;
    }

    public ITEM_TYPE getITEM_type() {
        return mITEM_type;
    }

    public void setITEM_type(ITEM_TYPE ITEM_type) {
        mITEM_type = ITEM_type;
    }



    public static enum ITEM_TYPE {
        ITEM_TYPE_ABOLISH,
        ITEM_TYPE_ORDER,
        ITEM_TYPE_PROCEED,
        ITEM_TYPE_FINISH
    }
}
