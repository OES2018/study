package com.zjw.chineseChess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import com.sun.javafx.css.Rule;

/**
 * 棋盘
 * @author jiawei
 *
 */
public class ChessBoard extends JPanel implements MouseListener{

	private int width;//棋盘两线之间的距离；
	boolean focus = false ; //棋子的状态；
	int jiang1_i = 4;//帅的i坐标；
	int jiang1_j = 0;//帅的j坐标；
	int jiang2_i = 4;//将的i坐标；
	int jiang2_j = 9;//将的j坐标；
	int startI = -1;//棋子开始的位置；
	int startJ = -1;//
	int endI = -1;//棋子的终止位置；
	int endJ = -1;
	public ChessPiece chessPieces[][];//棋子的数组；
	ChineseChess chineseChess= null;//声明象棋的引用；
	ChineseRule chineseRule ;//声明象棋规则的引用；
	public ChessBoard(ChessPiece chessPiece[][],int width,ChineseChess chineseChess){
		this.chessPieces = chessPiece;
		this.chineseChess = chineseChess;
		this.width = width;
		chineseRule = new ChineseRule(); 
		this.addMouseListener(this);//为棋盘添加鼠标事件监听器；
		this.setBounds(0, 0, 700, 700);//设置棋盘的大小；
		this.setLayout(null);//设置为空布局；
	}
	public void paint(Graphics g1){
		Graphics2D g = (Graphics2D) g1;//获得Graphics2d对象；
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);//打开
		Color color  = g.getColor();//获得画笔的颜色；
		g.setColor(chineseChess.bgColor);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
