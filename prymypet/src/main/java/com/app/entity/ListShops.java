package com.app.entity;
 
import java.util.ArrayList;
import java.util.List;

public class ListShops 
{
    private List<Shop> shopList;
    
    public List<Shop> getShopList() {
        if(shopList == null) {
            shopList = new ArrayList<>();
        }
        return shopList;
     }
 
    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
     }
}