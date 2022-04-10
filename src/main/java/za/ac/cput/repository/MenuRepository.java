package za.ac.cput.repository;

import za.ac.cput.entity.Menu;

import java.util.HashSet;
import java.util.Set;
/* MenuRepository.java
 Entity for the Menu
 Author: Blaine Simpson (218020171)
 Date: 02 April 2022

 */
public class MenuRepository implements IMenuRepository {

    private static IMenuRepository repository = null;
    private Set<Menu> menuDB=null;

    private MenuRepository(){

        menuDB = new HashSet<Menu>();

    }

    public static MenuRepository getRespository() {

        if (repository == null){
            repository = new MenuRepository();
        }

        return (MenuRepository) repository;
    }





    @Override
    public Menu read(String menu) {
        for (Menu m : menuDB) {
            if (m.getMenuT().equals(menu))
                return m;
        }
        return null;
    }


    @Override
    public Menu update(Menu menu) {
        Menu oldMenu = read (menu.getMenuId());
        if(oldMenu !=null) {
            menuDB.remove(oldMenu);
            menuDB.add(menu);
            return menu;
        }
        return null;

    }

    @Override
    public boolean delete(String MenuT) {
        Menu menuDelete = read(MenuT);
        if (menuDelete == null)
            return false;
        menuDB.remove(menuDelete);

        return true ;
    }
    @Override
    public Menu create(Menu menu) {

        boolean works = menuDB.add(menu);

        if (!works)
            return null;
        return menu;

    }
    @Override
    public Set<Menu> getAll() {
        return menuDB;
    }


}
