package lz.ChineseChese;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ImageCapabilities;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;
public class CheseBoard extends JFrame implements ActionListener {
	public static void main(String[] args){
		new CheseBoard("初级象棋对战系统");
	}
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
	//构造函数初始化一个窗口
	public CheseBoard(String title){
		ChesePiece piece;
		//获得窗口引用
		con = this.getContentPane();
		con.setLayout(null);
		
		//创建工具栏并初始化按钮
		menu = new JToolBar();
		st = new JLabel("欢迎使用，祝您愉快！");
		st.setToolTipText("信息提示");
		start = new JButton(" 开 始 ");
		start.setToolTipText("开始新的游戏");
		restart = new JButton(" 重新开始 ");
		restart.setToolTipText("重新开始新的游戏");
		exit = new JButton(" 退 出 ");
		exit.setToolTipText("退出游戏");
		
		//把按钮添加到菜单中
		menu.setLayout(new GridLayout(0,4));
		menu.add(start);
		menu.add(restart);
		menu.add(exit);
		menu.add(st);
		menu.setBounds(0,0,538,30);
		con.add(menu);
		
		//添加棋子标签,注意要先添加棋子添加棋盘，JLabel的添加顺序是从外向内，最后添加的棋盘在底层不会遮挡棋子
		piece = new ChesePiece(con);
		
		//添加棋盘标签，注意文件路径最好使用File.separator的形式进行分割，保证路径信息不出现错位
		
		image = new JLabel(new ImageIcon("src"+File.separator+"image"+File.separator+"main.gif"));
		//image = new JLabel(new ImageIcon("..\\lz.ChineseChese\\src\\image\\main.gif"));
		con.add(image);
		image.setBounds(0, 30, 558, 620);
		
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
		//设置床就属性，由于本应用采用图片作为棋盘，所以窗口不能拉伸
		this.setResizable(true);
		this.setTitle(title);
		this.setSize(558, 670);
		this.show();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
