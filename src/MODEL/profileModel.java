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
public class profileModel {
    private String mahoso;
    private String fullname;
    private int CCCD;
    private String address;
    private String dayin;
    private String dayout;
    private int salary;

    public profileModel(String mahoso, String fullname, int CCCD, String address, String dayin, String dayout, int salary) {
        this.mahoso = mahoso;
        this.fullname = fullname;
        this.CCCD = CCCD;
        this.address = address;
        this.dayin = dayin;
        this.dayout = dayout;
        this.salary = salary;
    }

    public profileModel() {
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

    public int getCCCD() {
        return CCCD;
    }

    public void setCCCD(int CCCD) {
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
}
