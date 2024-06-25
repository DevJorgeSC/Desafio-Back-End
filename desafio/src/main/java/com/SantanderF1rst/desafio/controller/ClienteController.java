package com.SantanderF1rst.desafio.controller;

import com.SantanderF1rst.desafio.entity.ClienteEntity;
import com.SantanderF1rst.desafio.repository.ClienteRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api/cliente")
public class ClienteController {

        @Autowired
        private ClienteRepository clienteRepository;

        @PostMapping(path = "/cadastro", produces = {"application/json"})
        @ResponseBody
        public ResponseEntity<String> clienteCadastro(@RequestBody ClienteEntity clienteRequestBody) {

            clienteRepository.save(clienteRequestBody);

            return ResponseEntity.status(HttpStatus.OK).body(
                    new JSONObject()
                            .put("Sucesso!", "Cliente cadastrado com sucesso!")
                            .toString());
        }
}
