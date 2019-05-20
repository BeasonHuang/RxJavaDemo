package com.hb.rxjavademo.model;

/**
 * @author huangbiao
 * @data 2019 2019-05-18 13:00
 */
public class OperatorModel {
    private String info;

    public OperatorModel(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "OperatorModel{" +
                "info='" + info + '\'' +
                '}';
    }
}
