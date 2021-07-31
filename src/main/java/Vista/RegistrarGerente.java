package Vista;

import DAO.UsuariosDAO;
import Modelo.Cargo_;
import Modelo.Estado_;
import Modelo.Usuario_;
import java.awt.Image;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Alvaro Jose
 */
public class RegistrarGerente extends javax.swing.JFrame {

    private Login login;
    private UsuariosDAO uDao;
    private ResultSet rs;

    public RegistrarGerente() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/Miniatura2.png")).getImage();
        super.setIconImage(icon);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        signIn = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        txfUsuario = new javax.swing.JTextField();
        txfContraseña = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txfContraseña1 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Registrar Gerente");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 380, 100));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cabecera_.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 111));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        signIn.setBackground(new java.awt.Color(255, 255, 255));
        signIn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        signIn.setForeground(new java.awt.Color(255, 255, 255));
        signIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bton Login.png"))); // NOI18N
        signIn.setBorderPainted(false);
        signIn.setContentAreaFilled(false);
        signIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signIn.setFocusable(false);
        signIn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/bton login cursor oscuro.png"))); // NOI18N
        signIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(255, 255, 255));
        btnExit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bton salida.png"))); // NOI18N
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.setFocusable(false);
        btnExit.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/bton salida cursor oscuro.png"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        txfUsuario.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        txfUsuario.setForeground(new java.awt.Color(204, 204, 204));
        txfUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfUsuario.setText("USUARIO");
        txfUsuario.setToolTipText("");
        txfUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txfUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txfUsuarioMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txfUsuarioMouseReleased(evt);
            }
        });
        txfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfUsuarioActionPerformed(evt);
            }
        });
        txfUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfUsuarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfUsuarioKeyTyped(evt);
            }
        });

        txfContraseña.setForeground(new java.awt.Color(204, 204, 204));
        txfContraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfContraseña.setText("•••••••••••••••");
        txfContraseña.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txfContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txfContraseñaMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txfContraseñaMouseReleased(evt);
            }
        });
        txfContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfContraseñaActionPerformed(evt);
            }
        });
        txfContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfContraseñaKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Contraseña:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Usuario:");

        txfContraseña1.setForeground(new java.awt.Color(204, 204, 204));
        txfContraseña1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfContraseña1.setText("•••••••••••••••");
        txfContraseña1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txfContraseña1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txfContraseña1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txfContraseña1MouseReleased(evt);
            }
        });
        txfContraseña1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfContraseña1ActionPerformed(evt);
            }
        });
        txfContraseña1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfContraseña1KeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Repita su contraseña:");

        jLabel8.setText("Cree el nombre de usuario y la contraseña para el gerente.");

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LogoCVC.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(txfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(txfContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(signIn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExit))
                            .addComponent(txfContraseña1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Logo)
                .addGap(156, 156, 156))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addGap(3, 3, 3)
                .addComponent(txfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(3, 3, 3)
                .addComponent(txfContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addGap(3, 3, 3)
                .addComponent(txfContraseña1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(signIn)
                    .addComponent(btnExit))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txfUsuarioMouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 1) {

            if (txfContraseña.getText().length() == 0) {
                txfContraseña.setText("•••••••••••••••");
            } else {

                if (txfContraseña1.getText().length() == 0) {
                    txfContraseña1.setText("•••••••••••••••");

                } else {
                    if (txfUsuario.getText().equalsIgnoreCase("USUARIO")) {
                        txfUsuario.setText(null);

                    } else {
                    }
                }
            }
        }
    }//GEN-LAST:event_txfUsuarioMouseClicked

    private void txfUsuarioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txfUsuarioMouseReleased
        // TODO add your handling code here:

        if (txfContraseña.getText().length() == 0) {
            txfContraseña.setText("•••••••••••••••");
        } else {

            if (txfUsuario.getText().equalsIgnoreCase("USUARIO")) {
                txfUsuario.setText(null);

            } else {
            }
        }
    }//GEN-LAST:event_txfUsuarioMouseReleased

    private void txfUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfUsuarioKeyPressed
        // TODO add your handling code here:

        if (txfContraseña.getText().length() == 0) {
            txfContraseña.setText("•••••••••••••••");
        } else {

            if (txfUsuario.getText().equalsIgnoreCase("USUARIO")) {
                txfUsuario.setText(null);

            } else {
            }
        }
    }//GEN-LAST:event_txfUsuarioKeyPressed

    private void txfContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txfContraseñaMouseClicked

        if (evt.getClickCount() == 1) {
            if (txfUsuario.getText().length() == 0) {
                txfUsuario.setText("USUARIO");

            } else {

                if (txfContraseña1.getText().length() == 0) {
                    txfContraseña1.setText("•••••••••••••••");
                } else {
                    if (txfContraseña.getText().equalsIgnoreCase("•••••••••••••••")) {
                        txfContraseña.setText(null);
                    } else {
                    }
                }

            }
        }
    }//GEN-LAST:event_txfContraseñaMouseClicked

    private void txfContraseñaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txfContraseñaMouseReleased

        if (txfUsuario.getText().length() == 0) {
            txfUsuario.setText("USUARIO");
        } else {

            if (txfContraseña.getText().equalsIgnoreCase("•••••••••••••••")) {
                txfContraseña.setText(null);
            } else {
            }
        }
    }//GEN-LAST:event_txfContraseñaMouseReleased

    private void txfContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfContraseñaKeyPressed

        if (txfUsuario.getText().length() == 0) {
            txfUsuario.setText("USUARIO");
        } else {

            if (txfContraseña1.getText().length() == 0) {
                txfContraseña1.setText("•••••••••••••••");

            } else {

                if (txfContraseña.getText().equalsIgnoreCase("•••••••••••••••")) {
                    txfContraseña.setText(null);

                } else {
                }
            }
        }
    }//GEN-LAST:event_txfContraseñaKeyPressed

    private void txfContraseña1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txfContraseña1MouseClicked

        if (evt.getClickCount() == 1) {
            if (txfUsuario.getText().length() == 0) {
                txfUsuario.setText("USUARIO");
            } else {

                if (txfContraseña.getText().length() == 0) {
                    txfContraseña.setText("•••••••••••••••");
                } else {
                    if (txfContraseña1.getText().equalsIgnoreCase("•••••••••••••••")) {
                        txfContraseña1.setText(null);
                    } else {
                    }
                }
            }
        }
    }//GEN-LAST:event_txfContraseña1MouseClicked

    private void txfContraseña1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txfContraseña1MouseReleased

        if (txfUsuario.getText().length() == 0) {
            txfUsuario.setText("USUARIO");
        } else {

            if (txfContraseña1.getText().equalsIgnoreCase("•••••••••••••••")) {
                txfContraseña1.setText(null);
            } else {
            }
        }
    }//GEN-LAST:event_txfContraseña1MouseReleased

    private void txfContraseña1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfContraseña1KeyPressed

        if (txfUsuario.getText().length() == 0) {
            txfUsuario.setText("USUARIO");
        } else {

            if (txfContraseña1.getText().equalsIgnoreCase("•••••••••••••••")) {
                txfContraseña1.setText(null);

            } else {
            }
        }
    }//GEN-LAST:event_txfContraseña1KeyPressed

    private void signInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInActionPerformed

        verificar();

    }//GEN-LAST:event_signInActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void txfContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfContraseñaActionPerformed
        verificar();
    }//GEN-LAST:event_txfContraseñaActionPerformed

    private void txfContraseña1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfContraseña1ActionPerformed
        verificar();
    }//GEN-LAST:event_txfContraseña1ActionPerformed

    private void txfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfUsuarioActionPerformed
        verificar();
    }//GEN-LAST:event_txfUsuarioActionPerformed

    private void txfUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfUsuarioKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        } else {

        }

    }//GEN-LAST:event_txfUsuarioKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Logo;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton signIn;
    private javax.swing.JPasswordField txfContraseña;
    private javax.swing.JPasswordField txfContraseña1;
    private javax.swing.JTextField txfUsuario;
    // End of variables declaration//GEN-END:variables

    public void verificar() {

        if (txfUsuario.getText().length() == 0 || txfContraseña.getText().length() == 0
                || txfContraseña1.getText().length() == 0 || txfUsuario.getText().equals("USUARIO")
                || txfContraseña.getText().equals("•••••••••••••••")) {

            JOptionPane.showMessageDialog(null, "Llene todos los campos, por favor.");

        } else {

            if (!txfContraseña.getText().equals(txfContraseña1.getText())) {

                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden. Verifique la información.");

            } else {

                    uDao = new UsuariosDAO();
                    String usuario = txfUsuario.getText();
                    String contraseña = txfContraseña.getText();
                    Usuario_ gerente = new Usuario_(usuario, contraseña, Cargo_.GERENTE, "Adriana", "Rodriguez", "3174016609", "Calle 45b #25-75", Estado_.ACTIVO);

                    if (uDao.CrearUsuario(gerente)) {

                        Login login = new Login();
                        login.setVisible(true);
                        dispose();

                    } else {

                        JOptionPane.showMessageDialog(null, "No se ha podido registrar el gerente, revise su información nuevamente.");
                    }

                
            }

        }
    }

}
