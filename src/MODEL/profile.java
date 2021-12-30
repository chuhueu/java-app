/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author chuhu
 */
public class profile {
    private String mahoso;
    private String fullname;
    private String CCCD;
    private String address;
    private String dayin;
    private String dayout;
    private String salary;

    public profile(String mahoso, String fullname, String CCCD, String address, String dayin, String dayout, String salary) {
        this.mahoso = mahoso;
        this.fullname = fullname;
        this.CCCD = CCCD;
        this.address = address;
        this.dayin = dayin;
        this.dayout = dayout;
        this.salary = salary;
    }

    public profile() {
    }

    public String getMahoso() {
        return mahoso;
    }

    public void setMahoso(String mahoso) {
        this.mahoso = mahoso;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDayin() {
        return dayin;
    }

    public void setDayin(String dayin) {
        this.dayin = dayin;
    }

    public String getDayout() {
        return dayout;
    }

    public void setDayout(String dayout) {
        this.dayout = dayout;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
    
}
