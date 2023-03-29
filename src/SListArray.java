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
        int size = 0;
        for (int i=0; i<this._elements.length; i++) {
            if (this._elements[i] != null) {
                size++;
            }
        }
        return size;
    }

    private String[] copy(int new_size, String[] elements) {
        String[] new_elements = new String[new_size];
        for (int i=0; i<elements.length; i++) {
            new_elements[i] = elements[i];
        }
        return new_elements;
    }

    public String get(int position) {
        if (position < 0 || position > this._elements.length-1) {
            return INDEX_OUT_OF_RANGE;
        }
        return this._elements[position];
    }

    public String set(int position, String element) {
        if (position < 0 || position > this._elements.length-1) {
            return INDEX_OUT_OF_RANGE;
        }
        String old_element = this._elements[position];
        this._elements[position] = element;
        return old_element;
    }

    public String add(int position, String element)
    {
        if(position < 0 || position > this._elements.length-1)
            return INDEX_OUT_OF_RANGE;
        if (this._elements[this._elements.length-1] != null)
            this._elements = copy((this._elements.length)*2, this._elements);
        for (int i=position+1; i<this._elements.length-1; i++)
            this._elements[i+1] = this._elements[i];
        this._elements[position] = element;
        return INDEX_OK;
    }
    public String remove(int position) {
        if(position < 0 || position > this._elements.length-1)
            return INDEX_OUT_OF_RANGE;
        for (int i = this._elements.length-1; i>position; i--)
            this._elements[i-1] = this._elements[i];
        return INDEX_OK;
    }

    public void append(SList anotherSList)
    {
        int new_size = (anotherSList.size() + this.size()) * 2;
        String[] new_elements = new String[new_size];
        for (int i=0; i<this.size(); i++) {
            new_elements[i] = this._elements[i];
        }
        for (int i=this.size(); i<(anotherSList.size()+this.size()); i++) {
            new_elements[i] = anotherSList.get(i-this.size());
        }
        this._elements = new_elements;
    }
    public SList commonStrings()
    {
        HashMap<String, Integer> dict = new HashMap<>();
        for (int i=0; i<this._elements.length; i++) {
            if (dict.containsKey(this._elements[i])) {
                dict.put(this._elements[i], dict.get(this._elements[i] + 1));
            }
            else {
                dict.put(this._elements[i], 1);
            }
        }

        int highest_frequency = 0;
        for (int value: dict.values()) {
            if (value > highest_frequency)
                highest_frequency = value;
        }

        SListArray commonWords = new SListArray();
        for (String s: dict.keySet()) {
            if (dict.get(s) == highest_frequency) {
                commonWords.add(commonWords.size()-1, s);
            }
        }
        return commonWords;
    }

    public SList[] commonStrings(int n) {
        HashMap<String, Integer> dict = new HashMap<>();
        for (int i=0; i<this._elements.length; i++) {
            if (dict.containsKey(this._elements[i])) {
                dict.put(this._elements[i], dict.get(this._elements[i] + 1));
            }
            else {
                dict.put(this._elements[i], 1);
            }
        }

        ArrayList<Integer> frequencies = new ArrayList<>(dict.values());
        Collections.sort(frequencies);
        Collections.reverse(frequencies);

        SListArray[] commonWords = new SListArray[n];
        int freq = 0;
        for (int i=0; i<n; i++) {
            freq = frequencies.get(i);
            // loop through the dictionary to look for the key that matches this value
            for (String s: dict.keySet()) {
                if (dict.get(s) == freq) {
                    commonWords[i].add(commonWords[i].size()-1, s);
                }
            }
        }
        return commonWords;
    }
}