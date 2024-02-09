package com.ceica.taskappfx.models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tasks extends BaseModel
{

    private int idtask;
    private String title;
    private String description;
    private Users user;
    private boolean status;
    private Date create_time;
    private Date deadline;

    public Tasks() {
    }

    public int getIdtask() {
        return idtask;
    }

    public void setIdtask(int idtask) {
        this.idtask = idtask;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Override
    protected String getNombreTabla() {
        return "tasks";
    }

    @Override
    protected Object createObjectFromResultSet(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public String toString() {
        return "Task{" +
                "idtask=" + idtask +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                ", status=" + status +
                ", create_time=" + create_time +
                ", deadline=" + deadline +
                '}';
    }
}