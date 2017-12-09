package com.zjw.chineseChess;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
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
		g.setColor(chineseChess.bgColor);//将画笔设置为背景颜色；
		g.fill3DRect(60, 30, 580, 630, false);//绘制一个矩形棋盘；
		g.setColor(Color.black);//画笔颜色设置为黑色；
		for(int i=80;i<=620;i=i+60){
			g.drawLine(110, i, 590, i);//绘制横向；，前两个参数为起点坐标，后两个参数为终点坐标；
		}
		g.drawLine(110,80,110,620);//绘制左边线
		g.drawLine(590,80,590,620);//绘制右边线
		for(int i=170;i<=530;i=i+60){//绘制中间的竖线
			g.drawLine(i,80,i,320);
			g.drawLine(i,380,i,620);
		}
		g.drawLine(290,80,410,200);//绘制两边的斜线
		g.drawLine(290,200,410,80);
		g.drawLine(290,500,410,620);
		g.drawLine(290,620,410,500);
		this.smallLine(g,1,2);//绘制红炮所在位置的标志
		this.smallLine(g,7,2);//绘制红炮所在位置的标志
		this.smallLine(g,0,3);//绘制兵所在位置的标志
		this.smallLine(g,2,3);//绘制兵所在位置的标志
		this.smallLine(g,4,3);//绘制兵所在位置的标志
		this.smallLine(g,6,3);//绘制兵所在位置的标志
		this.smallLine(g,8,3);//绘制兵所在位置的标志
		this.smallLine(g,0,6);//绘制卒所在位置的标志
		this.smallLine(g,2,6);//绘制卒所在位置的标志
		this.smallLine(g,4,6);//绘制卒所在位置的标志
		this.smallLine(g,6,6);//绘制卒所在位置的标志
		this.smallLine(g,8,6);//绘制卒所在位置的标志
		this.smallLine(g,1,7);//绘制白炮所在位置的标志
		this.smallLine(g,7,7);//绘制白炮所在位置的标志
		g.setColor(Color.black);
		Font font1=new Font("宋体",Font.BOLD,50);//设置字体
		g.setFont(font1);
		g.drawString("楚 河",170,365);//绘制楚河汉界
		g.drawString("漢 界",400,365);
		Font font=new Font("宋体",Font.BOLD,30);
		g.setFont(font);//设置字体
		for(int i=0;i<9;i++){
			for(int j=0;j<10;j++){//绘制棋子
				if(chessPieces[i][j]!=null){
					if(this.chessPieces[i][j].isFocus()!=false){//是否被选中
						g.setColor(chineseChess.focusbg);//选中后的背景色
						g.fillOval(110+i*60-25,80+j*60-25,50,50);//绘制该棋子,这个就是画圆的函数；
						//第一个参数是要填充椭圆的左上角的x坐标，第二个参数是要填充椭圆的左上角的y坐标，3参数-要填充椭圆的宽度，4参数-要填充椭圆的高度；
						g.setColor(chineseChess.focuschar);//字符的颜色
					}
					else{
						g.fillOval(110+i*60-25,80+j*60-25,50,50);//绘制该棋子，110是棋子的中心点，左上角：x减去了25
						g.setColor(chessPieces[i][j].getColor());//设置画笔颜色
					}
					//绘制棋子的位置，有意思了，在界面中显示跟i和j有关；
				    g.drawString(chessPieces[i][j].getName(),110+i*60-15,80+j*60+10);//画棋子中的字
				    g.setColor(Color.black);//设为黑色
				}
			}
		}
		g.setColor(color);//还原画笔颜色

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(this.chineseChess.caipan == true){//判断是否轮到该玩家走棋；
			int i = -1,j = -1;
			int[] pos = getPos(e);
			i = pos[0];j=pos[1];
			if (i>=0&&i<=8&&j>=0&&j<=9) { //在棋盘范围内
				if (focus == false) {//如果没有选中棋子；
					
				}
				else {//如果选中棋子；
					if(chessPieces[i][j] != null){//如果该处有棋子；
						if(chessPieces[i][j].getColor() == chessPieces[startI][startJ].getColor()){
							chessPieces[startI][startJ].setFocus(false);//将之前的设置为不能操作；
							chessPieces[i][j].setFocus(true);//更改选中对象；
							startI = i; startJ = j ;//保存修改；
							System.out.println(i+";"+j);
						}
						else {//如果是对方棋子：提示对方走棋；
							
						}
					
					}
					else {//如果没有棋子；
						
					}
				}
			}
		}
	}
	public int [] getPos(MouseEvent e){
		int [] pos = new int[2];
		pos[0] = -1;
		pos[1] = -1;
		Point p = e.getPoint(); //获得事件发生的坐标点；
		double x = p.getX();
		double y = p.getY();
		if (Math.abs((x-110)/1%60)<=25) {  //获得对应于数组下标的位置；因为棋子的半径是25
			pos[0] = Math.round((float)(x-110))/60;//math.round（）方法是把一个数字舍入一个最接近其的整数；
		}else if (Math.abs((x-110)/1%60)>=35){//大于35就是右边的棋子了；
			pos[0] = Math.round((float)(x-110))/60+1;
		}if (Math.abs((y-80)/1%60)<=25) {  //获得对应于数组下标的位置；因为棋子的半径是25
			pos[1] = Math.round((float)(y-80))/60;//math.round（）方法是把一个数字舍入一个最接近其的整数；
		}else if (Math.abs((y-80)/1%60)>=35){//大于35就是右边的棋子了；
			pos[1] = Math.round((float)(y-80))/60+1;
		}
		return pos;
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
	public void smallLine(Graphics2D g,int i,int j){
		int x=110+60*i;//计算坐标
		int y=80+60*j;
		if(i>0){//绘制左上方的标志
			g.drawLine(x-3,y-3,x-20,y-3);g.drawLine(x-3,y-3,x-3,y-20);
		}
		if(i<8){//绘制右上方的标志
			g.drawLine(x+3,y-3,x+20,y-3);g.drawLine(x+3,y-3,x+3,y-20);
		}
		if(i>0){//绘制左下方的标志
			g.drawLine(x-3,y+3,x-20,y+3);g.drawLine(x-3,y+3,x-3,y+20);
		}
		if(i<8){//绘制右下方的标志
			g.drawLine(x+3,y+3,x+20,y+3);g.drawLine(x+3,y+3,x+3,y+20);
		}
	}
	
}
