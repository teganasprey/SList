import java.util.Arrays;
import java.util.LinkedList;
public class SListArray extends SList{

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
            myList[i].set(i,elements[i]);
    }
    public SList commonStrings()
    {

    }
    public void append(SList anotherSList)
    {
        int newSize=(anotherSList.size()+this.size())*2;
        SListArray myList= new SListArray;
        for (int i=0;i<this.size();i++)
            myList.set(i,this.get(i));
        for (int i=this.size();i<(anotherSList.size()+this.size());i++)
            myList.set(i,anotherSList.get(i));

    }

    public String add(int position, String element)
    {
        if(position<0||position>this.size())
            return "Index out of bounds";
        if (this.get(this.size()-1)!=null)
        {
            SListArray myList = new SListArray;
            for (int i=0;i<)
        }


            
    }
}