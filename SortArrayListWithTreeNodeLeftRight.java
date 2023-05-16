import java.util.ArrayList;

import javax.lang.model.util.ElementScanner14;

public class SortArrayListWithTreeNodeLeftRight 
{
    public static void main(String[]args)
    {
        int[] numbers = {75, 50, 25, 100, 200, 300, 35, 150, 10, 20, 125};
        ArrayList<TreeNodeLeftRight> list = addNodeIntoArrayList(numbers);
        output1(list);
        output2(list, 0);
    }

    public static ArrayList<TreeNodeLeftRight> addNodeIntoArrayList(int[] numbers)
    {
        ArrayList<TreeNodeLeftRight> list = new ArrayList<TreeNodeLeftRight>();
        for(int i = 0; i < numbers.length; i++)
        {
            
            list.add(new TreeNodeLeftRight(numbers[i], -1, -1));
            int curr = 0;

            // it will only go into this loop if either left or right is not -1
            while((list.get(curr).getMyLeft() != -1 || list.get(curr).getMyRight() != -1))
            {
                // this is the case when the value we are on is less than the 'curr' (the one we compare with--from the root of the 'tree')
                // and it only go in if the left index is taken (there is a child for the tree node)
                if(list.get(i).getMyValue() < list.get(curr).getMyValue() && list.get(curr).getMyLeft() != -1)
                {
                    if(list.get(curr).getMyLeft() == -1) //if we found an available space then break out of the loop
                        break;
                    curr = list.get(curr).getMyLeft();
                }

                // this is the case when the value we are on is greater than the 'curr' (the one we compare with--from the root of the 'tree')
                // and it only go in if the right index is taken (there is a child for the tree node)
                else if(list.get(i).getMyValue() > list.get(curr).getMyValue() && list.get(curr).getMyRight() != -1)
                {
                    if(list.get(curr).getMyRight() == -1) //if we found an available space then break out of the loop
                        break;
                    curr = list.get(curr).getMyRight();
                }

                // this is the case when there is a direct available space to insert the value
                else
                    break;
            }
            if(list.get(i).getMyValue() < list.get(curr).getMyValue()) // for when the value is less than the value we are comparing with
                list.get(curr).setMyLeft(i);
            else if(list.get(i).getMyValue() > list.get(curr).getMyValue()) // for when the value is greater than the value we are comparing with
                list.get(curr).setMyRight(i);
            }
        return list;
    }

    public static void output1(ArrayList<TreeNodeLeftRight> list)
    {
        for(int i = 0; i < list.size(); i++)
        {
            System.out.print(list.get(i).getMyValue() + " ");
        }
        System.out.println();
        
        for(int i = 0; i < list.size(); i++)
        {
            System.out.print(list.get(i).getMyLeft() + " ");
        }
        System.out.println();

        for(int i =0; i < list.size(); i++)
        {
            System.out.print(list.get(i).getMyRight() + " ");
        }
        System.out.println();
    }

    public static void output2(ArrayList<TreeNodeLeftRight> list, int index)
    {
        if(index != -1)
        {
            output2(list, list.get(index).getMyLeft());
            System.out.print(list.get(index).getMyValue() + " ");
            output2(list, list.get(index).getMyRight());
        }
    } 
}
