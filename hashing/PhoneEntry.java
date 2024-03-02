package hashing;

import static hashing.test.hashStringLowerUpperDigits;

public class PhoneEntry {

    static final int internalLimit = 2147483647;
    String name;//key
    String phoneNumber;//data

    public PhoneEntry(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    int hash() {
        return hashStringLowerUpperDigits(name, internalLimit);
    }

}
