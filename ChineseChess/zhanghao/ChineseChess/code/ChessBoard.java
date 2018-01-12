package zh;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChessBoard extends JFrame implements ActionListener,MouseListener,Runnable{

	//32颗棋子
	JLabel play[] = new JLabel[32];
	ChessPieces chessPieces;//棋子图片
	//棋盘
	JLabel image;	
	//窗格
	Container con;
	
	//规则类对象,用于棋子移动以及吃子，输赢等规则
	ChessRule rule;
	
	/**
	** 单击棋子
	** chessManClick = true 闪烁棋子 并给线程响应
	** chessManClick = false 吃棋子 停止闪烁  并给线程响应
	*/
	boolean chessManClick;
	
	/**
	** 控制玩家走棋
	** chessPlayClick=1 黑棋走棋
	** chessPlayClick=2 红棋走棋
	** chessPlayClick=3 双方都不能走棋
	*/
	int chessPlayClick=2;//默认红棋开始先走
	
	//控制棋子闪烁的线程
	static Thread tmain;
	//把第一次的单击棋子给线程响应
	static int Man,i;
	

	ChessBoard() throws IOException{
		new ChessBoard("中国象棋");
	}
	//有参构造函数
	ChessBoard(String Title) throws IOException{
		//获取窗格引用
		con = this.getContentPane();
		con.setLayout(null);
		chessPieces=new ChessPieces();
		//实例化规则类
		rule = new ChessRule();
		
		//添加棋子
	    drawChessMan();
	    //注册棋子移动监听
	    for (int i=0;i<32;i++){
	  		con.add(play[i]);
	  		play[i].addMouseListener(this);
	  	}
	    //添加棋盘标签
	    con.add(image = new JLabel(chessPieces.getTable()));
	    image.setBounds(0,30,558,620);//设置棋盘大小
	    image.addMouseListener(this);//注册棋盘监听事件
	    
	    //注册窗体关闭监听
	  	this.addWindowListener(
	  		new WindowAdapter() {
	  			public void windowClosing(WindowEvent we){
	  				System.exit(0);
	  			}
	  		}
	  	);
	  	
		//窗体居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getSize();
		
		if (frameSize.height > screenSize.height){
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width){
			frameSize.width = screenSize.width;
		}
		
		this.setLocation((screenSize.width - frameSize.width) / 2 - 280 ,(screenSize.height - frameSize.height ) / 2 - 350);
	
		//设置
		//this.setIconImage(chessPieces.getRedgenera().getImage());
		this.setResizable(false);
		this.setTitle(Title);
		this.setSize(558,670);
		this.setVisible(true);
	}
	
	//添加棋子方法
	public void drawChessMan() {
		//流程控制
		int i,k;
		//图标
		Icon in;
						
		//黑色棋子		
		//车
		in = chessPieces.getBlackcar();
		for (i=0,k=24;i<2;i++,k+=456){		
			play[i] = new JLabel(in);
			play[i].setBounds(k,56,55,55);	
			play[i].setName("车1"+i);//加i的目的是让每个棋子有独一无二的名字			
		}	
				
		//马
		in = chessPieces.getBlackhorse();
		for (i=4,k=81;i<6;i++,k+=342){	
			play[i] = new JLabel(in);
			play[i].setBounds(k,56,55,55);
			play[i].setName("马1"+i);
		}
				
		//相
		in = chessPieces.getBlackelephant();
		for (i=8,k=138;i<10;i++,k+=228){	
			play[i] = new JLabel(in);
			play[i].setBounds(k,56,55,55);
			play[i].setName("象1"+i);
		}
				
		//士
		in = chessPieces.getBlackofficia();
		for (i=12,k=195;i<14;i++,k+=114){
			play[i] = new JLabel(in);
			play[i].setBounds(k,56,55,55);
			play[i].setName("士1"+i);
		}
				
		//卒
		in = chessPieces.getBlacksoldier();
		for (i=16,k=24;i<21;i++,k+=114){
			play[i] = new JLabel(in);
			play[i].setBounds(k,227,55,55);
			play[i].setName("卒1"+i);
		}
				
		//炮
		in = chessPieces.getBlackcannon();			
		for (i=26,k=81;i<28;i++,k+=342){
			play[i] = new JLabel(in);
			play[i].setBounds(k,170,55,55);
			play[i].setName("炮1"+i);
		}
				
		//将
		in = chessPieces.getBlackgenera();
		play[30] = new JLabel(in);
		play[30].setBounds(252,56,55,55);
		play[30].setName("将1");

		//红色棋子
		//车
		in = chessPieces.getRedcar();
		for (i=2,k=24;i<4;i++,k+=456){
			play[i] = new JLabel(in);
			play[i].setBounds(k,569,55,55);
			play[i].setName("车2"+i);
		}
				
		//马
		in = chessPieces.getRedhorse();
		for (i=6,k=81;i<8;i++,k+=342){
			play[i] = new JLabel(in);
			play[i].setBounds(k,569,55,55);
			play[i].setName("马2"+i);
		}
				
		//相
		in = chessPieces.getRedelephant();			
		for (i=10,k=138;i<12;i++,k+=228){
			play[i] = new JLabel(in);
			play[i].setBounds(k,569,55,55);
			play[i].setName("象2"+i);
		}
				
	    //士
		in = chessPieces.getRedofficia();
		for (i=14,k=195;i<16;i++,k+=114){
			play[i] = new JLabel(in);
			play[i].setBounds(k,569,55,55);
			play[i].setName("士2"+i);
		}
				
		//兵
		in = chessPieces.getRedsoldier();
		for (i=21,k=24;i<26;i++,k+=114){
			play[i] = new JLabel(in);
			play[i].setBounds(k,398,55,55);
			play[i].setName("卒2"+i);
		}
				
		//炮
		in = chessPieces.getRedcannon();
		for (i=28,k=81;i<30;i++,k+=342){
			play[i] = new JLabel(in);
			play[i].setBounds(k,455,55,55);
			play[i].setName("炮2"+i);
		}
				
		//帅
		in = chessPieces.getRedgenera();			
		play[31] = new JLabel(in);
		play[31].setBounds(252,569,55,55);		
		play[31].setName("帅2");
	}
	
	/**
	** 线程方法控制棋子闪烁
	*/
	@Override
	public void run() {
		while (true){
			//单击棋子第一下开始闪烁
			if (chessManClick){
				play[Man].setVisible(false);

				//时间控制
				try{
					tmain.sleep(200);
				}
				catch(Exception e){
				}
				
				play[Man].setVisible(true);
			}
			
			try{
				tmain.sleep(350);
			}
			catch (Exception e){
			}
		}
	}

	
	/**
	** 单击棋子方法,完成移动棋子，吃棋子等逻辑
	*/
	@Override
	public void mouseClicked(MouseEvent me) {
		//当前坐标
		int Ex=0,Ey=0;
				
		//启动线程
		if (tmain == null){
			tmain = new Thread(this);
			tmain.start();
		}
		
		//点击棋盘移动棋子
		if (me.getSource().equals(image)){
			//该红棋走棋的时候
			if (chessPlayClick == 2 && play[Man].getName().charAt(1) == '2'){	
				Ex = play[Man].getX();
				Ey = play[Man].getY();
				//移动卒、兵
				if (Man > 15 && Man < 26){
					rule.armsRule(Man,play[Man],me);
				}
				//移动炮
				else if (Man > 25 && Man < 30){			
					rule.cannonRule(play[Man],play,me);
				}
                //移动车
				else if (Man >=0 && Man < 4){
					rule.cannonRule(play[Man],play,me);
				}
				//移动马
				else if (Man > 3 && Man < 8){
					rule.horseRule(play[Man],play,me);
				}
				//移动相、象
				else if (Man > 7 && Man < 12){
					rule.elephantRule(Man,play[Man],play,me);
				}
				//移动仕、士
				else if (Man > 11 && Man < 16){
					rule.chapRule(Man,play[Man],play,me);
				}
				//移动将、帅
				else if (Man == 30 || Man == 31){				
					rule.willRule(Man,play[Man],play,me);
				}
				//是否走棋错误(是否在原地没有动)
				if (Ex == play[Man].getX() && Ey == play[Man].getY()){
					chessPlayClick=2;
				}
				//红棋走完后黑棋走
				else{
					chessPlayClick = 1;
				}
			}
			//该黑棋走棋的时候
			else if (chessPlayClick == 1 && play[Man].getName().charAt(1) == '1'){
				Ex = play[Man].getX();
				Ey = play[Man].getY();
				//移动卒、兵
				if (Man > 15 && Man < 26){
					rule.armsRule(Man,play[Man],me);
				}
				//移动炮
				else if (Man > 25 && Man < 30){			
					rule.cannonRule(play[Man],play,me);
				}
                //移动车
				else if (Man >=0 && Man < 4){
					rule.cannonRule(play[Man],play,me);
				}
                //移动马
				else if (Man > 3 && Man < 8){
					rule.horseRule(play[Man],play,me);
				}
				//移动相、象
				else if (Man > 7 && Man < 12){
					rule.elephantRule(Man,play[Man],play,me);
				}
				//移动仕、士
				else if (Man > 11 && Man < 16){
					rule.chapRule(Man,play[Man],play,me);
				}
				//移动将、帅
				else if (Man == 30 || Man == 31){
					rule.willRule(Man,play[Man],play,me);
				}
                //是否走棋错误(是否在原地没有动)
				if (Ex == play[Man].getX() && Ey == play[Man].getY()){
					chessPlayClick=1;
				}
				//黑棋走完后红棋走
				else{
					chessPlayClick = 2;
				}
			}
			//当前没有操作(停止闪烁)
			chessManClick=false;
		}
		
		//点击棋子
		else{
			//第一次单击棋子(闪烁棋子)
			if (!chessManClick){
				for (int i=0;i<32;i++){
					//被单击的棋子
					if (me.getSource().equals(play[i])){
						//告诉线程让该棋子闪烁
						Man=i;
						//开始闪烁
						chessManClick=true;
						break;
					}//if
				}//for
			}//if
			
			//第二次单击棋子(单击要吃掉的棋子)
			else if (chessManClick){
				//当前没有操作(停止闪烁)
				chessManClick=false;
				
				for (i=0;i<32;i++){
					//找到被吃的棋子
					if (me.getSource().equals(play[i])){
						//该红棋吃棋的时候
						if (chessPlayClick == 2 && play[Man].getName().charAt(1) == '2'){
							Ex = play[Man].getX();
							Ey = play[Man].getY();
							
							//卒、兵吃规则
							if (Man > 15 && Man < 26){
								rule.armsRule(play[Man],play[i]);
							}

							//炮吃规则
							else if (Man > 25 && Man < 30){
								rule.cannonRule(0,play[Man],play[i],play,me);
							}
							
							//车吃规则
							else if (Man >=0 && Man < 4){
								rule.cannonRule(1,play[Man],play[i],play,me);
							}
		
							//马吃规则
							else if (Man > 3 && Man < 8){
								rule.horseRule(play[Man],play[i],play,me);	
							}
							
							//相、象吃规则
							else if (Man > 7 && Man < 12){
								rule.elephantRule(play[Man],play[i],play);
							}
							
							//士、仕吃棋规则
							else if (Man > 11 && Man < 16){
								rule.chapRule(Man,play[Man],play[i],play);
							}
							
							//将、帅吃棋规则
							else if (Man == 30 || Man == 31){
								rule.willRule(Man,play[Man],play[i],play);
								play[Man].setVisible(true);	
							}

							//是否走棋错误(是否在原地没有动)
							if (Ex == play[Man].getX() && Ey == play[Man].getY()){
								chessPlayClick=2;
								break;
							}

							//红棋吃完黑棋后由黑棋走棋
							else{
								chessPlayClick=1;
								break;
							}
						}
						
						//该黑棋吃棋的时候
						else if (chessPlayClick == 1 && play[Man].getName().charAt(1) == '1'){
							Ex = play[Man].getX();
							Ey = play[Man].getY();
													
							//卒吃规则
							if (Man > 15 && Man < 26){
								rule.armsRule(play[Man],play[i]);
							}

						    //炮吃规则
							else if (Man > 25 && Man < 30){
								rule.cannonRule(0,play[Man],play[i],play,me);
							}
							
							//车吃规则
							else if (Man >=0 && Man < 4){
								rule.cannonRule(1,play[Man],play[i],play,me);
							}

							//马吃规则
							else if (Man > 3 && Man < 8){
								rule.horseRule(play[Man],play[i],play,me);
							}
							
							//相、象吃规则
							else if (Man > 7 && Man < 12){
								rule.elephantRule(play[Man],play[i],play);
							}
							
							//士、仕吃棋规则
							else if (Man > 11 && Man < 16){
								rule.chapRule(Man,play[Man],play[i],play);
							}
							
							//将、帅吃棋规则
							else if (Man == 30 || Man == 31){
								rule.willRule(Man,play[Man],play[i],play);
								play[Man].setVisible(true);			
							}
							
							//是否走棋错误(是否在原地没有动)
							if (Ex == play[Man].getX() && Ey == play[Man].getY()){
								chessPlayClick=1;
								break;
							}

							//黑棋吃完红棋后由红棋走棋
							else{
								chessPlayClick=2;
								break;
							}
						}
					}//if
				}//for
			}//else if
		}//else
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}

