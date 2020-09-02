/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package austpms;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Tahmid
 */
public class Register extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
        screenShowing();
        
        
    }
    
    
    /****screen size****/
    private final int screenWidth = 960;
    private final int screenHeight = 640;
    
    //variables
    int charCount = 0; // this variable is for character count when typing mobile number
    int charCountForVehicleNum = 0; // this variable is for character count when typing Vehicle number
    
    
    /*******************variables for database******************/
    
    ConnectDatabase connectDatabase = new ConnectDatabase();
    String idTeacherStaff;
    //start-17 March, 2020
    String firstName;
    String lastName;
    String profession;
    String id;
    String mobileNum;
    String dept;
    String vehicleType;
    String vehicleModel;
    String vehicleColor;
    String vehicleSerial;
    String vehicleNumber;
    String regDate;
    String expiryDate;
    //end-17 March,2020
    
    boolean deptComboActiveState = false;
    String departmentCode; // using department code for generating teacher's ID or staff's ID
    String professionCode;
    private void generateDeptCode(){
        
        if(deptCombo.getSelectedIndex() == 1){
            departmentCode = "09"; // for Arts and Science
        }
        
        if(deptCombo.getSelectedIndex() == 2){
            departmentCode = "01";
        }
        if(deptCombo.getSelectedIndex() == 3){
            departmentCode = "02";
        }
        if(deptCombo.getSelectedIndex() == 4){
            departmentCode = "03";
        }
        if(deptCombo.getSelectedIndex() == 5){
            departmentCode = "04";
        }
        if(deptCombo.getSelectedIndex() == 6){
            departmentCode = "05";
        }
        if(deptCombo.getSelectedIndex() == 7){
            departmentCode = "06";
        }
        if(deptCombo.getSelectedIndex() == 8){
            departmentCode = "07";
        }
        if(deptCombo.getSelectedIndex() == 9){
            departmentCode = "08";
        }
        
        
    }
    
    private void professionCodeGenerate(){
        
        //profession code generate
        if(professionCombo.getSelectedIndex() == 1)
        {
            professionCode = "01";
        }
        if(professionCombo.getSelectedIndex() == 3)
        {
            professionCode = "02";
        }
    }
    
    private void enableStudentInfo(boolean state){
        startHour1.setEnabled(state);
        startMin1.setEnabled(state);
        endHour1.setEnabled(state);
        endMin1.setEnabled(state);
        
        startHour2.setEnabled(state);
        startMin2.setEnabled(state);
        endHour2.setEnabled(state);
        endMin2.setEnabled(state);
        
        startHour3.setEnabled(state);
        startMin3.setEnabled(state);
        endHour3.setEnabled(state);
        endMin3.setEnabled(state);
        
        startHour4.setEnabled(state);
        startMin4.setEnabled(state);
        endHour4.setEnabled(state);
        endMin4.setEnabled(state);
        
        startHour5.setEnabled(state);
        startMin5.setEnabled(state);
        endHour5.setEnabled(state);
        endMin5.setEnabled(state);
        
    }
    
    private void setDefaultTimeField(){
        startHour1.setText("hour");
        startHour2.setText("hour");
        startHour3.setText("hour");
        startHour4.setText("hour");
        startHour5.setText("hour");
        
        endHour1.setText("hour");
        endHour2.setText("hour");
        endHour3.setText("hour");
        endHour4.setText("hour");
        endHour5.setText("hour");
        
        startMin1.setText("min");
        startMin2.setText("min");
        startMin3.setText("min");
        startMin4.setText("min");
        startMin5.setText("min");
        
        endMin1.setText("min");
        endMin2.setText("min");
        endMin3.setText("min");
        endMin4.setText("min");
        endMin5.setText("min");
    }
    
    private void screenShowing(){
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setSize(screenWidth, screenHeight);
//        System.out.println(size.width/2); //== 960
//        System.out.println(size.height/2 + 100); //==640
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        
        mainPanel.setPreferredSize(new Dimension(screenWidth, screenHeight));
        
    }
    
    
    /*******************************Image related******************************/
    //pic resize for upload
    private ImageIcon resizeImage(String imagePath){
        ImageIcon myImage = new ImageIcon(imagePath);
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(imagePanel.getWidth(), imagePanel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage = new ImageIcon(newImg);
        return finalImage;
    }
    
    private void convertToByteArray(String path){
        try{
            File image = new File(path);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            
            for(int readNum; (readNum = fis.read(buf))!=-1;){
                baos.write(buf, 0, readNum);
            }
            picture = baos.toByteArray();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    private byte[] picture = null;
    private boolean isImageSelected = false;
    
    /******************************image related*******************************/
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel27 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        backButton = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        expiryDateField = new javax.swing.JTextField();
        regDateField = new javax.swing.JTextField();
        vehicleNumField = new javax.swing.JTextField();
        vehicleSerialCombo = new javax.swing.JComboBox<>();
        vehicleColorField = new javax.swing.JTextField();
        vehicleModelField = new javax.swing.JTextField();
        vehicleTypeCombo = new javax.swing.JComboBox<>();
        mobileNumField = new javax.swing.JTextField();
        idField = new javax.swing.JTextField();
        deptCombo = new javax.swing.JComboBox<>();
        professionCombo = new javax.swing.JComboBox<>();
        idGenerateButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        selectImageButton = new javax.swing.JButton();
        imagePanel = new javax.swing.JPanel();
        imageField = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        warningMsg = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        clsHourPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        startHour5 = new javax.swing.JTextField();
        startHour4 = new javax.swing.JTextField();
        startHour3 = new javax.swing.JTextField();
        startHour2 = new javax.swing.JTextField();
        startHour1 = new javax.swing.JTextField();
        startMin1 = new javax.swing.JTextField();
        startMin2 = new javax.swing.JTextField();
        startMin3 = new javax.swing.JTextField();
        startMin4 = new javax.swing.JTextField();
        startMin5 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        endHour1 = new javax.swing.JTextField();
        endHour2 = new javax.swing.JTextField();
        endHour3 = new javax.swing.JTextField();
        endHour4 = new javax.swing.JTextField();
        endHour5 = new javax.swing.JTextField();
        endMin5 = new javax.swing.JTextField();
        endMin4 = new javax.swing.JTextField();
        endMin3 = new javax.swing.JTextField();
        endMin2 = new javax.swing.JTextField();
        endMin1 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AUST Parking Management System");
        setBackground(new java.awt.Color(102, 102, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setBackground(new java.awt.Color(102, 102, 255));
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        mainPanel.setBackground(new java.awt.Color(102, 102, 255));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back(small).png"))); // NOI18N
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });
        mainPanel.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 40));

        firstNameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        firstNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                firstNameFieldKeyTyped(evt);
            }
        });
        mainPanel.add(firstNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 225, -1));

        lastNameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lastNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lastNameFieldKeyTyped(evt);
            }
        });
        mainPanel.add(lastNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 225, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Last Name");
        mainPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("First Name");
        mainPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Profession");
        mainPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Department");
        mainPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("ID");
        mainPanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Mobile");
        mainPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Vehicle Type");
        mainPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Vehicle Model");
        mainPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Vehicle Color");
        mainPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Vehicle Serial");
        mainPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Vehicle Number");
        mainPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, -1, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Registration Date");
        mainPanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Expiry Date");
        mainPanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, -1, -1));

        expiryDateField.setEditable(false);
        expiryDateField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        expiryDateField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                expiryDateFieldMouseClicked(evt);
            }
        });
        expiryDateField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                expiryDateFieldKeyTyped(evt);
            }
        });
        mainPanel.add(expiryDateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 500, 225, -1));

        regDateField.setEditable(false);
        regDateField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        regDateField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regDateFieldMouseClicked(evt);
            }
        });
        regDateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regDateFieldActionPerformed(evt);
            }
        });
        regDateField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                regDateFieldKeyTyped(evt);
            }
        });
        mainPanel.add(regDateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 470, 225, -1));

        vehicleNumField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        vehicleNumField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleNumFieldActionPerformed(evt);
            }
        });
        vehicleNumField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                vehicleNumFieldKeyTyped(evt);
            }
        });
        mainPanel.add(vehicleNumField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 225, -1));

        vehicleSerialCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        vehicleSerialCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Ha", "La", "Ga", "Gha", "Ka" }));
        mainPanel.add(vehicleSerialCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 225, -1));

        vehicleColorField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mainPanel.add(vehicleColorField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 225, -1));

        vehicleModelField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mainPanel.add(vehicleModelField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 225, -1));

        vehicleTypeCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        vehicleTypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Car", "Self Driving Car", "Motor Bike" }));
        mainPanel.add(vehicleTypeCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 225, -1));

        mobileNumField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mobileNumField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mobileNumFieldKeyTyped(evt);
            }
        });
        mainPanel.add(mobileNumField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 225, -1));

        idField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                idFieldMouseClicked(evt);
            }
        });
        idField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFieldActionPerformed(evt);
            }
        });
        mainPanel.add(idField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 225, -1));

        deptCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deptCombo.setMaximumRowCount(12);
        deptCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Arts & Science", "Archi", "BBA", "CE", "CSE", "EEE", "TEX", "IPE", "ME" }));
        deptCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                deptComboItemStateChanged(evt);
            }
        });
        deptCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptComboActionPerformed(evt);
            }
        });
        mainPanel.add(deptCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 220, -1));

        professionCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        professionCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Teacher", "Student", "Staff" }));
        professionCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                professionComboItemStateChanged(evt);
            }
        });
        professionCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                professionComboActionPerformed(evt);
            }
        });
        mainPanel.add(professionCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 225, -1));

        idGenerateButton.setBackground(new java.awt.Color(0, 255, 153));
        idGenerateButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        idGenerateButton.setText("Generate");
        idGenerateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idGenerateButtonActionPerformed(evt);
            }
        });
        mainPanel.add(idGenerateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Register");
        mainPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(0, 255, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 255, 0));
        mainPanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 120, -1));

        selectImageButton.setBackground(new java.awt.Color(0, 255, 204));
        selectImageButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        selectImageButton.setText("Select");
        selectImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectImageButtonActionPerformed(evt);
            }
        });
        mainPanel.add(selectImageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 490, -1, -1));

        imagePanel.setBackground(new java.awt.Color(255, 255, 255));
        imagePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imagePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imageField.setText("Upload a picture");
        imagePanel.add(imageField, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        mainPanel.add(imagePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, 150, 170));

        submitButton.setBackground(new java.awt.Color(255, 0, 0));
        submitButton.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        mainPanel.add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 520, 100, 30));

        warningMsg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        warningMsg.setForeground(new java.awt.Color(51, 255, 51));
        mainPanel.add(warningMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 400, 20));

        jSeparator1.setBackground(new java.awt.Color(0, 255, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 255, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        mainPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 10, 470));

        clsHourPanel.setBackground(new java.awt.Color(204, 204, 255));
        clsHourPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("For students only (set class hour):");
        clsHourPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(153, 0, 0));
        jLabel24.setText("*** Please, use 24-hour format");
        clsHourPanel.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Sunday");
        clsHourPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Monday");
        clsHourPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Tuesday");
        clsHourPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Wednesday");
        clsHourPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Thursday");
        clsHourPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        startHour5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        startHour5.setText("hour");
        startHour5.setEnabled(false);
        startHour5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startHour5MouseClicked(evt);
            }
        });
        clsHourPanel.add(startHour5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 60, -1));

        startHour4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        startHour4.setText("hour");
        startHour4.setEnabled(false);
        startHour4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startHour4MouseClicked(evt);
            }
        });
        clsHourPanel.add(startHour4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 60, -1));

        startHour3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        startHour3.setText("hour");
        startHour3.setEnabled(false);
        startHour3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startHour3MouseClicked(evt);
            }
        });
        clsHourPanel.add(startHour3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 60, -1));

        startHour2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        startHour2.setText("hour");
        startHour2.setEnabled(false);
        startHour2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startHour2MouseClicked(evt);
            }
        });
        clsHourPanel.add(startHour2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 60, -1));

        startHour1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        startHour1.setText("hour");
        startHour1.setEnabled(false);
        startHour1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startHour1MouseClicked(evt);
            }
        });
        startHour1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startHour1ActionPerformed(evt);
            }
        });
        clsHourPanel.add(startHour1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 60, -1));

        startMin1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        startMin1.setText("min");
        startMin1.setEnabled(false);
        startMin1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startMin1MouseClicked(evt);
            }
        });
        startMin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startMin1ActionPerformed(evt);
            }
        });
        clsHourPanel.add(startMin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 60, -1));

        startMin2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        startMin2.setText("min");
        startMin2.setEnabled(false);
        startMin2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startMin2MouseClicked(evt);
            }
        });
        clsHourPanel.add(startMin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 60, -1));

        startMin3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        startMin3.setText("min");
        startMin3.setEnabled(false);
        startMin3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startMin3MouseClicked(evt);
            }
        });
        clsHourPanel.add(startMin3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 60, -1));

        startMin4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        startMin4.setText("min");
        startMin4.setEnabled(false);
        startMin4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startMin4MouseClicked(evt);
            }
        });
        clsHourPanel.add(startMin4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 60, -1));

        startMin5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        startMin5.setText("min");
        startMin5.setEnabled(false);
        startMin5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startMin5MouseClicked(evt);
            }
        });
        clsHourPanel.add(startMin5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 60, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("to");
        clsHourPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("to");
        clsHourPanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("to");
        clsHourPanel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("to");
        clsHourPanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("to");
        clsHourPanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

        endHour1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        endHour1.setText("hour");
        endHour1.setEnabled(false);
        endHour1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                endHour1MouseClicked(evt);
            }
        });
        clsHourPanel.add(endHour1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 60, -1));

        endHour2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        endHour2.setText("hour");
        endHour2.setEnabled(false);
        endHour2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                endHour2MouseClicked(evt);
            }
        });
        clsHourPanel.add(endHour2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 60, -1));

        endHour3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        endHour3.setText("hour");
        endHour3.setEnabled(false);
        endHour3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                endHour3MouseClicked(evt);
            }
        });
        clsHourPanel.add(endHour3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 60, -1));

        endHour4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        endHour4.setText("hour");
        endHour4.setEnabled(false);
        endHour4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                endHour4MouseClicked(evt);
            }
        });
        clsHourPanel.add(endHour4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 60, -1));

        endHour5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        endHour5.setText("hour");
        endHour5.setEnabled(false);
        endHour5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                endHour5MouseClicked(evt);
            }
        });
        clsHourPanel.add(endHour5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 60, -1));

        endMin5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        endMin5.setText("min");
        endMin5.setEnabled(false);
        endMin5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                endMin5MouseClicked(evt);
            }
        });
        clsHourPanel.add(endMin5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 60, -1));

        endMin4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        endMin4.setText("min");
        endMin4.setEnabled(false);
        endMin4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                endMin4MouseClicked(evt);
            }
        });
        clsHourPanel.add(endMin4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 60, -1));

        endMin3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        endMin3.setText("min");
        endMin3.setEnabled(false);
        endMin3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                endMin3MouseClicked(evt);
            }
        });
        clsHourPanel.add(endMin3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 60, -1));

        endMin2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        endMin2.setText("min");
        endMin2.setEnabled(false);
        endMin2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                endMin2MouseClicked(evt);
            }
        });
        clsHourPanel.add(endMin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 60, -1));

        endMin1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        endMin1.setText("min");
        endMin1.setEnabled(false);
        endMin1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                endMin1MouseClicked(evt);
            }
        });
        clsHourPanel.add(endMin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 60, -1));

        mainPanel.add(clsHourPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 400, 220));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(153, 51, 0));
        jLabel29.setText("(**For Student ID pattern should be 17.01.05.xxx)");
        jLabel29.setToolTipText("");
        mainPanel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, -1, -1));

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void professionComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_professionComboActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_professionComboActionPerformed

    private void professionComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_professionComboItemStateChanged
        // TODO add your handling code here:
        //String item = jComboBox3.getSelectedItem().toString();
        expiryDateField.setText("");
        idField.setText("");
        if(professionCombo.getSelectedIndex() == 2){
            enableStudentInfo(true);
            idGenerateButton.setEnabled(false);
            idField.setEnabled(true);
        }
        else{
            enableStudentInfo(false);
            idGenerateButton.setEnabled(true);
            setDefaultTimeField();
            professionCodeGenerate();
            System.out.println(professionCode);
        }
        
    }//GEN-LAST:event_professionComboItemStateChanged

    private void mobileNumFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobileNumFieldKeyTyped
        // TODO add your handling code here:
        char ch = evt.getKeyChar();
        if(charCount < 11){
        if(!Character.isDigit(ch)){
            evt.consume();
            
            if(ch == evt.VK_BACK_SPACE || ch == evt.VK_DELETE){
                charCount--;
                if(charCount < 0){
                    charCount = 0;
                }
            }
            else
                getToolkit().beep();
        }
        else{
            charCount++;
            System.out.println(charCount);
        }
        }
        else{
            evt.consume();
            if(ch == evt.VK_BACK_SPACE || ch == evt.VK_DELETE){
                charCount--;
                if(charCount < 0){
                    charCount = 0;
                }
            }
            else
                getToolkit().beep();
        }
    }//GEN-LAST:event_mobileNumFieldKeyTyped

    private void vehicleNumFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicleNumFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vehicleNumFieldActionPerformed

    private void vehicleNumFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vehicleNumFieldKeyTyped
        // TODO add your handling code here:
        char ch = evt.getKeyChar();
        if(charCountForVehicleNum < 6){
        if(!Character.isDigit(ch)){
            evt.consume();
            
            if(ch == evt.VK_BACK_SPACE || ch == evt.VK_DELETE){
                charCountForVehicleNum--;
                if(charCountForVehicleNum < 0){
                    charCountForVehicleNum = 0;
                }
            }
            else
                getToolkit().beep();
        }
        else{
            charCountForVehicleNum++;
            System.out.println(charCountForVehicleNum);
        }
        }
        else{
            evt.consume();
            if(ch == evt.VK_BACK_SPACE || ch == evt.VK_DELETE){
                charCountForVehicleNum--;
                if(charCountForVehicleNum < 0){
                    charCountForVehicleNum = 0;
                }
            }
            else
                getToolkit().beep();
        }
    }//GEN-LAST:event_vehicleNumFieldKeyTyped

    private void lastNameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastNameFieldKeyTyped
        // TODO add your handling code here:
//        char ch = evt.getKeyChar();
//        
//        if(!Character.isLetter(ch)){
//            evt.consume();
//        }
    }//GEN-LAST:event_lastNameFieldKeyTyped

    private void firstNameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstNameFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameFieldKeyTyped

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        /************testing database(17 march)***************/
        //ConnectDatabase connectDatabase = new ConnectDatabase();
        //connectDatabase = new ConnectDatabase();
        connectDatabase.ConnectDB();
        
        //connectDatabase.retrieveData();
        
        // start- 17 March, 2020
        profession = professionCombo.getSelectedItem().toString();
        firstName = firstNameField.getText();
        lastName = lastNameField.getText();
        id = idField.getText();
        mobileNum = mobileNumField.getText();
        dept = deptCombo.getSelectedItem().toString();
        vehicleType = vehicleTypeCombo.getSelectedItem().toString();
        vehicleModel = vehicleModelField.getText();
        vehicleColor  = vehicleColorField.getText();
        vehicleSerial = vehicleSerialCombo.getSelectedItem().toString();
        vehicleNumber = vehicleNumField.getText();
        regDate = regDateField.getText();//"2015-05-25";
        expiryDate = expiryDateField.getText();//"2015-11-25";
        
        if(profession.equals("None") || firstName.equals("") || lastName.equals("") || id.equals("") 
                || mobileNum.equals("") || dept.equals("None") || vehicleType.equals("None") || vehicleModel.equals("")
                || vehicleColor.equals("") || vehicleSerial.equals("None") || vehicleNumber.equals("") || !isImageSelected){
            warningMsg.setText("Please fill all of the fields and select proper item");
        }
        else{
            if(profession == professionCombo.getItemAt(1).toString()){ // Teacher
                
                connectDatabase.storePersonData(id, firstName, lastName, mobileNum, profession, dept, picture);
                connectDatabase.storeVehicleData(vehicleSerial, vehicleNumber, vehicleType, vehicleModel, vehicleColor, regDate, expiryDate, id);
                warningMsg.setText("");
                System.out.println("OK");
                
                //generating barcode using person's ID
                BarcodeGenerate barcode = new BarcodeGenerate();
                barcode.createBarCode128(id);
            }
            else if(profession == professionCombo.getItemAt(2).toString()){ // Student
                
                connectDatabase.storePersonData(id, firstName, lastName, mobileNum, profession, dept, picture);
                connectDatabase.storeVehicleData(vehicleSerial, vehicleNumber, vehicleType, vehicleModel, vehicleColor, regDate, expiryDate, id);
                warningMsg.setText("");
                System.out.println("OK");
                
                /*******************work with schedule****************/
                String sunStart = startHour1.getText() + ":" + startMin1.getText();
                String sunEnd = endHour1.getText() + ":" + endMin1.getText();
                String monStart = startHour2.getText() + ":" + startMin2.getText();
                String monEnd = endHour2.getText() + ":" + endMin2.getText();
                String tuesStart = startHour3.getText() + ":" + startMin3.getText();
                String tuesEnd = endHour3.getText() + ":" + endMin3.getText();
                String wedStart = startHour4.getText() + ":" + startMin4.getText();
                String wedEnd = endHour4.getText() + ":" + endMin4.getText();
                String thursStart = startHour5.getText() + ":" + startMin5.getText();
                String thursEnd = endHour5.getText() + ":" + endMin5.getText();
//
                connectDatabase.storeSchedule(id, sunStart, sunEnd, monStart, monEnd, tuesStart, tuesEnd, wedStart, wedEnd, thursStart, thursEnd);
                
                //generating barcode using person's ID
                BarcodeGenerate barcode = new BarcodeGenerate();
                barcode.createBarCode128(id);
            }
            else if(profession == professionCombo.getItemAt(3).toString()){ // Staff
                
                connectDatabase.storePersonData(id, firstName, lastName, mobileNum, profession, dept, picture);
                connectDatabase.storeVehicleData(vehicleSerial, vehicleNumber, vehicleType, vehicleModel, vehicleColor, regDate, expiryDate, id);
                warningMsg.setText("");
                System.out.println("OK");
                
                //generating barcode using person's ID
                BarcodeGenerate barcode = new BarcodeGenerate();
                barcode.createBarCode128(id);
            }
            else{
                System.out.println("Not OK");
            }
        }
        
        
        //end- 17 March, 2020
        //connectDatabase.storeData("Abul", "Molla", "Kalatiya", "Dhaka", "Bangladesh");
        
        
        
    }//GEN-LAST:event_submitButtonActionPerformed

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFieldActionPerformed

    private void startHour1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startHour1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_startHour1ActionPerformed

    private void startHour1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startHour1MouseClicked
        // TODO add your handling code here:
        //String text = startHour1.getText();
        
        /*====removing default text====*/
        if(startHour1.isEnabled() && startHour1.getText().equals("hour"))
        {
            startHour1.setText("");
        }
    }//GEN-LAST:event_startHour1MouseClicked

    private void startHour2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startHour2MouseClicked
        // TODO add your handling code here:
        
        /*====removing default text====*/
        if(startHour2.isEnabled() && startHour2.getText().equals("hour"))
        {
            startHour2.setText("");
        }
    }//GEN-LAST:event_startHour2MouseClicked

    private void startHour3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startHour3MouseClicked
        // TODO add your handling code here:
        
        /*====removing default text====*/
        if(startHour3.isEnabled() && startHour3.getText().equals("hour"))
        {
            startHour3.setText("");
        }
    }//GEN-LAST:event_startHour3MouseClicked

    private void startHour4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startHour4MouseClicked
        // TODO add your handling code here:
        
        /*====removing default text====*/
        if(startHour4.isEnabled() && startHour4.getText().equals("hour"))
        {
            startHour4.setText("");
        }
    }//GEN-LAST:event_startHour4MouseClicked

    private void startHour5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startHour5MouseClicked
        // TODO add your handling code here:
        
        /*====removing default text====*/
        if(startHour5.isEnabled() && startHour5.getText().equals("hour"))
        {
            startHour5.setText("");
        }
    }//GEN-LAST:event_startHour5MouseClicked

    private void endHour1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_endHour1MouseClicked
        // TODO add your handling code here:
        
        /*====removing default text====*/
        if(endHour1.isEnabled() && endHour1.getText().equals("hour"))
        {
            endHour1.setText("");
        }
    }//GEN-LAST:event_endHour1MouseClicked

    private void endHour2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_endHour2MouseClicked
        // TODO add your handling code here:
        
        /*====removing default text====*/
        if(endHour2.isEnabled() && endHour2.getText().equals("hour"))
        {
            endHour2.setText("");
        }
    }//GEN-LAST:event_endHour2MouseClicked

    private void endHour3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_endHour3MouseClicked
        // TODO add your handling code here:
        
        /*====removing default text====*/
        if(endHour3.isEnabled() && endHour3.getText().equals("hour"))
        {
            endHour3.setText("");
        }
    }//GEN-LAST:event_endHour3MouseClicked

    private void endHour4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_endHour4MouseClicked
        // TODO add your handling code here:
        
        /*====removing default text====*/
        if(endHour4.isEnabled() && endHour4.getText().equals("hour"))
        {
            endHour4.setText("");
        }
    }//GEN-LAST:event_endHour4MouseClicked

    private void endHour5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_endHour5MouseClicked
        // TODO add your handling code here:
        
        /*====removing default text====*/
        if(endHour5.isEnabled() && endHour5.getText().equals("hour"))
        {
            endHour5.setText("");
        }
    }//GEN-LAST:event_endHour5MouseClicked

    private void endMin1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_endMin1MouseClicked
        // TODO add your handling code here:.
        
        /*====removing default text====*/
        if(endMin1.isEnabled() && endMin1.getText().equals("min"))
        {
            endMin1.setText("");
        }
    }//GEN-LAST:event_endMin1MouseClicked

    private void endMin2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_endMin2MouseClicked
        // TODO add your handling code here:
        
        /*====removing default text====*/
        if(endMin2.isEnabled() && endMin2.getText().equals("min"))
        {
            endMin2.setText("");
        }
    }//GEN-LAST:event_endMin2MouseClicked

    private void endMin3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_endMin3MouseClicked
        // TODO add your handling code here:
        
        /*====removing default text====*/
        if(endMin3.isEnabled() && endMin3.getText().equals("min"))
        {
            endMin3.setText("");
        }
    }//GEN-LAST:event_endMin3MouseClicked

    private void endMin4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_endMin4MouseClicked
        // TODO add your handling code here:
        
        /*====removing default text====*/
        if(endMin4.isEnabled() && endMin4.getText().equals("min"))
        {
            endMin4.setText("");
        }
    }//GEN-LAST:event_endMin4MouseClicked

    private void endMin5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_endMin5MouseClicked
        // TODO add your handling code here:
        
        /*====removing default text====*/
        if(endMin5.isEnabled() && endMin5.getText().equals("min"))
        {
            endMin5.setText("");
        }
    }//GEN-LAST:event_endMin5MouseClicked

    private void startMin1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startMin1MouseClicked
        // TODO add your handling code here:
        
        /*====removing default text====*/
        if(startMin1.isEnabled() && startMin1.getText().equals("min"))
        {
            startMin1.setText("");
        }
    }//GEN-LAST:event_startMin1MouseClicked

    private void startMin2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startMin2MouseClicked
        // TODO add your handling code here:
        
        /*====removing default text====*/
        if(startMin2.isEnabled() && startMin2.getText().equals("min"))
        {
            startMin2.setText("");
        }
    }//GEN-LAST:event_startMin2MouseClicked

    private void startMin3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startMin3MouseClicked
        // TODO add your handling code here:
        
        /*====removing default text====*/
        if(startMin3.isEnabled() && startMin3.getText().equals("min"))
        {
            startMin3.setText("");
        }
    }//GEN-LAST:event_startMin3MouseClicked

    private void startMin4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startMin4MouseClicked
        // TODO add your handling code here:
        
        /*====removing default text====*/
        if(startMin4.isEnabled() && startMin4.getText().equals("min"))
        {
            startMin4.setText("");
        }
    }//GEN-LAST:event_startMin4MouseClicked

    private void startMin5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startMin5MouseClicked
        // TODO add your handling code here:
        /*====removing default text====*/
        if(startMin5.isEnabled() && startMin5.getText().equals("min"))
        {
            startMin5.setText("");
        }
    }//GEN-LAST:event_startMin5MouseClicked

    private void startMin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startMin1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startMin1ActionPerformed

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        // TODO add your handling code here:
        this.dispose();
        Home home = new Home();
        home.setVisible(true);
    }//GEN-LAST:event_backButtonMouseClicked

    private void regDateFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_regDateFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_regDateFieldKeyTyped

    private void expiryDateFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_expiryDateFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_expiryDateFieldKeyTyped

    private void regDateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regDateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regDateFieldActionPerformed

    private void regDateFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regDateFieldMouseClicked
        // TODO add your handling code here:
        Time time = new Time();
        regDateField.setText(time.getCurrentDate());
          //regDateField.setText("2020-08-12");
    }//GEN-LAST:event_regDateFieldMouseClicked

    private void expiryDateFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expiryDateFieldMouseClicked
        // TODO add your handling code here:
        
        //Time time = new Time();
        if(regDateField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please click on Registration Date field first");
        }
        else{
            String curDate = regDateField.getText();
            String splitDate[] = curDate.split("-", 3);

            int date = Integer.parseInt(splitDate[2]);
            int month = Integer.parseInt(splitDate[1]);
            int year = Integer.parseInt(splitDate[0]);
            int expireIn;
            int extendMonth = 0;
            int extendYear = 0;
            if(professionCombo.getSelectedItem().toString().equals("Student")){
                expireIn = 6;
                extendMonth = month + expireIn;
                
                if(extendMonth <= 12){
                    expiryDateField.setText(String.valueOf(year) + "-" + String.valueOf(extendMonth) + "-" + String.valueOf(date));
                }
                else{
                    year = year + 1;
                    extendMonth = extendMonth % 12;
                    if(extendMonth == 2){ // by chance jodi generated tarikh maane day ta february month hoy r 
                        // day jodi 28/29(leap year) er beshi hoy tahole problem. tai 28 er beshi holei next month er date diye disi
                        if(date > 28){
                            extendMonth += 1;
                            date = 1;
                        }
                    }
                    expiryDateField.setText(String.valueOf(year) + "-" + String.valueOf(extendMonth) + "-" + String.valueOf(date));
                }
            }
            else if(professionCombo.getSelectedIndex() == 1 || professionCombo.getSelectedIndex() == 3){
                expireIn = 1;
                extendYear = year + expireIn;
                
                expiryDateField.setText(String.valueOf(extendYear) + "-" + String.valueOf(month) + "-" + String.valueOf(date));
            }
            else{
                JOptionPane.showMessageDialog(null, "Please select profession");
            }
            

//            if(extendMonth <= 12){
//                expiryDateField.setText(String.valueOf(year) + "-" + String.valueOf(extendMonth) + "-" + String.valueOf(date));
//            }
//            else{
//                year = year + 1;
//                extendMonth = extendMonth % 12;
//                expiryDateField.setText(String.valueOf(year) + "-" + String.valueOf(extendMonth) + "-" + String.valueOf(date));
//            }
        }
        
        
    }//GEN-LAST:event_expiryDateFieldMouseClicked

    private void selectImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectImageButtonActionPerformed
        // TODO add your handling code here:
        
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.image", "jpg", "png", "jpeg");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        
        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            imageField.setText("");
            imageField.setIcon(resizeImage(path));
            convertToByteArray(path);
            isImageSelected = true;
        }
        else if(result == JFileChooser.CANCEL_OPTION){
            imageField.setText("Upload a picture");
            System.out.println("No file selected");
            isImageSelected = false;
        }
    }//GEN-LAST:event_selectImageButtonActionPerformed

    private void idFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idFieldMouseClicked
        // TODO add your handling code here:
//        String idForTeacherStaff;
//        if(professionCombo.getSelectedIndex() == 1 || professionCombo.getSelectedIndex() == 3){
//            idForTeacherStaff = "2878.01.04.001";
//            idField.setText(idForTeacherStaff);
//            idField.setEnabled(false);
//        }
//        else{
//            idField.setEnabled(true);
//        }
    }//GEN-LAST:event_idFieldMouseClicked

    private void deptComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_deptComboItemStateChanged
        // TODO add your handling code here:
        idField.setText("");
    }//GEN-LAST:event_deptComboItemStateChanged

    private void deptComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deptComboActionPerformed
        // TODO add your handling code here:
        if(deptCombo.getSelectedIndex() != 0){
            deptComboActiveState = true;    
            generateDeptCode();
            System.out.println(departmentCode);     
        }
        else{
            idField.setText("");
        }
    }//GEN-LAST:event_deptComboActionPerformed

    private void idGenerateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idGenerateButtonActionPerformed
        // TODO add your handling code here:
        String idForTeacherStaff;
        String tempId = null;
        if(professionCombo.getSelectedIndex() == 0 || deptCombo.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Please select profession and department first");
        }
        else{
            connectDatabase.ConnectDB();
            if(professionCombo.getSelectedItem().equals("Teacher")){
                tempId = connectDatabase.forGeneratingTeacherID();
                if(Integer.parseInt(tempId) < 10){
                    tempId = "00" + tempId;
                }
                else if(Integer.parseInt(tempId) < 100){
                    tempId = "0" + tempId;
                }
                else
                    tempId = tempId;
            }
            else if(professionCombo.getSelectedItem().equals("Staff")){
                tempId = connectDatabase.forGeneratingStaffID();
                if(Integer.parseInt(tempId) < 10){
                    tempId = "00" + tempId;
                }
                else if(Integer.parseInt(tempId) < 100){
                    tempId = "0" + tempId;
                }
                else
                    tempId = tempId;
            }
            
            idForTeacherStaff = "2878." + professionCode + "." + departmentCode + "." + tempId;
            idField.setText(idForTeacherStaff);
            idField.setEnabled(false);
        }
    }//GEN-LAST:event_idGenerateButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backButton;
    private javax.swing.JPanel clsHourPanel;
    private javax.swing.JComboBox<String> deptCombo;
    private javax.swing.JTextField endHour1;
    private javax.swing.JTextField endHour2;
    private javax.swing.JTextField endHour3;
    private javax.swing.JTextField endHour4;
    private javax.swing.JTextField endHour5;
    private javax.swing.JTextField endMin1;
    private javax.swing.JTextField endMin2;
    private javax.swing.JTextField endMin3;
    private javax.swing.JTextField endMin4;
    private javax.swing.JTextField endMin5;
    private javax.swing.JTextField expiryDateField;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JTextField idField;
    private javax.swing.JButton idGenerateButton;
    private javax.swing.JLabel imageField;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField mobileNumField;
    private javax.swing.JComboBox<String> professionCombo;
    private javax.swing.JTextField regDateField;
    private javax.swing.JButton selectImageButton;
    private javax.swing.JTextField startHour1;
    private javax.swing.JTextField startHour2;
    private javax.swing.JTextField startHour3;
    private javax.swing.JTextField startHour4;
    private javax.swing.JTextField startHour5;
    private javax.swing.JTextField startMin1;
    private javax.swing.JTextField startMin2;
    private javax.swing.JTextField startMin3;
    private javax.swing.JTextField startMin4;
    private javax.swing.JTextField startMin5;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField vehicleColorField;
    private javax.swing.JTextField vehicleModelField;
    private javax.swing.JTextField vehicleNumField;
    private javax.swing.JComboBox<String> vehicleSerialCombo;
    private javax.swing.JComboBox<String> vehicleTypeCombo;
    private javax.swing.JLabel warningMsg;
    // End of variables declaration//GEN-END:variables
}
