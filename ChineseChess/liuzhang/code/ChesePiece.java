package lz.ChineseChese;

import java.awt.Container;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ChesePiece {
	JLabel[] pieces=new JLabel[32];
	//使用i和k将所有棋子摆放到棋盘中
	int i;
	int k;
	//棋子图标
	Icon in;
	//棋子的构造函数初始化棋子位置,这里每个棋子的位置是通过棋盘大小和棋子大小计算出来的，每一个格子相隔57
	public ChesePiece(Container con){
		//“------黑棋-------”
		//车
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"黑车.gif");
		for(i=0, k=24;i<2;i++,k+=456){
			pieces[i] = new JLabel(in);
			con.add(pieces[i]);
			pieces[i].setBounds(k,56,55,55);
		}
		//马
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"黑马.gif");
		for(int i=2, k=81;i<4;i++,k+=342){
			pieces[i] = new JLabel(in);
			con.add(pieces[i]);
			pieces[i].setBounds(k,56,55,55);
		}
		//象
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"黑象.gif");
		for(int i=4, k=138;i<6;i++,k+=228){
			pieces[i] = new JLabel(in);
			con.add(pieces[i]);
			pieces[i].setBounds(k,56,55,55);
		}
		//士
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"黑士.gif");
		for(int i=6, k=195;i<8;i++,k+=114){
			pieces[i] = new JLabel(in);
			con.add(pieces[i]);
			pieces[i].setBounds(k,56,55,55);
		}
		//将 
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"黑将.gif");
		pieces[8] = new JLabel(in);
		con.add(pieces[8]);
		pieces[8].setBounds(252,56,55,55);
		//炮
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"黑炮.gif");
		for(int i=9, k=81;i<11;i++,k+=342){
			pieces[i] = new JLabel(in);
			con.add(pieces[i]);
			pieces[i].setBounds(k,170,55,55);
		}
		//卒
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"黑卒.gif");
		for(int i=11, k=24;i<16;i++,k+=114){
			pieces[i] = new JLabel(in);
			con.add(pieces[i]);
			pieces[i].setBounds(k,227,55,55);
		}
		//“------红棋------”
		//车
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"红车.gif");
		for(int i=16, k=24;i<18;i++,k+=456){
			pieces[i] = new JLabel(in);
			con.add(pieces[i]);
			pieces[i].setBounds(k,569,55,55);
		}
		//马
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"红马.gif");
		for(int i=18, k=81;i<20;i++,k+=342){
			pieces[i] = new JLabel(in);
			con.add(pieces[i]);
			pieces[i].setBounds(k,569,55,55);
		}
		//相
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"红象.gif");
		for(int i=20, k=138;i<22;i++,k+=228){
			pieces[i] = new JLabel(in);
			con.add(pieces[i]);
			pieces[i].setBounds(k,569,55,55);
		}
		//士
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"红士.gif");
		for(int i=22, k=195;i<24;i++,k+=114){
			pieces[i] = new JLabel(in);
			con.add(pieces[i]);
			pieces[i].setBounds(k,569,55,55);
		}
		//帅
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"红将.gif");
		pieces[24] = new JLabel(in);
		con.add(pieces[24]);
		pieces[24].setBounds(252,569,55,55);
		//炮
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"红炮.gif");
		for(int i=25, k=81;i<27;i++,k+=342){
			pieces[i] = new JLabel(in);
			con.add(pieces[i]);
			pieces[i].setBounds(k,455,55,55);
		}
		//兵
		in = new ImageIcon("src"+File.separator+"image"+File.separator+"红卒.gif");
		for(int i=27, k=24;i<32;i++,k+=114){
			pieces[i] = new JLabel(in);
			con.add(pieces[i]);
			pieces[i].setBounds(k,398,55,55);
		}
		/*
		 * pieces中的棋子分布为{0黑车1，1黑车2，2黑马1，3黑马2，4黑象1，5黑象2，6黑士1，7黑士2，8黑将，9黑炮1，10黑炮2，11黑卒1，12黑卒2，13黑卒3，14黑卒4，15黑卒5
		 *                  16红车1，17红车2，18红马2，19红马2，20红相1，21红相2，22红士1，23红士2，24红帅，25红炮1，26红炮2，27红兵1，28红兵2，29红兵3，30红兵4，31红兵5}
		 */
	}
}
