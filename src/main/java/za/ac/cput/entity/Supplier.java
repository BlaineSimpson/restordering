package za.ac.cput.entity;

/*
IRepository.java
Author: Shuaib Allie (217148867)
Date: 1 April 2022
 */

public class Supplier {

    private String suppName;

    private String suppPhysAddress;

    private String suppEmail;
    private int suppPhone;
    private int suppID;


    private Supplier(){}

    private Supplier(Supplier.Builder builder){
        this.suppName=builder.suppName;
        this.suppPhysAddress=builder.suppPhysAddress;
        this.suppEmail=builder.suppEmail;
        this.suppPhone=builder.suppPhone;
        this.suppID=builder.suppID;


    }

    public String getSuppName(){
        return suppName;
    }

    public String getSuppPhysAddress(){
        return suppPhysAddress;
    }

    public String getSuppEmail(){
        return suppEmail;
    }

    public int getSuppPhone(){
        return suppPhone;
    }

    private int getSuppID(){
        return suppID;
    }



    @Override
    public String toString(){
        return "Supplier{" +
                "suppName='" + suppName + '\'' +
                ", supPhysAddress='" + suppPhysAddress + '\'' +
                ", supEmail='" + suppEmail + '\'' +
                ", supPhone='" + suppPhone + '\'' +
                ", supID='" + suppID + '\'' +
                '}';
    }

    public static class Builder{
        private String suppName;

        private String suppPhysAddress;

        private String suppEmail;
        private int suppPhone;
        private int suppID;


        public Supplier.Builder setSuppName(String suppName){
            this.suppName = suppName;
            return this;
        }

        public Supplier.Builder setSuppPhysAddress(String suppPhysAddress){
            this.suppPhysAddress = suppPhysAddress;
            return this;
        }

        public Supplier.Builder setSupEmail(String suppEmail){
            this.suppEmail = suppEmail;
            return this;
        }

        public Supplier.Builder setSupPhone(int suppPhone){
            this.suppPhone = suppPhone;
            return this;
        }

        public Supplier.Builder setSuppID(int suppID){
            this.suppID = suppID;
            return this;
        }



        public Supplier.Builder copy (Supplier supplier){
            this.suppName = supplier.suppName;
            this.suppPhysAddress = supplier.suppPhysAddress;
            this.suppEmail = supplier.suppEmail;
            this.suppPhone = supplier.suppPhone;
            this.suppID = supplier.suppID;
            return this;
        }
        public Supplier build(){
            return new Supplier(this);
        }
    }

}

