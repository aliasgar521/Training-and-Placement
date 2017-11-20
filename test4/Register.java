/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test4;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ali
 */
public final class Register extends javax.swing.JFrame {
    Connection conn =null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    private Pattern pattern;
    private Matcher matcher;
    
    
    public Register() {
        initComponents();
       // Show_Users_In_JTable();
     
       Show_Login_In_JTable();
    }
    public static boolean valPhone(String in)
    {
        return in.length()==10 && in.matches("[0-9]+");
    }
    public static boolean valPincode(String in)
    {
        return in.length()==6 && in.matches("[0-9]+");
    }
    public static boolean valemail(String in)
    {
        boolean status=false;
        String email_pattern="^[_A-Za-z0-9]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9-]+)*(\\.[A-za-z0-9]{2,})$";
        
        Pattern pattern=Pattern.compile(email_pattern);
        Matcher matcher=pattern.matcher(in);
        
        if(matcher.matches())
        {
            status=true;
        }
        else{
            status=false;
        }
        return status;
    }

     public Connection getConnection()
   {
       Connection con;
       try {
           con = DriverManager.getConnection("jdbc:mysql://localhost/test5?autoReconnect=true&useSSL=false", "root","95752468aliasgar");
          
           return con;
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
   }
public ArrayList<Register1> getLoginList()
   {
       ArrayList<Register1> usersList = new ArrayList<Register1>();
       Connection connection = getConnection();
       
       String query = "SELECT * FROM  `person` ";
       Statement st;
       ResultSet rs;

       try 
       {
           st = connection.createStatement();
           rs = st.executeQuery(query);
           Register1 user;
           while(rs.next())
           {
               user = new Register1(rs.getString("p_id"),rs.getString("fname"),rs.getString("lname"),rs.getString("email"),rs.getString("phone"),rs.getString("gender"),rs.getString("city"),rs.getString("street"));//,rs.getString("flat"),rs.getInt("pincode"));
               
               usersList.add(user);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return usersList;
   }
public void Show_Login_In_JTable()
   {
       ArrayList<Register1> list = getLoginList();
       DefaultTableModel model = (DefaultTableModel)jTable_display.getModel();
       Object[] row = new Object[3];
       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getpid();
           row[1] = list.get(i).getfname();
           row[2] = list.get(i).getlname();
           
           
           model.addRow(row);
       }
    }
//public void display_person() throws SQLException{
//    String selectSQL="SELECT fname,lname,email,dob,phone,gender,city,street,flat,pincode from person where p_id="+jTextField_pid.getText();
//    Connection conn=getConnection();
//    PreparedStatement ps =conn.prepareStatement(selectSQL);
//    ResultSet rs=ps.executeQuery();
//    try{
//        while(rs.next()) {
//            jTextField_fname.setText(rs.getString("fname"));
//            jTextField_lname.setText(rs.getString("lname"));
//            jTextField_city.setText(rs.getString("city"));
//            jTextField_email.setText(rs.getString("email"));
//            jTextField_flat.setText(rs.getString("flat"));
//            jTextField_phone.setText(rs.getString("phone"));
//            jTextField_pincode.setText(rs.getString("pincode"));
//            
//        }
//    }catch(SQLException e1){
//                e1.printStackTrace();
//                }finally {
//                         ps.close();
//                        conn.close();
//                        }
//    }
//
/*public void Show_Login_In_JTable()
   {
       ArrayList<Login> list = getLoginList();
       DefaultTableModel model = (DefaultTableModel)jTable1_user.getModel();
       Object[] row = new Object[4];
       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getUserName();
           row[1] = list.get(i).getEmailId();
           row[2] = list.get(i).getPassword();
           row[3] = list.get(i).getId();
           
           model.addRow(row);
       }
    }*/
public void executeSQlQuery(String query, String message)
   {
       Connection con = getConnection();
       Statement st;
       try{
           st = con.createStatement();
           if((st.executeUpdate(query)) == 1)
           {
               // refresh jtable data
               DefaultTableModel model = (DefaultTableModel)jTable_display.getModel();
               model.setRowCount(0);
               
//               Show_Users_In_JTable();
             // Show_Login_In_JTable();
               JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");
           }
           else
           {
               JOptionPane.showMessageDialog(null, "Data Not "+message);
           }
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
       }
   }
//public static boolean isValidEmailAddress(String email) {
//   boolean result = true;
//   try {
//      InternetAddress emailAddr = new InternetAddress(email);
//      emailAddr.validate();
//   } catch (AddressException ex) {
//      result = false;
//   }
//   return result;
//}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField_fname = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField_lname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField_email = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        jLabel4 = new javax.swing.JLabel();
        jTextField_phone = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBox_gender = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTextField_city = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField_street = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField_flat = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField_pincode = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_display = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jTextField_username = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jComboBox_tpo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(null);

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Personal Information");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(40, 0, 282, 41);

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("First Name");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(20, 60, 100, 17);

        jTextField_fname.setToolTipText("");
        jPanel2.add(jTextField_fname);
        jTextField_fname.setBounds(20, 80, 100, 30);

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Middle Name");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(130, 60, 100, 17);
        jPanel2.add(jTextField1);
        jTextField1.setBounds(130, 80, 100, 30);

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Last Name");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(250, 60, 82, 17);

        jTextField_lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_lnameActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField_lname);
        jTextField_lname.setBounds(250, 80, 97, 30);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("E-mail :");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 140, 70, 17);

        jTextField_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_emailActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField_email);
        jTextField_email.setBounds(150, 130, 191, 30);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DOB :");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 180, 44, 17);

        dateChooserCombo1.setCalendarPreferredSize(new java.awt.Dimension(350, 280));
        dateChooserCombo1.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dateChooserCombo1OnCommit(evt);
            }
        });
        jPanel2.add(dateChooserCombo1);
        dateChooserCombo1.setBounds(150, 170, 191, 30);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Phone No :");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 220, 87, 17);
        jPanel2.add(jTextField_phone);
        jTextField_phone.setBounds(150, 210, 191, 30);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Gender : ");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(20, 260, 75, 17);

        jComboBox_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jComboBox_gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_genderActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox_gender);
        jComboBox_gender.setBounds(150, 250, 190, 24);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("City : ");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 300, 46, 17);
        jPanel2.add(jTextField_city);
        jTextField_city.setBounds(150, 290, 191, 30);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Street :");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(20, 350, 60, 17);
        jPanel2.add(jTextField_street);
        jTextField_street.setBounds(150, 340, 191, 30);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Flat No :");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(20, 400, 65, 17);
        jPanel2.add(jTextField_flat);
        jTextField_flat.setBounds(150, 390, 191, 30);

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Pincode : ");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(20, 450, 79, 17);

        jTextField_pincode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_pincodeActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField_pincode);
        jTextField_pincode.setBounds(150, 440, 191, 30);

        jTable_display.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "P-ID", "First Name", "Last Name"
            }
        ));
        jScrollPane2.setViewportView(jTable_display);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(360, 70, 275, 260);

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(10, 490, 340, 10);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Username : ");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(20, 510, 96, 17);
        jPanel2.add(jTextField_username);
        jTextField_username.setBounds(190, 500, 149, 30);

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Password : ");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(20, 560, 94, 17);
        jPanel2.add(jPasswordField);
        jPasswordField.setBounds(190, 550, 149, 30);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Re-enter Password : ");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(20, 610, 168, 17);
        jPanel2.add(jPasswordField2);
        jPasswordField2.setBounds(190, 600, 149, 30);

        jComboBox_tpo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TPO", "Student" }));
        jComboBox_tpo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_tpoActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox_tpo);
        jComboBox_tpo.setBounds(20, 660, 139, 30);

        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(250, 660, 66, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon("/home/ali/Downloads/blue5.jpg")); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 360, 770);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_lnameActionPerformed

    private void jComboBox_genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_genderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_genderActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      //  int pp= Integer.parseInt(jTextField_pid.getText());
     // String query1;
     
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        String date = formater.format(dateChooserCombo1.getSelectedDate().getTime());
       // SimpleDateFormat df = new SimpleDateFormat("yyyy");
        //String year = formater.format(dateChooserCombo1.getSelectedDate().getTime().getYear());
        //int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
        int year = Integer.parseInt(date.split("-")[0]); 
        String mobile=jTextField_phone.getText();
        String email=jTextField_email.getText();
        String pincode=jTextField_pincode.getText();
        /*if(!(Pattern.matches(" ", jTextField_fname.getText()))){
            JOptionPane.showMessageDialog(null, "First name can NOT be empty");
        }*/
        if(!(Pattern.matches("[a-zA-Z ,]+", jTextField_fname.getText()))){
            JOptionPane.showMessageDialog(null, "First name can only have alphabets");
            jTextField_fname.requestFocusInWindow();
        }
        else if(!(Pattern.matches("[a-zA-Z ,]+", jTextField_lname.getText()))){
           JOptionPane.showMessageDialog(null, "Last name can only have alphabets"); 
           jTextField_lname.requestFocusInWindow();
        }
        else if(valemail(email)==false){
             JOptionPane.showMessageDialog(null,"Email Incorrect!");
             jTextField_email.requestFocusInWindow();
        }
        else if(valPhone(mobile)==false){
             JOptionPane.showMessageDialog(null,"Mobile Number Incorrect!");
             jTextField_phone.requestFocusInWindow();
        }
        else if(valPincode(pincode)==false){
            JOptionPane.showMessageDialog(null,"Pincode Incorrect!");
            jTextField_pincode.requestFocusInWindow();
        }
        else if(!(Pattern.matches("^[a-zA-Z0-9@._]+$",jTextField_username.getText()))){
                        JOptionPane.showMessageDialog(null,"Invalid Username! Choose another Ussername","Error",JOptionPane.ERROR_MESSAGE);
                        jTextField_username.requestFocusInWindow();
        }
        else if(jPasswordField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Password cannot be Empty","Error",JOptionPane.ERROR_MESSAGE);
            jPasswordField.requestFocusInWindow();
        }
        else if(!(jPasswordField2.getText()).equals((jPasswordField.getText()))){
            JOptionPane.showMessageDialog(null,"Passwords do not match","Error",JOptionPane.ERROR_MESSAGE);            
            jPasswordField2.requestFocusInWindow();
        }
        //JOptionPane.showMessageDialog(null, year);
//        
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = format.parse(dateChooserCombo1.getSelectedDate());
        //SimpleDateFormat df = new SimpleDateFormat("yyyy");
        //year = df.format(date);
        
        
        //String s=""+date;
        //String d1=""+dateChooserCombo1.getSelectedDate();
        
        //Show_Login_In_JTable();
        else {
        if(jComboBox_tpo.getSelectedItem()=="TPO")
        { 
               /* if(valPhone(mobile)==true && valemail(email)==true && valPincode(pincode)==true){
                    if(!(Pattern.matches("^[a-zA-Z0-9@._]+$",jTextField_username.getText()))){
                        JOptionPane.showMessageDialog(null,"Invalid Username! Choose another Ussername","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else if(jPasswordField.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null,"Password cannot be Empty","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else if(!(jPasswordField2.getText()).equals((jPasswordField.getText()))){
                        JOptionPane.showMessageDialog(null,"Passwords do not match","Error",JOptionPane.ERROR_MESSAGE);
                    
                    }
                    else{*/
                    String query2 = "INSERT INTO `login`(`username`,`password`,`id`) VALUES ('"+jTextField_username.getText()+"','"+jPasswordField.getText()+"','"+"1"+"')";
                    executeSQlQuery(query2,"insert");
                    String query1 = "INSERT INTO `person`(`fname`,`lname`,`email`,`phone`,`city`,`street`,`flat`,`gender`,`pincode`,`username`,`dob`) VALUES ('" +jTextField_fname.getText()+"','"+jTextField_lname.getText()+"','"+jTextField_email.getText()+"','"+jTextField_phone.getText()+"','"+jTextField_city.getText()+"','"+jTextField_street.getText()+"','"+jTextField_flat.getText()+"','"+jComboBox_gender.getSelectedItem()+"','"+jTextField_pincode.getText()+"','"+jTextField_username.getText()+"','"+date+"')";
                    executeSQlQuery(query1,"insert");                
                    this.dispose();
                    new tpo_register(jTextField_email.getText()).setVisible(true);
                    //}
                }
              /*  else if(valemail(email)==false)
                {
                    JOptionPane.showMessageDialog(null,"Email Incorrect!");
                }
                else if(valPhone(mobile)==false){
                    JOptionPane.showMessageDialog(null,"Mobile Number Incorrect!");
                }
                else if(valPincode(pincode)==false){
                    JOptionPane.showMessageDialog(null,"Pincode Incorrect!");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Data not Inserted!");
                }*/
             //String query3 = "SELECT * from `person`";
             //ResultSet rs1;
             //tpo_register obj = new tpo_register();
             //Statement st1=conn.createStatement();
             //rs1=st1.executeQuery(query3);
             //System.out.println(rs1.getInt(1));
             //obj.getDataFromLogin(rs1.getInt(1));
                
                
                
            
            
        
        else if(jComboBox_tpo.getSelectedItem()=="Student")
        {
            if(valPhone(mobile)==true && valemail(email)==true){
                String query2 = "INSERT INTO `login`(`username`,`password`,`id`) VALUES ('"+jTextField_username.getText()+"','"+jPasswordField.getText()+"','"+"0"+"')";
                executeSQlQuery(query2,"insert");
                String query1 = "INSERT INTO `person`(`fname`,`lname`,`email`,`phone`,`city`,`street`,`flat`,`gender`,`pincode`,`username`,`dob`) VALUES ('" +jTextField_fname.getText()+"','"+jTextField_lname.getText()+"','"+jTextField_email.getText()+"','"+jTextField_phone.getText()+"','"+jTextField_city.getText()+"','"+jTextField_street.getText()+"','"+jTextField_flat.getText()+"','"+jComboBox_gender.getSelectedItem()+"','"+jTextField_pincode.getText()+"','"+jTextField_username.getText()+"','"+date+"')";
                executeSQlQuery(query1,"insert");
                this.dispose();
                new student_register(jTextField_email.getText()).setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null,"Not Validated!");
            }
        }
//      String query1 = "INSERT INTO `Person`(`f_name`, `m_name`, `l_name`,`address`,`Dept_name`) VALUES ('"+jTextField_f_name.getText()+"','"+jTextField_m_name.getText()+"','"+jTextField_l_name.getText()+"','"+jTextField_address.getText()+"','"+jComboBox1_deptname.getSelectedItem()+"')";   
        
        
        //
            // TODO add your handling code here:
                }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox_tpoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_tpoActionPerformed
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_tpoActionPerformed

    private void dateChooserCombo1OnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dateChooserCombo1OnCommit
        // TODO add your handling code here:
    }//GEN-LAST:event_dateChooserCombo1OnCommit

    private void jTextField_pincodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_pincodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_pincodeActionPerformed

    private void jTextField_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_emailActionPerformed
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_emailActionPerformed

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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox_gender;
    private javax.swing.JComboBox<String> jComboBox_tpo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable_display;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField_city;
    private javax.swing.JTextField jTextField_email;
    private javax.swing.JTextField jTextField_flat;
    private javax.swing.JTextField jTextField_fname;
    private javax.swing.JTextField jTextField_lname;
    private javax.swing.JTextField jTextField_phone;
    private javax.swing.JTextField jTextField_pincode;
    private javax.swing.JTextField jTextField_street;
    private javax.swing.JTextField jTextField_username;
    // End of variables declaration//GEN-END:variables
}
