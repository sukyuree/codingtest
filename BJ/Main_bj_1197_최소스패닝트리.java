import java.io.*;
import java.util.*;

public class Main_bj_1197_최소스패닝트리 {
  static int V,E;
  static int[][] edges;
  static int[] p;

  static void make(){
    p = new int[V+1];
    for(int i = 1; i <= V; i++) p[i] = i;
  }

  static int find(int a){
    if(p[a]==a) return a;
    return p[a] = find(p[a]);
  }

  static boolean union(int a, int b){
    int aRoot = find(a);
    int bRoot = find(b);
    if(aRoot == bRoot) return false;
    p[bRoot] = aRoot;
    return true;
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    edges = new int[E][3];

    for(int i = 1; i <= E; i++){
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      edges[i-1] = new int[]{from,to,weight};
    }

    Arrays.sort(edges,(e1,e2)->e1[2]-e2[2]);
    make();
    int result = 0;
    int cnt = 0;

    for(int[] nodes : edges){
      if(union(nodes[0],nodes[1])){
        result += nodes[2];
        if(++cnt==V) break;
      }
    }
    System.out.print(result);
  }
}
