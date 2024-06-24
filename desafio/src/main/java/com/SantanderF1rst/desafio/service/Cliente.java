package com.SantanderF1rst.desafio.service;


public class Cliente {

    private String documento;
    private String endereco;
    private String senha;
    private String tipo;
    private String nome;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {

        if (documento.length() == 14) {
            setTipo("PF");
            this.documento = documento;
        } else if (documento.length() == 18){
            setTipo("PJ");
            this.documento = documento;
        } else {
            System.out.println("Documento inválido!");
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
