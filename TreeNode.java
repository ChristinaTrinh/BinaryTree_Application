public class TreeNode <E>
{
    private E data;
    private TreeNode<E> left;
    private TreeNode<E> right;

    public TreeNode(E data)
    {
        this(data, null, null);
    }

    public TreeNode(E data, TreeNode<E> left, TreeNode<E> right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public E getData()
    {
        return this.data;
    }

    public TreeNode<E> getLeft()
    {
        return this.left;
    }

    public TreeNode<E> getRight()
    {
        return this.right;
    }

    public void setData(E data)
    {
        this.data = data;
    }

    public void setLeft(TreeNode<E> left)
    {
        this.left = left;
    }

    public void setRight(TreeNode<E> right)
    {
        this.right = right;
    }
}