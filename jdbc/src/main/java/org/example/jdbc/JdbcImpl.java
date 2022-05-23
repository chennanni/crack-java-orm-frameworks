package org.example.jdbc;

import java.sql.*;

public class JdbcImpl {
    public Connection conn;
    private String jdbcDriver = "org.h2.Driver";
    private String jdbcUrl = "jdbc:h2:file:F:/H2/db1";
    private String jdbcUsername = "sa";
    private String jdbcPassword = "";
    private String sqlSelect = "select * from ACCOUNT";
    private String sqlUpdate = "update ACCOUNT set name = \"Charlie\" where id = 2";
    public Connection connectDB() {
        // register jdbc driver
        try {
            Class.forName(jdbcDriver);
        } catch(ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }

        // connect to db
        try {
            Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
            System.out.println("connect successfully :)");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeDB() {
        try {
            conn.close();
            System.out.println("connection closed, bye...");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateData() {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sqlUpdate);
            int count = ps.executeUpdate();
            System.out.println(count + " rows updated!");
            ps.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectData() {
        if(conn != null) {
            try {
                Statement st;
                ResultSet rs;
                st = conn.createStatement();
                rs = st.executeQuery(sqlSelect);
                ResultSetMetaData rsmd = rs.getMetaData();
                int count = rsmd.getColumnCount();
                // print header
                for(int i=1;i<=count;i++) {
                    System.out.print(rsmd.getColumnName(i) + "\t");
                }
                System.out.println();
                // print data
                while(rs.next()) {
                    for(int i=1;i<=count;i++)
                        System.out.print(rs.getString(i) + "\t");
                    System.out.println("");
                }
                rs.close();
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
