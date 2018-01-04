package lz.ChineseChese;

import java.awt.event.MouseEvent;

import javax.swing.JLabel;

/**
 ** �����������ӵ��ƶ��ͳ����ӹ���
 */
public class ChessRule {
	//���䡢����ƶ�����,����ʵ���ƶ������ؾ���ķ�Χȷ���ƶ����ĵ�
	public void soldiesMoveRule(int i,JLabel chess,MouseEvent me){
		//����
		if(i>10 && i<16){
			//����
			if((me.getY()-chess.getY()) > 27 
					&& (me.getY()-chess.getY()) < 84
					&& (me.getX()-chess.getX()) < 55 
					&& (me.getX()-chess.getX() > 0)){
				chess.setBounds(chess.getX(),chess.getY()+57,55,55);
			}//�������ң��������
			else if(chess.getY()>284 
					&& (me.getX()-chess.getX()) >= 57 
					&&(me.getX()-chess.getY()) <= 112){
				chess.setBounds(chess.getX()+57, chess.getY(), 55, 55);
			}//�������󣬱������
			else if(chess.getY()>284 
					&& (chess.getX()-me.getX()) >= 2 
					&& (chess.getX()-me.getX()) <= 58){
				chess.setBounds(chess.getX()-57, chess.getY(), 55, 55);
			}
		}
		
		//���
		else if(i>26 && i<32){
			//����
			if((chess.getY()-me.getY())>27 
					&& (chess.getY()-me.getY()) < 84 
					&& (me.getX()-chess.getX()) >= 0 
					&& (me.getX()-chess.getX()) <= 55 ){
				chess.setBounds(chess.getX(), chess.getY()-57, 55, 55);
			}//������ң��������
			else if(chess.getY()<341 
					&& (me.getX()-chess.getX()) >= 57 
					&&(me.getX()-chess.getY()) <= 112){
				chess.setBounds(chess.getX()+57, chess.getY(), 55, 55);
			}//������󣬱������
			else if(chess.getY()<341 
					&& (chess.getX()-me.getX()) >= 2 
					&& (chess.getX()-me.getX()) <= 58){
				chess.setBounds(chess.getX()-57, chess.getY(), 55, 55);
			}
		}	
	}
	
	///���䡢����Թ���
	public void soldiesKillRule(JLabel chess1, JLabel chess2){
		//���ҳ���
		if ((chess2.getX()-chess1.getX()) <= 112 
				&& (chess2.getX()-chess1.getX()) >= 57 
				&& (chess1.getY() - chess2.getY()) < 22 
				&& (chess1.getY() - chess2.getY()) > -22 
				&& chess2.isVisible() 
				&& chess1.getName().charAt(0)!=chess2.getName().charAt(0)){
			//����������ҳ���
			if (chess1.getName().charAt(0) == '��' 
					&& chess1.getY() > 284 
					&& chess1.getName().charAt(0)!=chess2.getName().charAt(0)){
				//�Ǳ��Ե����ӡ���ʧ�����ú��ó������ŵ����Ե����ӵ�λ��
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(),chess2.getY(),55,55);
			}//����������ҳԺ���
			else if (chess1.getName().charAt(0) == '��' 
					&& chess1.getY() < 341 
					&& chess1.getName().charAt(0) != chess2.getName().charAt(0)){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(),chess2.getY(),55,55);				
			}
		}
		//���������
		else if ((chess1.getX()-chess2.getX()) <= 112 
				&& (chess1.getX()-chess2.getX()) >= 57 
				&& (chess1.getY()-chess2.getY()) < 22 
				&& (chess1.getY()-chess2.getY()) > -22 
				&& chess2.isVisible() && chess1.getName().charAt(0)!=chess2.getName().charAt(0)){
			//����Ҫ���Ӳ�����Ժ���
			if (chess1.getName().charAt(1) == '��' 
					&& chess1.getY() > 284 
					&& chess1.getName().charAt(0) != chess2.getName().charAt(0)){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(),chess2.getY(),55,55);
			}
			
			//����Ҫ���Ӳ��������
			else if (chess1.getName().charAt(0) == '��' 
					&& chess1.getY() < 341 
					&& chess1.getName().charAt(0) != chess2.getName().charAt(0)){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(),chess2.getY(),55,55);				
			}
		}
		//�������³Ժ��壬�������ϳԺ���
		else if (chess1.getX() - chess2.getX() >= -22 
				&& chess1.getX() - chess2.getX() <= 22 
				&& chess1.getY() - chess2.getY() >= -112 
				&& chess1.getY() - chess2.getY() <= 112){
			//�������³Ժ���
			if (chess1.getName().charAt(1) == '��' 
					&& chess1.getY() < chess2.getY() 
					&& chess1.getName().charAt(0) != chess2.getName().charAt(0)){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(),chess2.getY(),55,55);
			}
			
			//�������ϳԺ���
			else if (chess1.getName().charAt(1) == '��' 
					&& chess1.getY() > chess2.getY() 
					&& chess1.getName().charAt(0) != chess2.getName().charAt(0)){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(),chess2.getY(),55,55);
			}	
		}
	}
	
	//�ڡ����ƶ��������������ӵ��ƶ�����һ��
	public void cannonAndRookMoveRule(JLabel chess, JLabel[] chesses, MouseEvent me){
		//���������յ��������������,
		int county = 0;
		int countx = 0;
		int iy;
		int ix;
		
		//�ڡ����������ƶ�,���ж��Ƿ��������ƶ�
		if(((chess.getX() - me.getX()) <= 0 && (chess.getX() - me.getX()) >= -57)){
			//�����е�Y�����������
			for(iy=56; iy<=571; iy+=57){
				//�ж��������λ���Ƿ���ĳ������ӽ�
				if((iy - me.getY()) >= -27 && (iy - me.getY()) < 27){
					//�ҳ���ͬһ�������Ͻ��������յ�ĵ�������������
					for(int j=0; j<32; j+=1){
						//���ܵ����������Ƿ���ȣ��������ƶ��Ĺ������������ϸ΢�ı仯���������ǵ�����Ͳ�����ȷ
						if((chesses[j].getX()-chess.getX()) <= 27
								&&(chesses[j].getX()-chess.getX()) >= -27
								&&chesses[j].getName() != chess.getName()){
							//���ϵ���
							if((chesses[j].getY() > (chess.getY()+27))
									&&(chesses[j].getY()< (iy-27))){
								county++;
							}//���µ���
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
		//�ڡ����������ƶ�
		else if(((chess.getY() - me.getY()) <= 27 
				&& (chess.getY() - me.getY()) >= -27)){
			//������������һ���������ҽ��������յ�֮���������������
			for(ix=24; ix<=480; ix+=57){
				if((ix - me.getX()) >= -55 && (ix-me.getX())<=0){
					for(int j=0; j<32; j++){
						if((chesses[j].getY()- chess.getY()) <= 27 
								&&(chesses[j].getY()- chess.getY()) >= -27
								&&chesses[j].getName() != chess.getName()){
								//������
							if(chesses[j].getX() >= (chess.getX()+57)
									&&chesses[j].getX() < ix){
								countx++;
							}//���ҵ���
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
	
	//�ڡ����������
	public void cannonAndRookKillRule(JLabel chess1, JLabel chess2, JLabel[] chesses){
		//��������յ�֮���������������
		int count=0;
		
		
		for(int j=0; j<32; j+=1){
			//�ҳ�ͬһ�������������н��������յ�֮�������
			if((chesses[j].getX() - chess1.getX()) <= 27 
					&&(chesses[j].getX()-chess1.getX()) >= -27){
				//��������
				if(chesses[j].getY() > (chess1.getY()+27)
						&&chesses[j].getY()< (chess2.getY()-27)){
					count++;
				}//��������
				else if(chesses[j].getY() > (chess2.getY()+27)
						&&chesses[j].getY()< (chess1.getY()-27)){
					count++;
				}	
			}
			//�ҳ�ͬһ�������������н��������յ�֮�������
			else if((chesses[j].getY()- chess1.getY()) <= 27 
					&&(chesses[j].getY()- chess1.getY()) >= -27){
					//������
				if(chesses[j].getX() >= (chess1.getX()+57)
						&&chesses[j].getX() < chess2.getX()){
					count++;
				}//���ҵ���
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
	
	//���ƶ�����
	public void horseMoveRule(JLabel chess, JLabel[] chesses, MouseEvent me){
		//�ƶ����Ƿ����ϰ�
		boolean flag = true;
		//��Ҫ��������ȷ�����ƶ���λ��
		int x=0;
		int y=0;
		//����ƶ��ӷ����������а��֣��������ҡ��������ҡ����ϡ����¡����ϡ����¡�
		//��һ�֣�����
		if((chess.getX()-me.getX()) >=2
				&&(chess.getX()-me.getX()) <= 57
				&&(chess.getY()-me.getY()) >= 84
				&&(chess.getY()-me.getY()) <= 141){
			//�ҵ���Ӧ��x����
			for(int ix=24; ix<=480; ix+=57){
				if(ix -me.getX() >=-55
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//�ҵ���Ӧ��y����
			for(int iy=56; iy<571; iy+=57){
				if((iy - me.getY())>=-27
						&&(iy-me.getY()) <=27){
					y = iy;
					break;
				}
			}
			//�ж��Ƿ����ϰ��������Ϸ��Ƿ�������
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible() 
						&&chess.getX() == chesses[i].getX()
						&&(chesses[i].getY()- chess.getY()) == -57){
					flag = false;
				}
			}
			//�ж��Ƿ�����ƶ�����
			if(flag) chess.setBounds(x, y, 55, 55);
			
		}
		//�ڶ��֣�����
		else if((me.getX()-chess.getX()) >=2
				&&(me.getX()-chess.getX()) <= 57
				&&(chess.getY()-me.getY()) >= 84
				&&(chess.getY()-me.getY()) <= 141){
			//�ҵ���Ӧ��x����
			for(int ix=24; ix<=480; ix+=57){
				if((ix -me.getX()) >=-55
						&&(ix - me.getX()) <= 0){
					x = ix;
					break;
				}
			}
			//�ҵ���Ӧ��y����
			for(int iy=56; iy<571; iy+=57){
				if((iy - me.getY())>=-27
						&&(iy-me.getY()) <=27){
					y = iy;
					break;
				}
			}
			//�ж��Ƿ����ϰ��������Ϸ��Ƿ�������
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible() 
						&&chess.getX() == chesses[i].getX()
						&&(chesses[i].getY()- chess.getY()) == -57){
					flag = false;
				}
			}
			//�ж��Ƿ�����ƶ�����
			if(flag) chess.setBounds(x, y, 55, 55);
			
		}
		//�����֣�����
		else if((chess.getX()-me.getX()) >=2
				&&(chess.getX()-me.getX()) <= 57
				&&(me.getY()-chess.getY()) >= 84
				&&(me.getY()-chess.getY()) <= 141){
			//�ҵ���Ӧ��x����
			for(int ix=24; ix<=480; ix+=57){
				if(ix -me.getX() >=-55
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//�ҵ���Ӧ��y����
			for(int iy=56; iy<571; iy+=57){
				if((iy - me.getY())>=-27
						&&(iy-me.getY()) <=27){
					y = iy;
					break;
				}
			}
			//�ж��Ƿ����ϰ��������·��Ƿ�������
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible() 
						&&chess.getX() == chesses[i].getX()
						&&(chesses[i].getY()- chess.getY()) == 57){
					flag = false;
				}
			}
			//�ж��Ƿ�����ƶ�����
			if(flag) chess.setBounds(x, y, 55, 55);
			
		}
		//�����֣�����
		else if((me.getX()-chess.getX()) >=2
				&&(me.getX()-chess.getX()) <= 57
				&&(me.getY()-chess.getY()) >= 84
				&&(me.getY()-chess.getY()) <= 141){
			//�ҵ���Ӧ��x����
			for(int ix=24; ix<=480; ix+=57){
				if(ix -me.getX() >=-55
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//�ҵ���Ӧ��y����
			for(int iy=56; iy<571; iy+=57){
				if((iy - me.getY())>=-27
						&&(iy-me.getY()) <=27){
					y = iy;
					break;
				}
			}
			//�ж��Ƿ����ϰ��������·��Ƿ�������
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible() 
						&&chess.getX() == chesses[i].getX()
						&&(chesses[i].getY()- chess.getY()) == 57){
					flag = false;
				}
			}
			//�ж��Ƿ�����ƶ�����
			if(flag) chess.setBounds(x, y, 55, 55);
			
		}
		//������:����
		else if((chess.getX()-me.getX()) >=59
				&&(chess.getX()-me.getX()) <= 114
				&&(chess.getY()-me.getY()) >= 27
				&&(chess.getY()-me.getY()) <= 84){
			//�ҵ���Ӧ��x����
			for(int ix=24; ix<=480; ix+=57){
				if(ix -me.getX() >=-55
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//�ҵ���Ӧ��y����
			for(int iy=56; iy<571; iy+=57){
				if((iy - me.getY())>=-27
						&&(iy-me.getY()) <=27){
					y = iy;
					break;
				}
			}
			//�ж��Ƿ����ϰ�������ǰ���Ƿ�������
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible() 
						&&chess.getY() == chesses[i].getY()
						&&(chesses[i].getX()- chess.getX()) == -57){
					flag = false;
				}
			}
			//�ж��Ƿ�����ƶ�����
			if(flag) chess.setBounds(x, y, 55, 55);
			
		}
		//�����֣� ����
		else if((chess.getX()-me.getX()) >=59
				&&(chess.getX()-me.getX()) <= 114
				&&(me.getY()-chess.getY()) >= 27
				&&(me.getY()-chess.getY()) <= 84){
			//�ҵ���Ӧ��x����
			for(int ix=24; ix<=480; ix+=57){
				if(ix -me.getX() >=-55
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//�ҵ���Ӧ��y����
			for(int iy=56; iy<571; iy+=57){
				if((iy - me.getY())>=-27
						&&(iy-me.getY()) <=27){
					y = iy;
					break;
				}
			}
			//�ж��Ƿ����ϰ�������ǰ���Ƿ�������
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible() 
						&&chess.getY() == chesses[i].getY()
						&&(chesses[i].getX()- chess.getX()) == -57){
					flag = false;
				}
			}
			//�ж��Ƿ�����ƶ�����
			if(flag) chess.setBounds(x, y, 55, 55);
			
		}
		//�����֣�����
		else if((me.getX()-chess.getX()) >=59
				&&(me.getX()-chess.getX()) <= 114
				&&(chess.getY()-me.getY()) >= 27
				&&(chess.getY()-me.getY()) <= 84){
			//�ҵ���Ӧ��x����
			for(int ix=24; ix<=480; ix+=57){
				if(ix -me.getX() >=-55
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//�ҵ���Ӧ��y����
			for(int iy=56; iy<571; iy+=57){
				if((iy - me.getY())>=-27
						&&(iy-me.getY()) <=27){
					y = iy;
					break;
				}
			}
			//�ж��Ƿ����ϰ�������ǰ���Ƿ�������
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible() 
						&&chess.getY() == chesses[i].getY()
						&&(chesses[i].getX()- chess.getX()) == 57){
					flag = false;
				}
			}
			//�ж��Ƿ�����ƶ�����
			if(flag) chess.setBounds(x, y, 55, 55);
			
		}
		//�ڰ��֣�����
		else if((me.getX()-chess.getX()) >=59
				&&(me.getX()-chess.getX()) <= 114
				&&(me.getY()-chess.getY()) >= 27
				&&(me.getY()-chess.getY()) <= 84){
			//�ҵ���Ӧ��x����
			for(int ix=24; ix<=480; ix+=57){
				if(ix -me.getX() >=-55
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//�ҵ���Ӧ��y����
			for(int iy=56; iy<571; iy+=57){
				if((iy - me.getY())>=-27
						&&(iy-me.getY()) <=27){
					y = iy;
					break;
				}
			}
			//�ж��Ƿ����ϰ��������Ϸ��Ƿ�������
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible() 
						&&chess.getY() == chesses[i].getY()
						&&(chesses[i].getX()- chess.getX()) == 57){
					flag = false;
				}
			}
			//�ж��Ƿ�����ƶ�����
			if(flag) chess.setBounds(x, y, 55, 55);
			
		}
	}
	//��������
	public void horseKillRule(JLabel chess1, JLabel chess2, JLabel[] chesses){
		//�ж��Ƿ����ϰ�
		boolean flag = true;
		
		//�����������Ҳ��Ҫ�ְ������
		//��һ�֣����ƶ������
		if(chess1.getName().charAt(0) != chess2.getName().charAt(0)
				&&chess1.getX() - chess2.getY() == 57
				&&chess1.getY() - chess2.getY() == 114){
			//�ж����Ϸ��Ƿ����ϰ�
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
		//�ڶ��֣����Ƴ��ұ�
		else if(chess1.getName().charAt(0) != chess2.getName().charAt(0)
				&&chess2.getX() - chess1.getY() == 57
				&&chess1.getY() - chess2.getY() == 114){
			//�ж����Ϸ��Ƿ����ϰ�
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
		//�����֣����ƶ������
		else if(chess1.getName().charAt(0) != chess2.getName().charAt(0)
				&&chess1.getX() - chess2.getY() == 57
				&&chess2.getY() - chess1.getY() == 114){
			//�ж����·��Ƿ����ϰ�
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
		//�����֣����ƶ����ұ�
		else if(chess1.getName().charAt(0) != chess2.getName().charAt(0)
				&&chess2.getX() - chess1.getY() == 57
				&&chess2.getY() - chess1.getY() == 114){
			//�ж����·��Ƿ����ϰ�
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
		//�����֣����ƶ����ϱ�
		else if(chess1.getName().charAt(0) != chess2.getName().charAt(0)
				&&chess1.getX() - chess2.getY() == 114
				&&chess1.getY() - chess2.getY() == 57){
			//�ж���ǰ���Ƿ����ϰ�
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
		//�����֣����ƶ����±�
		else if(chess1.getName().charAt(0) != chess2.getName().charAt(0)
				&&chess1.getX() - chess2.getY() == 114
				&&chess2.getY() - chess1.getY() == 57){
			//�ж���ǰ���Ƿ����ϰ�
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
		//�����֣����ƶ����ϱ�
		else if(chess1.getName().charAt(0) != chess2.getName().charAt(0)
				&&chess2.getX() - chess1.getY() == 114
				&&chess1.getY() - chess2.getY() == 57){
			//�ж���ǰ���Ƿ����ϰ�
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
		//�ڰ��֣����ƶ����±�
		else if(chess1.getName().charAt(0) != chess2.getName().charAt(0)
				&&chess2.getX() - chess1.getY() == 114
				&&chess2.getY() - chess1.getY() == 57){
			//�ж���ǰ���Ƿ����ϰ�
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
	
	//���������
	public void ministerMoveRule(JLabel chess, JLabel [] chesses, MouseEvent me ){
		//�ж��ƶ��Ƿ����ϰ�
		boolean flag = false;
		//��Ҫ����������ȷ�������ƶ���λ��
		int x = 0;
		int y = 0;
		//�ӷ�������������ƶ���Ϊ���֣��������ҡ���������
		//��һ�֣�����
		if(chess.getX() - me.getX() >= 59 
				&&chess.getX() - me.getX() <= 114
				&&chess.getY() - me.getY() >= 87
				&&chess.getY() - me.getY() <= 141){
			//��������ָ��λ�õ�x����
			for(int ix=24; ix<=480;ix+=57){
				if(ix - me.getX() >= -55 
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//��������ָ��λ�õ�y����
			for(int iy=56; iy<=571; iy+=57){
				if(iy - me.getY() >= -27
						&&iy - me.getY() <= 27){
					y = iy;
					break;
				}
			}
			//�ж���ǰ�Ƿ����ϰ�
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible()
						&&chess.getX() - chesses[i].getX() == 57 
						&&chess.getY() - chesses[i].getY() == 57){
					flag = true;
					break;
				}
			}
			//����ͺ��嶼���ܹ��ӣ������ƶ���Ҫע���ж�λ��
			if(flag == false && y >= 341
					&&chess.getName().charAt(0) == '��'){
				chess.setBounds(x, y, 55,55);
			}
			else if(flag == false && y <= 284
					&&chess.getName().charAt(0) == '��'){
				chess.setBounds(x, y, 55,55);
			}
		}
		//�ڶ��֣�����
		else if(me.getX() - chess.getX() >= 114
				&&me.getX() - chess.getX() <= 169
				&&chess.getY() - me.getY() >= 87
				&&chess.getY() - me.getY() <= 141){
			//��������ָ��λ�õ�x����
			for(int ix=24; ix<=480;ix+=57){
				if(ix - me.getX() >= -55 
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//��������ָ��λ�õ�y����
			for(int iy=56; iy<=571; iy+=57){
				if(iy - me.getY() >= -27
						&&iy - me.getY() <= 27){
					y = iy;
					break;
				}
			}
			//�ж���ǰ�Ƿ����ϰ�
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible()
						&&chess.getX() - chesses[i].getX() == -57 
						&&chess.getY() - chesses[i].getY() == 57){
					flag = true;
					break;
				}
			}
			//����ͺ��嶼���ܹ��ӣ������ƶ���Ҫע���ж�λ��
			if(flag == false && y >= 341
					&&chess.getName().charAt(0) == '��'){
				chess.setBounds(x, y, 55,55);
			}
			else if(flag == false && y <= 284
					&&chess.getName().charAt(0) == '��'){
				chess.setBounds(x, y, 55,55);
			}
		}
		//�����֣�����
		else if(chess.getX() - me.getX() >= 59 
				&&chess.getX() - me.getX() <= 114
				&&me.getY() - chess.getY() >= -87
				&&me.getY() - chess.getY() <= 141){
			//��������ָ��λ�õ�x����
			for(int ix=24; ix<=480;ix+=57){
				if(ix - me.getX() >= -55 
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//��������ָ��λ�õ�y����
			for(int iy=56; iy<=571; iy+=57){
				if(iy - me.getY() >= -27
						&&iy - me.getY() <= 27){
					y = iy;
					break;
				}
			}
			//�ж������Ƿ����ϰ�
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible()
						&&chess.getX() - chesses[i].getX() == 57 
						&&chess.getY() - chesses[i].getY() == -57){
					flag = true;
					break;
				}
			}
			//����ͺ��嶼���ܹ��ӣ������ƶ���Ҫע���ж�λ��
			if(flag == false && y >= 341
					&&chess.getName().charAt(0) == '��'){
				chess.setBounds(x, y, 55,55);
			}
			else if(flag == false && y <= 284
					&&chess.getName().charAt(0) == '��'){
				chess.setBounds(x, y, 55,55);
			}
		}
		//�����֣�����
		else if(me.getX() - chess.getX() >= 114
				&&me.getX() - chess.getX() <= 169
				&&me.getY() - chess.getY() >= 87
				&&me.getY() - chess.getY() <= 141){
			//��������ָ��λ�õ�x����
			for(int ix=24; ix<=480;ix+=57){
				if(ix - me.getX() >= -55 
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//��������ָ��λ�õ�y����
			for(int iy=56; iy<=571; iy+=57){
				if(iy - me.getY() >= -27
						&&iy - me.getY() <= 27){
					y = iy;
					break;
				}
			}
			//�ж������Ƿ����ϰ�
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible()
						&&chess.getX() - chesses[i].getX() == -57 
						&&chess.getY() - chesses[i].getY() == -57){
					flag = true;
					break;
				}
			}
			//����ͺ��嶼���ܹ��ӣ������ƶ���Ҫע���ж�λ��
			if(flag == false && y >= 341
					&&chess.getName().charAt(0) == '��'){
				chess.setBounds(x, y, 55,55);
			}
			else if(flag == false && y <= 284
					&&chess.getName().charAt(0) == '��'){
				chess.setBounds(x, y, 55,55);
			}
		}
	}
	//������ӹ���Ҳ�����ַ�������ӣ��������ҡ���������
	public void ministerKillRule(JLabel chess1, JLabel chess2, JLabel[] chesses){
		//�ж��Ƿ����ϰ�
		boolean flag = false;
		//���������
		if(chess1.getName().charAt(0) != chess2.getName().charAt(0)
				&&chess1.getX() - chess2.getX() == 114
				&&chess1.getY() - chess2.getY() ==114){
			//�ж���ǰ�Ƿ����ϰ�
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible()
						&&chess1.getX() - chesses[i].getX() == 57 
						&&chess1.getY() - chesses[i].getY() == 57){
					flag = true;
					break;
				}
			}
			//����Ժ���
			if(flag == false && chess2.getY() >= 341
					&&chess1.getName().charAt(0) == '��'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
			//����Ժ���
			else if(flag == false && chess2.getY() <= 284
					&&chess1.getName().charAt(0) == '��'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
		}
		//�ڶ��֣����ҳ�����
		else if(chess1.getName().charAt(0) != chess2.getName().charAt(0)
				&&chess2.getX() - chess1.getX() == 114
				&&chess1.getY() - chess2.getY() ==114){
			//�ж���ǰ�Ƿ����ϰ�
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible()
						&&chess1.getX() - chesses[i].getX() == -57 
						&&chess1.getY() - chesses[i].getY() == 57){
					flag = true;
					break;
				}
			}
			//����Ժ���
			if(flag == false && chess2.getY() >= 341
					&&chess1.getName().charAt(0) == '��'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
			//����Ժ���
			else if(flag == false && chess2.getY() <= 284
					&&chess1.getName().charAt(0) == '��'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
		}
		//�����֣����������
		else if(chess1.getName().charAt(0) != chess2.getName().charAt(0)
				&&chess1.getX() - chess2.getX() == 114
				&&chess2.getY() - chess1.getY() ==114){
			//�ж������Ƿ����ϰ�
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible()
						&&chess1.getX() - chesses[i].getX() == 57 
						&&chess1.getY() - chesses[i].getY() == -57){
					flag = true;
					break;
				}
			}
			//����Ժ���
			if(flag == false && chess2.getY() >= 341
					&&chess1.getName().charAt(0) == '��'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
			//����Ժ���
			else if(flag == false && chess2.getY() <= 284
					&&chess1.getName().charAt(0) == '��'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
		}
		//�����֣����ҳ�����
		else if(chess1.getName().charAt(0) != chess2.getName().charAt(0)
				&&chess2.getX() - chess1.getX() == 114
				&&chess2.getY() - chess1.getY() ==114){
			//�ж������Ƿ����ϰ�
			for(int i=0; i<32; i++){
				if(chesses[i].isVisible()
						&&chess1.getX() - chesses[i].getX() == -57 
						&&chess1.getY() - chesses[i].getY() == -57){
					flag = true;
					break;
				}
			}
			//����Ժ���
			if(flag == false && chess2.getY() >= 341
					&&chess1.getName().charAt(0) == '��'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
			//����Ժ���
			else if(flag == false && chess2.getY() <= 284
					&&chess1.getName().charAt(0) == '��'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
		}
	}
	//ʿ���ƶ�����
	public void advisorMoveRule(JLabel chess, MouseEvent me){
		//��Ҫ����������ȷ��λ��
		int x=0;
		int y=0;
		
		//�ӷ�����������Ϊ�����ƶ�������������ҡ���������
		//��һ�֣�����
		if(chess.getX() - me.getX() >= 2 
				&&chess.getX() - me.getX() <= 57
				&&chess.getY() - me.getY() >= 30
				&&chess.getY() - me.getY() <= 84){
			//��������ָ��λ�õ�x����
			for(int ix=24; ix<=480;ix+=57){
				if(ix - me.getX() >= -55 
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//��������ָ��λ�õ�y����
			for(int iy=56; iy<=571; iy+=57){
				if(iy - me.getY() >= -27
						&&iy - me.getY() <= 27){
					y = iy;
					break;
				}
			}
			//��ʿ�ͺ�ʿ�����ܹ�������ָ��������
			//��ʿ�ƶ�
			if(x >= 195 && x <= 309
					&& y >= 455 && y <= 569){
				chess.setBounds(x, y, 55, 55);
			}
			//��ʿ�ƶ�
			else if(x >= 195 && x <= 309
					&& y >= 56 && y <= 170){
				chess.setBounds(x, y, 55, 55);
			}
		}
		//�ڶ��֣�����
		else if(me.getX() - chess.getX() >= 57 
				&&me.getX() - chess.getX() <= 112
				&&chess.getY() - me.getY() >= 30
				&&chess.getY() - me.getY() <= 84){
			//��������ָ��λ�õ�x����
			for(int ix=24; ix<=480;ix+=57){
				if(ix - me.getX() >= -55 
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//��������ָ��λ�õ�y����
			for(int iy=56; iy<=571; iy+=57){
				if(iy - me.getY() >= -27
						&&iy - me.getY() <= 27){
					y = iy;
					break;
				}
			}
			//��ʿ�ͺ�ʿ�����ܹ�������ָ��������
			//��ʿ�ƶ�
			if(x >= 195 && x <= 309
					&& y >= 455 && y <= 569){
				chess.setBounds(x, y, 55, 55);
			}
			//��ʿ�ƶ�
			else if(x >= 195 && x <= 309
					&& y >= 56 && y <= 170){
				chess.setBounds(x, y, 55, 55);
			}
		}
		//�����֣�����
		else if(chess.getX() - me.getX() >= 2 
				&&chess.getX() - me.getX() <= 57
				&&me.getY() - chess.getY() >= 30
				&&me.getY() - chess.getY() <= 84){
			//��������ָ��λ�õ�x����
			for(int ix=24; ix<=480;ix+=57){
				if(ix - me.getX() >= -55 
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//��������ָ��λ�õ�y����
			for(int iy=56; iy<=571; iy+=57){
				if(iy - me.getY() >= -27
						&&iy - me.getY() <= 27){
					y = iy;
					break;
				}
			}
			//��ʿ�ͺ�ʿ�����ܹ�������ָ��������
			//��ʿ�ƶ�
			if(x >= 195 && x <= 309
					&& y >= 455 && y <= 569){
				chess.setBounds(x, y, 55, 55);
			}
			//��ʿ�ƶ�
			else if(x >= 195 && x <= 309
					&& y >=56 && y <= 170){
				chess.setBounds(x, y, 55, 55);
			}
		}
		//�����֣�����
		else if(me.getX() - chess.getX() >= 57 
				&&me.getX() - chess.getX() <= 112
				&&me.getY() - chess.getY() >= 30
				&&me.getY() - chess.getY() <= 84){
			//��������ָ��λ�õ�x����
			for(int ix=24; ix<=480;ix+=57){
				if(ix - me.getX() >= -55 
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//��������ָ��λ�õ�y����
			for(int iy=56; iy<=571; iy+=57){
				if(iy - me.getY() >= -27
						&&iy - me.getY() <= 27){
					y = iy;
					break;
				}
			}
			//��ʿ�ͺ�ʿ�����ܹ�������ָ��������
			//��ʿ�ƶ�
			if(x >= 195 && x <= 309
					&& y >= 455 && y <= 569){
				chess.setBounds(x, y, 55, 55);
			}
			//��ʿ�ƶ�
			else if(x >= 195 && x <= 309
					&& y >= 56 && y <= 170){
				chess.setBounds(x, y, 55, 55);
			}
		}
	}
	//ʿ�ĳ������
	//Ҳ���ĸ���������ӣ��������ҡ���������
	public void advisorKillRule(JLabel chess1, JLabel chess2){
		//��һ�֣����������
		if(chess1.getX() - chess2.getX() == 57 
				&&chess1.getY() -chess2.getY() == 57){
			//��ʿ�ͺ�ʿ�����ܹ�������ָ��������
			//��ʿ�ƶ��Ժ���
			if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >= 455 && chess2.getY() <= 569
					&&chess1.getName().charAt(0) == '��'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
			//��ʿ�ƶ��Ժ���
			else if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >=56 && chess2.getY() <= 170
					&&chess1.getName().charAt(0) == '��'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
		}
		//���ҳ�����
		else if(chess2.getX() - chess1.getX() == 57 
				&&chess1.getY() -chess2.getY() == 57){
			//��ʿ�ͺ�ʿ�����ܹ�������ָ��������
			//��ʿ�ƶ��Ժ���
			if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >= 455 && chess2.getY() <= 569
					&&chess1.getName().charAt(0) == '��'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
			//��ʿ�ƶ��Ժ���
			else if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >= 56 && chess2.getY() <= 170
					&&chess1.getName().charAt(0) == '��'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
		}
		//���������
		else if(chess1.getX() - chess2.getX() == 57 
				&&chess2.getY() -chess1.getY() == 57){
			//��ʿ�ͺ�ʿ�����ܹ�������ָ��������
			//��ʿ�ƶ��Ժ���
			if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >= 455 && chess2.getY() <= 569
					&&chess1.getName().charAt(0) == '��'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
			//��ʿ�ƶ��Ժ���
			else if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >56 && chess2.getY() <= 170
					&&chess1.getName().charAt(0) == '��'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
		}
		//���ҳ�����
		else if(chess2.getX() - chess1.getX() == 57 
				&&chess2.getY() -chess1.getY() == 57){
			//��ʿ�ͺ�ʿ�����ܹ�������ָ��������
			//��ʿ�ƶ��Ժ���
			if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >= 455 && chess2.getY() <= 569
					&&chess1.getName().charAt(0) == '��'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
			//��ʿ�ƶ��Ժ���
			else if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >= 56 && chess2.getY() <= 170
					&&chess1.getName().charAt(0) == '��'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
		}
	}
	//����˧�ƶ�����
	public void kingMoveRule(JLabel chess, MouseEvent me){
		//��Ҫ��������ȷ���ƶ�λ��
		int x=0;
		int y=0;
		//����˧�ƶ�����Ҳ�����֣��ϡ��¡����� 
		//��һ�֣���
		if(chess.getX() - me.getX() >= -55 
				&&chess.getX() - me.getX() <= 0
				&&chess.getY() - me.getY() >= 30
				&&chess.getY() - me.getY() <= 84){
			//��������ָ��λ�õ�x����
			for(int ix=24; ix<=480;ix+=57){
				if(ix - me.getX() >= -55 
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//��������ָ��λ�õ�y����
			for(int iy=56; iy<=571; iy+=57){
				if(iy - me.getY() >= -27
						&&iy - me.getY() <= 27){
					y = iy;
					break;
				}
			}
			//��˧�ͺڽ������ܹ�������ָ��������
			//��˧�ƶ�
			if(x >= 195 && x <= 309
					&& y >= 455 && y <= 569){
				chess.setBounds(x, y, 55, 55);
			}
			//�ڽ��ƶ�
			else if(x >= 195 && x <= 309
					&& y >= 56 && y <= 170){
				chess.setBounds(x, y, 55, 55);
			}
		}
		//�ڶ��֣���
		else if(chess.getX() - me.getX() >= -55 
				&&chess.getX() - me.getX() <= 0
				&&me.getY() - chess.getY() >= 30
				&&me.getY() - chess.getY() <= 84){
			//��������ָ��λ�õ�x����
			for(int ix=24; ix<=480;ix+=57){
				if(ix - me.getX() >= -55 
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//��������ָ��λ�õ�y����
			for(int iy=56; iy<=571; iy+=57){
				if(iy - me.getY() >= -27
						&&iy - me.getY() <= 27){
					y = iy;
					break;
				}
			}
			//��˧�ͺڽ������ܹ�������ָ��������
			//��˧�ƶ�
			if(x >= 195 && x <= 309
					&& y >= 455 && y <= 569){
				chess.setBounds(x, y, 55, 55);
			}
			//�ڽ��ƶ�
			else if(x >= 195 && x <= 309
					&& y>=56 && y <= 170){
				chess.setBounds(x, y, 55, 55);
			}
		}
		//�����֣���
		else if(chess.getX() - me.getX() >= 2
				&&chess.getX() - me.getX() <= 57
				&&me.getY() - chess.getY() >= -27
				&&me.getY() - chess.getY() <= 27){
			//��������ָ��λ�õ�x����
			for(int ix=24; ix<=480;ix+=57){
				if(ix - me.getX() >= -55 
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//��������ָ��λ�õ�y����
			for(int iy=56; iy<=571; iy+=57){
				if(iy - me.getY() >= -27
						&&iy - me.getY() <= 27){
					y = iy;
					break;
				}
			}
			//��˧�ͺڽ������ܹ�������ָ��������
			//��˧�ƶ�
			if(x >= 195 && x <= 309
					&& y >= 455 && y <= 569){
				chess.setBounds(x, y, 55, 55);
			}
			//�ڽ��ƶ�
			else if(x >= 195 && x <= 309
					&& y>=56 && y <= 170){
				chess.setBounds(x, y, 55, 55);
			}
		}
		//�����֣���
		else if(me.getX() - chess.getX() >= 57 
				&&me.getX() - chess.getX() <= 112
				&&me.getY() - chess.getY() >= -27
				&&me.getY() - chess.getY() <= 27){
			//��������ָ��λ�õ�x����
			for(int ix=24; ix<=480;ix+=57){
				if(ix - me.getX() >= -55 
						&&ix - me.getX() <= 0){
					x = ix;
					break;
				}
			}
			//��������ָ��λ�õ�y����
			for(int iy=56; iy<=571; iy+=57){
				if(iy - me.getY() >= -27
						&&iy - me.getY() <= 27){
					y = iy;
					break;
				}
			}
			//��˧�ͺڽ������ܹ�������ָ��������
			//��˧�ƶ�
			if(x >= 195 && x <= 309
					&& y >= 455 && y <= 569){
				chess.setBounds(x, y, 55, 55);
			}
			//�ڽ��ƶ�
			else if(x >= 195 && x <= 309
					&& y>=56 && y <= 170){
				chess.setBounds(x, y, 55, 55);
			}
		}
	}
	//����˧�����ӹ���
	public void kingMoveRule(JLabel chess1, JLabel chess2, JLabel[] chesses){
		//�ж�˧�ͽ��Ƿ����ֱ�ӳԶԷ�
		boolean flag = true;
		//����˧����Ҳ�����֣��ϡ��¡����ҡ�˧�ϳԽ������³�˧��
		//Ҫ����ע��˧�ͽ�ֱ�����ʱ�������
		//��
		if(chess1.getX() == chess2.getX() 
				&& chess1.getY() -chess2.getY() == 57){
			//��˧�Ժ���
			if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >= 455 && chess2.getY() <= 569
					&&chess1.getName().charAt(0) == '��'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
			//�ڽ��Ժ���
			else if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >= 56 && chess2.getY() <= 170
					&&chess1.getName().charAt(0) == '��'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
		}
		//��
		else if(chess1.getX() == chess2.getX() 
				&& chess2.getY() -chess1.getY() == 57){
			//��˧�Ժ���
			if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >= 455 && chess2.getY() <= 569
					&&chess1.getName().charAt(0) == '��'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
			//�ڽ��Ժ���
			else if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >= 56 && chess2.getY() <= 170
					&&chess1.getName().charAt(0) == '��'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
		}
		//��
		else if(chess1.getX() - chess2.getX() == 57
				&& chess1.getY() == chess2.getY()){
			//��˧�Ժ���
			if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >= 455 && chess2.getY() <= 569
					&&chess1.getName().charAt(0) == '��'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
			//�ڽ��Ժ���
			else if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >= 56 && chess2.getY() <= 170
					&&chess1.getName().charAt(0) == '��'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
		}
		//��
		else if(chess2.getX() - chess1.getX() == 57
				&& chess1.getY() == chess2.getY()){
			//��˧�Ժ���
			if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >= 455 && chess2.getY() <= 569
					&&chess1.getName().charAt(0) == '��'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
			//�ڽ��Ժ���
			else if(chess2.getX() >= 195 && chess2.getX() <= 309
					&& chess2.getY() >= 56 && chess2.getY() <= 170
					&&chess1.getName().charAt(0) == '��'){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
		}
		//˧�ϳԽ�
		else if(chess1.getName().charAt(1) == '˧' 
				&& chess2.getName().charAt(1) == '��'
				&& chess1.getX() == chess2.getX()){
			for(int i=0; i<32; i++){
				if(chesses[i].getX() == chess1.getX()){
					flag = false;
				}
			}
			if(flag){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
		}
		//���³���
		else if(chess1.getName().charAt(1) == '��' 
				&& chess2.getName().charAt(1) == '˧'
				&& chess1.getX() == chess2.getX()){
			for(int i=0; i<32; i++){
				if(chesses[i].getX() == chess1.getX()){
					flag = false;
				}
			}
			if(flag){
				chess2.setVisible(false);
				chess1.setBounds(chess2.getX(), chess2.getY(), 55, 55);
			}
		}
	}
}