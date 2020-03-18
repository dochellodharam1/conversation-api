package com.sapient.how.hellodoc.controller;

import com.sapient.how.hellodoc.model.Dialogue;
import com.sapient.how.hellodoc.repositories.DialougeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/data")
@Log4j2
public class DataController {

    @Autowired
    private DialougeRepository repository;

    @GetMapping
    public ResponseEntity<Page<Dialogue>> list(@PageableDefault(page = 0, size = 20)
                                               @SortDefault.SortDefaults({
                                                       @SortDefault(sort = "id", direction = Sort.Direction.ASC)
                                               }) Pageable pageable) {
        return ResponseEntity.ok(repository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dialogue> read(@PathVariable("id") String id) {
        Optional<Dialogue> dialogue = repository.findById(id);
        return dialogue.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Dialogue> create(@RequestBody Dialogue dialogue) {
        dialogue = repository.save(dialogue);
        return ResponseEntity.created(URI.create(dialogue.getId())).body(dialogue);
    }

    @PostMapping("/bulk")
    public ResponseEntity<Iterable<Dialogue>> bulkCreate(@RequestBody Iterable<Dialogue> dialogues) {
        dialogues = repository.saveAll(dialogues);
        return ResponseEntity.created(URI.create("")).body(dialogues);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dialogue> update(@PathVariable("id") String id, @RequestBody Dialogue dialogue) {
        Optional<Dialogue> byId = repository.findById(id);
        Dialogue saved = byId.map(c -> {
            dialogue.setId(id);
            return repository.save(dialogue);
        }).orElseGet(() -> repository.save(dialogue));
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Dialogue> delete(@PathVariable("id") String id) {
        Optional<Dialogue> byId = repository.findById(id);
        return byId.map(c -> {
            repository.delete(c);
            return ResponseEntity.ok(c);
        }).orElse(ResponseEntity.notFound().build());
    }


}
