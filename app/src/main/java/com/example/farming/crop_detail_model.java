package com.example.farming;

public class crop_detail_model {
    int type;
    int icon;
    String crop_name;
    String n_value;
    String p_value;
    String k_value;
    public static final int ze=0;
    public static final int on=1;
    boolean isexpandable=false;

    public crop_detail_model(int type, int icon, String crop_name, String n_value, String p_value, String k_value) {
        this.type = type;
        this.icon = icon;
        this.crop_name = crop_name;
        this.n_value = n_value;
        this.p_value = p_value;
        this.k_value = k_value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getCrop_name() {
        return crop_name;
    }

    public void setCrop_name(String crop_name) {
        this.crop_name = crop_name;
    }

    public String getN_value() {
        return n_value;
    }

    public void setN_value(String n_value) {
        this.n_value = n_value;
    }

    public String getP_value() {
        return p_value;
    }

    public void setP_value(String p_value) {
        this.p_value = p_value;
    }

    public String getK_value() {
        return k_value;
    }

    public void setK_value(String k_value) {
        this.k_value = k_value;
    }

    public boolean isIsexpandable() {
        return isexpandable;
    }

    public void setIsexpandable(boolean isexpandable) {
        this.isexpandable = isexpandable;
    }
}
