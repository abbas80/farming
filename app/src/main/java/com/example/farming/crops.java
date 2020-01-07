package com.example.farming;

public class crops {
    String crop_name;
    crop_detail crop_detail;

    public crops(String crop_name, com.example.farming.crop_detail crop_detail) {
        this.crop_name = crop_name;
        this.crop_detail = crop_detail;
    }

    public String getCrop_name() {
        return crop_name;
    }

    public void setCrop_name(String crop_name) {
        this.crop_name = crop_name;
    }

    public com.example.farming.crop_detail getCrop_detail() {
        return crop_detail;
    }

    public void setCrop_detail(com.example.farming.crop_detail crop_detail) {
        this.crop_detail = crop_detail;
    }
}
