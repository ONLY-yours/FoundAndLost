package com.example.foundandlost.bean;

/**
 * @auther: lijunjie
 * @createDate: 2020/5/31  19:02
 * @purpose：
 */
public class ItemBean {
    private String name;
    private String time;
    private String describe;
    private int idnumber=0;

    public String getDescribe() {
        return describe;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setIdnumber(int idnumber) {
        this.idnumber = idnumber;
    }

    public int getIdnumber() {
        return idnumber;
    }
}
