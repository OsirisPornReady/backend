package org.osiris.backend.controller;

import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.dto.ComicAlbumDTO;
//import org.osiris.backend.dto.ComicCollectDTO;
import org.osiris.backend.entity.ComicAlbum;
import org.osiris.backend.service.ComicAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comic_album")
@CrossOrigin(origins = "*")
public class ComicAlbumController {

    private final ComicAlbumService comicAlbumService;

    @Autowired
    public ComicAlbumController(ComicAlbumService comicAlbumService) {
        this.comicAlbumService = comicAlbumService;
    }

    @PostMapping
    public void add(@RequestBody ComicAlbumDTO ComicAlbumDTO) { comicAlbumService.addComicAlbum(ComicAlbumDTO); }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody ComicAlbumDTO ComicAlbumDTO) {
        comicAlbumService.updateComicAlbum(ComicAlbumDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        comicAlbumService.removeById(id);
    }

    @GetMapping("/{id}")
    public ComicAlbumDTO getById(@PathVariable Integer id) { return comicAlbumService.getDTOById(id); }

    @GetMapping("/get_by_page")
    public STResDTO getByPage(@RequestParam(value = "pi", required = false, defaultValue = "1") Integer pi, @RequestParam(value = "ps", required = false, defaultValue = "10") Integer ps) {
        return comicAlbumService.getByPage(pi, ps);
    }

    @GetMapping("/get_select_all")
    public List<ComicAlbum> getSelectAll() {
        return comicAlbumService.list();
    }

//    @PostMapping("/collect_Comic/{id}")
//    public void collectComic(@PathVariable Integer id, @RequestBody ComicCollectDTO ComicCollectDTO) { ComicAlbumService.collectComic(id, ComicCollectDTO); }
//
//    @GetMapping("/get_album_collected_Comic/{id}")
//    public List<ComicAlbum> getAlbumCollectedComic(@PathVariable Integer id) { return ComicAlbumService.getAlbumCollectedComic(id); }


}
