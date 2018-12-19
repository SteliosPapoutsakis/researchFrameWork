package Framework;/*
This class purpose is to turn decimal numbers into binary numbers without creating an object

@author Stelios Papoutsakis
 */

public class IntToBinary {


    //prints number with no length
    public static String printToBinary(int number) {
        return printToBinary(number,Integer.toBinaryString(number).length());
    }

    // prints a decimal number in binary with verilog format
    public static String printToBinary(int number, int bitSize) {
        String str = Integer.toBinaryString(number);


        // this conditial fixes binary numbers which are negative, so they are the right size;
        if (str.length() > bitSize)
            str = str.substring(str.length() - (bitSize + 1), str.length() - 1);
        String addition = "";
        while (str.length() + addition.length() < bitSize) {
            addition += "0";
        }
        return bitSize + "'b" + addition + str;
    }

    //prints strickly the binary number
    public static String strickBinary(int number, int size) {
        String str = Integer.toBinaryString(number);
        if (str.length() > size)
            str = str.substring(str.length() - (size + 1), str.length() - 1);
        String addition = "";
        while (str.length() + addition.length() < size) {
            addition += "0";
        }
        return addition + str;
    }

    // prints binary number without verilog syntax
    public static String strickBinary(int number) {
        return strickBinary(number,Integer.toBinaryString(number).length());
    }
}
