package com.SantanderF1rst.desafio.service;

public class Conta {

    private String aqencia;
    private double saldo;
    private String status;

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
}

