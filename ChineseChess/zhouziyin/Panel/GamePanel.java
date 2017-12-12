package com.zhouziyin.ChineseChess.panel;

import com.zhouziyin.ChineseChess.entity.Board;
import com.zhouziyin.ChineseChess.entity.Man;
import com.zhouziyin.ChineseChess.util.FontUtil;

import javax.swing.*;
import java.awt.*;

/**
 * Created by zhouziyin on 2017/12/8.
 */
public class GamePanel extends JPanel {

    private Board chess = new Board();
    private Man chessMan = new Man();
    private int message = 0;

    // 重新显示游戏界面
    public void dispaly(Board chess, Man chessMan) {
        this.chess = chess;
        this.chessMan = chessMan;
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        // 设置背景色
        g.setColor(new Color(216,196,160));
        // 绘制背景
        g.fillRect(0, 0, 605, 690);

        // 绘制棋盘和棋子
        if (chess != null && chessMan != null) {
            chess.drawChess(g);
            chessMan.drawChessMan(g);
        }


        // 绘制游戏信息
        if(message != 0){
            g.setColor(Color.RED);
            g.setFont(FontUtil.myFont3);
            if(message == 1){
                g.drawString("黑棋获胜", getWidth()/2-150, getHeight()/2+15);
            }else if(message == 2){
                g.drawString("红棋获胜", getWidth()/2-150, getHeight()/2+15);
            }
            message = 0;
        }
    }

    public void setMessage(int message){
        this.message = message;
    }
}
