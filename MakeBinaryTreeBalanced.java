import java.util.*;

public class MakeBinaryTreeBalanced
{
    static int treeValues[] = {50,40,60,30,70,105,20,80,35,5,10,90,100,110,65};
    static TreeNode<Integer> root= null;

    // 'odd' variable is being used in makeBalancedTree method to initially check if the list is odd or even
    // a perfect tree is detected if the list has odd total length (all branches have two children)
    // a nonperfect tree is detected if the list has even total length (one of the branches has only 1 child)
    static boolean odd = true; 

    public static void main(String[]args)
    {    
        System.out.println("\t UnBalanced: ");
        makeTree();       
        printTreeSideWays(root, 1);
        System.out.println("\n\n\n");
        
        Arrays.sort(treeValues);
        
        System.out.println("\t Balanced: ");  
        if(treeValues.length%2==0) //initially check if the list is odd or even
            odd = false;
        root = null;      
        makeBalancedTree(0, treeValues.length-1);
        printTreeSideWays(root, 1);
    }
    
    public static void makeTree()
    {
        for (int i=0; i<treeValues.length; i++)
        {
            root = addNode(root, treeValues[i]);
        }   
    }

    public static TreeNode<Integer> addNode(TreeNode<Integer> root, int k)   
    {
        if (root==null)
            root = new TreeNode<Integer>(k);
        else if (k<root.getData())
            root.setLeft(addNode(root.getLeft(), k));
        else
            root.setRight(addNode(root.getRight(), k));            
        return root;
    }

    public static void makeBalancedTree(int low, int high)
    {
        boolean oddMethod; // this 'odd' variable is local which is different than the global 'odd'
        if((high-low)%2==0)
            oddMethod = true;
        else
            oddMethod = false;

        if(low<treeValues.length && high>=0)
        {
            if(!odd) //only when the total length from low to high is even
            {
                // my algorithm prioritize the left subtree
                // which means that the left side will be full, leaving the right side lack of 1 child 
                // this case happends when the total number in the list is even
                int index = low+((high-low)/2+1);
                odd = true; // set the global odd to true because we want to recursively fill the left side first
                            // since I prioritize the left side, it has odd length
                root = addNode(root, treeValues[index]);
                makeBalancedTree(index-((high-low)/2+1), index-1);
                odd = false; //after filling the left side, we set the global odd to false again 
                             //because the right side still has even length
                makeBalancedTree(index+1, index+(high-low)/2);
            }
            else if(oddMethod) //only when the total length from low to high is odd
            {
                int index = low+(high-low)/2;
                root = addNode(root, treeValues[index]);
                makeBalancedTree(index-(high-low)/2, index-1);
                makeBalancedTree(index+1, index+(high-low)/2);
            }
        }
    }
    
    // postCondition: prints in reversed preorder the tree with given
    // root, indenting each line to the given level
    private static void printTreeSideWays(TreeNode<Integer> root, int level) 
    {
        if (root != null) 
        {
            printTreeSideWays(root.getRight(), level + 1);
            for (int i = 0; i < level; i++)
                System.out.print(" \t");
            System.out.println(root.getData());
            printTreeSideWays(root.getLeft(), level + 1);
        }
    }    
} 
