package com.heshouyang.entity;

public class Menu {
    private Integer tMenuid;

    private String tMenuname;

    private String tMemudesc;

    public Integer gettMenuid() {
        return tMenuid;
    }

    public void settMenuid(Integer tMenuid) {
        this.tMenuid = tMenuid;
    }

    public String gettMenuname() {
        return tMenuname;
    }

    public void settMenuname(String tMenuname) {
        this.tMenuname = tMenuname == null ? null : tMenuname.trim();
    }

    public String gettMemudesc() {
        return tMemudesc;
    }

    public void settMemudesc(String tMemudesc) {
        this.tMemudesc = tMemudesc == null ? null : tMemudesc.trim();
    }
}