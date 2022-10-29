import java.io.*;
import java.util.Vector;
import java.util.ArrayList;

public class BigList<T> implements Serializable
{
    private int count;            // количество элементов списка
    private BigListNode head = null; // первый элемент списка
    private BigListNode tail = null; // последний элемент списка

    public BigListNode get_head()
    {
        return head;
    }

    class BigListNode implements Serializable
    {
        private SmallList item;        // данные узла списка
        private BigListNode next; // указатель на след. узел

        public BigListNode(SmallList _item, BigListNode _next)
        {
            item = _item;
            next = _next;
        }

        public BigListNode get_next()
        {
            return next;
        }

        public SmallList get_value()
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
            BigListNode clone = this;
            return clone;
        }

        @Override
        public String toString()
        {
            return "BigListNode<T>{" +
                    "item=" + item +
                    ", next=" + next +
                    "}";
        }
    };

    public BigList() {} // создание пустого списка

    public BigList(final BigList _list) // конструктор копирования
    {
        push(_list);
    }

    private void push(final BigList _list) // добавление в конец списка (для конструктора копирования)
    {
        for(BigListNode cur = _list.head; cur != null; cur = cur.next)
        {
            push(cur.item);
        }
    }

    public void push(SmallList _item) // добавление в конец списка
    {
        BigListNode newnode = new BigListNode(_item, null);

        if(head == null)
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

    public void push(T _item) // добавление в конец списка
    {
        tail.get_value().push(_item);
    }

    public void push_to_head(SmallList _item) // добавление в начало списка
    {
        BigListNode newnode = new BigListNode(_item, head);

        if(head==null)
        {
            tail = newnode;
        }

        head = newnode;
        count++;
    }

    public void push_to_head(T _item) // добавление в начало списка
    {
        head.get_value().push_to_head(_item);
    }

    public T remove_item_from_head()
    {
        return (T) head.get_value().remove_item_from_head();
    }

    public SmallList remove_from_head()
    {
        SmallList buf_result = head.item;

//        if(count==1)
//        {
//            System.err.println("BigList (remove_on_position): your BigList have only so lone element");
//            System.err.println("Can u add another item in future?");
//        }

        if(head != null)
        {
            head = head.next;
            count--;
            return buf_result;
        }
        else
        {
            System.out.println("Error: can't delete *HEAD* element");
            return null;
        }
    }

    public boolean insert_on_position(SmallList _item, int _pos)
    {
        BigListNode prev = null;
        BigListNode cur = head;

        if (_pos == get_count() + 1)
        {
            push(_item);
            return true;
        }

        if (_pos > get_count() || _pos <= 0)
        {
            System.err.println("BigList (insert_on_position): u write wrong position " + _pos);
            System.err.println("Need 1-" + get_count());
            return false;
        }

        switch (_pos)
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
                    if (buf_pos == _pos)
                    {
                        BigListNode newNode = new BigListNode(_item, cur);
                        prev.next = newNode;
                        count++;
                        return true;
                    }
                }
            }
        }
    }

    public boolean insert_item_on_position(T _item, int logical_position)
    {
        int[] physycal_position = get_physical_pos(logical_position);

        if (logical_position <= 0 || logical_position > physycal_position[2])
        {
            System.err.println("BigList (insert_on_position): u write wrong position " + logical_position);
            System.err.println("Need 1-" + physycal_position[0]*physycal_position[1]);
            return false;
        }

        if (physycal_position[0] == get_count() + 1)
        {
            push(_item);
            return true;
        }

        if(physycal_position[0] == 1 && physycal_position[1] == 1)
        {
            push_to_head(_item);
            return true;
        }

        for (int buf_pos = 1; buf_pos <= count; buf_pos++)
        {
            if (buf_pos == physycal_position[0])
            {
                get_on_position(physycal_position[0]).insert_item_on_position(_item, physycal_position[1]);
                return true;
            }
        }

        return false;
    }

    public SmallList remove_on_position(int _pos)
    {
        BigListNode prev = null;
        BigListNode cur = head;

//        if(count==1)
//        {
//            System.err.println("BigList (remove_on_position): your BigList have only so lone element");
//            System.err.println("Can u add another item in future?");
//        }

        if(_pos > get_count() || _pos <= 0)
        {
            System.err.println("BigList (remove_on_position): u write wrong position " + _pos);
            System.err.println("Need 1-" + get_count());
            return null;
        }

        SmallList buf_cur = null;

        for (int buf_pos = 1 ; buf_pos <= count; prev = cur, cur = cur.next, buf_pos++)
        {
            if (buf_pos == _pos)
            {
                if (cur == head)
                {
                    buf_cur = cur.get_value();
                    remove_from_head();
                    break;
                }
                else
                {
                    buf_cur = cur.get_value();
                    prev.next = cur.next;
                    cur = null;
                    count--;
                    break;
                }
            }
        }
        return buf_cur;
    }

    public T remove_item_on_position(int logical_position)
    {
        int[] physycal_position = get_physical_pos(logical_position);

//        if(get_on_position(physycal_position[0]).get_count() == 1)
//        {
//            System.err.println("SmallList (remove_on_position): your SmallList have only so lone element");
//            System.err.println("Can u add another item in future?");
//        }

        if(logical_position <= 0 || logical_position > physycal_position[2])
        {
            System.err.println("SmallList (remove_on_position): u write wrong position " + logical_position);
            System.err.println("Need 1-" + physycal_position[0]*physycal_position[1]);
            return null;
        }

        return (T) get_on_position(physycal_position[0]).remove_item_on_position(physycal_position[1]);
    }

    public SmallList get_on_position(int _pos)
    {
        BigListNode cur = head;

        if(_pos > get_count() || _pos <= 0)
        {
            System.err.println("BigList (get_on_position): u write wrong position " + _pos);
            System.err.println("Need 1-" + get_count());
        }

        for (int buf_pos = 1; cur.next != null; cur = cur.next, buf_pos++)
        {
            if (buf_pos == _pos)
            {
                return cur.get_value();
            }
        }
        return cur.get_value();
    }

    public T get_item_on_position(int logical_position)
    {
        int[] physycal_position = get_physical_pos(logical_position);

        if(logical_position <= 0 || logical_position > physycal_position[2])
        {
            System.err.println("SmallList (get_on_position): u write wrong position " + logical_position);
            System.err.println("Need 1-" + physycal_position[0]*physycal_position[1]);
        }

        return (T) get_on_position(physycal_position[0]).get_item_on_position(physycal_position[1]);
    }

    public void print_List()
    {
        for (int i = 1; i <= count; i++)
        {
            System.out.println(i + ": " + get_on_position(i).to_array());
        }
    }

    public Object change_item_on_pos(T _new_value, int logical_position)
    {
        int[] physycal_position = get_physical_pos(logical_position);

        if(logical_position <= 0)
        {
            System.err.println("SmallList (change_nodeList_on_pos): u write wrong position " + logical_position);
            System.err.println("Need 1-" + physycal_position[0]*physycal_position[1]);
            return null;
        }

        get_on_position(physycal_position[0]).change_item_on_pos(_new_value, physycal_position[1]);
        return null;
    }

    public int get_count()
    {
        int buf_count = count;
        return buf_count;
    }

    private void comp_and_swap(Vector arr, int _i, int _j, int _direction)
    {
        if (((Integer)arr.get(_i) > (Integer)arr.get(_j) && _direction == 1)
                                            ||
             ((Integer)arr.get(_i) < (Integer)arr.get(_j) && _direction == 0))
        {
            Integer temp_i = (Integer) arr.get(_i);
            Integer temp_j = (Integer) arr.get(_j);

            arr.remove(_i); arr.insertElementAt(temp_j, _i);

            arr.remove(_j); arr.insertElementAt(temp_i, _j);
        }
    }

    private void bitonic_merge(Vector arr, int _low, int _count, int _direction)
    {
        if (_count > 1)
        {
            int _buf_count = _count / 2;

            for (int i = _low; i < _low + _buf_count; i++)
            {
                comp_and_swap(arr, i, i + _buf_count, _direction);
            }
            bitonic_merge(arr, _low, _buf_count, _direction);
            bitonic_merge(arr, _low + _buf_count, _buf_count, _direction);
        }
    }

    private void bitonic_sort(Vector arr, int _low, int _count, int _direction)
    {
        if (_count > 1)
        {
            int _buf_count = _count / 2;

            bitonic_sort(arr, _low, _buf_count, 1);
            bitonic_sort(arr,_low + _buf_count, _buf_count, 0);

            bitonic_merge(arr, _low, _count, _direction);
        }
    }

    public void sort_list()
    {
        Vector arr = new Vector();
        Vector size_of_node = new Vector();

        int logical_pos = 1;

        for (int i = 1; i <= count; i++)
        {
            size_of_node.add(get_on_position(i).get_count());

            for (int j = 1; j <= get_on_position(i).get_count(); j++, logical_pos++)
            {
                arr.add(get_item_on_position(logical_pos));
            }
        }

        if(((arr.size() > 0) && ((arr.size() & (arr.size() - 1)) == 0))) // если количество элементов кратно степени 2ки
        {
            bitonic_sort(arr, 0, arr.size(),1);
        }
        else
        {
            int buf_size = arr.size();
            int to_remove_buf_elements = 0;

            while (!((arr.size() & (arr.size() - 1)) == 0))
            {
                arr.add(1); // добавление фиктивных элементов для получения нужной размерности (количество элементов кратно степени 2ки)
                to_remove_buf_elements++;
            }

            size_of_node.add(arr.size()-buf_size);

            bitonic_sort(arr, 0, arr.size(), 1);

            for (int i = 0; i < to_remove_buf_elements; i++)
            {
                arr.removeElementAt(0);
            }

            size_of_node.remove(size_of_node.size()-1);

            remove_List();
        }

        for (int i = 0; i < size_of_node.size(); i++)
        {
            push(new SmallList<>());

            for (int j = 0; j < (Integer) size_of_node.get(i); j++)
            {
                tail.get_value().push((T) arr.firstElement());
                arr.remove(arr.firstElement());
            }
        }
    }

    public ArrayList to_array()
    {
        ArrayList<Object> array = new ArrayList<>();

        if (head != null)
        {
            for (BigListNode cur = head; cur != null; cur = cur.next)
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

    public void export_serialize()
    {
        try{
            FileOutputStream fos = new FileOutputStream("test.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
        }
        catch (Exception ex)
        {}
    }

    public void import_serialize()
    {
        BigList<SmallList> buf_list = new BigList<SmallList>();

        try{
            FileInputStream fis = new FileInputStream("test.dat");
            ObjectInputStream iis = new ObjectInputStream(fis);
            buf_list = (BigList<SmallList>) iis.readObject();
        }
        catch (Exception ex)
        {}

        push(buf_list);
    }

    private int[] get_physical_pos(int _pos)
    {
        int[] pos = new int[3];

        for (int i = 1, logical_pos = 1; i <= count; i++)
        {
            for (int j = 1; j <= get_on_position(i).get_count(); j++, logical_pos++)
            {
                if(_pos == logical_pos)
                {
                    pos = new int[]{i, j, 0};
                }
            }
            pos[2] = logical_pos;
        }
        return pos;
    }

    public void balance_list(int for_balance_count)
    {
        Vector arr = new Vector();

        int logical_pos = 1;

        for (int i = 1; i <= count; i++)
        {
            for (int j = 1; j <= get_on_position(i).get_count(); j++, logical_pos++)
            {
                arr.add(get_item_on_position(logical_pos));
            }
        }

        remove_List();

        while (arr.size() > 0)
        {
            push(new SmallList<>());

            for (int i = 0; i < for_balance_count; i++)
            {
                if(arr.size()==0)
                    break;

                tail.get_value().push((T) arr.firstElement());
                arr.remove(arr.firstElement());
            }
        }
    }

    public void remove_List()
    {
        while (count!=0)
        {
            remove_from_head();
        }
    }
}
