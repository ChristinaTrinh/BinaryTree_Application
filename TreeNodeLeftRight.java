public class TreeNodeLeftRight 
{
    private int myValue;
    private int myLeft;
    private int myRight;

    public TreeNodeLeftRight(int myValue)
    {
        this(myValue, -1, -1);
    }

    public TreeNodeLeftRight(int myValue, int myLeft, int myRight)
    {
        this.myValue = myValue;
        this.myLeft = myLeft;
        this.myRight = myRight;
    }

    public int getMyValue()
    {
        return myValue;
    }
    
    public int getMyLeft()
    {
        return myLeft;
    }

    public int getMyRight()
    {
        return myRight;
    }

    public void setMyValue(int myValue)
    {
        this.myValue = myValue;
    }

    public void setMyLeft(int myLeft)
    {
        this.myLeft = myLeft;
    }

    public void setMyRight(int myRight)
    {
        this.myRight = myRight;
    }
}
