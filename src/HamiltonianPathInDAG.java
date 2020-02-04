import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Topological;

public class HamiltonianPathInDAG {
    private static Digraph readGraph(In in) {
        int v = in.readInt();   //# of vertex
        int e = in.readInt();   //# of edges
        Digraph g = new Digraph(v);

        for (int i = 0; i < e; i++) {
            g.addEdge(in.readInt() - 1, in.readInt() - 1);
        }
        return g;
    }

    public static void main(String[] args) {
        String filename = "HPID.txt";
        In file = new In(filename);

        int nGraphs = file.readInt();
        for (int i = 0; i < nGraphs; i++) {
            //Node[] adjlist = MatrixReading.StdInAdjList(StdIn.readInt(), StdIn.readInt());
            PrintHamiltonianPath(readGraph(file));
        }
    }

    private static void PrintHamiltonianPath(Digraph g) {
        Topological path = new Topological(g);
        int len = g.V();
        if (path.hasOrder()) {

            int[] order = new int[len];
            int i = 0;
            for (Integer p : path.order()) {

                order[i] = p;
                //StdOut.print("o: "+order[i]);
                i++;
            }

            for (i = 0; i < len - 1; i++) {
                boolean flag = false;
                for (Integer k : g.adj(order[i])) {
                    if (k == order[i + 1]) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    StdOut.print("-1\n");
                    return;
                }
            }
            StdOut.print("1 ");
            for (int j = 0; j < len; j++) {
                StdOut.print((order[j] + 1) + " ");
            }
            StdOut.print("\n");
            return;
        }

        StdOut.print("-1");
    }
}
