package com.bawei.ckenbost.bean;

/**
 * Created by 1 on 2017/3/22.
 */
public class ShopBean
{
    private String title;
    private int price;
    private int count;
    private boolean boo;

    public ShopBean(String title, int price, int count) {
        this.title = title;
        this.price = price;
        this.count = count;
    }

    public ShopBean() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isBoo() {
        return boo;
    }

    public void setBoo(boolean boo) {
        this.boo = boo;
    }

    @Override
    public String toString() {
        return "ShopBean{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", boo=" + boo +
                '}';
    }
}
