package org.example;

import jakarta.persistence.EntityManager;

import java.util.List;

public class USERSDAO {

    private EntityManager em;

    public USERSDAO(EntityManager em){
        this.em = em;
    }

    //create
    public USERS create(String fname){
        USERS user = new USERS();
        user.setFname(fname);

        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            return user;
        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }

    //read
    public USERS findById(Integer id){
        return em.find(USERS.class, id);
    }

    //update
    public USERS update(Integer id, String newName){
        try {
            em.getTransaction().begin();
            USERS user = em.find(USERS.class, id);
            if(user != null){
                user.setFname(newName);
                em.getTransaction().commit();
                return user;
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
            USERS user = em.find(USERS.class, id);
            if(user != null){
                em.remove(user);
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
    public List<USERS> getAllUsers() {
        return em.createQuery("SELECT u FROM USERS u", USERS.class).getResultList();
    }
}
