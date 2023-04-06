/*  Создать новую базу данных с помощью MySQLWorkbench.
    Создать обычный java-проект и подключить к нему библиотеки JPA и Hibernate.
    Создать файл с настройками persistence.xml в папке META-INF.
    Создать класс Animal(int age, String name, boolean tail) с методами get и set, как сущность к нашей таблице.
    И с помощью jpa сделать crud в классе AnimalHelper.
 */

package org.example;

import org.example.repositories.IAnimalRepository;
import org.example.repositories.JpaAnimalRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("eclipselink_jpa");

        IAnimalRepository animalRepository = new JpaAnimalRepository(emf);

        AnimalHelper animalHelper = new AnimalHelper(animalRepository);

        animalHelper.create();

        animalHelper.read();

        animalHelper.update();

        animalHelper.delete();

        animalHelper.getAll();

    }
}
