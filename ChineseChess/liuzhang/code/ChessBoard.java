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
		new ChessBoard("初级象棋对战系统");
	}
	//32颗棋子
	JLabel[] chess=new JLabel[32];
	//棋盘以图片的形式嵌入窗体中
	JLabel image;
	//窗格
	Container con;
	//工具栏
	JToolBar menu;
	//定义基本按钮(开始和退出)
	JButton start;
	JButton restart;
	JButton exit;
	//系统提示消息
	JLabel st;
	/**
	 **棋子是否被点击
	 **chessClick = true 棋子闪烁
	 **
	 */
	boolean chessClick;
	//控制棋子闪烁的线程
	Thread t1;
	/**
	 *  chessColor=1  黑棋走棋
	 *  chessColor=2  红棋走棋（默认）
	 *  chessColor=3  双方都不能走棋
	 */
	int chessColor=2;
	//象棋规则类
	ChessRule rule;
	static int play,i;
	//构造函数初始化一个窗口
	public ChessBoard(String title){
		//在初始化窗口时实例化所需对象
		rule = new ChessRule();
		//定义棋子类
		ChessPiece chessPiece;
		//获得窗口引用
		con = this.getContentPane();
		con.setLayout(null);
		
		//创建工具栏并初始化按钮
		menu = new JToolBar();
		st = new JLabel("欢迎使用，祝您愉快！");
		st.setToolTipText("信息提示");
		start = new JButton(" 开始新游戏");
		start.setToolTipText("开始一局新的游戏");
		//restart = new JButton(" 重新开始 ");
		//restart.setToolTipText("重新开始新的游戏");
		exit = new JButton(" 退 出 ");
		exit.setToolTipText("退出游戏");
		
		//把按钮添加到菜单中
		menu.setLayout(new GridLayout(0,3));
		menu.add(start);
		//menu.add(restart);
		menu.add(exit);
		menu.add(st);
		menu.setBounds(0,0,538,30);
		con.add(menu);
		
		//注册按钮监听
		start.addActionListener(this);
		//restart.addActionListener(this);
		exit.addActionListener(this);
		
		//添加棋子标签,注意要先添加棋子添加棋盘，JLabel的添加顺序是从外向内，最后添加的棋盘在底层不会遮挡棋子
		chessPiece = new ChessPiece(con,chess);
		
		//注册棋子监听
		for(int i=0;i<32;i++){
			chess[i].addMouseListener(this);
		}
		
		//添加棋盘标签，注意文件路径最好使用File.separator的形式进行分割，保证路径信息不出现错位
		
		image = new JLabel(new ImageIcon("src"+File.separator+"image"+File.separator+"main.gif"));
		//image = new JLabel(new ImageIcon("..\\lz.ChineseChese\\src\\image\\main.gif"));
		con.add(image);
		image.setBounds(0, 30, 558, 620);
		image.addMouseListener(this);
		
		//关闭窗口
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
		
		//窗口居中显示
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize=this.getSize();
		if (frameSize.height > screenSize.height){
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width){
			frameSize.width = screenSize.width;
		}
		this.setLocation((screenSize.width - frameSize.width) / 2 - 280 ,(screenSize.height - frameSize.height ) / 2 - 350);
		//设置窗口属性，由于本应用采用图片作为棋盘，所以窗口不能拉伸
		this.setResizable(true);
		this.setTitle(title);
		this.setSize(558, 670);
		this.show();
	}
	
	@Override
	public void actionPerformed(ActionEvent button) {
		//点击开始新游戏按钮,
		if(button.getSource().equals(start)){
			//初始化棋子位置
			chessClick=false;
			chessColor=2;
			st.setText("红棋走棋");
			int i,k;
			//“------黑棋-------”
			//车
			for(i=0, k=24;i<2;i++,k+=456){
				chess[i].setBounds(k,56,55,55);
			}
			//马
			for(i=2, k=81;i<4;i++,k+=342){
				chess[i].setBounds(k,56,55,55);
			}
			//象
			for(i=4, k=138;i<6;i++,k+=228){
				chess[i].setBounds(k,56,55,55);
			}
			//士
			for(i=6, k=195;i<8;i++,k+=114){
				chess[i].setBounds(k,56,55,55);
			}
			//将 
			chess[8].setBounds(252,56,55,55);
			//炮
			for(i=9, k=81;i<11;i++,k+=342){
				chess[i].setBounds(k,170,55,55);
			}
			//卒
			for(i=11, k=24;i<16;i++,k+=114){
				chess[i].setBounds(k,227,55,55);
			}
			//“------红棋------”
			//车
			for(i=16, k=24;i<18;i++,k+=456){
				chess[i].setBounds(k,569,55,55);
			}
			//马
			for(i=18, k=81;i<20;i++,k+=342){
				chess[i].setBounds(k,569,55,55);
			}
			//相
			for(i=20, k=138;i<22;i++,k+=228){
				chess[i].setBounds(k,569,55,55);
			}
			//士
			for(i=22, k=195;i<24;i++,k+=114){
				chess[i].setBounds(k,569,55,55);
			}
			//帅
			chess[24].setBounds(252,569,55,55);
			//炮
			for(i=25, k=81;i<27;i++,k+=342){
				chess[i].setBounds(k,455,55,55);
			}
			//兵
			for(i=27, k=24;i<32;i++,k+=114){
				chess[i].setBounds(k,398,55,55);
			}
			
		}
		if(button.getSource().equals(exit)){
			int x=JOptionPane.showConfirmDialog(this,"确定要退出本游戏吗？","退出",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(x==JOptionPane.YES_OPTION) System.exit(0);
		}
	}
	@Override
	/**
	 ** 重写的线程方法来控制棋子闪烁
	 */
	public void run() {
		while(true){
			//点击棋子时棋子闪烁
			if(chessClick){
				chess[play].setVisible(false);
				//设置闪烁时间间隔
				try{
					t1.sleep(200);
				}catch(Exception e){
				}
				chess[play].setVisible(true);			
			}
			//棋子走动后系统消息提示对方走棋
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
	//监听棋子和棋盘是否被点击
	public void mouseClicked(MouseEvent me) {
		System.out.println("mouse");
		//当前坐标
		int x,y;
		//鼠标发生点击后开始线程,若是线程不存在则产生一个新的线程
		if(t1==null){
			t1 = new Thread(this);
			t1.start();
		}
		if(me.getSource().equals(image)){
			//红棋走棋子
			if(chessColor ==2 && chess[play].getName().charAt(0) == '红'){
				x = chess[play].getX();
				y = chess[play].getY();
				//移动卒、兵
				if((play >= 11 && play <= 15)
						|| (play >= 27 && play <= 31)){
					rule.soldiesMoveRule(play, chess[play], me);
				}
				//移动炮
				else if((play >= 9 && play <= 10)
						|| (play >= 25 && play <= 26)){
					rule.cannonAndRookMoveRule(chess[play], chess, me);
				}
				//移动车
				else if((play >= 0 && play <= 1)
						|| (play >= 16 && play <= 17)){
					System.out.println("车要上下移动");
					rule.cannonAndRookMoveRule(chess[play], chess, me);
				}
				//移动马
				else if((play >= 2 && play <= 3)
						|| (play >= 18 && play <= 19)){
					rule.horseMoveRule(chess[play], chess, me);
				}
				//移动象
				else if((play >= 4 && play <= 5)
						|| (play >= 20 && play <= 21)){
					rule.ministerMoveRule(chess[play], chess, me);
				}
				//移动士
				else if((play >= 6 && play <= 7)
						|| (play >= 22 && play <= 23)){
					rule.advisorMoveRule(chess[play], me);
				}
				//移动将和帅
				else if((play == 8) || (play == 24)){
					rule.kingMoveRule(chess[play], me);
				}
				//默认红棋走棋，如果棋子在原地没动
				if(x == chess[play].getX() && y == chess[play].getY()){
					st.setText("红棋走棋");
					chessColor = 2;
				}
				else{
					st.setText("黑棋走棋");
					chessColor = 1;
				}
			}
			else if(chessColor == 1 && chess[play].getName().charAt(0) == '黑'){

				x = chess[play].getX();
				y = chess[play].getY();
				//移动卒、兵
				if((play >= 11 && play <= 15)
						|| (play >= 27 && play <= 31)){
					rule.soldiesMoveRule(play, chess[play], me);
				}
				//移动炮
				else if((play >= 9 && play <= 10)
						|| (play >= 25 && play <= 26)){
					rule.cannonAndRookMoveRule(chess[play], chess, me);
				}
				//移动车
				else if((play >= 0 && play <= 1)
						|| (play >= 16 && play <= 17)){
					System.out.println("车要上下移动");
					rule.cannonAndRookMoveRule(chess[play], chess, me);
				}
				//移动马
				else if((play >= 2 && play <= 3)
						|| (play >= 18 && play <= 19)){
					rule.horseMoveRule(chess[play], chess, me);
				}
				//移动象
				else if((play >= 4 && play <= 5)
						|| (play >= 20 && play <= 21)){
					rule.ministerMoveRule(chess[play], chess, me);
				}
				//移动士
				else if((play >= 6 && play <= 7)
						|| (play >= 22 && play <= 23)){
					rule.advisorMoveRule(chess[play], me);
				}
				//移动将和帅
				else if((play == 8) || (play == 24)){
					rule.kingMoveRule(chess[play], me);
				}
				//默认红棋走棋，如果棋子在原地没动
				if(x == chess[play].getX() && y == chess[play].getY()){
					st.setText("黑棋走棋");
					chessColor = 1;
				}
				else{
					st.setText("红棋走棋");
					chessColor = 2;
				}
			
			}
			//当前没有任何操作时
			chessClick = false ;
		}
		else{
			//第一次鼠标点击
			if(!chessClick){
				System.out.println("棋子被点击");
				for(int i=0; i<32; i++){
					//鼠标如果点击的是棋子
					if(me.getSource().equals(chess[i])){
						play=i;
						//该棋子闪烁
						chessClick = true;
						break;
					}
				}
			}
			else if(chessClick){
				//停止棋子闪烁
				for(i=0; i<32; i++){
					//找到被吃的棋子
					if(me.getSource().equals(chess[i])){
						//红棋吃棋
						if(chessColor == 2 && chess[play].getName().charAt(0) == '红'){
							x = chess[play].getX();
							y = chess[play].getY();
							
							//卒子和兵吃棋子
							if((play >= 27 && play <= 31)){
								rule.soldiesKillRule(chess[play], chess[i]);
							}
							//炮吃棋子
							else if((play >= 9 && play <= 10)
									&&(play >= 25 && play <= 26)){
								rule.cannonAndRookKillRule(chess[play], chess[i], chess);
							}
							//车吃棋子
							else if((play >= 0 && play <= 1)
									&&(play >= 16 && play <= 17)){
								rule.cannonAndRookKillRule(chess[play], chess[i], chess);
							}
							//马吃棋子
							else if((play >= 2 && play <= 3)
									&&(play >= 18 && play <= 19)){
								rule.horseKillRule(chess[play], chess[i], chess);
							}
							//象吃棋子
							else if((play >= 4 && play <= 5)
									&&(play >= 20 && play <= 21)){
								rule.ministerKillRule(chess[play], chess[i], chess);
							}
							//士吃棋子
							else if((play >= 6 && play <= 7)
									&&(play >= 22 && play <= 23)){
								rule.advisorKillRule(chess[play], chess[i]);
							}
							//将、帅吃棋子
							else if((play == 8) || (play == 24)){
								rule.kingKillRule(chess[play], chess[i], chess);
								chess[play].setVisible(true);
							}
							//默认红棋走棋，如果棋子在原地没动
							if(x == chess[play].getX() && y == chess[play].getY()){
								st.setText("红棋走棋");
								chessColor = 2;
								break;
							}
							else{
								st.setText("黑棋走棋");
								chessColor = 1;
								break;
							}
						}
						else if(chessColor ==1 && chess[play].getName().charAt(0) == '黑'){

							x = chess[play].getX();
							y = chess[play].getY();
							
							//卒子和兵吃棋子
							if((play >= 11 && play<=15)
									||(play >= 27 && play <= 31)){
								rule.soldiesKillRule(chess[play], chess[i]);
							}
							//炮吃棋子
							else if((play >= 9 && play <= 10)
									&&(play >= 25 && play <= 26)){
								rule.cannonAndRookKillRule(chess[play], chess[i], chess);
							}
							//车吃棋子
							else if((play >= 0 && play <= 1)
									&&(play >= 16 && play <= 17)){
								rule.cannonAndRookKillRule(chess[play], chess[i], chess);
							}
							//马吃棋子
							else if((play >= 2 && play <= 3)
									&&(play >= 18 && play <= 19)){
								rule.horseKillRule(chess[play], chess[i], chess);
							}
							//象吃棋子
							else if((play >= 4 && play <= 5)
									&&(play >= 20 && play <= 21)){
								rule.ministerKillRule(chess[play], chess[i], chess);
							}
							//士吃棋子
							else if((play >= 6 && play <= 7)
									&&(play >= 22 && play <= 23)){
								rule.advisorKillRule(chess[play], chess[i]);
							}
							//将、帅吃棋子
							else if((play == 8) || (play == 24)){
								rule.kingKillRule(chess[play], chess[i], chess);
								chess[play].setVisible(true);
							}
							//默认红棋走棋，如果棋子在原地没动
							if(x == chess[play].getX() && y == chess[play].getY()){
								st.setText("红棋走棋");
								chessColor = 2;
								break;
							}
							else{
								st.setText("黑棋走棋");
								chessColor = 1;
								break;
							}
						}
					}
				}
				//当前没有任何操作时
				chessClick = false ;
				
				if(!chess[24].isVisible()){
					JOptionPane.showConfirmDialog(
						this,"黑棋胜利","玩家一胜利",
						JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
					//双方都不可以在走棋了
					chessColor = 3;
					st.setText("黑棋胜利");
				}
				else if (!chess[8].isVisible()){
					JOptionPane.showConfirmDialog(
						this,"红棋胜利","玩家二胜利",
						JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
					chessColor=3;
					st.setText("红棋胜利");
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
