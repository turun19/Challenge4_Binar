package com.example.challenge4_binar.controller;

import com.example.challenge4_binar.model.Films;
import com.example.challenge4_binar.service.FilmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/films")
public class FilmsController {
    @Autowired
    FilmsService fs;

    @GetMapping
    public List<Films> getAll(){
        return fs.getAllFilms();
    }

    @GetMapping(value = "/status/{sedang_tayang_atau_tidak}")
    public List<Films> getFilmTayangAtauTidak(@PathVariable("sedang_tayang_atau_tidak") String status){
        return fs.findBySedangTayangAtauTidak(status);
    }

    @GetMapping(value = "/page") ///films/page?nama=Avatar&page=0&size=10
    public List<Films> getFilmByName(@RequestParam("namaFilm") String namaFilm,  @RequestParam("page") int pageNumber,
                                     @RequestParam("size") int pageSize){
        return fs.findByFilmName(namaFilm, pageNumber, pageSize);
    }


    @PostMapping(value = "/film-add")
    public List<Films> addAllFilms(@RequestBody List<Films> films){
        return fs.getAddFilms(films);
    }

    @PutMapping (value = "/film-update/{film_code}")
    public List<Films> updateFilms(@PathVariable int film_code, @RequestBody List <Films> films){
        return fs.updateAllFilm(film_code, films);
    }
}
