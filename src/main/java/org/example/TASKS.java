package org.example;

import jakarta.persistence.*;

@Entity
public class TASKS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tname;
    private String tdesc;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private USERS user;

    public TASKS() {

    }

    public Integer getId(){
        return id;
    }

    public void setTname(String tname){
        this.tname = tname;
    }
    public void setTdesc(String tdesc){
        this.tdesc = tdesc;
    }

    public String getTname(){
        return tname;
    }

    public String getTdesc(){
        return tdesc;
    }

    public void setUser(USERS user){
        this.user = user;
    }

    public USERS getUser(){
        return user;
    }
}
