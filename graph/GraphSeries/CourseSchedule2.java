package graph.GraphSeries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {
    
     static int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];

        
        // Build graph
        for(int[] pre : prerequisites){

            int course = pre[0];
            int prereq = pre[1];

            graph.get(prereq).add(course);
            inDegree[course]++;
        }

          Queue<Integer> queue = new LinkedList<>();

        // Add nodes with indegree 0
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        while(!queue.isEmpty()){
            int node =  queue.poll();
            result[index++] = node;

            for(int neighbour : graph.get(node)){
                inDegree[neighbour]--;
            
                if(inDegree[neighbour] == 0){
                    queue.add(neighbour);
                }
            }
        }

        return result;

     }

    public static void main(String[] args) {
      int numCourses = 4;
      int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};

      System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));

    }
}
