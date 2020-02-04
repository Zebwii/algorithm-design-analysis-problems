import java.util.Stack;

public class SquareInAGraph
{
    public static void main(String[] args)
    {
        String path = "SIAGprob.txt";
        In infile = new In(path);

        int n_graphs = infile.readInt();
        boolean[] answers = new boolean[n_graphs];

        for (int i = 0; i < n_graphs; i++)
            answers[i] = HasCycle(ReadMatrix(infile));
        for (int i = 0; i < n_graphs; i++)
            System.out.print(answers[i] ? "1 " : "-1 ");
    }


    private static boolean[][] ReadMatrix(In infile)
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

    private static boolean HasCycleRecursive(boolean[][] matrix, boolean[] visited, int v, int parent, int count)
    {
        visited[v] = true;
        for (int i = 0; i < matrix.length; i++)
        {
            if(matrix[v][i])
            {
                if (!visited[i])
                {
                    if (HasCycleRecursive(matrix, visited, i, v, count+1))
                    {
                        return true;
                    }
                }
                else if (i != parent && count == 3) return true;
            }
        }
        return false;
    }

    private static boolean HasCycle(boolean[][] matrix)
    {
        boolean[] visited = new boolean[matrix.length];
        for (int i = 0; i < matrix.length; i++)
        {
            if (!visited[i] && HasCycleRecursive(matrix, visited, i,-1,0))
            {
                return true;
            }

        }
        return false;
    }
}

