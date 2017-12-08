package com.zjw.chineseChess;

import java.awt.Color;

/**
 * 棋子类；
 * @author jiawei
 *
 */
public class ChessPiece {
	private Color color ;//棋子的颜色；
	private String name ;//棋子的名字；
	private int x;
	private int y;
	private boolean focus = false;//棋子的状态，是否被选中；
	
	public ChessPiece() {
		super();
	}
	//生成构造函数；
	public ChessPiece(Color color, String name, int x, int y) {
		super();
		this.color = color;
		this.name = name;
		this.x = x;
		this.y = y;
	}
	//生成setget方法；
	public Color getColor() { 
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isFocus() {
		return focus;
	}
	public void setFocus(boolean focus) {
		this.focus = focus;
	}
	
}
