package com.SantanderF1rst.desafio.controller;

import com.SantanderF1rst.desafio.entity.ContaEntity;
import com.SantanderF1rst.desafio.entity.TransacaoEntity;
import com.SantanderF1rst.desafio.repository.ContaRepository;
import com.SantanderF1rst.desafio.repository.TransacaoRepository;
import com.SantanderF1rst.desafio.service.Conta;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
@RestController
@RequestMapping("/api/conta")
public class ContaController {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @PostMapping(path = "/cadastro", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<String> cadastroConta(@RequestBody ContaEntity contaRequestBody) {
        contaRepository.save(contaRequestBody);
        return ResponseEntity.status(HttpStatus.OK).body(
                new JSONObject()
                        .put("Sucesso!", "Conta cadastrada com sucesso!")
                        .toString());
    }

    @PostMapping(path = "/debito/{valor}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<String> contaDebito(@RequestBody ContaEntity contaRequestBody, @PathVariable double valor) {
        Conta contaDebito = new Conta();
        contaDebito.contaDebito(valor);
        TransacaoEntity transacaoEntity = new TransacaoEntity();
        transacaoEntity.setContaDestino(String.valueOf(contaRequestBody.getId()));
        transacaoEntity.setTipo("Debito");
        transacaoEntity.setValor(valor);

        transacaoRepository.save(transacaoEntity);
        return ResponseEntity.status(HttpStatus.OK).body(
                new JSONObject()
                        .put("Sucesso!", "Debito realizado com sucesso!")
                        .toString());
    }

    @PostMapping(path = "/credito/{valor}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<String> contaCredito(@RequestBody ContaEntity contaRequestBody, @PathVariable double valor) {
        Conta contaCredito = new Conta();
        contaCredito.contaCredito(valor);
        TransacaoEntity transacaoEntity = new TransacaoEntity();
        transacaoEntity.setContaDestino(String.valueOf(contaRequestBody.getId()));
        transacaoEntity.setTipo("Credito");
        transacaoEntity.setValor(valor);

        transacaoRepository.save(transacaoEntity);
        return ResponseEntity.status(HttpStatus.OK).body(
                new JSONObject()
                        .put("Sucesso!", "Crédito realizado com sucesso!")
                        .toString());

    }

    @PostMapping(path = "/cancelaTransacao/{contaDeb}/{contaCred}/{valor}/{id}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<String> cancelaTranscao(@PathVariable String contaDeb, @PathVariable String contaCred, @PathVariable double valor, @PathVariable Long id) {

        Conta contaDebitada = new Conta();
        contaDebitada.setId(Long.valueOf(contaDeb));

        Conta contaCreditada = new Conta();
        contaCreditada.setId(Long.valueOf(contaCred));

        Conta cancelaTransacao = new Conta();
        cancelaTransacao.cancelaPagamento(valor, contaDebitada, contaCreditada);

        TransacaoEntity transacaoCredito= new TransacaoEntity();
        transacaoCredito.setContaDestino(String.valueOf(contaCreditada.getId()));
        transacaoCredito.setTipo("Credito");
        transacaoCredito.setValor(valor);

        TransacaoEntity transacaoDebito= new TransacaoEntity();
        transacaoDebito.setContaDestino(String.valueOf(contaDebitada.getId()));
        transacaoDebito.setTipo("Debito");
        transacaoDebito.setValor(valor);

        transacaoRepository.save(transacaoCredito);
        transacaoRepository.save(transacaoDebito);

        transacaoRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body(
                new JSONObject()
                        .put("Sucesso!", "Transação removida com sucesso!")
                        .toString());
    }

    @PostMapping(path = "/trasnferencia/{contaDest}/{contaOri}/{valor}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<String> trasnferencia(@PathVariable String contaDest, @PathVariable String contaOri, @PathVariable double valor){
        Conta contaDestino = new Conta();
        contaDestino.setId(Long.valueOf(contaDest));
        Conta contaOrigem = new Conta();
        contaOrigem.setId(Long.valueOf(contaOri));

        Conta transferencia = new Conta();
        transferencia.tranferencia(contaDestino, contaOrigem, valor);

        TransacaoEntity transacaoCredito= new TransacaoEntity();
        transacaoCredito.setContaDestino(String.valueOf(contaDestino.getId()));
        transacaoCredito.setContaOrigem(contaOri);
        transacaoCredito.setTipo("Credito");
        transacaoCredito.setValor(valor);

        TransacaoEntity transacaoDebito= new TransacaoEntity();
        transacaoDebito.setContaDestino(String.valueOf(contaDestino.getId()));
        transacaoDebito.setContaOrigem(contaOri);
        transacaoDebito.setTipo("Debito");
        transacaoDebito.setValor(valor);

        transacaoRepository.save(transacaoCredito);
        transacaoRepository.save(transacaoDebito);

        return ResponseEntity.status(HttpStatus.OK).body(
                new JSONObject()
                        .put("Sucesso!", "Tranferência efetuado com sucesso!")
                        .toString());
    }

}

