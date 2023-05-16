package SortListVia2Trees_usingComparators;

import java.util.Comparator;

public class nameComparator implements Comparator<PersonNode>
{
    public int compare(PersonNode person1, PersonNode person2)
    {
        return person1.getFullName().compareTo(person2.getFullName());
    }
}
