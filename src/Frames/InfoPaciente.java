/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import clases.Conexion;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author PRIDE OMEGA
 */
public class InfoPaciente extends javax.swing.JFrame {

    /**
     * Creates new form InfoPaciente
     */
    private int pacienteID;
    public InfoPaciente() {
        initComponents();
        this.setLocationRelativeTo(null);   
        this.setTitle("Info Paciente");
        //System.out.println("Entrando sin paciente Id");
    }
    
    public InfoPaciente(int pacID) throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null); 
        this.setTitle("Info Paciente");
       
        pacienteID = pacID;
        boolean tmp = getData(pacID);
        if(!tmp){
            setFalseData(pacID);
        }
    }
    
    private ImageIcon imagen;
    private Icon icono;
    
    private void setFalseData(int pacID) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Conexion conn = new Conexion();
        Connection con  = conn.getConnection();
        
        String sqlQuery = "select Nombre_completo,Genero,Edad from  pacientes where ID_Paciente = "+pacID;
        
        ps = con.prepareStatement(sqlQuery);
        rs = ps.executeQuery();
        
        if(rs.next()){
            NameField.setText(rs.getObject(1).toString());
            genderField.setText(rs.getObject(2).toString());
            ageField.setText(rs.getObject(3).toString());
            
            cambiarIcono(tipoPaciente,"NoData");
            
            IMCField.setText("--");
            IMMField.setText("--");
            PesoField.setText("--");
            cinturaField.setText("--");
            brazoField.setText("--");
            estaturaField.setText("--");
            avancesBtn.setVisible(false);
            avancesImg.setVisible(false);
            plAl.setVisible(false);
            plAlImg.setVisible(false);
        }
        
        
    }
    private boolean getData(int pacID) throws SQLException{
        //System.err.println("Entrando al getDataaaa");
        
        int i = verifyValues(pacID);
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Conexion conn = new Conexion();
        Connection con  = conn.getConnection();
        String sqlQuery = "";
        if(i == 0){
            sqlQuery = "select p.Nombre_completo,p.Genero,p.Edad,p.Actividad, m.IMC, m.IMM, m.Peso, m.Cintura,m.Brazo,m.Estatura from medidas as m,pacientes as p where p.ID_Paciente = m.ID_Paciente AND p.ID_Paciente = "+pacID;
        }else{
            sqlQuery = "select p.Nombre_completo,p.Genero,p.Edad,p.Actividad, m.IMC, m.IMM, m.Peso, m.Cintura,m.Brazo,m.Estatura from medidas as m,pacientes as p where p.ID_Paciente = m.ID_Paciente AND p.ID_Paciente = "+pacID+" and m.ID_Medida = "+i;
        }
        
        ps = con.prepareStatement(sqlQuery);
        rs = ps.executeQuery();
        
        ResultSetMetaData rsMd = rs.getMetaData();
        
        int xd = rsMd.getColumnCount();
        if(!rs.next()){
            System.out.println("Este compa no tiene detalles aun unu");
            return false;
        }else{
            //System.out.println("Aqui andamos porque aca fue donde nos puso la vida");
            NameField.setText(rs.getObject(1).toString());
            genderField.setText(rs.getObject(2).toString());
            ageField.setText(rs.getObject(3).toString());
            
            String tipo = rs.getObject(4).toString();
            
            cambiarIcono(tipoPaciente,tipo);
            
            IMCField.setText(rs.getObject(5).toString());
            IMMField.setText(rs.getObject(6).toString());
            PesoField.setText(rs.getObject(7).toString());
            cinturaField.setText(rs.getObject(8).toString());
            brazoField.setText(rs.getObject(9).toString());
            estaturaField.setText(rs.getObject(10).toString());
            
            return true;
        }
    }
    private void cambiarIcono(JLabel lbl, String tipo) {
        String url = "src/src/";
        if(null != tipo)switch (tipo) {
            case "Nada":
                url+="Nada.png";
                break;
            case "Deportes":
                url+="Deportes.png";
                break;
            case "Pesas":
                url+="Pesas.png";
                break;
            case "Crossfit":
                url+="Crossfit.png";
                break;
            case "NoData":
                url+="NoData.png";
                break;
            default:
                url+="Nada.png";
                break;
        }
        this.imagen = new ImageIcon(url);
        this.icono = new ImageIcon(this.imagen.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
        lbl.setIcon(this.icono);
        this.repaint();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Proceso = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tipoPaciente = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NameField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        ageField = new javax.swing.JTextField();
        genderField = new javax.swing.JTextField();
        IMCField = new javax.swing.JTextField();
        IMMField = new javax.swing.JTextField();
        cinturaField = new javax.swing.JTextField();
        brazoField = new javax.swing.JTextField();
        estaturaField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        avancesImg = new javax.swing.JLabel();
        avancesBtn = new javax.swing.JLabel();
        plAlImg = new javax.swing.JLabel();
        plAl = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        PesoField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(229, 229, 229));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/error.png"))); // NOI18N
        jLabel1.setToolTipText("Salir");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 60, -1, -1));

        tipoPaciente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(tipoPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 64, 70));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Nombre");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        NameField.setEditable(false);
        NameField.setBackground(new java.awt.Color(153, 153, 153));
        NameField.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        NameField.setForeground(new java.awt.Color(255, 255, 255));
        NameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NameField.setBorder(null);
        jPanel1.add(NameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 398, 38));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 626, 10));

        ageField.setEditable(false);
        ageField.setBackground(new java.awt.Color(153, 153, 153));
        ageField.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ageField.setForeground(new java.awt.Color(255, 255, 255));
        ageField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(ageField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 52, 38));

        genderField.setEditable(false);
        genderField.setBackground(new java.awt.Color(153, 153, 153));
        genderField.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        genderField.setForeground(new java.awt.Color(255, 255, 255));
        genderField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(genderField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 52, 38));

        IMCField.setEditable(false);
        IMCField.setBackground(new java.awt.Color(153, 153, 153));
        IMCField.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        IMCField.setForeground(new java.awt.Color(255, 255, 255));
        IMCField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(IMCField, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 197, 52, 38));

        IMMField.setEditable(false);
        IMMField.setBackground(new java.awt.Color(153, 153, 153));
        IMMField.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        IMMField.setForeground(new java.awt.Color(255, 255, 255));
        IMMField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(IMMField, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 253, 52, 38));

        cinturaField.setEditable(false);
        cinturaField.setBackground(new java.awt.Color(153, 153, 153));
        cinturaField.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cinturaField.setForeground(new java.awt.Color(255, 255, 255));
        cinturaField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(cinturaField, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 197, 52, 38));

        brazoField.setEditable(false);
        brazoField.setBackground(new java.awt.Color(153, 153, 153));
        brazoField.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        brazoField.setForeground(new java.awt.Color(255, 255, 255));
        brazoField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(brazoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 253, 52, 38));

        estaturaField.setEditable(false);
        estaturaField.setBackground(new java.awt.Color(153, 153, 153));
        estaturaField.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        estaturaField.setForeground(new java.awt.Color(255, 255, 255));
        estaturaField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(estaturaField, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 309, 52, 38));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Edad");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("Género");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, -1, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setText("IMC");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 206, -1, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel7.setText("IMM");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 262, -1, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel9.setText("Cintura");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 206, -1, -1));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel10.setText("Estatura");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 318, -1, -1));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel11.setText("Brazo");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 262, -1, -1));

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Medidas último avance capturado");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 250, 32));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/flecha-izquierda (1).png"))); // NOI18N
        jLabel2.setToolTipText("Regresar");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 390, -1, -1));

        avancesImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/diario.png"))); // NOI18N
        avancesImg.setToolTipText("Visualizar avances");
        avancesImg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        avancesImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avancesImgMouseClicked(evt);
            }
        });
        jPanel1.add(avancesImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 60, 60));

        avancesBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/button.png"))); // NOI18N
        avancesBtn.setToolTipText("Visualizar avances");
        avancesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        avancesBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avancesBtnMouseClicked(evt);
            }
        });
        jPanel1.add(avancesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 375, -1, -1));

        plAlImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/dieta.png"))); // NOI18N
        plAlImg.setToolTipText("Ver plan alimenticio");
        plAlImg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        plAlImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plAlImgMouseClicked(evt);
            }
        });
        jPanel1.add(plAlImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 70, 60));

        plAl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/planAl.png"))); // NOI18N
        plAl.setToolTipText("Ver plan alimenticio");
        plAl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        plAl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plAlMouseClicked(evt);
            }
        });
        jPanel1.add(plAl, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 375, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/programar.png"))); // NOI18N
        jLabel17.setToolTipText("Ver citas");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, 70, 70));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/citas.png"))); // NOI18N
        jLabel14.setToolTipText("Ver citas");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, -1, -1));

        PesoField.setEditable(false);
        PesoField.setBackground(new java.awt.Color(153, 153, 153));
        PesoField.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        PesoField.setForeground(new java.awt.Color(255, 255, 255));
        PesoField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(PesoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 309, 52, 38));

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel15.setText("Peso");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 318, -1, -1));

        jLabel16.setBackground(new java.awt.Color(197, 152, 38));
        jLabel16.setOpaque(true);
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 30));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/completed-task (1).png"))); // NOI18N
        jLabel22.setToolTipText("Agregar medidas");
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, -1, -1));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/agregarChiquito.png"))); // NOI18N
        jLabel20.setToolTipText("Agregar medidas");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 120, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        Main mn = null;
        try {
            mn = new Main();
        } catch (Exception ex) {
            Logger.getLogger(InfoPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
        mn.setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void avancesBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avancesBtnMouseClicked
        // TODO add your handling code here:
        moveToAvances();
    }//GEN-LAST:event_avancesBtnMouseClicked

    private void plAlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plAlMouseClicked
        // TODO add your handling code here:
        moveToPlan();
    }//GEN-LAST:event_plAlMouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        moveToCitas();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        moveToCitas();
    }//GEN-LAST:event_jLabel17MouseClicked

    private void plAlImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plAlImgMouseClicked
        moveToPlan();
    }//GEN-LAST:event_plAlImgMouseClicked

    private void avancesImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avancesImgMouseClicked
        moveToAvances();
    }//GEN-LAST:event_avancesImgMouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        try {
            // TODO add your handling code here:
            moteToNuevasMedidas(pacienteID);
        } catch (SQLException ex) {
            Logger.getLogger(InfoPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        try {
            // TODO add your handling code here:
            moteToNuevasMedidas(pacienteID);
        } catch (SQLException ex) {
            Logger.getLogger(InfoPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel22MouseClicked

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
            java.util.logging.Logger.getLogger(InfoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IMCField;
    private javax.swing.JTextField IMMField;
    private javax.swing.JTextField NameField;
    private javax.swing.JTextField PesoField;
    private static javax.swing.ButtonGroup Proceso;
    private javax.swing.JTextField ageField;
    private javax.swing.JLabel avancesBtn;
    private javax.swing.JLabel avancesImg;
    private javax.swing.JTextField brazoField;
    private javax.swing.JTextField cinturaField;
    private javax.swing.JTextField estaturaField;
    private javax.swing.JTextField genderField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel plAl;
    private javax.swing.JLabel plAlImg;
    private javax.swing.JLabel tipoPaciente;
    // End of variables declaration//GEN-END:variables

    private void moveToCitas() {
        citasDePacientes cdp = new citasDePacientes(pacienteID);
        this.dispose();
        cdp.setVisible(true);
    }

    private void moveToPlan() {
        PlanAlimenticio pa = new PlanAlimenticio(pacienteID);
        this.dispose();
        pa.setVisible(true);
    }

    private void moveToAvances() {
        Avances av = new Avances();
        this.dispose();
        av.setVisible(true);
    }

    private void moteToNuevasMedidas(int id) throws SQLException {
       // System.err.println("ahhh con razon xd");
        NuevasMedidasPaciente nmp = new NuevasMedidasPaciente(id);
        nmp.setVisible(true);
        this.dispose();
    }

    private int verifyValues(int pacID) throws SQLException {        
        //;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Conexion conn = new Conexion();
        Connection con  = conn.getConnection();
        
        String sqlQuery = "select citaNumero, ID_Medida from fechas where ID_Paciente = "+pacID+" order by citaNumero desc limit 1";
        System.err.println("Buscando ultima cita del paciente "+pacID);
        //Este nos trae el numero y id de la ultima cita 
        
        ps = con.prepareStatement(sqlQuery);
        rs = ps.executeQuery();
        
        if(rs.next()){
            return Integer.parseInt(rs.getObject(2).toString());
            
        }else{
            return 0;
        }
        
    }

    
}
