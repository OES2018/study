package com.zjw.chineseChess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

/**
 * 象棋主类
 * @author jiawei
 *
 */
public class ChineseChess extends JFrame implements ActionListener{
	ChessBoard board = null;
	MakeChessManual record = null;
	Container con = null;
	Demo demo = null;
	JMenuBar bar ; //菜单条
	JMenu fileMenu;//菜单
	JMenuItem CreatChessSpectrum,SaveChessSpectrum,DemoChess;//菜单项
	JFileChooser fileChooser = null;//文件选择器；
	LinkedList 	chess = null;
	public ChineseChess(){
		bar = new JMenuBar();
		fileMenu = new JMenu("中国象棋");
		CreatChessSpectrum = new JMenuItem("制作棋谱");
		SaveChessSpectrum = new JMenuItem("保存棋谱");
		SaveChessSpectrum.setEnabled(false);
		DemoChess =  new JMenuItem("演示棋谱");
		fileMenu.add(CreatChessSpectrum);
		fileMenu.add(SaveChessSpectrum);
		fileMenu.add(DemoChess);
		bar.add(fileMenu);
		setJMenuBar(bar);
		setTitle(CreatChessSpectrum.getText());
		SaveChessSpectrum.addActionListener(this);
		CreatChessSpectrum.addActionListener(this);
		DemoChess.addActionListener(this);
		board = new ChessBoard(45, 45, 9, 10);
		record = board.record;
		con = getContentPane();//初始化一个容器，用来在容器上添加一些控件；
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true);
		split.setDividerSize(5);
		split.setDividerLocation(460);
		con.add(split,BorderLayout.CENTER);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		setVisible(true);
		setBounds(60,20,690,540);
		fileChooser = new JFileChooser();
		con.validate();
		validate();
		
	}
public static void main(String[] args) {
	new ChineseChess();
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource() == CreatChessSpectrum){
		con.removeAll();
		SaveChessSpectrum.setEnabled(true);
		this.setTitle(CreatChessSpectrum.getText());
		board = new ChessBoard(45, 45, 9, 10);
		record = board.record;
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true);
		split.setDividerSize(5);
		split.setDividerLocation(460);
		con.add(split,BorderLayout.CENTER);
		validate();
	}
	
	if (e.getSource() == SaveChessSpectrum) {  
        int state = fileChooser.showSaveDialog(null);  
        File saveFile = fileChooser.getSelectedFile();  
        if (saveFile != null && state == JFileChooser.APPROVE_OPTION) {  
            try {  
                FileOutputStream outOne = new FileOutputStream(saveFile);  
                ObjectOutputStream outTwo = new ObjectOutputStream(outOne);  
                outTwo.writeObject(record.获取棋谱());  
                outOne.close();  
                outTwo.close();  
            } catch (IOException event) {  
            }  
        }  
    }  
	
	if(e.getSource() == DemoChess){
		con.removeAll();  
        con.repaint();  
        con.validate();  
        validate();  
        SaveChessSpectrum.setEnabled(false); 
        int state = fileChooser.showOpenDialog(null);  
        File openFile = fileChooser.getSelectedFile(); 
        if (openFile != null && state == JFileChooser.APPROVE_OPTION) {  
            try {  
                FileInputStream inOne = new FileInputStream(openFile);  
                ObjectInputStream inTwo = new ObjectInputStream(inOne);  
                chess = (LinkedList) inTwo.readObject();  
                inOne.close();  
                inTwo.close();  
                ChessBoard board = new ChessBoard(45, 45, 9, 10);  
                demo = new Demo(board);  
              //  demo.set棋谱(chess);  
                //con.add(demo, BorderLayout.CENTER);  
                con.validate();  
                validate();  
                this.setTitle(DemoChess.getText() + ":" + openFile);  
            } catch (Exception event) {  
                JLabel label = new JLabel("不是棋谱文件");  
                label.setFont(new Font("隶书", Font.BOLD, 60));  
                label.setForeground(Color.red);  
                label.setHorizontalAlignment(SwingConstants.CENTER);  
                con.add(label, BorderLayout.CENTER);  
                con.validate();  
                this.setTitle("没有打开棋谱");  
                validate();  
            }  
        } else {  
            JLabel label = new JLabel("没有打开棋谱文件呢");  
            label.setFont(new Font("隶书", Font.BOLD, 50));  
            label.setForeground(Color.pink);  
            label.setHorizontalAlignment(SwingConstants.CENTER);  
            con.add(label, BorderLayout.CENTER);  
            con.validate();  
            this.setTitle("没有打开棋谱文件呢");  
            validate();  
        }  
	}
}
}
