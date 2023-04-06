package org.example.repositories;

import org.example.entities.Animal;

import java.util.List;

public interface IAnimalRepository {

    Animal create(Animal animal);

    Animal read(int id);

    void update(Animal animal);

    Animal delete(int id);

    List<Animal> getAll();
}
