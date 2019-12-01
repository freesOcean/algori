import java.util.LinkedList;

public class Graph{
    public int v;//顶点
    public LinkedList<Integer> []adj;//临链表

    public Graph(int v){
        this.v = v;
        adj = new LinkedList[v];

        for(int i=0;i<v;++i){
            adj[i] = new LinkedList<>();
        }

    }

    //增加一条s到t的边:无向图一条边存两次
    public void addEdge(int s,int t){
        adj[s].add(t);
        adj[t].add(s);
    }

}