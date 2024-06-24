package com.SantanderF1rst.desafio.controller;

import com.SantanderF1rst.desafio.service.Cliente;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

        @PostMapping(path = "/cadastro", produces = {"application/json"})
        @ResponseBody
        public ResponseEntity<String> clienteCadastro(@RequestBody Cliente clienteRequestBody) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new JSONObject()
                            .put("Sucesso!", "Cliente cadastrado com sucesso!")
                            .toString());
        }

}
