
import io.github.ollama4j.exceptions.OllamaBaseException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import javax.swing.SwingUtilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author lam
 */
public class trochuyen extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(trochuyen.class.getName());

    /**
     * Creates new form trochuyen
     */
    public trochuyen() {
        initComponents();
        setLocationRelativeTo(null);
    }
  

 private void chataiapisteam() {
        jButton7.setEnabled(false);
        String prompt = txtgui.getText();
        
String tam =txtnhan.getText();

        new Thread(() -> {
//  chatWithOpenRoutersteamtrue.chat(prompt,new MessageCallback() {
//    String tam = "";
//
//    @Override
//    public void onMessageReceived(String message) {
//        try {
//  byte[] bytes = message.getBytes("windows-1252");
//String decoded = new String(bytes, "UTF-8");
//
//    tam += "" + decoded;
//    txtnhan.setText(tam);
//} catch (UnsupportedEncodingException e) {
//    e.printStackTrace();
//}
//
            
                ////        tam += " " + message;
////        txtnhan.setText(tam); 
//    }
//});
// 
{
//            String apiKey="Bearer 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";
//            String model = "deepseek/deepseek-r1:free";
//String model="llama3-laptop-tuvan";
//String model = "llama3-laptop-tuvan";
//String model = "llama3.1-8b-vietnamese4096";
String model = "google/gemma-2-9b";
//String model="mistralai/mistral-7b-instruct-v0.3";
//String model="google/gemma-3-12b";
                String apiKey = "Bearer lm-studio";
//String Urlcreate="https://openrouter.ai/api/v1/chat/completions";
//String Urlcreate="http://localhost:1234/v1/chat/completions";
String Urlcreate="http://26.127.151.70:1234/v1/chat/completions";
//                String Urlcreate = "http://localhost:1234/v1/chat/completions";
//            String model1 = "anthropic/claude-3.7-sonnet";
                //   prompt="xin chào";
                String json = String.format("""
            {
              "model": "%s",
              "messages": [
                { "role": "user", "content": "%s" }
              ],
                "stream": true
            }
            """, model, prompt.replace("\"", "\\\""));
                PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8), true);
//out.println("Chào bạn! Đây là tiếng Việt có dấu.");

                //out.println("Payload JSON:\n" + json);
                System.out.println("\n 0");
                HttpRequest request = HttpRequest.newBuilder()
                        //                .uri(URI.create("https://openrouter.ai/api/v1/chat/completions"))
                        .uri(URI.create(Urlcreate))
                        //          .timeout(Duration.ofSeconds(30))
                        .header("Authorization", apiKey)
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString(json))
                        .build();
                System.out.println("\n 1");
                System.out.println("Sending request...");
                HttpClient client = HttpClient.newBuilder()
                        .version(HttpClient.Version.HTTP_1_1)
                        //    .connectTimeout(Duration.ofSeconds(30))
                        .build();
                System.out.println("11");
                long startTime = System.nanoTime();
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                HttpResponse<InputStream> response = null;
                try {
                    response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
                } catch (IOException ex) {
             //       System.getLogger(ViewProductJPanel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                } catch (InterruptedException ex) {
          //          System.getLogger(ViewProductJPanel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
                long endTime = System.nanoTime();
                long sominigiay = (endTime - startTime) / 1_000_000;

                BufferedReader reader = new BufferedReader(new InputStreamReader(response.body(), StandardCharsets.UTF_8));

                String line;
                StringBuilder fullText = new StringBuilder();
                try {
                    while ((line = reader.readLine()) != null) {
//            if(line.length()>0){
                        out.println("Chunk:" + line);
//            String tam=txtnhan.getText();
//            String mes=(Chuyenjointhanhvanbanthuongkieusteam.extractMessage(line));
                      //  String content = Chuyenjointhanhvanbanthuongkieusteam.extractMessage(line);
//          if(content.length()>0){
                        fullText.append(line);

//cleaned = cleaned.replaceAll("([.!?])(?=\\p{L})", "$1 ");
String cleaned = fullText.toString()
    .replaceAll("\\\\n", "\n") ;
//    .replaceAll("([.!?])(?=\\p{L})", "$1 ") 
//    .replaceAll("\\s{2,}", " ");
//                        txtnhan.setText(fullText.toString());
                        txtnhan.setText(cleaned);
//    txtnhan.setText(fullText.toString());
//          }
//            }

//            txtnhan.setText(tam+cleaned);
// out.println("Raw line: " + mes);
//XDialog.alert("Chuỗi gốc nhận được: " + mes);
                    }
                  String cleaned = fullText.toString()
    .replaceAll("\\\\n", "\n") 
    .replaceAll("([.!?])(?=\\p{L})", "$1 ") 
    .replaceAll("\\s{2,}", " ");
//                    txtnhan.setText(fullText.toString());
 cleaned= String.format("""
                 Phản hồi từ AI:
                ---------------------
                 %s

              
                """, cleaned );
//                    txtnhan.setText(cleaned);
                    txtnhan.setText(tam+" " +cleaned);
                } catch (IOException ex) {
                 //   System.getLogger(ViewProductJPanel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
            }

//    System.out.println("txtnhan"+txtnhan.getText());
            SwingUtilities.invokeLater(() -> {
// txtnhan.setText(tam+"\n"+rep);
                jButton7.setEnabled(true);
                txtnhan.setCaretPosition(txtnhan.getDocument().getLength());
            });
        }).start();

        txtgui.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bthienai = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtnhan = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtgui = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btguichoai = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bthienai.setText("Chat AI");
        bthienai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthienaiActionPerformed(evt);
            }
        });

        txtnhan.setEditable(false);
        jScrollPane3.setViewportView(txtnhan);

        jScrollPane5.setViewportView(txtgui);

        jLabel2.setText("Hỏi AI");

        jButton7.setText("chatapisteam");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton2.setText("Gửi local");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btguichoai.setText("gửi api");
        btguichoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btguichoaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                                .addComponent(jScrollPane5))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(393, 393, 393)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btguichoai)))
                .addGap(765, 765, 765))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton2)
                    .addComponent(btguichoai)))
        );

        jLabel1.setText("Hỏi đáp với AI");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1650, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bthienai)))
                    .addGap(0, 50, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 845, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 170, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(160, 724, Short.MAX_VALUE)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(620, 717, Short.MAX_VALUE)
                            .addComponent(bthienai)))
                    .addGap(0, 105, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bthienaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthienaiActionPerformed
        // TODO add your handling code here:
        if (jPanel2.isVisible()) {
            jPanel2.setVisible(false);
            btguichoai.setVisible(false);
            jButton7.setVisible(false);
            jButton2.setVisible(false);
            jButton2.setVisible(false);
        } else {
            btguichoai.setVisible(true);
            jPanel2.setVisible(true);
            jButton7.setVisible(true);
            jButton2.setVisible(true);
            jButton2.setVisible(true);
        }
    }//GEN-LAST:event_bthienaiActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        chataiapisteam();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    //    chatloclaai();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btguichoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btguichoaiActionPerformed
//        chataiapi();        // TODO add your handling code here:
    }//GEN-LAST:event_btguichoaiActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new trochuyen().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btguichoai;
    private javax.swing.JButton bthienai;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextPane txtgui;
    private javax.swing.JTextPane txtnhan;
    // End of variables declaration//GEN-END:variables
}
