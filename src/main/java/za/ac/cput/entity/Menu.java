package za.ac.cput.entity;
/* Menu.java
 Entity for the Menu
 Author: Blaine Simpson (218020171)
 Date: 02 April 2022

 */
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String MenuId;
    private String MenuT;

    private Menu(Builder builder){
        this.MenuId = builder.MenuId;
        this.MenuT = builder.MenuT;

    }

    public Menu(String menuId, String menuT) {
        MenuId = menuId;
        MenuT = menuT;
    }

    public String getMenuId() {

        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }

    public String getMenuT() {
        return MenuT;
    }

    public void setMenuT(String menuT) {
        MenuT = menuT;
    }






    @Override
    public String toString() {
        return "Menu{" +
                "MenuId=" + MenuId +
                ", MenuT=" + MenuT +
                '}';
    }
    public static class Builder {

        private String MenuId;
        private String MenuT;

    public Builder setMenuId(String menuId){
        MenuId = menuId;
        return this;

    }

    public Builder setMenuT(String menut){

        MenuT = menut;
        return this;
    }
    public Builder copy(Menu menu){
        this.MenuId = menu.MenuId;
        this.MenuT = menu.MenuT;
        return this;

    }

    public Menu build() {

       return new Menu(this);

    }



    }



}
