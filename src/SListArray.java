import java.util.Arrays;
import java.util.LinkedList;
public abstract class SListArray extends SList{

    public SListArray()
    {
        SList[] myList = new SList[8];
        //  myList = new SList[(myList.length*2)];
    }
    // creates an empty list
    public SListArray(String[] elements)
    {
        SList[] myList = new SList[elements.length];
        for (int i=0;i<elements.length;i++)
        {
            myList[i].set(i,elements[i]);
        }
    }
    public SList commonStrings()
    {

    }
    public void append(SList anotherSList)
    {


    }

    public String add(int position, String element)
    {

    }

// creates a list with the strings in elements
// the ordering and size of this list will be the same as in elements
}