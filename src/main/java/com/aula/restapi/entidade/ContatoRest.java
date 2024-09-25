package com.aula.restapi.entidade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aula.restapi.database.RepositorioContato;

@RestController
@RequestMapping("/contato")
public class ContatoRest {
    
    @Autowired
    private RepositorioContato repositorioContato;

    @GetMapping
    public List<Contato> listar() {
        return repositorioContato.findAll();
    }

    @PostMapping
    public void salvar(@RequestBody Contato contato) {
        repositorioContato.save(contato);
    }

    @PutMapping
    public void alterar(@RequestBody Contato contato) {
        if (contato.getId() > 0) {
            repositorioContato.save(contato);
        }
    }

    @DeleteMapping
    public void excluir(@RequestBody Contato contato) {
        repositorioContato.delete(contato);
    }
}
