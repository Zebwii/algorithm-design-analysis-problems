import edu.princeton.cs.algs4.BellmanFordSP;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;

import java.util.Arrays;

public class NegativeWeightCycle
{
    public static void main(String[] args)
    {
        int n = StdIn.readInt();

        for (int i = 0; i < n; i++)
        {
            StdOut.print(HasNegativeWeightCycle(MatrixReading.StdInReadWDIG())? "1 ": "-1 ");
        }
    }


    private static boolean HasNegativeWeightCycle(EdgeWeightedDigraph g)
    {
        for (int i = 0; i < g.V(); i++)
        {
            BellmanFordSP sp = new BellmanFordSP(g,i);
            if(sp.hasNegativeCycle()) return true;
        }
        return false;

//        int V = g.V();
//
//        for (int i = 0; i < V; i++)
//        {
//            double[] distance = new double[V];
//            Arrays.fill(distance, Double.POSITIVE_INFINITY);
//            distance[i] = 0;
//
//            for (int n = 0; n < V-1; n++)
//            {
//                for (DirectedEdge e: g.edges())
//                {
//                    int u = e.from();
//                    int v = e.to();
//                    double w = e.weight();
//                    if (distance[u] != Double.POSITIVE_INFINITY && distance[u] + w < distance[v])
//                        distance[v] = distance[u] + w;
//                }
//            }
//            for (DirectedEdge e: g.edges())
//            {
//                int u = e.from();
//                int v = e.to();
//                double w = e.weight();
//                if (distance[u] + w < distance[v])
//                {
//                    return true;
//                }
//            }
//
//        }
//        return false;
//
    }
}
