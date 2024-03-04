package hashing.probing;

import hashing.PhoneEntry;
import java.util.Vector;

public class PhoneHashTable {
    
    int tableSize;
    public Vector<PhoneEntry> table;
    PhoneEntry deleted = new PhoneEntry("", "");
    
    public PhoneHashTable(int tableSize) {
        this.tableSize = tableSize;
        this.table = new Vector<>(this.tableSize);
        for (int i = 0; i < tableSize; i++) {
            this.table.add(null);
        }
    }
    
    public boolean put(PhoneEntry phone) {
        int index = phone.hash() % tableSize;
        for (int ind = 0; ind < tableSize; ++ind) {
            if (table.get(index) == null || table.get(index).equals(deleted)) {
                table.set(index, phone);//add
                return true;
            } else if (table.get(index).name.equals(phone.name)) {
                table.get(index).phoneNumber = phone.phoneNumber;//update
                return true;
            }
            index = (index + 1) % tableSize;//move
        }
        return false;
    }
    
    public boolean remove(PhoneEntry phone) {
        int index = phone.hash() % tableSize;
        for (int ind = 0; ind < tableSize; ++ind) {
            if (table.get(index) == deleted || table.get(index) == null) {
                return false;
            } else if (table.get(index).name.equals(phone.name)) {
                table.set(index, deleted);
                return true;
            }
            index = (index + 1) % tableSize;//move
        }
        return false;
    }
    
    public boolean get(PhoneEntry phone) {
        int index = phone.hash() % tableSize;
        for (int ind = 0; ind < tableSize; ++ind) {
            if (table.get(index) == deleted || table.get(index) == null) {
                return false;
            } else if (table.get(index).name.equals(phone.name)) {
                table.get(index).phoneNumber.equals(phone.phoneNumber);
                return true;
            }
            index = (index + 1) % tableSize;//move
        }
        return false;
    }
    
    private void swap(PhoneEntry itemPhone, PhoneEntry last) {
        PhoneEntry temp = itemPhone;
        itemPhone = last;
        last = temp;
    }
    
    public void print() {
        for (int i = 0; i < tableSize; i++) {
            if (this.table.get(i) != null) {
                System.out.println(i + " : " + table.get(i).name + " " + table.get(i).phoneNumber);
            }
        }
        System.out.println("");
    }
    
}
