package br.com.view;

import br.com.model.Funcionario;
import br.com.model.controller.FuncionarioController;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FuncionarioInserirGUI extends javax.swing.JFrame {

    private DefaultTableModel modelo;
    private int linhaSelecionada;

    public FuncionarioInserirGUI(DefaultTableModel modelo) {
        this.modelo = modelo;
        this.linhaSelecionada = linhaSelecionada;
        initComponents();
    }

    FuncionarioInserirGUI(DefaultTableModel modelo, int linhaSelecionada, int idUsuario) {
        this.modelo = modelo;
        this.linhaSelecionada = linhaSelecionada;
        initComponents();
        FuncionarioController fc = new FuncionarioController();
        Funcionario f = fc.listById(idUsuario);
        
        txCodigo.setText(Integer.toString(f.getId()));
        txNome.setText(f.getNome());
        txRg.setText(f.getRg());
        txSalario.setText(String.valueOf(f.getSalario()));
        txCpf.setText(f.getCpf());
        txTelefone1.setText(f.getTelefoneContato1());
        txSenha.setText(f.getSenha());
        txLogin.setText(f.getLogin());
        txTelefone2.setText(f.getTelefoneContato2());
        txCtps.setText(f.getCtps());
        txEmail.setText(f.getEmail());



        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String data = sdf.format(f.getDataAdimissao());
        txDataNascimento.setText(data);
        txDataAdmissao.setText(data);

        if (f.getSexo().equals("Feminino")) {
            rbFeminino.setSelected(true);
        } else if (f.getSexo().equals("Masculino")) {
            rbMasculino.setSelected(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupSexo = new javax.swing.ButtonGroup();
        painelFundo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txLogin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txSenha = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txCpf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txTelefone1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txDataNascimento = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        rbMasculino = new javax.swing.JRadioButton();
        rbFeminino = new javax.swing.JRadioButton();
        btSalvar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txTelefone2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txRg = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txCtps = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txSalario = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txDataAdmissao = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txEmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        painelFundo.setBackground(new java.awt.Color(255, 255, 255));
        painelFundo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Cadastro de Funcionário\n", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        painelFundo.setPreferredSize(new java.awt.Dimension(610, 450));
        painelFundo.setLayout(null);

        jLabel1.setText("Código:");
        painelFundo.add(jLabel1);
        jLabel1.setBounds(15, 121, 50, 14);

        txCodigo.setEditable(false);
        txCodigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        painelFundo.add(txCodigo);
        txCodigo.setBounds(70, 120, 131, 16);

        jLabel2.setText("Nome:");
        painelFundo.add(jLabel2);
        jLabel2.setBounds(15, 143, 50, 14);

        txNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        painelFundo.add(txNome);
        txNome.setBounds(70, 142, 450, 16);

        jLabel3.setText("Login:");
        painelFundo.add(jLabel3);
        jLabel3.setBounds(15, 164, 50, 14);

        txLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        painelFundo.add(txLogin);
        txLogin.setBounds(70, 164, 141, 16);

        jLabel4.setText("Senha:");
        painelFundo.add(jLabel4);
        jLabel4.setBounds(330, 170, 50, 14);

        txSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txSenhaActionPerformed(evt);
            }
        });
        painelFundo.add(txSenha);
        txSenha.setBounds(390, 170, 130, 16);

        jLabel5.setText("CPF:");
        painelFundo.add(jLabel5);
        jLabel5.setBounds(15, 187, 50, 14);

        txCpf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        painelFundo.add(txCpf);
        txCpf.setBounds(70, 189, 141, 16);

        jLabel6.setText("Telefone 1:");
        painelFundo.add(jLabel6);
        jLabel6.setBounds(310, 190, 70, 14);

        txTelefone1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        painelFundo.add(txTelefone1);
        txTelefone1.setBounds(390, 190, 130, 16);

        jLabel7.setText("Data de Nascimento:");
        painelFundo.add(jLabel7);
        jLabel7.setBounds(265, 230, 120, 14);

        txDataNascimento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        painelFundo.add(txDataNascimento);
        txDataNascimento.setBounds(390, 230, 130, 16);

        jLabel8.setText("sexo:");
        painelFundo.add(jLabel8);
        jLabel8.setBounds(15, 320, 50, 14);

        rbMasculino.setBackground(new java.awt.Color(255, 255, 255));
        grupSexo.add(rbMasculino);
        rbMasculino.setText("Masculino");
        painelFundo.add(rbMasculino);
        rbMasculino.setBounds(70, 316, 90, 23);

        rbFeminino.setBackground(new java.awt.Color(255, 255, 255));
        grupSexo.add(rbFeminino);
        rbFeminino.setText("Feminino");
        painelFundo.add(rbFeminino);
        rbFeminino.setBounds(160, 316, 79, 23);

        btSalvar.setBackground(new java.awt.Color(255, 255, 255));
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Add2.png"))); // NOI18N
        btSalvar.setBorder(null);
        btSalvar.setContentAreaFilled(false);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        painelFundo.add(btSalvar);
        btSalvar.setBounds(410, 320, 35, 37);

        btLimpar.setBackground(new java.awt.Color(255, 255, 255));
        btLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Eraser.png"))); // NOI18N
        btLimpar.setBorder(null);
        btLimpar.setContentAreaFilled(false);
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });
        painelFundo.add(btLimpar);
        btLimpar.setBounds(450, 320, 35, 37);

        jLabel9.setText("Telefone 2:");
        painelFundo.add(jLabel9);
        jLabel9.setBounds(310, 210, 70, 14);

        txTelefone2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        painelFundo.add(txTelefone2);
        txTelefone2.setBounds(390, 210, 130, 16);

        jLabel10.setText("RG:");
        painelFundo.add(jLabel10);
        jLabel10.setBounds(15, 212, 50, 14);

        txRg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        painelFundo.add(txRg);
        txRg.setBounds(70, 211, 141, 16);

        jLabel12.setText("Ctps:");
        painelFundo.add(jLabel12);
        jLabel12.setBounds(15, 234, 50, 14);

        txCtps.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        painelFundo.add(txCtps);
        txCtps.setBounds(70, 233, 141, 16);

        jLabel13.setText("Salário: ");
        painelFundo.add(jLabel13);
        jLabel13.setBounds(15, 256, 50, 14);

        txSalario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        painelFundo.add(txSalario);
        txSalario.setBounds(70, 255, 141, 16);

        jLabel14.setText("Data de Adimissão:");
        painelFundo.add(jLabel14);
        jLabel14.setBounds(275, 250, 110, 14);

        txDataAdmissao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        painelFundo.add(txDataAdmissao);
        txDataAdmissao.setBounds(390, 250, 130, 16);

        jLabel15.setText("E-mail:");
        painelFundo.add(jLabel15);
        jLabel15.setBounds(15, 283, 50, 14);

        txEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        painelFundo.add(txEmail);
        txEmail.setBounds(70, 282, 450, 16);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/espuma 3.jpg"))); // NOI18N
        jLabel11.setText("jLabel11");
        painelFundo.add(jLabel11);
        jLabel11.setBounds(0, 20, 540, 70);

        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/return.png"))); // NOI18N
        btVoltar.setBorder(null);
        btVoltar.setContentAreaFilled(false);
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });
        painelFundo.add(btVoltar);
        btVoltar.setBounds(490, 320, 30, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelFundo, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelFundo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        Funcionario f = new Funcionario();

        if (!(txCodigo.getText().equals("") || ((txCodigo.getText().equals(null))))) {
            f.setId(Integer.parseInt(txCodigo.getText()));

        }
        f.setNome(txNome.getText());
        f.setTelefoneContato1(txTelefone1.getText());
        f.setTelefoneContato2(txTelefone2.getText());
        f.setEmail(txEmail.getText());
        f.setCpf(txCpf.getText());
        f.setRg(txRg.getText());
        f.setSalario(Double.parseDouble(txSalario.getText()));
        f.setCtps(txCtps.getText());
        f.setSenha(txSenha.getText());
        f.setLogin(txLogin.getText());

        if (rbFeminino.isSelected()) {
            f.setSexo("Feminino");
        } else if (rbMasculino.isSelected()) {
            f.setSexo("Masculino");
        }
        try {
            String data = txDataNascimento.getText();
            f.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(data));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao converter data.");
        }

        try {
            String data = txDataAdmissao.getText();
            f.setDataAdimissao(new SimpleDateFormat("dd/MM/yyyy").parse(data));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao converter data.");
        }

        FuncionarioController fc = new FuncionarioController();

        if (f.getId() == 0) {
            int id = fc.salvar(f);

            if (id > 0) {
                modelo.addRow(new Object[]{id, f.getNome(), f.getCpf(), f.getSalario()});
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
            }
        } else {
            int id = fc.salvar(f);
            if (id > 0) {
                modelo.removeRow(linhaSelecionada);
                modelo.addRow(new Object[]{id, f.getNome(), f.getCpf(), f.getSalario()});
                JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso");

            }

        }
        // comando fechar janela
        dispose();
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed

        txCodigo.setText("");
        txNome.setText("");
        txTelefone1.setText("");
        txTelefone2.setText("");
        txEmail.setText("");
        grupSexo.clearSelection();
        txDataNascimento.setText("");
        txCpf.setText("");
        txRg.setText("");
        txSalario.setText("");
        txDataAdmissao.setText("");
        txCtps.setText("");
        txSenha.setText("");
        txLogin.setText("");

    }//GEN-LAST:event_btLimparActionPerformed

    private void txSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txSenhaActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        // TODO add your handling code here:
        FuncionarioListarGUI fl = new FuncionarioListarGUI();
        fl.setLocationRelativeTo(null);
        this.dispose();
         fl.setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btVoltar;
    private javax.swing.ButtonGroup grupSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel painelFundo;
    private javax.swing.JRadioButton rbFeminino;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.JTextField txCodigo;
    private javax.swing.JTextField txCpf;
    private javax.swing.JTextField txCtps;
    private javax.swing.JTextField txDataAdmissao;
    private javax.swing.JTextField txDataNascimento;
    private javax.swing.JTextField txEmail;
    private javax.swing.JTextField txLogin;
    private javax.swing.JTextField txNome;
    private javax.swing.JTextField txRg;
    private javax.swing.JTextField txSalario;
    private javax.swing.JTextField txSenha;
    private javax.swing.JTextField txTelefone1;
    private javax.swing.JTextField txTelefone2;
    // End of variables declaration//GEN-END:variables
}
