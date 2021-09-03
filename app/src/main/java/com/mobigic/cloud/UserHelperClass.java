package com.mobigic.cloud;

public class UserHelperClass {
    String nam, emai, passwr,phone;
    public  UserHelperClass(){
        //for firebase database
    }

    public UserHelperClass(String nam, String emai, String passwr,String phone) {
        this.nam = nam;
        this.emai = emai;
        this.passwr = passwr;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getEmai() {
        return emai;
    }

    public void setEmai(String emai) {
        this.emai = emai;
    }

    public String getPasswr() {
        return passwr;
    }

    public void setPasswr(String passwr) {
        this.passwr = passwr;
    }
}
