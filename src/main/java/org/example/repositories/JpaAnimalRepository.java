package org.example.repositories;

import org.example.entities.Animal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;


public class JpaAnimalRepository implements IAnimalRepository{

    private final EntityManagerFactory emf;
    private EntityManager em;

    public JpaAnimalRepository(EntityManagerFactory emf){
        this.emf = emf;
    }


    public Animal create(Animal animal){
        System.out.println("\nStart of CREATE...");
        em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(animal);

        em.getTransaction().commit();
        em.close();

        return animal;
    }


    public Animal read(int id){
        System.out.println("\nStart of READ...");
        em = emf.createEntityManager();
        em.getTransaction().begin();

        Animal animal = em.find(Animal.class, id);

        em.getTransaction().commit();
        em.close();

        return animal;
    }


    public void update(Animal animal) {
        System.out.println("\nStart of UPDATE...");
        em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(animal);

        em.getTransaction().commit();
        em.close();

    }


    public Animal delete(int id) {

        System.out.println("\nStart of DELETE...");
        em = emf.createEntityManager();
        em.getTransaction().begin();

        Animal animal = em.find(Animal.class, id);
        em.remove(em.contains(animal) ? animal : em.merge(animal));

        em.getTransaction().commit();
        em.close();

        return animal;

    }


    public List<Animal> getAll(){
        System.out.println("\nStart of GET_ALL...");
        em = emf.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery("SELECT animals FROM Animal animals");

        List<Animal> animals = query.getResultList();
        em.getTransaction().commit();
        em.close();

        return animals;
    }

}
