/*
Table.java
Table entity
Author Demi Alexis Farquhar (220322104)
Date: 6 April 2022
 */
package za.ac.cput.entity;

public class Table {
    private String tableId;
    private int tableNo;
    private int noOfSeats;
    private boolean isTableAvailable;

    private Table() {
    }

    private Table(Builder builder) {
        this.tableId = builder.tableId;
        this.tableNo = builder.tableNo;
        this.noOfSeats = builder.noOfSeats;
        this.isTableAvailable = builder.isTableAvailable;
    }

    public String getTableId() {
        return tableId;
    }

    public int getTableNo() {
        return tableNo;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public boolean isTableAvailable() {
        return isTableAvailable;
    }

    @Override
    public String toString() {
        return "Table {" +
                " tableId='" + tableId + '\'' +
                ", tableNo=" + tableNo +
                ", noOfSeats=" + noOfSeats +
                ", isTableAvailable=" + isTableAvailable +
                '}';
    }

    public static class Builder {
        private String tableId;
        private int tableNo;
        private int noOfSeats;
        private boolean isTableAvailable;

        public Builder setTableId(String tableId) {
            this.tableId = tableId;
            return this;
        }

        public Builder setTableNo(int tableNo) {
            this.tableNo = tableNo;
            return this;
        }

        public Builder setNoOfSeats(int noOfSeats) {
            this.noOfSeats = noOfSeats;
            return this;
        }

        public Builder setTableAvailable(boolean tableAvailable) {
            isTableAvailable = tableAvailable;
            return this;
        }
        public Builder copy (Table table){
            this.tableId=table.tableId;
            this.tableNo=table.tableNo;
            this.noOfSeats=table.noOfSeats;
            this.isTableAvailable=table.isTableAvailable;
            return this;
        }
        public Table build(){
            return new Table(this);
        }
    }
}