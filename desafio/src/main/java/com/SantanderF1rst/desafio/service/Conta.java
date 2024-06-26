package com.SantanderF1rst.desafio.service;

public class Conta {

    private String aqencia;
    private double saldo;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;

    public String getAqencia() {
        return aqencia;
    }

    public void setAqencia(String aqencia) {
        this.aqencia = aqencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean validaSaldo (){
        if (this.saldo > 0){
            return true;
        }
        else {
            return false;
        }
    }

    public void contaCredito (double valor){
        this.saldo = this.saldo + valor;
        }

    public void contaDebito (double valor){
        if (validaSaldo()){
            if (this.saldo >= valor){
                this.saldo = this.saldo - valor;
            }
        }
    }

    public void cancelaPagamento (double valor, Conta contaDebitada, Conta contaCreditada){
        contaDebitada.contaCredito(valor);
        contaCreditada.contaDebito(valor);
    }

    public void tranferencia(Conta contaDestino, Conta contaOrigem, double valor){
        if (contaOrigem.validaSaldo()){
            contaOrigem.contaDebito(valor);
            contaDestino.contaCredito(valor);
        }else {
            System.out.println("Saldo insuficiente!");
        }
    }
}

