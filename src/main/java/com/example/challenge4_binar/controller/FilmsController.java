package com.example.challenge4_binar.controller;

import com.example.challenge4_binar.model.Films;
import com.example.challenge4_binar.service.FilmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Slf4j
@RestController
@RequestMapping(value = "/films")
public class FilmsController {
    private final Logger logger= Logger.getLogger(FilmsController.class.getName());
    @Autowired
    FilmsService fs;

    @GetMapping
    public List<Films> getAll(){
        logger.info("Sukses menampilkan semua film");
        return fs.getAllFilms();
    }

    @GetMapping(value = "/status/{sedang_tayang_atau_tidak}")
    public List<Films> getFilmTayangAtauTidak(@PathVariable("sedang_tayang_atau_tidak") String status){
        logger.info("Sukses menampilkan film yang sedang tayang atau tidak tayang");
        return fs.findBySedangTayangAtauTidak(status);
    }

    @GetMapping(value = "/page") ///films/page?nama=Avatar&page=0&size=10
    public List<Films> getFilmByName(@RequestParam("namaFilm") String namaFilm,  @RequestParam("page") int pageNumber,
                                     @RequestParam("size") int pageSize){
        logger.info("Sukses menampilkan data dari page " + pageNumber + "sampai " + pageSize);
        return fs.findByFilmName(namaFilm, pageNumber, pageSize);
    }


    @PostMapping(value = "/film-add")
    public List<Films> addAllFilms(@RequestBody List<Films> films){
        logger.info("Sukses menambahkan Film");
        return fs.getAddFilms(films);
    }

    @PutMapping (value = "/film-update/{film_code}")
    public List<Films> updateFilms(@PathVariable int film_code, @RequestBody List <Films> films){
        logger.info("Sukses mengupdate film sesuai dengan film code");
        return fs.updateAllFilm(film_code, films);
    }

    @DeleteMapping(value = "/delete/{film_code}")
    public Films deleteFilm(@PathVariable int film_code){
        logger.info("Sukses menghapus film berdasarkan film code");
        return fs.deleteFilmByFilmCode(film_code);
    }
}
