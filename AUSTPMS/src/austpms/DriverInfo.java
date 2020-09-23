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
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author tahmi
 */
public class DriverInfo extends javax.swing.JFrame {

    /**
     * @param sunStart the sunStart to set
     */
    public void setSunStart(String sunStart) {
        this.sunStart = sunStart;
    }

    /**
     * @param sunEnd the sunEnd to set
     */
    public void setSunEnd(String sunEnd) {
        this.sunEnd = sunEnd;
    }

    /**
     * @param monStart the monStart to set
     */
    public void setMonStart(String monStart) {
        this.monStart = monStart;
    }

    /**
     * @param monEnd the monEnd to set
     */
    public void setMonEnd(String monEnd) {
        this.monEnd = monEnd;
    }

    /**
     * @param tuesStart the tuesStart to set
     */
    public void setTuesStart(String tuesStart) {
        this.tuesStart = tuesStart;
    }

    /**
     * @param tuesEnd the tuesEnd to set
     */
    public void setTuesEnd(String tuesEnd) {
        this.tuesEnd = tuesEnd;
    }

    /**
     * @param wedStart the wedStart to set
     */
    public void setWedStart(String wedStart) {
        this.wedStart = wedStart;
    }

    /**
     * @param wedEnd the wedEnd to set
     */
    public void setWedEnd(String wedEnd) {
        this.wedEnd = wedEnd;
    }

    /**
     * @param thursStart the thursStart to set
     */
    public void setThursStart(String thursStart) {
        this.thursStart = thursStart;
    }

    /**
     * @param thursEnd the thursEnd to set
     */
    public void setThursEnd(String thursEnd) {
        this.thursEnd = thursEnd;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param mobileNum the mobileNum to set
     */
    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    /**
     * @param profession the profession to set
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }

    /**
     * @param dept the dept to set
     */
    public void setDept(String dept) {
        this.dept = dept;
    }

    /**
     * @param vehicleType the vehicleType to set
     */
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    /**
     * @param vehicleModel the vehicleModel to set
     */
    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    /**
     * @param vehicleColor the vehicleColor to set
     */
    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    /**
     * @param vehicleSerial the vehicleSerial to set
     */
    public void setVehicleSerial(String vehicleSerial) {
        this.vehicleSerial = vehicleSerial;
    }

    /**
     * @param vehicleNumber the vehicleNumber to set
     */
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    /**
     * @param regDate the regDate to set
     */
    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    /**
     * @param expiryDate the expiryDate to set
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    
    public void setPicture(byte[] picture){
        this.picture = picture;
    }

    /**
     * Creates new form DriverInfo
     */
    
    private String firstName = "";
    private String lastName = "";
    private String id = "";
    private String mobileNum = "";
    private String profession = "";
    private String dept = "";
    private String vehicleType = "";
    private String vehicleModel = "";
    private String vehicleColor = "";
    private String vehicleSerial = "";
    private String vehicleNumber = "";
    private String regDate  = "";
    private String expiryDate = "";
    private byte[] picture = null;

    
    private byte[] driverPicture = null;
    private byte[] licensePicture = null;
    private boolean isDriverImageSelected = false;
    private boolean isLicenseImageSelected = false;
    
    // =============== schedule ==================
    private String sunStart;
    private String sunEnd;
    private String monStart;
    private String monEnd;
    private String tuesStart;
    private String tuesEnd;
    private String wedStart;
    private String wedEnd;
    private String thursStart;
    private String thursEnd;
    
    int charCount = 0; // this variable is for character count when typing mobile number
    
    public DriverInfo() {
        initComponents();
        screenShowing();
    }
    
    
    private void screenShowing(){
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        //setSize(size.width/2, size.height/2 + 100);
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        
    }
    
    private void setDefault(){
        driverNameField.setText("");
        driverMobileField.setText("");
        
        driverImageField.setText("Upload Driver Image");
        licenseImageField.setText("Upload License Image");

    }
    
    /*******************************Image related******************************/
    //pic resize for upload
    private ImageIcon resizeImage(String imagePath, JPanel imagePanel){
        ImageIcon myImage = new ImageIcon(imagePath);
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(imagePanel.getWidth(), imagePanel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage = new ImageIcon(newImg);
        return finalImage;
    }
    
    private void convertToByteArrayDriver(String path){
        try{
            File image = new File(path);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            
            for(int readNum; (readNum = fis.read(buf))!=-1;){
                baos.write(buf, 0, readNum);
            }
            driverPicture = baos.toByteArray();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    private void convertToByteArrayLicense(String path){
        try{
            File image = new File(path);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            
            for(int readNum; (readNum = fis.read(buf))!=-1;){
                baos.write(buf, 0, readNum);
            }
            licensePicture = baos.toByteArray();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        driveByCombo = new javax.swing.JComboBox<>();
        driverNameField = new javax.swing.JTextField();
        driverMobileField = new javax.swing.JTextField();
        licenseImagePanel = new javax.swing.JPanel();
        licenseImageField = new javax.swing.JLabel();
        driverImagePanel = new javax.swing.JPanel();
        driverImageField = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        selectDriverImageButton = new javax.swing.JButton();
        selectLicenseImageButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AUST Parking Management System");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPanel.setBackground(new java.awt.Color(34, 56, 67));

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(204, 204, 204));
        titleLabel.setText("Driving Information");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Drive By:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Name:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Mobile:");

        driveByCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        driveByCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Driver", "Own", "Father", "Mother", "Brother", "Sister", " " }));

        driverNameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        driverMobileField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        driverMobileField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                driverMobileFieldKeyTyped(evt);
            }
        });

        licenseImagePanel.setBackground(new java.awt.Color(204, 204, 204));
        licenseImagePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        licenseImageField.setText("Upload License Image");
        licenseImagePanel.add(licenseImageField, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        driverImagePanel.setBackground(new java.awt.Color(204, 204, 204));
        driverImagePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        driverImageField.setText("Upload Driver Image");
        driverImagePanel.add(driverImageField, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        submitButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        backButton.setText("Cancel");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        selectDriverImageButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        selectDriverImageButton.setText("Select");
        selectDriverImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectDriverImageButtonActionPerformed(evt);
            }
        });

        selectLicenseImageButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        selectLicenseImageButton.setText("Select");
        selectLicenseImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectLicenseImageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(41, 41, 41)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(driveByCombo, 0, 270, Short.MAX_VALUE)
                            .addComponent(driverNameField)
                            .addComponent(driverMobileField))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(driverImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(licenseImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(selectDriverImageButton)
                        .addGap(91, 91, 91)
                        .addComponent(selectLicenseImageButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(submitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(titleLabel)
                .addGap(55, 55, 55)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(driveByCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(driverNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(driverMobileField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(licenseImagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(driverImagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(submitButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectDriverImageButton)
                    .addComponent(selectLicenseImageButton)
                    .addComponent(backButton))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectDriverImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectDriverImageButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.image", "jpg", "png", "jpeg");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        
        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            driverImageField.setText("");
            driverImageField.setIcon(resizeImage(path, driverImagePanel));
            convertToByteArrayDriver(path);
            isDriverImageSelected = true;
            System.out.println(driverPicture);
        }
        else if(result == JFileChooser.CANCEL_OPTION){
            driverImageField.setText("Upload Driver Image");
            System.out.println("No file selected");
            isDriverImageSelected = false;
        }
    }//GEN-LAST:event_selectDriverImageButtonActionPerformed

    private void selectLicenseImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectLicenseImageButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.image", "jpg", "png", "jpeg");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        
        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            licenseImageField.setText("");
            licenseImageField.setIcon(resizeImage(path, licenseImagePanel));
            convertToByteArrayLicense(path);
            isLicenseImageSelected = true;
            System.out.println(licensePicture);

        }
        else if(result == JFileChooser.CANCEL_OPTION){
            driverImageField.setText("Upload License Image");
            System.out.println("No file selected");
            isLicenseImageSelected = false;
        }
    }//GEN-LAST:event_selectLicenseImageButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure?");
        if(choice == 0){ //yes
            this.dispose();
            Home home = new Home();
            home.setVisible(true);
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        String driveBy = driveByCombo.getSelectedItem().toString();
        String driverName = driverNameField.getText();
        String driverMobile = driverMobileField.getText();
        
        if(driveBy.equals("None") || driverName.equals("") || driverMobile.equals("") || !isDriverImageSelected || !isLicenseImageSelected){
            JOptionPane.showMessageDialog(null, "Please fill up all the fields and select images");
        }else{
            ConnectDatabase connectDatabase = new ConnectDatabase();
            connectDatabase.ConnectDB();
            if(profession.equals("Teacher")){ // Teacher  
                connectDatabase.storePersonData(id, firstName, lastName, mobileNum, profession, dept, picture);
                connectDatabase.storeVehicleData(vehicleSerial, vehicleNumber, vehicleType, vehicleModel, vehicleColor, regDate, expiryDate, id);
                connectDatabase.storeDriverData(driveBy, driverName, driverMobile, driverPicture, licensePicture, id);
                
                System.out.println("OK");
                
                //generating barcode using person's ID
                BarcodeGenerate barcode = new BarcodeGenerate();
                barcode.createBarCode128(id);
            }
            else if(profession == "Student"){ // Student
                
                connectDatabase.storePersonData(id, firstName, lastName, mobileNum, profession, dept, picture);
                connectDatabase.storeVehicleData(vehicleSerial, vehicleNumber, vehicleType, vehicleModel, vehicleColor, regDate, expiryDate, id);
                connectDatabase.storeDriverData(driveBy, driverName, driverMobile, driverPicture, licensePicture, id);
                connectDatabase.storeSchedule(id, sunStart, sunEnd, monStart, monEnd, tuesStart, tuesEnd, wedStart, wedEnd, thursStart, thursEnd);
                
                System.out.println("OK");
                                
                //generating barcode using person's ID
                BarcodeGenerate barcode = new BarcodeGenerate();
                barcode.createBarCode128(id);
            }
            else if(profession == "Staff"){ // Staff
                
                connectDatabase.storePersonData(id, firstName, lastName, mobileNum, profession, dept, picture);
                connectDatabase.storeVehicleData(vehicleSerial, vehicleNumber, vehicleType, vehicleModel, vehicleColor, regDate, expiryDate, id);
                connectDatabase.storeDriverData(driveBy, driverName, driverMobile, driverPicture, licensePicture, id);
                System.out.println("OK");
                
                //generating barcode using person's ID
                BarcodeGenerate barcode = new BarcodeGenerate();
                barcode.createBarCode128(id);
            }
            else{
                System.out.println("Not OK");
            }
            
            connectDatabase.CloseDB();
            JOptionPane.showMessageDialog(null, "Successfully stored. Thank you");
            setDefault();

        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void driverMobileFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_driverMobileFieldKeyTyped
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
    }//GEN-LAST:event_driverMobileFieldKeyTyped

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
            java.util.logging.Logger.getLogger(DriverInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DriverInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DriverInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DriverInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DriverInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> driveByCombo;
    private javax.swing.JLabel driverImageField;
    private javax.swing.JPanel driverImagePanel;
    private javax.swing.JTextField driverMobileField;
    private javax.swing.JTextField driverNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel licenseImageField;
    private javax.swing.JPanel licenseImagePanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton selectDriverImageButton;
    private javax.swing.JButton selectLicenseImageButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
