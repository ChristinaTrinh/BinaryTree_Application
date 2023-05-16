package SortListVia2Trees_usingComparators;

import java.util.ArrayList;
import java.util.Collections;

public class Client 
{
    static PersonTreeNode nameTreeSort = null;
    static PersonTreeNode idNumTreeSort = null;
    public static void main(String[]args)
    {
        ArrayList<PersonNode> list = new ArrayList<PersonNode>();
        addNodeIntoList(list);
        makeTree(list);
        System.out.println("Sort by full name: ");
        printInorderTraversal(nameTreeSort);
        System.out.println();
        System.out.println("Sort by idNum: ");
        printInorderTraversal(idNumTreeSort);
    }
    
    public static void addNodeIntoList(ArrayList<PersonNode> list)
    {
        list.add(new PersonNode("Marques", "Paul", "The-Great", "123-45-678"));
 	    list.add(new PersonNode("Kent", "Clark", "Kriptonite", "932-00-918"));
	    list.add(new PersonNode("Luthor", "Lex", "King-of-Evil", "632-95-174"));
	    list.add(new PersonNode("Lane", "Lois", "Lipstick", "390-29-4945"));
	    list.add(new PersonNode("Bunny", "Bugs", "Hoppy", "383-92-484"));
	    list.add(new PersonNode("Duck", "Daffy", "Dippy", "395-10-573"));
	    list.add(new PersonNode("Flintstone", "Fred", "RockHead", "592-96-285"));
	    list.add(new PersonNode("Ruble", "Barney", "ShortStone", "116-30-590"));
	    list.add(new PersonNode("Flintstone", "Wilma", "Mary", "883-95-499"));
	    list.add(new PersonNode("Ruble", "Betty", "Boop", "501-57-295"));
	    list.add(new PersonNode("Man", "Pac", "Hungry", "492-95-100"));
	    list.add(new PersonNode("Invader", "Space", "1980sVideoGame", "385-10-395"));
	    list.add(new PersonNode("Bert", "Q", "-", "385-19-305"));
    }

    public static void makeTree(ArrayList<PersonNode> list)
    {
        for(PersonNode person : list)
        {
            nameTreeSort = putNamesIntoTree(nameTreeSort, person, new nameComparator());
            idNumTreeSort = putIdNumsIntoTree(idNumTreeSort, person, new idComparator());
        }
    }

    public static PersonTreeNode putNamesIntoTree(PersonTreeNode root, PersonNode person, nameComparator nameCom)
    {
        if(root == null)
            return new PersonTreeNode(person, null, null);
        else if(nameCom.compare(person, root.getPerson()) < 0)
            root.setLeft(putNamesIntoTree(root.getLeft(), person, new nameComparator()));
        else 
            root.setRight(putNamesIntoTree(root.getRight(), person, new nameComparator()));
        return root;
    }

    public static PersonTreeNode putIdNumsIntoTree(PersonTreeNode root, PersonNode person, idComparator idCom)
    {
        if(root == null)
            return new PersonTreeNode(person, null, null);
        else if(idCom.compare(person, root.getPerson()) < 0)
            root.setLeft(putIdNumsIntoTree(root.getLeft(), person, idCom));
        else 
            root.setRight(putIdNumsIntoTree(root.getRight(), person, idCom));
        return root;
    }

    public static void printInorderTraversal(PersonTreeNode root)
    {
        if(root != null)
        {
            printInorderTraversal(root.getLeft());
            System.out.println(root.getPerson().getFullName()+", " + root.getPerson().getIdNum());
            printInorderTraversal(root.getRight());
        }
    }
}
