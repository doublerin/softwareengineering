package com.example.softwareengineering;

import com.example.softwareengineering.domain.Accounting;
import com.example.softwareengineering.domain.Permission;
import com.example.softwareengineering.domain.User;

import java.sql.*;

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

    public int addAcc(Accounting accounting) throws SQLException {
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

    //TODO: запросить роль
}
