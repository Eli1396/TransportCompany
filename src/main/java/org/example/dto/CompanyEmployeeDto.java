package org.example.dto;

public class CompanyEmployeeDto {
    private long companyId;

    private String companyName;

    private long employeeId;

    private String employeeName;

    public CompanyEmployeeDto(long companyId, String companyName, long employeeId, String employeeName) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public CompanyEmployeeDto(long companyId, long employeeId) {
        this.companyId = companyId;
        this.employeeId = employeeId;
    }

    public CompanyEmployeeDto(long companyId) {
        this.companyId = companyId;
    }

    public CompanyEmployeeDto(String companyName) {
        this.companyName = companyName;
    }

    public CompanyEmployeeDto(long companyId, String companyName) {
        this.companyId = companyId;
        this.companyName = companyName;
    }

    public long getCompanyId() {
        return companyId;
    }

    @Override
    public String toString() {
        return "CompanyEmployeeDto{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

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
}
