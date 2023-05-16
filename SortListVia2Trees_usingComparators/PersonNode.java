package SortListVia2Trees_usingComparators;
public class PersonNode 
{
    private String lastName;
    private String firstName;
    private String middleName;
    private String idNum;

    public PersonNode(String lastName, String firstName, String middleName, String idNum)
    {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.idNum = idNum;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public String getMiddleName()
    {
        return this.middleName;
    }

    public String getFullName()
    {
        return this.lastName + " " + this.firstName + " " + this.middleName;
    }

    public String getIdNum()
    {
        return this.idNum;
    }

    public int getIdNumAsInt()
    {
        return Integer.valueOf(this.idNum.substring(0,3)+this.idNum.substring(4,6)+this.idNum.substring(7));
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    public void setIdNum(String idNum)
    {
        this.idNum = idNum;
    }

    
}
