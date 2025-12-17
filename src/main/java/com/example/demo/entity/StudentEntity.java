package com.example.demo.entity

public class StudentEntity{
    private Integer id;
    private String name;
    private String username;
    private String email;
    private String password;
    private Date created;

    public void setId(Integer id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setCreated(Date created){
        this.created=created;
    }

    public Integer getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public Date getCreated(){
        return created;
    }

    
}