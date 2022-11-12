import Types.Dot2D;
import Types.Int;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class Test {
    public static void main(String[] args) throws Exception {

//        testInt();
//        System.out.println("\n\nSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLIT\n\n");
//        testProperFraction();
//        System.out.println("\n\nSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLIT\n\n");
//        testTimestampSort();
//        System.out.println("\n\nSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLIT\n\n");
        testTimestampGetOnPosition();
        System.out.println("\n\nSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLIT\n\n");
        testTimestampInsertOnPosition();
    }

    private static void testTimestampInsertOnPosition()
    {
        try(FileWriter writer = new FileWriter("testInsertOnPos.csv", false))
        {
            int num_elements = 10000;

            while (num_elements<=50000)
            {
                BigList Biglist = new BigList();

                System.out.println("\n-----testTimestampInsertOnPosition-----");

                for (int j = 0; j < 10; j++)
                {
                    Biglist.push(new SmallList());

                    for (int i = 0; i < num_elements/10; i++)
                    {
                        int value = ((int) (Math.random() * ((100 - 1) + 1)) + 1) + 1;
                        Biglist.push(new Int(value));
                    }
                }

                int value = ((int) (Math.random() * ((100 - 1) + 1)) + 1) + 1;
                double startTime = System.nanoTime();
                Biglist.insert_item_on_position(value, new Int());
                double endTime = System.nanoTime();
                double duration = (endTime - startTime)/1000000;

                System.out.println("----------------------------------");
                System.out.println("Кол-во элементов: " + num_elements);
                System.out.println("Время мс: " + duration);
                System.out.println("----------------------------------");

                String text = num_elements+","+duration;
                writer.write(text);
                writer.append('\n');
                writer.flush();

                num_elements+=500;
                Biglist.remove_list();
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    private static void testTimestampGetOnPosition()
    {
        try(FileWriter writer = new FileWriter("testGetOnPos.txt", false))
        {
            int num_elements = 10000;

            while (num_elements<=50000)
            {
                BigList Biglist = new BigList();

                System.out.println("\n-----testTimestampGetOnPosition-----");

                for (int j = 0; j < 10; j++)
                {
                    Biglist.push(new SmallList());

                    for (int i = 0; i < num_elements/10; i++)
                    {
                        int value = ((int) (Math.random() * ((100 - 1) + 1)) + 1) + 1;
                        Biglist.push(new Int(value));
                    }
                }

                int value = ((int) (Math.random() * ((100 - 1) + 1)) + 1) + 1;
                double startTime = System.nanoTime();
                Biglist.get_item_on_position(value);
                double endTime = System.nanoTime();
                double duration = (endTime - startTime)/1000000;

                System.out.println("----------------------------------");
                System.out.println("Кол-во элементов: " + num_elements);
                System.out.println("Время мс: " + duration);
                System.out.println("----------------------------------");

                String text = num_elements+","+duration;
                writer.write(text);
                writer.append('\n');
                writer.flush();

                num_elements+=500;
                Biglist.remove_list();
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    private static void testTimestampSort()
    {
        try(FileWriter writer = new FileWriter("testSort.csv", false))
        {
            int num_elements = 1000;

            while (num_elements<=20000)
            {
                BigList Biglist = new BigList();

                System.out.println("\n-----testTimestampSort-----");

                for (int j = 0; j < 10; j++)
                {
                    Biglist.push(new SmallList());

                    for (int i = 0; i < num_elements/10; i++)
                    {
                        int value = ((int) (Math.random() * ((100 - 1) + 1)) + 1) + 1;
                        Biglist.push(new Int(value));
                    }
                }

                long startTime = System.currentTimeMillis();
                Biglist.sort_list();
                long endTime = System.currentTimeMillis();
                long duration = (endTime - startTime);

                System.out.println("----------------------------------");
                System.out.println("Кол-во элементов: " + num_elements);
                System.out.println("Время мс: " + duration);
                System.out.println("----------------------------------");

                String text = num_elements+","+duration;
                writer.write(text);
                writer.append('\n');
                writer.flush();

                num_elements+=500;
                Biglist.remove_list();
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    private static void testInt() throws Exception {

        System.out.println("+==============+");
        System.out.println("| TEST INTEGER |");
        System.out.println("+==============+");

        BigList Biglist = new BigList();

        System.out.println("\n-----generate data-----");

        for (int j = 0; j < 3; j++) {
            Biglist.push(new SmallList());

            for (int i = 0; i < 3; i++) {
                int value = ((int) (Math.random() * ((100 - 1) + 1)) + 1) + 1;
                Biglist.push(new Int(value));
            }
        }
        System.out.println(Biglist.print_list());

        System.out.println("\n------pushed list------");
        int value = 777;
        Biglist.push(new Int(value));
        Biglist.push(new Int(value));
        Biglist.push(new Int(value));
        System.out.println(Biglist.print_list());

        System.out.println("\n------remove list------");
        Biglist.remove_from_head();
        System.out.println(Biglist.print_list());

        System.out.println("\n------remove item from head list------");
        Biglist.remove_item_from_head();
        System.out.println(Biglist.print_list());

        System.out.println("\n------pushed in head list------");
        Biglist.push_to_head(new Int(value));
        Biglist.push_to_head(new Int(value));
        Biglist.push_to_head(new Int(value));
        System.out.println(Biglist.print_list());

        System.out.println("\n------insert in position list------");
        Biglist.insert_item_on_position(3, new Int(123));
        Biglist.insert_item_on_position(6, new Int(123));
        Biglist.insert_item_on_position(8, new Int(123));
        System.out.println(Biglist.print_list());

        System.out.println("\n------remove in position 3, 5, 7 list------");
        System.out.println(Biglist.print_list());
        System.out.println("");
        Biglist.remove_item_on_position(3);
        Biglist.remove_item_on_position(5);
        Biglist.remove_item_on_position(7);
        System.out.println(Biglist.print_list());

        System.out.println("\n------get in position list------");
        System.out.println("logical position " + 1 + ": " + Biglist.get_item_on_position(1));
        System.out.println("logical position " + 4 + ": " + Biglist.get_item_on_position(4));
        System.out.println("logical position " + 7 + ": " + Biglist.get_item_on_position(7));
        System.out.println("");
        System.out.println(Biglist.print_list());

        System.out.println("\n------change in position=2 list------");
        System.out.println(Biglist.print_list());
        Biglist.change_item_on_pos(2, new Int(888));
        System.out.println();
        System.out.println(Biglist.print_list());

        System.out.println("\n------balance list (balance column 2)------");
        System.out.println(Biglist.print_list());
        Biglist.balance_list(2);
        System.out.println();
        System.out.println(Biglist.print_list());

        System.out.println("\n------sort list------");
        System.out.println(Biglist.print_list());
        Biglist.sort_list();
        System.out.println();
        System.out.println(Biglist.print_list());

        System.out.println("\n------balance list (balance column 4)------");
        System.out.println(Biglist.print_list());
        Biglist.balance_list(4);
        System.out.println();
        System.out.println(Biglist.print_list());

        System.out.println("\n------Serialization: saving------");
        Serializator.saveToFile(Biglist, "test_int.txt", UserFactory.get_type_name_list().get(0));
        System.out.println("\n------Serialization: loading------");
        BigList newBiglist = Serializator.loadFile("test_int.txt");

        System.out.println("");
        newBiglist.forEach(System.out::print);
        System.out.println("");

        System.out.println("\n+==================+");
        System.out.println("| END TEST INTEGER |");
        System.out.println("+==================+");
    }

    private static void testProperFraction() throws Exception {

        System.out.println("+==============+");
        System.out.println("| TEST POINT2D |");
        System.out.println("+==============+");

        BigList Biglist = new BigList();

        System.out.println("\n-----generate data-----");

        for (int j = 0; j < 3; j++) {
            Biglist.push(new SmallList());

            for (int i = 0; i < 3; i++) {
                int x = ((int) (Math.random() * ((100 - 1) + 1)) + 1) + 1;
                int y = ((int) (Math.random() * ((100 - 1) + 1)) + 1) + 1;
                Biglist.push(new Dot2D(x, y));
            }
        }
        System.out.println(Biglist.print_list());

        System.out.println("\n------pushed list------");
        int x = 77;
        int y = 7;
        Biglist.push(new Dot2D(x, y));
        Biglist.push(new Dot2D(x, y));
        Biglist.push(new Dot2D(x, y));
        System.out.println(Biglist.print_list());

        System.out.println("\n------remove list------");
        Biglist.remove_from_head();
        System.out.println(Biglist.print_list());

        System.out.println("\n------remove item from head list------");
        Biglist.remove_item_from_head();
        System.out.println(Biglist.print_list());

        System.out.println("\n------pushed in head list------");
        Biglist.push_to_head(new Dot2D(x, y));
        Biglist.push_to_head(new Dot2D(x, y));
        Biglist.push_to_head(new Dot2D(x, y));
        System.out.println(Biglist.print_list());

        System.out.println("\n------insert in position list------");
        Biglist.insert_item_on_position(3, new Dot2D(123, 321));
        Biglist.insert_item_on_position(8, new Dot2D(123, 321));
        Biglist.insert_item_on_position(6, new Dot2D(123, 321));
        ;
        System.out.println(Biglist.print_list());

        System.out.println("\n------remove in position 3, 5, 7 list------");
        Biglist.remove_item_on_position(3);
        Biglist.remove_item_on_position(5);
        Biglist.remove_item_on_position(7);
        System.out.println(Biglist.print_list());

        System.out.println("\n------get in position list------");
        System.out.println("logical position " + 1 + ": " + Biglist.get_item_on_position(1));
        System.out.println("logical position " + 4 + ": " + Biglist.get_item_on_position(4));
        System.out.println("logical position " + 7 + ": " + Biglist.get_item_on_position(7));
        System.out.println("");
        System.out.println(Biglist.print_list());

        System.out.println("\n------change in position=2 list------");
        System.out.println(Biglist.print_list());
        Biglist.change_item_on_pos(2, new Dot2D(88, 8));
        System.out.println();
        System.out.println(Biglist.print_list());

        System.out.println("\n------balance list (balance column 2)------");
        System.out.println(Biglist.print_list());
        Biglist.balance_list(2);
        System.out.println();
        System.out.println(Biglist.print_list());

        System.out.println("\n------sort list------");
        System.out.println(Biglist.print_list());
        Biglist.sort_list();
        System.out.println();
        System.out.println(Biglist.print_list());

        System.out.println("\n------balance list (balance column 4)------");
        System.out.println(Biglist.print_list());
        Biglist.balance_list(4);
        System.out.println();
        System.out.println(Biglist.print_list());

        System.out.println("\n------Serialization: saving------");
        Serializator.saveToFile(Biglist, "test_point2d.txt", UserFactory.get_type_name_list().get(1));
        System.out.println("\n------Serialization: loading------");
        BigList newBiglist = Serializator.loadFile("test_point2d.txt");

        System.out.println("");
        newBiglist.forEach(System.out::print);
        System.out.println("");

        System.out.println("\n+==================+");
        System.out.println("| END TEST POINT2D |");
        System.out.println("+==================+");
    }
}
