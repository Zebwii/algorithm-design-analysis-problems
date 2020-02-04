public class PartialSort
{
    public static void main(String[] args)
    {
        int len = StdIn.readInt();
        int[] arry = new int[len];

        for (int i = 0; i < len; i++)
            arry[i] = StdIn.readInt();

        int k = StdIn.readInt();
        for (int i = 0; i < k; i++)
        {
            int min = 0;
            for (int j = 0; j < len; j++)
            {
                if(arry[j] < arry[min])
                {
                    min = j;
                }
            }
            StdOut.print(arry[min]+" ");
            arry[min] = Integer.MAX_VALUE;
        }
    }

}
