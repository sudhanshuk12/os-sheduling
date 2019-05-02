package os;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class disk extends javax.swing.JFrame {

    String n;
    int n1, i, j, total = 0, hs, k, cyl, fcfs, sstf,scan, cscan, look, clook,seek_time=0,final1,t;
    int c[] = new int[15]; 
    

    public disk() {
        initComponents();
        invisible();
        input();
    }

    public void fcfs() {
        int flag;
        int hm[] = new int[n1];
        flag = hs;
        for (i = 0; i < n1; i++) {
            if (c[i] > flag) {
                hm[i] = c[i] - flag;
            } else {
                hm[i] = flag - c[i];
            }
            flag = c[i];
        }
        for (i = 0; i < n1; i++) {
            total = total + hm[i];
        }
        fcfs = total;
    }
    public void sstf(){
         int k=0,l=0,seek_time=0,m=0,temp,small;
	j=hs;
	for(m=0;m<n1;m++){
	small=c[m]-j;
        l=m;
		if(small<0)
		small=(-small);
	for(i=m;i<n1;i++){
		k=c[i]-j;
		if(k<0)
		k=(-k);
		if(k<small){
		small=k;
		l=i;
        }
	}
	seek_time+=small;
	temp=c[m];
	c[m]=c[l];
	c[l]=temp;
	j=c[m];
}
sstf = seek_time;    
    }

    public void scan() {
        for(i=0;i<n1;i++){
            int temp = c[i];
            j=i-1;
            while(j>=0&&c[j]>temp){
                c[j+1]=c[j];
                j--;
            }
            c[j+1]=temp;
        }
         i = 0;
        seek_time=0;
        while (c[i] < hs) {
            i++;
        }
        j = hs;
        for (k = i - 1; k >= 0; k--) {
            final1 = j - c[k];
            seek_time += final1;
            j = c[k];
        }
        final1 = j - 0;
        j = 0;
        seek_time += final1;
        for (k = i; k < n1; k++) {
            final1 = c[k] - j;
            j = c[k];
            seek_time += final1;
        }
        scan = seek_time;
    }

    public void cscan() {
      for(i=0;i<n1;i++){
            int temp = c[i];
            j=i-1;
            while(j>=0&&c[j]>temp){
                c[j+1]=c[j];
                j--;
            }
            c[j+1]=temp;
        }
        i = 0;
        seek_time=0;
        while (c[i] < hs) {
            i++;
        }
        j = hs;
        for (k = i - 1; k >= 0; k--) {
            final1 = j - c[k];
            seek_time += final1;
            j = c[k];
        }
        final1 = j - 0;
        j = 0;
        seek_time += final1;
        final1 = cyl - 1;
        seek_time += final1;
        j = cyl- 1;
        for (k = n1 - 1; k >= i; k--) {
            final1 = j - c[k];
            j = c[k];
            seek_time += final1;
        }
        cscan=seek_time;
    }
    public void look(){
      for(i=0;i<n1;i++){
            int temp = c[i];
            j=i-1;
            while(j>=0&&c[j]>temp){
                c[j+1]=c[j];
                j--;
            }
            c[j+1]=temp;
        }
        i=0;
        seek_time=0;
	while(c[i]<hs){
		i++;
	}
	j=hs;
	for(k=i-1;k>=0;k--){
		final1=j-c[k];
		seek_time+=final1;
		j=c[k];
	}
	for(k=i;k<n1;k++){
		final1=c[k]-j;
		j=c[k];
		seek_time+=final1;
	}
	       look=seek_time;
    }
    public void clook(){
        for(i=0;i<n1;i++){
            int temp = c[i];
            j=i-1;
            while(j>=0&&c[j]>temp){
                c[j+1]=c[j];
                j--;
            }
            c[j+1]=temp;
        }
	i=0;
        seek_time=0;
	while(c[i]<hs){
		i++;
	}
	j=hs;
	for(k=i-1;k>=0;k--){
		final1=j-c[k];
		seek_time+=final1;
		j=c[k];
	}
	final1=c[n1-1]-c[0];
	seek_time+=final1;
	j=c[n1-1];
	for(k=n1-2;k>=i;k--){
		final1=j-c[k];
		j=c[k];
		seek_time+=final1;
	}
	      clook=seek_time;
    }

    public void input() {
        do {
            n = JOptionPane.showInputDialog("Enter total number of elements in work queue(Max.15)");
            n1 = Integer.parseInt(n);
            if (n1 == 1) {
                p1.setVisible(true);
                A.setVisible(true);
            }
            if (n1 == 2) {
                p1.setVisible(true);
                p2.setVisible(true);
                A.setVisible(true);
                B.setVisible(true);
            }
            if (n1 == 3) {
                p3.setVisible(true);
                p1.setVisible(true);
                p2.setVisible(true);
                A.setVisible(true);
                B.setVisible(true);
                C.setVisible(true);
            }
            if (n1 == 4) {
                p4.setVisible(true);
                p3.setVisible(true);
                p1.setVisible(true);
                p2.setVisible(true);
                A.setVisible(true);
                B.setVisible(true);
                C.setVisible(true);
                D.setVisible(true);
            }
            if (n1 == 5) {
                p5.setVisible(true);
                p4.setVisible(true);
                p3.setVisible(true);
                p1.setVisible(true);
                p2.setVisible(true);
                A.setVisible(true);
                B.setVisible(true);
                C.setVisible(true);
                D.setVisible(true);
                E.setVisible(true);
            }
            if (n1 == 6) {
                p6.setVisible(true);
                p5.setVisible(true);
                p4.setVisible(true);
                p3.setVisible(true);
                p1.setVisible(true);
                p2.setVisible(true);
                A.setVisible(true);
                B.setVisible(true);
                C.setVisible(true);
                D.setVisible(true);
                E.setVisible(true);
                F.setVisible(true);
            }
            if (n1 == 7) {
                p7.setVisible(true);
                p6.setVisible(true);
                p5.setVisible(true);
                p4.setVisible(true);
                p3.setVisible(true);
                p1.setVisible(true);
                p2.setVisible(true);
                A.setVisible(true);
                B.setVisible(true);
                C.setVisible(true);
                D.setVisible(true);
                E.setVisible(true);
                F.setVisible(true);
                G.setVisible(true);
            }
            if (n1 == 8) {
                p8.setVisible(true);
                p7.setVisible(true);
                p6.setVisible(true);
                p5.setVisible(true);
                p4.setVisible(true);
                p3.setVisible(true);
                p1.setVisible(true);
                p2.setVisible(true);
                A.setVisible(true);
                B.setVisible(true);
                C.setVisible(true);
                D.setVisible(true);
                E.setVisible(true);
                F.setVisible(true);
                G.setVisible(true);
                H.setVisible(true);
            }
            if (n1 == 9) {
                p9.setVisible(true);
                p8.setVisible(true);
                p7.setVisible(true);
                p6.setVisible(true);
                p5.setVisible(true);
                p4.setVisible(true);
                p3.setVisible(true);
                p1.setVisible(true);
                p2.setVisible(true);
                A.setVisible(true);
                B.setVisible(true);
                C.setVisible(true);
                D.setVisible(true);
                E.setVisible(true);
                F.setVisible(true);
                G.setVisible(true);
                H.setVisible(true);
                I.setVisible(true);
            }
            if (n1 == 10) {
                p10.setVisible(true);
                p9.setVisible(true);
                p8.setVisible(true);
                p7.setVisible(true);
                p6.setVisible(true);
                p5.setVisible(true);
                p4.setVisible(true);
                p3.setVisible(true);
                p1.setVisible(true);
                p2.setVisible(true);
                A.setVisible(true);
                B.setVisible(true);
                C.setVisible(true);
                D.setVisible(true);
                E.setVisible(true);
                F.setVisible(true);
                G.setVisible(true);
                H.setVisible(true);
                I.setVisible(true);
                J.setVisible(true);
            }
            if (n1 == 11) {
                p11.setVisible(true);
                p10.setVisible(true);
                p9.setVisible(true);
                p8.setVisible(true);
                p7.setVisible(true);
                p6.setVisible(true);
                p5.setVisible(true);
                p4.setVisible(true);
                p3.setVisible(true);
                p1.setVisible(true);
                p2.setVisible(true);
                A.setVisible(true);
                B.setVisible(true);
                C.setVisible(true);
                D.setVisible(true);
                E.setVisible(true);
                F.setVisible(true);
                G.setVisible(true);
                H.setVisible(true);
                I.setVisible(true);
                J.setVisible(true);
                K.setVisible(true);
            }
            if (n1 == 12) {
                p12.setVisible(true);
                p11.setVisible(true);
                p10.setVisible(true);
                p9.setVisible(true);
                p8.setVisible(true);
                p7.setVisible(true);
                p6.setVisible(true);
                p5.setVisible(true);
                p4.setVisible(true);
                p3.setVisible(true);
                p1.setVisible(true);
                p2.setVisible(true);
                A.setVisible(true);
                B.setVisible(true);
                C.setVisible(true);
                D.setVisible(true);
                E.setVisible(true);
                F.setVisible(true);
                G.setVisible(true);
                H.setVisible(true);
                I.setVisible(true);
                J.setVisible(true);
                K.setVisible(true);
                L.setVisible(true);
            }
            if (n1 == 13) {
                p13.setVisible(true);
                p12.setVisible(true);
                p11.setVisible(true);
                p10.setVisible(true);
                p9.setVisible(true);
                p8.setVisible(true);
                p7.setVisible(true);
                p6.setVisible(true);
                p5.setVisible(true);
                p4.setVisible(true);
                p3.setVisible(true);
                p1.setVisible(true);
                p2.setVisible(true);
                A.setVisible(true);
                B.setVisible(true);
                C.setVisible(true);
                D.setVisible(true);
                E.setVisible(true);
                F.setVisible(true);
                G.setVisible(true);
                H.setVisible(true);
                I.setVisible(true);
                J.setVisible(true);
                K.setVisible(true);
                L.setVisible(true);
                M.setVisible(true);
            }
            if (n1 == 14) {
                p14.setVisible(true);
                p13.setVisible(true);
                p12.setVisible(true);
                p11.setVisible(true);
                p10.setVisible(true);
                p9.setVisible(true);
                p8.setVisible(true);
                p7.setVisible(true);
                p6.setVisible(true);
                p5.setVisible(true);
                p4.setVisible(true);
                p3.setVisible(true);
                p1.setVisible(true);
                p2.setVisible(true);
                A.setVisible(true);
                B.setVisible(true);
                C.setVisible(true);
                D.setVisible(true);
                E.setVisible(true);
                F.setVisible(true);
                G.setVisible(true);
                H.setVisible(true);
                I.setVisible(true);
                J.setVisible(true);
                K.setVisible(true);
                L.setVisible(true);
                M.setVisible(true);
                N.setVisible(true);
            }
            if (n1 == 15) {
                p15.setVisible(true);
                p14.setVisible(true);
                p13.setVisible(true);
                p12.setVisible(true);
                p11.setVisible(true);
                p10.setVisible(true);
                p9.setVisible(true);
                p8.setVisible(true);
                p7.setVisible(true);
                p6.setVisible(true);
                p5.setVisible(true);
                p4.setVisible(true);
                p3.setVisible(true);
                p1.setVisible(true);
                p2.setVisible(true);
                A.setVisible(true);
                B.setVisible(true);
                C.setVisible(true);
                D.setVisible(true);
                E.setVisible(true);
                F.setVisible(true);
                G.setVisible(true);
                H.setVisible(true);
                I.setVisible(true);
                J.setVisible(true);
                K.setVisible(true);
                L.setVisible(true);
                M.setVisible(true);
                N.setVisible(true);
                O.setVisible(true);
            }
            if (n1 > 15) {
                JOptionPane.showMessageDialog(null, "Wrong Input!!");
            }
        } while (n1 > 15);
    }

    public void invisible() {
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
        p11.setVisible(false);
        p12.setVisible(false);
        p13.setVisible(false);
        p14.setVisible(false);
        p15.setVisible(false);
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
        K.setVisible(false);
        L.setVisible(false);
        M.setVisible(false);
        N.setVisible(false);
        O.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scheduling = new javax.swing.JLabel();
        NUMBER = new javax.swing.JLabel();
        HEAD = new javax.swing.JLabel();
        NUMBERTEXT = new javax.swing.JTextField();
        HEADTEXT = new javax.swing.JTextField();
        p1 = new javax.swing.JTextField();
        p13 = new javax.swing.JTextField();
        p5 = new javax.swing.JTextField();
        p8 = new javax.swing.JTextField();
        p11 = new javax.swing.JTextField();
        p2 = new javax.swing.JTextField();
        p4 = new javax.swing.JTextField();
        p7 = new javax.swing.JTextField();
        p10 = new javax.swing.JTextField();
        p14 = new javax.swing.JTextField();
        p9 = new javax.swing.JTextField();
        p12 = new javax.swing.JTextField();
        p3 = new javax.swing.JTextField();
        p6 = new javax.swing.JTextField();
        p15 = new javax.swing.JTextField();
        enter = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        A = new javax.swing.JLabel();
        B = new javax.swing.JLabel();
        C = new javax.swing.JLabel();
        D = new javax.swing.JLabel();
        F = new javax.swing.JLabel();
        E = new javax.swing.JLabel();
        I = new javax.swing.JLabel();
        H = new javax.swing.JLabel();
        G = new javax.swing.JLabel();
        L = new javax.swing.JLabel();
        K = new javax.swing.JLabel();
        J = new javax.swing.JLabel();
        O = new javax.swing.JLabel();
        N = new javax.swing.JLabel();
        M = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 255));

        jPanel1.setBackground(new java.awt.Color(179, 106, 217));

        scheduling.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        scheduling.setText("            DISK SCHEDULING");

        NUMBER.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        NUMBER.setText("Number of cylinders");

        HEAD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        HEAD.setText("Head position");

        NUMBERTEXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NUMBERTEXTActionPerformed(evt);
            }
        });

        HEADTEXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HEADTEXTActionPerformed(evt);
            }
        });

        p7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p7ActionPerformed(evt);
            }
        });

        enter.setBackground(new java.awt.Color(216, 135, 17));
        enter.setText("Enter");
        enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterActionPerformed(evt);
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

        F.setText("F");

        E.setText("E");

        I.setText("I");

        H.setText("H");

        G.setText("G");

        L.setText("L");

        K.setText("K");

        J.setText("J");

        O.setText("O");

        N.setText("N");

        M.setText("M");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(HEAD, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(HEADTEXT, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(NUMBER, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(NUMBERTEXT, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(A)
                .addGap(222, 222, 222)
                .addComponent(B)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(C)
                .addGap(176, 176, 176))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(p4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p10, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p13, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(159, 159, 159)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(p11, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p14, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(D)
                        .addGap(219, 219, 219)
                        .addComponent(E)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p15, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p12, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(147, 147, 147))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(F)
                        .addGap(172, 172, 172))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(G)
                .addGap(221, 221, 221)
                .addComponent(H)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(I)
                .addGap(172, 172, 172))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(J)
                .addGap(220, 220, 220)
                .addComponent(K)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(L)
                .addGap(173, 173, 173))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(M)
                .addGap(219, 219, 219)
                .addComponent(N)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(O)
                .addGap(174, 174, 174))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(scheduling, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(enter, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(scheduling, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NUMBER, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NUMBERTEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HEADTEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HEAD, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(A)
                    .addComponent(B)
                    .addComponent(C))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(D)
                    .addComponent(F)
                    .addComponent(E))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(G)
                    .addComponent(I)
                    .addComponent(H))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(J)
                    .addComponent(K)
                    .addComponent(L))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(M)
                    .addComponent(N)
                    .addComponent(O))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enter, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "Confirm exit");
        if (a == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitActionPerformed

    private void enterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterActionPerformed
        hs = Integer.parseInt(HEADTEXT.getText());
        if (n1 == 1) {
            c[0] = Integer.parseInt(p1.getText());
        }
        if (n1 == 2) {
            c[0] = Integer.parseInt(p1.getText());
            c[1] = Integer.parseInt(p2.getText());
        }
        if (n1 == 3) {
            c[0] = Integer.parseInt(p1.getText());
            c[1] = Integer.parseInt(p2.getText());
            c[2] = Integer.parseInt(p3.getText());
        }
        if (n1 == 4) {
            c[0] = Integer.parseInt(p1.getText());
            c[1] = Integer.parseInt(p2.getText());
            c[2] = Integer.parseInt(p3.getText());
            c[3] = Integer.parseInt(p4.getText());
        }
        if (n1 == 5) {
            c[0] = Integer.parseInt(p1.getText());
            c[1] = Integer.parseInt(p2.getText());
            c[2] = Integer.parseInt(p3.getText());
            c[3] = Integer.parseInt(p4.getText());
            c[4] = Integer.parseInt(p5.getText());
        }
        if (n1 == 6) {
            c[0] = Integer.parseInt(p1.getText());
            c[1] = Integer.parseInt(p2.getText());
            c[2] = Integer.parseInt(p3.getText());
            c[3] = Integer.parseInt(p4.getText());
            c[4] = Integer.parseInt(p5.getText());
            c[5] = Integer.parseInt(p6.getText());
        }
        if (n1 == 7) {
            c[0] = Integer.parseInt(p1.getText());
            c[1] = Integer.parseInt(p2.getText());
            c[2] = Integer.parseInt(p3.getText());
            c[3] = Integer.parseInt(p4.getText());
            c[4] = Integer.parseInt(p5.getText());
            c[5] = Integer.parseInt(p6.getText());
            c[6] = Integer.parseInt(p7.getText());
        }
        if (n1 == 8) {
            c[0] = Integer.parseInt(p1.getText());
            c[1] = Integer.parseInt(p2.getText());
            c[2] = Integer.parseInt(p3.getText());
            c[3] = Integer.parseInt(p4.getText());
            c[4] = Integer.parseInt(p5.getText());
            c[5] = Integer.parseInt(p6.getText());
            c[6] = Integer.parseInt(p7.getText());
            c[7] = Integer.parseInt(p8.getText());
        }
        if (n1 == 9) {
            c[0] = Integer.parseInt(p1.getText());
            c[1] = Integer.parseInt(p2.getText());
            c[2] = Integer.parseInt(p3.getText());
            c[3] = Integer.parseInt(p4.getText());
            c[4] = Integer.parseInt(p5.getText());
            c[5] = Integer.parseInt(p6.getText());
            c[6] = Integer.parseInt(p7.getText());
            c[7] = Integer.parseInt(p8.getText());
            c[8] = Integer.parseInt(p9.getText());

        }
        if (n1 == 10) {
            c[0] = Integer.parseInt(p1.getText());
            c[1] = Integer.parseInt(p2.getText());
            c[2] = Integer.parseInt(p3.getText());
            c[3] = Integer.parseInt(p4.getText());
            c[4] = Integer.parseInt(p5.getText());
            c[5] = Integer.parseInt(p6.getText());
            c[6] = Integer.parseInt(p7.getText());
            c[7] = Integer.parseInt(p8.getText());
            c[8] = Integer.parseInt(p9.getText());
            c[9] = Integer.parseInt(p10.getText());

        }
        if (n1 == 11) {
            c[0] = Integer.parseInt(p1.getText());
            c[1] = Integer.parseInt(p2.getText());
            c[2] = Integer.parseInt(p3.getText());
            c[3] = Integer.parseInt(p4.getText());
            c[4] = Integer.parseInt(p5.getText());
            c[5] = Integer.parseInt(p6.getText());
            c[6] = Integer.parseInt(p7.getText());
            c[7] = Integer.parseInt(p8.getText());
            c[8] = Integer.parseInt(p9.getText());
            c[9] = Integer.parseInt(p10.getText());
            c[10] = Integer.parseInt(p11.getText());

        }
        if (n1 == 12) {
            c[0] = Integer.parseInt(p1.getText());
            c[1] = Integer.parseInt(p2.getText());
            c[2] = Integer.parseInt(p3.getText());
            c[3] = Integer.parseInt(p4.getText());
            c[4] = Integer.parseInt(p5.getText());
            c[5] = Integer.parseInt(p6.getText());
            c[6] = Integer.parseInt(p7.getText());
            c[7] = Integer.parseInt(p8.getText());
            c[8] = Integer.parseInt(p9.getText());
            c[9] = Integer.parseInt(p10.getText());
            c[10] = Integer.parseInt(p11.getText());
            c[11] = Integer.parseInt(p12.getText());

        }
        if (n1 == 13) {
            c[0] = Integer.parseInt(p1.getText());
            c[1] = Integer.parseInt(p2.getText());
            c[2] = Integer.parseInt(p3.getText());
            c[3] = Integer.parseInt(p4.getText());
            c[4] = Integer.parseInt(p5.getText());
            c[5] = Integer.parseInt(p6.getText());
            c[6] = Integer.parseInt(p7.getText());
            c[7] = Integer.parseInt(p8.getText());
            c[8] = Integer.parseInt(p9.getText());
            c[9] = Integer.parseInt(p10.getText());
            c[10] = Integer.parseInt(p11.getText());
            c[11] = Integer.parseInt(p12.getText());
            c[12] = Integer.parseInt(p13.getText());

        }
        if (n1 == 14) {
            c[0] = Integer.parseInt(p1.getText());
            c[1] = Integer.parseInt(p2.getText());
            c[2] = Integer.parseInt(p3.getText());
            c[3] = Integer.parseInt(p4.getText());
            c[4] = Integer.parseInt(p5.getText());
            c[5] = Integer.parseInt(p6.getText());
            c[6] = Integer.parseInt(p7.getText());
            c[7] = Integer.parseInt(p8.getText());
            c[8] = Integer.parseInt(p9.getText());
            c[9] = Integer.parseInt(p10.getText());
            c[10] = Integer.parseInt(p11.getText());
            c[11] = Integer.parseInt(p12.getText());
            c[12] = Integer.parseInt(p13.getText());
            c[13] = Integer.parseInt(p14.getText());
        }
        if (n1 == 15) {
            c[0] = Integer.parseInt(p1.getText());
            c[1] = Integer.parseInt(p2.getText());
            c[2] = Integer.parseInt(p3.getText());
            c[3] = Integer.parseInt(p4.getText());
            c[4] = Integer.parseInt(p5.getText());
            c[5] = Integer.parseInt(p6.getText());
            c[6] = Integer.parseInt(p7.getText());
            c[7] = Integer.parseInt(p8.getText());
            c[8] = Integer.parseInt(p9.getText());
            c[9] = Integer.parseInt(p10.getText());
            c[10] = Integer.parseInt(p11.getText());
            c[11] = Integer.parseInt(p12.getText());
            c[12] = Integer.parseInt(p13.getText());
            c[13] = Integer.parseInt(p14.getText());
            c[14] = Integer.parseInt(p15.getText());
        }
        cyl = Integer.parseInt(NUMBERTEXT.getText());
        for (int k = 0; k < n1; k++) {
            if (c[i] < cyl) {
            } else {
                JOptionPane.showMessageDialog(null, "Input above cylinder ");
            }
        }
        if (hs > cyl) {
            JOptionPane.showMessageDialog(null, "hs position above cylinder ");
        }
        fcfs();
        scan();
        cscan();
        look();
        clook();
        sstf();
        this.setVisible(false);
        new result(fcfs,scan,cscan,look,clook,sstf).setVisible(true);
    }//GEN-LAST:event_enterActionPerformed

    private void p7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p7ActionPerformed

    }//GEN-LAST:event_p7ActionPerformed

    private void HEADTEXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HEADTEXTActionPerformed
    }//GEN-LAST:event_HEADTEXTActionPerformed

    private void NUMBERTEXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NUMBERTEXTActionPerformed
    }//GEN-LAST:event_NUMBERTEXTActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(disk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(disk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(disk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(disk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new disk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel A;
    private javax.swing.JLabel B;
    private javax.swing.JLabel C;
    private javax.swing.JLabel D;
    private javax.swing.JLabel E;
    private javax.swing.JLabel F;
    private javax.swing.JLabel G;
    private javax.swing.JLabel H;
    private javax.swing.JLabel HEAD;
    private javax.swing.JTextField HEADTEXT;
    private javax.swing.JLabel I;
    private javax.swing.JLabel J;
    private javax.swing.JLabel K;
    private javax.swing.JLabel L;
    private javax.swing.JLabel M;
    private javax.swing.JLabel N;
    private javax.swing.JLabel NUMBER;
    private javax.swing.JTextField NUMBERTEXT;
    private javax.swing.JLabel O;
    private javax.swing.JButton enter;
    private javax.swing.JButton exit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField p1;
    private javax.swing.JTextField p10;
    private javax.swing.JTextField p11;
    private javax.swing.JTextField p12;
    private javax.swing.JTextField p13;
    private javax.swing.JTextField p14;
    private javax.swing.JTextField p15;
    private javax.swing.JTextField p2;
    private javax.swing.JTextField p3;
    private javax.swing.JTextField p4;
    private javax.swing.JTextField p5;
    private javax.swing.JTextField p6;
    private javax.swing.JTextField p7;
    private javax.swing.JTextField p8;
    private javax.swing.JTextField p9;
    private javax.swing.JLabel scheduling;
    // End of variables declaration//GEN-END:variables
}
