import edu.princeton.cs.algs4.DijkstraSP;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.StdOut;

public class ShortestCycle {
    private int tip;
    private int tail;
    private int weight;

    public static void main(String[] args) {
        new ShortestCycle().run();
    }

    private void run() {
        In in = new In("SCTAN.txt");
        int n = in.readInt();  //# of graphs

        for(int i = 0; i<n; i++){
            solve(in);   //solve the whole data set once for each graph? I guess B/C the methods below only work one graph at a time its ok.
        }
    }

    private void solve(In in) {
        EdgeWeightedDigraph g = readGraph(in);
        DijkstraSP shortest = new DijkstraSP(g,tip);
        double length = shortest.distTo(tail) ;  //looks for the shortest distance from the tip to the tail
        if(length == Double.POSITIVE_INFINITY){  //if no path between the two exist
            StdOut.print("-1 ");
        }
        else {
            StdOut.print((int)length+weight+" ");
        }
    }

    private EdgeWeightedDigraph readGraph(In in) {
        int v = in.readInt();   //# of vertex
        int e = in.readInt();   //# of edges
        EdgeWeightedDigraph g = new EdgeWeightedDigraph(v + 1);
        tail = in.readInt();
        tip = in.readInt();
        weight = in.readInt();

        for(int i = 0; i <e-1; i++){
            g.addEdge(new DirectedEdge(in.readInt(),in.readInt(),in.readInt()));
        }
        return g;
    }
}
