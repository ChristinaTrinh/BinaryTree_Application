public class Sort2DArrayViaIndexPointers{
    public static void main(String[]args){
        int valuesArray[][] = {{25,35,30,40,10,37,26,32,5,50},
                     {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}};
        int head = -1;
        System.out.println("head = " + head);
        print(valuesArray);

        head = sort(valuesArray);
        System.out.println("head = " + head);
        print(valuesArray);
    }

    public static void print(int[][] valuesArray)
    {
        for(int row = 0; row < valuesArray.length; row++)
        {
            System.out.print(valuesArray[row][0]);
            for(int col = 1; col < valuesArray[row].length; col++)
                System.out.print(", " + valuesArray[row][col]);
            System.out.println();
        }
    }

    public static int sort(int[][] valuesArray)
    {
        int head = 0;
        for (int i = 1; i < valuesArray[0].length; i++){
            if (valuesArray[0][i]<valuesArray[0][head])
            {
                valuesArray[1][i]=head;
                head = i;
            } 
            else 
            {
                int prev = head; 
                int current = valuesArray[1][head];
                while (current!=-1)
                {
                    if (valuesArray[0][prev]<valuesArray[0][i] && valuesArray[0][current]>valuesArray[0][i])
                        break;
                    prev = current;
                    current = valuesArray[1][current];
                }
                valuesArray[1][prev]=i;
                valuesArray[1][i]=current;
            }
        }
        return head;
    }
}