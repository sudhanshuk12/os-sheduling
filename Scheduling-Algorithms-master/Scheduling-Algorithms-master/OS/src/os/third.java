package os;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class third extends javax.swing.JFrame {

    public third() {
        initComponents();
    }
    float smallwait = 0, smalltat = 0;
    int flagfcfs = 0, flagsrtf = 0, flagltf = 0, flagrr = 0, flagpr = 0;
    float wait[] = new float[5];
    float tat[] = new float[5];

    public third(float fcfswait, float fcfstat, float srtfwait, float srtftat, float ltfwait, float ltftat, float rrwait, float rrtat,float prwait,float prtat) {
        initComponents();
        String resultfcfs = String.format("%.2f", fcfswait);
        String resultfcfs2 = String.format("%.2f", fcfstat);
        FCFSwait.setText("Average waiting time: " + resultfcfs);
        FCFSturnaround.setText("Average turnaround time: " + resultfcfs2);
        String resultsrtf = String.format("%.2f", srtfwait);
        String resultsrtf2 = String.format("%.2f", srtftat);
        SRTFwait.setText("Average waiting time: " + resultsrtf);
        SRTFturnaround.setText("Average turnaround time: " + resultsrtf2);
        String resultltf = String.format("%.2f", ltfwait);
        String resultltf2 = String.format("%.2f", ltftat);
        LTFwait.setText("Average waiting time: " + resultltf);
        LTFturnaround.setText("Average turnaround time: " + resultltf2);
        String resultrr = String.format("%.2f", rrwait);
        String resultrr2 = String.format("%.2f", rrtat);
        RRwait.setText("Average waiting time: " + resultrr);
        RRturnaround.setText("Average turnaround time: " + resultrr2);
        String resultpr = String.format("%.2f", prwait);
        String resultpr2 = String.format("%.2f", prtat);
        PRwait.setText("Average waiting time: " + resultpr);
        PRturnaround.setText("Average turnaround time: " + resultpr2);

        if (fcfswait < srtfwait && fcfswait < ltfwait && fcfswait < rrwait && fcfswait<prwait) {
            smallwait = fcfswait;
            flagfcfs = 1;
        }
        if (srtfwait < fcfswait && srtfwait < ltfwait && srtfwait < rrwait && srtfwait<prwait) {
            smallwait = srtfwait;
            flagsrtf = 1;
        }
        if (ltfwait < srtfwait && ltfwait < fcfswait && ltfwait < rrwait && ltfwait<prwait) {
            smallwait = ltfwait;
            flagltf = 1;
        }
        if (rrwait < srtfwait && rrwait < ltfwait && rrwait < fcfswait && rrwait<prwait) {
            smallwait = rrwait;
            flagrr = 1;
        }
         if (prwait < srtfwait && prwait < ltfwait && prwait < fcfswait && prwait<rrwait) {
            smallwait = prwait;
            flagpr = 1;
        }

        if (fcfstat < srtftat && fcfstat < ltftat && fcfstat < rrtat && fcfstat<prtat) {
            smalltat = fcfstat;
        }
        if (srtftat < fcfstat && srtftat < ltftat && srtftat < rrtat && srtftat<prtat) {
            smalltat = srtftat;
        }
        if (ltftat < srtftat && ltftat < fcfstat && ltftat < rrtat && ltftat<prtat) {
            smalltat = ltftat;
        }
        if (rrtat < srtftat && rrtat < ltftat && rrtat < fcfstat && rrtat<prtat) {
            smalltat = rrtat;
        }
         if (prtat < srtftat && prtat < ltftat && prtat < fcfstat && prtat<rrtat) {
            smalltat = prtat;
        }
         String result1 = String.format("%.2f", smallwait);
         String result2 = String.format("%.2f", smalltat);
        bestwait.setText("Average waiting time: " + result1);
        bestturnaround.setText("Average turnaround time: " + result2);
        if (flagfcfs == 1) {
            best.setText("Best choice: First come first serve algorithm");
        }
        if (flagsrtf == 1) {
            best.setText("Best choice: Shortest remaining time first algorithm");
        }
        if (flagltf == 1) {
            best.setText("Best choice: Longest time first algorithm");
        }
        if (flagrr == 1) {
            best.setText("Best choice: Round robin algorithm");
        }
        if (flagpr == 1) {
            best.setText("Best choice: Priority algorithm");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scheduling = new javax.swing.JLabel();
        rr = new javax.swing.JLabel();
        ltf = new javax.swing.JLabel();
        FCFSwait = new javax.swing.JLabel();
        fcfs = new javax.swing.JLabel();
        FCFSturnaround = new javax.swing.JLabel();
        SRTFwait = new javax.swing.JLabel();
        srtf = new javax.swing.JLabel();
        SRTFturnaround = new javax.swing.JLabel();
        LTFwait = new javax.swing.JLabel();
        LTFturnaround = new javax.swing.JLabel();
        best = new javax.swing.JLabel();
        bestwait = new javax.swing.JLabel();
        bestturnaround = new javax.swing.JLabel();
        RRwait = new javax.swing.JLabel();
        RRturnaround = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        pr = new javax.swing.JLabel();
        main = new javax.swing.JButton();
        PRwait = new javax.swing.JLabel();
        PRturnaround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(179, 106, 217));

        scheduling.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        scheduling.setText("SCHEDULING");

        rr.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rr.setText("Round robin");

        ltf.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ltf.setText("Longest remaining time first");

        FCFSwait.setText("AVG waiting time");

        fcfs.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fcfs.setText("First come first serve");

        FCFSturnaround.setBackground(new java.awt.Color(179, 106, 217));
        FCFSturnaround.setText("AVG turnaround time");

        SRTFwait.setText("AVG waiting time");

        srtf.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        srtf.setText("Shortest remaining time first");

        SRTFturnaround.setText("AVG turnaround time");

        LTFwait.setText("AVG waiting time");

        LTFturnaround.setText("AVG turnaround time");

        best.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        best.setText("Best choice");

        bestwait.setText("AVG waiting time");

        bestturnaround.setText("AVG turnaround time");

        RRwait.setText("AVG waiting time");

        RRturnaround.setText("AVG turnaround time");

        exit.setBackground(new java.awt.Color(216, 135, 17));
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        pr.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pr.setText("Priority");

        main.setBackground(new java.awt.Color(216, 135, 17));
        main.setText("Return");
        main.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainActionPerformed(evt);
            }
        });

        PRwait.setText("AVG waiting time");

        PRturnaround.setText("AVG turnaround time");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(srtf, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                    .addComponent(rr, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fcfs)
                                    .addComponent(best)
                                    .addComponent(ltf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(RRwait, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(LTFturnaround, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(LTFwait, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(SRTFturnaround, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(SRTFwait, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(FCFSturnaround, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(FCFSwait, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(bestturnaround, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bestwait, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(PRwait, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(PRturnaround, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(RRturnaround, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(scheduling, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pr, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1358, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scheduling, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FCFSwait, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fcfs, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FCFSturnaround, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(srtf, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SRTFwait, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SRTFturnaround, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ltf, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LTFwait, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LTFturnaround, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rr, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RRwait, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RRturnaround, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(PRwait, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PRturnaround, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bestwait, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bestturnaround, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(pr, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(best, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(369, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(613, 654));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "Confirm exit");
        if (a == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitActionPerformed

    private void mainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainActionPerformed
        this.setVisible(false);
        new choose().setVisible(true);
    }//GEN-LAST:event_mainActionPerformed
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
            java.util.logging.Logger.getLogger(third.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(third.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(third.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(third.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new third().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FCFSturnaround;
    private javax.swing.JLabel FCFSwait;
    private javax.swing.JLabel LTFturnaround;
    private javax.swing.JLabel LTFwait;
    private javax.swing.JLabel PRturnaround;
    private javax.swing.JLabel PRwait;
    private javax.swing.JLabel RRturnaround;
    private javax.swing.JLabel RRwait;
    private javax.swing.JLabel SRTFturnaround;
    private javax.swing.JLabel SRTFwait;
    private javax.swing.JLabel best;
    private javax.swing.JLabel bestturnaround;
    private javax.swing.JLabel bestwait;
    private javax.swing.JButton exit;
    private javax.swing.JLabel fcfs;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel ltf;
    private javax.swing.JButton main;
    private javax.swing.JLabel pr;
    private javax.swing.JLabel rr;
    private javax.swing.JLabel scheduling;
    private javax.swing.JLabel srtf;
    // End of variables declaration//GEN-END:variables
}
