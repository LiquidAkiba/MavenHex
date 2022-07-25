package minesweeper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainForm extends JFrame implements ActionListener
{
    JMenuBar MenuBar;
    JMenu GameMenu;
    JMenuItem newGameItem;
    JMenuItem resetGameItem;
    JMenuItem exitItem;
    JMenu FiledMenu;
    JMenu filedSizeMenu;
    JMenu filedTypeMenu;
    JMenuItem noviceItem;
    JMenuItem amateurItem;
    JMenuItem expertItem;
    JMenuItem SqrFiledItem;
    JMenuItem hexFiledItem;
    MinesweeperBoard board;
    int w = 9;
    int h = 9;
    int b = 10;
    public MainForm()
    {
        super();
        setTitle("Pinky Duck Minesweeper v2.0");
        MenuBar = new JMenuBar();
        GameMenu = new JMenu("Play");
        FiledMenu = new JMenu("Play Mode");
        newGameItem = new JMenuItem("New Game");
        resetGameItem = new JMenuItem("Reset Game");
        exitItem = new JMenuItem("Exit");
        newGameItem.addActionListener(this);
        resetGameItem.addActionListener(this);
        exitItem.addActionListener(this);

        filedSizeMenu = new JMenu("Grid Size");
        filedTypeMenu = new JMenu("Grid Shape");
        noviceItem = new JMenuItem("Easy 9x9 10 Mines");
        amateurItem = new JMenuItem("Medium 16x16 40 Mines");
        expertItem = new JMenuItem("Hard 24x20 99 Mines");
        noviceItem.addActionListener(this);
        amateurItem.addActionListener(this);
        expertItem.addActionListener(this);
        filedSizeMenu.add(noviceItem);
        filedSizeMenu.add(amateurItem);
        filedSizeMenu.add(expertItem);
        SqrFiledItem = new JMenuItem("Square, 8 Sides");
        SqrFiledItem.addActionListener(this);
        hexFiledItem = new JMenuItem("Hexagon, 6 Sides");
        hexFiledItem.addActionListener(this);
        filedTypeMenu.add(SqrFiledItem);
        filedTypeMenu.add(hexFiledItem);
        GameMenu.add(newGameItem);
        GameMenu.add(resetGameItem);
        GameMenu.add(exitItem);
        FiledMenu.add(filedSizeMenu);
        FiledMenu.add(filedTypeMenu);
        MenuBar.add(GameMenu);
        MenuBar.add(FiledMenu);
        setJMenuBar(MenuBar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(1000,1000);
        board = new SqrMinesweeperBoard();
        getContentPane().add(board);
        board.setSize(getSize());
        board.GetGame().LoadGame(w,h,b);
        board.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if(source == exitItem)
            System.exit(0);
        if(source == newGameItem)
            board.GetGame().LoadGame(w,h,b);
        if(source == resetGameItem)
            board.GetGame().RestartGame();
        if(source == noviceItem)
        {
            w = 9; h = 9;b = 10;
            board.GetGame().LoadGame(w, h,b);
            board.resized(null);
        }
        if(source == amateurItem)
        {
            w = 16; h = 16;b = 40;
            board.GetGame().LoadGame(w, h,b);
            board.resized(null);
        }
        if(source == expertItem)
        {
            w = 24; h = 20;b = 99;
            board.GetGame().LoadGame(w, h,b);
            board.resized(null);
        }
        if(source == SqrFiledItem)
        {
            board = new SqrMinesweeperBoard();
            getContentPane().removeAll();
            getContentPane().add(board);
            board.setSize(getContentPane().getSize());
            board.GetGame().LoadGame(w,h,b);
        }
        if(source == hexFiledItem)
        {
            board = new HexMinesweeperBoard();
            getContentPane().removeAll();
            getContentPane().add(board);
            board.setSize(getContentPane().getSize());
            board.GetGame().LoadGame(w,h,b);
        }
    }
}
