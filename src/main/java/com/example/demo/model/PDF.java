package com.example.demo.model;

import java.time.Instant;

public class PDF {

    private String pdfBase64;
    private String senha;
    private Instant horaGeracao;

    public Instant getHoraGeracao() {
        return horaGeracao;
    }

    public void setHoraGeracao(Instant horaGeracao) {
        this.horaGeracao = horaGeracao;
    }

    public PDF(String pdfBase64, String senha) {
        this.pdfBase64 = pdfBase64;
        this.senha = senha;
        this.horaGeracao = Instant.now();
    }

    public String getPdfBase64() {
        return pdfBase64;
    }

    public void setPdfBase64(String pdfBase64) {
        this.pdfBase64 = pdfBase64;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
