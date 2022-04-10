/*
Order.java
Order entity
Author Craig Jarvis (220103216)
Date: 9 April 2022
 */

package za.ac.cput.entity;

public class Order {
    private Integer customerID;
    private String orderDate;
    private boolean isReady;

    private Order(){
    }


    private Order(Builder builder){
        this.customerID=builder.customerID;
        this.orderDate=builder.orderDate;
        this.isReady=builder.isReady;
    }


    //getters and setters
    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }
    //end of getters and setters


    @Override
    public String toString() {
        return "Order{" +
                "customerID=" + customerID +
                ", orderDate='" + orderDate + '\'' +
                ", isReady=" + isReady +
                '}';
    }
    //end of toString



    public static class Builder{
        private Integer customerID;
        private String orderDate;
        private boolean isReady;

        public Builder setCustomerID(Integer customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder setOrderDate(String orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder setReady(boolean ready) {
            isReady = ready;
            return this;
        }

        public Builder copy (Order order){
            this.customerID=order.customerID;
            this.orderDate=order.orderDate;
            this.isReady=order.isReady;
            return this;
        }
        public Order build(){
            return new Order(this);
        }
    }
}
