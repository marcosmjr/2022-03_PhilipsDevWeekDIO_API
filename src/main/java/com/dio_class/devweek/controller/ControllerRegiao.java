package com.dio_class.devweek.controller;

import com.dio_class.devweek.repo.RegiaoRepo;
import com.dio_class.devweek.entity.Regiao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerRegiao {

    private RegiaoRepo repository;

    public ControllerRegiao(RegiaoRepo repository) {
        this.repository = repository;
    }

    @GetMapping("/regioes")
    public ResponseEntity<?> findAllRegioes(){
        try {
            List<Regiao> allRegioes = repository.findAll();
            if(allRegioes.isEmpty()){ System.out.println("Vazia");}
                return new ResponseEntity<>(allRegioes, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/regioes/{id}")
    public ResponseEntity<?> findRegiaoById(@PathVariable Long id) {
        Optional<Regiao> regiaoOptional = repository.findById(id);
        if (regiaoOptional.isPresent()){
            Regiao regiaoUnid = regiaoOptional.get();
            return new ResponseEntity<>(regiaoUnid, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/regioes/novo")
    public Regiao putRegiao(@RequestBody Regiao newRegiao){
        return repository.save(newRegiao);
    }

    @DeleteMapping("/regioes/delete/{id}")
    public void deleteRegiao(@PathVariable Long id){
        repository.deleteById(id);

    }
}
