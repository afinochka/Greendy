package com.example.afinochka.greendy.Objects;

public class User {
    private String name;
    private String email;
    private String password;
    private String number;
    private String birthday;

    public User(){}

    public User(String name, String email, String password, String number, String birthday){
        this.name = name;
        this.email = email;
        this.password = password;
        this.number = number;
        this.birthday = birthday;
    }

    public User(String name, String email, String password, String number){
        this.name = name;
        this.email = email;
        this.password = password;
        this.number = number;
    }

    public void setName(String name){this.name = name;}
    public String getName(){return name;}

    public void setEmail(String email){this.email = email;}
    public String getEmail(){return email;}

    public void setPassword(String password){this.password = password;}
    public String getPassword(){return password;}

    public void setNumber(String number){this.number = number;}
    public String getNumber(){return number;}

    public void setBirthday(String birthday){this.birthday = birthday;}
    public String getBirthday(){return birthday;}
}
