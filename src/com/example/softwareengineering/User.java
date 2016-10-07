package com.example.softwareengineering;

//Класс больших чисел
import java.math.BigInteger;
//То, что помогает генерировать соль\хэш
import java.security.SecureRandom;

import static com.example.softwareengineering.Secure.MD5;
import static com.example.softwareengineering.Secure.generateSalt;

class User {
    public int Id;
    public String Login;
    public String Password;
    public String Name;



    public User(int id, String login, String password, String name) {
        Id = id;
        Login = login;
        Name = name;
        Password = password;
    }

}
