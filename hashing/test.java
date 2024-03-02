package hashing;

import java.util.Vector;

public class test {

    public static int hashNum(int num, int n) {
        long n2 = n;
        return (int) ((num % n2 + n2) % n2);
    }

    public static int hashString(String str, int n) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum = sum + str.charAt(i) - 'a';
        }
        return sum % n;
    }

    public static int hashStringLowerUpperDigits(String str, int n) {
        int base = 2 * 26 + 10; // lower, upper, and 10 digits
        long n2 = n;
        long sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int value;
            if (Character.isDigit(ch)) {
                value = ch - '0' + 52;
            } else if (Character.isUpperCase(ch)) {
                value = ch - 'A' + 26;
            } else {
                value = ch - 'a';
            }

            sum = (sum * base + value) % n2;
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        System.out.println(hashStringLowerUpperDigits("ABC233", 10));
//        PhoneHashTable phoneHash = new PhoneHashTable(10);
//        phoneHash.put(new PhoneEntry("kareem", "201023412234"));
//        phoneHash.put(new PhoneEntry("ahmed", "201023412224"));
//        phoneHash.put(new PhoneEntry("taher", "202224"));
//        phoneHash.put(new PhoneEntry("taherr", "201023412224"));
//        phoneHash.put(new PhoneEntry("mahmoud", "201023412234"));
//        phoneHash.put(new PhoneEntry("gazy", "201023412224"));
//        phoneHash.put(new PhoneEntry("hamo", "201023412224"));
//        phoneHash.put(new PhoneEntry("dinaa", "201023412224"));
//        phoneHash.put(new PhoneEntry("tahr", "201023412224"));
//        phoneHash.put(new PhoneEntry("mamoud", "201023412234"));
//        phoneHash.put(new PhoneEntry("gazzy", "201023412224"));
//        phoneHash.put(new PhoneEntry("hamoo", "201023412224"));
//        phoneHash.put(new PhoneEntry("dina", "201023412224"));
//        phoneHash.print();
    }
}
