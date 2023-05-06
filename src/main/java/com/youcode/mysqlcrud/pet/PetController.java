package com.youcode.mysqlcrud.pet;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;



@RestController
@RequestMapping("/api/pet")
@AllArgsConstructor
public class PetController {

    private PetService petService;

    @GetMapping
    public ResponseEntity<List<Pet>> all() {
        return new ResponseEntity<>(petService.all(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Pet> findById(@PathVariable Integer id) throws Exception {
        return  petService.findById(id).map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }



    @PostMapping
    public ResponseEntity<Pet> store(@RequestBody Pet pet) {
        return new ResponseEntity<>(petService.store(pet), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> update(@PathVariable Integer id, @RequestBody Pet pet) {
        pet.setId(id);
        return new ResponseEntity<>(petService.update(pet), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        petService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
