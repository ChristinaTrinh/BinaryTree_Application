package SortListVia2Trees_usingComparators;

import java.util.Comparator;

public class idComparator implements Comparator<PersonNode>
{
    public int compare(PersonNode person1, PersonNode person2)
    {
        return person1.getIdNumAsInt() - person2.getIdNumAsInt();
    }
}
