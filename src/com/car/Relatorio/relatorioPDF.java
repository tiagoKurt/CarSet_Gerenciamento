package com.car.Relatorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.car.Ferramentas.ConexaoBD;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class relatorioPDF {

    private Connection conexao = null;

    public relatorioPDF() throws Exception {
        conexao = ConexaoBD.getConexao();
    }

    public static void main(String[] args) {

    }

    public void gerarRelatorioGastosGeral() {
        String sql = "select * from gastosgeral order by datagasto";

        try {
            Statement statment = conexao.createStatement();
            ResultSet rs = statment.executeQuery(sql);

            gerarRelatorioGeralPDF(rs);

            rs.close();
            statment.close();
        } catch (SQLException erro) {

        }
    }

    public void gerarRelatorioGastosCombustivel() {
        String sql = "select tipogasto, veiculos.placa, descgasto, qtdlcomb, valorlitrocomb, kmplcarro,\n"
                + "dataabast from gastos_combustivel inner join  veiculos on\n"
                + "gastos_combustivel.id_veiculo = veiculos.id order by dataabast";

        try {
            Statement statment = conexao.createStatement();
            ResultSet rs = statment.executeQuery(sql);

            gerarRelatorioCombustivelPDF(rs);

            rs.close();
            statment.close();
        } catch (SQLException erro) {

        }
    }

    public void gerarRelatorioGastosMecanico() {
        String sql = "select tipogasto, veiculos.placa , descgasto, descitemman, qtditemman,\n"
                + "valoritemman, valormaoobra, datamanutencao from gastos_mecanico inner join veiculos\n"
                + "on gastos_mecanico.id_veiculo = veiculos.id order by datamanutencao";

        try {
            Statement statment = conexao.createStatement();
            ResultSet rs = statment.executeQuery(sql);

            gerarRelatorioMecanicoPDF(rs);

            rs.close();
            statment.close();
        } catch (SQLException erro) {

        }
    }

    public void gerarRelatorioGastosSeguro() {
        String sql = "select tipogasto, veiculos.placa , descgasto, valorfranquia, datapagamento \n"
                + "from gastos_seguro inner join veiculos on \n"
                + "gastos_seguro.id_veiculo = veiculos.id order by datapagamento";

        try {
            Statement statment = conexao.createStatement();
            ResultSet rs = statment.executeQuery(sql);

            gerarRelatorioSeguroPDF(rs);

            rs.close();
            statment.close();
        } catch (SQLException erro) {

        }
    }

    public static void gerarRelatorioCombustivelPDF(ResultSet rs) {

        try {
            Document relatorioPDF = new Document(PageSize.A4, 36, 36, 36, 36);
            PdfWriter escritor = PdfWriter.getInstance(relatorioPDF, new FileOutputStream("./src/com/car/Relatorio/RelatorioDeCombustivel.pdf"));
            relatorioPDF.setPageSize(PageSize.A4);

            relatorioPDF.open();

            Image logoImagem = Image.getInstance("./src/com/car/visao/icons/skr.jpg");
            logoImagem.scaleToFit(175, 175);
            relatorioPDF.add(logoImagem);
            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

            relatorioPDF.add(new Paragraph("   RELÁTORIO DOS GASTOS COM COMBUSTÍVEL"));
            relatorioPDF.bottomMargin();

            while (rs.next()) {
                String tipoDoGasto = rs.getString("tipogasto");
                String descGasto = rs.getString("descgasto");
                String placaVeiculo = rs.getString("placa");
                float qntLitros = rs.getFloat("qtdlcomb");
                float valorLitro = rs.getFloat("valorlitrocomb");
                float kmPorLitro = rs.getFloat("kmplcarro");
                Date datagasto = rs.getDate("dataabast");

                PdfContentByte contentByte = escritor.getDirectContent();

//                contentByte.moveTo(relatorioPDF.left(), relatorioPDF.top());
//                contentByte.lineTo(relatorioPDF.right(), relatorioPDF.top());
//                contentByte.stroke();
//
//                contentByte.moveTo(relatorioPDF.left(), relatorioPDF.bottom());
//                contentByte.lineTo(relatorioPDF.right(), relatorioPDF.bottom());
//                contentByte.stroke();
//
//                contentByte.moveTo(relatorioPDF.left(), relatorioPDF.bottom());
//                contentByte.lineTo(relatorioPDF.left(), relatorioPDF.top());
//                contentByte.stroke();
//
//                contentByte.moveTo(relatorioPDF.right(), relatorioPDF.bottom());
//                contentByte.lineTo(relatorioPDF.right(), relatorioPDF.top());
//                contentByte.stroke();
                contentByte.setLineWidth(1f);
                contentByte.moveTo(relatorioPDF.leftMargin(), relatorioPDF.topMargin() - 10);
                contentByte.lineTo(relatorioPDF.getPageSize().getWidth() - relatorioPDF.rightMargin(), relatorioPDF.topMargin() - 10);
                contentByte.stroke();

                Paragraph paragrafo = new Paragraph("   Tipo do gasto: " + tipoDoGasto);
                Paragraph paragrafo2 = new Paragraph("   Descrição do gasto: " + descGasto);
                Paragraph paragrafo3 = new Paragraph("   Veículo abastecido: " + placaVeiculo);
                Paragraph paragrafo4 = new Paragraph("   Quantidade de litros abastecidos: " + qntLitros);
                Paragraph paragrafo5 = new Paragraph("   Valor do litro abastecidos: " + valorLitro);
                Paragraph paragrafo6 = new Paragraph("   Quantos KM/l o veículos faz: " + kmPorLitro);
                Paragraph paragrafo7 = new Paragraph("   Data do abastecimento: " + datagasto);
                Paragraph pularLinha = new Paragraph("\n");

                paragrafo.setFont(font);
                paragrafo2.setFont(font);
                paragrafo3.setFont(font);
                paragrafo4.setFont(font);

                relatorioPDF.add(paragrafo);
                relatorioPDF.add(paragrafo2);
                relatorioPDF.add(paragrafo3);
                relatorioPDF.add(paragrafo4);
                relatorioPDF.add(paragrafo5);
                relatorioPDF.add(paragrafo6);
                relatorioPDF.add(paragrafo7);

                relatorioPDF.add(pularLinha);

                LineSeparator linhaSeparadora = new LineSeparator();
                relatorioPDF.add(linhaSeparadora);
            }

            relatorioPDF.close();

        } catch (DocumentException doc) {
            doc.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SQLException ex) {

        }
    }

    public static void gerarRelatorioMecanicoPDF(ResultSet rs) {

        try {
            Document relatorioPDF = new Document(PageSize.A4, 36, 36, 36, 36);
            PdfWriter escritor = PdfWriter.getInstance(relatorioPDF, new FileOutputStream("./src/com/car/Relatorio/RelatorioDoMecanico.pdf"));
            relatorioPDF.setPageSize(PageSize.A4);

            relatorioPDF.open();

            Image logoImagem = Image.getInstance("./src/com/car/visao/icons/skr.jpg");
            logoImagem.scaleToFit(175, 175);
            relatorioPDF.add(logoImagem);
            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

            relatorioPDF.add(new Paragraph("   RELÁTORIO DOS GASTOS COM MECÂNICO"));
            relatorioPDF.bottomMargin();

            while (rs.next()) {
                String tipoDoGasto = rs.getString("tipogasto");
                String descGasto = rs.getString("descgasto");
                String placaVeiculo = rs.getString("placa");
                String descricaoDoItem = rs.getString("descitemman");
                int qntItem = rs.getInt("qtditemman");
                float valorItem = rs.getFloat("valoritemman");
                float valorMaoDeObra = rs.getFloat("valormaoobra");
                Date dataMecanico = rs.getDate("datamanutencao");

                PdfContentByte contentByte = escritor.getDirectContent();

//                contentByte.moveTo(relatorioPDF.left(), relatorioPDF.top());
//                contentByte.lineTo(relatorioPDF.right(), relatorioPDF.top());
//                contentByte.stroke();
//
//                contentByte.moveTo(relatorioPDF.left(), relatorioPDF.bottom());
//                contentByte.lineTo(relatorioPDF.right(), relatorioPDF.bottom());
//                contentByte.stroke();
//
//                contentByte.moveTo(relatorioPDF.left(), relatorioPDF.bottom());
//                contentByte.lineTo(relatorioPDF.left(), relatorioPDF.top());
//                contentByte.stroke();
//
//                contentByte.moveTo(relatorioPDF.right(), relatorioPDF.bottom());
//                contentByte.lineTo(relatorioPDF.right(), relatorioPDF.top());
//                contentByte.stroke();
                contentByte.setLineWidth(1f);
                contentByte.moveTo(relatorioPDF.leftMargin(), relatorioPDF.topMargin() - 10);
                contentByte.lineTo(relatorioPDF.getPageSize().getWidth() - relatorioPDF.rightMargin(), relatorioPDF.topMargin() - 10);
                contentByte.stroke();

                Paragraph paragrafo = new Paragraph("   Tipo do gasto: " + tipoDoGasto);
                Paragraph paragrafo2 = new Paragraph("   Descrição do gasto: " + descGasto);
                Paragraph paragrafo3 = new Paragraph("   Veículo que foi realizado a troca/manutenção: " + placaVeiculo);
                Paragraph paragrafo4 = new Paragraph("   Item comprado/trocado (Caso tiver) : " + descricaoDoItem);
                Paragraph paragrafo5 = new Paragraph("   Quantidade dos itens comprado/trocado (Caso tiver) : " + qntItem);
                Paragraph paragrafo6 = new Paragraph("   Valor do item (Caso tiver) : " + valorItem);
                Paragraph paragrafo7 = new Paragraph("   Valor da mão de obra/manutenção/revisão (Caso tiver) : " + valorMaoDeObra);
                Paragraph paragrafo8 = new Paragraph("   Data da visita ao mecânico: " + dataMecanico);
                Paragraph pularLinha = new Paragraph("\n");

                paragrafo.setFont(font);
                paragrafo2.setFont(font);
                paragrafo3.setFont(font);
                paragrafo4.setFont(font);

                relatorioPDF.add(paragrafo);
                relatorioPDF.add(paragrafo3);
                relatorioPDF.add(paragrafo2);

                relatorioPDF.add(paragrafo4);
                relatorioPDF.add(paragrafo5);
                relatorioPDF.add(paragrafo6);
                relatorioPDF.add(paragrafo7);
                relatorioPDF.add(paragrafo8);

                relatorioPDF.add(pularLinha);

                LineSeparator linhaSeparadora = new LineSeparator();
                relatorioPDF.add(linhaSeparadora);
            }

            relatorioPDF.close();

        } catch (DocumentException doc) {
            doc.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SQLException ex) {

        }
    }

    public static void gerarRelatorioSeguroPDF(ResultSet rs) {

        try {
            Document relatorioPDF = new Document(PageSize.A4, 36, 36, 36, 36);
            PdfWriter escritor = PdfWriter.getInstance(relatorioPDF, new FileOutputStream("./src/com/car/Relatorio/RelatorioGastosSeguro.pdf"));
            relatorioPDF.setPageSize(PageSize.A4);

            relatorioPDF.open();

            Image logoImagem = Image.getInstance("./src/com/car/visao/icons/skr.jpg");
            logoImagem.scaleToFit(175, 175);
            relatorioPDF.add(logoImagem);
            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

            relatorioPDF.add(new Paragraph("   RELÁTORIO DOS GASTOS COM SEGURO"));
            relatorioPDF.bottomMargin();

            while (rs.next()) {
                String tipoDoGasto = rs.getString("tipogasto");
                String descGasto = rs.getString("descgasto");
                String placaVeiculo = rs.getString("placa");
                float ValorDaFranquia = rs.getFloat("valorfranquia");
                Date dataPagamento = rs.getDate("datapagamento");

                PdfContentByte contentByte = escritor.getDirectContent();

//                contentByte.moveTo(relatorioPDF.left(), relatorioPDF.top());
//                contentByte.lineTo(relatorioPDF.right(), relatorioPDF.top());
//                contentByte.stroke();
//
//                contentByte.moveTo(relatorioPDF.left(), relatorioPDF.bottom());
//                contentByte.lineTo(relatorioPDF.right(), relatorioPDF.bottom());
//                contentByte.stroke();
//
//                contentByte.moveTo(relatorioPDF.left(), relatorioPDF.bottom());
//                contentByte.lineTo(relatorioPDF.left(), relatorioPDF.top());
//                contentByte.stroke();
//
//                contentByte.moveTo(relatorioPDF.right(), relatorioPDF.bottom());
//                contentByte.lineTo(relatorioPDF.right(), relatorioPDF.top());
//                contentByte.stroke();
                contentByte.setLineWidth(1f);
                contentByte.moveTo(relatorioPDF.leftMargin(), relatorioPDF.topMargin() - 10);
                contentByte.lineTo(relatorioPDF.getPageSize().getWidth() - relatorioPDF.rightMargin(), relatorioPDF.topMargin() - 10);
                contentByte.stroke();

                Paragraph paragrafo = new Paragraph("   Tipo do gasto: " + tipoDoGasto);
                Paragraph paragrafo2 = new Paragraph("   Serviço realizado junto ao seguro " + descGasto);
                Paragraph paragrafo3 = new Paragraph("   Veículo que foi realizado o serviço: " + placaVeiculo);
                Paragraph paragrafo4 = new Paragraph("   Valor pago na franquia do seguro : " + ValorDaFranquia);
                Paragraph paragrafo5 = new Paragraph("   Data do pagamento do seguro " + dataPagamento);
                Paragraph pularLinha = new Paragraph("\n");

                paragrafo.setFont(font);
                paragrafo2.setFont(font);
                paragrafo3.setFont(font);
                paragrafo4.setFont(font);
                paragrafo5.setFont(font);

                relatorioPDF.add(paragrafo);
                relatorioPDF.add(paragrafo3);
                relatorioPDF.add(paragrafo2);
                relatorioPDF.add(paragrafo4);
                relatorioPDF.add(paragrafo5);

                relatorioPDF.add(pularLinha);

                LineSeparator linhaSeparadora = new LineSeparator();
                relatorioPDF.add(linhaSeparadora);
            }

            relatorioPDF.close();

        } catch (DocumentException doc) {
            doc.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SQLException ex) {

        }
    }

    public static void gerarRelatorioGeralPDF(ResultSet rs) {

        try {
            Document relatorioPDF = new Document(PageSize.A4, 36, 36, 36, 36);

            PdfWriter escritor = PdfWriter.getInstance(relatorioPDF, new FileOutputStream("./src/com/car/Relatorio/RelatorioDeGastos.pdf"));

            relatorioPDF.setPageSize(PageSize.A4);

            relatorioPDF.open();

            Image logoImagem = Image.getInstance("./src/com/car/visao/icons/skr.jpg");
            logoImagem.scaleToFit(175, 175);
            relatorioPDF.add(logoImagem);
            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

            relatorioPDF.add(new Paragraph("   RELÁTORIO DOS GASTOS GERAIS"));
            relatorioPDF.bottomMargin();

            while (rs.next()) {
                String tipoDoGasto = rs.getString("tipogasto");
                String descGasto = rs.getString("descgasto");
                float valorTotal = rs.getFloat("valortotal");
                Date datagasto = rs.getDate("datagasto");

                PdfContentByte contentByte = escritor.getDirectContent();

//                contentByte.moveTo(relatorioPDF.left(), relatorioPDF.top());
//                contentByte.lineTo(relatorioPDF.right(), relatorioPDF.top());
//                contentByte.stroke();
//
//                contentByte.moveTo(relatorioPDF.left(), relatorioPDF.bottom());
//                contentByte.lineTo(relatorioPDF.right(), relatorioPDF.bottom());
//                contentByte.stroke();
//
//                contentByte.moveTo(relatorioPDF.left(), relatorioPDF.bottom());
//                contentByte.lineTo(relatorioPDF.left(), relatorioPDF.top());
//                contentByte.stroke();
//
//                contentByte.moveTo(relatorioPDF.right(), relatorioPDF.bottom());
//                contentByte.lineTo(relatorioPDF.right(), relatorioPDF.top());
//                contentByte.stroke();
//
//                contentByte.setLineWidth(1f);
//                contentByte.moveTo(relatorioPDF.leftMargin(), relatorioPDF.topMargin() - 10);
//                contentByte.lineTo(relatorioPDF.getPageSize().getWidth() - relatorioPDF.rightMargin(), relatorioPDF.topMargin() - 10);
//                contentByte.stroke();
                Paragraph paragrafo = new Paragraph("   Tipo do gasto: " + tipoDoGasto);
                Paragraph paragrafo2 = new Paragraph("   Descrição do gasto: " + descGasto);
                Paragraph paragrafo3 = new Paragraph("   Valor total do gasto: " + valorTotal);
                Paragraph paragrafo4 = new Paragraph("   Data do gasto: " + datagasto);
                Paragraph pularLinha = new Paragraph("\n");
                paragrafo.setFont(font);
                paragrafo2.setFont(font);
                paragrafo3.setFont(font);
                paragrafo4.setFont(font);

                relatorioPDF.add(paragrafo);
                relatorioPDF.add(paragrafo2);
                relatorioPDF.add(paragrafo3);
                relatorioPDF.add(paragrafo4);
                relatorioPDF.add(pularLinha);
                relatorioPDF.add(pularLinha);
                LineSeparator linhaSeparadora = new LineSeparator();
                relatorioPDF.add(linhaSeparadora);
            }

            relatorioPDF.close();

        } catch (DocumentException doc) {
            doc.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SQLException ex) {

        }
    }
}
