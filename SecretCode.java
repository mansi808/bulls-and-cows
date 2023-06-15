package bullscows;
import java.util.Random;

//secret code generated using random class
class SecretCode extends GeneratedCode {

    SecretCode(int length) {
        super(length);
        this.length = length;
    }

    public void generateCode() {
        Random random = new Random();

        //algorithm for getting digits in thier length 0-9, 10-99, 100-999....
        //start from 10^length
        //(10^length - 10^length-1) +1 = interval
        //eg for 0-9: (10 - 1) + 1 = 10 = interval
        //eg for 0-9: 10^0 = 1 = start
        String code = String.valueOf(random.nextInt((int)(Math.pow(10,length) - Math.pow(10,length-1)) + 1)+Math.pow(10,length-1));

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
}
