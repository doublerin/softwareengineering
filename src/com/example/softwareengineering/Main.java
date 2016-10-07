package com.example.softwareengineering;

import static com.example.softwareengineering.Permission.*;

public class Main {

    public static void main(String[] args) {

        //new Client(args).parse();


        User User1 = new User(1,"jdoe","sup3rpaZZ","John Doe");
        User User2 = new User(2,"jrow","Qweqrty12","Jane Row");

        Role Role1 = new Role(1, 1, READ.code(), "a");
        Role Role2 = new Role(2, 1, WRITE.code(), "a.b");
        Role Role3 = new Role(3, 2, EXECUTE.code(), "a.b.c");
        Role Role4 = new Role(4, 1, EXECUTE.code(), "a.bc");


    System.exit(0);
    }
}
