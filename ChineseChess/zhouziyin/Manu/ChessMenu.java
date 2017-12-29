package com.zhouziyin.ChineseChess.menu;

import com.zhouziyin.ChineseChess.controller.Controller;
import com.zhouziyin.ChineseChess.entity.Flag;
import com.zhouziyin.ChineseChess.entity.Man;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by zhouziyin on 2017/12/19.
 */
public class ChessMenu implements ActionListener {

    public JMenuBar getChessMenu(){
        //创建菜单栏
        JMenuBar menuBar = new JMenuBar();
        //创建菜单
        JMenu gameMenu = new JMenu("游戏");
        JMenu helpMenu = new JMenu("帮助");
        //创建菜单项
        JMenuItem startItem = new JMenuItem("开始游戏");
        startItem.addActionListener(this);
        JMenuItem openItem = new JMenuItem("打开游戏");
        openItem.addActionListener(this);
        JMenuItem saveItem = new JMenuItem("保存游戏");
        saveItem.addActionListener(this);
        JMenuItem gameItem =new JMenuItem("游戏设置");
        gameItem.addActionListener(this);
        JMenuItem exitItem = new JMenuItem("退出游戏");
        exitItem.addActionListener(this);
        //把菜单项添加到菜单
        gameMenu.add(startItem);
        gameMenu.add(openItem);
        gameMenu.add(saveItem);
        gameMenu.addSeparator();
        gameMenu.add(gameItem);
        gameMenu.addSeparator();
        gameMenu.add(exitItem);
        //把菜单添加到菜单栏
        menuBar.add(gameMenu);
        menuBar.add(helpMenu);
        //返回菜单栏
        return menuBar;

    }


    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("开始游戏")){
            startGame();
        }
    }


    /*
     *功能：初始化游戏
     */
    public void startGame(){
        //设置棋子的初始位置
        int [][] initFlag={
                {1,2,3,4,5,4,3,2,1},
                {0,0,0,0,0,0,0,0,0},
                {0,6,0,0,0,0,0,6,0},
                {7,0,7,0,7,0,7,0,7},
                {0,0,0,0,0,0,0,0,0},

                {0,0,0,0,0,0,0,0,0},
                {8,0,8,0,8,0,8,0,8},
                {0,9,0,0,0,0,0,9,0},
                {0,0,0,0,0,0,0,0,0},
                {10,11,12,13,14,13,12,11,10}
        };
        //创建棋子坐标对象
        Man chessMan = new Man();
        //初始化棋子的坐标
        chessMan.setChessFlag(initFlag);
        //设置游戏为开始状态
        Controller.showGame();

    }

    /*
     *功能：读取游戏存盘
     */
    public void openGame(){
        try{
            //创建文件选择器
            JFileChooser fileChooser = new JFileChooser();
            //显示打开文件对话框
            fileChooser.showOpenDialog(null);
            //获取打开的文件绝对路径
            String filepath = fileChooser.getSelectedFile().getAbsolutePath();
            //创建对象输入流
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath));
            Flag chessFlag = (Flag) ois.readObject();

            //创建棋子坐标对象
            Man chessMan = new Man();
            //初始化棋子的坐标
            chessMan.setChessFlag(chessFlag.getChessFlag());
            //设置游戏为开始状态
            Controller.setGameover(false);
            //重新显示游戏界面
            Controller.showGame();
            //关闭对象流
            ois.close();
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"读取游戏存盘失败");
        }
    }

    /*
     *功能：游戏存盘

     */
    public void saveGame(){
        try{
            //创建文件选择器
            JFileChooser fileChooser = new JFileChooser();
            //显示保存文件对话框
            fileChooser.showSaveDialog(null);
            //获取保存的文件绝对路径
            String filename = fileChooser.getSelectedFile().getAbsolutePath();
            //创建对象输出流
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            //创建棋子坐标对象
            Flag chessFlag = new Flag();
            chessFlag.setChessFlag(new Man().getChessFlag());
            //输出棋子的坐标
            oos.writeObject(chessFlag);
            //关闭对象流
            oos.close();
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"游戏存盘失败");
        }
    }

}
