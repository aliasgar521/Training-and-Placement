/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test4;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ali
 */
public class TPO_file extends javax.swing.JFrame {
    Connection conn =null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    /**
     * Creates new form TPO_file
     */
    String username;
    Integer tpo_id;
    Integer p_id;
    public TPO_file(String Username) throws SQLException {
        initComponents();
        username=Username;
        
              conn = MySqlConnect.ConnectDB();
    String Sql="select * from tpo_view1 where username='"+username+"'";
    try{
        pst=conn.prepareStatement(Sql);
        rs=pst.executeQuery();
        rs.next();
        System.out.println(rs.getString(1));
        System.out.println(rs.getInt(2));
        tpo_id=rs.getInt(2);
        p_id=rs.getInt(3);
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
        setDefaultCloseOperation(TPO_file.HIDE_ON_CLOSE);
        jLabel1.setText("Your TPO ID is "+rs.getInt(2));
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
    
    public void executeSQlQuery(String query, String message)
   {
       Connection con = getConnection();
       Statement st;
       try{
           st = con.createStatement();
           if((st.executeUpdate(query)) == 1)
           {
               // refresh jtable data
            //   DefaultTableModel model = (DefaultTableModel)jTable_display.getModel();
              // model.setRowCount(0);
               
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
    public ArrayList<tpo_file> getLoginList()
   {
       ArrayList<tpo_file> usersList = new ArrayList<tpo_file>();
       Connection connection = getConnection();
       
      // String query = "SELECT * FROM  `person` ";
       String query1 = "select login.username,tpo_id from person,login,TPO where login.username=person.username and person.p_id=TPO.p_id";
       Statement st;
       ResultSet rs;
       String username;
       Integer tpo_id;
       try 
       {
           st = connection.createStatement();
           rs = st.executeQuery(query1);
           tpo_file user;
           while(rs.next())
           {
               //user = new Register1(rs.getString("p_id"),rs.getString("fname"),rs.getString("lname"),rs.getString("email"),rs.getString("phone"),rs.getString("gender"),rs.getString("city"),rs.getString("street"));//,rs.getString("flat"),rs.getInt("pincode"));
              // user = new tpo_file(rs.getString("username"),rs.getInt("tpo_id"));
               //usersList.add(user);
               username=rs.getString("username");
               tpo_id=rs.getInt("tpo_id");
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return usersList;
   }
   public ArrayList<company1> getCompanyList()
   {
       ArrayList<company1> usersList = new ArrayList<company1>();
       Connection connection = getConnection();
       
       String query = "SELECT * FROM  `company` ";
       Statement st;
       ResultSet rs;

       try 
       {
           st = connection.createStatement();
           rs = st.executeQuery(query);
           company1 user;
           while(rs.next())
           {
               user = new company1(rs.getInt("comp_id"),rs.getString("co_name"),rs.getString("type"));//,rs.getString("flat"),rs.getInt("pincode"));
               
               usersList.add(user);
              
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return usersList;
   }
    public void Show_Company_In_JTable()
   {
       ArrayList<company1> list = getCompanyList();
       DefaultTableModel model = (DefaultTableModel)jTable_company.getModel();
       Object[] row = new Object[3];
       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getcompid();
           row[1] = list.get(i).getcompname();
           row[2] = list.get(i).gettype();
           
           
           model.addRow(row);
       }
    }
  
     public ArrayList<schedule1> getScheduleList()
   {
       ArrayList<schedule1> scheduleList = new ArrayList<schedule1>();
       Connection connection = getConnection();
       
       String query = "SELECT * FROM  `sch` where tpo_id='"+tpo_id+"' and active=1";
       Statement st;
       ResultSet rs;

       try 
       {
           st = connection.createStatement();
           rs = st.executeQuery(query);
           schedule1 user;
           while(rs.next())
           {
               user = new schedule1(rs.getInt("sch_id"),rs.getDate("sch_date").toString(),rs.getInt("comp_id"),rs.getString("co_name"),rs.getInt("criteria"),rs.getInt("min_salary"));//,rs.getString("flat"),rs.getInt("pincode"));
               
               scheduleList.add(user);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return scheduleList;
   }
    public void Show_Schedule_In_JTable()
   {
       ArrayList<schedule1> list1 = getScheduleList();
       DefaultTableModel model = (DefaultTableModel)jTable_schedule.getModel();
       Object[] row = new Object[6];
       for(int i = 0; i < list1.size(); i++)
       {
           row[0] = list1.get(i).getschid();
           row[1] = list1.get(i).getschdate();
           row[2] = list1.get(i).getcompid();
           row[3] = list1.get(i).getconame();
           row[4] = list1.get(i).getcriteria();
           row[5] = list1.get(i).getminsalary();
           
           
           model.addRow(row);
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_company = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_schedule = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 153, 51));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel1);
        jLabel1.setBounds(0, 10, 539, 47);

        jTable_company.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Company ID", "Company Name", "Type"
            }
        ));
        jScrollPane1.setViewportView(jTable_company);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(10, 60, 560, 120);

        jTable_schedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Schedule ID", "Schedule Date", "Company ID", "Company", "Criteria", "Min Salary"
            }
        ));
        jScrollPane3.setViewportView(jTable_schedule);

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(10, 200, 560, 118);

        jLabel2.setIcon(new javax.swing.ImageIcon("/home/ali/Downloads/blue3.jpg")); // NOI18N
        jPanel3.add(jLabel2);
        jLabel2.setBounds(0, 0, 580, 340);

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 255));

        jMenu1.setText("Company");
        jMenu1.setToolTipText("");

        jMenuItem2.setText("Company Details");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Company Register");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Schedule");

        jMenuItem4.setText("Schedule Details");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Schedule Register");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Student");

        jMenuItem6.setText("Student Details");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem7.setText("Appearing Students");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Alumini");

        jMenuItem8.setText("Recruited Students");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuBar1.add(jMenu4);

        jMenu7.setText("Report");

        jMenuItem10.setText("View Department wise");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem10);

        jMenuItem11.setText("View Company wise");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem11);

        jMenuItem12.setText("View Year wise");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem12);

        jMenuBar1.add(jMenu7);

        jMenu5.setText("Edit");

        jMenuItem1.setText("Edit Profile");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("More..");
        jMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu6ActionPerformed(evt);
            }
        });

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setText("Logout");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem9);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            new update(p_id).setVisible(true);
            this.setVisible(true);
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(TPO_file.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        this.setVisible(true);
        new company().setVisible(true);
            

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
         Show_Company_In_JTable();
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
            this.setVisible(true);
            new Schedule().setVisible(true);
    
    
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Show_Schedule_In_JTable();
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
       this.setVisible(true);
        new TPO_student_details(tpo_id).setVisible(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        this.setVisible(true);
        new TPO_students_schedule(tpo_id).setVisible(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6ActionPerformed
        
    }//GEN-LAST:event_jMenu6ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        this.dispose();
        try {
            new Login().setVisible(true);
            // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(TPO_file.class.getName()).log(Level.SEVERE, null, ex);
        }
            // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        new alumni(tpo_id).setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        new Report1().setVisible(true);
        
            // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        new Report().setVisible(true);
            // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
    new alumni(tpo_id).setVisible(true);
    // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem12ActionPerformed

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
            java.util.logging.Logger.getLogger(TPO_file.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TPO_file.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TPO_file.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TPO_file.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // try {
                //    new TPO_file().setVisible(true);
               // }// catch (SQLException ex) {
                 //   Logger.getLogger(TPO_file.class.getName()).log(Level.SEVERE, null, ex);
               // }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable_company;
    private javax.swing.JTable jTable_schedule;
    // End of variables declaration//GEN-END:variables
}
