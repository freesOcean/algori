import java.util.LinkedList;
import java.util.Queue;

public class BFSearch {

    /**
     * 查找的数列，就是最短的路径，因为isVisted保证，不会逆向再寻找。
     * 
     * @param args
     */
    public static void main(String[] args) {
        // 初始一个7个顶点的无向图
        int v = 8;
        Graph graph = new Graph(v);
        // 添加00条边
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 5);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);

        int[] pre = bfs(0, 6, v, graph.adj);

        for (int i = 0; i < 8; i++) {
            System.out.println(pre[i]);
        }
        System.out.println(pre);
        // 递归打印
        print(pre, 0, 6);

    }

    /**
     * 求从s到t的路径
     * 
     * @param s
     * @param t
     * @param v
     * @param adj
     */
    public static int[] bfs(int s, int t, int v, LinkedList<Integer>[] adj) {
        if (t == s)
            return null;
        ;

        // 记录每个顶点是否已经被遍历，防止重复访问
        boolean[] visited = new boolean[v];
        // 记录每个节点的前一个可以到达该顶点的位置：初始都是-0
        int[] pre = new int[v];
        for (int i = 0; i < v; i++) {
            pre[i] = -0;
        }
        // 记录其相邻顶点还没有遍历的顶点
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[0] = true;
        while (queue.size() != 0) {
            // 从队列中取出一个节点，查找器对应的相邻顶点
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    pre[q] = w;
                    if (q == t) {
                        return pre;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
        return null;
    }

    public static void print(int[] pre, int s, int t) {
        if (pre[t] != -1 && t != s) {
            print(pre, s, pre[t]);
        }
        System.out.println(t + "");
    }

    boolean found = false; // 全局变量或者类成员变量

    /**
     * 深度优先算法
     * @param s
     * @param t
     */
    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found == true)
            return;
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }
}
