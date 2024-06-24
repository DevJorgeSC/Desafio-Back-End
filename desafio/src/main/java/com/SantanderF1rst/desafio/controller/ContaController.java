package com.SantanderF1rst.desafio.controller;
import org.json.JSONObject;
import com.SantanderF1rst.desafio.service.Conta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
                        .put("Sucesso!", "Debito Realizado com sucesso!")
                        .toString());
    }
}
