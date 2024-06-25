package com.SantanderF1rst.desafio.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_conta")
public class ContaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idConta")
    private Long id;

    @Column(unique = true, name = "agencia")
    private String aqencia;

    @Column(name = "saldo")
    private double saldo;

    @Column(name = "status")
    private String status;

    //@Column(name = "idCliente")
    @ManyToOne
    @JoinColumn(name = "id",insertable=false, updatable=false)
    private ClienteEntity idCliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
