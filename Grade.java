package bullscows;

//getter methods, incrementing methods, making number zeroes and printing the number of bulls and cows method
//logic for the game in assign()
class Grade {
    private static int bulls;
    private static int cows;

    public static int getBulls() {
        return bulls;
    }

    public static int getCows() {
        return cows;
    }

    public static void increBulls() {
        bulls++;
    }

    public static void increCows() {
        cows++;
    }

    public static void zeroBulls() {
        bulls =0;
    }

    public static void zeroCows() {
        cows =0;
    }

    public static void printGrade() {
        StringBuilder bull_info = new StringBuilder((bulls > 0) ? bulls+" bull" : "" );
        bull_info.append(bulls>1 && bulls > 0 ? "s " : bulls > 0 ? " ":"" );
        String connective = (bulls > 0 && cows >0) ? "and ": "";
        StringBuilder cow_info = new StringBuilder ((cows > 0) ? cows+" cow":"");
        cow_info.append(cows>1 && cows > 0 ? "s " : "" );
        StringBuilder none_info = new StringBuilder((cows==0&&bulls==0)? "None":"");
        System.out.println("Grade: " + bull_info +connective+cow_info+none_info);
    }

    static void assign(char[] secret_code, char[] guess_code) {
        Grade.zeroBulls();
        Grade.zeroCows();
        //bulls == numbers in right positions
        //cows number present in secret code but not in right position in guess code

        for (int i=0; i< guess_code.length ; i++) {
            if (secret_code[i] == guess_code[i]) {
                Grade.increBulls();
            } else {
                for (int x : secret_code) {
                    if (guess_code[i] == x) {
                        Grade.increCows();
                        break;
                    }
                }
            }
        }
    }//assign ends

}