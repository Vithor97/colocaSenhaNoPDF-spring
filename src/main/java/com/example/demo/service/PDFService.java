package com.example.demo.service;

import com.example.demo.dto.PDFDto;
import com.example.demo.model.PDF;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Base64;

@Service
public class PDFService {

    public PDF gerarSenha(PDFDto pdfDto) throws IOException {

         String pdfComSenha = putPasswordPDF(pdfDto.getPdf(), pdfDto.getSenha());

        return new PDF(pdfComSenha, pdfDto.getSenha());
    }

    private String putPasswordPDF(String pdf, String senha) throws IOException {

        byte[] decodedBytes = Base64.getDecoder().decode(pdf);

        PDDocument doc = PDDocument.load(decodedBytes);


        int keyLength = 128;

        AccessPermission ap = new AccessPermission();

        ap.setCanPrint(false);
        StandardProtectionPolicy spp = new StandardProtectionPolicy("12345", senha, ap);
        spp.setEncryptionKeyLength(keyLength);
        spp.setPermissions(ap);
        doc.protect(spp);

        //transforma bytes em rray
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        //salva escrevendo o conteudo da variavel 'baos'
        doc.save(baos);

        String base64String = Base64.getEncoder().encodeToString(baos.toByteArray());
        doc.close();

        //seta(base64String);

        return base64String;
    }

    private void seta(String base64String) throws IOException {
        File file = new File("arquivos/test.pdf");

        FileOutputStream fos = new FileOutputStream(file);
        // To be short I use a corrupted PDF string, so make sure to use a valid one if you want to preview the PDF file

        byte[] decoder = Base64.getDecoder().decode(base64String);

        fos.write(decoder);
        System.out.println("PDF File Saved");
        fos.close();
    }








}
