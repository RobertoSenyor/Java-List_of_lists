public interface ForEach
{

    int get_num_of_item();

    void refresh();

    Object toDo(Object value);

    public boolean hasNext();

    public Object next();

    public void to_head();

    void to_tail();
}