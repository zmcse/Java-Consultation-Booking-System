/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author zoemariechor
 */
public class profile extends javax.swing.JFrame {
    private String userID; 
    
    //Constructor for profile class.
    public profile(String userID) {
        this.userID = userID; 
        initComponents();
        loadUserData(); 
    }

    // Load user data from 'user.txt' based on the 'userID' and display the user's name.
    private void loadUserData() {
        IDdisplayMP.setText(userID); 
        try (Scanner scanner = new Scanner(new File("user.txt"))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                if (parts[0].equals(userID)) { 
                    NameInputMP.setText(parts[1]); 
                    break;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading user data!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Update user details (name and password) in 'user.txt'.
    private void updateUserDetails() {
        String newName = NameInputMP.getText().trim();
        String currentPassword = new String(CPWInputMP.getPassword());
        String newPassword = new String(NPWInputMP.getPassword());

        List<String> lines = new ArrayList<>();
        boolean passwordMatched = false;

        try (Scanner scanner = new Scanner(new File("user.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                if (parts[0].equals(userID)) {
                    if (!parts[2].equals(currentPassword)) { 
                        JOptionPane.showMessageDialog(this, "Current password is incorrect!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    passwordMatched = true;

                    if (!newName.isEmpty()) parts[1] = newName;
                    if (!newPassword.isEmpty()) parts[2] = newPassword;

                    line = String.join(",", parts);
                }
                lines.add(line);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading file!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (passwordMatched) {
            try (PrintWriter writer = new PrintWriter(new FileWriter("user.txt"))) {
                for (String updatedLine : lines) {
                    writer.println(updatedLine);
                }
                JOptionPane.showMessageDialog(this, "Profile updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error updating file!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // Retrieve the role of the user based on 'userID' from 'user.txt'.
    private String getUserRole(String userID) {
        String role = "";
        try (Scanner scanner = new Scanner(new File("user.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(","); 

                if (parts[0].equals(userID)) { 
                    role = parts[3]; 
                    break;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading user file!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return role; 
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        IDdisplayMP = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NameInputMP = new javax.swing.JTextField();
        CPWInputMP = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        NPWInputMP = new javax.swing.JPasswordField();
        UpdateButtonMP = new javax.swing.JButton();
        DBButtonMP = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Big Caslon", 0, 18)); // NOI18N
        jLabel1.setText("My Profile");

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("ID:");

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Name:");

        NameInputMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameInputMPActionPerformed(evt);
            }
        });

        CPWInputMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPWInputMPActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Current Password:");

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("New Password:");

        NPWInputMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NPWInputMPActionPerformed(evt);
            }
        });

        UpdateButtonMP.setText("Update");
        UpdateButtonMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonMPActionPerformed(evt);
            }
        });

        DBButtonMP.setText("Dashboard");
        DBButtonMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DBButtonMPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(NameInputMP, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(UpdateButtonMP))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(DBButtonMP)
                                        .addGap(70, 70, 70)))
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(CPWInputMP)
                                        .addComponent(NPWInputMP, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                    .addComponent(IDdisplayMP, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel1)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(DBButtonMP)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(IDdisplayMP, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(NameInputMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CPWInputMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(NPWInputMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(UpdateButtonMP)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NameInputMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameInputMPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameInputMPActionPerformed

    private void CPWInputMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPWInputMPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CPWInputMPActionPerformed

    private void NPWInputMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NPWInputMPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NPWInputMPActionPerformed

    private void UpdateButtonMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonMPActionPerformed
        updateUserDetails();
    }//GEN-LAST:event_UpdateButtonMPActionPerformed

    private void DBButtonMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DBButtonMPActionPerformed
        String role = getUserRole(userID); // Retrieve the user's role based on their userID

        if ("LT".equals(role)) {
            lecturerDashboard lecturerDashboard = new lecturerDashboard(userID);
            lecturerDashboard.setVisible(true);
        } else if ("ST".equals(role)) {
            studentDashboard studentDashboard = new studentDashboard(userID);
            studentDashboard.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Error: User role not found!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.dispose(); 
    }//GEN-LAST:event_DBButtonMPActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }

        String userID = "ST123"; 
        java.awt.EventQueue.invokeLater(() -> new profile(userID).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField CPWInputMP;
    private javax.swing.JButton DBButtonMP;
    private javax.swing.JLabel IDdisplayMP;
    private javax.swing.JPasswordField NPWInputMP;
    private javax.swing.JTextField NameInputMP;
    private javax.swing.JButton UpdateButtonMP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
