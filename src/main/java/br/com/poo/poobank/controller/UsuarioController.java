package br.com.poo.poobank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.poo.poobank.domain.Usuario;
import br.com.poo.poobank.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodos() {
        List<Usuario> userList = repository.findAll();
        return ResponseEntity.ok().body(userList);       
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> carregarUsuario(@PathVariable("id") Integer id) {
        Optional<Usuario> usuario = repository.findById(id);
        return usuario.isPresent() ? ResponseEntity.ok(usuario.get()) : ResponseEntity.notFound().build();
    }

    @GetMapping("/login/{login}")
    public ResponseEntity<Usuario> carregarUsuarioPorLogin(@PathVariable("login") String login) {
        Usuario usuario = repository.findByLogin(login);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
        Usuario novoUsuario = repository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody Usuario u) {
        Optional<Usuario> logado = repository
            .findByLoginAndSenha(u.getLogin(), u.getSenha());

        if (logado.isPresent()) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
