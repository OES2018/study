package lz.ChineseChese;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ImageCapabilities;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
public class ChessBoard extends JFrame implements ActionListener,MouseListener,Runnable{
	public static void main(String[] args){
		new ChessBoard("���������սϵͳ");
	}
	//32������
	JLabel[] chess=new JLabel[32];
	//������ͼƬ����ʽǶ�봰����
	JLabel image;
	//����
	Container con;
	//������
	JToolBar menu;
	//���������ť(��ʼ���˳�)
	JButton start;
	JButton restart;
	JButton exit;
	//ϵͳ��ʾ��Ϣ
	JLabel st;
	/**
	 **�����Ƿ񱻵��
	 **chessClick = true ������˸
	 **
	 */
	boolean chessClick;
	//����������˸���߳�
	Thread t1;
	/**
	 *  chessColor=1  ��������
	 *  chessColor=2  �������壨Ĭ�ϣ�
	 *  chessColor=3  ˫������������
	 */
	int chessColor=2;
	//���������
	ChessRule rule;
	static int play,i;
	//���캯����ʼ��һ������
	public ChessBoard(String title){
		//�ڳ�ʼ������ʱʵ�����������
		rule = new ChessRule();
		//����������
		ChessPiece chessPiece;
		//��ô�������
		con = this.getContentPane();
		con.setLayout(null);
		
		//��������������ʼ����ť
		menu = new JToolBar();
		st = new JLabel("��ӭʹ�ã�ף����죡");
		st.setToolTipText("��Ϣ��ʾ");
		start = new JButton(" ��ʼ����Ϸ");
		start.setToolTipText("��ʼһ���µ���Ϸ");
		//restart = new JButton(" ���¿�ʼ ");
		//restart.setToolTipText("���¿�ʼ�µ���Ϸ");
		exit = new JButton(" �� �� ");
		exit.setToolTipText("�˳���Ϸ");
		
		//�Ѱ�ť��ӵ��˵���
		menu.setLayout(new GridLayout(0,3));
		menu.add(start);
		//menu.add(restart);
		menu.add(exit);
		menu.add(st);
		menu.setBounds(0,0,538,30);
		con.add(menu);
		
		//ע�ᰴť����
		start.addActionListener(this);
		//restart.addActionListener(this);
		exit.addActionListener(this);
		
		//������ӱ�ǩ,ע��Ҫ���������������̣�JLabel�����˳���Ǵ������ڣ������ӵ������ڵײ㲻���ڵ�����
		chessPiece = new ChessPiece(con,chess);
		
		//ע�����Ӽ���
		for(int i=0;i<32;i++){
			chess[i].addMouseListener(this);
		}
		
		//������̱�ǩ��ע���ļ�·�����ʹ��File.separator����ʽ���зָ��֤·����Ϣ�����ִ�λ
		
		image = new JLabel(new ImageIcon("src"+File.separator+"image"+File.separator+"main.gif"));
		//image = new JLabel(new ImageIcon("..\\lz.ChineseChese\\src\\image\\main.gif"));
		con.add(image);
		image.setBounds(0, 30, 558, 620);
		image.addMouseListener(this);
		
		//�رմ���
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
		
		//���ھ�����ʾ
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize=this.getSize();
		if (frameSize.height > screenSize.height){
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width){
			frameSize.width = screenSize.width;
		}
		this.setLocation((screenSize.width - frameSize.width) / 2 - 280 ,(screenSize.height - frameSize.height ) / 2 - 350);
		//���ô������ԣ����ڱ�Ӧ�ò���ͼƬ��Ϊ���̣����Դ��ڲ�������
		this.setResizable(true);
		this.setTitle(title);
		this.setSize(558, 670);
		this.show();
	}
	
	@Override
	public void actionPerformed(ActionEvent button) {
		//�����ʼ����Ϸ��ť,
		if(button.getSource().equals(start)){
			//��ʼ������λ��
			chessClick=false;
			chessColor=2;
			st.setText("��������");
			int i,k;
			//��------����-------��
			//��
			for(i=0, k=24;i<2;i++,k+=456){
				chess[i].setBounds(k,56,55,55);
			}
			//��
			for(i=2, k=81;i<4;i++,k+=342){
				chess[i].setBounds(k,56,55,55);
			}
			//��
			for(i=4, k=138;i<6;i++,k+=228){
				chess[i].setBounds(k,56,55,55);
			}
			//ʿ
			for(i=6, k=195;i<8;i++,k+=114){
				chess[i].setBounds(k,56,55,55);
			}
			//�� 
			chess[8].setBounds(252,56,55,55);
			//��
			for(i=9, k=81;i<11;i++,k+=342){
				chess[i].setBounds(k,170,55,55);
			}
			//��
			for(i=11, k=24;i<16;i++,k+=114){
				chess[i].setBounds(k,227,55,55);
			}
			//��------����------��
			//��
			for(i=16, k=24;i<18;i++,k+=456){
				chess[i].setBounds(k,569,55,55);
			}
			//��
			for(i=18, k=81;i<20;i++,k+=342){
				chess[i].setBounds(k,569,55,55);
			}
			//��
			for(i=20, k=138;i<22;i++,k+=228){
				chess[i].setBounds(k,569,55,55);
			}
			//ʿ
			for(i=22, k=195;i<24;i++,k+=114){
				chess[i].setBounds(k,569,55,55);
			}
			//˧
			chess[24].setBounds(252,569,55,55);
			//��
			for(i=25, k=81;i<27;i++,k+=342){
				chess[i].setBounds(k,455,55,55);
			}
			//��
			for(i=27, k=24;i<32;i++,k+=114){
				chess[i].setBounds(k,398,55,55);
			}
			
		}
		if(button.getSource().equals(exit)){
			int x=JOptionPane.showConfirmDialog(this,"ȷ��Ҫ�˳�����Ϸ��","�˳�",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(x==JOptionPane.YES_OPTION) System.exit(0);
		}
	}
	@Override
	/**
	 ** ��д���̷߳���������������˸
	 */
	public void run() {
		while(true){
			//�������ʱ������˸
			if(chessClick){
				chess[play].setVisible(false);
				//������˸ʱ����
				try{
					t1.sleep(200);
				}catch(Exception e){
				}
				chess[play].setVisible(true);			
			}
			//�����߶���ϵͳ��Ϣ��ʾ�Է�����
			else{
				st.setVisible(false);
				try {
					t1.sleep(200);
				} catch (Exception e) {	
				}
				st.setVisible(true);
			}
			try{
				t1.sleep(350);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	@Override
	//�������Ӻ������Ƿ񱻵��
	public void mouseClicked(MouseEvent me) {
		System.out.println("mouse");
		//��ǰ����
		int x,y;
		//��귢�������ʼ�߳�,�����̲߳����������һ���µ��߳�
		if(t1==null){
			t1 = new Thread(this);
			t1.start();
		}
		if(me.getSource().equals(image)){
			//����������
			if(chessColor ==2 && chess[play].getName().charAt(0) == '��'){
				x = chess[play].getX();
				y = chess[play].getY();
				//�ƶ��䡢��
				if((play >= 11 && play <= 15)
						|| (play >= 27 && play <= 31)){
					rule.soldiesMoveRule(play, chess[play], me);
				}
				//�ƶ���
				else if((play >= 9 && play <= 10)
						|| (play >= 25 && play <= 26)){
					rule.cannonAndRookMoveRule(chess[play], chess, me);
				}
				//�ƶ���
				else if((play >= 0 && play <= 1)
						|| (play >= 16 && play <= 17)){
					System.out.println("��Ҫ�����ƶ�");
					rule.cannonAndRookMoveRule(chess[play], chess, me);
				}
				//�ƶ���
				else if((play >= 2 && play <= 3)
						|| (play >= 18 && play <= 19)){
					rule.horseMoveRule(chess[play], chess, me);
				}
				//�ƶ���
				else if((play >= 4 && play <= 5)
						|| (play >= 20 && play <= 21)){
					rule.ministerMoveRule(chess[play], chess, me);
				}
				//�ƶ�ʿ
				else if((play >= 6 && play <= 7)
						|| (play >= 22 && play <= 23)){
					rule.advisorMoveRule(chess[play], me);
				}
				//�ƶ�����˧
				else if((play == 8) || (play == 24)){
					rule.kingMoveRule(chess[play], me);
				}
				//Ĭ�Ϻ������壬���������ԭ��û��
				if(x == chess[play].getX() && y == chess[play].getY()){
					st.setText("��������");
					chessColor = 2;
				}
				else{
					st.setText("��������");
					chessColor = 1;
				}
			}
			else if(chessColor == 1 && chess[play].getName().charAt(0) == '��'){

				x = chess[play].getX();
				y = chess[play].getY();
				//�ƶ��䡢��
				if((play >= 11 && play <= 15)
						|| (play >= 27 && play <= 31)){
					rule.soldiesMoveRule(play, chess[play], me);
				}
				//�ƶ���
				else if((play >= 9 && play <= 10)
						|| (play >= 25 && play <= 26)){
					rule.cannonAndRookMoveRule(chess[play], chess, me);
				}
				//�ƶ���
				else if((play >= 0 && play <= 1)
						|| (play >= 16 && play <= 17)){
					System.out.println("��Ҫ�����ƶ�");
					rule.cannonAndRookMoveRule(chess[play], chess, me);
				}
				//�ƶ���
				else if((play >= 2 && play <= 3)
						|| (play >= 18 && play <= 19)){
					rule.horseMoveRule(chess[play], chess, me);
				}
				//�ƶ���
				else if((play >= 4 && play <= 5)
						|| (play >= 20 && play <= 21)){
					rule.ministerMoveRule(chess[play], chess, me);
				}
				//�ƶ�ʿ
				else if((play >= 6 && play <= 7)
						|| (play >= 22 && play <= 23)){
					rule.advisorMoveRule(chess[play], me);
				}
				//�ƶ�����˧
				else if((play == 8) || (play == 24)){
					rule.kingMoveRule(chess[play], me);
				}
				//Ĭ�Ϻ������壬���������ԭ��û��
				if(x == chess[play].getX() && y == chess[play].getY()){
					st.setText("��������");
					chessColor = 1;
				}
				else{
					st.setText("��������");
					chessColor = 2;
				}
			
			}
			//��ǰû���κβ���ʱ
			chessClick = false ;
		}
		else{
			//��һ�������
			if(!chessClick){
				System.out.println("���ӱ����");
				for(int i=0; i<32; i++){
					//�����������������
					if(me.getSource().equals(chess[i])){
						play=i;
						//��������˸
						chessClick = true;
						break;
					}
				}
			}
			else if(chessClick){
				//ֹͣ������˸
				for(i=0; i<32; i++){
					//�ҵ����Ե�����
					if(me.getSource().equals(chess[i])){
						//�������
						if(chessColor == 2 && chess[play].getName().charAt(0) == '��'){
							x = chess[play].getX();
							y = chess[play].getY();
							
							//���Ӻͱ�������
							if((play >= 27 && play <= 31)){
								rule.soldiesKillRule(chess[play], chess[i]);
							}
							//�ڳ�����
							else if((play >= 9 && play <= 10)
									&&(play >= 25 && play <= 26)){
								rule.cannonAndRookKillRule(chess[play], chess[i], chess);
							}
							//��������
							else if((play >= 0 && play <= 1)
									&&(play >= 16 && play <= 17)){
								rule.cannonAndRookKillRule(chess[play], chess[i], chess);
							}
							//�������
							else if((play >= 2 && play <= 3)
									&&(play >= 18 && play <= 19)){
								rule.horseKillRule(chess[play], chess[i], chess);
							}
							//�������
							else if((play >= 4 && play <= 5)
									&&(play >= 20 && play <= 21)){
								rule.ministerKillRule(chess[play], chess[i], chess);
							}
							//ʿ������
							else if((play >= 6 && play <= 7)
									&&(play >= 22 && play <= 23)){
								rule.advisorKillRule(chess[play], chess[i]);
							}
							//����˧������
							else if((play == 8) || (play == 24)){
								rule.kingKillRule(chess[play], chess[i], chess);
								chess[play].setVisible(true);
							}
							//Ĭ�Ϻ������壬���������ԭ��û��
							if(x == chess[play].getX() && y == chess[play].getY()){
								st.setText("��������");
								chessColor = 2;
								break;
							}
							else{
								st.setText("��������");
								chessColor = 1;
								break;
							}
						}
						else if(chessColor ==1 && chess[play].getName().charAt(0) == '��'){

							x = chess[play].getX();
							y = chess[play].getY();
							
							//���Ӻͱ�������
							if((play >= 11 && play<=15)
									||(play >= 27 && play <= 31)){
								rule.soldiesKillRule(chess[play], chess[i]);
							}
							//�ڳ�����
							else if((play >= 9 && play <= 10)
									&&(play >= 25 && play <= 26)){
								rule.cannonAndRookKillRule(chess[play], chess[i], chess);
							}
							//��������
							else if((play >= 0 && play <= 1)
									&&(play >= 16 && play <= 17)){
								rule.cannonAndRookKillRule(chess[play], chess[i], chess);
							}
							//�������
							else if((play >= 2 && play <= 3)
									&&(play >= 18 && play <= 19)){
								rule.horseKillRule(chess[play], chess[i], chess);
							}
							//�������
							else if((play >= 4 && play <= 5)
									&&(play >= 20 && play <= 21)){
								rule.ministerKillRule(chess[play], chess[i], chess);
							}
							//ʿ������
							else if((play >= 6 && play <= 7)
									&&(play >= 22 && play <= 23)){
								rule.advisorKillRule(chess[play], chess[i]);
							}
							//����˧������
							else if((play == 8) || (play == 24)){
								rule.kingKillRule(chess[play], chess[i], chess);
								chess[play].setVisible(true);
							}
							//Ĭ�Ϻ������壬���������ԭ��û��
							if(x == chess[play].getX() && y == chess[play].getY()){
								st.setText("��������");
								chessColor = 2;
								break;
							}
							else{
								st.setText("��������");
								chessColor = 1;
								break;
							}
						}
					}
				}
				//��ǰû���κβ���ʱ
				chessClick = false ;
				
				if(!chess[24].isVisible()){
					JOptionPane.showConfirmDialog(
						this,"����ʤ��","���һʤ��",
						JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
					//˫������������������
					chessColor = 3;
					st.setText("����ʤ��");
				}
				else if (!chess[8].isVisible()){
					JOptionPane.showConfirmDialog(
						this,"����ʤ��","��Ҷ�ʤ��",
						JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
					chessColor=3;
					st.setText("����ʤ��");
				}
			}
		}	
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
