package com.example.softwareengineering;

import com.example.softwareengineering.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AaaDao {

    Connection con;

    public AaaDao(Connection con) {
        this.con = con;
    }

    public User getUser(String login) throws SQLException {
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
}
