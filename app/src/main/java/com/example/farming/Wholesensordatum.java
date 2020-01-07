
package com.example.farming;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wholesensordatum {
    public Wholesensordatum(String id, String moduleId, String nitrogen, String phosphorus, String potassium) {
        this.id = id;
        this.moduleId = moduleId;
        this.nitrogen = nitrogen;
        this.phosphorus = phosphorus;
        this.potassium = potassium;
    }

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("module_id")
    @Expose
    private String moduleId;
    @SerializedName("nitrogen")
    @Expose
    private String nitrogen;
    @SerializedName("phosphorus")
    @Expose
    private String phosphorus;
    @SerializedName("potassium")
    @Expose
    private String potassium;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getNitrogen() {
        return nitrogen;
    }

    public void setNitrogen(String nitrogen) {
        this.nitrogen = nitrogen;
    }

    public String getPhosphorus() {
        return phosphorus;
    }

    public void setPhosphorus(String phosphorus) {
        this.phosphorus = phosphorus;
    }

    public String getPotassium() {
        return potassium;
    }

    public void setPotassium(String potassium) {
        this.potassium = potassium;
    }

}
