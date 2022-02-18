/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelasGui;

import Model.Cliente;
import View.IViewSimplesCRUD;
import java.util.List;
import Valids.LimiteLetras;
import Valids.LimiteNumeros;
import Valids.ValCPF;
import Valids.ValEmail;

/**
 *
 * @author otávio
 */
public class ClienteTela extends ViewGuiSimples implements IViewSimplesCRUD<Cliente>{

    
    private static ClienteTela tela;
    private boolean retornoOk;
    
    public boolean isRetornoOk(){
        return retornoOk;
    }
    
    public ClienteTela(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txtNome.setDocument(new LimiteLetras(20));
    }
    
    public static ClienteTela GetInstance(java.awt.Frame parent, boolean modal) {
        if (tela == null) {
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
            java.util.logging.Logger.getLogger(ClienteTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
            return new ClienteTela(parent, modal);
        }
        else{
            return tela;
        }
  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        txtCpf = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Nimbus Mono L", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cliente");
        lblTitulo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblNome.setText("Nome:");

        lblCpf.setText("CPF:");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        lblEmail.setText("E-mail:");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnOk.setBackground(new java.awt.Color(51, 255, 51));
        btnOk.setText("Cadastrar");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCpfFocusLost(evt);
            }
        });
        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEmail)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lblCpf)
                            .addGap(18, 18, 18)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblNome)
                            .addGap(18, 18, 18)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnOk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed

        
        if (txtNome.getText().isEmpty() || txtCpf.getText().isEmpty() || 
            txtEmail.getText().isEmpty()){
            this.showErrorMessage("Campo vazio!");        
        } else if (txtNome.getText().length() < 3) {
            this.showErrorMessage("O Nome deve conter no mínimo 3 caracteres!");
        
            this.showErrorMessage("Login deve conter no mínimo 4 caracteres!");
        } else if (ValCPF.isCPF(String.valueOf(txtCpf.getText())) == false) {
            this.showErrorMessage("CPF é invalido!");
        } else if (ValEmail.validaEmail(txtEmail.getText()) == false) {
            this.showErrorMessage("O Email informado é invalido!");
        }
        else{
            retornoOk = true;
            this.dispose();
        }
    }//GEN-LAST:event_btnOkActionPerformed


    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        retornoOk = false;

        this.dispose();
        //this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCpfFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfFocusLost

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
            java.util.logging.Logger.getLogger(ClienteTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ClienteTela dialog = new ClienteTela(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables

    


    
    
    @Override
    public Cliente criar() {
        this.limpaTela();
        this.prepararCriar();
        Cliente funcionario = null;

        this.setVisible(true);
        if(retornoOk){
            this.getScreenObject();
        }
        return funcionario;
    }

    
    
    public Cliente getScreenObject(){

        Cliente novo = new Cliente();
        novo.setNome(txtNome.getText());
        novo.setCpf(txtCpf.getText());
        novo.setEmail(txtEmail.getText());
        return novo;
    }
    
    public Cliente limpaTela(){
        
        txtNome.setText("");
        txtCpf.setText("");
        txtEmail.setText("");

        
        return null;
    }
    public void preencherTela(Cliente preencha){
        txtNome.setText(preencha.getNome());
        txtCpf.setText(String.valueOf(preencha.getCpf()));
        txtEmail.setText(preencha.getEmail());

    }
    
    @Override
    public void listar(List<Cliente> listas) {
        String lista = "";
        for (Cliente funcionario : listas) {
            if (funcionario != null) {
                lista += funcionario.toString() + "\n";
            }
        }
        showMessage(lista);
    }
    
    @Override
    public void mostrar(Cliente type) {
        this.prepararMostra(type);
        this.setVisible(true);
    }
   
    
    
    
    @Override
    public Cliente editar(Cliente funcionario) {
            
        this.prepararEditar(funcionario);

        this.setVisible(true);
        if(retornoOk){
            funcionario.setNome(txtNome.getText());
            funcionario.setCpf(txtCpf.getText());
            funcionario.setEmail(txtEmail.getText());

        }
        return funcionario;
    }

   
    
    @Override
    public boolean excluir(Cliente deletar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    

    @Override
    public void read(Cliente Type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


     public void prepararCriar(){
        lblTitulo.setText("Cadastro de Funcionário");
        
        txtNome.setText("");
        txtNome.setEditable(true);
        txtNome.setEnabled(true);
        
        txtCpf.setText("");
        txtCpf.setEditable(true);
        txtCpf.setEnabled(true);
        
        txtEmail.setText("");
        txtEmail.setEditable(true);
        txtEmail.setEnabled(true);
        
        
        btnOk.setText("Salvar");
        btnOk.setVisible(true);
        
        btnCancelar.setText("Cancelar");
        btnCancelar.setVisible(true);
        

    }
    
    
    public void prepararEditar(Cliente funcionario){

        lblTitulo.setText("Alterar Funcionario");

        txtNome.setText(funcionario.getNome());
        txtNome.setEditable(true);
        txtNome.setEnabled(true);
        
        txtCpf.setText(String.valueOf(funcionario.getCpf()));
        txtCpf.setEditable(true);
        txtCpf.setEnabled(true);
        
        txtEmail.setText(funcionario.getEmail());
        txtEmail.setEditable(true);
        txtEmail.setEnabled(true);
        
        
        btnOk.setText("Alterar");
        btnOk.setVisible(true);
        
        btnCancelar.setText("Cancelar");
        btnCancelar.setVisible(true);

                
    }
    
    
    public void prepararMostra(Cliente mostrar ){
        lblTitulo.setText("Dados Produto");
        
        txtNome.setText(mostrar.getNome());
        txtNome.setEditable(false);
        txtNome.setEnabled(false);
        
        txtCpf.setText(String.valueOf(mostrar.getCpf()));
        txtCpf.setEditable(false);
        txtCpf.setEnabled(false);
        
        txtEmail.setText(mostrar.getEmail());
        txtEmail.setEditable(false);
        txtEmail.setEnabled(false);
        
   
        
        btnOk.setText("Ok");
        btnOk.setVisible(true);
        
        btnCancelar.setText("Cancelar");
        btnCancelar.setVisible(false);

        

        
    }
    
}
