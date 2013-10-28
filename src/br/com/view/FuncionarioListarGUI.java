package br.com.view;

import br.com.model.Funcionario;
import br.com.model.controller.FuncionarioController;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FuncionarioListarGUI extends javax.swing.JFrame {

    private JTable tabela;
    private DefaultTableModel modelo = new DefaultTableModel();

    public FuncionarioListarGUI() {
        initComponents();
        criaJTable();
        painelLista.setViewportView(tabela);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelFundo = new javax.swing.JPanel();
        lbPesquisar = new javax.swing.JLabel();
        txPesquisar = new javax.swing.JTextField();
        painelLista = new javax.swing.JScrollPane();
        btInserir = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelFundo.setBackground(new java.awt.Color(255, 255, 255));

        lbPesquisar.setText("Pesquisar:");

        txPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPesquisarActionPerformed(evt);
            }
        });

        btInserir.setText("Inserir");
        btInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInserirActionPerformed(evt);
            }
        });

        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelFundoLayout = new javax.swing.GroupLayout(painelFundo);
        painelFundo.setLayout(painelFundoLayout);
        painelFundoLayout.setHorizontalGroup(
            painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelFundoLayout.createSequentialGroup()
                        .addComponent(lbPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txPesquisar)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelFundoLayout.createSequentialGroup()
                        .addComponent(painelLista)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelFundoLayout.createSequentialGroup()
                .addContainerGap(257, Short.MAX_VALUE)
                .addComponent(btInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelFundoLayout.setVerticalGroup(
            painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFundoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPesquisar)
                    .addComponent(txPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btInserir)
                    .addComponent(btEditar)
                    .addComponent(btExcluir))
                .addGap(18, 18, 18)
                .addComponent(painelLista, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInserirActionPerformed
        // TODO add your handling code here:
        // Orientação a objeto (UsuarioInsertGUI ui para new UsuarioInsertGUI(modelo);)
        FuncionarioInserirGUI fi = new FuncionarioInserirGUI(modelo);
        fi.setLocationRelativeTo(null);
        fi.setVisible(true);
         this.dispose();

    }//GEN-LAST:event_btInserirActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // cria uma variavel inteira que pegara a linha selecionada
        int linhaSelecionada = -1;
        // pega a linha selecionada
        linhaSelecionada = tabela.getSelectedRow();
        // compara se a linha é maior ou igual a zero
        if (linhaSelecionada >= 0) {
            // cria a variavel para o ID do usuario e pega o numero de linhas e da coluna
            int idFuncionario = (int) tabela.getValueAt(linhaSelecionada, 0);
            // novo usuario controller
            FuncionarioController fc = new FuncionarioController();
            // se a operação der certo lá no usuario implements ele exclui a linha da tabela 
            if (fc.delete(idFuncionario)) {
                modelo.removeRow(linhaSelecionada);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma linha foi selecionada");
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        // cria uma linha 
        int linhaSelecionada = -1;
        // pega linha seleciona 
        linhaSelecionada = tabela.getSelectedRow();
        // compara se a linha é maior ou igual a zero
        if (linhaSelecionada >= 0) {
            //
            int idFuncionario = (int) tabela.getValueAt(linhaSelecionada, 0);
            FuncionarioInserirGUI fi = new FuncionarioInserirGUI(modelo, linhaSelecionada, idFuncionario);
            fi.setLocationRelativeTo(null);
            this.dispose();
            fi.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma linha foi selecionada");
        }
    }//GEN-LAST:event_btEditarActionPerformed

    private void txPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPesquisarActionPerformed
        // TODO add your handling code here:
        String nome = txPesquisar.getText();
        FuncionarioController fc = new FuncionarioController();
        fc.listByNome(nome);
       
        modelo.setNumRows(0);
        for (Funcionario f : fc.listByNome(nome)) {
            modelo.addRow(new Object[]{
                f.getId(),
                f.getNome(),
                f.getCpf(),
                f.getSalario()});
        }
    }//GEN-LAST:event_txPesquisarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btInserir;
    private javax.swing.JLabel lbPesquisar;
    private javax.swing.JPanel painelFundo;
    private javax.swing.JScrollPane painelLista;
    private javax.swing.JTextField txPesquisar;
    // End of variables declaration//GEN-END:variables

    private void criaJTable() {
        tabela = new JTable(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("Nome");
        modelo.addColumn("CPF");
        modelo.addColumn("Salário");
        preencheJTable();
    }

    private void preencheJTable() {
        FuncionarioController fc = new FuncionarioController();
        for (Funcionario f : fc.listarTodos()) {
            modelo.addRow(new Object[]{f.getId(), f.getNome(), f.getCpf(), f.getSalario()});
        }
    }
}