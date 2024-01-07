package org.example.dto;



public class VehicleDto {
    private String type;
    private String capacityUnit;
    private float capacity;

    public VehicleDto(String type, String capacityUnit, float capacity) {
        this.type = type;
        this.capacityUnit = capacityUnit;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCapacityUnit() {
        return capacityUnit;
    }

    public void setCapacityUnit(String capacityUnit) {
        this.capacityUnit = capacityUnit;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }
}
