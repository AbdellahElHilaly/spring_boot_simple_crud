package com.youcode.mysqlcrud.pet;

import java.util.List;
import java.util.Optional;

public interface PetService {
    Pet store(Pet pet);
    List<Pet> all(); 
    Pet update(Pet pet);
    void delete(Integer id);
    Optional<Pet> findById(Integer id) throws Exception;
}

