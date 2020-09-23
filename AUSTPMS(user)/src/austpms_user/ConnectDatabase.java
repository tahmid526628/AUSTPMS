/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package austpms_user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Tahmid
 */
public class ConnectDatabase {

    /**
     * @return the guestVehicleType
     */
    public String getGuestVehicleType() {
        return guestVehicleType;
    }

     /**
     * @return the slotNumber
     */
    public String getSlotNumber() {
        return slotNumber;
    }
    
    /**
     * @return the parkingStatus
     */
    public String getParkingStatus() {
        return parkingStatus;
    }

    /**
     * @return the vehicleType
     */
    public String getVehicleType() {
        return vehicleType;
    }

    /**
     * @return the vehicleNumber
     */
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public String getCountVehicle() {
        return countVehicle;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @return the profession
     */
    public String getProfession() {
        return profession;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }
    
    
    
    public String getGuestName() {
        return guestName;
    }

    public String getGuestSlotNum() {
        return guestSlotNum;
    }

    public String getGuestMobile() {
        return guestMobile;
    }

    /**
     * @return the photo
     */
    public byte[] getPhoto() {
        return photo;
    }
    public Connection connection;
    public Statement statement1;
    public Statement statement2;
    
    /******************************personal variables**************************/
    private String id;
    private String firstName;
    private String lastName;
    private String mobile;
    private String profession;
    private String department;
    private byte[] photo;
    
    private String countVehicle;
    private String vehicleType;
    private String vehicleNumber;
    /*****************************personal variables***************************/
   
    /***************************variables for parking**************************/
    private String parkingStatus;  
    private String slotNumber;
    /***************************variables for parking**************************/
    
    /* =========================Guest parking========================== */
    private String guestName;
    private String guestSlotNum;
    private String guestMobile;
    private String guestVehicleType;
    
    
    
    
    public void ConnectDB(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433; databaseName=AUSTPMS;selectMethod=cursor", "sa", "12345");                       
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public void CloseDB(){
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void retrieveDataNewVehicle(String id){
        try{
            statement1 = connection.createStatement();
            ResultSet resultSet2 = statement1.executeQuery("select P.ID, P.FirstName, P.LastName, P.Profession, P.Department, P.Photo,"
                    + "V.VehicleNumber, V.VehicleType from Person P inner join Vehicle V on P.ID = V.ID where P.ID = '"
                    + id + "'");
            
           while(resultSet2.next()){
               this.id = resultSet2.getString("ID");
               firstName = resultSet2.getString("FirstName");
               lastName = resultSet2.getString("LastName");
               profession = resultSet2.getString("Profession");
               department = resultSet2.getString("Department");
               photo = resultSet2.getBytes("Photo");
               
               vehicleType = resultSet2.getString("VehicleType");
               vehicleNumber = resultSet2.getString("VehicleNumber");
                             
               System.out.println("CustomerName: " + resultSet2.getString("FirstName")); // example of as
            }
           resultSet2 = statement1.executeQuery("select count(*) as count from Vehicle where ID = '" + id + "'");
           while(resultSet2.next()){
               countVehicle = resultSet2.getString("count");
               //System.out.println("Number: " + resultSet2.getString("count"));
           }
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Not Found");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void retrieveParkingData(String id){
        try{
            statement2 = connection.createStatement();
            ResultSet resultSet = statement2.executeQuery("select * from Parking where ID = '" + id + "'");
            //String nameT = null;
            while(resultSet.next()){
                //nameT  = resultSet.getString("Name");
                //parkingStatus = "Yes";
                parkingStatus = resultSet.getString("ParkingStatus");
                slotNumber = resultSet.getString("SlotNumber");
                if(parkingStatus.equals("Yes")){
                    break;
                }
            }
            if(parkingStatus == null){
                parkingStatus = "No";
            }
            
            //System.out.println(nameT);            
            // for getting null value if nothing in table, we have to print name outside the while loop.
            // if inside and no value in table, then it will print nothing.
        }catch(NullPointerException e){
            System.out.println("Not found");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void storeParkingData(String parkingDate, String parkingTime, String id, String name, String profession, String vehicleType,
            String vehicleNum, String parkingStatus, String slotNumber){
        try{
            String query = "insert into Parking(ParkingDate, ParkingTime, ID, Name, Profession, VehicleType, VehicleNumber, ParkingStatus, SlotNumber) "
                    + "values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
            
            pst.setString(1, parkingDate);
            pst.setString(2, parkingTime);
            pst.setString(3, id);
            pst.setString(4, name);
            pst.setString(5, profession);
            pst.setString(6, vehicleType);
            pst.setString(7, vehicleNum);
            pst.setString(8, parkingStatus);
            pst.setString(9, slotNumber);
            
            pst.executeUpdate();
            pst.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void updateParkingData(String status, String id, String exitTime){
        try{
            String query = "update Parking set ParkingStatus = '" + status + "', ExitTime='"+ exitTime + "' where ID = '" + id + "' and ParkingStatus='Yes'";
            PreparedStatement pst = connection.prepareStatement(query);
            
            pst.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean retrieveParkingToStart(String slotNum){
        boolean fieldState = false;
        try{
            
            Statement statement3 = connection.createStatement();
            ResultSet resultSet = statement3.executeQuery("select * from Parking where SlotNumber = '" + slotNum + "' and ParkingStatus = 'Yes'");
            while(resultSet.next()){
//                parkingStatus = resultSet.getString("ParkingStatus");
                fieldState = true;
            }           
        }catch(NullPointerException e){
            System.out.println("Not found");
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println(fieldState);
        return fieldState;
    }
    
    
    /* =====================Guest parking===============================*/
    public boolean retrieveGuestsParkingToStart(String slotNum){
        boolean fieldState = false;
        try{
            Statement statement3 = connection.createStatement();
            ResultSet resultSet = statement3.executeQuery("select * from GuestParking where SlotNumber = '" + slotNum + "' and ParkingStatus = 'Yes'");
            while(resultSet.next()){
                fieldState = true;
            }  
        }catch(Exception e){
            System.out.println(e);
        }
        return fieldState;
    }
    
    
    public void storeGuestParkingData(String parkingDate, String entryTime, String name, String mobile, String vehicleNum, String parkingStatus, String slotNumber, String vehicleType){
        try{
            String query = "insert into GuestParking(ParkingDate, Name, Mobile, VehicleNumber, ParkingStatus, EntryTime, SlotNumber, VehicleType) "
                    + "values(?,?,?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
            
            pst.setString(1, parkingDate);
            pst.setString(2, name);
            pst.setString(3, mobile);
            pst.setString(4, vehicleNum);
            pst.setString(5, parkingStatus);
            pst.setString(6, entryTime);
            pst.setString(7, slotNumber);
            pst.setString(8, vehicleType);
            
            pst.executeUpdate();
            pst.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void updateGuestParkingData(String status, String vehicleNumber, String exitTime){
        try{
            String query = "update GuestParking set ParkingStatus = '" + status + "', ExitTime = '" + exitTime + "' where VehicleNumber = '" + vehicleNumber + "'";
            PreparedStatement pst = connection.prepareStatement(query);
            
            pst.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void retrieveGuestParkingData(String vehicleNumber){
        try{
            Statement statement3 = connection.createStatement();
            ResultSet resultSet = statement3.executeQuery("select * from GuestParking where VehicleNumber = '" + vehicleNumber + "' and ParkingStatus = 'Yes'");
            while(resultSet.next()){
                guestName = resultSet.getString("Name");
                guestMobile = resultSet.getString("Mobile");
                guestSlotNum = resultSet.getString("SlotNumber");
                this.guestVehicleType = resultSet.getString("VehicleType");
            }  
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    
    
    
    
    
    /***************************************************************/ 
    /***************************************************************/ 
    /***************************************************************/ 
    
    
    
    // start- 17 March,2020
//    public void storePersonData(String id, String firstName, String lastName, String mobileNum, String profession, String dept, byte[] pic){
//        try{
//            String query = "insert into Person(ID, FirstName, LastName, Mobile, Profession, Department, Photo) values(?,?,?,?,?,?,?)";
//            PreparedStatement pst = connection.prepareStatement(query);
//            
//            pst.setString(1, id);
//            pst.setString(2, firstName);
//            pst.setString(3, lastName);
//            pst.setString(4, mobileNum);
//            pst.setString(5, profession);
//            pst.setString(6, dept);
//            pst.setBytes(7, pic);
////            
//            pst.executeUpdate();
//            pst.close();
//            
//            JOptionPane.showMessageDialog(null, "Successfully stored. Thank you");
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//    //end- 17 March,2020
//    
//    public void storeVehicleData(String vehicleSerial, String vehicleNum, String vehicleType, String vehicleModel, 
//            String vehicleColor, String regDate, String expiryDate, String id){
//        try{
//            String query = "insert into Vehicle(VehicleNumber, VehicleType, VehicleModel, VehicleColor, RegDate, ExpiryDate, ID) values(?,?,?,?,?,?,?)";
//            PreparedStatement pst = connection.prepareStatement(query);
//            
//            String vehicleNumberNew = vehicleSerial + vehicleNum;
//            System.out.println(vehicleNumberNew);
//   
//            pst.setString(1, vehicleNumberNew);
//            pst.setString(2, vehicleType);
//            pst.setString(3, vehicleModel);
//            pst.setString(4, vehicleColor);  
//            pst.setString(5, regDate);
//            pst.setString(6, expiryDate);
//            pst.setString(7, id);
//            
//            pst.executeUpdate();
//            pst.close();
//            
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
//    
//    public String forGeneratingTeacherID(){
//        String count = null;
//        //System.out.println(profession);
//        try{
//            statement1 = connection.createStatement();
//            
//            ResultSet resultSet = statement1.executeQuery("select count(*) as count from Person inner join Vehicle on Person.ID=Vehicle.ID group by Profession having Profession = 'Teacher'");
//            while(resultSet.next()){
//            count = resultSet.getString("count");
//            System.out.println(count);
//            }
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, e);
//        }
//        
//        return String.valueOf(Integer.parseInt(count) + 1);
//    }
//    
//    public String forGeneratingStaffID(){
//        String count = null;
//        //System.out.println(profession);
//        try{
//            statement1 = connection.createStatement();
//            
//            ResultSet resultSet = statement1.executeQuery("select count(*) as count from Person inner join Vehicle on Person.ID=Vehicle.ID group by Profession having Profession = 'Staff'");
//            while(resultSet.next()){
//            count = resultSet.getString("count");
//            System.out.println(count);
//            }
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, e);
//        }
//        
//        return String.valueOf(Integer.parseInt(count) + 1);
//    }
//    
//    public void storeSchedule(String id, String sundayStart, String sundayEnd, String mondayStart, String mondayEnd, String tuesdayStart,
//            String tuesdayEnd, String wedStart, String wedEnd, String thursdayStart, String thursdayEnd){
//        try{
//            String query = "insert into Schedule(ID, SundayStart, SundayEnd, MondayStart, MondayEnd, TuesdayStart, TuesdayEnd, WednesdayStart,"
//                    + "WednesdayEnd, ThursdayStart, ThursdayEnd) values(?,?,?,?,?,?,?,?,?,?,?)";
//            PreparedStatement pst = connection.prepareStatement(query);
//            
//            pst.setString(1, id);
//            pst.setString(2, sundayStart);
//            pst.setString(3, sundayEnd);
//            pst.setString(4, mondayStart);
//            pst.setString(5, mondayEnd);
//            pst.setString(6, tuesdayStart);
//            pst.setString(7, tuesdayEnd);
//            pst.setString(8, wedStart);
//            pst.setString(9, wedEnd);
//            pst.setString(10, thursdayStart);
//            pst.setString(11, thursdayEnd);
//            
//            pst.executeUpdate();
//            pst.close();
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }

   
}
