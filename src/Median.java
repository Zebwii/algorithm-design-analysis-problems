import java.util.Arrays;

public class Median
{
    public static void main(String[] args)
    {
        int len = StdIn.readInt();
        int[] arry = new int[len];
        for (int i = 0; i < len; i++)
        {
            arry[i] = StdIn.readInt();
        }

        Arrays.sort(arry);
        StdOut.println(arry[StdIn.readInt()-1]);
    }
}
