
package MiniHangmanGame;

import java.util.*;

/**
 *
 * @author RabiaYAVULUEL
 */
public class MiniHangmanGame {

    public static void main(String[] args) {
        Scanner ky = new Scanner(System.in);
        String word = "JAVA";
        char[] guessedWord = new char[word.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        int attempts = 0;
        boolean gameOver = false;
        StringBuilder wrongGuesses = new StringBuilder();

        while (!gameOver) {
            System.out.println("\nWord: " + String.valueOf(guessedWord));
            System.out.println("Wrong Letters: " + wrongGuesses);
            System.out.print("Guess a letter: ");
            char guess = Character.toUpperCase(ky.next().charAt(0));

            if (word.indexOf(guess) >= 0) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        guessedWord[i] = guess;
                    }
                }
            } else {
                if (wrongGuesses.indexOf(String.valueOf(guess)) == -1) {
                    wrongGuesses.append(guess).append(" ");
                    attempts++;
                }
            }

            switch (attempts) {
                case 1 ->
                    System.out.println("\n O");
                case 2 ->
                    System.out.println("\n O\n |");
                case 3 ->
                    System.out.println("\n O\n /|");
                case 4 ->
                    System.out.println("\n O\n /|\\");
                case 5 ->
                    System.out.println("\n O\n /|\\\n /");
                case 6 -> {
                    System.out.println("\n O\n /|\\\n / \\");
                    System.out.println("Game Over! The Word: " + word);
                    gameOver = true;
                }
            }
            if (String.valueOf(guessedWord).equals(word)) {
                System.out.println("Congrats! You found the word: " + word);
                gameOver = true;
            }
        }
        ky.close();
    }
}
