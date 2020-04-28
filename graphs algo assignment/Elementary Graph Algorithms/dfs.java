import java.util.*;
import java.io.*;

class graph
{
  public int nv;
  public int[] visited;
  public LinkedList<Integer> adj[];

  graph(int v)
  {
    nv = v;
    visited = new int[v];
    for(int i = 0; i<v ; i++)
    {
      visited[i] = 0;
    }
    adj = new LinkedList[v];
    for(int i = 0; i<v ; i++)
    {
      adj[i] = new LinkedList();
    }
  }

  public void addEdge(int v, int w)
  {
    adj[v].add(w);
  }

  public void DFS(int s)
  {
    
    visited[s] =1;
    System.out.print(s +", ");
    Iterator<Integer> i = adj[s].listIterator();
    while(i.hasNext())
    {
      int n = i.next();
      if(visited[n] == 0)
      {
        visited[n] = 1;
        DFS(n);
      }
    }
  }
}

public class dfs{
  public static void main(String[] args)
  {
    graph g = new graph(8);
    
	g.addEdge(0, 1);
    g.addEdge(1, 2);
    g.addEdge(1, 0);
    g.addEdge(2, 1);
    g.addEdge(2, 3);
    g.addEdge(3, 2);
    g.addEdge(3, 4);
    g.addEdge(3, 5);
    g.addEdge(4, 3);
    g.addEdge(4, 5);
    g.addEdge(4, 6);
    g.addEdge(5, 3);
    g.addEdge(5, 4);
    g.addEdge(5, 6);
    g.addEdge(5, 7);
    g.addEdge(6, 4);
    g.addEdge(6, 5);
    g.addEdge(6, 7);
    g.addEdge(7, 5);
    g.addEdge(7, 6);

    System.out.println("this is the depth first search starting from vertex 2: ");
    g.DFS(2);
  }
}
