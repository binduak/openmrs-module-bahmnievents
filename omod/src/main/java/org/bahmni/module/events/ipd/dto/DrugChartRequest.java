package org.bahmni.module.events.ipd.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DrugChartRequest {
    private String patientUuid;

    private String orderUuid;

    private List<Date> slots = new ArrayList<>();

    private String providerUuid;


    public String getOrderUuid() {
        return orderUuid;
    }

    public void setOrderUuid(String orderUuid) {
        this.orderUuid = orderUuid;
    }


    public String getPatientUuid() {
        return patientUuid;
    }

    public void setPatientUuid(String patientUuid) {
        this.patientUuid = patientUuid;
    }

    public List<Date> getSlots() {
        return slots;
    }

    public void setSlots(List<Date> slots) {
        this.slots = slots;
    }

    public String getProviderUuid() {
        return providerUuid;
    }

    public void setProviderUuid(String providerUuid) {
        this.providerUuid = providerUuid;
    }
}
