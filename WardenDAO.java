/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.Prisonner;
import Model.Warden;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author HP
 */
public class WardenDAO {
     private final String db_url = "jdbc:mysql://localhost:3306/prison_management_system_db";
    private final String username = "root";
    private final String password = "atessy02";
    
     public String createWardenPrepared(Warden wardenrObj) {
        try (Connection con = DriverManager.getConnection(db_url, username, password)) {
            String sql = "INSERT INTO warden(wardenID, fullName, position, password, DateOfBirth, ShiftStartTime, ShiftEndTime) VALUES ( ?, ?, ?, ?, ?, ?,?)";
            
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setInt(1, wardenrObj.getWardenid());
                pst.setString(2, wardenrObj.getFullname());
                 pst.setString(3, wardenrObj.getPosition());
                pst.setString(4, wardenrObj.getPassword());
                pst.setString(5, wardenrObj.getDob());
                pst.setString(6,wardenrObj.getStarttime());
                pst.setString(7,wardenrObj.getEndtime());
                

                int rowAffected = pst.executeUpdate();

                if (rowAffected >= 1) {
                    return " successfully saved!";
                } else {
                    return " not successfully saved!";
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "Server Error";
        }
    }
       public Warden searchWarden(Warden wardenObj) {
    try {
        Connection con = DriverManager.getConnection(db_url, username, password);
        String sql = "SELECT * FROM warden WHERE wardenID=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, wardenObj.getWardenid());
        ResultSet result = pst.executeQuery();

        Warden thewarden = new Warden();
        boolean flag = false;

        while (result.next()) {
           
           thewarden.setWardenid(result.getInt("wardenID"));
            thewarden.setFullname(result.getString("fullName"));
          thewarden.setPosition(result.getString("position"));
            thewarden.setPassword(result.getString("password"));
            thewarden.setDob(result.getString("DateOfBirth"));
            thewarden.setStarttime(result.getString("ShiftStartTime"));
            thewarden.setEndtime(result.getString("ShiftEndTime"));
           

            flag = true;
        }

        con.close();

        if (flag) {
            return thewarden;
        }

    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return null;
}public String updateWardenPrepared(Warden wardenrObj) {
       try (Connection con = DriverManager.getConnection(db_url, username, password)) {
        String sql = "UPDATE warden SET fullName=?, position=?, password=?, DateOfBirth=?, ShiftStartTime=?, ShiftEndTime=? WHERE wardenID=?";
        
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, wardenrObj.getFullname());
            pst.setString(2, wardenrObj.getPosition());
            pst.setString(3, wardenrObj.getPassword());
            pst.setString(4, wardenrObj.getDob());
            pst.setString(5, wardenrObj.getStarttime());
            pst.setString(6, wardenrObj.getEndtime());
            pst.setInt(7, wardenrObj.getWardenid());

            int rowAffected = pst.executeUpdate();

            if (rowAffected >= 1) {
                return "Successfully updated!";
            } else {
                return "Not successfully updated!";
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        return "Server Error";
    }
        }
public String deleteWardenPrepared(Warden wardenObj) {
        try (Connection con = DriverManager.getConnection(db_url, username, password)) {
            String sql = "DELETE FROM warden WHERE wardenID=?";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setInt(1, wardenObj.getWardenid());

                int rowAffected = pst.executeUpdate();

                if (rowAffected >= 1) {
                    return "Warden successfully deleted!";
                } else {
                    return "Warden not deleted!";
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "Server Error";
        }
    }

    public List<Warden> getAllWardens() {
        List<Warden> wardens = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(db_url, username, password)) {
            String sql = "SELECT * FROM warden";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                ResultSet result = pst.executeQuery();

                while (result.next()) {
                    Warden warden = new Warden();
                    warden.setWardenid(result.getInt("wardenID"));
                    warden.setFullname(result.getString("fullName"));
                    warden.setPosition(result.getString("position"));
                    warden.setPassword(result.getString("password"));
                    warden.setDob(result.getString("DateOfBirth"));
                    warden.setStarttime(result.getString("ShiftStartTime"));
                    warden.setEndtime(result.getString("ShiftEndTime"));

                    wardens.add(warden);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return wardens;
    }
}

   
    

