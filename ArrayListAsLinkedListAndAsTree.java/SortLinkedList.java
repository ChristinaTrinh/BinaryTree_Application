import java.util.ArrayList;

public class SortLinkedList 
{
    public static void main(String[]args)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        addValuesIntoArrayList(list);
        ArrayList<LinkedListNode> sortedList = sort(list);
        print(sortedList);
    }

    public static void addValuesIntoArrayList(ArrayList<Integer> list)
    {
        list.add(7);
        list.add(2);
        list.add(16);
        list.add(11);
    }

    public static ArrayList<LinkedListNode> sort (ArrayList<Integer> list)
    {
        ArrayList<LinkedListNode> sortedList = new ArrayList<LinkedListNode>();
        for(int i = 0; i<list.size(); i++)
        {
            LinkedListNode node = helperSort(i, list);
            sortedList.add(node);
        }
        return sortedList;
    }

    public static LinkedListNode helperSort(int index, ArrayList<Integer> list)
    {
        int difference = -1;
        int nextIndex = -1;
        for(int i = 0; i<list.size(); i++)
        {
            if(i!=index && ((list.get(i) - list.get(index))>0 && (list.get(i) - list.get(index))<difference) ||
                           (difference == -1 && (list.get(i) - list.get(index))>0))
            {    
                nextIndex = i;
                difference = list.get(i) - list.get(index);
            }
        }
        return new LinkedListNode(list.get(index), nextIndex);
    }
    
    public static void print(ArrayList<LinkedListNode> sortedList)
    {
        System.out.print("myValue: ");
        for(LinkedListNode node : sortedList)
            System.out.print(node.getMyValue() + " ");
        System.out.println();
        System.out.print("myNext:  ");
        for(LinkedListNode node : sortedList)
            System.out.print(node.getMyNext()+ " ");
    }
}
