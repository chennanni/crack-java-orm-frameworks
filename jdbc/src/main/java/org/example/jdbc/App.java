package org.example.jdbc;

public class App {

    public static void main(String args[]) {
        JdbcImpl db = new JdbcImpl();
        db.conn = db.connectDB();

        //db.createTable();
        //db.updateData();

        db.selectData();
        db.closeDB();
    }

}
