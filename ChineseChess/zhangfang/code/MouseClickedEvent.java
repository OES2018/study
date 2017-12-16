
/**
 * 鼠标点击事件
 *
 */

package zf.chinesechess;

import java.awt.event.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class MouseClickedEvent implements MouseListener{
    ChessRule rule;
    Object[] para;//保存参数，用于返回

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub		
	}
	
	public Object[] mouseClicked(MouseEvent e, ChessPiece chess, JLabel hint, int index, int chessClick, boolean isClick)
	{
		para = new Object[3];
		rule = new ChessRule();
		
		//棋子的位置
		int chessX,chessY;;
		
		//点击点的位置
		int eX=e.getX();
		int eY=e.getY();
		
		/**   单击棋盘(移动棋子)  */
		if (!(e.getSource()instanceof JLabel)){
			/*  该红棋走棋的时候   */
			System.out.println("点击棋盘");
			if (chessClick == 2 && chess.chesspiece[index].getName().charAt(0) == '红'){		
				chessX = chess.chesspiece[index].getX();
				chessY = chess.chesspiece[index].getY();
				//移动卒、兵
				if (index > 15 && index < 26){
					rule.soldierMoveRule(chess.chesspiece[index],e);
				}			
				
				//移动炮
				else if (index > 25 && index < 30){			
					rule.cannonMoveRule(chess.chesspiece, chess.chesspiece[index],e);
				}
				
				//移动车
				else if (index >=0 && index < 4){
					rule.cannonMoveRule(chess.chesspiece, chess.chesspiece[index],e);
				}
				
				//移动马
				else if (index > 3 && index < 8){
					rule.horseMoveRule(chess.chesspiece, chess.chesspiece[index],e);
				}
				
				//移动相、象
				else if (index > 7 && index < 12){
					rule.elephantMoveRule(chess.chesspiece, chess.chesspiece[index],e);
				}
				
				//移动仕、士
				else if (index > 11 && index < 16){
					rule.officerMoveRule(chess.chesspiece[index],e);
				}
				
				//移动将、帅
				else if (index == 30 || index == 31){				
					rule.chiefMoveRule(chess.chesspiece[index],e);
				}
				
				//是否走棋错误(是否在原地没有动)
				if (chessX==chess.chesspiece[index].getX() && chessY==chess.chesspiece[index].getY()){
					hint.setText("     红棋走棋");
					chessClick=2;
				}
				
				else {
					hint.setText("     黑棋走棋");
					chessClick=1;
				}					
				isClick=false;
			}//if
			
			/*  该黑棋走棋的时候   */
			else if (chessClick == 1 && chess.chesspiece[index].getName().charAt(0) == '黑'){
				chessX = chess.chesspiece[index].getX();
				chessY = chess.chesspiece[index].getY();
				//移动卒、兵
				if (index > 15 && index < 26){
					rule.soldierMoveRule(chess.chesspiece[index],e);
					}

				//移动炮
				else if (index > 25 && index < 30){
					rule.cannonMoveRule(chess.chesspiece, chess.chesspiece[index],e);
					}
				
				//移动车
				else if (index >=0 && index < 4){
					rule.cannonMoveRule(chess.chesspiece, chess.chesspiece[index],e);
					}
				
				//移动马
				else if (index > 3 && index < 8){
					rule.horseMoveRule(chess.chesspiece, chess.chesspiece[index],e);
					}
					
				//移动相、象
				else if (index > 7 && index < 12){
					rule.elephantMoveRule(chess.chesspiece, chess.chesspiece[index],e);
					}
					
				//移动仕、士
				else if (index > 11 && index < 16){
					rule.officerMoveRule(chess.chesspiece[index],e);
					}
					
				//移动将、帅
				else if (index == 30 || index == 31){
					rule.chiefMoveRule(chess.chesspiece[index],e);
					}
					
				//是否走棋错误(是否在原地没有动)
				if (chessX==chess.chesspiece[index].getX() && chessY==chess.chesspiece[index].getY()){
					hint.setText("     黑棋走棋");
					chessClick=1;
					}
				
				else {
					hint.setText("     红棋走棋");
					chessClick=2;
					}					
			}//else if		
			isClick=false;
		}//if
		
		/**  单击棋子     */
		else{			
			//第一次单击棋子(闪烁棋子)
			if (!isClick){
				System.out.println("第一次点击棋子");
				int i;
				for (i=0;i<32;i++){					
					//被单击的棋子
					if (e.getSource().equals(chess.chesspiece[i])){
						//告诉线程让该棋子闪烁
						//当前该红棋走,你点击的也是红棋
						if(chessClick==2 && chess.chesspiece[i].getName().charAt(0)=='红'){
							index=i;
							//开始闪烁
							isClick=true;
						}
						else if(chessClick==1 && chess.chesspiece[i].getName().charAt(0)=='黑'){
							index=i;
							//开始闪烁
							isClick=true;
						}
						break;
					}
				}//for
			//	System.out.println(e.getSource().equals(chess.chesspiece[i])+" "+1);
			}//if				
			
			//第二次单击棋子(吃棋子)
			else if (isClick){
				System.out.println("第二次点击棋子");
				for (int i=0;i<32;i++){
					//找到被吃的棋子
					//System.out.println(e.getSource().equals(chess.chesspiece[i])+" "+2);
					if (e.getSource().equals(chess.chesspiece[i])){						
					//	System.out.println(e.getSource().equals(chess.chesspiece[i])+" "+isClick);
						//该红棋吃棋的时候
						if (chessClick == 2 && chess.chesspiece[index].getName().charAt(0) == '红'){
							chessX = chess.chesspiece[index].getX();
							chessY = chess.chesspiece[index].getY();							
							//卒、兵吃规则
							if (index > 15 && index < 26){
								rule.soliderEatRule(chess.chesspiece[index],chess.chesspiece[i]);
							}
							
							//炮吃规则
							else if (index > 25 && index < 30){
								rule.cannonEatRule(chess.chesspiece,chess.chesspiece[index],chess.chesspiece[i]);
							}
							
							//车吃规则
							else if (index >=0 && index < 4){
								rule.cannonEatRule(chess.chesspiece,chess.chesspiece[index],chess.chesspiece[i]);
							}
							
							//马吃规则
							else if (index > 3 && index < 8){
								rule.horseEatRule(chess.chesspiece,chess.chesspiece[index],chess.chesspiece[i]);	
							}
							
							//相、象吃规则
							else if (index > 7 && index < 12){
								rule.elephantEatRule(chess.chesspiece,chess.chesspiece[index],chess.chesspiece[i]);
							}
							
							//士、仕吃棋规则
							else if (index > 11 && index < 16){
								rule.officerEatRule(chess.chesspiece[index],chess.chesspiece[i]);
							}
							
							//将、帅吃棋规则
							else if (index == 30 || index == 31){
								rule.chiefEatRule(chess.chesspiece[index],chess.chesspiece[i]);
								chess.chesspiece[index].setVisible(true);	
							}
							
							//是否走棋错误(是否在原地没有动)
							if (chessX==chess.chesspiece[index].getX() && chessY==chess.chesspiece[index].getY()){
								hint.setText("     红棋走棋");
								chessClick=2;
								}
							
							else {
								hint.setText("     黑棋走棋");
								chessClick=1;
								}
							
						}//if
						
						//该黑棋吃棋的时候
						else if (chessClick == 1 && chess.chesspiece[index].getName().charAt(0) == '黑'){
							chessX = chess.chesspiece[index].getX();
							chessY = chess.chesspiece[index].getY();							
							//卒、兵吃规则
							if (index > 15 && index < 26){
								rule.soliderEatRule(chess.chesspiece[index],chess.chesspiece[i]);
							}
							
							//炮吃规则
							else if (index > 25 && index < 30){
								rule.cannonEatRule(chess.chesspiece,chess.chesspiece[index],chess.chesspiece[i]);
							}
							
							//车吃规则
							else if (index >=0 && index < 4){
								rule.cannonEatRule(chess.chesspiece,chess.chesspiece[index],chess.chesspiece[i]);
							}
							
							//马吃规则
							else if (index > 3 && index < 8){
								rule.horseEatRule(chess.chesspiece,chess.chesspiece[index],chess.chesspiece[i]);	
							}
							
							//相、象吃规则
							else if (index > 7 && index < 12){
								rule.elephantEatRule(chess.chesspiece,chess.chesspiece[index],chess.chesspiece[i]);
							}
							
							//士、仕吃棋规则
							else if (index > 11 && index < 16){
								rule.officerEatRule(chess.chesspiece[index],chess.chesspiece[i]);
							}
							
							//将、帅吃棋规则
							else if (index == 30 || index == 31){
								rule.chiefEatRule(chess.chesspiece[index],chess.chesspiece[i]);
								chess.chesspiece[index].setVisible(true);	
							}
							
							//是否走棋错误(是否在原地没有动)
							if (chessX==chess.chesspiece[index].getX() && chessY==chess.chesspiece[index].getY()){
								hint.setText("     黑棋走棋");
								chessClick=1;
								}
							
							else {
								hint.setText("     红棋走棋");
								chessClick=2;
								}
							
						}//else if

						//当前没有操作(停止闪烁)
						isClick=false;
					}//if
					
				}//for
				
				
				//是否胜利
				if (!chess.chesspiece[31].isVisible()){
					JOptionPane.showConfirmDialog(
						null,"黑棋胜利","恭喜！",
						JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
					//双方都不可以在走棋了
					chessClick=3;
//					text.setText("  黑棋胜利");
					
				}//if 

				else if (!chess.chesspiece[30].isVisible()){
					JOptionPane.showConfirmDialog(
						null,"红棋胜利","恭喜！",
						JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
					chessClick=3;
//					text.setText("  红棋胜利");
				}//else if					
			}//else			
		}//else		
		para[0]=index;
		para[1]=chessClick;
		para[2]=isClick;
		return para;
		
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
