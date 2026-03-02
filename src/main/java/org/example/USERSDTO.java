package org.example;

public class USERSDTO {

    private Integer id;
    private String fname;

    public USERSDTO() {}

    public USERSDTO(Integer id, String fname){
        this.id = id;
        this.fname = fname;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setFname(String fname){
        this.fname = fname;
    }

    public Integer getId(){
        return id;
    }

    public String getFname() {
        return fname;
    }

    @Override
    public String toString() {
        return "USERSDTO{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                '}';
    }
}
