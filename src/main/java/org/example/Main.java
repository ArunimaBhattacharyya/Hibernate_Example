package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("newTask");

        EntityManager em = emf.createEntityManager();

        USERSDAO userdao = new USERSDAO(em);
        TASKSDAO tasksdao = new TASKSDAO(em);

//        USERS user1 = userdao.create("Rajarshi");
//        USERS user2 = userdao.create("Anurag");
        USERS user3 = userdao.create("Anishka");
//
//        System.out.println("Created user:" + user.getId());

        //create task for user
        TASKS task = tasksdao.create(
                "Learn hibernate",
                "Understand relationships",
                user3.getId()
        );

        TASKS updatedTask = tasksdao.update(
                task.getId(),
                "Master Hibernate",
                "Deep understanding of hibernate"
        );

        boolean deleted = tasksdao.delete(task.getId());

        em.close();
        emf.close();


    }
}