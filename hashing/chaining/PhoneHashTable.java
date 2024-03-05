package hashing.chaining;

import hashing.PhoneEntry;
import java.util.Vector;

public class PhoneHashTable {

    int tableSize;
    Vector<Vector<PhoneEntry>> table;

    public PhoneHashTable(int tableSize) {
        this.tableSize = tableSize;
        this.table = new Vector<>(tableSize);
        for (int i = 0; i < tableSize; i++) {
            table.add(new Vector<>());
        }
    }

    public void put(PhoneEntry phone) {//o(n) time , o(1) memory
        int index = phone.hash() % tableSize;
        for (PhoneEntry itemPhone : table.get(index)) {
            if (itemPhone.name.equals(phone.name)) {
                itemPhone = phone;
                return;
            }
        }
        table.get(index).addLast(phone);
    }

    public boolean remove(PhoneEntry phone) {//o(n) time , o(1) memory
        int index = phone.hash() % tableSize;
        for (PhoneEntry itemPhone : table.get(index)) {
            if (itemPhone.name.equals(phone.name)) {
                PhoneEntry last = table.get(index).lastElement();
                swap(itemPhone, last);
                table.get(index).removeLast();
                return true;
            }
        }
        return false;
    }

    public boolean get(PhoneEntry phone) {//o(n) time , o(1) memory
        int index = phone.hash() % tableSize;
        for (PhoneEntry itemPhone : table.get(index)) {
            if (itemPhone.name.equals(phone.name)) {
                itemPhone = phone;
                return true;
            }
        }
        return false;
    }

    private void swap(PhoneEntry itemPhone, PhoneEntry last) {//o(1) time , o(1) memory
        PhoneEntry temp = itemPhone;
        itemPhone = last;
        last = temp;
    }

    public void print() {//o(n2) time , o(1) memory
        for (int i = 0; i < tableSize; i++) {
            if(table.get(i).isEmpty()){
                continue;
            }
            System.out.print(i + " : ");
            for (PhoneEntry item : table.get(i)) {
                System.out.print(" (" + item.name+","+item.phoneNumber+") ");
            }
            System.out.println("");
        }
    }

}
