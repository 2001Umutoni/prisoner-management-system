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
public class Prisonner {
    private int prisonnerID;
    private  String prisonnerName;
    private String gender;
    private String dob;
     private String crime;
    private String startdate;
     private String enddate;
      private int cellid;
   
//constructor with no args
    public Prisonner() {
    }
//constructor with args

    public Prisonner(int prisonnerID, String prisonnerName, String gender, String dob, String crime, String startdate, String enddate, int cellid) {
        this.prisonnerID = prisonnerID;
        this.prisonnerName = prisonnerName;
        this.gender = gender;
        this.dob = dob;
        this.crime = crime;
        this.startdate = startdate;
        this.enddate = enddate;
        this.cellid = cellid;
    }

    public int getPrisonnerID() {
        return prisonnerID;
    }

    public void setPrisonnerID(int prisonnerID) {
        this.prisonnerID = prisonnerID;
    }

    public String getPrisonnerName() {
        return prisonnerName;
    }

    public void setPrisonnerName(String prisonnerName) {
        this.prisonnerName = prisonnerName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public int getCellid() {
        return cellid;
    }

    public void setCellid(int cellid) {
        this.cellid = cellid;
    }
    
}