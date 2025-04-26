/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import javax.swing.*;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author zoemariechor
 */
public class login extends javax.swing.JFrame {

    // Constructor for the login class
    public login() {
        initComponents();
        createUserFile();
        createConsultationFile();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        registerButtonLogin = new javax.swing.JButton();
        LoginButtonLogin = new javax.swing.JButton();
        IDInputLogin = new javax.swing.JTextField();
        PWInputLogin = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Big Caslon", 0, 18)); // NOI18N
        jLabel1.setText("APU Psychology Consultation");

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("ID:");

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Password:");

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("No account? Click here to");

        registerButtonLogin.setText("Register");
        registerButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonLoginActionPerformed(evt);
            }
        });

        LoginButtonLogin.setText("Login");
        LoginButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonLoginActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Silom", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 153));
        jLabel6.setText("APU");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(34, 34, 34)
                                    .addComponent(jLabel3)
                                    .addGap(31, 31, 31)
                                    .addComponent(PWInputLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(registerButtonLogin)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(77, 77, 77)
                                .addComponent(IDInputLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(LoginButtonLogin)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDInputLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(PWInputLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(registerButtonLogin))
                .addGap(27, 27, 27)
                .addComponent(LoginButtonLogin)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonLoginActionPerformed
        register registerPage = new register(); 
        registerPage.setVisible(true); 
        this.dispose(); 
    }//GEN-LAST:event_registerButtonLoginActionPerformed

    private void LoginButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonLoginActionPerformed
        String enteredId = IDInputLogin.getText(); 
        String enteredPassword = new String(PWInputLogin.getPassword()); 
        String role = validateLogin(enteredId, enteredPassword);

        if (role != null) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            this.dispose(); 
            if (role.equals("ST")) {
                new studentDashboard(enteredId).setVisible(true); 
            } else if (role.equals("LT")) {
                new lecturerDashboard(enteredId).setVisible(true); 
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid ID or Password. Please try again.");
        }

    }//GEN-LAST:event_LoginButtonLoginActionPerformed
    
    // Validates the login credentials (ID and password) by reading "user.txt" file.
    private String validateLogin(String enteredId, String enteredPassword) {
        try (BufferedReader br = new BufferedReader(new FileReader("user.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length >= 4) {
                    String storedId = userData[0];
                    String storedPassword = userData[2];
                    String role = userData[3]; 
                    if (storedId.equals(enteredId) && storedPassword.equals(enteredPassword)) {
                        return role; 
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading user file: " + e.getMessage());
        }
        return null; 
    }
       
    // Retrieves the role of a user based on their ID by reading the "user.txt" file.
    private String getUserRole(String userId) {
        try {
            File file = new File("user.txt");
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] userDetails = line.split(",");
                    if (userDetails[0].equals(userId)) {
                        scanner.close();
                        return userDetails[3]; 
                    }
                }
            }
            return null;
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    // Creates the "user.txt" file if it does not already exist.
    private void createUserFile() {
        try {
            File file = new File("user.txt");
            if (!file.exists()) {
                file.createNewFile();  
                System.out.println("user.txt file created.");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "An error occurred while creating user.txt file.");
        }
    }

    // Creates the "consultation.txt" file with a header row if it does not exist.
    public static void createConsultationFile() {
        File file = new File("consultation.txt");

        if (!file.exists()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write("ConsultationID,LecturerID,StudentID,Date,Time,Status,LecturerFeedback,StudentFeedback,RescheduleID");
                writer.newLine(); 
                System.out.println("Consultation file created successfully.");
            } catch (IOException e) {
                System.out.println("An error occurred while creating the consultation file: " + e.getMessage());
            }
        } else {
            System.out.println("Consultation file already exists.");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDInputLogin;
    private javax.swing.JButton LoginButtonLogin;
    private javax.swing.JPasswordField PWInputLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton registerButtonLogin;
    // End of variables declaration//GEN-END:variables
}
