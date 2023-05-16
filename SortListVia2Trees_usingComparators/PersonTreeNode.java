package SortListVia2Trees_usingComparators;
public class PersonTreeNode 
{
    private PersonNode person;
    private PersonTreeNode left;
    private PersonTreeNode right;

    public PersonTreeNode(PersonNode person)
    {
        this(person, null, null);
    }

    public PersonTreeNode(PersonNode person, PersonTreeNode left, PersonTreeNode right)
    {
        this.person = person;
        this.left = left;
        this.right = right;
    }

    public PersonNode getPerson()
    {
        return this.person;
    }

    public PersonTreeNode getLeft()
    {
        return this.left;
    }

    public PersonTreeNode getRight()
    {
        return this.right;
    }

    public void setValue(PersonNode person)
    {
        this.person = person;
    }

    public void setLeft(PersonTreeNode left)
    {
        this.left = left;
    }

    public void setRight(PersonTreeNode right)
    {
        this.right = right;
    }
}
