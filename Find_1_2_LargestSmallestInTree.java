import javax.swing.JOptionPane;
import java.util.*;

public class Find_1_2_LargestSmallestInTree
{
    static String treeValues = "";
  
    public static void main(String[]args)
    {
        TreeNode<Integer> root=null;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        ArrayList<Integer> smallestLargest_1_2_List = new ArrayList<Integer>(); // Hold 1st 2nd smallest & largest in here                                                      
	    getNumbers(nums);

        root = new TreeNode<Integer>(nums.get(0),null,null); // Set root with 1st value.
        for(int i=1; i<nums.size(); i++)  // Make rest tree with 1 value at a time.
            placeNodeInTree(root, new TreeNode<Integer>(nums.get(i),null,null));       

        find_1_2_LargestSmallest(root, smallestLargest_1_2_List);
	    gatherTreeValuesInOrder(root);  // put them into ‘treeValues’
        System.out.println(treeValues.substring(0, treeValues.length()-2));
        printResults(smallestLargest_1_2_List);
    } 									

    // Gather the values in each node into ‘treeValues’ via an InOrder tree traversal.
    public static void gatherTreeValuesInOrder(TreeNode<Integer> root) 
    {
        if(root != null) 
        {
		    gatherTreeValuesInOrder(root.getLeft());
		    treeValues += root.getData() + ", ";
		    gatherTreeValuesInOrder(root.getRight());
	    }
    }  

    public static void getNumbers(ArrayList<Integer> nums)
	{	
        nums.add(8);       
        nums.add(4); 
 	    nums.add(12);      
        nums.add(2); 
  		nums.add(6);       
        nums.add(10);  
  		nums.add(14);      
        //nums.add(1);  
  		nums.add(3);       
        nums.add(5);   
  		nums.add(7);       
        nums.add(9);   
 		nums.add(11);  
        nums.add(13);     
        //nums.add(15);   
	}

    // makes the tree
    public static void placeNodeInTree(TreeNode<Integer> root, TreeNode<Integer> add) 
    {  
        if(add.getData() < root.getData() && root.getLeft()==null)
            root.setLeft(add);
        else if(add.getData() < root.getData())
            placeNodeInTree(root.getLeft(), add);
        else if(add.getData() > root.getData() && root.getRight() == null)
            root.setRight(add);
        else if(add.getData() > root.getData())
            placeNodeInTree(root.getRight(), add);
    }

    // find the 1st and 2nd largest & smallest
    public static void find_1_2_LargestSmallest(TreeNode<Integer> root, ArrayList<Integer> smallestLargest_1_2_List)
    { 
        if(smallestLargest_1_2_List.size()==0)
        {
            smallestLargest_1_2_List.add(root.getData());
            smallestLargest_1_2_List.add(root.getData());
            smallestLargest_1_2_List.add(root.getData());
            smallestLargest_1_2_List.add(root.getData());
            find_1_2_LargestSmallest(root.getLeft(), smallestLargest_1_2_List);
            find_1_2_LargestSmallest(root.getRight(), smallestLargest_1_2_List);
        }
        else if(root!=null)
        {
            if(root.getData()<smallestLargest_1_2_List.get(0))
            {
                smallestLargest_1_2_List.set(1, smallestLargest_1_2_List.get(0));
                smallestLargest_1_2_List.set(0, root.getData());
                find_1_2_LargestSmallest(root.getLeft(), smallestLargest_1_2_List);
                find_1_2_LargestSmallest(root.getRight(), smallestLargest_1_2_List);
            }
            else if(root.getData()>smallestLargest_1_2_List.get(2))
            {
                smallestLargest_1_2_List.set(3, smallestLargest_1_2_List.get(2));
                smallestLargest_1_2_List.set(2, root.getData());
                find_1_2_LargestSmallest(root.getLeft(), smallestLargest_1_2_List);
                find_1_2_LargestSmallest(root.getRight(), smallestLargest_1_2_List);
            }
            else if(root.getData()<smallestLargest_1_2_List.get(1) && root.getData()>smallestLargest_1_2_List.get(0))
            {
                smallestLargest_1_2_List.set(1, root.getData());
                find_1_2_LargestSmallest(root.getLeft(), smallestLargest_1_2_List);
                find_1_2_LargestSmallest(root.getRight(), smallestLargest_1_2_List);
            }
            else if(root.getData()>smallestLargest_1_2_List.get(3) && root.getData()<smallestLargest_1_2_List.get(2))
            {
                smallestLargest_1_2_List.set(3, root.getData());
                find_1_2_LargestSmallest(root.getLeft(), smallestLargest_1_2_List);
                find_1_2_LargestSmallest(root.getRight(), smallestLargest_1_2_List);
            }
        }
    }
 
    // print out the results
    public static void printResults(ArrayList<Integer> smallestLargestList) 
    { 
        System.out.println("First smallest = " + smallestLargestList.get(0));
        System.out.println("Second smallest = " + smallestLargestList.get(1));
        System.out.println("First largest = " + smallestLargestList.get(2));
        System.out.println("Second largest = " + smallestLargestList.get(3));
    }
} 