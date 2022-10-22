import java.io.Serializable;
import java.util.ArrayList;

public class SmallList<T> extends BigList
{
    private int count;            // количество элементов списка
    private SmallListNode head = null; // первый элемент списка
    private SmallListNode tail = null; // последний элемент списка

    private class SmallListNode<T> implements Serializable
    {
        private T item;        // данные узла списка
        private SmallListNode next; // указатель на след. узел

        public SmallListNode(T _item, SmallListNode _next)
        {
            item = _item;
            next = _next;
        }

        public SmallListNode get_next()
        {
            return next;
        }

        public T get_value()
        {
            return (item != null) ? item : null;
        }

        public String get_type_value()
        {
            /*System.out.println(item.getClass().getSimpleName());*/
            return (item.getClass().getSimpleName());
        }

        public Object clone()
        {
            SmallListNode clone = this;
            return clone;
        }

        @Override
        public String toString()
        {
            return "SmallListNode<T>{" +
                    "item=" + item +
                    ", next=" + next +
                    "}";
        }
    };

    public SmallList() {}

    public SmallList(final SmallList _list)
    {
        push(_list);
    }

    @Override
    public void push(SmallList _item)
    {
        SmallListNode newnode = new SmallListNode(_item, null);

        if(tail == null)
        {
            head = newnode;
        }
        else
        {
            tail.next = newnode;
        }

        tail = newnode;
        count++;
    }

    @Override
    public void push(Object _item)
    {
        SmallListNode newnode = new SmallListNode(_item, null);

        if(tail == null)
        {
            head = newnode;
        }
        else
        {
            tail.next = newnode;
        }

        tail = newnode;
        count++;
    }

    @Override
    public void push_to_head(SmallList _item) {
        super.push_to_head(_item);
    }

    @Override
    public void push_to_head(Object _item)
    {
        SmallListNode newnode = new SmallListNode<>(_item, head);

        if(head==null)
        {
            tail = newnode;
        }

        head = newnode;
        count++;
    }

    @Override
    public T remove_item_from_head() {

        T buf_item = (T) head.get_value();

        if (count == 1)
        {
            System.err.println("SmallList (remove_on_position): your SmallList have only so lone element");
            System.err.println("Can u add another item in future?");
        }

        if(head != null)
        {
            head = head.next;
            count --;
            return buf_item;
        }
        else
        {
            System.out.println("Error: can't delete *HEAD* element");
            return null;
        }
    }

    @Override
    public SmallList remove_from_head()
    {
        return super.remove_from_head();
    }

    @Override
    public boolean insert_on_position(SmallList _item, int _pos) {
        return super.insert_on_position(_item, _pos);
    }

    @Override
    public boolean insert_item_on_position(Object _item, int logical_position)
    {
        SmallListNode prev = null;
        SmallListNode cur = head;

        if(logical_position == get_count() + 1)
        {
            push(_item);
            return true;
        }

        if(logical_position > get_count() || logical_position <= 0)
        {
            System.err.println("SmallList (insert_on_position): u write wrong position " + logical_position);
            System.err.println("Need 1-" + get_count());
            return false;
        }

        switch (logical_position)
        {
            case 1:
            {
                push_to_head(_item);
                return true;
            }
            default:
            {
                for (int buf_pos = 1; ; prev = cur, cur = cur.next, buf_pos++)
                {
                    if (buf_pos == logical_position)
                    {
                        SmallListNode newNode = new SmallListNode(_item, cur);
                        prev.next = newNode;
                        count++;
                        return true;
                    }
                }
            }
        }
    }

    @Override
    public SmallList remove_on_position(int _pos) {
        return super.remove_on_position(_pos);
    }

    @Override
    public T remove_item_on_position(int logical_position)
    {
        SmallListNode prev = null;
        SmallListNode cur = head;

        if(count==1)
        {
            System.err.println("SmallList (remove_on_position): your SmallList have only so lone element");
            System.err.println("Can u add another item in future?");
        }

        if(logical_position > get_count() || logical_position <= 0)
        {
            System.err.println("BigList (remove_on_position): u write wrong position " + logical_position);
            System.err.println("Need 1-" + get_count());
            return null;
        }

        T buf_cur = null;

        for (int buf_pos = 1 ; buf_pos <= count; prev = cur, cur = cur.next, buf_pos++)
        {
            if (buf_pos == logical_position)
            {
                if (cur == head)
                {
                    buf_cur = (T) cur.get_value();
                    remove_from_head();
                    break;
                }
                else
                {
                    buf_cur = (T) cur.get_value();
                    prev.next = cur.next;
                    cur = null;
                    count--;
                    break;
                }
            }
        }
        return buf_cur;
    }

    @Override
    public SmallList get_on_position(int _pos) {
        return super.get_on_position(_pos);
    }

    @Override
    public T get_item_on_position(int logical_position)
    {
        SmallListNode cur = head;

        if(logical_position > get_count() || logical_position <= 0)
        {
            System.err.println("SmallList (get_on_position): u write wrong position " + logical_position);
            System.err.println("Need 1-" + get_count());
        }

        for (int buf_pos = 1; cur.next != null; cur = cur.next, buf_pos++)
        {
            if (buf_pos == logical_position)
            {
                return (T) cur.get_value();
            }
        }
        return (T) cur.get_value();
    }

    @Override
    public void print_List() {
        super.print_List();
    }

    @Override
    public Object change_item_on_pos(Object _new_value, int logical_position)
    {
        SmallListNode cur = head;

        if(logical_position > get_count() || logical_position <= 0)
        {
            System.err.println("SmallList (get_on_position): u write wrong position " + logical_position);
            System.err.println("Need 1-" + get_count());
        }

        for (int buf_pos = 1; cur.next != null; cur = cur.next, buf_pos++)
        {
            if (buf_pos == logical_position)
            {
                remove_item_on_position(logical_position);
                insert_item_on_position(_new_value, logical_position);
                break;
            }
        }
        return cur.get_value();
    }

    @Override
    public int get_count()
    {
        return count;
    }

    @Override
    public ArrayList to_array()
    {
        ArrayList<Object> array = new ArrayList<>();

        if (head != null)
        {
            for (SmallListNode cur = head; cur != null; cur = cur.next)
            {
                array.add(cur.item);
            }
            return array;
        }
        else
        {
            return null;
        }
    }

    @Override
    public void export_serialize() {
        super.export_serialize();
    }

    @Override
    public void import_serialize() {
        super.import_serialize();
    }

    @Override
    public void remove_List() {
        super.remove_List();
    }
}
