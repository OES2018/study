package com.zhouziyin.ChineseChess.main;

import com.zhouziyin.ChineseChess.controller.Controller;
import com.zhouziyin.ChineseChess.entity.Board;
import com.zhouziyin.ChineseChess.entity.Man;
import com.zhouziyin.ChineseChess.menu.ChessMenu;
import com.zhouziyin.ChineseChess.panel.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by zhouziyin on 2017/12/8.
 */
public class ChineseChess extends JFrame {

    public ChineseChess() throws IOException{

        //创建游戏中的对象
        Board chessBoard = new Board();
        Man chessMan = new Man();
        GamePanel gamePanel = new GamePanel();
        Controller controller = new Controller(gamePanel,chessBoard,chessMan);

        //添加游戏面板
        this.add(gamePanel);
        //设置菜单栏
        this.setJMenuBar(new ChessMenu().getChessMenu());
        //把进入窗口的鼠标设置为手型
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //设置标题
        this.setTitle("中国象棋");
        //添加鼠标监听
        this.addMouseListener(controller);
        //设置窗口的图标
        this.setIconImage(ImageIO.read(new File("src/res/chess.jpg")));
        // 设置窗口大小
        this.setSize(605, 710);
        // 设置窗口默认关闭方式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置窗口大小不可改变
        this.setResizable(false);
        // 设置窗口居中
        this.setLocationRelativeTo(null);
        // 设置窗口显示
        this.setVisible(true);
    }

    /*
     *功能：main函数
     */
    public static void main(String[] args){
        try{
            //把游戏界面设置为本地界面风格
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            //创建游戏
            new ChineseChess();
        }catch (Exception e){
            System.exit(0);
        }
    }

}
