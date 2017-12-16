package zf.chinesechess;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.Timer;


public class ChessBoard extends JFrame implements MouseListener, ActionListener{
	Container con;
	//创建工具栏
    JToolBar jtool;
    Graphics cg;
    
    //棋盘,棋子
    JPanel board;
    ChessPiece chess;
    //按钮，提示
    JButton start;
    JButton exit;
    JLabel hint;
    
    //记录参数,第一个参数：点击棋子的下标；第二个：1表示黑棋先走，2表示红棋先走；第三个：棋子被点击时为true
    static Object[] para={0,2,false};
    
    //线程
    Thread t; //控制闪烁棋子，表明选中
    MyThread tm;
    boolean flag;
    
	public ChessBoard(){
		/* 设置窗体的样式 */
		this.setTitle("Chinese Chess");
		this.setIconImage(new ImageIcon("images\\黑将.gif").getImage());
        this.setSize(630,720);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null); //居中显示
        
        
        /* 获取当前面板 */
        con = this.getContentPane();
        con.setBackground(Color.white);        
    	con.setLayout(null);
    	
    	
        /* 创建工具栏，并将工具栏添加到当前布局中*/
        jtool = new JToolBar();
        jtool.setBounds(0, 0, 630, 50);
        jtool.setBackground(Color.white);
        jtool.setPreferredSize(jtool.getSize());
        con.add(jtool);
        
        //创建控件，并添加到工具栏中
        start = new JButton("重新开始");
        start.setFont(new Font("微软雅黑", Font.BOLD, 15));
        start.setBackground(new Color(255, 250, 250));
        start.setToolTipText("开始游戏");     
        
        exit = new JButton("退出");
        exit.setFont(new Font("微软雅黑", Font.BOLD, 15));
        exit.setBackground(new Color(255, 250, 250));
        exit.setToolTipText("退出游戏");
        
        hint = new JLabel(" 欢迎进入游戏:红棋先走  ", JLabel.CENTER);
        hint.setFont(new Font("微软雅黑", Font.BOLD, 15));
        
        jtool.setLayout(new GridLayout(0,3));
        jtool.add(start);
        jtool.add(exit);
        jtool.add(hint);
        
        //注册按扭监听
        start.addActionListener(this);
      	exit.addActionListener(this);
        
      	/*  添加棋子  */
        chess = new ChessPiece(); 
		for(int i=0;i<32;i++){
			con.add(chess.chesspiece[i]);
			chess.chesspiece[i].addMouseListener(this); //添加鼠标监听事件
		}
		chess.drawChess();
		
      	/* 获取当前面板的绘图对象，并绘制棋盘*/
//      //	由于paint方法会自动调用，而这里要调用paintChessBoard会看不到绘图结果，需要在调用前之前插入一段代码，让进程等待500毫秒
//      	 try {
//      		 Thread.sleep(100);
//      		 } catch (Exception e) {
//      			 e.printStackTrace();
//      			 }  
		
		/*   棋盘      */
		board = new JPanel();
		board.setBounds(0, 0, 630, 670);
		board.setBackground(Color.white);
        board.setPreferredSize(board.getSize());
		con.add(board);
      	cg = board.getGraphics();
      //	paintChessBoard(cg);
      	//设置一个定时器，定时更新，防止被JFrame的paint覆盖掉
      	Timer t = new Timer(10, new ActionListener() {      		 
            @Override
            public void actionPerformed(ActionEvent e) {
            	paintChessBoard(cg);
            }
        });
        t.start();//开始执行Timer 
        board.addMouseListener(this); //棋盘监听
        
        /*  添加窗体监听  */
        this.addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e){  
                System.exit(0);  
            }  
        });  
    }  
	
	/*  绘制棋盘,该方法重写了JFrame中的paint方法，自动调用 ；也可以设置定时器,定时刷新      */  
    public void paintChessBoard(Graphics g){ 
    	//super.paint(g);
        Font f=new Font("微软雅黑",Font.BOLD,30);  
        g.setFont(f);
        g.setColor(new Color(185,24,24));         
        g.drawRect(60, 80, 500, 560);  //外圈  
        g.drawRect(70, 90, 480, 540);  //内圈
        
        /*横线部分*/  
        int length=150; 
        for(int i=1;i<9;i++){  
        	g.drawLine(70, length, 550, length);  
        	length += 60;
        	// 中间汉字  
        	g.drawString("楚  河", 130, 370);
        	g.drawString("汉  界", 400, 370);  
        }  
         
        /*上半部分竖线*/  
        length=130; 
        for(int i=0;i<7;i++){  
            g.drawLine( length, 90, length, 330);  
            length += 60;  
        }  
        
        /*下半部分竖线*/  
        length=130;        
        for(int i=0;i<7;i++){  
            g.drawLine( length, 390, length, 630);  
            length += 60;  
        }  
        
        /*上半部分九宫格斜线*/
        g.drawLine(250, 90, 370, 210);
        g.drawLine(370, 90, 250, 210);  
  
        /*下半部分九宫格斜线*/
        g.drawLine(250, 510, 370, 630);
        g.drawLine(250, 630, 370, 510);  
        }  
   
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub		
		System.out.println((int)para[0]+" "+(int)para[1]+" "+(boolean)para[2]);
		para=(new MouseClickedEvent()).mouseClicked(e, chess, hint, (int)para[0], (int)para[1], (boolean)para[2]);
		flag=true;
		//启动线程
		if (t==null){
//			tm=new MyThread((int)para[0], hint, (boolean)para[2]);
//			t=new Thread(tm);
			t= new Thread(){
				public void run(){
					while (flag){
						//单击棋子第一下开始闪烁
						if ((boolean)para[2]){
							chess.chesspiece[(int)para[0]].setVisible(false);
							//时间控制
							try{
								Thread.sleep(200);
								}catch(Exception e){
								}				
							chess.chesspiece[(int)para[0]].setVisible(true);
							}
						
						//闪烁当前提示信息
						else {
							hint.setVisible(false);
							try{
								Thread.sleep(350);
								}catch(Exception e){									
								}		
							hint.setVisible(true);
						//	hint.setForeground(Color.red);
							}
						try{
							Thread.sleep(300);
							}
						catch (Exception e){
						}
						}
					}
				};
				t.start();
				}
		
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
		//System.out.println(e.getSource().equals(start));
		if(e.getSource().equals(start)){
				/*  重排棋子  */
				chess.drawChess();
				for(int i=0;i<32;i++){
					chess.chesspiece[i].setVisible(true);
					chess.chesspiece[i].addMouseListener(this); //添加鼠标监听事件
				}
				//参数初始化
				para[0]=0;
				para[1]=2;
				para[2]=false;
				//提示信息初始化
				hint.setText("  欢迎进入游戏:红棋先走");
				//hint.setForeground(Color.black);
				//关闭前一个线程
				flag=false;
				t=null;
				}
		else{
			int j=JOptionPane.showConfirmDialog(
					null,"真的要退出游戏吗?","退出",
					JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
			if (j == JOptionPane.YES_OPTION){
				System.exit(0);
				}
			}
		}

	
	}  
