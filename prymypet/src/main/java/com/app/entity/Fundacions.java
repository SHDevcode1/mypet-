package com.app.entity;

import java.util.ArrayList;
import java.util.List;

public class Fundacions {
    private List<Fundacion> fundacionList;
    
    public List<Fundacion> getFundacionList() {
        if(fundacionList == null) {
            fundacionList = new ArrayList<>();
        }
        return fundacionList;
    }
 
    public void setFundacionList(List<Fundacion> fundacionList) {
        this.fundacionList = fundacionList;
    }
}
