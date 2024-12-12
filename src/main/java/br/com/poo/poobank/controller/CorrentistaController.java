package br.com.poo.poobank.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.poo.poobank.domain.Correntista;
import br.com.poo.poobank.repository.CorrentistaRepository;

@RestController
@RequestMapping("correntista")
@CrossOrigin
public class CorrentistaController {
    
    @Autowired
    private CorrentistaRepository repository;

    @PostMapping
    public ResponseEntity<Correntista> salvar(@RequestBody Correntista c) {
        Correntista novoCorrentista = repository.save(c);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCorrentista);
    }


}