package com.example.softwareengineering;

import com.example.softwareengineering.domain.Accounting;
import com.example.softwareengineering.domain.Permission;
import com.example.softwareengineering.domain.User;
import com.example.softwareengineering.domain.Role;

import java.sql.*;

class AaaDao {

    private Connection con;

    AaaDao(Connection con) {
        this.con = con;
    }

    User getUser(String login) throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT * FROM USER WHERE LOGIN = ?");
        ps.setString(1, login);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            User user = new User();
            user.setId(rs.getInt(1));
            user.setName(rs.getString(2));
            user.setLogin(rs.getString(3));
            user.setPassword(rs.getString(4));
            user.setSalt(rs.getString(5));
            return user;
        } else {
            return null;
        }
    }

     int addAcc(Accounting accounting) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO ACCOUNTING (DATE_START, DATE_END, VOLUME, ROLE_ID) VALUES (?, ?, ?, ?)");
        ps.setDate(1, Date.valueOf(accounting.getDateStart()));
        ps.setDate(2, Date.valueOf(accounting.getDateEnd()));
        ps.setInt(3, accounting.getVolume());
        ps.setInt(4, accounting.getRole().getId());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    Role getRole(User user) throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT * FROM ROLE WHERE USER_ID = ?");
        ps.setString(1, String.valueOf(user.getId()));
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Role role = new Role();
            role.setId(rs.getInt(1));
            role.setPermission(Permission.valueOf(rs.getString(2)));
            role.setResource(rs.getString(3));
            return role;
        } else {
            return null;
        }
    }
}
