//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.Vector;
//
//public class Viewshka extends JFrame
//{
//    private Vector<BigList> _vector = new Vector<>();
//    private BigList<BigList> BigList = new BigList<>();
//    private IteratorList it_BigList = new IteratorList(BigList);
//    private double grade_of_two = 3;
//
//    private Object[] userTypes = {"Integer", "Double"};
//    private int choosen_userType; // выбор типа данных
//    private JButton showBigList_btn;
//    private JButton showAllLists_btn;
//    private JButton sortBigList_btn;
//    private JButton pushInList_btn;
//    private JButton getOnPosList_btn;
//    private JButton insertOnPosList_btn;
//    private JButton removeOnPosList_btn;
//    private JButton exportList_btn;
//    private JButton importList_btn;
//    private JPanel mainPanel;
//
//    public Viewshka()
//    {
//        super("Viewshka");
//
//        getContentPane().setBackground(Color.DARK_GRAY);
//        getContentPane().setLayout(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(new Dimension(600, 500));
//
//        // для расположения основного окна
//        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        Dimension screenSize = toolkit.getScreenSize();
//        int x = (screenSize.width - this.getWidth()) / 2;
//        int y = (screenSize.height - this.getHeight()) / 2;
//        setLocation(x,y);
//
//        choosen_userType = JOptionPane.showOptionDialog(this,
//                "Which user type do you want choose?",
//                "Choose 'userType'",
//                JOptionPane.YES_NO_OPTION,
//                JOptionPane.QUESTION_MESSAGE,
//                null,
//                userTypes,
//                null
//        );
//
//        generate_list_hierarchy(choosen_userType);
//
//        mainPanel = new JPanel();
//        mainPanel.setBounds(0,0, 600, 500);
//        mainPanel.setBackground(Color.DARK_GRAY);
//        mainPanel.setLayout(null);
//
//        getContentPane().add(mainPanel);
//
//        showBigList_btn = new JButton("Show BigList");
//        showBigList_btn.setBounds(200, 30, 200, 30);
//        mainPanel.add(showBigList_btn);
//        showBigList_btn.setFocusable(false);
//
//        showBigList_btn.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
//                JOptionPane.showOptionDialog(mainPanel,
//                        BigList.to_array().toArray(),
//                        "BigList count: " + BigList.get_count(),
//                        JOptionPane.DEFAULT_OPTION,
//                        JOptionPane.INFORMATION_MESSAGE,
//                        null,
//                        null,
//                        null
//                );
//            }
//        });
//
//        showAllLists_btn = new JButton("Show All Lists");
//        showAllLists_btn.setBounds(200, 70, 200, 30);
//        mainPanel.add(showAllLists_btn);
//        showAllLists_btn.setFocusable(false);
//
//        showAllLists_btn.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
//                Object choosenList_info = (Object) JOptionPane.showInputDialog(mainPanel,
//                        "Choose BigList for get information",
//                        "Count of Lists: " + _vector.size(),
//                        JOptionPane.PLAIN_MESSAGE,
//                        null,
//                        _vector.toArray(),
//                        null
//                );
//
//                JOptionPane.showOptionDialog(mainPanel,
//                        _vector.get(_vector.indexOf(choosenList_info)).to_array().toArray(),
//                        "Count of "+ _vector.get(_vector.indexOf(choosenList_info)) + ": " + _vector.get(_vector.indexOf(choosenList_info)).get_count(),
//                        JOptionPane.DEFAULT_OPTION,
//                        JOptionPane.INFORMATION_MESSAGE,
//                        null,
//                        null,
//                        null
//                );
//            }
//        });
//
//        sortBigList_btn = new JButton("Sort BigList");
//        sortBigList_btn.setBounds(200, 110, 200, 30);
//        mainPanel.add(sortBigList_btn);
//        sortBigList_btn.setFocusable(false);
//
//        sortBigList_btn.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
//                JOptionPane.showOptionDialog(mainPanel,
//                        BigList.to_array().toArray(),
//                        "BigList before sort!!!",
//                        JOptionPane.DEFAULT_OPTION,
//                        JOptionPane.INFORMATION_MESSAGE,
//                        null,
//                        null,
//                        null
//                );
//
//                if (!(BigList.sort_list()))
//                {
//                    JOptionPane.showOptionDialog(mainPanel,
//                            "Size of BigList must be equal power of 2!",
//                            "Wrong size " + BigList.get_count(),
//                            JOptionPane.DEFAULT_OPTION,
//                            JOptionPane.INFORMATION_MESSAGE,
//                            null,
//                            null,
//                            null
//                    );
//                }
//
//                JOptionPane.showOptionDialog(mainPanel,
//                        BigList.to_array().toArray(),
//                        "BigList after sort!!!",
//                        JOptionPane.DEFAULT_OPTION,
//                        JOptionPane.INFORMATION_MESSAGE,
//                        null,
//                        null,
//                        null
//                );
//            }
//        });
//
//        pushInList_btn = new JButton("Push in anything BigList");
//        pushInList_btn.setBounds(200, 150, 200, 30);
//        mainPanel.add(pushInList_btn);
//        pushInList_btn.setFocusable(false);
//
//        pushInList_btn.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
//                Object choosenList_info = (Object) JOptionPane.showInputDialog(mainPanel,
//                        "Choose BigList for push",
//                        "Count of Lists: " + _vector.size(),
//                        JOptionPane.PLAIN_MESSAGE,
//                        null,
//                        _vector.toArray(),
//                        null
//                );
//
//                int onlyOneToPush = JOptionPane.showOptionDialog(mainPanel,
//                        "Do you want push only one item?",
//                        "One or more",
//                        JOptionPane.YES_NO_OPTION,
//                        JOptionPane.INFORMATION_MESSAGE,
//                        null,
//                        null,
//                        null
//                );
//
//                if (choosenList_info.equals(BigList))
//                {
//                    _vector.add(new BigList<Integer>());
//                    _vector.lastElement().push(777);
//                    BigList.push(_vector.lastElement());
//                }
//                else
//                {
//                    _vector.get(_vector.indexOf(choosenList_info)).push(777);
//                }
//
//                JOptionPane.showOptionDialog(mainPanel,
//                        _vector.get(_vector.indexOf(choosenList_info)).to_array().toArray(),
//                        "Count of "+ _vector.get(_vector.indexOf(choosenList_info))+": " + _vector.get(_vector.indexOf(choosenList_info)).get_count(),
//                        JOptionPane.DEFAULT_OPTION,
//                        JOptionPane.INFORMATION_MESSAGE,
//                        null,
//                        null,
//                        null
//                );
//
//                if (onlyOneToPush == 1)
//                {
//                    pushInList_btn.doClick();
//                }
//            }
//        });
//
//        getOnPosList_btn = new JButton("Get on position from BigList");
//        getOnPosList_btn.setBounds(200, 190, 200, 30);
//        mainPanel.add(getOnPosList_btn);
//        getOnPosList_btn.setFocusable(false);
//
//        getOnPosList_btn.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
//                Object choosenList_info = (Object) JOptionPane.showInputDialog(mainPanel,
//                        "Choose BigList for get information",
//                        "Count of Lists: " + _vector.size(),
//                        JOptionPane.PLAIN_MESSAGE,
//                        null,
//                        _vector.toArray(),
//                        null
//                );
//
//                String choosenPosList = (String)JOptionPane.showInputDialog(
//                        mainPanel,
//                        "Choose position for get item",
//                        "Count of BigList: " + _vector.get(_vector.indexOf(choosenList_info)).get_count(),
//                        JOptionPane.PLAIN_MESSAGE,
//                        null,
//                        null,
//                        "Position must have a value between 1 and " + _vector.get(_vector.indexOf(choosenList_info)).get_count()
//                );
//
//                JOptionPane.showOptionDialog(mainPanel,
//                        _vector.get(_vector.indexOf(choosenList_info)).get_on_position(Integer.parseInt(choosenPosList)),
//                        "Item on pos " + choosenPosList,
//                        JOptionPane.DEFAULT_OPTION,
//                        JOptionPane.INFORMATION_MESSAGE,
//                        null,
//                        null,
//                        null
//                );
//            }
//        });
//
//        insertOnPosList_btn = new JButton("Insert on position from BigList");
//        insertOnPosList_btn.setBounds(200, 230, 200, 30);
//        mainPanel.add(insertOnPosList_btn);
//        insertOnPosList_btn.setFocusable(false);
//
//        insertOnPosList_btn.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
//                Object choosenList_info = (Object) JOptionPane.showInputDialog(mainPanel,
//                        "Choose BigList for insert on position",
//                        "Count of Lists: " + _vector.size(),
//                        JOptionPane.PLAIN_MESSAGE,
//                        null,
//                        _vector.toArray(),
//                        null
//                );
//
//                String choosenPosList = (String)JOptionPane.showInputDialog(
//                        mainPanel,
//                        "Choose position for insert item",
//                        "Count of BigList: " + _vector.get(_vector.indexOf(choosenList_info)).get_count(),
//                        JOptionPane.PLAIN_MESSAGE,
//                        null,
//                        null,
//                        "Position must have a value between 1 and " + _vector.get(_vector.indexOf(choosenList_info)).get_count()
//                );
//
//                if (choosenList_info.equals(BigList))
//                {
//                    _vector.add(new BigList<Integer>());
//                    _vector.lastElement().push(777);
//                    BigList.insert_on_position(_vector.lastElement(), Integer.parseInt(choosenPosList));
//                }
//                else
//                {
//                    _vector.get(_vector.indexOf(choosenList_info)).insert_on_position(777, Integer.parseInt(choosenPosList));
//                }
//
//                JOptionPane.showOptionDialog(mainPanel,
//                        _vector.get(_vector.indexOf(choosenList_info)).to_array().toArray(),
//                        "Count of "+ _vector.get(_vector.indexOf(choosenList_info))+": " + _vector.get(_vector.indexOf(choosenList_info)).get_count(),
//                        JOptionPane.DEFAULT_OPTION,
//                        JOptionPane.INFORMATION_MESSAGE,
//                        null,
//                        null,
//                        null
//                );
//            }
//        });
//
//        removeOnPosList_btn = new JButton("Remove on position from BigList");
//        removeOnPosList_btn.setBounds(200, 270, 200, 30);
//        mainPanel.add(removeOnPosList_btn);
//        removeOnPosList_btn.setFocusable(false);
//
//        removeOnPosList_btn.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
//                Object choosenList_info = (Object) JOptionPane.showInputDialog(mainPanel,
//                        "Choose BigList for remove on position",
//                        "Count of Lists: " + _vector.size(),
//                        JOptionPane.PLAIN_MESSAGE,
//                        null,
//                        _vector.toArray(),
//                        null
//                );
//
//                String choosenPosList = (String)JOptionPane.showInputDialog(
//                        mainPanel,
//                        "Choose position for remove item",
//                        "Count of BigList: " + _vector.get(_vector.indexOf(choosenList_info)).get_count(),
//                        JOptionPane.PLAIN_MESSAGE,
//                        null,
//                        null,
//                        "Position must have a value between 1 and " + _vector.get(_vector.indexOf(choosenList_info)).get_count()
//                );
//
//                _vector.get(_vector.indexOf(choosenList_info)).remove_on_position(Integer.parseInt(choosenPosList));
//                _vector.remove(Integer.parseInt(choosenPosList));
//
//                JOptionPane.showOptionDialog(mainPanel,
//                        _vector.get(_vector.indexOf(choosenList_info)).to_array().toArray(),
//                        "Count of "+ _vector.get(_vector.indexOf(choosenList_info))+": " + _vector.get(_vector.indexOf(choosenList_info)).get_count(),
//                        JOptionPane.DEFAULT_OPTION,
//                        JOptionPane.INFORMATION_MESSAGE,
//                        null,
//                        null,
//                        null
//                );
//            }
//        });
//
//        exportList_btn = new JButton("To serialize");
//        exportList_btn.setBounds(200, 310, 200, 30);
//        mainPanel.add(exportList_btn);
//        exportList_btn.setFocusable(false);
//
//        exportList_btn.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
//                BigList.export_serialize();
//            }
//        });
//
//        importList_btn = new JButton("Serialize back");
//        importList_btn.setBounds(200, 350, 200, 30);
//        mainPanel.add(importList_btn);
//        importList_btn.setFocusable(false);
//
//        importList_btn.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
//                _vector.clear();
//
//                BigList.remove_List();
//                BigList = new BigList<>();
//                BigList.import_serialize();
//
//                _vector.add(BigList);
//                _vector.addAll(BigList.to_array());
//            }
//        });
//
//        setVisible(true);
//    }
//
//    public void generate_list_hierarchy(int userType)
//    {
//        _vector.add(BigList);
//
//        if (userType == 0)
//        {
//            for (int j = 0; j < 8; j++) //(int)Math.pow(2,((int)(Math.random()*((4-1)+1))+1))
//            {
//                _vector.add(new BigList<Integer>());
//
//                for (int i = 0; i < ((int)(Math.random()*((10-1)+1))+1); i++)
//                {
//                    _vector.lastElement().push(((int)(Math.random()*((10-1)+1))+1) + 1);
//                }
//
//                BigList.push(_vector.lastElement());
//            }
//        }
//
//        if (userType == 1)
//        {
//            for (int j = 0; j < 8; j++)
//            {
//                _vector.add(new BigList<Double>());
//
//                for (int i = 0; i < ((int)(Math.random()*((10-1)+1))+1); i++)
//                {
//                    _vector.lastElement().push((Math.random()*((10-1)+1))+1);
//                }
//
//                BigList.push(_vector.lastElement());
//            }
//        }
//    }
//
//    public static void main(String[] args)
//    {
////        new Viewshka();
//
//        Vector<BigList> _vector = new Vector<>();
//        BigList<BigList> BigList = new BigList<>();
//
//        for (int j = 0; j < 4; j++)
//        {
//            _vector.add(new BigList<Integer>());
//
//            for (int i = 0; i < ((int) (Math.random() * ((10 - 1) + 1)) + 1); i++)
//            {
//                _vector.lastElement().push(((int) (Math.random() * ((10 - 1) + 1)) + 1) + 1);
//            }
//
//            BigList.push(_vector.lastElement());
//        }
//
//        BigList.export_serialize();
//        BigList.remove_List();
//
//        BigList = new BigList<>();
//        BigList.import_serialize();
//
//        _vector.clear();
//        _vector.addAll(BigList.to_array());
//
//        System.out.println(_vector);
//        BigList.remove_List();
//        BigList.print_List();
//    }
//}