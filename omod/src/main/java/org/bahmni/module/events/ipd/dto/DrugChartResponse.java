package org.bahmni.module.events.ipd.dto;

import java.util.List;

public class DrugChartResponse {
    private String patientUuid;
    private String scheduleUuid;
    private String comment;
    private String startDate;
    private String endDate;
    private String scheduleServiceType;
    private List<DrugChartSlot> drugChartSlotList;

    public String getPatientUuid() {
        return patientUuid;
    }

    public void setPatientUuid(String patientUuid) {
        this.patientUuid = patientUuid;
    }

    public String getScheduleUuid() {
        return scheduleUuid;
    }

    public void setScheduleUuid(String scheduleUuid) {
        this.scheduleUuid = scheduleUuid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getScheduleServiceType() {
        return scheduleServiceType;
    }

    public void setScheduleServiceType(String scheduleServiceType) {
        this.scheduleServiceType = scheduleServiceType;
    }

    public List<DrugChartSlot> getDrugChartSlotList() {
        return drugChartSlotList;
    }

    public void setDrugChartSlotList(List<DrugChartSlot> drugChartSlotList) {
        this.drugChartSlotList = drugChartSlotList;
    }
}
