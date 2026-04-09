package graph.GraphSeries;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    static class Pair {
        String word;
        int steps;

        Pair(String word , int steps){
            this.word = word;
            this.steps = steps;
        }
    }

    static int getLadderCount(String beginWord , String endWord , List<String> wordList){
        
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)){
            return 0;
        }

        Queue<Pair>  q = new LinkedList<>();
        
        q.add(new Pair(beginWord, 1));

        while(!q.isEmpty()) {
            Pair curr = q.poll();
            String word = curr.word;
            int step = curr.steps;

            for(int i = 0 ; i < word.length() ; i++){

                char[] charArray =  word.toCharArray();

                for(char ch = 'a' ; ch <= 'z' ; ch++){

                    charArray[i] = ch;

                    String transformed = new String(charArray);

                    if(set.contains(transformed)){
                          if(transformed.equals(endWord)){
                                return step + 1; 
                            }
                        q.add(new Pair(transformed , step+1));
                        set.remove(transformed);
                    }
                }
            }

        }
        return 0;
    }
    

    public static void main(String[] args) {
         String beginWord = "hit";
    String endWord = "cog";
    List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

    int result = getLadderCount(beginWord, endWord, wordList);
    System.out.println("Shortest transformation length: " + result);
    }
}
