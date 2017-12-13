package com.mj.maven.chinesechess;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
*@auther minjie 
*@E-mail jie_min_jimmy@163.com
*@version 创建时间：2017年12月12日
**/
public class ChessBoard extends JPanel implements MouseListener,MouseMotionListener{

	private ArrayList<ChessPieceModelImp> blackChessPieces=new ArrayList<ChessPieceModelImp>();
	private ArrayList<ChessPieceModelImp> redChessPieces=new ArrayList<ChessPieceModelImp>();
	
	public ChessBoard(){
		initialize();
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	private void initialize() {
		//配置棋子
		configureChessPieces();
	}
	
	private void configureChessPieces() {
		configureBlackChessPieces();
		configureRedChessPieces();
	}
	
	private void configureBlackChessPieces() {
		ChessPieceModelImp firstBlackRook=new Rook("rook","black",1,1);
		ChessPieceModelImp firstBlackHorse=new Horse("horse","black",2,1);
		ChessPieceModelImp firstBlackBishop=new Bishop("bishop","black",3,1);
		ChessPieceModelImp firstBlackGuard=new Guard("guard","black",4,1);
		ChessPieceModelImp blackKing=new King("king","black",5,1);
		ChessPieceModelImp secondBlackRook=new Rook("rook","black",9,1);
		ChessPieceModelImp secondBlackHorse=new Horse("horse","black",8,1);
		ChessPieceModelImp secondBlackBishop=new Bishop("bishop","black",7,1);
		ChessPieceModelImp secondBlackGuard=new Guard("guard","black",6,1);
		
		ChessPieceModelImp firstBlackCannon=new Cannon("cannon","black",8,3);
		ChessPieceModelImp secondBlackCannon=new Cannon("cannon","black",2,3);
		
		ChessPieceModelImp firstBlackPawn=new Pawn("pawn","black",1,4);
		ChessPieceModelImp secondBlackPawn=new Pawn("pawn","black",3,4);
		ChessPieceModelImp thirdBlackPawn=new Pawn("pawn","black",5,4);
		ChessPieceModelImp fourthBlackPawn=new Pawn("pawn","black",7,4);
		ChessPieceModelImp fifthBlackPawn=new Pawn("pawn","black",9,4);
		
		blackChessPieces.add(firstBlackRook);
		blackChessPieces.add(firstBlackHorse);
		blackChessPieces.add(firstBlackBishop);
		blackChessPieces.add(firstBlackGuard);
		blackChessPieces.add(blackKing);
		blackChessPieces.add(secondBlackRook);
		blackChessPieces.add(secondBlackHorse);
		blackChessPieces.add(secondBlackBishop);
		blackChessPieces.add(secondBlackGuard);
		
		blackChessPieces.add(firstBlackCannon);
		blackChessPieces.add(secondBlackCannon);
		
		blackChessPieces.add(firstBlackPawn);
		blackChessPieces.add(secondBlackPawn);
		blackChessPieces.add(thirdBlackPawn);
		blackChessPieces.add(fourthBlackPawn);
		blackChessPieces.add(fifthBlackPawn);
		blackChessPieces.add(firstBlackPawn);
	}
	
	private void configureRedChessPieces() {
		ChessPieceModelImp firstRedRook=new Rook("rook","red",1,10);
		ChessPieceModelImp firstRedHorse=new Horse("horse","red",2,10);
		ChessPieceModelImp firstRedBishop=new Bishop("bishop","red",3,10);
		ChessPieceModelImp firstRedGuard=new Guard("guard","red",4,10);
		ChessPieceModelImp redKing=new King("king","red",5,10);
		ChessPieceModelImp secondRedRook=new Rook("rook","red",9,10);
		ChessPieceModelImp secondRedHorse=new Horse("horse","red",8,10);
		ChessPieceModelImp secondRedBishop=new Bishop("bishop","red",7,10);
		ChessPieceModelImp secondRedGuard=new Guard("guard","red",6,10);
		
		ChessPieceModelImp firstRedCannon=new Cannon("cannon","red",2,8);
		ChessPieceModelImp secondRedCannon=new Cannon("cannon","red",8,8);
		
		ChessPieceModelImp firstRedPawn=new Pawn("pawn","red",1,7);
		ChessPieceModelImp secondRedPawn=new Pawn("pawn","red",3,7);
		ChessPieceModelImp thirdRedPawn=new Pawn("pawn","red",5,7);
		ChessPieceModelImp fourthRedPawn=new Pawn("pawn","red",7,7);
		ChessPieceModelImp fifthRedPawn=new Pawn("pawn","red",9,7);		
		
		redChessPieces.add(firstRedRook);
		redChessPieces.add(firstRedHorse);
		redChessPieces.add(firstRedBishop);
		redChessPieces.add(firstRedGuard);
		redChessPieces.add(redKing);
		redChessPieces.add(secondRedRook);
		redChessPieces.add(secondRedHorse);
		redChessPieces.add(secondRedBishop);
		redChessPieces.add(secondRedGuard);
		
		redChessPieces.add(firstRedCannon);
		redChessPieces.add(secondRedCannon);
		
		redChessPieces.add(firstRedPawn);
		redChessPieces.add(secondRedPawn);
		redChessPieces.add(thirdRedPawn);
		redChessPieces.add(fourthRedPawn);
		redChessPieces.add(fifthRedPawn);
		redChessPieces.add(firstRedPawn);
	}
	
    public void paintComponent(Graphics g) {  
        super.paintComponent(g);  
        addChessBoardBackground(g);//添加棋盘背景
        addChessPieces(g);
        
    }  

	public void addChessBoardBackground(Graphics g){
/*		 ImageIcon imgIcon=new ImageIcon("src/main/resources/images/chessboard.gif");
	     Image img=imgIcon.getImage();
	     //下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小  
	     g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);  */

		
		BufferedImage chessBoardBackground=null;
		try {
			chessBoardBackground = ImageIO.read(new File("src/main/resources/images/chessboard.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(chessBoardBackground, 0, 0,this.getWidth(), this.getHeight(), null); 

				System.out.println(this.getWidth()+": "+this.getHeight());
	    int imgWidth = chessBoardBackground.getWidth(this);  
	    int imgHeight = chessBoardBackground.getHeight(this);// 获得图片的宽度与高度  
	    int FWidth = getWidth();  
	    int FHeight = getHeight();// 获得窗口的宽度与高度  
	    int x = (FWidth - imgWidth) / 2;  
	    int y = (FHeight - imgHeight) / 2;  
	    System.out.println(x+":"+y);
	    //  g.drawImage(img, x, y, null);
	}
	
	private void addChessPieces(Graphics g) {
		for(ChessPieceModelImp redCheessPiece: redChessPieces){
			redCheessPiece.paint(g);
		}
			
		for(ChessPieceModelImp blackChessPiece: blackChessPieces){
			blackChessPiece.paint(g);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("mouseClicked");
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouse dragged");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
