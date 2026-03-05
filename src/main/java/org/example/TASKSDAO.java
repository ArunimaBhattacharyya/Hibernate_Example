package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class TASKSDAO {

    private EntityManager em;
    public TASKSDAO(EntityManager em){
        this.em = em;
    }

    //create
    public TASKS create(String tname, String tdesc, Integer user_id){
        try {
            em.getTransaction().begin();
            USERS user = em.find(USERS.class, user_id);
            if(user == null){
                System.out.println("User not found");
                em.getTransaction().rollback();
                return null;
            }
            TASKS task = new TASKS();
            task.setTname(tname);
            task.setTdesc(tdesc);
            task.setUser(user); // this sets the foreign key
            em.persist(task);
            em.getTransaction().commit();

            return task;
        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }

    //read
    public TASKS read(Integer id){
        return em.find(TASKS.class, id);
    }

    //update
    public TASKS update(Integer id, String newName, String newDesc){
        try {
            em.getTransaction().begin();
            TASKS task = em.find(TASKS.class, id);
            if(task != null){
                task.setTname(newName);
                task.setTdesc(newDesc);

                em.getTransaction().commit();
                return task;
            } else {
                em.getTransaction().rollback();
                return null;
            }
        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }

    //delete
    public boolean delete(Integer id){
        try {
            em.getTransaction().begin();
            TASKS task = em.find(TASKS.class, id);
            if(task != null){
                em.remove(task);
                em.getTransaction().commit();
                return true;
            }

            em.getTransaction().rollback();
            return false;
        } catch (Exception e){
            em.getTransaction().rollback();
            return false;
        }
    }

    //get all
    public List<TASKS> getAllTasks(){
        return em.createQuery("SELECT t FROM TASKS t", TASKS.class).getResultList();
    }
}
