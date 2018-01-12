package lz.ChineseChese;

import java.awt.event.MouseEvent;

import javax.swing.JLabel;

/**
 ** 定义所有棋子的移动和吃棋子规则
 */
public class ChessRule {
	//黑卒、红兵移动规则,根据实际移动的像素距离的范围确定移动到的点
	public void soldiesMoveRule(int i,JLabel chess,MouseEvent me){
		//黑卒
		if(i>10 && i<16){
			//向下
			if((me.getY()-chess.getY()) > 27 
					&& (me.getY()-chess.getY()) < 84
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
					&& (chess.getY()-me.getY()) < 84 
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
	
	//炮、车移动规则，这两类棋子的移动规则一样
	public void cannonAndRookMoveRule(JLabel chess, JLabel[] chesses, MouseEvent me){
		//计算起点和终点的其他棋子数量,
		int county = 0;
		int countx = 0;
		int iy;
		int ix;
		
		//炮、车的上下移动,先判断是否是左右移动
		if(((chess.getX() - me.getX()) <= 0 && (chess.getX() - me.getX()) >= -57)){
			//将所有的Y坐标遍历出来
			for(iy=56; iy<=571; iy+=57){
				//判断鼠标点击的位子是否与某个坐标接近
				if((iy - me.getY()) >= -27 && (iy - me.getY()) < 27){
					//找出在同一条竖线上介于起点和终点的的所有其他棋子
					for(int j=0; j<32; j+=1){
						//不能单纯看坐标是否相等，可能在移动的过程中坐标出现细微的变化，本来我们的坐标就不够精确
						if((chesses[j].getX()-chess.getX()) <= 27
								&&(chesses[j].getX()-chess.getX()) >= -27
								&&chesses[j].getName() != chess.getName()){
							//从上到下
							if((chesses[j].getY() > (chess.getY()+27))
									&&(chesses[j].getY()< (iy-27))){
								county++;
							}//从下到上
							else if((chesses[j].getY() > (iy+27))
									&&(chesses[j].getY()< (chess.getY()-27))){
								county++;
							}
						}
					}
				}
			}
			if(county == 0){
				chess.setBounds(chess.getX(), iy, 55, 55);
			}
		}
		//炮、车的左右移动
		else if(((chess.getY() - me.getY()) <= 27 
				&& (chess.getY() - me.getY()) >= -27)){
			//遍历出所有在一条横线上且介于起点和终点之间的所有其他棋子
			for(ix=24; ix<=480; ix+=57){
				if((ix - me.getX()) >= -55 && (ix-me.getX())<=0){
					for(int j=0; j<32; j++){
						if((chesses[j].getY()- chess.getY()) <= 27 
								&&(chesses[j].getY()- chess.getY()) >= -27
								&&chesses[j].getName() != chess.getName()){
								//从左到右
							if(chesses[j].getX() >= (chess.getX()+57)
									&&chesses[j].getX() < ix){
								countx++;
							}//从右到左
							else if(chesses[j].getX() >= (ix+57)
									&&chesses[j].getX() < chess.getX()){
								countx++;
							}
						}
					}
				}
			}
			if(countx ==0){
				chess.setBounds(ix, chess.getY(), 55, 55);
			}
		}
	}
	
	//炮、车吃棋规则
	public void cannonAndRookKillRule(JLabel chess1, JLabel chess2, JLabel[] chesses){
		//计算起点终点之间的其他棋子数量
		int count=0;
		
		
		for(int j=0; j<32; j+=1){
			//找出同一竖线下其他所有介于起点和终点之间的棋子
			if((chesses[j].getX() - chess1.getX()) <= 27 
					&&(chesses[j].getX()-chess1.getX()) >= -27){
				//从上向下
				if(chesses[j].getY() > (chess1.getY()+27)
						&&chesses[j].getY()< (chess2.getY()-27)){
					count++;
				}//从下向上
				else if(chesses[j].getY() > (chess2.getY()+27)
						&&chesses[j].getY()< (chess1.getY()-27)){
					count++;
				}	
			}
			//找出同一横线上其他所有介于起点和终点之间的棋子
			else if((chesses[j].getY()- chess1.getY()) <= 27 
					&&(chesses[j].getY()- chess1.getY()) >= -27){
					//从左到右
				if(chesses[j].getX() >= (chess1.getX()+57)
						&&chesses[j].getX() < chess2.getX()){
					count++;
				}//从右到左
				else if(chesses[j].getX() >= (chess2.getX()+57)
						&&chesses[j].getX() < chess1.getX()){
					count++;
				}
			}
		}
		if(count == 1 && chess1.getName().charAt(0) != chess2.getName().charAt(0)){
			chess2.setVisible(false);
			chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			
		}else if(count ==0&& chess1.getName().charAt(0) != chess2.getName().charAt(0)){
			chess2.setVisible(false);
			chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
		}
	}
	
	//马移动规则
	public void horseMoveRule(JLabel chess, JLabel[] chesses, MouseEvent me){
		//移动马是否有障碍
		boolean flag = true;
		//需要两步才能确定马移动的位置
		int x=0;
		int y=0;
		//马的移动从方向上来看有八种，上左、上右、下左、下右、左上、左下、右上、右下。
		//第一种：上左
		if((chess.getX()-me.getX()) >=2
				&&(chess.getX()-me.getX()) <= 57
				&&(chess.getY()-me.getY()) >= 84
				&&(chess.getY()-me.getY()) <= 141){
			//找到对应的x坐标
			for(int ix=24; ix<=480; ix+=57){
				if(ix -me.getX() >=-55
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//找到对应的y坐标
			for(int iy=56; iy<571; iy+=57){
				if((iy - me.getY())>=-27
						&&(iy-me.getY()) <=27){
					y = iy;
					break;
				}
			}
			//判断是否有障碍，即正上方是否有棋子
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible() 
						&&chess.getX() == chesses[i].getX()
						&&(chesses[i].getY()- chess.getY()) == -57){
					flag = false;
				}
			}
			//判断是否可以移动棋子
			if(flag) chess.setBounds(x, y, 55, 55);
			
		}
		//第二种：上右
		else if((me.getX()-chess.getX()) >=2
				&&(me.getX()-chess.getX()) <= 57
				&&(chess.getY()-me.getY()) >= 84
				&&(chess.getY()-me.getY()) <= 141){
			//找到对应的x坐标
			for(int ix=24; ix<=480; ix+=57){
				if((ix -me.getX()) >=-55
						&&(ix - me.getX()) <= 0){
					x = ix;
					break;
				}
			}
			//找到对应的y坐标
			for(int iy=56; iy<571; iy+=57){
				if((iy - me.getY())>=-27
						&&(iy-me.getY()) <=27){
					y = iy;
					break;
				}
			}
			//判断是否有障碍，即正上方是否有棋子
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible() 
						&&chess.getX() == chesses[i].getX()
						&&(chesses[i].getY()- chess.getY()) == -57){
					flag = false;
				}
			}
			//判断是否可以移动棋子
			if(flag) chess.setBounds(x, y, 55, 55);
			
		}
		//第三种：下左
		else if((chess.getX()-me.getX()) >=2
				&&(chess.getX()-me.getX()) <= 57
				&&(me.getY()-chess.getY()) >= 84
				&&(me.getY()-chess.getY()) <= 141){
			//找到对应的x坐标
			for(int ix=24; ix<=480; ix+=57){
				if(ix -me.getX() >=-55
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//找到对应的y坐标
			for(int iy=56; iy<571; iy+=57){
				if((iy - me.getY())>=-27
						&&(iy-me.getY()) <=27){
					y = iy;
					break;
				}
			}
			//判断是否有障碍，即正下方是否有棋子
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible() 
						&&chess.getX() == chesses[i].getX()
						&&(chesses[i].getY()- chess.getY()) == 57){
					flag = false;
				}
			}
			//判断是否可以移动棋子
			if(flag) chess.setBounds(x, y, 55, 55);
			
		}
		//第四种：下右
		else if((me.getX()-chess.getX()) >=2
				&&(me.getX()-chess.getX()) <= 57
				&&(me.getY()-chess.getY()) >= 84
				&&(me.getY()-chess.getY()) <= 141){
			//找到对应的x坐标
			for(int ix=24; ix<=480; ix+=57){
				if(ix -me.getX() >=-55
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//找到对应的y坐标
			for(int iy=56; iy<571; iy+=57){
				if((iy - me.getY())>=-27
						&&(iy-me.getY()) <=27){
					y = iy;
					break;
				}
			}
			//判断是否有障碍，即正下方是否有棋子
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible() 
						&&chess.getX() == chesses[i].getX()
						&&(chesses[i].getY()- chess.getY()) == 57){
					flag = false;
				}
			}
			//判断是否可以移动棋子
			if(flag) chess.setBounds(x, y, 55, 55);
			
		}
		//第五种:左上
		else if((chess.getX()-me.getX()) >=59
				&&(chess.getX()-me.getX()) <= 114
				&&(chess.getY()-me.getY()) >= 27
				&&(chess.getY()-me.getY()) <= 84){
			//找到对应的x坐标
			for(int ix=24; ix<=480; ix+=57){
				if(ix -me.getX() >=-55
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//找到对应的y坐标
			for(int iy=56; iy<571; iy+=57){
				if((iy - me.getY())>=-27
						&&(iy-me.getY()) <=27){
					y = iy;
					break;
				}
			}
			//判断是否有障碍，即左前方是否有棋子
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible() 
						&&chess.getY() == chesses[i].getY()
						&&(chesses[i].getX()- chess.getX()) == -57){
					flag = false;
				}
			}
			//判断是否可以移动棋子
			if(flag) chess.setBounds(x, y, 55, 55);
			
		}
		//第六种： 左下
		else if((chess.getX()-me.getX()) >=59
				&&(chess.getX()-me.getX()) <= 114
				&&(me.getY()-chess.getY()) >= 27
				&&(me.getY()-chess.getY()) <= 84){
			//找到对应的x坐标
			for(int ix=24; ix<=480; ix+=57){
				if(ix -me.getX() >=-55
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//找到对应的y坐标
			for(int iy=56; iy<571; iy+=57){
				if((iy - me.getY())>=-27
						&&(iy-me.getY()) <=27){
					y = iy;
					break;
				}
			}
			//判断是否有障碍，即左前方是否有棋子
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible() 
						&&chess.getY() == chesses[i].getY()
						&&(chesses[i].getX()- chess.getX()) == -57){
					flag = false;
				}
			}
			//判断是否可以移动棋子
			if(flag) chess.setBounds(x, y, 55, 55);
			
		}
		//第七种：右上
		else if((me.getX()-chess.getX()) >=59
				&&(me.getX()-chess.getX()) <= 114
				&&(chess.getY()-me.getY()) >= 27
				&&(chess.getY()-me.getY()) <= 84){
			//找到对应的x坐标
			for(int ix=24; ix<=480; ix+=57){
				if(ix -me.getX() >=-55
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//找到对应的y坐标
			for(int iy=56; iy<571; iy+=57){
				if((iy - me.getY())>=-27
						&&(iy-me.getY()) <=27){
					y = iy;
					break;
				}
			}
			//判断是否有障碍，即右前方是否有棋子
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible() 
						&&chess.getY() == chesses[i].getY()
						&&(chesses[i].getX()- chess.getX()) == 57){
					flag = false;
				}
			}
			//判断是否可以移动棋子
			if(flag) chess.setBounds(x, y, 55, 55);
			
		}
		//第八种：右下
		else if((me.getX()-chess.getX()) >=59
				&&(me.getX()-chess.getX()) <= 114
				&&(me.getY()-chess.getY()) >= 27
				&&(me.getY()-chess.getY()) <= 84){
			//找到对应的x坐标
			for(int ix=24; ix<=480; ix+=57){
				if(ix -me.getX() >=-55
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//找到对应的y坐标
			for(int iy=56; iy<571; iy+=57){
				if((iy - me.getY())>=-27
						&&(iy-me.getY()) <=27){
					y = iy;
					break;
				}
			}
			//判断是否有障碍，即正上方是否有棋子
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible() 
						&&chess.getY() == chesses[i].getY()
						&&(chesses[i].getX()- chess.getX()) == 57){
					flag = false;
				}
			}
			//判断是否可以移动棋子
			if(flag) chess.setBounds(x, y, 55, 55);
			
		}
	}
	//马吃棋规则
	public void horseKillRule(JLabel chess1, JLabel chess2, JLabel[] chesses){
		//判断是否有障碍
		boolean flag = true;
		
		//按照走棋规则也是要分八种情况
		//第一种：上移动吃左边
		if(chess1.getName().charAt(0) != chess2.getName().charAt(0)
				&&chess1.getX() - chess2.getY() == 57
				&&chess1.getY() - chess2.getY() == 114){
			//判断正上方是否有障碍
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible() 
						&&chess1.getX() == chesses[i].getX()
						&&(chesses[i].getY()- chess1.getY()) == -57){
					flag = false;
				}
			}
			if(flag){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			} 
		}
		//第二种：上移吃右边
		else if(chess1.getName().charAt(0) != chess2.getName().charAt(0)
				&&chess2.getX() - chess1.getY() == 57
				&&chess1.getY() - chess2.getY() == 114){
			//判断正上方是否有障碍
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible() 
						&&chess1.getX() == chesses[i].getX()
						&&(chesses[i].getY()- chess1.getY()) == -57){
					flag = false;
				}
			}
			if(flag){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			} 
		}
		//第三种：下移动吃左边
		else if(chess1.getName().charAt(0) != chess2.getName().charAt(0)
				&&chess1.getX() - chess2.getY() == 57
				&&chess2.getY() - chess1.getY() == 114){
			//判断正下方是否有障碍
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible() 
						&&chess1.getX() == chesses[i].getX()
						&&(chesses[i].getY()- chess1.getY()) == 57){
					flag = false;
				}
			}
			if(flag){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			} 
		}
		//第四种：下移动吃右边
		else if(chess1.getName().charAt(0) != chess2.getName().charAt(0)
				&&chess2.getX() - chess1.getY() == 57
				&&chess2.getY() - chess1.getY() == 114){
			//判断正下方是否有障碍
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible() 
						&&chess1.getX() == chesses[i].getX()
						&&(chesses[i].getY()- chess1.getY()) == 57){
					flag = false;
				}
			}
			if(flag){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			} 
		}
		//第五种：左移动吃上边
		else if(chess1.getName().charAt(0) != chess2.getName().charAt(0)
				&&chess1.getX() - chess2.getY() == 114
				&&chess1.getY() - chess2.getY() == 57){
			//判断左前方是否有障碍
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible() 
						&&chess1.getY() == chesses[i].getY()
						&&(chesses[i].getX()- chess1.getX()) == -57){
					flag = false;
				}
			}
			if(flag){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			} 
		}
		//第六种：左移动吃下边
		else if(chess1.getName().charAt(0) != chess2.getName().charAt(0)
				&&chess1.getX() - chess2.getY() == 114
				&&chess2.getY() - chess1.getY() == 57){
			//判断左前方是否有障碍
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible() 
						&&chess1.getY() == chesses[i].getY()
						&&(chesses[i].getX()- chess1.getX()) == -57){
					flag = false;
				}
			}
			if(flag){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			} 
		}
		//第七种：右移动吃上边
		else if(chess1.getName().charAt(0) != chess2.getName().charAt(0)
				&&chess2.getX() - chess1.getY() == 114
				&&chess1.getY() - chess2.getY() == 57){
			//判断右前方是否有障碍
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible() 
						&&chess1.getY() == chesses[i].getY()
						&&(chesses[i].getX()- chess1.getX()) == 57){
					flag = false;
				}
			}
			if(flag){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			} 
		}
		//第八种：右移动吃下边
		else if(chess1.getName().charAt(0) != chess2.getName().charAt(0)
				&&chess2.getX() - chess1.getY() == 114
				&&chess2.getY() - chess1.getY() == 57){
			//判断右前方是否有障碍
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible() 
						&&chess1.getY() == chesses[i].getY()
						&&(chesses[i].getX()- chess1.getX()) == 57){
					flag = false;
				}
			}
			if(flag){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			} 
		}
	}
	
	//相走起规则
	public void ministerMoveRule(JLabel chess, JLabel [] chesses, MouseEvent me ){
		//判断移动是否有障碍
		boolean flag = false;
		//需要两个坐标来确定棋子移动的位置
		int x = 0;
		int y = 0;
		//从方向上来看相的移动分为四种：上左、上右、下左，下右
		//第一种：上左
		if(chess.getX() - me.getX() >= 59 
				&&chess.getX() - me.getX() <= 114
				&&chess.getY() - me.getY() >= 87
				&&chess.getY() - me.getY() <= 141){
			//遍历查找指定位置的x坐标
			for(int ix=24; ix<=480;ix+=57){
				if(ix - me.getX() >= -55 
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//遍历查找指定位置的y坐标
			for(int iy=56; iy<=571; iy+=57){
				if(iy - me.getY() >= -27
						&&iy - me.getY() <= 27){
					y = iy;
					break;
				}
			}
			//判断左前是否有障碍
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible()
						&&chess.getX() - chesses[i].getX() == 57 
						&&chess.getY() - chesses[i].getY() == 57){
					flag = true;
					break;
				}
			}
			//红旗和黑棋都不能过河，所以移动是要注意判断位置
			if(flag == false && y >= 341
					&&chess.getName().charAt(0) == '红'){
				chess.setBounds(x, y, 55,55);
			}
			else if(flag == false && y <= 284
					&&chess.getName().charAt(0) == '黑'){
				chess.setBounds(x, y, 55,55);
			}
		}
		//第二种：上右
		else if(me.getX() - chess.getX() >= 114
				&&me.getX() - chess.getX() <= 169
				&&chess.getY() - me.getY() >= 87
				&&chess.getY() - me.getY() <= 141){
			//遍历查找指定位置的x坐标
			for(int ix=24; ix<=480;ix+=57){
				if(ix - me.getX() >= -55 
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//遍历查找指定位置的y坐标
			for(int iy=56; iy<=571; iy+=57){
				if(iy - me.getY() >= -27
						&&iy - me.getY() <= 27){
					y = iy;
					break;
				}
			}
			//判断右前是否有障碍
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible()
						&&chess.getX() - chesses[i].getX() == -57 
						&&chess.getY() - chesses[i].getY() == 57){
					flag = true;
					break;
				}
			}
			//红旗和黑棋都不能过河，所以移动是要注意判断位置
			if(flag == false && y >= 341
					&&chess.getName().charAt(0) == '红'){
				chess.setBounds(x, y, 55,55);
			}
			else if(flag == false && y <= 284
					&&chess.getName().charAt(0) == '黑'){
				chess.setBounds(x, y, 55,55);
			}
		}
		//第三种：下左
		else if(chess.getX() - me.getX() >= 59 
				&&chess.getX() - me.getX() <= 114
				&&me.getY() - chess.getY() >= -87
				&&me.getY() - chess.getY() <= 141){
			//遍历查找指定位置的x坐标
			for(int ix=24; ix<=480;ix+=57){
				if(ix - me.getX() >= -55 
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//遍历查找指定位置的y坐标
			for(int iy=56; iy<=571; iy+=57){
				if(iy - me.getY() >= -27
						&&iy - me.getY() <= 27){
					y = iy;
					break;
				}
			}
			//判断左下是否有障碍
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible()
						&&chess.getX() - chesses[i].getX() == 57 
						&&chess.getY() - chesses[i].getY() == -57){
					flag = true;
					break;
				}
			}
			//红旗和黑棋都不能过河，所以移动是要注意判断位置
			if(flag == false && y >= 341
					&&chess.getName().charAt(0) == '红'){
				chess.setBounds(x, y, 55,55);
			}
			else if(flag == false && y <= 284
					&&chess.getName().charAt(0) == '黑'){
				chess.setBounds(x, y, 55,55);
			}
		}
		//第四种：下右
		else if(me.getX() - chess.getX() >= 114
				&&me.getX() - chess.getX() <= 169
				&&me.getY() - chess.getY() >= 87
				&&me.getY() - chess.getY() <= 141){
			//遍历查找指定位置的x坐标
			for(int ix=24; ix<=480;ix+=57){
				if(ix - me.getX() >= -55 
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//遍历查找指定位置的y坐标
			for(int iy=56; iy<=571; iy+=57){
				if(iy - me.getY() >= -27
						&&iy - me.getY() <= 27){
					y = iy;
					break;
				}
			}
			//判断右下是否有障碍
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible()
						&&chess.getX() - chesses[i].getX() == -57 
						&&chess.getY() - chesses[i].getY() == -57){
					flag = true;
					break;
				}
			}
			//红旗和黑棋都不能过河，所以移动是要注意判断位置
			if(flag == false && y >= 341
					&&chess.getName().charAt(0) == '红'){
				chess.setBounds(x, y, 55,55);
			}
			else if(flag == false && y <= 284
					&&chess.getName().charAt(0) == '黑'){
				chess.setBounds(x, y, 55,55);
			}
		}
	}
	//相吃棋子规则，也是四种方向吃棋子：上左、上右、下左，下右
	public void ministerKillRule(JLabel chess1, JLabel chess2, JLabel[] chesses){
		//判断是否有障碍
		boolean flag = false;
		//上左吃棋子
		if(chess1.getName().charAt(0) != chess2.getName().charAt(0)
				&&chess1.getX() - chess2.getX() == 114
				&&chess1.getY() - chess2.getY() ==114){
			//判断左前是否有障碍
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible()
						&&chess1.getX() - chesses[i].getX() == 57 
						&&chess1.getY() - chesses[i].getY() == 57){
					flag = true;
					break;
				}
			}
			//红相吃黑棋
			if(flag == false && chess2.getY() >= 341
					&&chess1.getName().charAt(0) == '红'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
			//黑相吃红棋
			else if(flag == false && chess2.getY() <= 284
					&&chess1.getName().charAt(0) == '黑'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
		}
		//第二种：上右吃棋子
		else if(chess1.getName().charAt(0) != chess2.getName().charAt(0)
				&&chess2.getX() - chess1.getX() == 114
				&&chess1.getY() - chess2.getY() ==114){
			//判断右前是否有障碍
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible()
						&&chess1.getX() - chesses[i].getX() == -57 
						&&chess1.getY() - chesses[i].getY() == 57){
					flag = true;
					break;
				}
			}
			//红相吃黑棋
			if(flag == false && chess2.getY() >= 341
					&&chess1.getName().charAt(0) == '红'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
			//黑相吃红棋
			else if(flag == false && chess2.getY() <= 284
					&&chess1.getName().charAt(0) == '黑'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
		}
		//第三种：下左吃棋子
		else if(chess1.getName().charAt(0) != chess2.getName().charAt(0)
				&&chess1.getX() - chess2.getX() == 114
				&&chess2.getY() - chess1.getY() ==114){
			//判断左下是否有障碍
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible()
						&&chess1.getX() - chesses[i].getX() == 57 
						&&chess1.getY() - chesses[i].getY() == -57){
					flag = true;
					break;
				}
			}
			//红相吃黑棋
			if(flag == false && chess2.getY() >= 341
					&&chess1.getName().charAt(0) == '红'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
			//黑相吃红棋
			else if(flag == false && chess2.getY() <= 284
					&&chess1.getName().charAt(0) == '黑'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
		}
		//第四种：下右吃棋子
		else if(chess1.getName().charAt(0) != chess2.getName().charAt(0)
				&&chess2.getX() - chess1.getX() == 114
				&&chess2.getY() - chess1.getY() ==114){
			//判断右下是否有障碍
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible()
						&&chess1.getX() - chesses[i].getX() == -57 
						&&chess1.getY() - chesses[i].getY() == -57){
					flag = true;
					break;
				}
			}
			//红相吃黑棋
			if(flag == false && chess2.getY() >= 341
					&&chess1.getName().charAt(0) == '红'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
			//黑相吃红棋
			else if(flag == false && chess2.getY() <= 284
					&&chess1.getName().charAt(0) == '黑'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
		}
	}
	//士的移动规则
	public void advisorMoveRule(JLabel chess, MouseEvent me){
		//需要两个坐标来确定位置
		int x=0;
		int y=0;
		
		//从方向上来看分为四种移动情况：上左、上右、下左，下右
		//第一种：上左
		if(chess.getX() - me.getX() >= 2 
				&&chess.getX() - me.getX() <= 57
				&&chess.getY() - me.getY() >= 30
				&&chess.getY() - me.getY() <= 84){
			//遍历查找指定位置的x坐标
			for(int ix=24; ix<=480;ix+=57){
				if(ix - me.getX() >= -55 
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//遍历查找指定位置的y坐标
			for(int iy=56; iy<=571; iy+=57){
				if(iy - me.getY() >= -27
						&&iy - me.getY() <= 27){
					y = iy;
					break;
				}
			}
			//红士和黑士都不能过河且在指定区域内
			//红士移动
			if(x >= 195 && x <= 309
					&& y >= 455 && y <= 569){
				chess.setBounds(x, y, 55, 55);
			}
			//黑士移动
			else if(x >= 195 && x <= 309
					&& y >= 56 && y <= 170){
				chess.setBounds(x, y, 55, 55);
			}
		}
		//第二种：上右
		else if(me.getX() - chess.getX() >= 57 
				&&me.getX() - chess.getX() <= 112
				&&chess.getY() - me.getY() >= 30
				&&chess.getY() - me.getY() <= 84){
			//遍历查找指定位置的x坐标
			for(int ix=24; ix<=480;ix+=57){
				if(ix - me.getX() >= -55 
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//遍历查找指定位置的y坐标
			for(int iy=56; iy<=571; iy+=57){
				if(iy - me.getY() >= -27
						&&iy - me.getY() <= 27){
					y = iy;
					break;
				}
			}
			//红士和黑士都不能过河且在指定区域内
			//红士移动
			if(x >= 195 && x <= 309
					&& y >= 455 && y <= 569){
				chess.setBounds(x, y, 55, 55);
			}
			//黑士移动
			else if(x >= 195 && x <= 309
					&& y >= 56 && y <= 170){
				chess.setBounds(x, y, 55, 55);
			}
		}
		//第三种：下左
		else if(chess.getX() - me.getX() >= 2 
				&&chess.getX() - me.getX() <= 57
				&&me.getY() - chess.getY() >= 30
				&&me.getY() - chess.getY() <= 84){
			//遍历查找指定位置的x坐标
			for(int ix=24; ix<=480;ix+=57){
				if(ix - me.getX() >= -55 
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//遍历查找指定位置的y坐标
			for(int iy=56; iy<=571; iy+=57){
				if(iy - me.getY() >= -27
						&&iy - me.getY() <= 27){
					y = iy;
					break;
				}
			}
			//红士和黑士都不能过河且在指定区域内
			//红士移动
			if(x >= 195 && x <= 309
					&& y >= 455 && y <= 569){
				chess.setBounds(x, y, 55, 55);
			}
			//黑士移动
			else if(x >= 195 && x <= 309
					&& y >=56 && y <= 170){
				chess.setBounds(x, y, 55, 55);
			}
		}
		//第四种：下右
		else if(me.getX() - chess.getX() >= 57 
				&&me.getX() - chess.getX() <= 112
				&&me.getY() - chess.getY() >= 30
				&&me.getY() - chess.getY() <= 84){
			//遍历查找指定位置的x坐标
			for(int ix=24; ix<=480;ix+=57){
				if(ix - me.getX() >= -55 
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//遍历查找指定位置的y坐标
			for(int iy=56; iy<=571; iy+=57){
				if(iy - me.getY() >= -27
						&&iy - me.getY() <= 27){
					y = iy;
					break;
				}
			}
			//红士和黑士都不能过河且在指定区域内
			//红士移动
			if(x >= 195 && x <= 309
					&& y >= 455 && y <= 569){
				chess.setBounds(x, y, 55, 55);
			}
			//黑士移动
			else if(x >= 195 && x <= 309
					&& y >= 56 && y <= 170){
				chess.setBounds(x, y, 55, 55);
			}
		}
	}
	//士的吃棋规则
	//也是四个方向吃棋子：上左、上右、下左，下右
	public void advisorKillRule(JLabel chess1, JLabel chess2){
		//第一种：上左吃棋子
		if(chess1.getX() - chess2.getX() == 57 
				&&chess1.getY() -chess2.getY() == 57){
			//红士和黑士都不能过河且在指定区域内
			//红士移动吃黑棋
			if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >= 455 && chess2.getY() <= 569
					&&chess1.getName().charAt(0) == '红'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
			//黑士移动吃红旗
			else if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >=56 && chess2.getY() <= 170
					&&chess1.getName().charAt(0) == '黑'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
		}
		//上右吃棋子
		else if(chess2.getX() - chess1.getX() == 57 
				&&chess1.getY() -chess2.getY() == 57){
			//红士和黑士都不能过河且在指定区域内
			//红士移动吃黑棋
			if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >= 455 && chess2.getY() <= 569
					&&chess1.getName().charAt(0) == '红'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
			//黑士移动吃红旗
			else if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >= 56 && chess2.getY() <= 170
					&&chess1.getName().charAt(0) == '黑'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
		}
		//下左吃棋子
		else if(chess1.getX() - chess2.getX() == 57 
				&&chess2.getY() -chess1.getY() == 57){
			//红士和黑士都不能过河且在指定区域内
			//红士移动吃黑棋
			if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >= 455 && chess2.getY() <= 569
					&&chess1.getName().charAt(0) == '红'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
			//黑士移动吃红旗
			else if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >56 && chess2.getY() <= 170
					&&chess1.getName().charAt(0) == '黑'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
		}
		//下右吃棋子
		else if(chess2.getX() - chess1.getX() == 57 
				&&chess2.getY() -chess1.getY() == 57){
			//红士和黑士都不能过河且在指定区域内
			//红士移动吃黑棋
			if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >= 455 && chess2.getY() <= 569
					&&chess1.getName().charAt(0) == '红'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
			//黑士移动吃红旗
			else if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >= 56 && chess2.getY() <= 170
					&&chess1.getName().charAt(0) == '黑'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
		}
	}
	//将、帅移动规则
	public void kingMoveRule(JLabel chess, MouseEvent me){
		//需要两个坐标确定移动位置
		int x=0;
		int y=0;
		//将、帅移动方向也是四种：上、下、左、右 
		//第一种：上
		if(chess.getX() - me.getX() >= -55 
				&&chess.getX() - me.getX() <= 0
				&&chess.getY() - me.getY() >= 30
				&&chess.getY() - me.getY() <= 84){
			//遍历查找指定位置的x坐标
			for(int ix=24; ix<=480;ix+=57){
				if(ix - me.getX() >= -55 
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//遍历查找指定位置的y坐标
			for(int iy=56; iy<=571; iy+=57){
				if(iy - me.getY() >= -27
						&&iy - me.getY() <= 27){
					y = iy;
					break;
				}
			}
			//红帅和黑将都不能过河且在指定区域内
			//红帅移动
			if(x >= 195 && x <= 309
					&& y >= 455 && y <= 569){
				chess.setBounds(x, y, 55, 55);
			}
			//黑将移动
			else if(x >= 195 && x <= 309
					&& y >= 56 && y <= 170){
				chess.setBounds(x, y, 55, 55);
			}
		}
		//第二种：下
		else if(chess.getX() - me.getX() >= -55 
				&&chess.getX() - me.getX() <= 0
				&&me.getY() - chess.getY() >= 30
				&&me.getY() - chess.getY() <= 84){
			//遍历查找指定位置的x坐标
			for(int ix=24; ix<=480;ix+=57){
				if(ix - me.getX() >= -55 
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//遍历查找指定位置的y坐标
			for(int iy=56; iy<=571; iy+=57){
				if(iy - me.getY() >= -27
						&&iy - me.getY() <= 27){
					y = iy;
					break;
				}
			}
			//红帅和黑将都不能过河且在指定区域内
			//红帅移动
			if(x >= 195 && x <= 309
					&& y >= 455 && y <= 569){
				chess.setBounds(x, y, 55, 55);
			}
			//黑将移动
			else if(x >= 195 && x <= 309
					&& y>=56 && y <= 170){
				chess.setBounds(x, y, 55, 55);
			}
		}
		//第三种：左
		else if(chess.getX() - me.getX() >= 2
				&&chess.getX() - me.getX() <= 57
				&&me.getY() - chess.getY() >= -27
				&&me.getY() - chess.getY() <= 27){
			//遍历查找指定位置的x坐标
			for(int ix=24; ix<=480;ix+=57){
				if(ix - me.getX() >= -55 
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//遍历查找指定位置的y坐标
			for(int iy=56; iy<=571; iy+=57){
				if(iy - me.getY() >= -27
						&&iy - me.getY() <= 27){
					y = iy;
					break;
				}
			}
			//红帅和黑将都不能过河且在指定区域内
			//红帅移动
			if(x >= 195 && x <= 309
					&& y >= 455 && y <= 569){
				chess.setBounds(x, y, 55, 55);
			}
			//黑将移动
			else if(x >= 195 && x <= 309
					&& y>=56 && y <= 170){
				chess.setBounds(x, y, 55, 55);
			}
		}
		//第四种：右
		else if(me.getX() - chess.getX() >= 57 
				&&me.getX() - chess.getX() <= 112
				&&me.getY() - chess.getY() >= -27
				&&me.getY() - chess.getY() <= 27){
			//遍历查找指定位置的x坐标
			for(int ix=24; ix<=480;ix+=57){
				if(ix - me.getX() >= -55 
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//遍历查找指定位置的y坐标
			for(int iy=56; iy<=571; iy+=57){
				if(iy - me.getY() >= -27
						&&iy - me.getY() <= 27){
					y = iy;
					break;
				}
			}
			//红帅和黑将都不能过河且在指定区域内
			//红帅移动
			if(x >= 195 && x <= 309
					&& y >= 455 && y <= 569){
				chess.setBounds(x, y, 55, 55);
			}
			//黑将移动
			else if(x >= 195 && x <= 309
					&& y>=56 && y <= 170){
				chess.setBounds(x, y, 55, 55);
			}
		}
	}
	//将、帅吃棋子规则
	public void kingMoveRule(JLabel chess1, JLabel chess2, JLabel[] chesses){
		//判断帅和将是否可以直接吃对方
		boolean flag = true;
		//将、帅吃棋也是六种：上、下、左、右、帅上吃将、将下吃帅。
		//要尤其注意帅和将直接面对时的情况，
		//上
		if(chess1.getX() == chess2.getX() 
				&& chess1.getY() -chess2.getY() == 57){
			//红帅吃黑棋
			if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >= 455 && chess2.getY() <= 569
					&&chess1.getName().charAt(0) == '红'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
			//黑将吃红棋
			else if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >= 56 && chess2.getY() <= 170
					&&chess1.getName().charAt(0) == '黑'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
		}
		//下
		else if(chess1.getX() == chess2.getX() 
				&& chess2.getY() -chess1.getY() == 57){
			//红帅吃黑棋
			if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >= 455 && chess2.getY() <= 569
					&&chess1.getName().charAt(0) == '红'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
			//黑将吃红棋
			else if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >= 56 && chess2.getY() <= 170
					&&chess1.getName().charAt(0) == '黑'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
		}
		//左
		else if(chess1.getX() - chess2.getX() == 57
				&& chess1.getY() == chess2.getY()){
			//红帅吃黑棋
			if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >= 455 && chess2.getY() <= 569
					&&chess1.getName().charAt(0) == '红'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
			//黑将吃红棋
			else if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >= 56 && chess2.getY() <= 170
					&&chess1.getName().charAt(0) == '黑'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
		}
		//右
		else if(chess2.getX() - chess1.getX() == 57
				&& chess1.getY() == chess2.getY()){
			//红帅吃黑棋
			if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >= 455 && chess2.getY() <= 569
					&&chess1.getName().charAt(0) == '红'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
			//黑将吃红棋
			else if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >= 56 && chess2.getY() <= 170
					&&chess1.getName().charAt(0) == '黑'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
		}
		//帅上吃将
		else if(chess1.getName().charAt(1) == '帅' 
				&& chess2.getName().charAt(1) == '将'
				&& chess1.getX() == chess2.getX()){
			for(int i=0; i<32; i++){
				if(chesses[i].getX() == chess1.getX() 
				   	&& chesses[i].getName() != chess1.getName()
				  	&& chesses[i].getName() != chess2.getName()){
					flag = false;
					break;
				}
			}
			if(flag){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
		}
		//将下吃棋
		else if(chess1.getName().charAt(1) == '将' 
				&& chess2.getName().charAt(1) == '帅'
				&& chess1.getX() == chess2.getX()){
			for(int i=0; i<32; i++){
				if(chesses[i].getX() == chess1.getX() 
				   	&& chesses[i].getName() != chess1.getName()
				  	&& chesses[i].getName() != chess2.getName()){
					flag = false;
					break;
				}
			}
			if(flag){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
		}
	}
}
