package org.example;

import jakarta.persistence.criteria.CriteriaBuilder;

public class TASKSDTO {
     private Integer id;
     private String tname;
     private String tdesc;
     private Integer user_id;

     public TASKSDTO() {}
     public TASKSDTO(Integer id, String tname, String tdesc, Integer user_id){
         this.id = id;
         this.tname = tname;
         this.tdesc = tdesc;
         this.user_id = user_id;
     }

     public void setId(Integer id){
         this.id = id;
     }

     public void setTname(String tname){
         this.tname = tname;
     }

     public void setTdesc(String tdesc){
         this.tdesc = tdesc;
     }

     public void setUser_id(Integer user_id){
         this.user_id = user_id;
     }

     public Integer getId(){
         return id;
     }

     public String getTname() {
         return tname;
     }

     public String getTdesc() {
         return tdesc;
     }

     public Integer getUser_id() {
         return user_id;
     }

    @Override
    public String toString() {
        return "TASKSDTO{" +
                "id=" + id +
                ", tname='" + tname + '\'' +
                ", tdesc='" + tdesc + '\'' +
                ", userId=" + user_id +
                '}';
    }
}
