package hashing;

import static hashing.test.hashStringLowerUpperDigits;

public class PhoneEntry {

    static final int internalLimit = 2147483647;
    public String name;//key
    public String phoneNumber;//data

    public PhoneEntry(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int hash() {
        return hashStringLowerUpperDigits(name, internalLimit);
    }

}
