package com.mj.maven.chinesechess;

import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
*@auther minjie 
*@E-mail jie_min_jimmy@163.com
*@version 创建时间：2017年12月11日
**/
public abstract class ChessPieceModelImp extends JLabel implements ChessPieceModel{
	private String name;
	private String color;
	private int x;
	private int y;
	
	private static final double MAP_TO_REALISTIC_POSITION_X_FACTOR=55.8;
	private static final double MAP_TO_REALISTIC_POSITION_Y_FACTOR=56.36;
	
	public ChessPieceModelImp(String name,String color,int x, int y){
		this.name=name;
		this.color=color;
		this.x=x;
		this.y=y;
	}
	
    public void paint(Graphics g) {       
        BufferedImage chessPieceImage=null;
		try {
			//System.out.println("src/main/resources/images/"+color+name+".gif"+x+": "+y);
			chessPieceImage = ImageIO.read(new File("src/main/resources/images/"+color+name+".gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		 g.drawImage(chessPieceImage, (int)(x*MAP_TO_REALISTIC_POSITION_X_FACTOR-chessPieceImage.getWidth()/2), (int)(y*MAP_TO_REALISTIC_POSITION_Y_FACTOR-chessPieceImage.getHeight()/2),chessPieceImage.getWidth(), chessPieceImage.getHeight(), null); 
    }
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
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
	

}
