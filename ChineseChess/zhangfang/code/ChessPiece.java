
/**
 * 添加棋子到数组中，便于调用
 *
 */

package zf.chinesechess;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ChessPiece {
	public JLabel chesspiece[] = new JLabel[32];   //棋子
	 //i棋子数,k控制棋子位置
	 int i,k; 		 
	 //棋子
	 Icon piece;
	 //棋子宽高的一半
	 int half=55/2;
	 
	ChessPiece(){
		//车
		 piece = new ImageIcon("piece\\黑车.gif");
		 for (i=0;i<2;i++){		
			 chesspiece[i] = new JLabel(piece);
			 chesspiece[i].setName("黑车" + i);
			 }	
		 
		 //马
		 piece = new ImageIcon("piece\\黑马.gif");
		 for (i=4;i<6;i++){			 
				chesspiece[i] = new JLabel(piece);
				chesspiece[i].setName("黑马" + i);
				}
		 
		 //象
		 piece = new ImageIcon("piece\\黑象.gif");
		 for (i=8;i<10;i++){
			 chesspiece[i] = new JLabel(piece);
			 chesspiece[i].setName("黑象" + i);
			}
		 
		 //士
		 piece = new ImageIcon("piece\\黑士.gif");
		 for (i=12;i<14;i++){
			 chesspiece[i] = new JLabel(piece);
			 chesspiece[i].setName("黑士" + i);
			 }
			
		 //卒
		 piece = new ImageIcon("piece\\黑卒.gif");
		 for (i=16;i<21;i++){
			 chesspiece[i] = new JLabel(piece);
			 chesspiece[i].setName("黑卒" + i);
			 }
			
		 //炮
		 piece = new ImageIcon("piece\\黑炮.gif");
		 for (i=26;i<28;i++){
			 chesspiece[i] = new JLabel(piece);
			 chesspiece[i].setName("黑炮" + i);
			 }
		
		 //将
		 piece = new ImageIcon("piece\\黑将.gif");
		 chesspiece[30] = new JLabel(piece);
		 chesspiece[30].setName("黑将");

		 //红色棋子
		 //车
		 piece = new ImageIcon("piece\\红车.gif");
		 for (i=2;i<4;i++){
			 chesspiece[i] = new JLabel(piece);
			 chesspiece[i].setName("红车" + i);
			}
			
		 //马
		 piece = new ImageIcon("piece\\红马.gif");
		 for (i=6;i<8;i++){
			 chesspiece[i] = new JLabel(piece);
			 chesspiece[i].setName("红马" + i);
			}
			
		 //相
		 piece = new ImageIcon("piece\\红象.gif");
		 for (i=10;i<12;i++){
			 chesspiece[i] = new JLabel(piece);
			 chesspiece[i].setName("红相" + i);
			}
			
		 //仕
		 piece = new ImageIcon("piece\\红士.gif");
		 for (i=14;i<16;i++){
			 chesspiece[i] = new JLabel(piece);
			 chesspiece[i].setName("红仕" + i);
			}
			
		 //兵
		 piece = new ImageIcon("piece\\红卒.gif");
		 for (i=21;i<26;i++){
			 chesspiece[i] = new JLabel(piece);
			 chesspiece[i].setName("红兵" + i);
			}
		 
		 //砲
		 piece = new ImageIcon("piece\\红炮.gif");
		 for (i=28;i<30;i++){
			 chesspiece[i] = new JLabel(piece);
			 chesspiece[i].setName("红砲" + i);
			}
			
		 //帅
		 piece = new ImageIcon("piece\\红将.gif");
		 chesspiece[31] = new JLabel(piece);
		 chesspiece[31].setName("红帅");
	}
	
	//初始化位置
	 public void drawChess(){		 	
		 // 黑棋
		 //车
		 for (i=0,k=70-half;i<2;i++,k+=480){		
			 chesspiece[i].setBounds(k,90-half,55,55); 
			 }	
		 
		 //马
		 for (i=4,k=130-half;i<6;i++,k+=360){			 
			 chesspiece[i].setBounds(k,90-half,55,55);  
			}
		 
		 //象
		 for (i=8,k=190-half;i<10;i++,k+=240){
			 chesspiece[i].setBounds(k,90-half,55,55); 
			}
		 
		 //士
		 for (i=12,k=250-half;i<14;i++,k+=120){
			 chesspiece[i].setBounds(k,90-half,55,55); 
			 }
			
		 //卒
		 for (i=16,k=70-half;i<21;i++,k+=120){
			 chesspiece[i].setBounds(k,270-half,55,55);
			 }
			
		 //炮
		 for (i=26,k=130-half;i<28;i++,k+=360){
			 chesspiece[i].setBounds(k,210-half,55,55);
			 }
		
		 //将
		 chesspiece[30].setBounds(310-half,90-half,55,55);		
		 

		 //红色棋子
		 //车
		 for (i=2,k=70-half;i<4;i++,k+=480){
			 chesspiece[i].setBounds(k,630-half,55,55); 
			}
			
		 //马
		 for (i=6,k=130-half;i<8;i++,k+=360){
			 chesspiece[i].setBounds(k,630-half,55,55); 
			}
			
		 //相
		 for (i=10,k=190-half;i<12;i++,k+=240){
			 chesspiece[i].setBounds(k,630-half,55,55); 
			}
			
		 //仕
		 for (i=14,k=250-half;i<16;i++,k+=120){
			 chesspiece[i].setBounds(k,630-half,55,55); 
			}
			
		 //兵
		 for (i=21,k=70-half;i<26;i++,k+=120){
			 chesspiece[i].setBounds(k,450-half,55,55);
			}
		 
		 //砲
		 for (i=28,k=130-half;i<30;i++,k+=360){
			 chesspiece[i].setBounds(k,510-half,55,55);
			}
			
		 //帅
		 piece = new ImageIcon("piece\\红将.gif");
		 chesspiece[31].setBounds(310-half,630-half,55,55);
		}
	
}
