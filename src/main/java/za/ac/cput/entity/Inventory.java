package za.ac.cput.entity;

/*
IRepository.java
Author: Shuaib Allie (217148867)
Date: 1 April 2022
 */

public class Inventory {

    private String inv;

    private String itemName;

    private String category;
    private String vendor;
    private int vendorInv;
    private int vendorPrice;


    private Inventory(){}

    private Inventory(Builder builder){
        this.inv=builder.inv;
        this.itemName=builder.itemName;
        this.category=builder.category;
        this.vendor=builder.vendor;
        this.vendorInv=builder.vendorInv;
        this.vendorPrice=builder.vendorPrice;

    }

    public String getInv(){
        return inv;
    }

    public String getCategory(){
        return category;
    }

    public String getItemName(){
        return itemName;
    }

    public String getVendor(){
        return vendor;
    }

    private int getVendorInv(){
        return vendorInv;
    }

    private int getVendorPrice(){
        return vendorPrice;
    }


    @Override
    public String toString(){
        return "Inventory{" +
                "Inventory Type='" + inv + '\'' +
                ", Item Name='" + itemName + '\'' +
                ", Category='" + category + '\'' +
                ", Vendor='" + vendor + '\'' +
                ", Inventory Amount='" + vendorInv + '\'' +
                ", Vendor Price (in Rands)='" + vendorPrice + '\'' +
                '}';
    }

    public static class Builder{
        private String inv;

        private String itemName;

        private String category;
        private String vendor;
        private int vendorInv;
        private int vendorPrice;


        public Builder setInv(String inv){
            this.inv = inv;
            return this;
        }

        public Builder setItemName(String itemName){
            this.itemName = itemName;
            return this;
        }

        public Builder setCategory(String category){
            this.category = category;
            return this;
        }

        public Builder setVendor(String vendor){
            this.vendor = vendor;
            return this;
        }

        public Builder setVendorInv(int vendorInv){
            this.vendorInv = vendorInv;
            return this;
        }

        public Builder setVendorPrice(int vendorPrice){
            this.vendorPrice = vendorPrice;
            return this;
        }



        public Builder copy (Inventory inventory){
            this.inv = inventory.inv;
            this.vendorInv = inventory.vendorInv;
            this.vendorPrice = inventory.vendorPrice;
            this.vendor = inventory.vendor;
            this.itemName = inventory.itemName;
            this.category = inventory.category;
            return this;
        }
        public Inventory build(){
            return new Inventory(this);
        }
    }

}

