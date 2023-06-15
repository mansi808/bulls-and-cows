package bullscows;

//secret code generated using System.nanoTime()
class PseudoCode extends GeneratedCode {

    PseudoCode(int length) {
        super(length);
        this.length = length;
    }

    public void generateCode() {
        //this generates code of random length
        long pseudoRandomNumber = System.nanoTime();
        String code = Long.toString(pseudoRandomNumber);

        if (code.charAt(code.length()-1)=='0') generateCode();
        //generating new code if length of the code is less than required number of digits

        if (code.length() >= length) {
            //adding numbers to value string
            //starting from last index
            for (int i = code.length()-1; i >= 0; i--) {

                value = conditions(code.charAt(i)) ? (value + code.charAt(i)) : value;
                if (value.length() == length) break;
            }
        } else generateCode();
    }

    public void printMessage() {
        if (length >10) System.out.println("Error: can't generate a secret number with a length of "+length+" because there aren't enough unique digits.");
        else {
            generateCode();
            System.out.println("The random secret number is " +this.getValue()+".");
        }
    }
}
