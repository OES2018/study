package zh;

import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public class ChessRule {

	//定义卒子移动规则
	public void armsRule(int Man, JLabel play, MouseEvent me) {
		//黑卒向下，每一隔的大小是57像素
		if (Man < 21){
			//向下移动、得到终点的坐标模糊成合法的坐标
			if ((me.getY()-play.getY()) > 27 && (me.getY()-play.getY()) < 86 && (me.getX()-play.getX()) < 55 && (me.getX()-play.getX()) > 0){
				play.setBounds(play.getX(),play.getY()+57,55,55);
			}
			
			//向右移动、得到终点的坐标模糊成合法的坐标、必须过河				
			else if (play.getY() > 284 && (me.getX() - play.getX()) >= 57 && (me.getX() - play.getX()) <= 112){
				play.setBounds(play.getX()+57,play.getY(),55,55);	
			}
			
			//向左移动、得到终点的坐标模糊成合法的坐标、必须过河
			else if (play.getY() > 284 && (play.getX() - me.getX()) >= 2 && (play.getX() - me.getX()) <=58){
				//模糊坐标
				play.setBounds(play.getX()-57,play.getY(),55,55);
			}
		}
		
		//红卒向上，每一隔的大小是57像素
		else{
			
			//向上移动、得到终点的坐标模糊成合法的坐标
			if ((me.getX()-play.getX()) >= 0 && (me.getX()-play.getX()) <= 55 && (play.getY()-me.getY()) >27 && play.getY()-me.getY() < 86){
				play.setBounds(play.getX(),play.getY()-57,55,55);
			}
			
			//向右移动、得到终点的坐标模糊成合法的坐标、必须过河
			else if (play.getY() <= 341 && (me.getX() - play.getX()) >= 57 && (me.getX() - play.getX()) <= 112){
				play.setBounds(play.getX()+57,play.getY(),55,55);
			}				
			
			//向左移动、得到终点的坐标模糊成合法的坐标、必须过河
			else if (play.getY() <= 341 && (play.getX() - me.getX()) >= 3 && (play.getX() - me.getX()) <=58){
				play.setBounds(play.getX()-57,play.getY(),55,55);
			}
		}
	}//卒移动结束
    
	//定义卒吃棋规则,play2是被吃的棋子
	public void armsRule(JLabel play1, JLabel play2) {
		//向右走,首要条件是卒只能吃掉紧邻的棋子，且不能吃自己家的棋子
		if ((play2.getX() - play1.getX()) <= 112 && (play2.getX() - play1.getX()) >= 57 && (play1.getY() - play2.getY()) < 22 && (play1.getY() - play2.getY()) > -22 && play2.isVisible() && play1.getName().charAt(1)!=play2.getName().charAt(1)){
			//黑棋要过河才能右吃棋
			if (play1.getName().charAt(1) == '1' && play1.getY() > 284 && play1.getName().charAt(1) != play2.getName().charAt(1)){
                //吃棋实质是让对方的棋子“隐身”
				play2.setVisible(false);
				//把对方的位置给自己
				play1.setBounds(play2.getX(),play2.getY(),55,55);
			}
			
			//红棋要过河才左能吃棋
			else if (play1.getName().charAt(1) == '2' && play1.getY() < 341 && play1.getName().charAt(1) != play2.getName().charAt(1)){
				play2.setVisible(false);
				//把对方的位置给自己
				play1.setBounds(play2.getX(),play2.getY(),55,55);				
			}
		}
		
		//向左走
		else if ((play1.getX() - play2.getX()) <= 112 && (play1.getX() - play2.getX()) >= 57 && (play1.getY() - play2.getY()) < 22 && (play1.getY() - play2.getY()) > -22 && play2.isVisible() && play1.getName().charAt(1)!=play2.getName().charAt(1)){
			//黑棋要过河才能左吃棋
			if (play1.getName().charAt(1) == '1' && play1.getY() > 284 && play1.getName().charAt(1) != play2.getName().charAt(1)){
				play2.setVisible(false);
				//把对方的位置给自己
				play1.setBounds(play2.getX(),play2.getY(),55,55);
			}
			
			//红棋要过河才能右吃棋
			else if (play1.getName().charAt(1) == '2' && play1.getY() < 341 && play1.getName().charAt(1) != play2.getName().charAt(1)){
				play2.setVisible(false);
				//把对方的位置给自己
				play1.setBounds(play2.getX(),play2.getY(),55,55);				
			}
		}
		
		//向上走
		else if (play1.getX() - play2.getX() >= -22 && play1.getX() - play2.getX() <= 22 && play1.getY() - play2.getY() >= -112 && play1.getY() - play2.getY() <= 112){
			//黑棋不能向上吃棋
			if (play1.getName().charAt(1) == '1' && play1.getY() < play2.getY() && play1.getName().charAt(1) != play2.getName().charAt(1)){
				play2.setVisible(false);
				//把对方的位置给自己
				play1.setBounds(play2.getX(),play2.getY(),55,55);
			}
			
			//红棋不能向下吃棋
			else if (play1.getName().charAt(1) == '2' && play1.getY() > play2.getY() && play1.getName().charAt(1) != play2.getName().charAt(1)){
				play2.setVisible(false);
				//把对方的位置给自己
				play1.setBounds(play2.getX(),play2.getY(),55,55);
			}			
		}	
	}//卒吃棋结束
    
}
