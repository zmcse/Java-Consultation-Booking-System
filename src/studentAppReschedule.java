
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author zoemariechor
 */
public class studentAppReschedule extends javax.swing.JFrame {
    private String studentID; 

    //Constructor for studentAppReschedule class.
    public studentAppReschedule(String studentID) {
        this.studentID = studentID; 
        initComponents();
        loadRescheduleData();
    }
    
    // Load pending/reschedule data for the logged-in student.
    private void loadRescheduleData() {
        DefaultListModel<String> pendingModel = new DefaultListModel<>();
        File file = new File("consultation.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 6) {
                    String consultationStudentID = parts[2].trim();
                    String status = parts[5].trim();

                    if (consultationStudentID.equals(studentID)) {
                        String lecturerID = parts[1].trim(); 
                        String lecturerName = getName(lecturerID); 

                        String consultationDetails = "ID: " + parts[0] + ", Lecturer: " + lecturerName + " (" + lecturerID + ")" + 
                                                     ", Date: " + parts[3] + ", Time: " + parts[4];

                        if (status.equalsIgnoreCase("Pending") || status.equalsIgnoreCase("Reschedule")) {
                            pendingModel.addElement(consultationDetails + " (" + status + ")");
                        }
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading consultations: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        PendingListSAR.setModel(pendingModel);
    }
    
    // Get lecturer name from user file using lecturer ID.
    private String getName(String lecturerID) {
        String name = "Unknown Lecturer"; 
        File file = new File("user.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts[0].trim().equals(lecturerID)) {
                    name = parts[1].trim(); 
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading user file.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return name;
    }

    // Process acceptance or rejection of a reschedule request.
    private void processRequest(String consultationID, boolean isAccepted) {
        File file = new File("consultation.txt");
        StringBuilder newContent = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(consultationID)) {
                    if (isAccepted) {
                        parts[5] = "Booked"; 
                    } else if (parts[5].equalsIgnoreCase("Pending") || parts[5].equalsIgnoreCase("Reschedule")) {
                        parts[5] = "Available"; 
                    }
                    line = String.join(",", parts); 
                }
                newContent.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error processing request: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(newContent.toString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing to file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        loadRescheduleData();
    }

    // Update slot status for a specific date and time.
    private void updateSlotStatus(String date, String time, String currentStatus, String newStatus) {
        File file = new File("consultation.txt");
        StringBuilder newContent = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[3].equals(date) && parts[4].equals(time) && parts[5].trim().equalsIgnoreCase(currentStatus)) {
                    parts[5] = newStatus; 
                    line = String.join(",", parts); 
                }
                newContent.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error updating slot status: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        try (java.io.FileWriter writer = new java.io.FileWriter(file)) {
            writer.write(newContent.toString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing to file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Process acceptance or rejection of a pending request.
    private void processPendingRequest(String consultationID, boolean isAccepted) {
        File file = new File("consultation.txt");
        StringBuilder newContent = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(consultationID)) {
                    if (isAccepted) {
                        String rescheduleID = parts[0] + "_R" + System.currentTimeMillis();
                        parts[8] = rescheduleID; 
                        parts[5] = "Reschedule"; 
                    } else {
                        if (parts[5].equalsIgnoreCase("Pending")) {
                            parts[5] = "Available"; 
                        } else if (parts[5].equalsIgnoreCase("Reschedule")) {
                            parts[5] = "Booked"; 
                            parts[8] = " ";
                        }
                    }
                    line = String.join(",", parts); 
                }
                newContent.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error processing pending request: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(newContent.toString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing to file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        loadRescheduleData(); 
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UpButtonSAR = new javax.swing.JButton();
        HistoryButtonSAR = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PendingListSAR = new javax.swing.JList<>();
        DBButtonSAR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        UpButtonSAR.setText("Upcoming");
        UpButtonSAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpButtonSARActionPerformed(evt);
            }
        });

        HistoryButtonSAR.setText("History");
        HistoryButtonSAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoryButtonSARActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Big Caslon", 0, 18)); // NOI18N
        jLabel1.setText("Reschedules");

        jScrollPane1.setViewportView(PendingListSAR);

        DBButtonSAR.setText("Dashboard");
        DBButtonSAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DBButtonSARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(DBButtonSAR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UpButtonSAR)
                        .addGap(18, 18, 18)
                        .addComponent(HistoryButtonSAR))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel1)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpButtonSAR)
                    .addComponent(HistoryButtonSAR)
                    .addComponent(DBButtonSAR))
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UpButtonSARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpButtonSARActionPerformed
        studentMyAppointment studentMyAppointment = new studentMyAppointment(studentID); 
        studentMyAppointment.setVisible(true); 
        this.dispose();
    }//GEN-LAST:event_UpButtonSARActionPerformed

    private void DBButtonSARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DBButtonSARActionPerformed
        studentDashboard studentDashboard = new studentDashboard(studentID);
        studentDashboard.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_DBButtonSARActionPerformed

    private void HistoryButtonSARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoryButtonSARActionPerformed
        studentAppHistory studentAppHistory = new studentAppHistory(studentID); 
        studentAppHistory.setVisible(true); 
        this.dispose(); 
    }//GEN-LAST:event_HistoryButtonSARActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new studentAppReschedule("defaultID").setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DBButtonSAR;
    private javax.swing.JButton HistoryButtonSAR;
    private javax.swing.JList<String> PendingListSAR;
    private javax.swing.JButton UpButtonSAR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
