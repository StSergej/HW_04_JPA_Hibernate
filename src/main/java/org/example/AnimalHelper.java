package org.example;

import org.example.entities.Animal;
import org.example.repositories.IAnimalRepository;

import java.util.ArrayList;
import java.util.List;

public class AnimalHelper {

    private final IAnimalRepository animalRepository;

    public AnimalHelper(IAnimalRepository animalRepository){
        this.animalRepository = animalRepository;
    }


    public void create(){

        Animal newAnimal = new Animal("horse",8, true);
        Animal generateAnimal = animalRepository.create(newAnimal);

        System.out.println("\n" + generateAnimal);


    }

    public void read(){
        System.out.println("----------------------------");
        Animal animalDb = animalRepository.read(2);

        System.out.println("\n" + animalDb);
    }

    public void update(){
        System.out.println("----------------------------");
        Animal animalToUpdate = animalRepository.read(3);
        animalToUpdate.setName("wolf");
        animalToUpdate.setAge(4);
        animalRepository.update(animalToUpdate);
        System.out.println("\n" + animalToUpdate);

    }

    public void delete(){
        System.out.println("----------------------------");
        Animal animalToDelete = animalRepository.delete(5);
        System.out.println("\n" + animalToDelete);
    }

    public void getAll(){
        System.out.println("----------------------------");
        List<Animal> animals = animalRepository.getAll();
        for(Animal animalsAll : animals){
            System.out.println(animalsAll);
        }
    }

}
