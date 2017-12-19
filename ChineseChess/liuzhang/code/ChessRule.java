package lz.ChineseChess;

import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public class ChessRule {
	//黑卒、红兵移动规则,根据实际移动的像素距离的范围确定移动到的点
	public void soldiesMoveRule(int i,JLabel chess,MouseEvent me){
		//黑卒
		if(i>10 && i<16){
			//向下
			if((me.getY()-chess.getY()) > 27 
					&& (me.getY()-chess.getY()) < 86 
					&& (me.getX()-chess.getX()) < 55 
					&& (me.getX()-chess.getX() > 0)){
				chess.setBounds(chess.getX(),chess.getY()+57,55,55);
			}//黑卒向右，必须过河
			else if(chess.getY()>284 
					&& (me.getX()-chess.getX()) >= 57 
					&&(me.getX()-chess.getY()) <= 112){
				chess.setBounds(chess.getX()+57, chess.getY(), 55, 55);
			}//黑卒向左，必须过河
			else if(chess.getY()>284 
					&& (chess.getX()-me.getX()) >= 2 
					&& (chess.getX()-me.getX()) <= 58){
				chess.setBounds(chess.getX()-57, chess.getY(), 55, 55);
			}
		}
		
		//红兵
		else if(i>26 && i<32){
			//向上
			if((chess.getY()-me.getY())>27 
					&& (chess.getY()-me.getY()) < 86 
					&& (me.getX()-chess.getX()) >= 0 
					&& (me.getX()-chess.getX()) <= 55 ){
				chess.setBounds(chess.getX(), chess.getY()-57, 55, 55);
			}//红兵向右，必须过河
			else if(chess.getY()<341 
					&& (me.getX()-chess.getX()) >= 57 
					&&(me.getX()-chess.getY()) <= 112){
				chess.setBounds(chess.getX()+57, chess.getY(), 55, 55);
			}//红兵向左，必须过河
			else if(chess.getY()<341 
					&& (chess.getX()-me.getX()) >= 2 
					&& (chess.getX()-me.getX()) <= 58){
				chess.setBounds(chess.getX()-57, chess.getY(), 55, 55);
			}
		}	
	}
	
	///黑卒、红兵吃规则
	public void soldiesKillRule(JLabel chess1, JLabel chess2){
		//向右吃棋
		if ((chess2.getX()-chess1.getX()) <= 112 
				&& (chess2.getX()-chess1.getX()) >= 57 
				&& (chess1.getY() - chess2.getY()) < 22 
				&& (chess1.getY() - chess2.getY()) > -22 
				&& chess2.isVisible() 
				&& chess1.getName().charAt(0)!=chess2.getName().charAt(0)){
			//黑棋过河向右吃棋
			if (chess1.getName().charAt(0) == '黑' 
					&& chess1.getY() > 284 
					&& chess1.getName().charAt(0)!=chess2.getName().charAt(0)){
				//是被吃的棋子“消失”，让后让吃棋的棋放到被吃的棋子的位置
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(),chess2.getY(),55,55);
			}//红棋过河向右吃黑棋
			else if (chess1.getName().charAt(0) == '红' 
					&& chess1.getY() < 341 
					&& chess1.getName().charAt(0) != chess2.getName().charAt(0)){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(),chess2.getY(),55,55);				
			}
		}
		//向左吃棋子
		else if ((chess1.getX()-chess2.getX()) <= 112 
				&& (chess1.getX()-chess2.getX()) >= 57 
				&& (chess1.getY()-chess2.getY()) < 22 
				&& (chess1.getY()-chess2.getY()) > -22 
				&& chess2.isVisible() && chess1.getName().charAt(0)!=chess2.getName().charAt(0)){
			//黑棋要过河才能左吃红棋
			if (chess1.getName().charAt(1) == '黑' 
					&& chess1.getY() > 284 
					&& chess1.getName().charAt(0) != chess2.getName().charAt(0)){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(),chess2.getY(),55,55);
			}
			
			//红棋要过河才能左吃棋
			else if (chess1.getName().charAt(0) == '红' 
					&& chess1.getY() < 341 
					&& chess1.getName().charAt(0) != chess2.getName().charAt(0)){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(),chess2.getY(),55,55);				
			}
		}
		//黑棋向下吃红棋，红棋向上吃黑棋
		else if (chess1.getX() - chess2.getX() >= -22 
				&& chess1.getX() - chess2.getX() <= 22 
				&& chess1.getY() - chess2.getY() >= -112 
				&& chess1.getY() - chess2.getY() <= 112){
			//黑棋向下吃红棋
			if (chess1.getName().charAt(1) == '黑' 
					&& chess1.getY() < chess2.getY() 
					&& chess1.getName().charAt(0) != chess2.getName().charAt(0)){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(),chess2.getY(),55,55);
			}
			
			//红棋向上吃黑棋
			else if (chess1.getName().charAt(1) == '红' 
					&& chess1.getY() > chess2.getY() 
					&& chess1.getName().charAt(0) != chess2.getName().charAt(0)){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(),chess2.getY(),55,55);
			}	
		}
	}
}
