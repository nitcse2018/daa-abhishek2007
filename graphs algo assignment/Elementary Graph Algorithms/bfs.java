import java.util.*;
import java.io.*;

class graph
{
  public int nv;
  public LinkedList<Integer> adj[];
  public int[] visited;

  graph(int v)
  {
    nv = v;
    adj = new LinkedList[v];
    for(int i = 0; i<v;i++)
    {
       adj[i] = new LinkedList();
    }
   visited = new int[v];
    for(int i = 0; i<4; i++)
    {
      visited[i] =0;
    }
  }

  void addEdge(int v, int w)
  {
    adj[v].add(w);
  }

  public void BFS(int s)
  {
    LinkedList<Integer> Q = new LinkedList<Integer>();
    visited[s] = 1;
    Q.add(s);
    while(Q.size() != 0)
    {
      s = Q.poll();
      System.out.println(s +", ");
      Iterator<Integer> i = adj[s].listIterator();
      while(i.hasNext())
      {
        int n = i.next();
        if(visited[n] == 0)
        {
          visited[n] = 1;
          Q.add(n);
        }
      }
    }

  }
}

public class bfs {

  public static void main(String[] args)
  {
	graph g = new graph(4);
	
	g.addEdge(0,1);
    g.addEdge(0,2);
    g.addEdge(0,3);
    g.addEdge(1,0);
    g.addEdge(1,2);
    g.addEdge(1,3);
    g.addEdge(2,0);
    g.addEdge(2,1);
    g.addEdge(2,3);
    g.addEdge(3,0);
    g.addEdge(3,1);
    g.addEdge(3,2);

    System.out.println("This is the breadth first search starting from vertex 1 : ");
    g.BFS(1);
  }
}
