package PRO.Lv3;


public class PRO_42861 {
  public static void main(String[] args) {
      Solution_42861 s = new Solution_42861();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    

import java.util.*;

class Solution_42861 {
    static List<Edge>[] graph;

    // 노드 구조 선언
    static class Edge implements Comparable<Edge> {
        int w;
        int cost;

        public Edge(int w, int cost) {
            this.w = w;
            this.cost = cost;
        }

        // 비교 기준 제시
        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }

    }
    
    // 최소 비용으로 모든 노드를 연결
    static public int solution(int n, int[][] costs) {
        int answer = 0;

        graph = new ArrayList[n+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 연결
        for (int i = 0; i < costs.length; i++) {
            int v = costs[i][0];
            int w = costs[i][1];
            int cost = costs[i][2];

            graph[v].add(new Edge(w, cost));
            graph[w].add(new Edge(v, cost));
        }

        // 프림 알고리즘 수행
        answer = prim(1, n);

        return answer;
    }

    // 프림 메서드
    static int prim(int start, int n) {
        boolean[] visited = new boolean[n+1];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        int total = 0;
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            int v = edge.w;
            int cost = edge.cost;

            if(visited[v]) continue;

            visited[v] = true;
            total += cost;

            for(Edge e : graph[v]) {
                if(!visited[e.w]) {
                    pq.add(e);
                }
            }
        }
        return total;
    }
}