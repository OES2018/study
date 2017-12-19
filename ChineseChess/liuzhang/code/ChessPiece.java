package lz.ChineseChess;

import java.awt.Container;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ChessPiece {
	//使用i和k将所有棋子摆放到棋盘中
	int i;
	int k;
	//棋子图标
	Icon in;
	//棋子的构造函数初始化棋子位置,这里每个棋子的位置是通过棋盘大小和棋子大小计算出来的，每一个格子相隔57
	public ChessPiece(Container con,JLabel[] chess){
		//“------黑棋-------”
		//车
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"黑车.gif");
		for(i=0, k=24;i<2;i++,k+=456){
			chess[i] = new JLabel(in);
			con.add(chess[i]);
			chess[i].setBounds(k,56,55,55);
			chess[i].setName("黑车"+i);
		}
		//马
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"黑马.gif");
		for(i=2, k=81;i<4;i++,k+=342){
			chess[i] = new JLabel(in);
			con.add(chess[i]);
			chess[i].setBounds(k,56,55,55);
			chess[i].setName("黑马"+i);
		}
		//象
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"黑象.gif");
		for(i=4, k=138;i<6;i++,k+=228){
			chess[i] = new JLabel(in);
			con.add(chess[i]);
			chess[i].setBounds(k,56,55,55);
			chess[i].setName("黑象"+i);
		}
		//士
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"黑士.gif");
		for(i=6, k=195;i<8;i++,k+=114){
			chess[i] = new JLabel(in);
			con.add(chess[i]);
			chess[i].setBounds(k,56,55,55);
			chess[i].setName("黑士"+i);
		}
		//将 
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"黑将.gif");
		chess[8] = new JLabel(in);
		con.add(chess[8]);
		chess[8].setBounds(252,56,55,55);
		chess[8].setName("黑将"+8);
		//炮
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"黑炮.gif");
		for(i=9, k=81;i<11;i++,k+=342){
			chess[i] = new JLabel(in);
			con.add(chess[i]);
			chess[i].setBounds(k,170,55,55);
			chess[i].setName("黑炮"+i);
		}
		//卒
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"黑卒.gif");
		for(i=11, k=24;i<16;i++,k+=114){
			chess[i] = new JLabel(in);
			con.add(chess[i]);
			chess[i].setBounds(k,227,55,55);
			chess[i].setName("黑卒"+i);
		}
		//“------红棋------”
		//车
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"红车.gif");
		for(i=16, k=24;i<18;i++,k+=456){
			chess[i] = new JLabel(in);
			con.add(chess[i]);
			chess[i].setBounds(k,569,55,55);
			chess[i].setName("红车"+i);
		}
		//马
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"红马.gif");
		for(i=18, k=81;i<20;i++,k+=342){
			chess[i] = new JLabel(in);
			con.add(chess[i]);
			chess[i].setBounds(k,569,55,55);
			chess[i].setName("红马"+i);
		}
		//相
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"红象.gif");
		for(i=20, k=138;i<22;i++,k+=228){
			chess[i] = new JLabel(in);
			con.add(chess[i]);
			chess[i].setBounds(k,569,55,55);
			chess[i].setName("红相"+i);
		}
		//士
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"红士.gif");
		for(i=22, k=195;i<24;i++,k+=114){
			chess[i] = new JLabel(in);
			con.add(chess[i]);
			chess[i].setBounds(k,569,55,55);
			chess[i].setName("红士"+i);
		}
		//帅
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"红将.gif");
		chess[24] = new JLabel(in);
		con.add(chess[24]);
		chess[24].setBounds(252,569,55,55);
		chess[i].setName("红帅"+24);
		//炮
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"红炮.gif");
		for(i=25, k=81;i<27;i++,k+=342){
			chess[i] = new JLabel(in);
			con.add(chess[i]);
			chess[i].setBounds(k,455,55,55);
			chess[i].setName("红炮"+i);
		}
		//兵
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"红卒.gif");
		for(i=27, k=24;i<32;i++,k+=114){
			chess[i] = new JLabel(in);
			con.add(chess[i]);
			chess[i].setBounds(k,398,55,55);
			chess[i].setName("红兵"+i);
		}
		/*
		 * chess中的棋子分布为{0黑车0，1黑车1，2黑马2，3黑马3，4黑象4，5黑象5，6黑士6，7黑士7，8黑将8，9黑炮9，10黑炮10，11黑卒11，12黑卒12，13黑卒13，14黑卒14，15黑卒15
		 *                  16红车16，17红车17，18红马18，19红马19，20红相20，21红相21，22红士22，23红士23，24红帅24，25红炮25，26红炮26，27红兵27，28红兵28，29红兵29，30红兵30，31红兵31}
		 */
	}
}
