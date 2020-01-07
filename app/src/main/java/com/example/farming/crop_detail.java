package com.example.farming;

public class crop_detail {
    double crop_nitrogen;
    double crop_phosphorus;
    double crop_potassium;
    double temp_min;
    double temp_max;
    double rainfall_min;
    double rainfall_max;

    public crop_detail(double crop_nitrogen, double crop_phosphorus, double crop_potassium, double temp_min, double temp_max, double rainfall_min, double rainfall_max) {
        this.crop_nitrogen = crop_nitrogen;
        this.crop_phosphorus = crop_phosphorus;
        this.crop_potassium = crop_potassium;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.rainfall_min = rainfall_min;
        this.rainfall_max = rainfall_max;
    }

    public double getCrop_nitrogen() {
        return crop_nitrogen;
    }

    public void setCrop_nitrogen(double crop_nitrogen) {
        this.crop_nitrogen = crop_nitrogen;
    }

    public double getCrop_phosphorus() {
        return crop_phosphorus;
    }

    public void setCrop_phosphorus(double crop_phosphorus) {
        this.crop_phosphorus = crop_phosphorus;
    }

    public double getCrop_potassium() {
        return crop_potassium;
    }

    public void setCrop_potassium(double crop_potassium) {
        this.crop_potassium = crop_potassium;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    public double getRainfall_min() {
        return rainfall_min;
    }

    public void setRainfall_min(double rainfall_min) {
        this.rainfall_min = rainfall_min;
    }

    public double getRainfall_max() {
        return rainfall_max;
    }

    public void setRainfall_max(double rainfall_max) {
        this.rainfall_max = rainfall_max;
    }
}
