package com.br.musicapp.Controller;

import com.br.musicapp.Entity.Musica;
import com.br.musicapp.Repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class MusicaController {

    @Autowired
    private MusicaRepository musicaRepository;

    @GetMapping
    public List<Musica> findAllMusicas() {
        return musicaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musica> findMusicaById(@PathVariable(value = "id") long id) {
        Optional<Musica> musica = musicaRepository.findAllById(id);

        if (musica.isPresent()) {
            return ResponseEntity.ok().body(musica.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Musica saveMusica (@Validated @RequestBody Musica musica) {
        return musicaRepository.save(musica);
    }
}
