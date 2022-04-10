package za.ac.cput.entity;

/* ItemOrder.java
 Entity for the ItemOrder
 Author: Blaine Simpson (218020171)
 Date: 02 April 2022

 */
public class ItemOrder {

    private String ItemId;
    private String ItemName;
    private String NumberofPlates;


   private ItemOrder(Builder builder){
        this.ItemId = builder.ItemId;
        this.ItemName = builder.ItemName;
        this.NumberofPlates = builder.NumberofPlates;

    }

    public ItemOrder(String itemId, String itemName, String NumberofPlates) {
        ItemId = itemId;
        ItemName = itemName;
        this.NumberofPlates = NumberofPlates;
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
        return NumberofPlates;
    }

    public void setNumberofPlates(String NumberofPlates) {
        this.NumberofPlates = NumberofPlates;
    }

    @Override
    public String toString() {
        return "Item{" +
                "ItemId=" + ItemId +
                ", ItemName='" + ItemName + '\'' +
                ", NumberofPlates=" + NumberofPlates +
                '}';
    }

    public static class Builder{

        private String ItemId;
        private String ItemName;
        private String NumberofPlates;


        public Builder setItemId(String itemId) {
            ItemId = itemId;
            return this;
        }

        public Builder setItemName(String itemName) {
            ItemName = itemName;
            return this;
        }

        public Builder setNumberofPlates(String NumberofPlates) {
            this.NumberofPlates = NumberofPlates;
            return this;

        }
        public Builder copy(ItemOrder item){
          this.ItemId = item.ItemId;
          this.ItemName =item.ItemName;
          this.NumberofPlates = item.NumberofPlates;
          return this;


        }

        public ItemOrder build() {

         return  new ItemOrder(this);
        }


    }
}
