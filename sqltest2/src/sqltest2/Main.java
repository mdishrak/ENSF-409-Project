//package edu.ucalgary.oop;
package sqltest2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        SqlMan dao = new SqlMan();
        dao.readDataBase();
        TaskMan taskMan = new TaskMan(dao.mergedList());
        
    }
}
