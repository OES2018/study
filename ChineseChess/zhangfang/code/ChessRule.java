
/** 
 * 象棋吃棋规则
 * 
 */

package zf.chinesechess;

import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class ChessRule {
	 int half=55/2; //55为棋子的高金额宽度
	 
	 /**  卒,兵移动规则      */
	 public void soldierMoveRule(JLabel chess, MouseEvent e){
		 //获取当前棋子所在的位置
		 int chessX = chess.getX()+half;
		 int chessY = chess.getY()+half;
//		 System.out.println(chessX + " " + chessY);
		 //获取鼠标点击的位置
		 int eX = e.getX();
		 int eY = e.getY();
//		 System.out.println(eX + " " + eY);
		 
		 //黑色的卒子 在数组中的下标范围16-20
		 if(chess.getName().charAt(0)=='黑'){
			 //向下移动 
			 if (eY < 640 && ((eY-chessY) > 50 && (eY-chessY) < 70) && ((eX-chessX) < 5 && (eX-chessX) > -5)){
				 chess.setBounds(chessX-half, chessY-half + 60, 55, 55); 
				 }
			 //向右移动（必须过河）
			 else if (chessY >= 390 && eX < 570 && ((eY-chessY) > -5 && (eY-chessY) < 5) && ((eX-chessX)> 50 && (eX-chessX) < 70)){
				 chess.setBounds(chessX-half + 60, chessY-half, 55, 55);
				 }
			 //向左移动（必须过河）
			 else if (chessY >= 390 && eX > 80 && ((eY-chessY) > -5 && (eY-chessY) < 5) && ((chessX-eX)> 50 && (chessX-eX) < 70)){
				 chess.setBounds(chessX - half - 60, chessY -half, 55, 55);
				 }
			 }
		 
		 //红色的兵 21-25
		 else{
			//向上移动
			 if (eY > 70 && ((chessY-eY) > 50 && (chessY-eY) < 70) && ((eX-chessX) < 5 && (eX-chessX) > -5)){
				 chess.setBounds(chessX-half, chessY-half - 60, 55, 55); 
				 }
			 //向右移动（必须过河）
			 else if (chessY <= 330 && eX < 570 && ((eY-chessY) > -5 && (eY-chessY) < 5) && ((eX-chessX)> 50 && (eX-chessX) < 70)){
				 chess.setBounds(chessX-half + 60, chessY-half, 55, 55);
				 }
			 //向左移动（必须过河）
			 else if (chessY <= 330 && eX > 70 && ((eY-chessY) > -5 && (eY-chessY) < 5) && ((chessX-eX)> 50 && (chessX-eX) < 70)){
				 chess.setBounds(chessX-half - 60, chessY -half, 55, 55);
				 }
			 }
		 }
	 
	 
	 /**  卒,兵吃棋规则  */
	 public void soliderEatRule(JLabel chess1, JLabel chess2){
		 int chessX1=chess1.getX()+half;
		 int chessY1=chess1.getY()+half;
		 int chessX2=chess2.getX()+half;
		 int chessY2=chess2.getY()+half;
//		 boolean com=(chess1.getName().charAt(0)!=chess2.getName().charAt(0));		 
//		 System.out.println(com);
//		 System.out.println(chessX1 + " " + chessY1);
//		 System.out.println(chessX2 + " " + chessY2);
		 //黑棋不能向上吃棋，红棋不能向下吃棋
		 //向右吃棋
		 if ((chessX2 - chessX1) <= 65 && (chessX2 - chessX1) >= 55 
				 && (chessY1 - chessY2) < 5 && (chessY1 - chessY2) > -5 
				 && chess2.isVisible() && chess1.getName().charAt(0)!=chess2.getName().charAt(0)){
			 //黑棋要过河
			 if (chess1.getName().charAt(0) == '黑' && chessY1 >= 390 && chess1.getName().charAt(0) != chess2.getName().charAt(0)){
				 chess2.setVisible(false);
				 //把对方的位置给自己
				 chess1.setBounds(chessX2-half,chessY2-half,55,55);
				 }
				
			 //红棋要过河
			 else if (chess1.getName().charAt(0) == '红' && chessY1 <=330 && chess1.getName().charAt(0) != chess2.getName().charAt(0)){
				 chess2.setVisible(false);
				 //把对方的位置给自己
				 chess1.setBounds(chessX2-half,chessY2-half,55,55);	
				 }
			 }
			
		 //向左走
		 else if ((chessX1 - chessX2) <= 65 && (chessX1 - chessX2) >= 55 
				 && (chessY1 - chessY2) < 5 && (chessY1 - chessY2) > -5 
				 && chess2.isVisible() && chess1.getName().charAt(0)!=chess2.getName().charAt(0)){
			 //黑棋要过河
			 if (chess1.getName().charAt(0) == '黑' && chessY1 >= 390 && chess1.getName().charAt(0) != chess2.getName().charAt(0)){
				 chess2.setVisible(false);
				 chess1.setBounds(chessX2-half,chessY2-half,55,55);
				 }
				
			 //红棋要过河
			 else if (chess1.getName().charAt(0) == '红' && chessY1 <=330 && chess1.getName().charAt(0) != chess2.getName().charAt(0)){
				 chess2.setVisible(false);
				 chess1.setBounds(chessX2-half,chessY2-half,55,55);	
				 }
			 }
			
		 //向上或向下走吃棋
		 else if (chessX1 - chessX2 >=-5 && chessX1 - chessX2 <=5 && chessY1 - chessY2 >= -60 && chessY1 - chessY2 <= 60){
			 //黑棋不能向上吃棋
			 if (chess1.getName().charAt(0) == '黑' && chessY1 < chessY2 && chess1.getName().charAt(0) != chess2.getName().charAt(0)){
				 chess2.setVisible(false);
				 chess1.setBounds(chessX2-half,chessY2-half,55,55);
				 }
				
			 //红棋不能向下吃棋
			 else if (chess1.getName().charAt(0) == '红' && chessY1 > chessY2 && chess1.getName().charAt(0) != chess2.getName().charAt(0)){
				 chess2.setVisible(false);
				 chess1.setBounds(chessX2-half,chessY2-half,55,55);
				 }			
			 }
		 }
	 
	 
	 /** 炮,车移动规则   : 移动格数不受限制     */
	 public void cannonMoveRule(JLabel chesspiece[], JLabel chess, MouseEvent e){
		//获取当前棋子所在的位置
		 int chessX = chess.getX()+half;
		 int chessY = chess.getY()+half;
		 //获取鼠标点击的位置
		 int eX = e.getX();
		 int eY = e.getY();
		 
		 int Move=0;
		 
		//向上或下移动: 判断起点和终点间有没有棋子
		 if (chessX - eX >=-5 && chessX - eX <= 5){
			 for (int j=0;j<32;j++){
				 //找出在同一条竖线的所有棋子、并不包括自己
				 int pieceX=chesspiece[j].getX()+half;
				 int pieceY=chesspiece[j].getY()+half;
				 if (pieceX - chessX >=-5 && pieceX - chessX <=5 && chesspiece[j].getName()!=chess.getName() && chesspiece[j].isVisible()){
						//从起点到终点(从上到下)
						for (int k= chessY+60;k<eY;k+=60){
							//大于起点、小于终点的坐标就可以知道中间是否有棋子
							if (pieceY < eY && pieceY > chessY){
								//中间有一个棋子就不可以从这条竖线过去
								Move++;
								break;
								}
							}//for
						//从起点到终点(从下到上)
						for (int k=eY+60;k<chessY;k+=60){
							//找起点和终点的棋子
							if (pieceY > eY && chessY > pieceY ){
								Move++;
								break;
								}
							}//for
						}
				 }
			 //中间没有棋子，可以移动
//			 System.out.println();
//			 System.out.println(count+" "+eX+"  "+eY);
			 for(int i=90;i<=630;i+=60){
				 if (Move == 0 && (eY-i) >=-5 && (eY-i) <=5){
					 chess.setBounds(chessX-half,eY-half,55,55); 
					 break;
					 }
				 }
			 }
		 
		//向左或右移动: 判断起点和终点间有没有棋子
		 else if (chessY - eY >=-5 &&  chessY - eY <= 5){
			 for (int j=0;j<32;j++){
				 //找出在同一条线的所有棋子、并不包括自己
				 int pieceX=chesspiece[j].getX()+half;
				 int pieceY=chesspiece[j].getY()+half;
				 if (pieceY - chessY >=-5 && pieceY - chessY <=5 && chesspiece[j].getName()!=chess.getName() && chesspiece[j].isVisible()){
						//从起点到终点(从左到右)
						for (int k= chessX+60;k<eX;k+=60){
							//大于起点、小于终点的坐标就可以知道中间是否有棋子
							if (pieceX < eX && pieceX > chessX){
								//中间有一个棋子就不可以从这条线过去
								Move++;
								break;
								}
							}//for
						//从起点到终点(从右到左)
						for (int k=eX+60;k<chessX;k+=60){
							//找起点和终点的棋子
							if (pieceX > eX && pieceX < chessX){
								Move++;
								break;
								}
							}//for
						}
				 }
//			 System.out.println(count);
			 //中间没有棋子，可以移动
			 for(int i=70;i<=560;i+=60){
				 if (Move == 0 && (eX-i) >=-5 && (eX-i) <=5){
					 chess.setBounds(eX-half,chessY-half,55,55); 
					 break;
					 }
				 }
			 }		 
		 }
	 
	 /** 炮,车吃棋规则   */
	 public void cannonEatRule(JLabel chesspiece[], JLabel chess1, JLabel chess2){
		 int chessX1=chess1.getX()+half;
		 int chessY1=chess1.getY()+half;
		 int chessX2=chess2.getX()+half;
		 int chessY2=chess2.getY()+half;
//		 System.out.println(chessX1+"  "+chessY1);
//		 System.out.println(chessX2+"  "+chessY2);
		 int count = 0;
		 for (int j=0;j<32;j++){
			 int pieceX=chesspiece[j].getX()+half;
			 int pieceY=chesspiece[j].getY()+half;
			 /*   上下吃棋    */
			 if (pieceX - chessX1>=-5 && pieceX - chessX1<=5 && chesspiece[j].getName()!=chess1.getName() && chesspiece[j].isVisible()){
					//chess1起点(从上到下)
					for (int k=chessY1+60;k<chessY2;k+=60){
						if (chessY1 < chessY2 && pieceY > chessY1 && pieceY <chessY2){
								//计算起点和终点中间的棋子数
								count++;			
								break;							
						}
					}//for								
					//从下到上
					for (int k=chessY2+60;k<chessY1;k+=60){
						if (chessY2 < chessY1 && pieceY > chessY2 && pieceY <chessY1){
								count++;			
								break;							
						}
					}//for	
					
				}//if
			 
			 /*   左右吃棋     */
			 else if (pieceY - chessY1>=-5 &&  pieceY - chessY1<=5 && chesspiece[j].getName()!=chess1.getName() && chesspiece[j].isVisible()){
					//chess1起点(从左到右)
					for (int k=chessX1+60;k<chessX2;k+=60){
						if (chessX1 < chessX2 && pieceX > chessX1 && pieceX<chessX2){
								count++;			
								break;							
						}
					}//for								
					//从右到左
					for (int k=chessX2+60;k<chessX1;k+=60){
						if (chessX2 < chessX1 && pieceX > chessX2 && pieceX<chessX1){
								count++;			
								break;							
						}
					}//for	
				}//if	
			 }	
		    if(chessX1-chessX2>=-5 && chessX1-chessX2<=5 ||chessY1-chessY2>=-5 && chessY1-chessY2<=5){
			//车吃棋
			 if(chess1.getName().charAt(1)== '车' && count==0 && chess2.getName().charAt(0) != chess1.getName().charAt(0)){
				 chess2.setVisible(false);
				 chess1.setBounds(chessX2-half,chessY2-half,55,55);
			 }	 
			 //炮吃棋
			 else if(chess1.getName().charAt(1)== '炮'&& count==1 && chess2.getName().charAt(0) != chess1.getName().charAt(0)){
				 chess2.setVisible(false);
				 chess1.setBounds(chessX2-half,chessY2-half,55,55);
			 }
		    }		
	 }
	 
	 
	 /** 马移动规则 : 马跳日  ,8个方向  */
	 public void horseMoveRule(JLabel chesspiece[], JLabel chess, MouseEvent e){
		 //获取当前棋子所在的位置
		 int chessX = chess.getX()+half;
		 int chessY = chess.getY()+half;
//		 System.out.println(chessX + " " + chessY);
		 //获取鼠标点击的位置
		 int eX = e.getX();
		 int eY = e.getY();
//		 System.out.println(eX + " " + eY);
		 
		 int Move=0;			
		 boolean tag=false;
		 /* 上移、左边（向上移动两格，左一格） */
		 if (chessX - eX >= 55 && chessX - eX <= 65 && chessY - eY >= 115 && chessY - eY <= 125){
			//正前方是否有别的棋子
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessX - pieceX>=-5 && chessX - pieceX<=5 && chessY - pieceY >=55 && chessY - pieceY <= 65){
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			}
		 
		 /*  上移、右边   */
		 else if (eX - chessX >= 55 && eX - chessX <= 65 && chessY - eY >= 115 && chessY -eY <= 125){

			 System.out.println(Move);
			 //正前方是否有别的棋子
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessX - pieceX>=-5 && chessX - pieceX<=5 && chessY - pieceY >=55 && chessY - pieceY <= 65){
					 Move = 1;
					 break;
					 }
				 } 
			 tag=true;
			 }
			
		 /* 左移、上边 */
		 else if (chessX - eX >= 115 && chessX - eX <= 125 && chessY - eY >= 55 && chessY -eY <= 65){
			//正前方是否有别的棋子
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessY - pieceY>=-5 && chessY - pieceY<=5 && chessX - pieceX >=55 && chessX - pieceX <= 65){
					 Move = 1;
					 break;
					 }
				 } 
			 tag=true;
			}
		 
		 
		 /*  右移、上边   */
		 else if (eX-chessX >= 115 && eX-chessX<= 125 && chessY - eY >= 55 && chessY - eY <= 65){
			 //正前方是否有别的棋子
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessY - pieceY>=-5 && chessY - pieceY<=5 && pieceX - chessX >=55 && pieceX - chessX <= 65){
//					 System.out.println(pieceX+" "+pieceY);
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			 }		 
		 
		 /* 下移、左边  */
		 else if (chessX - eX >= 55 && chessX - eX <= 65 && eY - chessY>= 115 && eY - chessY <= 125){
			//正前方是否有别的棋子
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessX - pieceX>=-5 && chessX - pieceX<=5 && pieceY - chessY>=55 && pieceY - chessY <= 65){
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			}
		 
		 /*  下移、右边   */
		 else if (eX - chessX >= 55 && eX - chessX <= 65 && eY - chessY >= 115 && eY - chessY <= 125){

			 System.out.println(Move);
			 //正前方是否有别的棋子
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessX - pieceX>=-5 && chessX - pieceX<=5 && pieceY - chessY>=55 && pieceY - chessY <= 65){
					 Move = 1;
					 break;
					 }
				 } 		
			 tag=true;
			 }
			
		 /* 左移、下边 */
		 else if (chessX - eX >= 115 && chessX - eX <= 125 && eY - chessY>= 55 && eY - chessY <= 65){
			//正前方是否有别的棋子
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessY - pieceY>=-5 && chessY - pieceY<=5 && chessX - pieceX >=55 && chessX - pieceX <= 65){
					 Move = 1;
					 break;
					 }
				 } 
			 tag=true;
			}
		 
		 /*  右移、下边   */
		 else if (eX - chessX >= 115 && eX - chessX <= 125 && eY - chessY >= 55 && eY - chessY <= 65){
			 //正前方是否有别的棋子
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessX - pieceX>=-5 && chessY - pieceY>=-5 && pieceX - chessX >=55 && pieceX - chessX <= 65){
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			 }
			
		 //可以移动该棋子
		 if (Move == 0 && tag){
			 chess.setBounds(eX-half,eY-half,55,55);
			 }
			
		}

	 
	 /**  马吃棋规则    */
	 public void horseEatRule(JLabel chesspiece[], JLabel chess1, JLabel chess2){
		 int chessX1=chess1.getX()+half;
		 int chessY1=chess1.getY()+half;
		 int chessX2=chess2.getX()+half;
		 int chessY2=chess2.getY()+half;
//		 System.out.println(chessX1 + " " + chessY1);
//		 System.out.println(chessX2 + " " + chessY2);
		 
		 int Move=0;			
		 boolean tag=false;
		 
		 /* 上移、左边（向上移动两格，左一格） */
		 if (chessX1 - chessX2 >= 55 && chessX1 - chessX2 <= 65 && chessY1 - chessY2 >= 115 && chessY1 - chessY2 <= 125){
			//正前方是否有别的棋子
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessX1 - pieceX>=-5 && chessX1 - pieceX<=5 && chessY1 - pieceY >=55 && chessY1 - pieceY <= 65){
					 Move = 1;
					 break;
					 }
				 } 		
			 tag=true;
			}
		 
		 /*  上移、右边   */
		 else if (chessX2 - chessX1 >= 55 && chessX2 - chessX1 <= 65 && chessY1 - chessY2 >= 115 && chessY1 -chessY2 <= 125){
			 //正前方是否有别的棋子
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessX1 - pieceX>=-5 && chessX1 - pieceX<=5 && chessY1 - pieceY >=55 && chessY1 - pieceY <= 65){
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			 }
			
		 /* 左移、上边 */
		 else if (chessX1 - chessX2 >= 115 && chessX1 - chessX2 <= 125 && chessY1 - chessY2 >= 55 && chessY1 -chessY2 <= 65){
			//正前方是否有别的棋子
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessY1 - pieceY>=-5 && chessY1 - pieceY<=5 && chessX1 - pieceX >=55 && chessX1 - pieceX <= 65){
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			}
		 
		 
		 /*  右移、上边   */
		 else if (chessX2-chessX1 >= 115 && chessX2-chessX1<= 125 && chessY1 - chessY2 >= 55 && chessY1 - chessY2 <= 65){
			 //正前方是否有别的棋子
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessY1 - pieceY>=-5 && chessY1 - pieceY<=5 && pieceX - chessX1 >=55 && pieceX - chessX1 <= 65){
					 System.out.println(pieceX+" "+pieceY);
					 Move = 1;
					 break;
					 }
				 } 
			 tag=true;
			 }		 
		 
		 /* 下移、左边  */
		 else if (chessX1 - chessX2 >= 55 && chessX1 - chessX2 <= 65 && chessY2 - chessY1>= 115 && chessY2 - chessY1 <= 125){
			//正前方是否有别的棋子
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessX1 - pieceX>=-5 && chessX1 - pieceX<=5 && pieceY - chessY1>=55 && pieceY - chessY1 <= 65){
					 Move = 1;
					 break;
					 }
				 }
			 tag=true;
			}
		 
		 /*  下移、右边   */
		 else if (chessX2 - chessX1 >= 55 && chessX2 - chessX1 <= 65 && chessY2 - chessY1 >= 115 && chessY2 - chessY1 <= 125){

			 System.out.println(Move);
			 //正前方是否有别的棋子
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessX1 - pieceX>=-5 && chessX1 - pieceX<=5 && pieceY - chessY1>=55 && pieceY - chessY1 <= 65){
					 Move = 1;
					 break;
					 }
				 } 
			 tag=true;
			 }
			
		 /* 左移、下边 */
		 else if (chessX1 - chessX2 >= 115 && chessX1 - chessX2 <= 125 && chessY2 - chessY1>= 55 && chessY2 - chessY1 <= 65){
			//正前方是否有别的棋子
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessY1 - pieceY>=-5 && chessY1 - pieceY<=5 && chessX1 - pieceX >=55 && chessX1 - pieceX <= 65){
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			}
		 
		 /*  右移、下边   */
		 else if (chessX2 - chessX1 >= 115 && chessX2 - chessX1 <= 125 && chessY2 - chessY1 >= 55 && chessY2 - chessY1 <= 65){
			 //正前方是否有别的棋子
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessX1 - pieceX>=-5 && chessY1 - pieceY>=-5 && pieceX - chessX1 >=55 && pieceX - chessX1 <= 65){
					 Move = 1;
					 break;
					 }
				 } 
			 tag=true;
			 }
		 
		 //吃棋
//		 
		 if(tag && Move==0 && chess1.getName().charAt(0)!= chess2.getName().charAt(0)){
			 //System.out.println(Move);
			 chess2.setVisible(false);
			 chess1.setBounds(chessX2-half,chessY2-half, 55, 55);
		 }
		 
	 }
	 
	 
	 /** 相（象）移动规则   : 象飞田，且仅限于本部内 */
	 public void elephantMoveRule(JLabel chesspiece[], JLabel chess, MouseEvent e){
		 //获取当前棋子所在的位置
		 int chessX = chess.getX()+half;
		 int chessY = chess.getY()+half;
//		 System.out.println(chessX + " " + chessY);
		 //获取鼠标点击的位置
		 int eX = e.getX();
		 int eY = e.getY();
//		 System.out.println(eX + " " + eY);
		 
		 int Move=0;			
		 boolean tag=false;
		 /* 上移、左边（向上移动两格，左两格） */
		 if (chessX - eX >= 115 && chessX - eX <= 125 && chessY - eY >= 115 && chessY - eY <= 125){
			//对角线处是否有棋子
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessX - pieceX>=55 && chessX - pieceX<=65 && chessY - pieceY >=55 && chessY - pieceY <= 65){
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			}
		 
		 /* 上移、左边   */
		 else if (eX - chessX >= 115 && eX - chessX <= 125 && chessY - eY >= 115 && chessY - eY <= 125){
			 //对角线处是否有棋子
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && pieceX - chessX>=55 && pieceX - chessX<=65 && chessY - pieceY >=55 && chessY - pieceY <= 65){
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			 }
		 
		 /* 下移、右边   */
		 else if (eX - chessX >= 115 && eX - chessX<= 125 && eY - chessY >= 115 && eY - chessY <= 125){
			 //对角线处是否有棋子
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessX - pieceX>=55 && chessX - pieceX<=65 && pieceY - chessY >=55 && pieceY - chessY<= 65){
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			 }
		 
		 /* 下移、左边   */
		 else if (chessX - eX >= 115 && chessX - eX <= 125 && eY - chessY >= 115 && eY - chessY <= 125){
			 //对角线处是否有棋子
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && pieceX - chessX>=55 && pieceX - chessX<=65 && pieceY - chessY >=55 && pieceY - chessY<= 65){
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			 }
		 
//		 System.out.println(Move+" "+tag);
		 //黑棋
		 if(chess.getName().charAt(0)=='黑' && eY<=335 && tag && Move==0){			 
			 chess.setBounds(eX-half, eY-half, 55, 55);
		 }
		//红棋
		 if(chess.getName().charAt(0)=='红' && eY>=395 && tag && Move==0){
			 chess.setBounds(eX-half, eY-half, 55, 55);
		 }
	 }
	 

	 /** 相（象）吃棋规则   */
	 public void elephantEatRule(JLabel chesspiece[], JLabel chess1, JLabel chess2){
		 //获取棋子所在的位置
		 int chessX1=chess1.getX()+half;
		 int chessY1=chess1.getY()+half;
		 int chessX2=chess2.getX()+half;
		 int chessY2=chess2.getY()+half;
		 
		 int Move=0;			
		 boolean tag=false;
		 /* 上移、左边（向上移动两格，左两格） */
		 if (chessX1 - chessX2 >= 115 && chessX1 - chessX2 <= 125 && chessY1 - chessY2 >= 115 && chessY1 - chessY2 <= 125){
			//对角线处是否有棋子
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessX1 - pieceX>=55 && chessX1 - pieceX<=65 && chessY1 - pieceY >=55 && chessY1 - pieceY <= 65){
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			}
		 
		 /* 上移、左边   */
		 else if (chessX2 - chessX1 >= 115 && chessX2 - chessX1 <= 125 && chessY1 - chessY2 >= 115 && chessY1 - chessY2 <= 125){
			 //对角线处是否有棋子
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && pieceX - chessX1>=55 && pieceX - chessX1<=65 && chessY1 - pieceY >=55 && chessY1 - pieceY <= 65){
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			 }
		 
		 /* 下移、右边   */
		 else if (chessX2 - chessX1 >= 115 && chessX2 - chessX1<= 125 && chessY2 - chessY1 >= 115 && chessY2 - chessY1 <= 125){
			 //对角线处是否有棋子
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && chessX1 - pieceX>=55 && chessX1 - pieceX<=65 && pieceY - chessY1 >=55 && pieceY - chessY1<= 65){
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			 }
		 
		 /* 下移、左边   */
		 else if (chessX1 - chessX2 >= 115 && chessX1 - chessX2 <= 125 && chessY2 - chessY1 >= 115 && chessY2 - chessY1 <= 125){
			 //对角线处是否有棋子
			 for (int i=0;i<32;i++){
				 int pieceX=chesspiece[i].getX()+half;
				 int pieceY=chesspiece[i].getY()+half;
				 if (chesspiece[i].isVisible() && pieceX - chessX1>=55 && pieceX - chessX1<=65 && pieceY - chessY1 >=55 && pieceY - chessY1<= 65){
					 Move = 1;
					 break;
					 }
				 } 	
			 tag=true;
			 }
		 
//		 System.out.println(Move+" "+tag);
//		 System.out.println(chess1.getName().charAt(0)+" "+ chess2.getName().charAt(0));
		 //黑棋
		 if((chess1.getName().charAt(0)!= chess2.getName().charAt(0)) && chess1.getName().charAt(0)=='黑' && chessY2<=335 && tag && Move==0){
			 chess2.setVisible(false);
			 chess1.setBounds(chessX2-half, chessY2-half, 55, 55);
		 }
		//红棋
		 else if(chess1.getName().charAt(0)!= chess2.getName().charAt(0) && chess1.getName().charAt(0)=='红' && chessY2>=395 && tag && Move==0){
			 chess2.setVisible(false);
			 chess1.setBounds(chessX2-half, chessY2-half, 55, 55);
		 }
	 }
	 
	 
	 /** 士移动规则  : 九宫内斜线行走，口字型 */
	 public void officerMoveRule(JLabel chess, MouseEvent e){
		 //获取当前棋子所在的位置
		 int chessX = chess.getX()+half;
		 int chessY = chess.getY()+half;
//		 System.out.println(chessX + " " + chessY);
		 //获取鼠标点击的位置
		 int eX = e.getX();
		 int eY = e.getY();
//		 System.out.println(eX + " " + eY);
		 
		 boolean tag=false;
		 /* 左上（向上移动一格，左一格） */
		 if (chessX - eX >= 55 && chessX - eX <= 65 && chessY - eY >= 55 && chessY - eY <= 65){
			 tag=true;
			}
		 
		 /* 右上  */
		 else if (eX - chessX >= 55 && eX - chessX <= 65 && chessY - eY >= 55 && chessY - eY <= 65){
			 tag=true;
			 }
		 
		 /* 右下  */
		 else if (eX - chessX >= 55 && eX - chessX<= 65 && eY - chessY >= 55 && eY - chessY <= 65){
			 tag=true;
			 }
		 
		 /* 左下  */
		 else if (chessX - eX >= 55 && chessX - eX <= 65 && eY - chessY >= 55 && eY - chessY <= 65){
			 tag=true;
			 }
		 
		 //黑棋
		 if(chess.getName().charAt(0)=='黑' && eX>=245 && eX<=375 && eY>=85 && eY<=205 && tag){			 
			 chess.setBounds(eX-half, eY-half, 55, 55);
		 }
		//红棋
		 if(chess.getName().charAt(0)=='红' && eX>=245 && eX<=375 && eY>=505 && eY<=635 && tag){
			 chess.setBounds(eX-half, eY-half, 55, 55);
		 }		 
	 }
	 
	 /** 士吃棋规则   */
	 public void officerEatRule(JLabel chess1, JLabel chess2){
		 //获取当前棋子所在的位置
		 int chessX1=chess1.getX()+half;
		 int chessY1=chess1.getY()+half;
		 int chessX2=chess2.getX()+half;
		 int chessY2=chess2.getY()+half;
		 
		 boolean tag=false;
		 /* 左上（向上移动一格，左一格） */
		 if (chessX1 - chessX2 >= 55 && chessX1 - chessX2 <= 65 && chessY1 - chessY2 >= 55 && chessY1 - chessY2 <= 65){
			 tag=true;
			}
		 
		 /* 右上  */
		 else if (chessX2 - chessX1 >= 55 && chessX2 - chessX1 <= 65 && chessY1 - chessY2 >= 55 && chessY1 - chessY2 <= 65){
			 tag=true;
			 }
		 
		 /* 右下  */
		 else if (chessX2 - chessX1 >= 55 && chessX2 - chessX1<= 65 && chessY2 - chessY1 >= 55 && chessY2 - chessY1 <= 65){
			 tag=true;
			 }
		 
		 /* 左下  */
		 else if (chessX1 - chessX2 >= 55 && chessX1 - chessX2 <= 65 && chessY2 - chessY1 >= 55 && chessY2 - chessY1 <= 65){
			 tag=true;
			 }
		 
		 //黑棋
		 if(chess1.getName().charAt(0)!= chess2.getName().charAt(0) && chess1.getName().charAt(0)=='黑'
				 && chessX2>=245 && chessX2<=375 && chessY2>=85 && chessY2<=205 && tag){	
			 chess2.setVisible(false);
			 chess1.setBounds(chessX2-half, chessY2-half, 55, 55);
		 }
		//红棋
		 if(chess1.getName().charAt(0)!= chess2.getName().charAt(0) && chess1.getName().charAt(0)=='红' 
				 && chessX2>=245 && chessX2<=375 && chessY2>=505 && chessY2<=635 && tag){
			 chess2.setVisible(false);
			 chess1.setBounds(chessX2-half, chessY2-half, 55, 55);
		 }		 
	 }
	 
	 
	 /** 将，帅移动规则  : 九宫内直线行走一格 */
	 public void chiefMoveRule(JLabel chess, MouseEvent e){
		 //获取当前棋子所在的位置
		 int chessX = chess.getX()+half;
		 int chessY = chess.getY()+half;
//		 System.out.println(chessX + " " + chessY);
		 //获取鼠标点击的位置
		 int eX = e.getX();
		 int eY = e.getY();
//		 System.out.println(eX + " " + eY);
		 
		 boolean tag=false;
		 /* 上  */
		 if (chessX - eX >= -5 && chessX - eX <= 5 && chessY - eY >= 55 && chessY - eY <= 65){
			 tag=true;
			}
		 
		 /* 下 */
		 else if (eX - chessX >= -5 && eX - chessX <= 5 && eY - chessY>= 55 && eY - chessY <= 65){
			 tag=true;
			 }
		 
		 /* 左  */
		 else if (chessX - eX >= 55 && chessX - eX <= 65 && eY - chessY >= -5 && eY - chessY <= 5){
			 tag=true;
			 }
		 
		 /* 右  */
		 else if (eX - chessX >= 55 && eX - chessX<= 65 && eY - chessY >= -5 && eY - chessY <= 5){
			 tag=true;
			 }		
		 
		 //黑棋
		 if(chess.getName().charAt(0)=='黑' && eX>=245 && eX<=375 && eY>=85 && eY<=205 && tag){			 
			 chess.setBounds(eX-half, eY-half, 55, 55);
		 }
		//红棋
		 if(chess.getName().charAt(0)=='红' && eX>=245 && eX<=375 && eY>=505 && eY<=635 && tag){
			 chess.setBounds(eX-half, eY-half, 55, 55);
		 }		 
	 }
	 
	 /** 将，帅移动规则  : 九宫内直线行走一格 */
	 public void chiefEatRule(JLabel chess1, JLabel chess2){
		 //获取当前棋子所在的位置
		 int chessX1=chess1.getX()+half;
		 int chessY1=chess1.getY()+half;
		 int chessX2=chess2.getX()+half;
		 int chessY2=chess2.getY()+half;
		 
		 
		 boolean tag=false;
		 /* 上  */
		 if (chessX1 - chessX2 >= -5 && chessX1 - chessX2 <= 5 && chessY1 - chessY2 >= 55 && chessY1 - chessY2 <= 65){
			 tag=true;
			}
		 
		 /* 下 */
		 else if (chessX2 - chessX1 >= -5 && chessX2 - chessX1 <= 5 && chessY2 - chessY1>= 55 && chessY2 - chessY1 <= 65){
			 tag=true;
			 }
		 
		 /* 左  */
		 else if (chessX1 - chessX2 >= 55 && chessX1 - chessX2 <= 65 && chessY2 - chessY1 >= -5 && chessY2 - chessY1 <= 5){
			 tag=true;
			 }
		 
		 /* 右  */
		 else if (chessX2 - chessX1 >= 55 && chessX2 - chessX1<= 65 && chessY2 - chessY1 >= -5 && chessY2 - chessY1 <= 5){
			 tag=true;
			 }		
		 
		 //黑棋
		 if(chess1.getName().charAt(0)!= chess2.getName().charAt(0) && chess1.getName().charAt(0)=='黑' 
				 && chessX2>=245 && chessX2<=375 && chessY2>=85 && chessY2<=205 && tag){	
			 chess2.setVisible(false);
			 chess1.setBounds(chessX2-half, chessY2-half, 55, 55);
		 }
		//红棋
		 if(chess1.getName().charAt(0)!= chess2.getName().charAt(0) && chess1.getName().charAt(0)=='红' 
				 && chessX2>=245 && chessX2<=375 && chessY2>=505 && chessY2<=635 && tag){
			 chess2.setVisible(false);
			 chess1.setBounds(chessX2-half, chessY2-half, 55, 55);
		 }		 
	 }
}

