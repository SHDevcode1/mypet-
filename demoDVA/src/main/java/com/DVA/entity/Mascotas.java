package com.DVA.entity;

import java.util.ArrayList;
import java.util.List;

public class Mascotas {
	
private List<Mascota> mascotaList;
    
    public List<Mascota> getMascotasList() {
        if(mascotaList == null) {
            mascotaList = new ArrayList<>();
        }
        return mascotaList;
    }
 
    public void setMascotasList(List<Mascota> mascotaList) {
        this.mascotaList = mascotaList;
    }

}
