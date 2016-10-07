package com.example.softwareengineering;

//Enum это ключевое слово, которое используется для перечисления
//Здесь описываются права доступа для пользователя
public enum Permission {

    READ (1),
    WRITE (2),
    EXECUTE (4);

    private int value;

    Permission(int value){
        this.value=value;
    }

    public int code(){
        return this.value;
    }
}
