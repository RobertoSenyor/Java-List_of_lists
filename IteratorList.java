import java.io.Serializable;
import java.util.Vector;

public class IteratorList implements ForEach, Serializable
{
    private BigList outerList;
    private int current = 0;
    private Vector arr;

    public IteratorList(){};

    public IteratorList(BigList _obj)
    {
        arr = new Vector();

        int logical_pos=1;

        for (int i = 1; i <= _obj.get_count(); i++)
        {
            for (int j = 1; j <= _obj.get_on_position(i).get_count(); j++, logical_pos++)
            {
                arr.add(_obj.get_item_on_position(logical_pos));
            }
        }
        outerList = _obj;
    }

    @Override
    public boolean hasNext()
    {
        return (current != arr.size());
    }

    @Override
    public int get_num_of_item()
    {
        return current+1;
    }

    @Override
    public void refresh()
    {
        arr.clear();

        int logical_pos = 1;

        for (int i = 1; i <= outerList.get_count(); i++)
        {
            for (int j = 1; j <= outerList.get_on_position(i).get_count(); j++, logical_pos++)
            {
                arr.add(outerList.get_item_on_position(logical_pos));
            }
        }
    }

    @Override
    public Object toDo(Object value) // функция итератора (реализация метода интерфейса ForEach)
    {
        if(value!=null)
        {
            return value;
        }
        return null;
    }

    @Override
    public Object next()
    {
        Object buf = arr.get(current);
        current++;
        return toDo(buf);
    }

    @Override
    public void to_head() {

        if(outerList.get_head()==null)
            return;

        current = 0;
    }

    @Override
    public void to_tail()
    {
        if(outerList.get_head()==null)
            return;

        current = arr.size();
    }
}