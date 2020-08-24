/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spotlight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ugur
 */
public class toplist extends javax.swing.JFrame {

    /**
     * Creates new form toplist
     */
    private timeline golist;
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public toplist(timeline goliste) {
        this.golist=goliste;
        initComponents();
        Following();
    }

    private toplist() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void Following(){
       try {
           
        Connection cd;
            cd = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotlight?useUnicode=true&characterEncoding=UTF-8", "ugur", "1905");
        Statement st = (Statement) cd.createStatement();
        try(ResultSet rs = st.executeQuery("SELECT COUNT(`transaction`) AS Followers,`userid` FROM `followers` GROUP BY `userid` ORDER BY COUNT(`transaction`) DESC")) { //connect to database table
            int colcount = rs.getMetaData().getColumnCount(); 
            DefaultTableModel tm = new DefaultTableModel(); 
            for(int i = 1;i<=colcount;i++)
                tm.addColumn(rs.getMetaData().getColumnName(i)); 
            while(rs.next())
                {
                    Object[] row = new Object[colcount];				
                    for(int i=1;i<=colcount;i++)
                        row[i-1] = rs.getObject(i);						
                    tm.addRow(row);
                }
            plnewstable.setModel(tm);
        }
        cd.close();     														
    } catch (SQLException ex) {     
            Logger.getLogger(toplist.class.getName()).log(Level.SEVERE, null, ex);
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
        plnewspane = new javax.swing.JScrollPane();
        plnewstable = new javax.swing.JTable();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setOpaque(false);

        plnewspane.setOpaque(false);

        plnewstable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
            }
        ));
        plnewstable.setCellSelectionEnabled(true);
        plnewstable.setMaximumSize(new java.awt.Dimension(4124, 2313));
        plnewstable.setMinimumSize(new java.awt.Dimension(500, 500));
        plnewstable.setPreferredSize(new java.awt.Dimension(500, 500));
        plnewstable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plnewstableMouseClicked(evt);
            }
        });
        plnewspane.setViewportView(plnewstable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(plnewspane, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(plnewspane, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(435, 150, 790, 520);

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spotlight/9.jpg"))); // NOI18N
        getContentPane().add(back);
        back.setBounds(0, 0, 1060, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void plnewstableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plnewstableMouseClicked
        boolean b= plnewstable.isEditing();
        if(b==false){
            JOptionPane.showMessageDialog(null,"You can't edit the news.");
        }
    }//GEN-LAST:event_plnewstableMouseClicked

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
back.setSize(this.getSize());         // TODO add your handling code here:
    }//GEN-LAST:event_formComponentResized

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
            java.util.logging.Logger.getLogger(toplist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(toplist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(toplist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(toplist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new toplist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane plnewspane;
    private javax.swing.JTable plnewstable;
    // End of variables declaration//GEN-END:variables
}
