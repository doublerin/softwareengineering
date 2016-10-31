package com.example.software_engineering;

import org.apache.commons.cli.ParseException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] arg) throws ParseException {

        ArrayList<User> anArrayOfUsers = new ArrayList<>();
        ArrayList<Role> anArrayOfRoles = new ArrayList<>();


        anArrayOfUsers.add(new User(1, "jdoe", "sup3rpaZZ", "John Doe"));
        anArrayOfUsers.add(new User(2, "jrow", "Qweqrty12", "Jane Row"));


        anArrayOfRoles.add(new Role(1, 1, "READ", "a"));
        anArrayOfRoles.add(new Role(2, 1, "WRITE", "a.b"));
        anArrayOfRoles.add(new Role(3, 2, "EXECUTE", "a.b.c"));
        anArrayOfRoles.add(new Role(4, 1, "EXECUTE", "a.bc"));

        Userdata userdata = new Parse(arg).parseCMD();

        if (userdata.isAuthentication()) {
            tryAuthent(anArrayOfUsers, userdata);
            if (!userdata.isAuthorization()) {
                System.exit(0);
            } else {
                tryAuthor(anArrayOfRoles, userdata);
            }
            if (!userdata.isAccounting()) {
                System.exit(0);
            } else {
                tryAcc(userdata);
            }

        } else {
            System.exit(0);
        }
    }


    private static void tryAuthent(ArrayList<User> anArrayOfUsers, Userdata userdata) {
        if (isCorrectLogin(userdata, anArrayOfUsers)) {
            if (isCorrectPassword(userdata, anArrayOfUsers)) {
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
        if (isCorrectRole(userdata, anArrayOfRoles)) {
            if (isCorrectResource(userdata, anArrayOfRoles)) {
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
        int vol = 0;

        try {
            start_date = LocalDate.parse(userdata.getuDate_start(), dtf);
            end_date = LocalDate.parse(userdata.getuDate_end(), dtf);
        } catch (java.time.format.DateTimeParseException e) {
            System.out.println("Invalid Activity");
            System.exit(5);
        }
        try {
            vol = Integer.valueOf(userdata.getuVolume());
        } catch (java.lang.NumberFormatException e) {
            System.out.println("Invalid Activity");
            System.exit(5);
        }
        System.out.println("Successfully Acc.");
        ArrayList<WastedVolume> wasted = new ArrayList<>();
        wasted.add(new WastedVolume(userdata.getRole(), userdata.getResource(),
                start_date, end_date, vol));
    }

    private static boolean isCorrectLogin(Userdata userdata, ArrayList<User> anArrayOfUsers) {
        for (User anArrayOfUser : anArrayOfUsers) {
            if (userdata.getLogin().equals(anArrayOfUser.login)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCorrectPassword(Userdata userdata, ArrayList<User> anArrayOfUsers) {
        for (User anArrayOfUser : anArrayOfUsers) {
            String temp = Secure.md5(Secure.md5(userdata.getPassword()) + anArrayOfUser.salt);
            if (userdata.getLogin().equals(anArrayOfUser.login)
                    && temp.equals(anArrayOfUser.password)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCorrectRole(Userdata userdata, ArrayList<Role> anArrayOfRoles) {
        for (Role anArrayOfRole : anArrayOfRoles) {
            if (userdata.getRole().equals(anArrayOfRole.rName)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCorrectResource(Userdata userdata,
                                             ArrayList<Role> anArrayOfRoles) {
        for (Role anArrayOfRole : anArrayOfRoles) {
            if (userdata.getRole().equals(anArrayOfRole.rName) &&
                    isDivide(anArrayOfRole.rResource, userdata.getResource())) {
                return true;
            }
        }
        return false;

    }

    private static boolean isDivide(String Resource, String input) {
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
