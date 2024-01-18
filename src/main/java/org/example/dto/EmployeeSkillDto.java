package org.example.dto;


public class EmployeeSkillDto {
    private long employeeId;
    private String employeeName;
    private String employeeFamilyName;
    private long skillId;
    private String skillType;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeFamilyName() {
        return employeeFamilyName;
    }

    public void setEmployeeFamilyName(String employeeFamilyName) {
        this.employeeFamilyName = employeeFamilyName;
    }

    public long getSkillId() {
        return skillId;
    }

    public void setSkillId(long skillId) {
        this.skillId = skillId;
    }

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

    @Override
    public String toString() {
        return "EmployeeSkillDto{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeFamilyName='" + employeeFamilyName + '\'' +
                ", skillId=" + skillId +
                ", skillType='" + skillType + '\'' +
                '}';
    }
}
