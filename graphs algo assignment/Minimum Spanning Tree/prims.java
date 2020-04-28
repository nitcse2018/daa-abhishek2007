import java.util.*;
import java.lang.*;
import java.io.*;

class MST {
    private static final int V = 5;

    int minKey(int key[], int mstSet[])
    {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (mstSet[v] == 0 && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        return min_index;
    }

    void primsMST(int graph[][])
    {
        int parent[] = new int[V];

        int key[] = new int[V];

        int mstSet[] = new int[V];

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = 0;
        }

        key[0] = 0;
        parent[0] = -1; 

        for (int c = 0; c < V - 1; c++) {

            
            int u = minKey(key, mstSet);

            mstSet[u] = 1;

            for (int v = 0; v < V; v++)

                if (graph[u][v] != 0 && mstSet[v] == 0 && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }
		System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }
  }

public class prims{
	public static void main(String[] a)
    {
        
        MST t = new MST();
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                                      { 2, 0, 3, 8, 5 },
                                      { 0, 3, 0, 0, 7 },
                                      { 6, 8, 0, 0, 9 },
                                      { 0, 5, 7, 9, 0 } };
		t.primsMST(graph);
    }
}
