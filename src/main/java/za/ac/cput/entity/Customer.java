package za.ac.cput.entity;
/* Customer .java
 Entity for the Customer
 Author: Sinovuyo Mlanjeni (219220387)
 Date: 04 April 2022
*/
public class Customer {
    private String cusId;
    private String cusFName;
    private String cusLName;
    private String cusEmail;
    private String cusAddress;

    private Customer() {

    }

    private Customer(Builder builder){
        this.cusId=builder.cusId;
        this.cusFName = builder.cusFName;
        this.cusLName = builder.cusLName;
        this.cusEmail= builder.cusEmail;
        this.cusAddress= builder.cusAddress;

    }

    public String getCusId() {
        return cusId;
    }
    public String getCusFName() {
        return cusFName;
    }

    public String getCusLName() {
        return cusLName;
    }

    public String getCusEmail() {
        return cusEmail;
    }


    public String getCusAddress() {
        return cusAddress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + cusId + '\'' +
                ", customerFName='" + cusFName + '\'' +
                ", customerLName='" + cusLName + '\'' +
                ", customerEmail='" + cusEmail + '\'' +
                ", customerAddress='" + cusAddress + '\'' +
                '}';
    }

    public static class Builder{
        private String cusId;
        private String cusFName;
        private String cusLName;
        private String cusEmail;
        private String cusAddress;

        public Builder setCusId(String cusId){
            this.cusId = cusId;
            return this;
        }

        public Builder setCusFName(String cusFName){
            this.cusFName = cusFName;
            return this;
        }


        public Builder setCusLName(String cusLName){
            this.cusLName = cusLName;
            return this;
        }
        public Builder setCusEmail(String cusEmail){
            this.cusEmail = cusEmail;
            return this;
        }

        public Builder setCusAddress(String cusAddress){
            this.cusAddress = cusAddress;
            return this;
        }

        public Builder copy(Customer customer){
            this.cusId = customer.cusId;
            this.cusFName = customer.cusFName;
            this.cusLName = customer.cusLName;
            this.cusEmail= customer.cusEmail;
            this.cusAddress = customer.cusAddress;
            return this;
        }
        public Customer build(){
            return new Customer(this);
        }


    }
}

