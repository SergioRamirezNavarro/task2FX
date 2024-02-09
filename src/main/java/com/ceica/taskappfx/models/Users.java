package com.ceica.taskappfx.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Users extends BaseModel
{
    private int iduser;
    private String username;
    private String password;
    private Roles rol;

    public Users() {
    }


    @Override
    protected String getNombreTabla() {
        return "user";
    }

    @Override
    protected Object createObjectFromResultSet(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public String toString() {
        return "User{" +
                "iduser=" + iduser +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rol=" + rol +
                '}';
    }

    public Users login(String username, String password) {
        Users user=new Users();
        Connection conn=user.getConnection();
        String sql="select iduser,username,rol.idrol,description from " +
                "user left join rol on user.idrol=rol.idrol " +
                "where username=? and password=?";
        try {
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1,username);
            pst.setString(2,password);
            ResultSet resultSet=pst.executeQuery();
            if(resultSet.next()){
                user.iduser=resultSet.getInt("iduser");
                user.username=resultSet.getString("username");
                Roles rol=new Roles();
                rol.setIdrol(resultSet.getInt("idrol"));
                rol.setDescription(resultSet.getString("description"));
                user.rol=rol;
                return user;
            }else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
