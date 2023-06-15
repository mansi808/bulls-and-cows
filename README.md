# bulls-and-cows
"Bulls And Cows" command line version.

🐮🐮🐮🐮🐮

### working

--asks for length of secret code (and number of symbols)

--generates secret code with characters (either a-z or 0-9 or both)

--Asks for guess code

--🐂Bulls = characters in correct position 

--🐄Cows = characters of guess code not in correct position

```
Please, enter the secret code's length:
3
Input the number of possible symbols in the code:
4
The secret is prepared: *** (0-3).
Okay, let's start a game!
Turn 1:
012
Grade: 1 bull and 1 cow
Turn 2:
021
Grade: 2 bulls 
Turn 3:
022
Grade: 1 bull 
Turn 4:
023
Grade: 1 bull and 1 cow
Turn 5:
031
Grade: 3 bulls 
Congratulations! You guessed the secret code.
```

### Project details

1. Grade - gets number of bulls and cows

2. Generated Code - parent class for code generation

3. Impossible code - creates code with a-z, 0-9

4. SecretCode - creates code with only 0-9

5. PseudoCode - creates code with 0-9 using System.nanoTime()

(Main.java currently generates code with characters a-z, 0-9)

#### Created for Java track project from Hyperskill.
