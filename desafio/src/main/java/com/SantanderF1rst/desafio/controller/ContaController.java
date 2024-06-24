package com.SantanderF1rst.desafio.controller;

import org.json.JSONObject;
import com.SantanderF1rst.desafio.service.Conta;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/api/conta")
public class ContaController {

    @PostMapping(path = "/cadastro", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<String> cadastroConta(@RequestBody Conta contaRequestBody) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new JSONObject()
                        .put("Sucesso!", "Conta cadastrada com sucesso!")
                        .toString());
    }

    @PostMapping(path = "/debito", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<String> contaDebito(@RequestBody Conta contaRequestBody) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new JSONObject()
                        .put("Sucesso!", "Debito realizado com sucesso!")
                        .toString());
    }

    @PostMapping(path = "/credito", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<String> contaCrebito(@RequestBody Conta contaRequestBody) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new JSONObject()
                        .put("Sucesso!", "Crédito realizado com sucesso!")
                        .toString());
    }

    @PostMapping(path = "/cancelaPagamento", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<String> cancelaPagamento(@RequestBody Conta contaRequestBody) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new JSONObject()
                        .put("Sucesso!", "Crédito cancelado com sucesso!")
                        .toString());

    }
}