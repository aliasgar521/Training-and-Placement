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
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ali
 */
public class TPO_student_details extends javax.swing.JFrame {
 Connection conn =null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    /**
     * Creates new form TPO_student_details
     */
    int tpo_id;
    int dep_id;
    public TPO_student_details(Integer tpo) {
        initComponents();
        setDefaultCloseOperation(TPO_student_details.HIDE_ON_CLOSE);
        tpo_id=tpo;
        conn = MySqlConnect.ConnectDB();
    String Sql="select d_id from TPO where tpo_id='"+tpo_id+"'";
    try{
        pst=conn.prepareStatement(Sql);
        rs=pst.executeQuery();
        rs.next();
        //System.out.println(rs.getString(1));
        System.out.println(rs.getInt(1));
        dep_id=rs.getInt(1);
        
    }
     catch(Exception e){
       // JOptionPane.showMessageDialog(null, e);
    }
       // jLabel1.setText("Your TPO ID is "+rs.getInt(2));
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
 public ArrayList<TPO_student_details_Java> getStudentList()
   {
       ArrayList<TPO_student_details_Java> studentList = new ArrayList<TPO_student_details_Java>();
       Connection connection = getConnection();
       
       String query = "SELECT * FROM  `student_view3` where d_id = '"+dep_id+"' and active=1";
       Statement st;
       ResultSet rs;

       try 
       {
           st = connection.createStatement();
           rs = st.executeQuery(query);
           TPO_student_details_Java user;
           while(rs.next())
           {
               user = new TPO_student_details_Java(rs.getString("fname"),rs.getInt("stu_id"),rs.getInt("FE"),rs.getInt("SE"),rs.getInt("TE"),rs.getString("username"),rs.getDate("academic_year").toString());//
               
               studentList.add(user);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return studentList;
   }
    public void Show_Student_In_JTable()
   {
       ArrayList<TPO_student_details_Java> list1 = getStudentList();
       DefaultTableModel model = (DefaultTableModel)jTable_studentInfo.getModel();
       Object[] row = new Object[7];
       for(int i = 0; i < list1.size(); i++)
       {
           
           row[0] = list1.get(i).getstu_id();
           row[1] = list1.get(i).getname();
           row[2] = list1.get(i).getfe();
           row[3] = list1.get(i).getse();
           row[4] = list1.get(i).gette();
           row[5] = list1.get(i).getusername();
           row[6] = list1.get(i).getacad_year();
           
           
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

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_studentInfo = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setLayout(null);

        jTable_studentInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "FE marks", "SE marks", "TE marks", "Student Username", "Student Acad_Year"
            }
        ));
        jScrollPane1.setViewportView(jTable_studentInfo);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(20, 40, 880, 130);

        jButton1.setText("Show Table");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(330, 180, 230, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon("/home/ali/Downloads/blue6.jpg")); // NOI18N
        jPanel3.add(jLabel1);
        jLabel1.setBounds(-20, 0, 940, 230);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Show_Student_In_JTable();
            // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(TPO_student_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TPO_student_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TPO_student_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TPO_student_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            //                new TPO_student_details().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_studentInfo;
    // End of variables declaration//GEN-END:variables
}
