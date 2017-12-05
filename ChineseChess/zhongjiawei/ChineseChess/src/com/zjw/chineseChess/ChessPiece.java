package com.zjw.chineseChess;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * 棋子类
 * @author jiawei
 *
 */
public class ChessPiece {
	String name;//棋子名字；
	Color backColor = null ,foreColor;
	String color = null;
	ChessBoard board = null;
	int width,height; //长宽；
	public ChessPiece(String name, Color bc, Color fc,
			 ChessBoard board, int width, int height) {
		super();
		this.name = name;
		backColor = bc ;
		foreColor = fc ;
		this.board = board;
		this.width = width;
		this.height = height;
		
	}
	public void paint(Graphics g){
		g.drawImage(board.pieceImg, 2, 2, width-2, height-2, null);
		g.setColor(foreColor);
		g.setFont(new Font("楷体", Font.BOLD, 26));
		g.drawString(name, 7, height-8);//在棋子上绘制棋子名
		g.setColor(Color.black);
		float lineWidth = 2.3f;
		((Graphics2D)g).setStroke(new BasicStroke(lineWidth));//设置线宽；
		((Graphics2D)g).drawOval(2, 2, width-2, height-2);
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public String getName(){
		return name;
	}
	public Color getChessPieceColor(){
		return foreColor;
	}
	public void setChessPiece(String chessPiece){
		
	}
	
}
