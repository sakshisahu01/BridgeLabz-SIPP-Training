public class LinearSearchSentence {

    public static String findSentenceWithWord(String[] sentences, String wordToFind) {
        for (String sentence : sentences) {
            if (sentence.contains(wordToFind)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
                "The quick brown fox jumps over the lazy dog.",
                "A journey of a thousand miles begins with a single step.",
                "To be or not to be, that is the question.",
                "The early bird catches the worm.",
                "Innovation distinguishes between a leader and a follower."
        };

        String word1 = "lazy";
        System.out.println("Searching for '" + word1 + "': " + findSentenceWithWord(sentences, word1));

        String word2 = "cat";
        System.out.println("Searching for '" + word2 + "': " + findSentenceWithWord(sentences, word2));

        String word3 = "question";
        System.out.println("Searching for '" + word3 + "': " + findSentenceWithWord(sentences, word3));

        String word4 = "java";
        System.out.println("Searching for '" + word4 + "': " + findSentenceWithWord(sentences, word4));
    }
}