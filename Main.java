package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int chance_num =1;
        boolean game_active = true;

        System.out.println("Please, enter the secret code's length:");
        String str_length = scanner.nextLine();
        ImpossibleCode.length_input_exception(str_length);
        int length = Integer.parseInt(str_length);

        while (!ImpossibleCode.lengthIsValid(length) || ImpossibleCode.lengthIsZero(length)) {
            System.out.println("Please, enter the secret code's length:");
            length = scanner.nextInt();
            ImpossibleCode.lengthIsZero(length);
        }

        System.out.println("Input the number of possible symbols in the code:");
        int symbols = scanner.nextInt();

        ImpossibleCode.unique_char_error(length, symbols);
        if (!ImpossibleCode.symbolsIsValid(symbols)) System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");

        ImpossibleCode impossiblecode = new ImpossibleCode(length, symbols);

        impossiblecode.generateCode();
        System.out.println("Okay, let's start a game!");

        char[] secret_code = impossiblecode.getValue().toString().toCharArray();
        System.out.println(secret_code);

        while (game_active) {
            System.out.println("Turn "+chance_num+":");

            char[] guess_code = scanner.next().toCharArray();
            impossiblecode.invalid_answer_error(guess_code);
            Grade.assign(secret_code, guess_code);

            Grade.printGrade();
            chance_num++;
            if (Grade.getBulls()==secret_code.length) game_active=false;
        }
        System.out.println("Congratulations! You guessed the secret code.");
    }
}
