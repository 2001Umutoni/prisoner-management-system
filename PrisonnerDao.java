package DAO;

import Model.Prisonner;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PrisonnerDao {
    private final String db_url = "jdbc:mysql://localhost:3306/prison_management_system_db";
    private final String username = "root";
    private final String password = "atessy02";

    /// create function
    public String createPrisonnerPrepared(Prisonner prisonnerObj) {
        try (Connection con = DriverManager.getConnection(db_url, username, password)) {
            String sql = "INSERT INTO Inmate(prisonerid, fullname, gender, DateOfBirth, CrimeDetails, SentenceStartDate, SentenceEndDate, CellID) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
            
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setInt(1, prisonnerObj.getPrisonnerID());
                pst.setString(2, prisonnerObj.getPrisonnerName());
                 pst.setString(3, prisonnerObj.getGender());
                pst.setString(4, prisonnerObj.getDob());
                pst.setString(5, prisonnerObj.getCrime());
                pst.setString(6, prisonnerObj.getStartdate());
                pst.setString(7, prisonnerObj.getEnddate());
                pst.setInt(8, prisonnerObj.getCellid());

                int rowAffected = pst.executeUpdate();

                if (rowAffected >= 1) {
                    return "Inmate successfully saved!";
                } else {
                    return "Inamate not successfully saved!";
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "Server Error";
        }
    }
    public String updatePrisonnerPrepared(Prisonner prisonnerObj) {
       
       
         try (Connection con = DriverManager.getConnection(db_url, username, password)) {
            String sql = "UPDATE Inmate SET fullname=?, gender=?, DateOfBirth=?, CrimeDetails=?, SentenceStartDate=?, SentenceEndDate=?,CellID=? WHERE prisonerid=?";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, prisonnerObj.getPrisonnerName());
            pst.setString(2, prisonnerObj.getGender());
            pst.setString(3, prisonnerObj.getDob());
            pst.setString(4, prisonnerObj.getCrime());
            pst.setString(5, prisonnerObj.getStartdate());
            pst.setString(6, prisonnerObj.getEnddate());
            pst.setInt(7, prisonnerObj.getCellid());
            pst.setInt(8, prisonnerObj.getPrisonnerID());

                int rowAffected = pst.executeUpdate();

                if (rowAffected >= 1) {
                    return "Inmate successfully updated!";
                } else {
                    return "Inmate not updated!";
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "Server Error";
        }
         
    }
   //view function
       public List<Prisonner> allprisonner() {
        try {
            Connection con = DriverManager.getConnection(db_url, username, password);
            String sql = "SELECT * FROM Inmate";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                try (ResultSet result = pst.executeQuery()) {
                    List<Prisonner> prisonnerlist = new ArrayList<>();
                    while (result.next()) {
                        Prisonner theprisonner = new Prisonner();
                        theprisonner.setPrisonnerID(result.getInt("prisonerid"));
                        theprisonner.setPrisonnerName(result.getString("fullname"));
                        theprisonner.setGender(result.getString("gender"));
                         theprisonner.setCrime(result.getString("CrimeDetails"));
                        theprisonner.setDob(result.getString("DateOfBirth"));
                        theprisonner.setStartdate(result.getString("SentenceStartDate"));
                        theprisonner.setEnddate(result.getString("SentenceEndDate"));
                        theprisonner.setCellid(result.getInt("CellID"));
                        prisonnerlist.add(theprisonner);
                    }
                    return prisonnerlist;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
       }
        public Prisonner searchPrisoner(Prisonner prisonnerObj) {
    try {
        Connection con = DriverManager.getConnection(db_url, username, password);
        String sql = "SELECT * FROM Inmate WHERE prisonerid=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, prisonnerObj.getPrisonnerID());
        ResultSet result = pst.executeQuery();

        Prisonner thePrisonner = new Prisonner();
        boolean flag = false;

        while (result.next()) {
           
            thePrisonner.setPrisonnerID(result.getInt("prisonerid"));
            thePrisonner.setPrisonnerName(result.getString("fullname"));
            thePrisonner.setGender(result.getString("gender"));
            thePrisonner.setCrime(result.getString("CrimeDetails"));
            thePrisonner.setDob(result.getString("DateOfBirth"));
            thePrisonner.setStartdate(result.getString("SentenceStartDate"));
            thePrisonner.setEnddate(result.getString("SentenceEndDate"));
            thePrisonner.setCellid(result.getInt("CellID"));

            flag = true;
        }

        con.close();

        if (flag) {
            return thePrisonner;
        }

    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return null;
}

         public String deletePrisonnerPrepared(Prisonner prisonnerObj) {
       
       
         try (Connection con = DriverManager.getConnection(db_url, username, password)) {
            String sql = "delete from Inmate where prisonerid=?";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setInt(1, prisonnerObj.getPrisonnerID());
               

                int rowAffected = pst.executeUpdate();

                if (rowAffected >= 1) {
                    return "Inmate successfully deleted!";
                } else {
                    return "Inmate not deleted!";
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "Server Error";
        }
         
    }
    }


            
            
       
        
 

    
