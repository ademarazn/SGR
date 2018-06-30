package VIEW;

import DAO.EmpresaDAO;
import DAO.ItemPedidoDAO;
import DAO.PedidoDAO;
import DOCUMENT.NumeroValidator;
import Entidade.Empresa;
import Entidade.ItemPedido;
import Entidade.Pedido;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import imprimir.SavePDF;
import java.awt.Desktop;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Ademar Zório Neto
 */
public class EfetuarPagamento extends javax.swing.JDialog {

    private Pedido pedido;

    /**
     * Creates new form EfetuarPagamento
     */
    public EfetuarPagamento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        novo();
        ((AbstractDocument) txtComanda.getDocument()).setDocumentFilter(new NumeroValidator(10, txtComanda));
        addEventoTeclaAtalho();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btConsultarComanda = new javax.swing.JButton();
        txtTotal = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCaixa = new javax.swing.JTable();
        txtComanda = new JTextFieldPersonalizado.JCTextField();
        btCancelar = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Caixa");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Caixa"));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Código da comanda");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Total");

        btConsultarComanda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/ic_search_18pt.png"))); // NOI18N
        btConsultarComanda.setText("Consultar");
        btConsultarComanda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btConsultarComandaMouseClicked(evt);
            }
        });

        txtTotal.setEditable(false);
        txtTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setText("0,0");

        tabelaCaixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabelaCaixa);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btConsultarComanda)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btConsultarComanda)
                    .addComponent(txtComanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/ic_cancel_18pt.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCancelarMouseClicked(evt);
            }
        });

        btConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/ic_done_18pt.png"))); // NOI18N
        btConfirmar.setText("Confirmar");
        btConfirmar.setEnabled(false);
        btConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btConfirmarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btConfirmar)
                        .addGap(10, 10, 10)
                        .addComponent(btCancelar))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btConfirmar))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btConsultarComandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btConsultarComandaMouseClicked
        novo();
        if (!txtComanda.getText().isEmpty()) {
            pedido = new PedidoDAO().consultarPedidoAtivoPorComanda(Integer.parseInt(txtComanda.getText()));
            if (pedido != null) {
                carregarTabelaItemPedido();
                btConfirmar.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog((Frame) getParent(), "Nenhum pedido está em aberto para essa comanda!");
            }
        }
    }//GEN-LAST:event_btConsultarComandaMouseClicked

    private void btConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btConfirmarMouseClicked
        if (btConfirmar.isEnabled()) {
            if (!txtComanda.getText().trim().isEmpty() && pedido != null) {
                if (JOptionPane.showConfirmDialog((Frame) getParent(), "Deseja realmente efetuar o "
                        + "pagamento?", "Efetuar Pagamento", 0) == 0) {
                    try {
                        pedido.setStatus(false);
                        new PedidoDAO().alterar(pedido);
                        btConfirmar.setEnabled(false);
                        JOptionPane.showMessageDialog((Frame) getParent(), "Pagamento efetuado com secesso!\n"
                                + "O recibo do pagamento será emitido logo em seguida!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog((Frame) getParent(), "Ocorreu um erro ao efetuar o pagamento!");
                    }
                    try {
                        Empresa empresa = new EmpresaDAO().consultar();
                        String cnpj = "";
                        String razaoSocial = "";
                        String data = "";
                        String horario = "";
                        String telefone = "";
                        String endereco = "";
                        if (empresa != null) {
                            try {
                                MaskFormatter maskFormatter = new MaskFormatter("##.###.###/####-##");
                                maskFormatter.setValueContainsLiteralCharacters(false);
                                cnpj = "CNPJ: " + maskFormatter.valueToString(empresa.getCnpj());
                                razaoSocial = "Razão Social: " + empresa.getRazaoSocial();
                                maskFormatter.setMask("(##) ####-####");
                                telefone = "Tel.: " + maskFormatter.valueToString(empresa.getTelefone());
                                maskFormatter.setMask("#####-###");
                                endereco = "End.: " + empresa.getEndereco() + ", " + empresa.getNum()
                                        + "\nBairro: " + empresa.getBairro() + "\n" + empresa.getCidade() + "/" + empresa.getEstado()
                                        + "\nCEP: " + maskFormatter.valueToString(empresa.getCep());
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog((Frame) getParent(), "Ocorreu um erro ao carregar os dados da empresa!");
                            }
                        } else {
                            JOptionPane.showMessageDialog((Frame) getParent(), "Não possui uma empresa cadastrada!");
                        }
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        SimpleDateFormat horarioFormat = new SimpleDateFormat("HH:mm:ss");
                        data = dateFormat.format(new Date());
                        horario = horarioFormat.format(new Date());
                        Font fonteCabecalho = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
                        Font fontePadrao = new Font(Font.FontFamily.HELVETICA, 12);
                        Font fonteHeader = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);

                        String nome = System.getProperty("user.home") + "\\Documents\\recibo" + (data.replace("/", "") + horario.replace(":", "")) + pedido.getPkPedido() + ".pdf";

                        System.out.println(nome);
                        // IMPRIMIR
                        Document document = new Document();
                        try {
                            PdfWriter.getInstance(document, new FileOutputStream(nome));
                            document.open();

                            PdfPTable table = new PdfPTable(tabelaCaixa.getColumnCount());
                            table.setWidthPercentage(100);

                            PdfPCell cell;

                            Paragraph paragraph = new Paragraph((data + " - " + horario), fontePadrao);
                            cell = new PdfPCell(paragraph);
                            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                            cell.setColspan(tabelaCaixa.getColumnCount());
                            cell.setBorder(0);
                            table.addCell(cell);

                            Image image = Image.getInstance(getClass().getResource("/imagem/logo-small.png"));
                            image.setAlignment(Element.ALIGN_MIDDLE);
                            image.scaleToFit(100, 100);
                            cell = new PdfPCell(image);
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                            table.addCell(cell);

                            paragraph = new Paragraph("Sistema de Gerenciamento de Restaurantes" + "\n" + cnpj + "\n" + razaoSocial + "\n" + telefone + "\n\nCupom Fiscal", fontePadrao);
                            cell = new PdfPCell(paragraph);
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                            cell.setColspan(tabelaCaixa.getColumnCount() - 1);
                            table.addCell(cell);

                            for (int j = 0; j < tabelaCaixa.getColumnCount(); j++) {
                                cell = new PdfPCell(new Phrase(tabelaCaixa.getColumnName(j), fonteHeader));
                                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                                table.addCell(cell);
                            }
                            table.setHeaderRows(3);

                            // Serão criadas células na tabela
                            // a ordem será da esquerda para a direita de criação
                            // ao final de cada linha uma nova célula será criada na próxima
                            // linha
                            for (int i = 0; i < tabelaCaixa.getRowCount(); i++) {
                                for (int j = 0; j < tabelaCaixa.getColumnCount(); j++) {
                                    cell = new PdfPCell(new Phrase(tabelaCaixa.getModel()
                                            .getValueAt(i, j).toString(), fontePadrao));
                                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                                    table.addCell(cell);
                                }
                            }
                            cell = new PdfPCell(new Phrase("Total", fonteHeader));
                            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                            cell.setColspan(tabelaCaixa.getColumnCount() - 1);
                            table.addCell(cell);
                            cell = new PdfPCell(new Phrase(txtTotal.getText()));
                            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                            table.addCell(cell);

                            cell = new PdfPCell(new Phrase("Cód. Cliente: " + pedido.getCliente().getPkCliente()));
                            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                            table.addCell(cell);

                            cell = new PdfPCell(new Phrase("Nome Cliente: " + pedido.getCliente().getNomeCliente()));
                            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                            cell.setColspan(tabelaCaixa.getColumnCount() - 1);
                            table.addCell(cell);

                            cell = new PdfPCell(new Phrase(endereco));
                            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                            cell.setColspan(tabelaCaixa.getColumnCount());
                            table.addCell(cell);

                            document.add(table);
                        } catch (DocumentException | FileNotFoundException ex) {
                            JOptionPane.showMessageDialog(getParent(), ex.getMessage(),
                                    "Erro ao salvar", JOptionPane.ERROR_MESSAGE);
                        } catch (IOException ex) {
                            Logger.getLogger(SavePDF.class.getName()).log(Level.SEVERE, null, ex);
                        } finally {
                            document.close();
                            Desktop.getDesktop().open(new File(nome));
                        }
                        String[] colunas = new String[]{
                            "Código", "Produto", "Quantidade", "Valor Unitário"
                        };
                        pedido = null;
                        setModeloTabela(tabelaCaixa, colunas);
                        txtComanda.getDocument().remove(0, txtComanda.getDocument().getLength());
                        txtTotal.setValue(0);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog((Frame) getParent(), "Ocorreu um erro ao gerar o recibo!");
                    }
                }
            }
        }
    }//GEN-LAST:event_btConfirmarMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        btCancelarMouseClicked(null);
    }//GEN-LAST:event_formWindowClosing

    private void btCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCancelarMouseClicked
        if (JOptionPane.showConfirmDialog((Frame) getParent(), "Deseja realmente cancelar?", "Cancelar", 0) == 0) {
            dispose();
        }
    }//GEN-LAST:event_btCancelarMouseClicked

    private void carregarTabelaItemPedido() {
        List<ItemPedido> itensPedido = new ItemPedidoDAO().consultarPorPedido(pedido.getPkPedido());
        String[] colunas = new String[]{
            "Código", "Produto", "Quantidade", "Valor Unitário"
        };
        setModeloTabela(tabelaCaixa, colunas);

        DefaultTableModel modelo = (DefaultTableModel) tabelaCaixa.getModel();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        tabelaCaixa.getColumnModel().getColumn(2).setCellRenderer(direita);
        tabelaCaixa.getColumnModel().getColumn(3).setCellRenderer(direita);
        float total = 0;
        for (ItemPedido i : itensPedido) {
            Object[] linha = new Object[]{
                i.getPkItemPedido(),
                i.getProduto().getNomeProduto(),
                i.getQtdProduto(),
                new java.text.DecimalFormat("#,##0.00").format(i.getPrecoVenda())
            };
            modelo.addRow(linha);
            total = total + i.getPrecoVenda() * i.getQtdProduto();
        }
        txtTotal.setValue(total);
    }

    private void setModeloTabela(JTable tabela, String[] colunas) {
        int lgt = colunas.length;
        boolean[] canEdit = new boolean[lgt];
        for (int i = 0; i < lgt; i++) {
            canEdit[i] = false;
        }
        DefaultTableModel modelo = new DefaultTableModel(null, colunas) {

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tabela.setModel(modelo);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.getParent().setBackground(new java.awt.Color(233, 232, 230));
        tabela.getColumnModel().getColumn(0).setPreferredWidth(73);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(tabela.getWidth() - 273);
    }

    private void novo() {
        String[] colunas = new String[]{
            "Código", "Produto", "Quantidade", "Valor Unitário"
        };
        setModeloTabela(tabelaCaixa, colunas);
    }

    private void addEventoTeclaAtalho() {
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "Consultar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        this.getRootPane().getActionMap().put("Consultar", new AbstractAction() {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent arg0) {
                btConsultarComanda.doClick();
                btConsultarComandaMouseClicked(null);
            }
        });
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0), "Confirmar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        this.getRootPane().getActionMap().put("Confirmar", new AbstractAction() {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent arg0) {
                btConfirmar.doClick();
                btConfirmarMouseClicked(null);
            }
        });
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancelar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        this.getRootPane().getActionMap().put("Cancelar", new AbstractAction() {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent arg0) {
                btCancelar.doClick();
                btCancelarMouseClicked(null);
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the SmartLookAndFeel look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EfetuarPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EfetuarPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EfetuarPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EfetuarPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EfetuarPagamento dialog = new EfetuarPagamento(new javax.swing.JFrame(), true);
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btConsultarComanda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaCaixa;
    private JTextFieldPersonalizado.JCTextField txtComanda;
    private javax.swing.JFormattedTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}