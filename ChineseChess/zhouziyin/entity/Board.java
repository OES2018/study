package com.zhouziyin.ChineseChess.entity;

import com.zhouziyin.ChineseChess.util.FontUtil;

import java.awt.*;

/**
 * Created by zhouziyin on 2017/12/8.
 */
public class Board {

    /*
    *功能：画出象棋的棋盘
     */

    public void drawChess(Graphics g){
        //转成2D模式
        Graphics2D g2d = (Graphics2D) g;

        //得到当前的画刷
        Stroke stroke = g2d.getStroke();
        g2d.setColor(Color.BLACK);

        //设置新的画刷
        g2d.setStroke(new BasicStroke(4));
        g2d.drawRect(49,49,501,561);

        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(60,60,540,60);
        g2d.drawLine(60,300,540,300);
        g2d.drawLine(60,360,540,360);
        g2d.drawLine(60,600,540,600);
        g2d.drawLine(60,60,60,600);
        g2d.drawLine(540,60,540,600);

        // 画黑炮的位置
        drawFlag(g2d, true, true, 120, 180);
        drawFlag(g2d, true, true, 480, 180);

        // 画红炮的位置
        drawFlag(g2d, true, true, 120, 480);
        drawFlag(g2d, true, true, 480, 480);

        // 画兵的位置
        drawFlag(g2d, false, true, 60, 240);
        for (int x = 180; x <= 480; x += 120) {
            drawFlag(g2d, true, true, x, 240);
        }
        drawFlag(g2d, true, false, 540, 240);

        // 画卒的位置
        drawFlag(g2d, false, true, 60, 420);
        for (int x = 180; x <= 480; x += 120) {
            drawFlag(g2d, true, true, x, 420);
        }
        drawFlag(g2d, true, false, 540, 420);

        // 将画刷复原
        g2d.setStroke(stroke);

        // 画棋盘格子
        g.setColor(Color.BLACK);
        for (int i = 1; i <= 10; i++) {
            if (i <= 9) {
                g.drawLine(60 * i, 60, 60 * i, 600);
            }
            g.drawLine(60, 60 * i, 540, 60 * i);
        }

        // 画河界
        g.setColor(new Color(216, 196, 160));
        g2d.fillRect(61, 301, 478, 58);
        g2d.setColor(Color.BLACK);
        g2d.setFont(FontUtil.myFont2);
        g2d.drawString("河", 135, 340);
        g2d.drawString("界", 435, 340);

        // 画交叉线
        g2d.drawLine(240, 60, 360, 180);
        g2d.drawLine(240, 180, 360, 60);
        g2d.drawLine(240, 480, 360, 600);
        g2d.drawLine(240, 600, 360, 480);

    }

    /*
	 * 功能：绘制指定棋子位置的边框
	 * 参数leftFlag：是否绘制左边图形
	 * 参数rightFlag：是否绘制右边图形
	 * 参数x,y：表示绘制图形的中心坐标
	 */


    private void drawFlag(Graphics2D g2d, boolean leftFlag, boolean rightFlag,
                          int x, int y) {
        if (leftFlag) {
            g2d.drawLine(x - 5, y - 20, x - 5, y - 5);
            g2d.drawLine(x - 5, y + 20, x - 5, y + 5);
            g2d.drawLine(x - 20, y - 5, x - 5, y - 5);
            g2d.drawLine(x - 20, y + 5, x - 5, y + 5);
        }
        if (rightFlag) {
            g2d.drawLine(x + 5, y - 20, x + 5, y - 5);
            g2d.drawLine(x + 5, y + 20, x + 5, y + 5);
            g2d.drawLine(x + 5, y + 5, x + 20, y + 5);
            g2d.drawLine(x + 5, y - 5, x + 20, y - 5);
        }
    }

}
