package com.zjw.chineseChess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
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
	
	ChessPiece redcar1,redcar2,redhorse1,redhorse2,redelephant1,redelephant2,redgeneral,redofficial1,redofficial2,
	redcannon1,redcannon2,redsoldier1,redsoldier2,redsoldier3,redsoldier4,redsoldier5;
	ChessPiece blackcar1,blackcar2,blackhorse1,blackhorse2,blackelephant1,blackelephant2,blackgeneral,blackofficial1,blackofficial2,
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
		
		//rule = new Rule(this, point);  
        //record = new MakeChessManual(this, point);  
  
        img = Toolkit.getDefaultToolkit().getImage("board.jpg");  
        pieceImg = Toolkit.getDefaultToolkit().getImage("piece.gif"); 
        
        redcar1 = new ChessPiece("车", bc, Color.red, this, w-4, h-4);
        redcar1.setChessPiece(Redcolor);
        redcar2 = new ChessPiece("车", bc, Color.red, this, w-4, h-4);
        redcar2.setChessPiece(Redcolor);

        redhorse1 = new ChessPiece("马", bc, Color.red, this, w-4, h-4);
        redhorse1.setChessPiece(Redcolor);
        redhorse2 = new ChessPiece("马", bc, Color.red, this, w-4, h-4);
        redhorse2.setChessPiece(Redcolor);
        redcannon1 = new ChessPiece("炮", bc, Color.red, this, w-4, h-4);
        redcannon1.setChessPiece(Redcolor);
        redcannon2 = new ChessPiece("炮", bc, Color.red, this, w-4, h-4);
        redcannon2.setChessPiece(Redcolor);
        redelephant1 = new ChessPiece("相", bc, Color.red, this, w-4, h-4);
        redelephant1.setChessPiece(Redcolor);
        redelephant2 = new ChessPiece("相", bc, Color.red, this, w-4, h-4);
        redelephant2.setChessPiece(Redcolor);
        redgeneral = new ChessPiece("帅", bc, Color.red, this, w-4, h-4);
        redgeneral.setChessPiece(Redcolor);
        redofficial1 = new ChessPiece("仕", bc, Color.red, this, w-4, h-4);
        redofficial1.setChessPiece(Redcolor);
        redofficial2 = new ChessPiece("仕", bc, Color.red, this, w-4, h-4);
        redofficial2.setChessPiece(Redcolor);
        redsoldier1 = new ChessPiece("兵", bc, Color.red, this, w-4, h-4);
        redsoldier1.setChessPiece(Redcolor);
        redsoldier2 = new ChessPiece("兵", bc, Color.red, this, w-4, h-4);
        redsoldier2.setChessPiece(Redcolor);
        redsoldier3 = new ChessPiece("兵", bc, Color.red, this, w-4, h-4);
        redsoldier3.setChessPiece(Redcolor);
        redsoldier4 = new ChessPiece("兵", bc, Color.red, this, w-4, h-4);
        redsoldier4.setChessPiece(Redcolor);
        redsoldier5 = new ChessPiece("兵", bc, Color.red, this, w-4, h-4);
        redsoldier5.setChessPiece(Redcolor);
        
        blackcar1 = new ChessPiece("车", bc, Color.black, this, w-4, h-4);
        blackcar1.setChessPiece(BlackColor);
        blackcar2 = new ChessPiece("车", bc, Color.black, this, w-4, h-4);
        blackcar2.setChessPiece(BlackColor);
        blackhorse1 = new ChessPiece("马", bc, Color.black, this, w-4, h-4);
        blackhorse1.setChessPiece(BlackColor);
        blackhorse2 = new ChessPiece("马", bc, Color.black, this, w-4, h-4);
        blackhorse2.setChessPiece(BlackColor);
        blackcannon1 = new ChessPiece("炮", bc, Color.black, this, w-4, h-4);
        blackcannon1.setChessPiece(BlackColor);
        blackcannon2 = new ChessPiece("炮", bc, Color.black, this, w-4, h-4);
        blackcannon2.setChessPiece(BlackColor);
        blackelephant1 = new ChessPiece("象", bc, Color.black, this, w-4, h-4);
        blackelephant1.setChessPiece(BlackColor);
        blackelephant2 = new ChessPiece("象", bc, Color.black, this, w-4, h-4);
        blackelephant2.setChessPiece(BlackColor);
        blackgeneral = new ChessPiece("将", bc, Color.black, this, w-4, h-4);
        blackgeneral.setChessPiece(BlackColor);
        blackofficial1 = new ChessPiece("仕", bc, Color.black, this, w-4, h-4);
        blackofficial1.setChessPiece(BlackColor);
        blackofficial2 = new ChessPiece("仕", bc, Color.black, this, w-4, h-4);
        blackofficial2.setChessPiece(BlackColor);
        blacksoldier1 = new ChessPiece("卒", bc, Color.black, this, w-4, h-4);
        blacksoldier1.setChessPiece(BlackColor);
        blacksoldier2 = new ChessPiece("卒", bc, Color.black, this, w-4, h-4);
        blacksoldier2.setChessPiece(BlackColor);
        blacksoldier3 = new ChessPiece("卒", bc, Color.black, this, w-4, h-4);
        blacksoldier3.setChessPiece(BlackColor);
        blacksoldier4 = new ChessPiece("卒", bc, Color.black, this, w-4, h-4);
        blacksoldier4.setChessPiece(BlackColor);
        blacksoldier5 = new ChessPiece("卒", bc, Color.black, this, w-4, h-4);
        blacksoldier5.setChessPiece(BlackColor);
        point[1][10].setPiece(redcar1, this);  
        point[2][10].setPiece(redhorse1, this);  
        point[3][10].setPiece(redelephant1, this);  
        point[4][10].setPiece(redofficial1, this);  
        point[5][10].setPiece(redgeneral, this);  
        point[6][10].setPiece(redofficial2, this);  
        point[7][10].setPiece(redelephant2, this);  
        point[8][10].setPiece(redhorse2, this);  
        point[9][10].setPiece(redcar2, this);  
        point[2][8].setPiece(redcannon1, this);  
        point[8][8].setPiece(redcannon2, this);  
        point[1][7].setPiece(redsoldier1, this);  
        point[3][7].setPiece(redsoldier2, this);  
        point[5][7].setPiece(redsoldier3, this);  
        point[7][7].setPiece(redsoldier4, this);  
        point[9][7].setPiece(redsoldier5, this);  
  
        point[1][1].setPiece(blackcar1, this);  
        point[2][1].setPiece(blackhorse1, this);  
        point[3][1].setPiece(blackelephant1, this);  
        point[4][1].setPiece(blackofficial1, this);  
        point[5][1].setPiece(blackgeneral, this);  
        point[6][1].setPiece(blackofficial2, this);  
        point[7][1].setPiece(blackelephant2, this);  
        point[8][1].setPiece(blackhorse2, this);  
        point[9][1].setPiece(blackcar2, this);  
        point[2][3].setPiece(blackcannon1, this);  
        point[8][3].setPiece(blackcannon2, this);  
        point[1][4].setPiece(blacksoldier1, this);  
        point[3][4].setPiece(blacksoldier2, this);  
        point[5][4].setPiece(blacksoldier3, this);  
        point[7][4].setPiece(blacksoldier4, this);  
        point[9][4].setPiece(blacksoldier5, this);  
  
        
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int imgWidth = img.getWidth(this);
		int imgHight = img.getHeight(this);
		int FWidth = getWidth();
		int FHight = getHeight();
		int x = (FWidth - imgWidth)/2;
		int y = (FHight - imgHight)/2;
		g.drawImage(img, x, y, null);
		
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
