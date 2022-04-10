package za.ac.cput.entity;

/* Item.java
 Entity for the Item
 Author: Blaine Simpson (218020171)
 Date: 01 April 2022

 */
public class Item {

    private String ItemId;
    private String ItemName;
    private String price;


   private Item(Builder builder){
        this.ItemId = builder.ItemId;
        this.ItemName = builder.ItemName;
        this.price = builder.price;

    }

    public Item(String itemId, String itemName, String price) {
        ItemId = itemId;
        ItemName = itemName;
        this.price = price;
    }

    public String getItemId() {
        return ItemId;
    }

    public void setItemId(String itemId) {
        ItemId = itemId;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "ItemId=" + ItemId +
                ", ItemName='" + ItemName + '\'' +
                ", price=" + price +
                '}';
    }

    public static class Builder{

        private String ItemId;
        private String ItemName;
        private String price;


        public Builder setItemId(String itemId) {
            ItemId = itemId;
            return this;
        }

        public Builder setItemName(String itemName) {
            ItemName = itemName;
            return this;
        }

        public Builder setPrice(String price) {
            this.price = price;
            return this;

        }
        public Builder copy(Item item){
          this.ItemId = item.ItemId;
          this.ItemName =item.ItemName;
          this.price = item.price;
          return this;


        }

        public Item build() {

         return  new Item(this);
        }


    }
}
