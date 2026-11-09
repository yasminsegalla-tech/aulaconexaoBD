package View;

import DAO.ClienteDAO;
import Model.Cliente;
import Util.Validacoes;


import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class CadastroCliente extends javax.swing.JFrame {
    
    
    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName());

    // Objeto responsável por acessar o banco de dados
    private final ClienteDAO clienteDAO = new ClienteDAO();

    // Construtor da tela
    public CadastroCliente() {

        initComponents();

        // Carrega os clientes ao abrir a tela
        carregarDadosDoBancoCliente();

        // Permite selecionar um cliente na tabela
        tabelaDados.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                preencherCamposSelecionados();
            }
        });
    }
    private void carregarDadosDoBancoCliente() {

    List<Cliente> clientes = ClienteDAO.listar();

    preencherTabela(clientes);
 
}
    private void preencherTabela(List<Cliente> clientes) {

    DefaultTableModel modelo =
            (DefaultTableModel) tabelaDados.getModel();

    modelo.setRowCount(0);

    for (Cliente cliente : clientes) {

        modelo.addRow(new Object[]{
            cliente.getId(),
            cliente.getNome(),
            cliente.getCpf(),
           
        });
    }
}
    private void preencherCamposSelecionados() {

    int linha = tabelaDados.getSelectedRow();

    if (linha != -1) {

        txtNome.setText(
                tabelaDados.getValueAt(linha, 1).toString()
        );

        txtCpf.setText(
                tabelaDados.getValueAt(linha, 2).toString()
        );

    }
}
    private void limparCampos() {

    txtNome.setText("");
    txtCpf.setText("");
    

    tabelaDados.clearSelection();

    }
    
       

               
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        txtIdade = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDados = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jBSalvar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Clientes");
        setResizable(false);

        jDesktopPane1.setBackground(new java.awt.Color(204, 204, 204));
        jDesktopPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro Cliente"));

        jLabel1.setText("*Nome");

        txtNome.addActionListener(this::txtNomeActionPerformed);

        jLabel3.setText("*CPF");

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel9.setText("Idade");

        txtIdade.addActionListener(this::txtIdadeActionPerformed);

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtCpf, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtIdade, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)
                        .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                        .addComponent(txtCpf)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tabelaDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "CPF", "IDADE"
            }
        ));
        jScrollPane1.setViewportView(tabelaDados);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel8.setText("OS CAMPOS MARCADOS COM * SÃO OBRIGATORIOS ");

        jBSalvar.setText("SALVAR");
        jBSalvar.addActionListener(this::jBSalvarActionPerformed);

        jBExcluir.setText("Excluir Dados ");
        jBExcluir.addActionListener(this::jBExcluirActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(142, 142, 142)
                        .addComponent(jBExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(131, 131, 131)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar)
                    .addComponent(jBExcluir))
                .addGap(0, 128, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        String nome = txtNome.getText();
    String cpf = txtCpf.getText();
    
    // Valida os dados
    if (!Validacoes.validarCliente(nome, cpf, idade)) {

        JOptionPane.showMessageDialog(
                this,
                "Verifique os dados informados!\n"
                + "Nome, CPF ou idade inválidos."
        );

        return;
    }

    // Cria o objeto Cliente
    Cliente cliente = new Cliente();

    cliente.setNome(nome);
    cliente.setCpf(Validacoes.formatarCPF(cpf));
    
    // Solicita ao DAO o cadastro no banco
    if (clienteDAO.cadastrar(cliente)) {

        JOptionPane.showMessageDialog(
                this,
                "Cliente cadastrado com sucesso!"
        );

        limparCampos();
        carregarDadosDoBancoCliente();

    } else {

        JOptionPane.showMessageDialog(
                this,
                "Erro ao cadastrar cliente!"
        );
    }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void txtIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdadeActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
         int linha = tabelaDados.getSelectedRow();

    if (linha == -1) {

        JOptionPane.showMessageDialog(
                this,
                "Selecione um cliente na tabela!"
        );

        return;
    }

    int id = Integer.parseInt(
            tabelaDados.getValueAt(linha, 0).toString()
    );

    int resposta = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente excluir este cliente?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION
    );

    if (resposta == JOptionPane.YES_OPTION) {

        if (clienteDAO.excluir(id)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Cliente excluído com sucesso!"
            );

            limparCampos();
            carregarDadosDoBancoCliente();

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao excluir cliente!"
            );
        }
    }
    }//GEN-LAST:event_jBExcluirActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new CadastroCliente().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaDados;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables

}