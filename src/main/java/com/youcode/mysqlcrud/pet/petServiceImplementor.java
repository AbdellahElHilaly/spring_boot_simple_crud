package com.youcode.mysqlcrud.pet;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor


public class petServiceImplementor implements PetService {

    private  PetRepository petRepository;

    @Override
    public Pet store(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> all() {
        return petRepository.findAll().stream().toList();
    }

    @Override
    public Pet update(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void delete(Integer id) {
        petRepository.deleteById(id);
    }

    
    @Override
    public Optional<Pet> findById(Integer id) throws Exception {
        return Optional.ofNullable(petRepository.findById(id).orElseThrow(() -> new Exception("Pet not  !")));
    }
    
    
}