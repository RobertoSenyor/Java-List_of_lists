import java.util.Vector;

public class Test
{
    public static void main(String[] args)
    {
        BigList<Integer> BigList = new BigList<>();

        System.out.println("\n-----generate data-----");
        for (int j = 0; j < 3; j++)
        {
            BigList.push(new SmallList<Integer>());

            for (int i = 0; i < 3; i++)
            {
                BigList.push(((int) (Math.random() * ((10 - 1) + 1)) + 1) + 1);
            }
        }
        BigList.print_List();

        System.out.println("\n------pushed list------");
        BigList.push(777);
        BigList.push(777);
        BigList.push(777);
        BigList.print_List();

        System.out.println("\n------remove list------");
        BigList.remove_from_head();
        BigList.print_List();

        System.out.println("\n------remove item from head list------");
        BigList.remove_item_from_head();
        BigList.print_List();

        System.out.println("\n------pushed in head list------");
        BigList.push_to_head(777);
        BigList.push_to_head(777);
        BigList.push_to_head(777);
        BigList.print_List();

        System.out.println("\n------insert in position list------");
        BigList.insert_item_on_position(123, 3);
        BigList.insert_item_on_position(123, 8);
        BigList.insert_item_on_position(123, 9);
        BigList.print_List();

        System.out.println("\n------remove in position list------");
        BigList.remove_item_on_position(3);
        BigList.remove_item_on_position(7);
        BigList.remove_item_on_position(7);
        BigList.print_List();

        System.out.println("\n------get in position list------");
        System.out.println("logical position "+1+": " + BigList.get_item_on_position(1));
        System.out.println("logical position "+4+": " + BigList.get_item_on_position(4));
        System.out.println("logical position "+7+": " + BigList.get_item_on_position(7));
        System.out.println("");
        BigList.print_List();

        System.out.println("\n------change in position=2 list------");
        BigList.print_List();
        BigList.change_item_on_pos(888, 2);
        System.out.println();
        BigList.print_List();

        System.out.println("\n------balance list (balance column 2)------");
        BigList.print_List();
        BigList.balance_list(2);
        System.out.println();
        BigList.print_List();

        System.out.println("\n------sort list------");
        BigList.print_List();
        BigList.sort_list();
        System.out.println();
        BigList.print_List();

        System.out.println("\n------balance list (balance column 4)------");
        BigList.print_List();
        BigList.balance_list(4);
        System.out.println();
        BigList.print_List();

        System.out.println("\n------iterator test------");
        IteratorList it = new IteratorList(BigList);

        while (it.hasNext())
        {
            System.out.println(it.get_num_of_item() + ": " + it.next());
        }
    }
}
