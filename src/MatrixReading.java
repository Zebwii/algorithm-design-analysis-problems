import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;

import java.util.Arrays;

class MatrixReading
{
    static Node[] StdInAdjList(int nodes, int edges)
    {
        Node[] nodearr = new Node[nodes];

        for (int i = 0; i < edges; i++)
        {
            int from = StdIn.readInt()-1,
                to = StdIn.readInt()-1;

            Node newn = new Node(null, to);

            if (nodearr[from] == null) nodearr[from] = newn;
            else
            {
                newn.next = nodearr[from];
                nodearr[from] = newn;
            }
        }
        return nodearr;
    }

    public static void printAdjList(Node[] list)
    {
        for (int i = 0; i < list.length; i++)
        {
            Node trav = list[i];
            StdOut.print("\n "+i+": ");
            while (trav != null)
            {
                StdOut.print(trav.value+", ");
                trav = trav.next;
            }
            StdOut.print("\n");
        }
    }

    public static void PrintWG(int[][] matrix)
    {
        StdOut.println();
        int len = matrix.length;
        for (int i = 0; i < len; i++)
        {
            for (int j = 0; j < len; j++)
            {
                StdOut.printf("%3d ",matrix[i][j]);
            }
            StdOut.println();
        }
        StdOut.println();
    }

    public static EdgeWeightedDigraph StdInReadWDIG()
    {
        int nodes = StdIn.readInt();
        int edges = StdIn.readInt();
        EdgeWeightedDigraph matrix = new EdgeWeightedDigraph(nodes);

        for (int j = 0; j < edges; j++)
            matrix.addEdge(new DirectedEdge(StdIn.readInt()-1,StdIn.readInt()-1,StdIn.readInt()));

        return matrix;
    }

    public static Digraph StdInReadDG()
    {
        Digraph matrix = new Digraph(StdIn.readInt());
        int edges = StdIn.readInt();

        for (int j = 0; j < edges; j++)
            matrix.addEdge(StdIn.readInt()-1,StdIn.readInt()-1);
        return matrix;
    }


    public static int[][] StdInReadWDG()
    {
        int nodes = StdIn.readInt();
        int edges = StdIn.readInt();
        int[][] matrix = new int[nodes][nodes];
        for(int[] row: matrix)
            Arrays.fill(row, Integer.MAX_VALUE);

        for (int j = 0; j < edges; j++)
            matrix[StdIn.readInt()-1][StdIn.readInt()-1] = StdIn.readInt();

        return matrix;
    }

    public static boolean[][] ReadMatrix(In infile)
    {
        int nodes = infile.readInt();
        int edges = infile.readInt();
        boolean[][] matrix = new boolean[nodes][nodes];

        for (int j = 0; j < edges; j++)
        {
            int v1 = infile.readInt()-1;
            int v2 = infile.readInt()-1;
            matrix[v1][v2] = matrix[v2][v1] = true;
        }
        return matrix;
    }

}
