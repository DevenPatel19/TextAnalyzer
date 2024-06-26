import java.util.*;

public class TextAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Text Analyzer Menu:");
                System.out.println("1. Enter a new text");
                System.out.println("2. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                if (choice == 1) {
                    // 1. User Input
                    System.out.println("Enter a paragraph or lengthy text:");
                    String inputText = scanner.nextLine();

                    // 2. Character Count
                    int charCount = inputText.length();
                    System.out.println("\nCharacter Count: " + charCount);

                    // 3. Word Count
                    String[] words = inputText.split("\\s+");
                    int wordCount = words.length;
                    System.out.println("Word Count: " + wordCount);

                    // 4. Most Common Character
                    char mostCommonChar = findMostCommonCharacter(inputText);
                    System.out.println("Most Common Character: " + mostCommonChar);

                    // 5. Character Frequency
                    System.out.println("\nEnter a character to find its frequency:");
                    String charInput = scanner.next().toLowerCase();
                    int charFrequency = findCharacterFrequency(inputText, charInput.charAt(0));
                    System.out.println("Frequency of '" + charInput + "' (case-insensitive): " + charFrequency);

                    // 6. Word Frequency
                    System.out.println("\nEnter a word to find its frequency:");
                    String wordInput = scanner.next().toLowerCase();
                    int wordFrequency = findWordFrequency(words, wordInput);
                    System.out.println("Frequency of \"" + wordInput + "\" (case-insensitive): " + wordFrequency);

                    // 7. Unique Words
                    Set<String> uniqueWords = new HashSet<>();
                    for (String word : words) {
                        uniqueWords.add(word.toLowerCase());
                    }
                    System.out.println("\nNumber of Unique Words (case-insensitive): " + uniqueWords.size());
                } else if (choice == 2) {
                    System.out.println("Exiting the program.");
                    break;
                } else {
                    System.out.println("Invalid option. Please choose 1 or 2.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    // Helper method to find the most common character in the text
    private static char findMostCommonCharacter(String text) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) { // consider only letters
                char lowercaseChar = Character.toLowerCase(c);
                charMap.put(lowercaseChar, charMap.getOrDefault(lowercaseChar, 0) + 1);
            }
        }

        int maxFrequency = 0;
        char mostCommonChar = ' ';
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mostCommonChar = entry.getKey();
            }
        }

        return mostCommonChar;
    }

    // Helper method to find the frequency of a specific character in the text
    private static int findCharacterFrequency(String text, char character) {
        int frequency = 0;
        for (char c : text.toCharArray()) {
            if (Character.toLowerCase(c) == Character.toLowerCase(character)) {
                frequency++;
            }
        }
        return frequency;
    }

    // Helper method to find the frequency of a specific word in the text
    private static int findWordFrequency(String[] words, String word) {
        int frequency = 0;
        for (String w : words) {
            if (w.equalsIgnoreCase(word)) {
                frequency++;
            }
        }
        return frequency;
    }
}
