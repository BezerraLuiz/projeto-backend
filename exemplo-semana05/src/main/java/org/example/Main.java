package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();

        // Criando documento
        PDDocument documento = new PDDocument();

        // Criando primeira pagina
        PDPage pageOne = new PDPage();
        documento.addPage(pageOne);

        Standard14Fonts.FontName nomeFonte = Standard14Fonts.FontName.HELVETICA;
        PDFont fonte = new PDType1Font(nomeFonte);

        // Escritor de pagina
        PDPageContentStream escritor = new PDPageContentStream(documento, pageOne);
        escritor.beginText();
        escritor.newLineAtOffset(25, 400);
        escritor.setFont(fonte, 20.5f);
        escritor.showText("Hello World " + nome);
        escritor.endText();
        escritor.close();

        // Salvando documento
        documento.save("teste.pdf");
    }
}