package com.nevdia.atta.atta_app.Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Service {
    @SerializedName("id")
@Expose
private String id;
    @SerializedName("maintenanceService_name")
    @Expose
    private String maintenanceServiceName;
    @SerializedName("maintenanceService_phones")
    @Expose
    private String maintenanceServicePhones;
    @SerializedName("maintenanceService_address")
    @Expose
    private String maintenanceServiceAddress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaintenanceServiceName() {
        return maintenanceServiceName;
    }

    public void setMaintenanceServiceName(String maintenanceServiceName) {
        this.maintenanceServiceName = maintenanceServiceName;
    }

    public String getMaintenanceServicePhones() {
        return maintenanceServicePhones;
    }

    public void setMaintenanceServicePhones(String maintenanceServicePhones) {
        this.maintenanceServicePhones = maintenanceServicePhones;
    }

    public String getMaintenanceServiceAddress() {
        return maintenanceServiceAddress;
    }

    public void setMaintenanceServiceAddress(String maintenanceServiceAddress) {
        this.maintenanceServiceAddress = maintenanceServiceAddress;
    }
}
