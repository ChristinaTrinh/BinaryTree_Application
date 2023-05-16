public class LinkedListNode 
{
    private int myValue;
    private int myNext;

    public LinkedListNode(int myValue)
    {
        this(myValue, -1);
    }

    public LinkedListNode(int myValue, int myNext)
    {
        this.myValue = myValue;
        this.myNext = myNext;
    }
    
    public int getMyValue()
    {
        return this.myValue;
    }

    public int getMyNext()
    {
        return this.myNext;
    }

    public void setMyValue(int myValue)
    {
        this.myValue = myValue;
    }

    public void setMyNext(int myNext)
    {
        this.myNext = myNext;
    }
}
