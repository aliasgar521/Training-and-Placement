/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ali
 */
public class alumni extends javax.swing.JFrame {
Connection conn =null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    int year;
    String year1;
   // String year1;
    /**
     * Creates new form alumni
     */
    int tpo_id;
    int dep_id;
    public alumni(Integer tpo) {
        initComponents();
        setDefaultCloseOperation(alumni.HIDE_ON_CLOSE);
        tpo_id=tpo;
        conn = MySqlConnect.ConnectDB();
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
    public ArrayList<alumni_java> getAlumniList(String year)
   {
       ArrayList<alumni_java> alumniList = new ArrayList<alumni_java>();
       Connection connection = getConnection();
       
       String query = "select cand_id,fname,sch.co_name,designation,package,candidate.sch_id,candidate.stu_id from candidate,student,person,sch where candidate.stu_id=student.stu_id and sch.sch_id=candidate.sch_id and person.p_id=student.p_id and year(academic_year)='"+year+"'";
       String query1 = "select cand_id,fname,sch.co_name,designation,package,candidate.sch_id,candidate.stu_id from candidate,student,person,sch where candidate.stu_id=student.stu_id and sch.sch_id=candidate.sch_id and person.p_id=student.p_id ";
       
       Statement st;
       ResultSet rs=null;

       try 
       {
           st = connection.createStatement();
           String cba=jComboBox1.getSelectedItem().toString();
          // JOptionPane.showMessageDialog(null,(String) jComboBox1.getSelectedItem());
          
         /* if(cba=="2010" || cba=="2011" || cba=="2012" || cba=="2013" || cba=="2014" ||cba=="2015" || cba=="2016" || cba=="2017"){
            rs = st.executeQuery(query);
          }
          else if (cba=="All_Years"){
            rs = st.executeQuery(query1);
          }
          */
         
          if(cba=="2010" || cba=="2011" || cba=="2012" || cba=="2013" || cba=="2014" ||cba=="2015" || cba=="2016" || cba=="2017"){
               rs = st.executeQuery(query);
           }
           
           alumni_java user;
           while(rs.next())
           {
               user = new alumni_java(rs.getInt("cand_id"),rs.getString("fname"),rs.getString("co_name"),rs.getString("designation"),rs.getString("package"),rs.getInt("sch_id"),rs.getInt("stu_id"));//
               
               alumniList.add(user);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return alumniList;
   }
    public void Show_Alumni_In_JTable(String year)
   {
       ArrayList<alumni_java> list1 = getAlumniList(year);
       DefaultTableModel model = (DefaultTableModel)jTable_alumni.getModel();
       Object[] row = new Object[7];
//       DefaultTableModel dm = (DefaultTableModel)table.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
       for(int i = 0; i < list1.size(); i++)
       {
           row[0] = list1.get(i).getID();
           row[1] = list1.get(i).getname();
           row[2] = list1.get(i).getcomp();
           row[3] = list1.get(i).getdes();
           row[4] = list1.get(i).getpack();
           row[5] = list1.get(i).getscID();
           row[6] = list1.get(i).getstid();
           
           model.addRow(row);
       }
    }

    
    
    public ArrayList<alumni_java> getAlumni1List() throws SQLException
   {
       ArrayList<alumni_java> alumniList = new ArrayList<alumni_java>();
       Connection connection = getConnection();
       
        String query1 = "select cand_id,fname,sch.co_name,designation,package,candidate.sch_id,candidate.stu_id from candidate,student,person,sch where candidate.stu_id=student.stu_id and sch.sch_id=candidate.sch_id and person.p_id=student.p_id order by cand_id";
       
       Statement st;
       ResultSet rs=null;

       
           st = connection.createStatement();
          
            rs = st.executeQuery(query1);
          
          
         
           
           alumni_java user;
           while(rs.next())
           {
               user = new alumni_java(rs.getInt("cand_id"),rs.getString("fname"),rs.getString("co_name"),rs.getString("designation"),rs.getString("package"),rs.getInt("sch_id"),rs.getInt("stu_id"));//
               
               alumniList.add(user);
           }
       
       
       return alumniList;
   }
    public void Show_Alumni1_In_JTable() throws SQLException
   {
       ArrayList<alumni_java> list1 = getAlumni1List();
       DefaultTableModel model = (DefaultTableModel)jTable_alumni.getModel();
       Object[] row = new Object[7];
//       DefaultTableModel dm = (DefaultTableModel)table.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
       for(int i = 0; i < list1.size(); i++)
       {
           row[0] = list1.get(i).getID();
           row[1] = list1.get(i).getname();
           row[2] = list1.get(i).getcomp();
           row[3] = list1.get(i).getdes();
           row[4] = list1.get(i).getpack();
           row[5] = list1.get(i).getscID();
           row[6] = list1.get(i).getstid();
           
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_alumni = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Academic Year : ");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(90, 30, 230, 29);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017" }));
        jComboBox1.setToolTipText("");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(360, 30, 216, 30);

        jTable_alumni.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Candidate ID", "First Name", "Company", "Designation", "Package", "Schedule ID", "Student ID"
            }
        ));
        jScrollPane1.setViewportView(jTable_alumni);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 80, 670, 118);

        jButton1.setText("Display All Years");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(230, 210, 210, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon("/home/ali/Downloads/blue6.jpg")); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, 0, 690, 270);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
        Show_Alumni1_In_JTable();
//        Show_Alumni_In_JTable();
// Show_Alumni_In_JTable(year);
// TODO add your handling code here:
    } catch (SQLException ex) {
        Logger.getLogger(alumni.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       // if (jComboBox1.getSelectedItem()=="2012"){
            year=Integer.parseInt(jComboBox1.getSelectedItem().toString());
            year1=(jComboBox1.getSelectedItem().toString());
           // Show_Student_In_JTable(year1);
            // year1=jComboBox1.getSelectedItem().toString();
            //JOptionPane.showMessageDialog(null,year);
            
           // jTable_alumni.fireTableDataChanged();
            Show_Alumni_In_JTable(year1);
            //Show_Alumni_In_JTable(year1);
       // }
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed
    
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
            java.util.logging.Logger.getLogger(alumni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(alumni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(alumni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(alumni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new alumni().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_alumni;
    // End of variables declaration//GEN-END:variables
}
