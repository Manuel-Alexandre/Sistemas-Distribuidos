
package Publish;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

import com.sun.management.OperatingSystemMXBean;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import org.eclipse.paho.client.mqttv3.MqttMessage;


public class Publish extends javax.swing.JFrame {
    MqttClient clienteP;
    OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
    float cpu;
    float jvm;
    String msg_gpu;
    String msg_jvm;
    int aux;
    int aux2;
    public Publish() {
        initComponents();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        B_conectar = new javax.swing.JButton();
        L_aviso = new javax.swing.JLabel();
        B_enviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        B_conectar.setBackground(new java.awt.Color(51, 204, 0));
        B_conectar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        B_conectar.setForeground(new java.awt.Color(255, 255, 255));
        B_conectar.setText("Conectar");
        B_conectar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B_conectarMouseClicked(evt);
            }
        });

        L_aviso.setBackground(new java.awt.Color(255, 255, 255));
        L_aviso.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        L_aviso.setForeground(new java.awt.Color(0, 51, 102));
        L_aviso.setText("Clique em enviar para começarenviar dados da sua CPU.");

        B_enviar.setBackground(new java.awt.Color(0, 102, 153));
        B_enviar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        B_enviar.setForeground(new java.awt.Color(255, 255, 255));
        B_enviar.setText("Enviar");
        B_enviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B_enviarMouseClicked(evt);
            }
        });
        B_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_enviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(B_conectar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(B_enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(L_aviso, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(B_conectar)
                .addGap(89, 89, 89)
                .addComponent(L_aviso, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(B_enviar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_enviarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_B_enviarActionPerformed

    private void B_enviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_enviarMouseClicked

        while(true){
            // What % CPU load this current JVM is taking, from 0.0-1.0

            // What % load the overall system is at, from 0.0-1.0
            cpu = (float) osBean.getSystemCpuLoad();
            cpu = cpu * 100;
            aux = (int) cpu;
            msg_gpu = Integer.toString(aux)+ "%";

            jvm = (float) osBean.getProcessCpuLoad();
            jvm = jvm * 100;
            aux2 = (int) jvm;
            msg_jvm = Integer.toString(aux2) + "%";

            MqttMessage msg1 = new MqttMessage(msg_gpu.getBytes());
            MqttMessage msg2 = new MqttMessage(msg_jvm.getBytes());
            try {
                clienteP.publish("/test/cpu", msg1);
                clienteP.publish("/test/jvm", msg2);
                System.out.println("Enviando dados...");

            } catch (MqttException ex) {
                System.out.println("Erro ao publicar mensagem!");
                Logger.getLogger(Publish.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_B_enviarMouseClicked

    private void B_conectarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_conectarMouseClicked
        try {
            clienteP = new MqttClient("tcp://localhost:1883", "Publish");
            clienteP.connect();
            System.out.println("Cliente publicador conectado!");
        } catch (MqttException ex) {
            System.out.println("Erro ao conectar!");
            Logger.getLogger(Publish.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_B_conectarMouseClicked

        
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
            java.util.logging.Logger.getLogger(Publish.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Publish.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Publish.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Publish.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Publish().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_conectar;
    private javax.swing.JButton B_enviar;
    private javax.swing.JLabel L_aviso;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
