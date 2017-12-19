package zh;

import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public class ChessRule {

	//定义卒子移动规则
	public void armsRule(int Man, JLabel play, MouseEvent me) {
		//黑卒向下，每一格的大小是57像素
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
		
		//红卒向上，每一格的大小是57像素
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
        
	/**定义炮、车移动规则  play为要移动的炮或车，playQ[]为同一条线的其他棋子*/
	public void cannonRule(JLabel play, JLabel playQ[], MouseEvent me) {
		//起点和终点之间是否有棋子
		int Count = 0;
		
		//上、下移动
		if(play.getX()-me.getX()<=0 && play.getX()-me.getX()>=-55){
			//指定所有模糊的Y坐标(一条直线上的所有Y坐标)
			for(int i=56;i<571;i+=57){
				//是否移动到指定位置
				if(i-me.getY()>=-27 && i-me.getY()<=27){
					//遍历所有棋子,判断移动棋子到目的地时中间是否有棋子
					for(int j=0;j<32;j++){
						//找出在同一条线的所有可以看见的棋子,不包括自己
						if(playQ[j].getX()-play.getX()>=-27 && playQ[j].getX()-play.getX()<=27 && playQ[j].getName()!=play.getName() && playQ[j].isVisible()){
							//向下移动，扫描起点到终点的其他棋子
							for(int k=play.getY()+57;k<i;k+=57){
								//判断是否有大于终点小于起点的坐标，若有说明中间有棋子
								if(playQ[j].getY()<i && playQ[j].getY()>play.getY()){
									Count++;
									break;
								}
							}
							//向上移动，扫描起点到终点的其他棋子
							for(int k=i+57;k<play.getY();k+=57){
								//判断是否有大于终点小于起点的坐标，若有说明中间有棋子
								if(playQ[j].getY()<play.getY() && playQ[j].getY()>i){
									Count++;
									break;
								}
							}
						}//if
					}//for
					//起点和终点没有棋子就可以移动了
					if(Count==0){
						play.setBounds(play.getX(),i,55,55);
						break;
					}
				}//if
			}//for
		}//if
		
		//左右移动
		else if(play.getY()-me.getY()>=-27 && play.getY()-me.getY()<=27){
			//指定所有模糊的X坐标(一条直线上的所有X坐标)
			for(int i=24;i<=480;i+=57){
				//移动棋子到指定位置
				if(i-me.getX()>=-55 && i-me.getX()<=0){
					//遍历所有棋子,判断移动棋子到目的地时中间是否有棋子
					for(int j=0;j<32;j++){
						//找出在同一条线的所有可以看见的棋子,不包括自己
						if(playQ[j].getY()-play.getY()>=-27 && playQ[j].getY()-play.getY()<=27 && playQ[j].getName()!=play.getName() && playQ[j].isVisible()){
							//向右移动，扫描起点到终点的棋子
							for(int k=play.getX()+57;k<i;k+=57){
								//判断是否有大于终点小于起点的坐标，若有说明中间有棋子
								if(playQ[j].getX()<i && playQ[j].getX()>play.getX()){
									Count++;
									break;
								}
							}
							//向左移动，扫描起点到终点的棋子
							for(int k=i+57;k<play.getX();k+=57){
								//判断是否有大于终点小于起点的坐标，若有说明中间有棋子
								if(playQ[j].getX()<play.getX() && playQ[j].getX()>i){
									Count++;
									break;
								}
							}
						}//if
					}//for
					//起点和终点没有棋子就可以移动了
					if(Count==0){
						play.setBounds(i,play.getY(),55,55);
						break;
					}
				}//if
			}//for
		}//else if
	}//炮，车移动规则结束
}
