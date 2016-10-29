package com.example.softwareengineering;

import org.apache.commons.cli.ParseException;

import java.util.ArrayList;

public class Main {

    public static void main(String[] arg) throws ParseException {

        ArrayList<User> anArrayOfUsers = new ArrayList<User>();
        ArrayList<Role> anArrayOfRoles = new ArrayList<Role>();


        anArrayOfUsers.add(new User(1, "jdoe", "sup3rpaZZ", "John Doe"));
        anArrayOfUsers.add(new User(2, "jrow", "Qweqrty12", "Jane Row"));


        anArrayOfRoles.add(new Role(1, 1, "READ", "a"));
        anArrayOfRoles.add(new Role(2, 1, "WRITE", "a.b"));
        anArrayOfRoles.add(new Role(3, 2, "EXECUTE", "a.b.c"));
        anArrayOfRoles.add(new Role(4, 1, "EXECUTE", "a.bc"));

        Userdata userdata = new Parse(arg).parseCMD();
        if (userdata.isEmpty()) {
            System.exit(0);
        } else if (userdata.authentication()) {
//            Спрашиваем у класса userdata достаточно ли ему данных для аутентифиц
//            Хватает
//
//            Пытаемся аутентифицировать для всех 3х сценариев,
//            Если неуспешно то выходим с ошибкой аутент
            tryAuthent(anArrayOfUsers, userdata);

//            Спрашиваем у класса userdata хватает ли ему данных для авториз
            boolean authorization = userdata.authorization();
//            Не хватает: выходим успешно (т.к.аутентиф вышла бы при неуспехе)
            if (!authorization) {
                System.exit(0);
                //            Хватает: Пытаемся авторизировать
            } else {
                //            Если авториз неуспешна то выходим с ошибкой авториз
//
//            Спрашиваем у класса userdata достаточно ли ему данных для акк
//            не хвтает: выходим успешно (т.к. авториз вышла бы при неуспехе)
//            хватает: пытаемся акк
                tryAuthor(anArrayOfRoles, userdata);
            }


        } else {
            System.exit(0);
        }
    }

    private static void tryAuthent(ArrayList<User> anArrayOfUsers, Userdata userdata) {
        boolean resL = checkLogin(userdata, anArrayOfUsers);
        if (resL) {
            boolean resP = checkPassword(userdata, anArrayOfUsers);
            if (resP) {
                System.out.println("Successfully Authent.");

            } else {
                System.out.println("Wrong password");
                System.exit(2);
            }
        } else {
            System.out.println("Unknown user");
            System.exit(1);
        }
    }

    private static void tryAuthor(ArrayList<Role> anArrayOfRoles, Userdata userdata) {
        boolean resRo = checkRole(userdata, anArrayOfRoles);
        if (resRo) {
            boolean resRe = checkResource(userdata, anArrayOfRoles);
            if (resRe) {
                System.out.println("Successfully Author.");
            } else {
                System.out.println("Doesn't exist");
                System.exit(4);
            }
        } else {
            System.out.println("Unknown Role");
            System.exit(3);
        }
    }

    private static boolean checkLogin(Userdata userdata, ArrayList<User> anArrayOfUsers) {
        for (User anArrayOfUser : anArrayOfUsers) {
            if (userdata.getLogin().equals(anArrayOfUser.Login)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkPassword(Userdata userdata, ArrayList<User> anArrayOfUsers) {
        for (User anArrayOfUser : anArrayOfUsers) {
            String temp = Secure.MD5(Secure.MD5(userdata.getPassword())+anArrayOfUser.getSalt());
            if (userdata.getLogin().equals(anArrayOfUser.Login)
                    && temp.equals(anArrayOfUser.Password)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkRole(Userdata userdata, ArrayList<Role> anArrayOfRoles) {
        for (Role anArrayOfRole : anArrayOfRoles) {
            if (userdata.getRole().equals(anArrayOfRole.Name)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkResource(Userdata userdata,
                                         ArrayList<Role> anArrayOfRoles) {
        for (Role anArrayOfRole : anArrayOfRoles) {
            if (userdata.getRole().equals(anArrayOfRole.Name)&&
                    divide(anArrayOfRole.Resource,userdata.getResource())){
                return true;
            }
        }
        return false;

    }

    private static boolean divide(String Resource, String input) {
        String[] dividedRes;
        String[] dividedInp;
        dividedRes = Resource.split("\\.");
        dividedInp = input.split("\\.");
        if (dividedInp.length < dividedRes.length) {
            return false;
        } else {
            for (int i = 0; i < dividedRes.length; i++) {
                if (!dividedRes[i].equals(dividedInp[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
