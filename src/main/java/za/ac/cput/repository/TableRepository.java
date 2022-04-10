/*
TableRepository.java
Author Demi Alexis Farquhar (220322104)
Date: 7 April 2022
 */

package za.ac.cput.repository;

import za.ac.cput.entity.Table;

import java.util.HashSet;
import java.util.Set;

public class TableRepository implements ITableRepository{
public static TableRepository repository=null;
private Set<Table> tableDB=null;

 private TableRepository(){
        tableDB= new HashSet<Table>();
    }
public static TableRepository getRepository(){
        if(repository==null){
            repository=new TableRepository();
        }
        return repository;
    }

    @Override
    public Table create(Table table) {
        boolean success= tableDB.add(table);
        if(!success)
            return null;
        return table;
    }

    @Override
    public Table read(String tableId) {
        Table table= tableDB.stream()
                .filter(t-> t.getTableId().equals(tableId))
                .findAny()
                .orElse(null);
        return table;

    }

    @Override
    public Table update(Table table) {
        Table oldTable= read(table.getTableId());
        if(oldTable!=null){
            tableDB.remove(oldTable);
            tableDB.add(table);
            return table;
        }
        return null;

    }

    @Override
    public boolean delete(String tableId) {
            Table tableToDelete=read(tableId);
            if(tableToDelete==null)
                return false;
            tableDB.remove(tableToDelete);
            return true;
    }

    @Override
    public Set<Table> getAll() {
        return  tableDB;
    }
}
