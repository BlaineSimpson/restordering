package za.ac.cput.entity;
/* Bill.java
  Entity for the Bill
   Author: Sinovuyo Mlanjeni (219220387)
    Date: 04 April 2022
         */

public class Bill {
    private String billId;
    private String billDate;
    private String cusId;
    private String restaurantId;
    private String billDescr;
    private int billAmount;

    private Bill(){

    }
    private Bill(Builder builder){
        this.billId = builder.billId;
        this.billDate = builder.billDate;
        this.cusId = builder.cusId;
        this.restaurantId = builder.restaurantId;
        this.billDescr = builder.billDescr;
        this.billAmount = builder.billAmount;
    }


    public String getBillId() {
        return billId;
    }

    public String getCusId() {
        return cusId;
    }

    public String getBillDate() {
        return billDate;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public String getBillDescr() {
        return billDescr;
    }

    public int getBillAmount() {
        return billAmount;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId='" + billId + '\'' +
                ", billDate='" + billDate + '\'' +
                ", cusId='" + cusId + '\'' +
                ", restaurantId='" + restaurantId + '\'' +
                ", billDescr='" + billDescr + '\'' +
                ", billAmount=" + billAmount +
                '}';
    }

    public static class Builder{
        private String billId;
        private String billDate;
        private String cusId;
        private String restaurantId;
        private String billDescr;
        private int billAmount;

        public Builder setBillId(String billId){
            this.billId = billId;
            return this;
        }

        public Builder setBillDate(String billDate){
            this.billDate = billDate;
            return this;
        }

        public Builder setCusId(String cusId){
            this.cusId = cusId;
            return this;
        }

        public Builder setRestaurantId(String restaurantId){
            this.restaurantId = restaurantId;
            return this;
        }

        public Builder setBillDescr(String billDescr){
            this.billDescr = billDescr;
            return this;
        }

        public Builder setBillAmount(int billAmount){
            this.billAmount= billAmount;
            return this;
        }

        public Builder copy (Bill bill){
            this.billId = bill.billId;
            this.billDate= bill.billDate;
            this.cusId = bill.cusId;
            this.restaurantId = bill.restaurantId;
            this.billDescr = bill.billDescr;
            this.billAmount = bill.billAmount;
            return this;
        }

        public Bill build(){
            return new Bill(this);
        }

    }

}
