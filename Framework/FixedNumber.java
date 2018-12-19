package Framework;

/*
This class is used to describe a standard binary number in verilog
This class takes the info and prints the appropriate
verilog code

@author Stelios Papoutsakis
*/
public class FixedNumber extends VerilogComp {
    private int number;

    //two ctor, this is because negative numbers need to be limited with a size, as well as some numbers needing to be bigger
    // to fit in registers

    public FixedNumber(int number, int size) {
        super("" + IntToBinary.printToBinary(number, size), size, false, false);
        this.number = number;


    }

    public FixedNumber(int number) {
        super("" + IntToBinary.printToBinary(number), Integer.toBinaryString(number).length(), false, false);


    }



}



