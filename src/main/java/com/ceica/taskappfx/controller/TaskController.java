package com.ceica.taskappfx.controller;


import com.ceica.taskappfx.models.Users;

public class TaskController
{
    private Users userLogged;
    public boolean createUser(String username,String password,int role)
    {
        Users user=new Users();
        return user.insertar("(username,password,id_role) values (?,?,?)",username,password,role);
    }
    public boolean editPassword (String username, String password)
    {
        Users user= new Users();
        user.actualizar("password=? where username=?");
        return true;
    }
    public boolean Login(String username, String password)
    {
        String sql="select id_user, username, id_role, description form "+
                "user left join role on user.id_role=role.id_role";

        Users user= new Users();
        userLogged= user.login(username,password);
        if (userLogged!=null)
        {
            return true;
        }
            else
            {
              return false;
            }
    }
}