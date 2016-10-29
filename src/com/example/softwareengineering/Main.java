package com.example.softwareengineering;

import org.apache.commons.cli.ParseException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
            tryAuthent(anArrayOfUsers, userdata);
            boolean authorization = userdata.authorization();
            if (!authorization) {
                System.exit(0);
            } else {
                tryAuthor(anArrayOfRoles, userdata);
            }
            boolean accounting = userdata.accounting();
            if (!accounting) {
                System.exit(0);
            } else {
                tryAcc(userdata);
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

    private static void tryAcc(Userdata userdata) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start_date = null;
        LocalDate end_date = null;

        try {
            start_date = LocalDate.parse(userdata.getuDate_start(), dtf);
            end_date = LocalDate.parse(userdata.getuDate_end(), dtf);
        } catch (java.time.format.DateTimeParseException e) {
            System.out.println(e);
            System.exit(5);
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
            String temp = Secure.MD5(Secure.MD5(userdata.getPassword()) + anArrayOfUser.getSalt());
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
            if (userdata.getRole().equals(anArrayOfRole.Name) &&
                    divide(anArrayOfRole.Resource, userdata.getResource())) {
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
