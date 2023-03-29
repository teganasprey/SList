import java.util.Arrays;
import java.util.LinkedList;

public class SListArray extends SList{

    private String[] _elements;

    public SListArray()
    {
        this._elements = new String[8];
    }

    public SListArray(String[] elements)
    {
        this._elements = new String[elements.length * 2];
        for (int i=0; i<elements.length; i++) {
            this._elements[i] = elements[i];
        }
    }

    public int size() {
        return this._elements.length;
    }

    private String[] copy(int new_size, String[] elements) {
        String[] new_elements = new String[new_size];
        for (int i=0; i<elements.length; i++) {
            new_elements[i] = elements[i];
        }
        return new_elements;
    }

    public String get(int position) {
        return this._elements[position];
    }

    public String set(int position, String element) {
        String old_element = this._elements[position];
        this._elements[position] = element;
        return old_element;
    }

    public String add(int position, String element)
    {
        if(position<0||position>this.size())
            return "Index out of bounds";
        if (this.get(this.size()-1)!=null)
        {
            SListArray myList = new SListArray();
            for (int i=0;i<index-1; i++)
                myList.set(i,this.get(i));

        }
    }

    public String remove(int position) {

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

    public SList commonStrings()
    {

    }

    public SList[] commonStrings(int n) {

    }
}