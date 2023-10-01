package com.br.musicapp.Controller;

import com.br.musicapp.Entity.Album;
import com.br.musicapp.Repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class AlbumController {

    @Autowired
    private AlbumRepository albumRepository;

    @GetMapping
    public List<Album> findAllAlbum() {
        return albumRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> findAlbumById(@PathVariable(value = "id") long id) {
        Optional<Album> album = albumRepository.findAllById(id);

        if(album.isPresent()) {
            return ResponseEntity.ok().body(album.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Album saveAlbum (@Validated @RequestBody Album album) {
        return albumRepository.save(album);
    }
}
