package za.ac.cput.repository;
/* Bill.java
 Entity for the Bill
 Author: Sinovuyo Mlanjeni (219220387)
 Date: 04 April 2022
*/
import za.ac.cput.entity.Bill;
import java.util.HashSet;
import java.util.Set;



public class BillRepository implements IBillRepository{
    private static BillRepository repository=null;
    private Set<Bill> billDB=null;

    private BillRepository(){
        billDB = new HashSet<Bill>();
    }

    public static BillRepository getRepository() {
        if (repository == null) {
            repository = new BillRepository();
        }
        return repository;
    }
    @Override
    public Bill create (Bill bill){
        boolean success = billDB.add(bill);

        if(!success)
            return null;
        return bill;
    }

    @Override
    public Bill read(String billId){
        Bill bill = billDB.stream()
                .filter(i-> i.getBillId().equals(billId))
                .findAny()
                .orElse(null);

        return bill;
    }

    @Override
    public Bill update(Bill bill){
      Bill oldBill=read(bill.getBillId());
        if(oldBill !=null){
            billDB.remove(oldBill);
           billDB.add(bill);
            return bill;
        }
        return null;
    }
    @Override

    public boolean delete(String billId) {
        Bill billToDelete=read(billId);
        if(billToDelete == null)
            return false;

        billDB.remove(billToDelete);

        return true;
    }

    @Override
    public Set<Bill> getAll(){
        return billDB;
    }


}



