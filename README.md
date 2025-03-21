כמובן! הנה קובץ README שמתאר את התוכנית שלך, המשחק ודרך פתרון האלגוריתם:

# Bulls & Cows Solver - README
Overview:
This is a Java-based program that implements a well-known algorithm to solve the Bulls & Cows game in an average of fewer than eight guesses. The program uses a smart searching algorithm to efficiently guess a secret number based on the feedback provided after each guess.

# About the Game
Bulls & Cows is a code-breaking game where one player (or the computer) thinks of a secret number, and the other player (or the solver) tries to guess it. After each guess, feedback is given in the form of:

Bulls: The number of digits that are correct and in the correct position.
Cows: The number of digits that are correct but in the wrong position.
The objective is to guess the secret number with as few guesses as possible, based on the feedback received after each guess.

# How the Algorithm Works
The algorithm implemented in this program applies a Minimax strategy, which is designed to minimize the number of guesses required to solve the puzzle. Here's how it works:

Start with all possible number combinations: The program begins with all the potential combinations of the secret number (for example, 4-digit numbers from 0000 to 9999 if the number length is 4).

Make an initial guess: The program makes a guess and receives feedback in the form of Bulls and Cows.

Filter out impossible solutions: Based on the feedback, the program eliminates all the number combinations that cannot possibly match the secret number.

Repeat the process: With each guess, the program continues to narrow down the possible solutions, choosing the guess that maximizes the elimination of options.

Minimize the number of guesses: The algorithm ensures that, on average, fewer than eight guesses are needed to guess the secret number correctly.

By iterating through this process, the program efficiently narrows down the possible solutions and guesses the secret number in a minimal number of tries

# important info:
The program for solving the Bulls & Cows game is executed by running the EX1 file. The TEST file contains two tests:

The first test: It calculates the average time of 100 executions with a customizable number of digits (using the numOfDigits variable) and shows that the average is less than 8 guesses.

The second test: It calculates the average time of 500 executions, with each execution including 100 attempts for each number of digits between 2 and 6, and shows that the average is less than 8 guesses.
