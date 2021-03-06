package com.fbs;

import com.fbs.db.DBCheckSchema;
import com.fbs.db.DBPropsFileRead;

import java.sql.SQLException;
import static com.fbs.db.DBCheckTables.checkTables;
import static com.fbs.db.DBExecuteQuery.execute;
import static com.fbs.db.DBSetupQueries.*;


public class Main {

    public static void main(String[] args) throws SQLException, InterruptedException {
        // Get information from db.props file
        DBPropsFileRead DBProps = new DBPropsFileRead();

        execute(DELETE_TABLE_USERS);
        execute(DELETE_TABLE_BILLBOARDS);
        execute(DELETE_TABLE_SCHEDULES);

        // Check it database exists
        if (DBCheckSchema.checkDatabase(DBProps.getSchema())){
           System.out.println("Checking tables...");
           checkTables();
           System.out.println("Tables Ok.");
           System.out.println("Starting SERVER....");
           Thread.sleep(10000);
           System.out.println("SERVER IS ONLINE");

            System.out.println("Test");

        }
        else{
            //System.out.println("Create new database");
            //System.out.println("Start application");
        }
    }
}