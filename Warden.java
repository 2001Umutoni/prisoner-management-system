/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author HP
 */
public class Warden {
    private int wardenid;
    private String fullname;
    private String position;
    private  String password;
    private String dob;
    private  String starttime;
    private String endtime;

    public Warden() {
    }

    public Warden(int wardenid, String fullname, String position, String password, String dob, String starttime, String endtime) {
        this.wardenid = wardenid;
        this.fullname = fullname;
        this.position = position;
        this.password = password;
        this.dob = dob;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public int getWardenid() {
        return wardenid;
    }

    public void setWardenid(int wardenid) {
        this.wardenid = wardenid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    
    
    
}
