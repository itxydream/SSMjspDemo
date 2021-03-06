package com.ssm.domain;

import java.util.Date;

public class Goods {
    private Integer id;

    private String name;

    private Float price;

    private String pic;

    private Date createtime;

    private String detail;

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pic='" + pic + '\'' +
                ", createtime=" + createtime +
                ", detail='" + detail + '\'' +
                '}';
    }

    public Goods(Integer id, String name, Float price, String detail, String pic, Date createtime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.pic = pic;
        this.createtime = createtime;
    }

    public Goods(String name, Float price, String detail) {
        this.name = name;
        this.price = price;
        this.detail = detail;
    }

    public Goods(Integer id, String name, Float price, Date createtime, String detail) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createtime = createtime;
        this.detail = detail;
    }

    public Goods() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}