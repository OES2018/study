package com.zjw.chineseChess;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 * 象棋主类；
 * @author jiawei
 *
 */
public class ChineseChess  extends JFrame implements ActionListener{
	public static  final Color bgColor = new Color(245,250,160);//棋盘的背景颜色；
	public static final Color focusbg = new Color(242,242,242);//棋子选中后的背景颜色；
	public static final Color focuschar = new Color(96,95,91);//棋子选中后的字符颜色；
	public static final Color color1 = new Color(249,183,173);
	public static final Color color2 = Color.white;//白方的颜色；
	JLabel jstartGame = new JLabel("游戏开始");
	int width = 60; //设置棋盘两线之间的距离；
	ChessPiece[][] chessPiece = new ChessPiece[9][10];//创建棋子数组；
	ChessBoard jpz = new ChessBoard(chessPiece, width, this);//创建棋盘
	JPanel jpy  = new JPanel();//创建一个JPanel；
	JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jpz, jpy);
	
	boolean caipan = false ;//可否走棋的标志位；
	int color = 0;//0代表红旗，1代表白棋；
	
	public ChineseChess() throws HeadlessException {
		super();
	}
	public void initialComponent(){
		jpy.setLayout(null);
		this.jstartGame.setBounds(10, 10, 50, 20);
		jpy.add(this.jstartGame);
		jpz.setLayout(null);
		jpz.setBounds(0, 0, 700, 700);
	}
	public void initialState(){
		
	}
	public void initialChessPiece(){
		//初始化各个棋子；
		chessPiece[0][0]=new ChessPiece(color1, "车", 0, 0);
		chessPiece[1][0]=new ChessPiece(color1, "马", 1, 0);
		chessPiece[2][0]=new ChessPiece(color1, "相", 2, 0);
		chessPiece[3][0]=new ChessPiece(color1, "仕", 3, 0);
		chessPiece[4][0]=new ChessPiece(color1, "帅", 4, 0);
		chessPiece[5][0]=new ChessPiece(color1, "仕", 5, 0);
		chessPiece[6][0]=new ChessPiece(color1, "相", 6, 0);
		chessPiece[7][0]=new ChessPiece(color1, "马", 7, 0);
		chessPiece[8][0]=new ChessPiece(color1, "车", 8, 0);
		chessPiece[1][2]=new ChessPiece(color1, "炮", 1, 2);
		chessPiece[7][2]=new ChessPiece(color1, "炮", 7, 2);
		chessPiece[0][3]=new ChessPiece(color1, "兵", 0, 3);
		chessPiece[2][3]=new ChessPiece(color1, "兵", 2, 3);
		chessPiece[4][3]=new ChessPiece(color1, "兵", 4, 3);
		chessPiece[6][3]=new ChessPiece(color1, "兵", 6, 3);
		chessPiece[8][3]=new ChessPiece(color1, "兵", 8, 3);
		
		chessPiece[0][9]=new ChessPiece(color2, "车", 0, 9);
		chessPiece[1][9]=new ChessPiece(color2, "马", 1, 9);
		chessPiece[2][9]=new ChessPiece(color2, "象", 2, 9);
		chessPiece[3][9]=new ChessPiece(color2, "仕", 3, 9);
		chessPiece[4][9]=new ChessPiece(color2, "将", 4, 9);
		chessPiece[5][9]=new ChessPiece(color2, "仕", 5, 9);
		chessPiece[6][9]=new ChessPiece(color2, "象", 6, 9);
		chessPiece[7][9]=new ChessPiece(color2, "马", 7, 9);
		chessPiece[8][9]=new ChessPiece(color2, "车", 8, 9);
		chessPiece[1][7]=new ChessPiece(color2, "炮", 1, 7);
		chessPiece[7][7]=new ChessPiece(color2, "炮", 7, 7);
		chessPiece[0][6]=new ChessPiece(color2, "卒", 0, 6);
		chessPiece[2][6]=new ChessPiece(color2, "卒", 2, 6);
		chessPiece[4][6]=new ChessPiece(color2, "卒", 4, 6);
		chessPiece[6][6]=new ChessPiece(color2, "卒", 6, 6);
		chessPiece[8][6]=new ChessPiece(color2, "卒", 8, 6);
	}
	public void initialFrame(){
		this.setTitle("中国象棋");
		Image image = new ImageIcon("ico.gif").getImage();
		this.setIconImage(image);//设置图标；
		this.add(this.jSplitPane);
		jSplitPane.setDividerLocation(730);//设置分割线位置及宽度；
		jSplitPane.setVisible(true);//设置可见性；
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(){
				System.exit(0);//退出；
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.jstartGame){
			this.jstartGame_event();
		}
	}
	public void jstartGame_event(){
		
	}
	public void next(){ //将棋子数组都置空；
		for (int i = 0; i < 9; i++) {
			for (int j =0;j<10;j++){
				this.chessPiece[i][j]=null;
			}
		}
		this.caipan = false;
		this.initialChessPiece();//重新初始化棋子；
		repaint();//重新绘制；
	}
	public static void main (String args[]){
		
	}
}
