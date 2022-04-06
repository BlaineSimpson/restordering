/*
Restaurant.java
Restaurant entity
Author Demi Alexis Farquhar (220322104)
Date: 6 April 2022
 */

package za.ac.cput.entity;

public class Restaurant {
    private String restaurantId;
    private String restaurantName;
    private String restaurantAddress;
    private boolean isOpen;

    private Restaurant(){}

private Restaurant(Builder builder ){
        this.restaurantId=builder.restaurantId;
        this.restaurantName=builder.restaurantName;
        this.restaurantAddress=builder.restaurantAddress;
        this.isOpen=builder.isOpen;

}

    public String getRestaurantId() {
        return restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public String toString() {
        return "Restaurant {" +
                " restaurantId='" + restaurantId + '\'' +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantAddress='" + restaurantAddress + '\'' +
                ", isOpen=" + isOpen +
                '}';
    }
    public static class Builder{
        private String restaurantId;
        private String restaurantName;
        private String restaurantAddress;
        private boolean isOpen;

        public Builder setRestaurantId(String restaurantId) {
            this.restaurantId = restaurantId;
            return this;
        }

        public Builder setRestaurantName(String restaurantName) {
            this.restaurantName = restaurantName;
            return this;
        }

        public Builder setRestaurantAddress(String restaurantAddress) {
            this.restaurantAddress = restaurantAddress;
            return this;
        }

        public Builder setOpen(boolean open) {
            isOpen = open;
            return this;
        }
        public Builder copy(Restaurant restaurant){
            this.restaurantId=restaurant.restaurantId;
            this.restaurantName=restaurant.restaurantName;
            this.restaurantAddress=restaurant.restaurantAddress;
            this.isOpen=restaurant.isOpen;
            return this;
        }
        public Restaurant build(){
            return new Restaurant(this);
        }
    }
    }

