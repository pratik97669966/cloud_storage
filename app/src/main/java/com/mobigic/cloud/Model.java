package com.mobigic.cloud;

import com.google.firebase.database.Exclude;

public class Model {
    private  String imageUrl;
    public  String mkey;
    public Model() {

    }
    public Model(String imageUrl){
        this.imageUrl=imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Exclude
    public String getMkey() {
        return mkey;
    }
@Exclude
    public void setMkey(String mkey) {
        this.mkey = mkey;
    }
}
