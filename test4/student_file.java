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
public class student_file extends javax.swing.JFrame {

    /**
     * Creates new form student_file
     */
    Connection conn =null;
    Connection conn1 =null;
    PreparedStatement pst1=null;
    PreparedStatement pst=null;

    ResultSet rs=null;
    ResultSet rs1=null;
   
    String username;
    Integer stud_id;
    Integer dep_id;
    Integer tpo_id;
    Integer p_id;
    Integer marks;
    public student_file(String Username) throws SQLException {
        initComponents();
        setDefaultCloseOperation(Register_schedule.HIDE_ON_CLOSE);
        username=Username;
                  conn = MySqlConnect.ConnectDB();
    String Sql="select * from student_view2 where username='"+username+"'";
    try{
        pst=conn.prepareStatement(Sql);
        rs=pst.executeQuery();
        rs.next();
       // System.out.println(rs.getString(1));
        System.out.println(rs.getInt(1));
        stud_id=rs.getInt(1);
        dep_id=rs.getInt(6);
        p_id=rs.getInt(7);
        //JOptionPane.showMessageDialog(null, dep_id);
        String abc="select tpo_id from TPO where d_id='"+dep_id+"'";
        
            pst=conn.prepareStatement(abc);
            rs1=pst.executeQuery();
            rs1.next();
            tpo_id=rs1.getInt(1);
            System.out.println(rs1.getInt(1));
            //JOptionPane.showMessageDialog(null, tpo_id);
        
        
            
        
        
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
        jLabel2.setText("Your Student ID is "+rs.getInt(1));
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
     public ArrayList<schedule1> getScheduleList()
   {
       ArrayList<schedule1> scheduleList = new ArrayList<schedule1>();
       Connection connection = getConnection();
       
      // String query = "SELECT * FROM  `schedule`";
       String query1= "select * from sch,TPO where TPO.d_id= '"+dep_id+"' and sch.tpo_id = '"+tpo_id+"' and active=1";
               //select sch_id,sch_date from schedule,TPO,student where student.d_id=TPO.d_id and schedule.tpo_id=TPO.tpo_id
       
       Statement st;
       ResultSet rs;

       try 
       {
           st = connection.createStatement();
           rs = st.executeQuery(query1);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_schedule = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setLayout(null);

        jLabel2.setBackground(new java.awt.Color(255, 153, 51));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(jLabel2);
        jLabel2.setBounds(0, 20, 680, 31);

        jTable_schedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Schedule ID", "Schedule Date", "Company ID", "Company Name", "Criteria", "Minimum Salary"
            }
        ));
        jScrollPane1.setViewportView(jTable_schedule);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(0, 70, 690, 110);

        jLabel1.setIcon(new javax.swing.ImageIcon("/home/ali/Downloads/blue3.jpg")); // NOI18N
        jPanel4.add(jLabel1);
        jLabel1.setBounds(-10, 0, 700, 260);

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 255));

        jMenu1.setText("Register");

        jMenuItem1.setText("View Schedule");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Register Schedule");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem3.setText("Edit Profile");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("More..");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Logout");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Show_Schedule_In_JTable();
            // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            new update(p_id).setVisible(true);        // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(student_file.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
      /*  String abc="SELECT `TE` from student where stu_id = '"+stud_id+"'";
        try {
            pst=conn.prepareStatement(abc);
            rs=pst.executeQuery();
            rs.next();
            marks=rs.getInt(1);
            JOptionPane.showMessageDialog(null, marks);
        } catch (SQLException ex) {
            Logger.getLogger(student_file.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        */
        new Register_schedule(stud_id).setVisible(true);
        this.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        this.dispose();
        try {
            new Login().setVisible(true);
            // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(student_file.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
            java.util.logging.Logger.getLogger(student_file.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(student_file.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(student_file.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(student_file.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new student_file().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_schedule;
    // End of variables declaration//GEN-END:variables
}