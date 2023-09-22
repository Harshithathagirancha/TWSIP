import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineVotingSystem {

    public static void main(String[] args) {
        Map<String, Integer> candidates = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        // Initialize candidates
        candidates.put("Candidate A", 0);
        candidates.put("Candidate B", 0);
        candidates.put("Candidate C", 0);

        System.out.println("Welcome to the Online Voting System!");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Vote for a candidate");
            System.out.println("2. View election results");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Candidates:");
                    for (String candidate : candidates.keySet()) {
                        System.out.println(candidate);
                    }
                    System.out.print("Enter the name of the candidate you want to vote for: ");
                    scanner.nextLine(); // Consume newline
                    String votedCandidate = scanner.nextLine();
                    if (candidates.containsKey(votedCandidate)) {
                        candidates.put(votedCandidate, candidates.get(votedCandidate) + 1);
                        System.out.println("Thank you for voting!");
                    } else {
                        System.out.println("Invalid candidate.");
                    }
                    break;
                case 2:
                    System.out.println("Election Results:");
                    for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
                    }
                    break;
                case 3:
                    System.out.println("Exiting the Online Voting System.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}