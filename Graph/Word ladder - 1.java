import java.util.*;

public class WordLadder {

    static class Pair {
        String word;
        int steps;

        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        boolean[] visited = new boolean[n];

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            String word = curr.word;
            int length = curr.steps;

            if (word.equals(endWord)) return length;

            for (int i = 0; i < n; i++) {
                if (!visited[i] && isOneCharDiff(word, wordList.get(i))) {
                    visited[i] = true;
                    queue.offer(new Pair(wordList.get(i), length + 1));
                }
            }
        }

        return 0;
    }

    private static boolean isOneCharDiff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList(
                "hot", "dot", "dog", "lot", "log", "cog"
        );

        System.out.println("Word Ladder Length: " +
                ladderLength(beginWord, endWord, wordList));
    }
}
