/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imprimir;

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
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Ademar Zório Neto
 * @since Classe criada em 31/05/2017
 */
public class SavePDF {

    public void salvar(Component parentComponent, JTable tabela, JFileChooser chooser,
            String texto, String cnpj, String razaoSocial, String titulo, String data,
            String horario, String img) {
        parentComponent.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        Font fonteCabecalho = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
        Font fontePadrao = new Font(Font.FontFamily.HELVETICA, 12);
        Font fonteHeader = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
        String nome = chooser.getSelectedFile().getPath();
        if (!nome.substring(nome.length() - 4, nome.length()).equals(".pdf")) {
            nome = nome + ".pdf";
        }

        System.out.println(nome);
        boolean exists = (new File(nome)).exists();

        if (exists) {
            int confirma = JOptionPane.showConfirmDialog(parentComponent, "O arquivo "
                    + "já existe\nDeseja sobrescrevê-lo?",
                    "Sobrescrever arquivo", 0);
            if (confirma != 0) {
                //cancela e não salva
                return;
            }
        }
        // IMPRIMIR
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(nome));
            document.open();
            Paragraph paragraph = new Paragraph((data + " - " + horario), fontePadrao);
            paragraph.setAlignment(Element.ALIGN_RIGHT);
            document.add(paragraph);
            Image image = Image.getInstance(getClass().getResource(img));
            image.setAlignment(Element.ALIGN_MIDDLE);
            image.scaleToFit(150, 150);
            document.add(image);
            paragraph = new Paragraph(texto + "\n" + cnpj + "\n" + razaoSocial, fontePadrao);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);

            paragraph = new Paragraph(titulo, fonteCabecalho);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
            paragraph = new Paragraph("\n");
            document.add(paragraph);

            PdfPTable table = new PdfPTable(tabela.getColumnCount());
            table.setWidthPercentage(100);

            PdfPCell cell;

            for (int j = 0; j < tabela.getColumnCount(); j++) {
                cell = new PdfPCell(new Phrase(tabela.getColumnName(j), fonteHeader));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                table.addCell(cell);
            }
            table.setHeaderRows(1);

            // Serão criadas células na tabela
            // a ordem será da esquerda para a direita de criação
            // ao final de cada linha uma nova célula será criada na próxima
            // linha
            for (int i = 0; i < tabela.getRowCount(); i++) {
                for (int j = 0; j < tabela.getColumnCount(); j++) {
                    cell = new PdfPCell(new Phrase(tabela.getModel()
                            .getValueAt(i, j).toString(), fontePadrao));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    table.addCell(cell);
                }
            }

            document.add(table);
            JOptionPane.showMessageDialog(parentComponent, "Relatório salvo "
                    + "com sucesso!", "Concluído", -1);
        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex.getMessage(),
                    "Erro ao salvar", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(SavePDF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            document.close();
        }
        try {
            Desktop.getDesktop().open(new File(nome));
        } catch (IOException ex) {
            Logger.getLogger(SavePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        parentComponent.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

}
