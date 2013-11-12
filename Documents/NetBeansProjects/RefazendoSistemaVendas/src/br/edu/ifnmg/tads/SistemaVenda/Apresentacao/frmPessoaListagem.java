/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SistemaVenda.Apresentacao;


import br.edu.ifnmg.tads.SistemaVendas.DataAccess.PessoaDAO;
import br.edu.ifnmg.tads.SistemaVendas.DomainModel.Pessoa;

import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALUNO
 */
public class frmPessoaListagem extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmPessoaListagem
     */
    PessoaDAO dao;

    public frmPessoaListagem() {
        initComponents();

        dao = new PessoaDAO();

        List<Pessoa> pessoas = dao.ListarTodos();

        preencheTabela(pessoas);
    }

    private void preencheTabela(List<Pessoa> lista) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Codigo");
        model.addColumn("Nome");
        model.addColumn("Data Nascimento");

        for (Pessoa p : lista) {
            Vector valores = new Vector();
            valores.add(0, p.getCodigo());
            valores.add(1, p.getNome());
            valores.add(2, p.getDataNascimento());
            model.addRow(valores);
        }
        tblListagem.setModel(model);
        tblListagem.repaint();


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListagem = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Nome: ");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        tblListagem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblListagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListagemMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblListagem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnNovo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
       
    }//GEN-LAST:event_txtNomeActionPerformed

 // Cadastrar Novo
    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
       
      //Passagem de parametros nulos  
        Pessoa pessoa = new Pessoa();
        PessoaDAO daoNulo= new PessoaDAO();
        frmPessoaEditar janela = new frmPessoaEditar(pessoa, daoNulo);
        this.getParent().add(janela);
        janela.setVisible(true);
        this.setVisible(false);


    }//GEN-LAST:event_btnNovoActionPerformed

 //Efetua Busca
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
            Pessoa pessoa = new Pessoa();
          //  pessoa.setNome(txtNome.getText());
            try {
                if (txtNome.getText().length() == 0) {
                    List<Pessoa> lista = dao.ListarTodos();
                    preencheTabela(lista);
                } else {
                    pessoa.setNome(txtNome.getText());
                    List<Pessoa> lista = dao.buscar(pessoa);
                    preencheTabela(lista);

                }



            } catch (Exception ex) {
                
                System.err.print(ex);

            }

      


    }//GEN-LAST:event_btnBuscarActionPerformed

 // Editar
    private void tblListagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListagemMouseClicked

        //carregar o objeto para a edição
        Object valor = tblListagem.getValueAt(tblListagem.getSelectedRow(), 0);
        Pessoa p = dao.Abrir((int) valor);
        frmPessoaEditar janela = new frmPessoaEditar(p, dao);
        this.getParent().add(janela);
        janela.setVisible(true);
        this.setVisible(false);
        





        //  this.setVisible(false);
    }//GEN-LAST:event_tblListagemMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblListagem;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
