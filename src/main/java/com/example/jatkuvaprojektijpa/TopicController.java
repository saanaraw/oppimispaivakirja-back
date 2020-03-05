package com.example.jatkuvaprojektijpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class TopicController {

    private Logger loki = Logger.getLogger(getClass().getName());
    @Autowired
    private TopicRepository tRepo;

    @GetMapping("/paivakirja") //printtaa kaikki
    public Iterable<Topic> TopicController() {
        return tRepo.findAll();
    }

    @GetMapping("/paivakirja/{id}")
    public ResponseEntity<?> haeIdlla(@PathVariable Integer id) {
        Optional<Topic> topic = tRepo.findById(id);
        return ResponseEntity.ok(topic.get());
    }
    @PostMapping("/paivakirja")
    public Topic lisaaTopic (@RequestBody Topic topic){

        return tRepo.save(topic);
    }
    @DeleteMapping("/paivakirja/{id}")
    public ResponseEntity<?> deleteTopic (@PathVariable(name = "id", required = true)int id){
        Optional<Topic> topic = tRepo.findById(id);
        if(topic.isPresent()){
            tRepo.deleteById(id);
            return ResponseEntity.noContent().build(); //antaa virheen 204. voidaan kirjoittaa no content sijasta .ok?
        }
        return ResponseEntity.notFound().build();
    }
}
