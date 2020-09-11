/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package austpms;

/**
 *
 * @author Tahmid
 */
/************testing database(17 march)***************/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConnectDatabase {

    /**
     * @return the extraStatement
     */
    public Statement getExtraStatement() {
        return extraStatement;
    }

    /**
     * @return the extraResultSet
     */
    public ResultSet getExtraResultSet() {
        return extraResultSet;
    }

    /**
     * @return the countVehicle
     */
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

    /**
     * @return the photo
     */
    public byte[] getPhoto() {
        return photo;
    }
    public Connection connection;
    public Statement statement1;
    
    /******************************personal variable***************************/
    private String id;
    private String firstName;
    private String lastName;
    private String mobile;
    private String profession;
    private String department;
    private byte[] photo;
    
    private String countVehicle;
    private String vehicleType;
    /******************************personal variable***************************/
    
    private Statement extraStatement;
    private ResultSet extraResultSet;
    public void ConnectDB(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433; databaseName=AUSTPMS;selectMethod=cursor", "sa", "12345");                       
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public void retrieveDataNewVehicle(String id){
        try{
            statement1 = connection.createStatement();
            ResultSet resultSet2 = statement1.executeQuery("select P.ID, P.FirstName, P.LastName, P.Profession, P.Department, P.Photo from Person P inner join Vehicle V on P.ID = V.ID where P.ID = '"
                    + id + "'");
            
           while(resultSet2.next()){
               this.id = resultSet2.getString("ID");
               firstName = resultSet2.getString("FirstName");
               lastName = resultSet2.getString("LastName");
               profession = resultSet2.getString("Profession");
               department = resultSet2.getString("Department");
               photo = resultSet2.getBytes("Photo");
                             
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
    
    public void retrieveParkingData(String date){
        try {
            extraStatement = connection.createStatement();
            extraResultSet = extraStatement.executeQuery("select P2.ParkingDate, P1.Profession, P1.FirstName +' '+ P1.LastName as Name, P1.ID, P1.Mobile,P2.VehicleNumber, P2.ParkingStatus, "
                    + "P2.SlotNumber from Person P1 inner join Parking P2 on P1.ID = P2.ID where P2.ParkingDate='" +date+ "'");
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void retrieveFullData(){
        try {
            extraStatement = connection.createStatement();
            extraResultSet = extraStatement.executeQuery(" select * from Person inner join Vehicle on person.id = vehicle.id");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void retrieveFullDataUsingProf(String prof){
        try {
            extraStatement = connection.createStatement();
            extraResultSet = extraStatement.executeQuery(" select * from Person inner join Vehicle on person.id = vehicle.id "
                    + "where Profession = '" + prof + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void retrieveFullDataUsingDept(String dept){
        try {
            extraStatement = connection.createStatement();
            extraResultSet = extraStatement.executeQuery(" select * from Person inner join Vehicle on person.id = vehicle.id "
                    + "where Department='" + dept + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void retrieveFullDataUsingID(String id){
        try {
            extraStatement = connection.createStatement();
            extraResultSet = extraStatement.executeQuery(" select * from Person inner join Vehicle on person.id = vehicle.id "
                    + "where Person.ID='" + id + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void retrieveForExpandDate(String id, String vehicleNum){
        //boolean expandStatus = false;
        try {
            statement1 = connection.createStatement();
            ResultSet resultSet = statement1.executeQuery(" select * from Person inner join Vehicle on person.id = vehicle.id "
                    + "where Person.ID='" + id + "' and VehicleNumber='"+vehicleNum+"'");
            
            while(resultSet.next()){
                this.id = resultSet.getString("ID");
                profession = resultSet.getString("Profession");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    public void retrieveOnlyPhoto(String id){
        try{
            //extraStatement = connection.createStatement();
            //extraResultSet = extraStatement.executeQuery("select Photo from Person where ID='" + id + "'");
            statement1 = connection.createStatement();
            ResultSet resultSet = statement1.executeQuery("select Photo from Person where ID='" + id + "'");
            while(resultSet.next()){
                photo = resultSet.getBytes("Photo");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    // start- 17 March,2020
    public void storePersonData(String id, String firstName, String lastName, String mobileNum, String profession, String dept, byte[] pic){
        try{
            String query = "insert into Person(ID, FirstName, LastName, Mobile, Profession, Department, Photo) values(?,?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
            
            pst.setString(1, id);
            pst.setString(2, firstName);
            pst.setString(3, lastName);
            pst.setString(4, mobileNum);
            pst.setString(5, profession);
            pst.setString(6, dept);
            pst.setBytes(7, pic);
//            
            pst.executeUpdate();
            pst.close();
            
            JOptionPane.showMessageDialog(null, "Successfully stored. Thank you");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //end- 17 March,2020
    
    public void storeVehicleData(String vehicleSerial, String vehicleNum, String vehicleType, String vehicleModel, 
            String vehicleColor, String regDate, String expiryDate, String id){
        try{
            String query = "insert into Vehicle(VehicleNumber, VehicleType, VehicleModel, VehicleColor, RegDate, ExpiryDate, ID) values(?,?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
            
            String vehicleNumberNew = vehicleSerial + vehicleNum;
            System.out.println(vehicleNumberNew);
   
            pst.setString(1, vehicleNumberNew);
            pst.setString(2, vehicleType);
            pst.setString(3, vehicleModel);
            pst.setString(4, vehicleColor);  
            pst.setString(5, regDate);
            pst.setString(6, expiryDate);
            pst.setString(7, id);
            
            pst.executeUpdate();
            pst.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e + " I'm from vehicle");
        }
    }
    
    public String forGeneratingTeacherID(){
        String count = null;
        //System.out.println(profession);
        try{
            statement1 = connection.createStatement();
            
            ResultSet resultSet = statement1.executeQuery("select count(*) as count from Person inner join Vehicle on Person.ID=Vehicle.ID group by Profession having Profession = 'Teacher'");
            while(resultSet.next()){
            count = resultSet.getString("count");
            System.out.println(count);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        if(count == null){
            count = "0";
        }        
        return String.valueOf(Integer.parseInt(count) + 1);
//        return "1";
    }
    
    public String forGeneratingStaffID(){
        String count = null;
        //System.out.println(profession);
        try{
            statement1 = connection.createStatement();
            
            ResultSet resultSet = statement1.executeQuery("select count(*) as count from Person inner join Vehicle on Person.ID=Vehicle.ID group by Profession having Profession = 'Staff'");
            while(resultSet.next()){
            count = resultSet.getString("count");
            System.out.println(count);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        if(count == null){
            count = "0";
        } 
        return String.valueOf(Integer.parseInt(count) + 1);
    }
    
    public void storeSchedule(String id, String sundayStart, String sundayEnd, String mondayStart, String mondayEnd, String tuesdayStart,
            String tuesdayEnd, String wedStart, String wedEnd, String thursdayStart, String thursdayEnd){
        try{
            String query = "insert into Schedule(ID, SundayStart, SundayEnd, MondayStart, MondayEnd, TuesdayStart, TuesdayEnd, WednesdayStart,"
                    + "WednesdayEnd, ThursdayStart, ThursdayEnd) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
            
            pst.setString(1, id);
            pst.setString(2, sundayStart);
            pst.setString(3, sundayEnd);
            pst.setString(4, mondayStart);
            pst.setString(5, mondayEnd);
            pst.setString(6, tuesdayStart);
            pst.setString(7, tuesdayEnd);
            pst.setString(8, wedStart);
            pst.setString(9, wedEnd);
            pst.setString(10, thursdayStart);
            pst.setString(11, thursdayEnd);
            
            pst.executeUpdate();
            pst.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    /*for checking a person is expired or not for Parking*/
    public void checkingExpireDate(String date){
        try {
            String query = "select ExpiryDate, ID from Vehicle where ExpiryDate < = '" + date + "'";
            Statement st = connection.createStatement();
            //ResultSet rs = st.executeQuery(query);
            extraResultSet = st.executeQuery(query);
            
//            extraResultSet = rs;
//            while(rs.next()){
//                System.out.println(rs.getString("ID"));
//            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
