package com.example.softwareengineering;

import com.example.softwareengineering.domain.Accounting;
import com.example.softwareengineering.domain.Permission;
import com.example.softwareengineering.domain.Role;
import com.example.softwareengineering.domain.User;
import org.apache.commons.cli.ParseException;
import org.flywaydb.core.Flyway;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.example.softwareengineering.Logging.log;


public class Main {

    public static void main(String[] arg) throws ParseException, ClassNotFoundException, SQLException {

        Class.forName("org.h2.Driver");
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:h2:file:./aaa", "aaa", "aaa");
        flyway.migrate();
        Connection con = DriverManager.getConnection("jdbc:h2:file:./aaa", "aaa", "aaa");
        AaaDao aaaDao = new AaaDao(con);
        log.info("Program is starting...");
        /*ArrayList<User> anArrayOfUsers = new ArrayList<>();
        ArrayList<Role> anArrayOfRoles = new ArrayList<>();

        anArrayOfUsers.add(new User(1, "jdoe", "sup3rpaZZ", "John Doe"));
        anArrayOfUsers.add(new User(2, "jrow", "Qweqrty12", "Jane Row"));

        anArrayOfRoles.add(new Role(1, anArrayOfUsers.get(0), Permission.READ, "a"));
        anArrayOfRoles.add(new Role(2, anArrayOfUsers.get(0), Permission.WRITE, "a.b"));
        anArrayOfRoles.add(new Role(3, anArrayOfUsers.get(1), Permission.EXECUTE, "a.b.c"));
        anArrayOfRoles.add(new Role(4, anArrayOfUsers.get(0), Permission.EXECUTE, "a.bc"));
*/
        Userdata userdata = new Parse(arg).parseCMD();

        if (userdata.isAuthentication()) {
            tryAuthent(aaaDao, userdata);
            if (!userdata.isAuthorization()) {
                System.exit(0);
            } else {
                tryAuthor(aaaDao, userdata);
            }
            if (!userdata.isAccounting()) {
                System.exit(0);
            } else {
                tryAcc(aaaDao, userdata);
            }

        } else {
            System.exit(0);
        }
    }


    private static void tryAuthent(AaaDao aaaDao, Userdata userdata) throws SQLException {
        if (isCorrectLogin(userdata, aaaDao)) {
            if (isCorrectPassword(userdata, aaaDao)) {
                log.info("Successfully Authent. Exit code: 0");

            } else {
                log.error("Password: " + userdata.getPassword() + " is wrong password. Exit code: 2");
                System.exit(2);
            }
        } else {
            log.error("Login: " + userdata.getLogin() + " is unknown user. Exit code: 1");
            System.exit(1);
        }
    }

    private static void tryAuthor(AaaDao aaaDao, Userdata userdata) throws SQLException {
        if (isCorrectRole(userdata)) {
            if (isCorrectResource(userdata, aaaDao)) {
                log.info("Successfully Author. Exit code: 0");
            } else {
                log.error("Resource: " + userdata.getResource() + " doesn't exist. Exit code: 4");
                System.exit(4);
            }
        } else {
            log.error("Role: " + userdata.getRole() + " is unknown Role. Exit code: 3");
            System.exit(3);
        }
    }

    private static void tryAcc(AaaDao aaaDao, Userdata userdata) throws SQLException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = null;
        LocalDate endDate = null;
        int vol = 0;

        try {
            startDate = LocalDate.parse(userdata.getDateStart(), dtf);
            endDate = LocalDate.parse(userdata.getDateEnd(), dtf);
        } catch (java.time.format.DateTimeParseException e) {
            log.error("Period: " + userdata.getDateStart() + " - " + userdata.getDateEnd() +
                    " is invalid activity. Exit code: 5");
            System.exit(5);
        }
        try {
            vol = Integer.valueOf(userdata.getVolume());
        } catch (java.lang.NumberFormatException e) {
            log.error("Volume: " + userdata.getVolume() + " is invalid activity. Exit code: 5");
            System.exit(5);
        }
        log.info("Successfully Acc. Exit code: 0");
        Role role = new Role(0, null, null, null);//TODO исправить
        aaaDao.addAcc(new Accounting(role, startDate, endDate, vol));
    }

    private static boolean isCorrectLogin(Userdata userdata, AaaDao aaaDao) throws SQLException {
        return aaaDao.getUser(userdata.getLogin()) != null;
    }

    private static boolean isCorrectPassword(Userdata userdata, AaaDao aaaDao) throws SQLException {
        User user=null;
        assert false;
        String temp = Secure.md5(Secure.md5(userdata.getPassword())+user.getSalt());
        return (aaaDao.getUser(userdata.getLogin()) != null)
                && temp.equals(aaaDao.getUser(userdata.getPassword()));

    }

    private static boolean isCorrectRole(Userdata userdata) {
        try {
            Permission.valueOf(userdata.getRole());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }

    }

    private static boolean isCorrectResource(Userdata userdata,
                                             AaaDao aaaDao) throws SQLException {
        return userdata.getPermission().equals(aaaDao.getUser(userdata.getRole())) &&
                isDivide(String.valueOf(aaaDao.getUser(userdata.getResource())), userdata.getResource())
                && (userdata.getLogin().equals(aaaDao.getUser(userdata.getRole()).getLogin()));

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
