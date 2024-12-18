import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.time.DayOfWeek;
// Ini mencakup BorderLayout dan komponen AWT lainnya


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Putra
 */
public class AplikasiPenghitunganHariframe extends javax.swing.JFrame {
      
    /**
     * Creates new form AplikasiPenghitunganHariframe
     */
    public AplikasiPenghitunganHariframe() {
       initComponents();
       initializeCustomComponents(); 
    }
    
    private void initializeCustomComponents() {
     
     
        
            // Menambahkan ActionListener pada tombol hitung
            calculateButton.addActionListener(e -> calculateDifference());
    
            // Menambahkan listener untuk memperbarui JCalendar saat JComboBox atau JSpinner berubah
            monthComboBox.addActionListener(e -> updateCalendarDate());
            yearSpinner.addChangeListener(e -> updateCalendarDate());
            
            // Menambahkan listener pada JCalendar untuk memperbarui JComboBox dan JSpinner
            Calendar1.addPropertyChangeListener("calendar", evt -> updateComboBoxAndSpinner());
    
             // Inisialisasi awal JCalendar
            updateCalendarDate();
    }
    
    private void updateCalendarDate() {
        int monthIndex = monthComboBox.getSelectedIndex(); // Indeks bulan dimulai dari 0
        int year = (Integer) yearSpinner.getValue(); // Mengambil nilai dari yearSpinner

        // Set tanggal pertama dari bulan dan tahun yang dipilih
        LocalDate selectedDate = LocalDate.of(year, monthIndex + 1, 1); 
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(java.util.Date.from(selectedDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));

        // Perbarui tanggal di JCalendar
        Calendar1.setCalendar(calendar);
    }
    
    private void updateComboBoxAndSpinner() {
        // Ambil tanggal yang dipilih dari JCalendar
        java.util.Date selectedDate = Calendar1.getDate();
        LocalDate localDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Perbarui JComboBox dan JSpinner
        monthComboBox.setSelectedIndex(localDate.getMonthValue() - 1); // Set bulan (indeks dimulai dari 0)
        yearSpinner.setValue(localDate.getYear()); // Set tahun
    }
    
    private String getDayInIndonesian(DayOfWeek dayOfWeek) {
    switch (dayOfWeek) {
        case MONDAY: return "Senin";
        case TUESDAY: return "Selasa";
        case WEDNESDAY: return "Rabu";
        case THURSDAY: return "Kamis";
        case FRIDAY: return "Jumat";
        case SATURDAY: return "Sabtu";
        case SUNDAY: return "Minggu";
        default: return ""; // Menambahkan return kosong untuk default
    }
}

    
    private void calculateDifference() {
        int monthIndex = monthComboBox.getSelectedIndex() + 1; // Month index starts from 0
        int year = (Integer) yearSpinner.getValue(); // Get value from yearSpinner

        LocalDate firstDay = LocalDate.of(year, monthIndex, 1);
        LocalDate lastDay = firstDay.withDayOfMonth(firstDay.lengthOfMonth());

        Date date1 = Calendar1.getDate();
        Date date2 = Calendar2.getDate();

        long diff = ChronoUnit.DAYS.between(
                date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        );

        // Check if the year is a leap year
        boolean isLeapYear = isLeapYear(year);

        // Update resultLabel with the results
        resultLabel.setText
               ("<html>Selisih hari  : " + Math.abs(diff) +
                "<br>Jumlah hari     : " + firstDay.lengthOfMonth() +
                "<br>Hari pertama    : " + getDayInIndonesian(firstDay.getDayOfWeek()) +
                "<br>Hari terakhir   : " + getDayInIndonesian(lastDay.getDayOfWeek()) +
                "<br>Tahun kabisat   : " + (isLeapYear ? "Ya" : "Tidak") + "</html>");
        this.revalidate();
        this.repaint();
    }
    
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        monthComboBox = new javax.swing.JComboBox<>();
        yearSpinner = new javax.swing.JSpinner();
        calculateButton = new javax.swing.JButton();
        Calendar1 = new com.toedter.calendar.JCalendar();
        Calendar2 = new com.toedter.calendar.JCalendar();
        resultLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Pilih Bulan");

        jLabel2.setText("Masukkan Tahun");

        monthComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));

        calculateButton.setText("Hitung");
        calculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateButtonActionPerformed(evt);
            }
        });

        resultLabel.setText("hasil");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setText("Aplikasi Penghitungan Hari");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Calendar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(26, 26, 26)
                                    .addComponent(calculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(yearSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(50, 50, 50)
                                    .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(63, 63, 63)
                            .addComponent(Calendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3))
                .addGap(113, 113, 113))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Calendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Calendar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(yearSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(calculateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateButtonActionPerformed
        initializeCustomComponents();// TODO add your handling code here:
    }//GEN-LAST:event_calculateButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AplikasiPenghitunganHariframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AplikasiPenghitunganHariframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AplikasiPenghitunganHariframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AplikasiPenghitunganHariframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AplikasiPenghitunganHariframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar Calendar1;
    private com.toedter.calendar.JCalendar Calendar2;
    private javax.swing.JButton calculateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> monthComboBox;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JSpinner yearSpinner;
    // End of variables declaration//GEN-END:variables
}
