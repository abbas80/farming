package com.example.farming;

public class past_npk_model {
    int sno;
    String past_n;
    String past_p;
    String past_k;
    String date;

    public past_npk_model(int sno, String past_n, String past_p, String past_k, String date) {

        this.sno = sno;
        this.past_n = past_n;
        this.past_p = past_p;
        this.past_k = past_k;
        this.date = date;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getPast_n() {
        return past_n;
    }

    public void setPast_n(String past_n) {
        this.past_n = past_n;
    }

    public String getPast_p() {
        return past_p;
    }

    public void setPast_p(String past_p) {
        this.past_p = past_p;
    }

    public String getPast_k() {
        return past_k;
    }

    public void setPast_k(String past_k) {
        this.past_k = past_k;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
