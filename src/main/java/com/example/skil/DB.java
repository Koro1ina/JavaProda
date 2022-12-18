package com.example.skil;

import java.sql.*;
import java.util.Properties;

public class DB {
    private final String HOST = "172.16.225.104";
    private final String PORT = "3306";
    private final String DB_NAME = "user27";

    private Connection dbConn = null;

    // Метод для подключения к БД с использованием значений выше
    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        Properties properties = new Properties();

        properties.setProperty("user", "user27");
        properties.setProperty("password", "62462");
        properties.setProperty("useUnicode", "true");
        properties.setProperty("characterEncoding", "utf8");

        String connStr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConn = DriverManager.getConnection(connStr, properties);
        return dbConn;
    }
    Integer col;
    public Integer getTasks(String loginDB, String passwordDB) throws SQLException, ClassNotFoundException {
        String sql1 = "SELECT FIO, position FROM staff, positions WHERE positions.id = staff.position AND login = loginDB AND password = passwordDB  ORDER BY `id` DESC";
        String sql = "SELECT count(*) as col FROM staff, positions WHERE positions.id = staff.position AND login = '"+loginDB+"' AND password = '"+passwordDB+"'";
        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);

        Integer tasks = 0;
        while(res.next()) {
            tasks = res.getInt(1);
        }


        return tasks;
        //System.out.println(tasks);

    }

    public String[] getTasks1(String loginDB, String passwordDB) throws SQLException, ClassNotFoundException {
        String sql1 = "SELECT FIO, positions.positions FROM staff, positions WHERE positions.id = staff.position AND login = '"+loginDB+"' AND password = '"+passwordDB+"'";
        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql1);

        String[] tasks = new String[2];
        while(res.next()) {
            tasks[0] = res.getString(1);
            tasks[1] = res.getString(2);
        }


        return tasks;
        //System.out.println(tasks);

    }

}
