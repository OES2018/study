package com.zjw.chineseChess;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

/**
 * 棋盘类
 * @author jiawei
 *
 */
public class ChessBoard extends JPanel implements MouseListener,MouseMotionListener{
	public ChessPoint point[][];
	public int unitWidth,unitHeight;
	private int x,y;
	private int Xaxis ,Yaxis;
	private Image img;
	protected Image pieceImg;
	private boolean move = false;
	public String Redcolor = "红方",BlackColor = "黑方";
	
	ChessPiece redcar1,redcar2,redhorse1,redhorse2,redelephant1,redelephant2,redgeneral,redofficial,
	redcannon1,redcannon2,redsoldier1,redsoldier2,redsoldier3,redsoldier4,redsoldier5;
	ChessPiece blackcar1,blackcar2,blackhorse1,blackhorse2,blackelephant1,blackelephant2,blackgeneral,blackofficial,
	blackcannon1,blackcannon2,blacksoldier1,blacksoldier2,blacksoldier3,blacksoldier4,blacksoldier5;
	
	int startX,startY;
	int startI,startJ;
	public boolean redgo = true ,blackgo = false;
	Rule rule = null;
	public MakeChessManual record = null;
	
	public ChessBoard (int w,int h,int r,int c){
		setLayout(null);//首先将容器的布局设置为空布局；
		addMouseListener(this);//添加鼠标监听器,监听鼠标事件MouseEvent；
		addMouseMotionListener(this);//添加鼠标监听器，监听鼠标的移动和拖放；
		Color bc = getBackground();//背景颜色；
		unitHeight = h;
		unitWidth = w;
		Xaxis = r;
		Yaxis = c;
		point = new ChessPoint[r+1][c+1];
		for(int i=1;i<=r;i++){
			for(int j=1;j<=c;j++){
				point[i][j]=new ChessPoint(i*unitWidth,j*unitHeight,false);
			}
		}
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
