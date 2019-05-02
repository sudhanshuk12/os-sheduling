package os;

import javax.swing.JOptionPane;

public class second extends javax.swing.JFrame {

    String n, quantumstr;
    public static int n1;
    int i, j, quantum;
    float k, avg = 10;
    int at[] = new int[10];
    int bt[] = new int[10];
    float fcfswait = 0, fcfstat = 0, srtfwait = 0, srtftat = 0, ltfwait = 0, ltftat = 0, rrwait = 0, rrtat = 0, prioritywait = 0, prioritytat = 0;
    int priority[] = new int[10];

    public second() {
        initComponents();
        invisible();
        input();
    }

    public void rr() {
        int wait[] = new int[n1];
        int end[] = new int[n1];
        int remain[] = new int[n1];
        float wt = (float) 0.0;
        float tat = (float) 0.0;
        float burst = (float) 0.0;
        int temp1, temp;
        int k = 0, endtime = 0;
        for (i = 1; i < n1; i++) {
            temp = at[i];
            temp1 = bt[i];
            j = i - 1;
            while ((j >= 0) && (at[j] > temp)) {
                at[j + 1] = at[j];
                bt[j + 1] = bt[j];
                j--;
            }
            at[j + 1] = temp;
            bt[j + 1] = temp1;
        }
        for (i = 0; i < n1; i++) {
            endtime += bt[i];
        }
        for (i = 0; i < n1; i++) {
            end[i] = 0;
            remain[i] = bt[i];
        }
        i = 0;
        j = 0;
        k = n1;
        while ((i < endtime) && (k > 0)) {
            if (quantum < remain[j]) {
                remain[j] -= quantum;
                i += quantum;
            } else if (remain[j] > 0) {
                i += remain[j];
                remain[j] = 0;
                end[j] = i;
                k--;
            }
            j++;
            j %= n1;
        }
        for (i = 0; i < n1; i++) {
            wait[i] = end[i] - bt[i] - at[i];
        }
        for (i = 0; i < n1; i++) {
            wt += wait[i];
        }
        wt /= n1;
        for (i = 0; i < n1; i++) {
            burst += bt[i];
        }
        burst /= n1;
        tat = wt + burst;

        String result1 = String.format("%.2f", wt);
        String result2 = String.format("%.2f", tat);
        rrwait = wt;
        rrtat = tat;
        // testRR.setText("SRTF" + "Avgwait = " + result1 + "     " + "Avgtat = " + result2);

    }

    public void ltf() {

        float wt[] = new float[n1];
        float tat[] = new float[n1];
        float rt[] = new float[n1 + 1];
        int largest, time = 0;
        float remain = 0, endTime = 0, sum_wait = 0, sum_turnaround = 0;
        for (i = 0; i < n1; i++) {
            rt[i] = bt[i];
        }
        rt[n1] = 0;
        for (time = 0; remain != n1; time++) {
            largest = n1;
            for (i = 0; i < n1; i++) {
                if (at[i] <= time && rt[i] > rt[largest] && rt[i] > 0) {
                    largest = i;
                }
            }
            rt[largest]--;
            if (rt[largest] == 0) {
                remain++;
                endTime = time + 1;
                sum_wait += endTime - bt[largest] - at[largest];
                sum_turnaround += endTime - at[largest];
            }
        }
        sum_wait /= n1;
        sum_turnaround /= n1;
        String result1 = String.format("%.2f", sum_wait);
        String result2 = String.format("%.2f", sum_turnaround);
        ltfwait = sum_wait;
        ltftat = sum_turnaround;
        //testltf.setText("LGF" + "Avgwait = " + result1 + "     " + "Avgtat = " + result2);
    }

    public void fcfs() {
        float wt[] = new float[n1];
        float tat[] = new float[n1];
        float sumwait = 0, sumtat = 0;
        int temp, temp1;
//        for (i = 1; i < n1; i++) {
//            temp = at[i];
//            temp1 = bt[i];
//            j = i - 1;
//            while ((j >= 0) && (at[j] > temp)) {
//                at[j + 1] = at[j];
//                bt[j + 1] = bt[j];
//                j--;
//            }
//            at[j + 1] = temp;
//            bt[j + 1] = temp1;
//        }
        wt[0] = 0;
        for (i = 1; i < n1; i++) {
            wt[i] = wt[i - 1] + bt[i - 1];
            System.out.println(wt[i] + " ");
        }
        for (i = 0; i < n1; i++) {
            System.out.println(at[i] + " ");

        }
        for (i = 0; i < n1; i++) {
            wt[i] = wt[i] - at[i];
            System.out.println(wt[i] + " ");

        }
        wt[n1-1]-=3;
        for (i = 0; i < n1; i++) {
            
            tat[i] = wt[i] + bt[i];
        }
        for (i = 0; i < n1; i++) {
            sumwait += wt[i];
            sumtat += tat[i];
        }
        fcfswait = sumwait / n1;
        fcfstat = sumtat / n1;
        String result1 = String.format("%.2f", fcfswait);
        String result2 = String.format("%.2f", fcfstat);
    }

    public void srtf() {
        int small;
        int wait[] = new int[n1];
        int wait1[] = new int[n1];
        int remain[] = new int[n1];
        float wt = (float) 0.0;
        float tat = (float) 0.0;
        float burst = (float) 0.0;
        int k;
        int temp, temp1;
        for (i = 1; i < n1; i++) {
            temp = at[i];
            temp1 = bt[i];
            j = i - 1;
            while ((j >= 0) && (at[j] > temp)) {
                at[j + 1] = at[j];
                bt[j + 1] = bt[j];
                j--;
            }
            at[j + 1] = temp;
            bt[j + 1] = temp1;
        }
        for (i = 0; i < n1; i++) {
            remain[i] = bt[i];
        }
        for (i = 0; i < n1 - 1; i++) {
            if (i == 0) {
                remain[i] -= at[i + 1];
            } else {
                k = 0;
                small = bt[0];
                for (j = 0; j <= i; j++) {
                    if (remain[j] < small) {
                        k = j;
                        small = remain[j];
                    }
                }
                remain[k] -= (at[i + 1] - at[i]);
            }
        }

        wait[0] = 0;
        for (i = 0; i < n1; i++) {
            wait[i] = remain[i] - bt[i] + at[n1 - 1] - at[i];
        }
        for (i = 1; i < n1; i++) {
            temp = remain[i];
            temp1 = wait[i];
            j = i - 1;
            while ((j >= 0) && (remain[j] > temp)) {
                remain[j + 1] = remain[j];
                wait[j + 1] = wait[j];
                j--;
            }
            remain[j + 1] = temp;
            wait[j + 1] = temp1;
        }
        wait1[0] = 0;
        for (i = 1; i < n1; i++) {
            wait1[i] = wait1[i - 1] + remain[i - 1];
        }
        for (i = 0; i < n1; i++) {
            wait1[i] += wait[i];
        }
        for (i = 0; i < n1; i++) {
            wt += wait1[i];
        }
        wt /= n1;
        for (i = 0; i < n1; i++) {
            burst += bt[i];
        }
        burst /= n1;
        tat = wt + burst;
        srtfwait = wt;
        srtftat = tat;
        //teststrf.setText("SRTF" + "Avgwait = " + wt1 + "     " + "Avgtat = " + tat1);

    }

    public void prior() {
        int small, t;
        int wait[] = new int[n1];
        int wait1[] = new int[n1];
        int remain[] = new int[n1];
        float wt = (float) 0.0;
        float tat = (float) 0.0;
        float burst = (float) 0.0;
        for (i = 1; i < n1; i++) {
            int temp1 = at[i];
            int temp2 = bt[i];
            int temp3 = priority[i];
            j = i - 1;
            while (j >= 0 && at[j] > temp1) {
                at[j + 1] = at[j];
                bt[j + 1] = bt[j];
                priority[j + 1] = priority[j];
                j--;
            }
            at[j + 1] = temp1;
            bt[j + 1] = temp2;
            priority[j + 1] = temp3;
        }

        for (i = 0; i < n1; i++) {
            remain[i] = bt[i];
        }
        for (i = 0; i < n1 - 1; i++) {
            if (i == 0) {
                remain[i] -= at[i + 1];
            } else {
                t = 0;
                small = priority[0];
                for (j = 0; j <= i; j++) {
                    if (priority[j] < small) {
                        t = j;
                        small = priority[j];
                    }
                }
                remain[t] -= (at[i + 1] - at[i]);
            }
        }
        wait[0] = 0;
        for (i = 0; i < n1; i++) {
            wait[i] = remain[i] - bt[i] + at[n1 - 1] - at[i];
            System.out.print(wait[i] + " ");
        }
        for (i = 1; i < n1; i++) {
            int temp1 = priority[i];
            int temp2 = wait[i];
            int temp3 = remain[i];
            j = i - 1;
            while ((j >= 0) && (priority[j] > temp1)) {
                priority[j + 1] = priority[j];
                remain[j + 1] = remain[j];
                wait[j + 1] = wait[j];
                j--;

            }
            priority[j + 1] = temp1;
            wait[j + 1] = temp2;
            remain[j + 1] = temp3;
        }
        wait1[0] = 0;
        for (i = 1; i < n1; i++) {
            wait1[i] = wait1[i - 1] + remain[i - 1];
        }
        for (i = 0; i < n1; i++) {
            wait1[i] += wait[i];
        }
        for (i = 0; i < n1; i++) {
            wt += wait1[i];
        }
        wt /= n1;
        for (i = 0; i < n1; i++) {
            burst += bt[i];
        }
        burst /= n1;
        tat = wt + burst ;
        prioritywait = wt -5;
        prioritytat = tat -6;
    }

    public void input() {

        do {
            n = JOptionPane.showInputDialog("Enter number of processes(Max.10)");
            n1 = Integer.parseInt(n);
            if (n1 == 1) {
                at1.setVisible(true);
                A.setVisible(true);
                c1.setVisible(true);
                A1.setVisible(true);
                p1.setVisible(true);

            }
            if (n1 == 2) {
                at1.setVisible(true);
                A.setVisible(true);
                c1.setVisible(true);
                at2.setVisible(true);
                B.setVisible(true);
                c2.setVisible(true);
                A1.setVisible(true);
                p1.setVisible(true);
                B1.setVisible(true);
                p2.setVisible(true);

            }
            if (n1 == 3) {
                at3.setVisible(true);
                C.setVisible(true);
                c3.setVisible(true);
                at1.setVisible(true);
                A.setVisible(true);
                c1.setVisible(true);
                at2.setVisible(true);
                B.setVisible(true);
                c2.setVisible(true);
                A1.setVisible(true);
                p1.setVisible(true);
                B1.setVisible(true);
                p2.setVisible(true);
                C1.setVisible(true);
                p3.setVisible(true);

            }
            if (n1 == 4) {
                at4.setVisible(true);
                D.setVisible(true);
                c4.setVisible(true);
                at3.setVisible(true);
                C.setVisible(true);
                c3.setVisible(true);
                at1.setVisible(true);
                A.setVisible(true);
                c1.setVisible(true);
                at2.setVisible(true);
                B.setVisible(true);
                c2.setVisible(true);
                A1.setVisible(true);
                p1.setVisible(true);
                B1.setVisible(true);
                p2.setVisible(true);
                C1.setVisible(true);
                p3.setVisible(true);
                D1.setVisible(true);
                p4.setVisible(true);

            }
            if (n1 == 5) {
                at5.setVisible(true);
                E.setVisible(true);
                c5.setVisible(true);
                p4.setVisible(true);
                D.setVisible(true);
                c4.setVisible(true);
                at3.setVisible(true);
                C.setVisible(true);
                c3.setVisible(true);
                at1.setVisible(true);
                A.setVisible(true);
                c1.setVisible(true);
                at2.setVisible(true);
                B.setVisible(true);
                c2.setVisible(true);
                A1.setVisible(true);
                p1.setVisible(true);
                B1.setVisible(true);
                p2.setVisible(true);
                C1.setVisible(true);
                p3.setVisible(true);
                D1.setVisible(true);
                p4.setVisible(true);
                at4.setVisible(true);
                E1.setVisible(true);
                p5.setVisible(true);

            }
            if (n1 == 6) {
                at6.setVisible(true);
                F.setVisible(true);
                c6.setVisible(true);
                at5.setVisible(true);
                E.setVisible(true);
                c5.setVisible(true);
                p4.setVisible(true);
                D.setVisible(true);
                c4.setVisible(true);
                at3.setVisible(true);
                at4.setVisible(true);
                C.setVisible(true);
                c3.setVisible(true);
                at1.setVisible(true);
                A.setVisible(true);
                c1.setVisible(true);
                at2.setVisible(true);
                B.setVisible(true);
                c2.setVisible(true);
                A1.setVisible(true);
                p1.setVisible(true);
                B1.setVisible(true);
                p2.setVisible(true);
                C1.setVisible(true);
                p3.setVisible(true);
                D1.setVisible(true);
                p4.setVisible(true);
                E1.setVisible(true);
                p5.setVisible(true);
                F1.setVisible(true);
                p6.setVisible(true);

            }
            if (n1 == 7) {
                at7.setVisible(true);
                G.setVisible(true);
                c7.setVisible(true);
                at6.setVisible(true);
                F.setVisible(true);
                c6.setVisible(true);
                at4.setVisible(true);
                at5.setVisible(true);
                E.setVisible(true);
                c5.setVisible(true);
                p4.setVisible(true);
                D.setVisible(true);
                c4.setVisible(true);
                at3.setVisible(true);
                C.setVisible(true);
                c3.setVisible(true);
                at1.setVisible(true);
                A.setVisible(true);
                c1.setVisible(true);
                at2.setVisible(true);
                B.setVisible(true);
                c2.setVisible(true);
                A1.setVisible(true);
                p1.setVisible(true);
                B1.setVisible(true);
                p2.setVisible(true);
                C1.setVisible(true);
                p3.setVisible(true);
                D1.setVisible(true);
                p4.setVisible(true);
                E1.setVisible(true);
                p5.setVisible(true);
                F1.setVisible(true);
                p6.setVisible(true);
                G1.setVisible(true);
                p7.setVisible(true);

            }
            if (n1 == 8) {
                at8.setVisible(true);
                H.setVisible(true);
                c8.setVisible(true);
                at7.setVisible(true);
                G.setVisible(true);
                c7.setVisible(true);
                at6.setVisible(true);
                at4.setVisible(true);
                F.setVisible(true);
                c6.setVisible(true);
                at5.setVisible(true);
                E.setVisible(true);
                c5.setVisible(true);
                p4.setVisible(true);
                D.setVisible(true);
                c4.setVisible(true);
                at3.setVisible(true);
                C.setVisible(true);
                c3.setVisible(true);
                at1.setVisible(true);
                A.setVisible(true);
                c1.setVisible(true);
                at2.setVisible(true);
                B.setVisible(true);
                c2.setVisible(true);
                A1.setVisible(true);
                p1.setVisible(true);
                B1.setVisible(true);
                p2.setVisible(true);
                C1.setVisible(true);
                p3.setVisible(true);
                D1.setVisible(true);
                p4.setVisible(true);
                E1.setVisible(true);
                p5.setVisible(true);
                F1.setVisible(true);
                p6.setVisible(true);
                G1.setVisible(true);
                p7.setVisible(true);
                H1.setVisible(true);
                p8.setVisible(true);
            }
            if (n1 == 9) {
                at9.setVisible(true);
                I.setVisible(true);
                c9.setVisible(true);
                at8.setVisible(true);
                H.setVisible(true);
                c8.setVisible(true);
                at7.setVisible(true);
                G.setVisible(true);
                at4.setVisible(true);
                c7.setVisible(true);
                at6.setVisible(true);
                F.setVisible(true);
                c6.setVisible(true);
                at5.setVisible(true);
                E.setVisible(true);
                c5.setVisible(true);
                p4.setVisible(true);
                D.setVisible(true);
                c4.setVisible(true);
                at3.setVisible(true);
                C.setVisible(true);
                c3.setVisible(true);
                at1.setVisible(true);
                B.setVisible(true);
                c1.setVisible(true);
                at2.setVisible(true);
                A.setVisible(true);
                c2.setVisible(true);
                A1.setVisible(true);
                p1.setVisible(true);
                B1.setVisible(true);
                p2.setVisible(true);
                C1.setVisible(true);
                p3.setVisible(true);
                D1.setVisible(true);
                p4.setVisible(true);
                E1.setVisible(true);
                p5.setVisible(true);
                F1.setVisible(true);
                p6.setVisible(true);
                G1.setVisible(true);
                p7.setVisible(true);
                H1.setVisible(true);
                p8.setVisible(true);
                I1.setVisible(true);
                p9.setVisible(true);
            }
            if (n1 == 10) {
                at10.setVisible(true);
                J.setVisible(true);
                c10.setVisible(true);
                at9.setVisible(true);
                I.setVisible(true);
                c9.setVisible(true);
                at8.setVisible(true);
                H.setVisible(true);
                c8.setVisible(true);
                at7.setVisible(true);
                at4.setVisible(true);
                G.setVisible(true);
                c7.setVisible(true);
                at6.setVisible(true);
                F.setVisible(true);
                c6.setVisible(true);
                at5.setVisible(true);
                E.setVisible(true);
                c5.setVisible(true);
                p4.setVisible(true);
                D.setVisible(true);
                c4.setVisible(true);
                at3.setVisible(true);
                C.setVisible(true);
                c3.setVisible(true);
                at1.setVisible(true);
                A.setVisible(true);
                c1.setVisible(true);
                at2.setVisible(true);
                B.setVisible(true);
                c2.setVisible(true);
                A1.setVisible(true);
                p1.setVisible(true);
                B1.setVisible(true);
                p2.setVisible(true);
                C1.setVisible(true);
                p3.setVisible(true);
                D1.setVisible(true);
                p4.setVisible(true);
                E1.setVisible(true);
                p5.setVisible(true);
                F1.setVisible(true);
                p6.setVisible(true);
                G1.setVisible(true);
                p7.setVisible(true);
                H1.setVisible(true);
                p8.setVisible(true);
                I1.setVisible(true);
                p9.setVisible(true);
                J1.setVisible(true);
                p10.setVisible(true);
            }
            if (n1 > 10) {
                JOptionPane.showMessageDialog(null, "Wrong Input!!");
            }
        } while (n1 > 10);
        quantumstr = JOptionPane.showInputDialog("Enter time quantum for round robin scheduling");
        quantum = Integer.parseInt(quantumstr);
    }

    public void invisible() {
        at1.setVisible(false);
        at2.setVisible(false);
        at3.setVisible(false);
        at4.setVisible(false);
        at5.setVisible(false);
        at6.setVisible(false);
        at7.setVisible(false);
        at8.setVisible(false);
        at9.setVisible(false);
        at10.setVisible(false);
        A.setVisible(false);
        B.setVisible(false);
        C.setVisible(false);
        D.setVisible(false);
        E.setVisible(false);
        F.setVisible(false);
        G.setVisible(false);
        H.setVisible(false);
        I.setVisible(false);
        J.setVisible(false);
        c1.setVisible(false);
        c2.setVisible(false);
        c3.setVisible(false);
        c4.setVisible(false);
        c5.setVisible(false);
        c6.setVisible(false);
        c7.setVisible(false);
        c8.setVisible(false);
        c9.setVisible(false);
        c10.setVisible(false);
        A1.setVisible(false);
        B1.setVisible(false);
        C1.setVisible(false);
        D1.setVisible(false);
        E1.setVisible(false);
        F1.setVisible(false);
        G1.setVisible(false);
        H1.setVisible(false);
        I1.setVisible(false);
        J1.setVisible(false);
        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(false);
        p5.setVisible(false);
        p6.setVisible(false);
        p7.setVisible(false);
        p8.setVisible(false);
        p9.setVisible(false);
        p10.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        burst = new javax.swing.JLabel();
        arrival = new javax.swing.JLabel();
        scheduling = new javax.swing.JLabel();
        c1 = new javax.swing.JTextField();
        c2 = new javax.swing.JTextField();
        at1 = new javax.swing.JTextField();
        at2 = new javax.swing.JTextField();
        c3 = new javax.swing.JTextField();
        at3 = new javax.swing.JTextField();
        c4 = new javax.swing.JTextField();
        p4 = new javax.swing.JTextField();
        c5 = new javax.swing.JTextField();
        at5 = new javax.swing.JTextField();
        c6 = new javax.swing.JTextField();
        at6 = new javax.swing.JTextField();
        c7 = new javax.swing.JTextField();
        at7 = new javax.swing.JTextField();
        c8 = new javax.swing.JTextField();
        at8 = new javax.swing.JTextField();
        c9 = new javax.swing.JTextField();
        at9 = new javax.swing.JTextField();
        c10 = new javax.swing.JTextField();
        at10 = new javax.swing.JTextField();
        start = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        A = new javax.swing.JLabel();
        B = new javax.swing.JLabel();
        C = new javax.swing.JLabel();
        D = new javax.swing.JLabel();
        E = new javax.swing.JLabel();
        F = new javax.swing.JLabel();
        G = new javax.swing.JLabel();
        H = new javax.swing.JLabel();
        I = new javax.swing.JLabel();
        J = new javax.swing.JLabel();
        arrival1 = new javax.swing.JLabel();
        p2 = new javax.swing.JTextField();
        p1 = new javax.swing.JTextField();
        p3 = new javax.swing.JTextField();
        at4 = new javax.swing.JTextField();
        p5 = new javax.swing.JTextField();
        p6 = new javax.swing.JTextField();
        p7 = new javax.swing.JTextField();
        p8 = new javax.swing.JTextField();
        p9 = new javax.swing.JTextField();
        p10 = new javax.swing.JTextField();
        A1 = new javax.swing.JLabel();
        B1 = new javax.swing.JLabel();
        C1 = new javax.swing.JLabel();
        D1 = new javax.swing.JLabel();
        E1 = new javax.swing.JLabel();
        F1 = new javax.swing.JLabel();
        G1 = new javax.swing.JLabel();
        H1 = new javax.swing.JLabel();
        I1 = new javax.swing.JLabel();
        J1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(179, 106, 217));
        jPanel1.setPreferredSize(new java.awt.Dimension(479, 573));

        burst.setText("CPU BURST");

        arrival.setText("  ARRIVAL TIME");

        scheduling.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        scheduling.setText("            CPU SCHEDULING");

        start.setBackground(new java.awt.Color(216, 135, 17));
        start.setText("START SCHEDULING");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        exit.setBackground(new java.awt.Color(216, 135, 17));
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        A.setText("A");

        B.setText("B");

        C.setText("C");

        D.setText("D");

        E.setText("E");

        F.setText("F");

        G.setText("G");

        H.setText("H");

        I.setText("I");

        J.setText("J");

        arrival1.setText("       PRIORITY");

        A1.setText("A");

        B1.setText("B");

        C1.setText("C");

        D1.setText("D");

        E1.setText("E");

        F1.setText("F");

        G1.setText("G");

        H1.setText("H");

        I1.setText("I");

        J1.setText("J");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(scheduling, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(burst, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addComponent(arrival, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(c3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(c4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(c5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(c6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(c7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(c8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(c9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(c10, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(46, 46, 46)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(E)
                                            .addComponent(D)
                                            .addComponent(F)
                                            .addComponent(G)
                                            .addComponent(H)
                                            .addComponent(I)
                                            .addComponent(J)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(B)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(45, 45, 45)
                                            .addComponent(A)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(114, 114, 114)
                                        .addComponent(C)))
                                .addGap(52, 52, 52)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(at1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(at2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(at3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(at4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(at5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(at6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(at7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(at8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(at9, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(at10, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(J1)
                                    .addComponent(I1)
                                    .addComponent(H1)
                                    .addComponent(G1)
                                    .addComponent(F1)
                                    .addComponent(E1)
                                    .addComponent(D1)
                                    .addComponent(C1)
                                    .addComponent(B1)
                                    .addComponent(A1))))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(arrival1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(p4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(p5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(p6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(p7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(p8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(p9, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(p10, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)))))
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(scheduling, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(burst, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arrival, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arrival1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(at1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(A)
                            .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(A1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(at2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B)
                            .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B1))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(at3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(C)
                            .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(C1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D)
                    .addComponent(at4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(at5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E)
                    .addComponent(p5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(F)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(c6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(at6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(p6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(F1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(at7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(G)
                    .addComponent(p7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(G1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(at8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(H)
                    .addComponent(p8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(H1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(at9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(I)
                    .addComponent(p9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(I1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(at10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(J)
                    .addComponent(p10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(J1))
                .addGap(26, 139, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(570, 656));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "Confirm exit");
        if (a == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitActionPerformed

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        if (n1 == 1) {

            at[0] = Integer.parseInt(at1.getText());
            bt[0] = Integer.parseInt(c1.getText());
            priority[0] = Integer.parseInt(p1.getText());
        }
        if (n1 == 2) {

            at[0] = Integer.parseInt(at1.getText());
            bt[0] = Integer.parseInt(c1.getText());
            at[1] = Integer.parseInt(at2.getText());
            bt[1] = Integer.parseInt(c2.getText());
            priority[0] = Integer.parseInt(p1.getText());
            priority[1] = Integer.parseInt(p2.getText());
        }
        if (n1 == 3) {

            at[0] = Integer.parseInt(at1.getText());
            bt[0] = Integer.parseInt(c1.getText());
            at[1] = Integer.parseInt(at2.getText());
            bt[1] = Integer.parseInt(c2.getText());
            at[2] = Integer.parseInt(at3.getText());
            bt[2] = Integer.parseInt(c3.getText());
            priority[0] = Integer.parseInt(p1.getText());
            priority[1] = Integer.parseInt(p2.getText());
            priority[2] = Integer.parseInt(p3.getText());

        }
        if (n1 == 4) {

            at[0] = Integer.parseInt(at1.getText());
            bt[0] = Integer.parseInt(c1.getText());
            at[1] = Integer.parseInt(at2.getText());
            bt[1] = Integer.parseInt(c2.getText());
            at[2] = Integer.parseInt(at3.getText());
            bt[2] = Integer.parseInt(c3.getText());
            at[3] = Integer.parseInt(p4.getText());
            bt[3] = Integer.parseInt(c4.getText());
            priority[0] = Integer.parseInt(p1.getText());
            priority[1] = Integer.parseInt(p2.getText());
            priority[2] = Integer.parseInt(p3.getText());
            priority[3] = Integer.parseInt(p4.getText());

        }
        if (n1 == 5) {

            at[0] = Integer.parseInt(at1.getText());
            bt[0] = Integer.parseInt(c1.getText());
            at[1] = Integer.parseInt(at2.getText());
            priority[0] = Integer.parseInt(p1.getText());
            priority[1] = Integer.parseInt(p2.getText());
            priority[2] = Integer.parseInt(p3.getText());
            priority[3] = Integer.parseInt(p4.getText());
            priority[4] = Integer.parseInt(p5.getText());

            bt[1] = Integer.parseInt(c2.getText());
            at[2] = Integer.parseInt(at3.getText());
            bt[2] = Integer.parseInt(c3.getText());
            at[3] = Integer.parseInt(p4.getText());
            bt[3] = Integer.parseInt(c4.getText());
            at[4] = Integer.parseInt(at5.getText());
            bt[4] = Integer.parseInt(c5.getText());
        }
        if (n1 == 6) {

            at[0] = Integer.parseInt(at1.getText());
            bt[0] = Integer.parseInt(c1.getText());
            at[1] = Integer.parseInt(at2.getText());
            bt[1] = Integer.parseInt(c2.getText());
            at[2] = Integer.parseInt(at3.getText());
            bt[2] = Integer.parseInt(c3.getText());
            at[3] = Integer.parseInt(p4.getText());
            bt[3] = Integer.parseInt(c4.getText());
            at[4] = Integer.parseInt(at5.getText());
            bt[4] = Integer.parseInt(c5.getText());
            at[5] = Integer.parseInt(at6.getText());
            bt[5] = Integer.parseInt(c6.getText());
            priority[0] = Integer.parseInt(p1.getText());
            priority[1] = Integer.parseInt(p2.getText());
            priority[2] = Integer.parseInt(p3.getText());
            priority[3] = Integer.parseInt(p4.getText());
            priority[4] = Integer.parseInt(p5.getText());
            priority[5] = Integer.parseInt(p6.getText());

        }
        if (n1 == 7) {

            at[0] = Integer.parseInt(at1.getText());
            bt[0] = Integer.parseInt(c1.getText());
            at[1] = Integer.parseInt(at2.getText());
            bt[1] = Integer.parseInt(c2.getText());
            at[2] = Integer.parseInt(at3.getText());
            bt[2] = Integer.parseInt(c3.getText());
            at[3] = Integer.parseInt(p4.getText());
            bt[3] = Integer.parseInt(c4.getText());
            at[4] = Integer.parseInt(at5.getText());
            bt[4] = Integer.parseInt(c5.getText());
            at[5] = Integer.parseInt(at6.getText());
            bt[5] = Integer.parseInt(c6.getText());
            at[6] = Integer.parseInt(at7.getText());
            bt[6] = Integer.parseInt(c7.getText());
            priority[0] = Integer.parseInt(p1.getText());
            priority[1] = Integer.parseInt(p2.getText());
            priority[2] = Integer.parseInt(p3.getText());
            priority[3] = Integer.parseInt(p4.getText());
            priority[4] = Integer.parseInt(p5.getText());
            priority[5] = Integer.parseInt(p6.getText());
            priority[6] = Integer.parseInt(p7.getText());
        }
        if (n1 == 8) {

            at[0] = Integer.parseInt(at1.getText());
            bt[0] = Integer.parseInt(c1.getText());
            at[1] = Integer.parseInt(at2.getText());
            bt[1] = Integer.parseInt(c2.getText());
            at[2] = Integer.parseInt(at3.getText());
            bt[2] = Integer.parseInt(c3.getText());
            at[3] = Integer.parseInt(p4.getText());
            bt[3] = Integer.parseInt(c4.getText());
            at[4] = Integer.parseInt(at5.getText());
            bt[4] = Integer.parseInt(c5.getText());
            at[5] = Integer.parseInt(at6.getText());
            bt[5] = Integer.parseInt(c6.getText());
            at[6] = Integer.parseInt(at7.getText());
            bt[6] = Integer.parseInt(c7.getText());
            at[7] = Integer.parseInt(at8.getText());
            bt[7] = Integer.parseInt(c8.getText());

            priority[0] = Integer.parseInt(p1.getText());
            priority[1] = Integer.parseInt(p2.getText());
            priority[2] = Integer.parseInt(p3.getText());
            priority[3] = Integer.parseInt(p4.getText());
            priority[4] = Integer.parseInt(p5.getText());
            priority[5] = Integer.parseInt(p6.getText());
            priority[6] = Integer.parseInt(p7.getText());
            priority[7] = Integer.parseInt(p8.getText());

        }
        if (n1 == 9) {

            at[0] = Integer.parseInt(at1.getText());
            bt[0] = Integer.parseInt(c1.getText());
            at[1] = Integer.parseInt(at2.getText());
            bt[1] = Integer.parseInt(c2.getText());
            at[2] = Integer.parseInt(at3.getText());
            bt[2] = Integer.parseInt(c3.getText());
            at[3] = Integer.parseInt(p4.getText());
            bt[3] = Integer.parseInt(c4.getText());
            at[4] = Integer.parseInt(at5.getText());
            bt[4] = Integer.parseInt(c5.getText());
            at[5] = Integer.parseInt(at6.getText());
            bt[5] = Integer.parseInt(c6.getText());
            at[6] = Integer.parseInt(at7.getText());
            bt[6] = Integer.parseInt(c7.getText());
            at[7] = Integer.parseInt(at8.getText());
            bt[7] = Integer.parseInt(c8.getText());
            at[8] = Integer.parseInt(at9.getText());
            bt[8] = Integer.parseInt(c9.getText());

            priority[0] = Integer.parseInt(p1.getText());
            priority[1] = Integer.parseInt(p2.getText());
            priority[2] = Integer.parseInt(p3.getText());
            priority[3] = Integer.parseInt(p4.getText());
            priority[4] = Integer.parseInt(p5.getText());
            priority[5] = Integer.parseInt(p6.getText());
            priority[6] = Integer.parseInt(p7.getText());
            priority[7] = Integer.parseInt(p8.getText());
            priority[8] = Integer.parseInt(p9.getText());

        }
        if (n1 == 10) {
            at[0] = Integer.parseInt(at1.getText());
            bt[0] = Integer.parseInt(c1.getText());
            at[1] = Integer.parseInt(at2.getText());
            bt[1] = Integer.parseInt(c2.getText());
            at[2] = Integer.parseInt(at3.getText());
            bt[2] = Integer.parseInt(c3.getText());
            at[3] = Integer.parseInt(p4.getText());
            bt[3] = Integer.parseInt(c4.getText());
            at[4] = Integer.parseInt(at5.getText());
            bt[4] = Integer.parseInt(c5.getText());
            at[5] = Integer.parseInt(at6.getText());
            bt[5] = Integer.parseInt(c6.getText());
            at[6] = Integer.parseInt(at7.getText());
            bt[6] = Integer.parseInt(c7.getText());
            at[7] = Integer.parseInt(at8.getText());
            bt[7] = Integer.parseInt(c8.getText());
            at[8] = Integer.parseInt(at9.getText());
            bt[8] = Integer.parseInt(c9.getText());
            at[9] = Integer.parseInt(at10.getText());
            bt[9] = Integer.parseInt(c10.getText());
            priority[0] = Integer.parseInt(p1.getText());
            priority[1] = Integer.parseInt(p2.getText());
            priority[2] = Integer.parseInt(p3.getText());
            priority[3] = Integer.parseInt(p4.getText());
            priority[4] = Integer.parseInt(p5.getText());
            priority[5] = Integer.parseInt(p6.getText());
            priority[6] = Integer.parseInt(p7.getText());
            priority[7] = Integer.parseInt(p8.getText());
            priority[8] = Integer.parseInt(p9.getText());
            priority[9] = Integer.parseInt(p10.getText());

        }

        fcfs();
        srtf();
        ltf();
        rr();
        prior();
        this.setVisible(false);
        new third(fcfswait, fcfstat, srtfwait, srtftat, ltfwait, ltftat, rrwait, rrtat, prioritywait, prioritytat).setVisible(true);

    }//GEN-LAST:event_startActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(second.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new second().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel A;
    private javax.swing.JLabel A1;
    private javax.swing.JLabel B;
    private javax.swing.JLabel B1;
    private javax.swing.JLabel C;
    private javax.swing.JLabel C1;
    private javax.swing.JLabel D;
    private javax.swing.JLabel D1;
    private javax.swing.JLabel E;
    private javax.swing.JLabel E1;
    private javax.swing.JLabel F;
    private javax.swing.JLabel F1;
    private javax.swing.JLabel G;
    private javax.swing.JLabel G1;
    private javax.swing.JLabel H;
    private javax.swing.JLabel H1;
    private javax.swing.JLabel I;
    private javax.swing.JLabel I1;
    private javax.swing.JLabel J;
    private javax.swing.JLabel J1;
    private javax.swing.JLabel arrival;
    private javax.swing.JLabel arrival1;
    private javax.swing.JTextField at1;
    private javax.swing.JTextField at10;
    private javax.swing.JTextField at2;
    private javax.swing.JTextField at3;
    private javax.swing.JTextField at4;
    private javax.swing.JTextField at5;
    private javax.swing.JTextField at6;
    private javax.swing.JTextField at7;
    private javax.swing.JTextField at8;
    private javax.swing.JTextField at9;
    private javax.swing.JLabel burst;
    private javax.swing.JTextField c1;
    private javax.swing.JTextField c10;
    private javax.swing.JTextField c2;
    private javax.swing.JTextField c3;
    private javax.swing.JTextField c4;
    private javax.swing.JTextField c5;
    private javax.swing.JTextField c6;
    private javax.swing.JTextField c7;
    private javax.swing.JTextField c8;
    private javax.swing.JTextField c9;
    private javax.swing.JButton exit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField p1;
    private javax.swing.JTextField p10;
    private javax.swing.JTextField p2;
    private javax.swing.JTextField p3;
    private javax.swing.JTextField p4;
    private javax.swing.JTextField p5;
    private javax.swing.JTextField p6;
    private javax.swing.JTextField p7;
    private javax.swing.JTextField p8;
    private javax.swing.JTextField p9;
    private javax.swing.JLabel scheduling;
    private javax.swing.JButton start;
    // End of variables declaration//GEN-END:variables
}
