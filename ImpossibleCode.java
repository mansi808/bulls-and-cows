package bullscows;
import java.util.ArrayList;
import java.util.Random;

//code that has characters a-z 0-9
//has max length 36
//input 1: length
//input 2: number of possible symbols
//eg input 2 = 16 so 0-9 ---> 10 characters || a-f ---> 6 characters
public class ImpossibleCode extends GeneratedCode {
    private int symbols;
    private ArrayList<Character> usable_symbols = new ArrayList<>();


    ImpossibleCode(int length, int symbols) {
        super(length);
        this.length = length;
        this.symbols = symbols;

    }

    public void generateCode() {

        //ascii code of 0-9 ----> 48-57
        // a-z -----> 97-122
        //creating list of usable symbols of number of specified
        for (char z = 48; z <= 122; z++) {
            usable_symbols.add(z);
            if (z == 57) {
                z = 96;
            }
            if (usable_symbols.size() == this.symbols) break;
        }
        for (int i = 1; i <= this.length; i++) {
            random_selection(usable_symbols);
        }

        String asterisk = "*";
        System.out.println("The secret is prepared: "+ asterisk.repeat(this.length)+" " +"("+ ( this.symbols <=10 ? usable_symbols.get(0)+"-"+usable_symbols.get(usable_symbols.size()-1) : usable_symbols.get(0)+"-"+usable_symbols.get(9) )  + (this.symbols >10 ? ", "+usable_symbols.get(10)+"-"+usable_symbols.get(usable_symbols.size()-1):"") + ").");
    }

    //selecting random number index from list and adding it to the String 'value' (see superclass)
    public void random_selection(ArrayList<Character> usable_symbols) {
        Random random = new Random();

        int index = random.nextInt(usable_symbols.size());
        if (conditions(usable_symbols.get(index))) {
            this.value += usable_symbols.get(index);
        } else {
            random_selection(usable_symbols);
        }
    }
    //overiding parent method
    static public boolean lengthIsValid(int length) {
        if (length > 36) {
            System.out.println("Error: can't generate a secret number with a length of " + length + " because there aren't enough unique digits.");
            return false;
        }
        return true;
    }

    static public boolean symbolsIsValid(int symbols) {
        if (symbols > 36) {
            System.out.println("Error: can't generate a secret number with a length of " + symbols + " because there aren't enough unique digits.");
            return false;
        }
        return true;
    }


    //handling error and ending program
    //exits program in case if condition true
    public static void unique_char_error(int length, int symbols) {
        //if number of symbols are less than length show error
        //code must contain unique characters only
        if (length>symbols) {
            System.out.println("Error: it's not possible to generate a code with a length of "+ length+" with "+symbols +" unique symbols.");
            System.exit(0);
        }
    }

    //if length contains non digits
    //exits program in case if condition true
    public static void length_input_exception(String length) {
        if (!length.matches("[0-9]+")) {
            System.out.println("Error: "+"\""+length+"\""+" isn't a valid number.");
            System.exit(0);
        }
    }

    //checks if answer contains invalid characters >> Uppercase letter >> Symbols like asterisk >> Characters not in usable_symbols (see generateCode() method)
    //called in class 'Main' ---> 'main()' method
    public void invalid_answer_error(char [] user_code) {
        for (char x: user_code) {
            String y = String.valueOf(x);
            if (!y.matches("[0-9a-z]")) {
                System.out.println("Error: invalid user input must contain chosen characters only");
            }
        }
    }

}
