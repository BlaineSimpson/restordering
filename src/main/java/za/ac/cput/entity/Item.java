/*
Item.java
Item entity
Author Craig Jarvis (220103216)
Date: 9 April 2022
 */

package za.ac.cput.entity;

public class Item {
    private Integer ID;
    private Integer orderID;
    private Integer quantity;
    private double price;

    private Item(){
    }


    private Item(Builder builder){
        this.ID=builder.ID;
        this.orderID=builder.orderID;
        this.quantity=builder.quantity;
        this.price=builder.price;
    }



    //getters and setters
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    //end of getters and setters


    @Override
    public String toString() {
        return "Item{" +
                "ID=" + ID +
                ", orderID=" + orderID +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
    //end of toString


    public static class Builder{
        private Integer ID;
        private Integer orderID;
        private Integer quantity;
        private double price;

        public Builder setID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder setOrderID(Integer orderID) {
            this.orderID = orderID;
            return this;
        }

        public Builder setQuantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder copy(Item item){
            this.ID=item.ID;
            this.orderID=item.orderID;
            this.quantity=item.quantity;
            this.price=item.price;
            return this;
        }
        public Item build(){
            return new Item(this);
        }
    }
}