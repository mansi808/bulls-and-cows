package bullscows;

//parent class of generated code which has necessary variables of length, value, conditions for code generation and getter method for value of code
class GeneratedCode {
    protected int length;
    protected String value = "";

    GeneratedCode(int length) {
        this.length = length;
    }

    public boolean conditions(char x) {
        //x digit should not be repeated
        //first digit at index 0 of value cannot be zero
        if (value.length() != 0 && (value.contains(String.valueOf(x))) )  {
            return false;
        }
        return true;
    }

    public String getValue() {
        return value;
    }

    public static boolean lengthIsValid(int length) {
        if (length > 10) {
            System.out.println("Error: can't generate a secret number with a length of " + length + " because there aren't enough unique digits.");
            return false;
        }
        return true;
    }

    //prints error message in case length is zero
    public static boolean lengthIsZero(int length) {
        if (length==0) {
            System.out.println("Error: can't generate a secret number with a length of " + length + ".");
            return true;
        } return false;
    }
}
