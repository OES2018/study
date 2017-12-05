package com.zjw.chineseChess;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;

/**
 * 象棋主类
 * @author jiawei
 *
 */
public class ChineseChess extends JFrame implements ActionListener{
	ChessBoard board = null;
	MakeChessManual record = null;
	Container con = null;
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
	
}
}
