package Collections.VotingSystem;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class VotingSystem {

    private Map<String, Integer> votesHashMap; // Candidate -> Votes
    private Map<String, Integer> votesLinkedHashMap; // To maintain insertion order of votes
    private Map<String, Integer> votesTreeMap; // To display results in sorted order by candidate name

    public VotingSystem() {
        votesHashMap = new HashMap<>();
        votesLinkedHashMap = new LinkedHashMap<>();
        votesTreeMap = new TreeMap<>();
    }

    // Cast a vote for a candidate
    public void castVote(String candidateName) {
        // Update HashMap
        votesHashMap.put(candidateName, votesHashMap.getOrDefault(candidateName, 0) + 1);

        // Update LinkedHashMap (maintains insertion order, so just put/update)
        votesLinkedHashMap.put(candidateName, votesLinkedHashMap.getOrDefault(candidateName, 0) + 1);

        // Update TreeMap (automatically sorts by key)
        votesTreeMap.put(candidateName, votesTreeMap.getOrDefault(candidateName, 0) + 1);

        System.out.println("Vote cast for: " + candidateName);
    }

    // Display current vote counts from HashMap
    public void displayVotesHashMap() {
        System.out.println("\n--- Current Votes (HashMap - Unordered) ---");
        if (votesHashMap.isEmpty()) {
            System.out.println("No votes cast yet.");
            return;
        }
        for (Map.Entry<String, Integer> entry : votesHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    // Display current vote counts from LinkedHashMap (maintains insertion order)
    public void displayVotesLinkedHashMap() {
        System.out.println("\n--- Current Votes (LinkedHashMap - Insertion Order) ---");
        if (votesLinkedHashMap.isEmpty()) {
            System.out.println("No votes cast yet.");
            return;
        }
        for (Map.Entry<String, Integer> entry : votesLinkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    // Display current vote counts from TreeMap (sorted by candidate name)
    public void displayVotesTreeMap() {
        System.out.println("\n--- Current Votes (TreeMap - Sorted by Candidate Name) ---");
        if (votesTreeMap.isEmpty()) {
            System.out.println("No votes cast yet.");
            return;
        }
        for (Map.Entry<String, Integer> entry : votesTreeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    // Get total votes for a specific candidate
    public int getVotesForCandidate(String candidateName) {
        return votesHashMap.getOrDefault(candidateName, 0);
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        System.out.println("--- Voting System Simulation ---");

        system.castVote("sohil");
        system.castVote("Raj");
        system.castVote("sohil");
        system.castVote("Tanuj");
        system.castVote("Raj");
        system.castVote("sohil");

        system.displayVotesHashMap();
        system.displayVotesLinkedHashMap();
        system.displayVotesTreeMap();

        System.out.println("\nTotal votes for sohil: " + system.getVotesForCandidate("sohil"));
        System.out.println("Total votes for Raj: " + system.getVotesForCandidate("Raj"));
        System.out.println("Total votes for Tanuj: " + system.getVotesForCandidate("Tanuj"));
        System.out.println("Total votes for nikhil: " + system.getVotesForCandidate("nikhil")); // Should be 0

        System.out.println("\n--- Casting more votes ---");
        system.castVote("nikhil");
        system.castVote("Sparsh");

        system.displayVotesHashMap();
        system.displayVotesLinkedHashMap();
        system.displayVotesTreeMap();
    }
}