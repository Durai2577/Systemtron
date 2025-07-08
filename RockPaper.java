import java.util.Random;
import java.util.Scanner;

public class RockPaper {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        String[] choices = {"rock", "paper", "scissors"};
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Enter your choice (rock, paper, scissors): ");
            String userChoice = scanner.nextLine().toLowerCase();

            if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("Invalid choice. Please choose rock, paper, or scissors.");
                continue;
            }

            
            int computerChoiceIndex = random.nextInt(3); 
            String computerChoice = choices[computerChoiceIndex];

            System.out.println("Computer chose: " + computerChoice);

            
            if (userChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
            } else if (
                (userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                (userChoice.equals("scissors") && computerChoice.equals("paper"))
            ) {
                System.out.println("You win!");
            } else {
                System.out.println("Computer wins!");
            }

            
            System.out.println("Do you want to play again? (yes/no)");
            String response = scanner.nextLine().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}