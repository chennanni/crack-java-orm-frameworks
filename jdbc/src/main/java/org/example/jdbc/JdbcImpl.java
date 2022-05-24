package org.example.jdbc;

import java.sql.*;

public class JdbcImpl {
    public Connection conn;
    public Connection connectDB() {
        // register jdbc driver
        try {
            Class.forName(DbConfig.JDBC_DRIVER);
        } catch(ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }

        // connect to db
        try {
            Connection conn = DriverManager.getConnection(DbConfig.JDBC_URL, DbConfig.JDBC_USERNAME, DbConfig.JDBC_PASSWORD);
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

    public void updateData(String sqlUpdate) {
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

    public void selectData(String sqlSelect) {
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
