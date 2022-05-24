package org.example.jdbc;

public class App {
    public static void main(String args[]) {

        JdbcImpl db = new JdbcImpl();
        db.conn = db.connectDB();

        //db.createTable();
        //String sqlUpdate = "update ACCOUNT set name = \"Charlie\" where id = 2";
        //db.updateData(sqlUpdate);

        String sqlSelect = "select * from ACCOUNT";
        db.selectData(sqlSelect);
        db.closeDB();
    }
}
