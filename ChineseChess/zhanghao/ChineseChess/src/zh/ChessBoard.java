package zh;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChessBoard extends JPanel{

	ChessPieces chessPieces;
    //定义棋盘大小
    private static int Borad_WidthSize=9;
    private static int Borad_HigthSize=10;
    //定义棋盘像素
    private final int Table_Width=555;
    private final int Table_Hight=618;
    //棋框大小
    //private final int Chess_Width=456;
    //private final int Chess_Hight=515;
    //方格大小
    private final int Box_Width=57;
    private final int Box_Hight=57;
    //定义棋盘坐标像素值与棋盘数组的比率
    //private final int Xrate=Chess_Width/Borad_WidthSize;
    //private final int Yrate=Chess_Hight/Borad_HigthSize;
    //定义棋盘坐标的像素值和棋盘数组之间的偏移距离
    private final int X_offset=25;
    private final int Y_offset=25;
    
    public void init() throws IOException{
    	chessPieces=new ChessPieces();
    	//游戏窗口
        JFrame f=new JFrame("中国象棋");
        
    	//画布大小
    	this.setPreferredSize(new Dimension(Table_Width,Table_Hight));
    	//绘制棋盘和棋子
    	this.repaint();
    	f.add(this);
    	f.pack();
    	f.setVisible(true);
    }
    public void paint(Graphics g){
    	//棋盘
    	g.drawImage(chessPieces.getTable(), 0, 0, null);
				
    	//绘制黑方棋子
    	g.drawImage(chessPieces.getBlackcar(), 0*Box_Width+X_offset, 0*Box_Hight+Y_offset, null);//车
    	g.drawImage(chessPieces.getBlackhorse(), 1*Box_Width+X_offset, 0*Box_Hight+Y_offset, null);//马
    	g.drawImage(chessPieces.getBlackelephant(), 2*Box_Width+X_offset, 0*Box_Hight+Y_offset, null);//象
    	g.drawImage(chessPieces.getBlackofficia(), 3*Box_Width+X_offset, 0*Box_Hight+Y_offset, null);//士
    	g.drawImage(chessPieces.getBlackgenera(), 4*Box_Width+X_offset, 0*Box_Hight+Y_offset, null);//将
    	g.drawImage(chessPieces.getBlackofficia(), 5*Box_Width+X_offset, 0*Box_Hight+Y_offset, null);//士
    	g.drawImage(chessPieces.getBlackelephant(), 6*Box_Width+X_offset, 0*Box_Hight+Y_offset, null);//象
    	g.drawImage(chessPieces.getBlackhorse(), 7*Box_Width+X_offset, 0*Box_Hight+Y_offset, null);//马
    	g.drawImage(chessPieces.getBlackcar(), 8*Box_Width+X_offset, 0*Box_Hight+Y_offset, null);//车	
    	g.drawImage(chessPieces.getBlackcannon(), 1*Box_Width+X_offset, 2*Box_Hight+Y_offset, null);//炮
    	g.drawImage(chessPieces.getBlackcannon(), 7*Box_Width+X_offset, 2*Box_Hight+Y_offset, null);//炮	
    	g.drawImage(chessPieces.getBlacksoldier(), 0*Box_Width+X_offset, 3*Box_Hight+Y_offset, null);//卒
    	g.drawImage(chessPieces.getBlacksoldier(), 2*Box_Width+X_offset, 3*Box_Hight+Y_offset, null);//卒
    	g.drawImage(chessPieces.getBlacksoldier(), 4*Box_Width+X_offset, 3*Box_Hight+Y_offset, null);//卒
    	g.drawImage(chessPieces.getBlacksoldier(), 6*Box_Width+X_offset, 3*Box_Hight+Y_offset, null);//卒
    	g.drawImage(chessPieces.getBlacksoldier(), 8*Box_Width+X_offset, 3*Box_Hight+Y_offset, null);//卒
    	    		
    	//绘制红方棋子
        g.drawImage(chessPieces.getRedcar(), 0*Box_Width+X_offset, 9*Box_Hight+Y_offset, null);//车
    	g.drawImage(chessPieces.getRedhorse(), 1*Box_Width+X_offset, 9*Box_Hight+Y_offset, null);//马
    	g.drawImage(chessPieces.getRedelephant(), 2*Box_Width+X_offset, 9*Box_Hight+Y_offset, null);//象
    	g.drawImage(chessPieces.getRedofficia(), 3*Box_Width+X_offset, 9*Box_Hight+Y_offset, null);//士
    	g.drawImage(chessPieces.getRedgenera(), 4*Box_Width+X_offset, 9*Box_Hight+Y_offset, null);//将
    	g.drawImage(chessPieces.getRedofficia(), 5*Box_Width+X_offset, 9*Box_Hight+Y_offset, null);//士
    	g.drawImage(chessPieces.getRedelephant(), 6*Box_Width+X_offset, 9*Box_Hight+Y_offset, null);//象
    	g.drawImage(chessPieces.getRedhorse(), 7*Box_Width+X_offset, 9*Box_Hight+Y_offset, null);//马
    	g.drawImage(chessPieces.getRedcar(), 8*Box_Width+X_offset, 9*Box_Hight+Y_offset, null);//车	
    	g.drawImage(chessPieces.getRedcannon(), 1*Box_Width+X_offset, 7*Box_Hight+Y_offset, null);//炮
    	g.drawImage(chessPieces.getRedcannon(), 7*Box_Width+X_offset, 7*Box_Hight+Y_offset, null);//炮	
    	g.drawImage(chessPieces.getRedsoldier(), 0*Box_Width+X_offset, 6*Box_Hight+Y_offset, null);//卒
    	g.drawImage(chessPieces.getRedsoldier(), 2*Box_Width+X_offset, 6*Box_Hight+Y_offset, null);//卒
    	g.drawImage(chessPieces.getRedsoldier(), 4*Box_Width+X_offset, 6*Box_Hight+Y_offset, null);//卒
    	g.drawImage(chessPieces.getRedsoldier(), 6*Box_Width+X_offset, 6*Box_Hight+Y_offset, null);//卒
    	g.drawImage(chessPieces.getRedsoldier(), 8*Box_Width+X_offset, 6*Box_Hight+Y_offset, null);//卒
    	
     }
}

