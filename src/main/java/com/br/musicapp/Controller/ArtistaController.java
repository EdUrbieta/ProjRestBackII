package com.br.musicapp.Controller;

import com.br.musicapp.Entity.Artista;
import com.br.musicapp.Repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class ArtistaController {

    @Autowired
    private ArtistaRepository artistaRepository;

    @GetMapping
    public List<Artista> findAllArtista() {
        return artistaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artista> findArtistasById(@PathVariable(value = "id") long id) {
        Optional<Artista> artista = artistaRepository.findAllById(id);

        if(artista.isPresent()) {
            return ResponseEntity.ok().body(artista.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Artista saveArtista (@Validated @RequestBody Artista artista) {
        return artistaRepository.save(artista);
    }
}

