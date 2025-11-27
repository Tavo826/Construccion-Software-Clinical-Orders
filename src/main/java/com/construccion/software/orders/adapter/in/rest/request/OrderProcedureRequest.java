package com.construccion.software.orders.adapter.in.rest.request;

public class OrderProcedureRequest {

    private String orderNumber;
    private String patientId;
    private String employeeId;
    private String itemNumber;
    private String procedureName;
    private String repetitionNumber;
    private String repetitionFrequency;
    private String price;
    private boolean requiresSpecialistAssistance;
    private String specialistId;
    private String bloodPressure;
    private String temperature;
    private String pulse;
    private String bloodOxygenLevel;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public String getRepetitionNumber() {
        return repetitionNumber;
    }

    public void setRepetitionNumber(String repetitionNumber) {
        this.repetitionNumber = repetitionNumber;
    }

    public String getRepetitionFrequency() {
        return repetitionFrequency;
    }

    public void setRepetitionFrequency(String repetitionFrequency) {
        this.repetitionFrequency = repetitionFrequency;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isRequiresSpecialistAssistance() {
        return requiresSpecialistAssistance;
    }

    public void setRequiresSpecialistAssistance(boolean requiresSpecialistAssistance) {
        this.requiresSpecialistAssistance = requiresSpecialistAssistance;
    }

    public String getSpecialistId() {
        return specialistId;
    }

    public void setSpecialistId(String specialistId) {
        this.specialistId = specialistId;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPulse() {
        return pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse;
    }

    public String getBloodOxygenLevel() {
        return bloodOxygenLevel;
    }

    public void setBloodOxygenLevel(String bloodOxygenLevel) {
        this.bloodOxygenLevel = bloodOxygenLevel;
    }
}
