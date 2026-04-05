package graph.GraphSeries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDictionary {


    static String alienDictionary(String[] words){

        Map<Character , List<Character>> adj = new HashMap<>();
         Map<Character , Integer> inDegree = new HashMap<>();

        for(String word : words){
            for(char c : word.toCharArray()){
                adj.putIfAbsent(c, new ArrayList<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

           for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());

           
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    inDegree.merge(w2.charAt(j), 1, Integer::sum);
                    break; 
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        for(char c :inDegree.keySet()){
            if(inDegree.get(c) == 0){
                q.offer(c);
            }
        }    


        StringBuilder result = new StringBuilder();
        while (!q.isEmpty()) {
          char c = q.poll();
            result.append(c);

            for (char neighbor : adj.get(c)) {
                inDegree.merge(neighbor, -1, Integer::sum);
                if (inDegree.get(neighbor) == 0) {
                    q.offer(neighbor);
                }
            }
        }

         if (result.length() != inDegree.size()) return "";

        return result.toString();
    }
    

    public static void main(String[] args) {
        String[] words1 = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(alienDictionary(words1)); // "wertf"
    }
}
