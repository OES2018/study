package com.zhouziyin.ChineseChess.entity;

import com.zhouziyin.ChineseChess.util.FontUtil;

import java.awt.*;
import java.io.Serializable;

/**
 * Created by zhouziyin on 2017/12/8.
 */
public class Man implements Serializable {

    private int oldX = -1; // 棋子上一步所在位置的x坐标
    private int oldY = -1; // 棋子上一步所在位置的y坐标
    private int newX = -1; // 棋子现在所在位置的x坐标
    private int newY = -1; // 棋子现在所在位置的y坐标
    private boolean redMove = true; // 红棋先行
    private String[] chessStr = { "车", "马", "象", "士", "将", "炮", "卒", "兵", "炮", "车", "马", "相", "士", "帅" };
    private static int[][] chessFlag = new Flag().getChessFlag();
    private boolean[][] select = new boolean[10][9]; // 保存棋子被选中的坐标

    /*
	 * 功能： 画出象棋棋盘中的棋子
	 */
    public void drawChessMan(Graphics g){
        //转成2D模式
        Graphics g2d = (Graphics) g;
        //获取当前的画刷
        Stroke stroke = g2d.getStroke();

        //遍历棋盘中所有的位置
        for(int i=0;i<chessFlag.length;i++){
            for(int j=0;j<chessFlag[i].length;j++){
                //判断指定位置是否有棋子
                if(chessFlag[i][j]!=0){

                    //把棋子数组的下标换成棋子的坐标
                    int x=(j+1)*60;
                    int y=(i+1)*60;

                    //判断指定位置的棋子是否被选中
                    if(select[i][j]){
                        //设置画刷的颜色
                        g2d.setColor(new Color(0,200,0));
                        //设置画刷的大小
                        g2d.setStroke(new BasicStroke(3));
                        //画选中棋子时的棋子边框
                        g2d.drawLine(x - 25, y - 20, x - 25, y - 25);
                        g2d.drawLine(x - 25, y + 20, x - 25, y + 25);
                        g2d.drawLine(x - 20, y - 25, x - 25, y - 25);
                        g2d.drawLine(x - 20, y + 25, x - 25, y + 25);
                        g2d.drawLine(x + 25, y - 20, x + 25, y - 25);
                        g2d.drawLine(x + 25, y + 20, x + 25, y + 25);
                        g2d.drawLine(x + 25, y + 25, x + 20, y + 25);
                        g2d.drawLine(x + 25, y - 25, x + 20, y - 25);
                        //还原为默认画刷
                        g2d.setStroke(stroke);

                        //把棋子设定为没有选中的状态
                        select[i][j] = !select[i][j];

                    }

                    // 画内圆
                    g2d.setColor(new Color(219, 196, 154));
                    g2d.fillOval(x - 25, y - 25, 50, 50);

                    // 画大外圆
                    g2d.setColor(new Color(109, 98, 77));
                    g2d.drawOval(x - 25, y - 25, 50, 50);

                    // 根据棋子的所属一方，显示不同的棋子颜色
                    if (chessFlag[i][j] < 8) {
                        g2d.setColor(Color.RED);
                    } else {
                        g2d.setColor(Color.BLACK);
                    }
                    // 画小外圆
                    g2d.drawOval(x - 20, y - 20, 40, 40);

                    g2d.setFont(FontUtil.myFont2);
                    String newstring = new String(chessStr[chessFlag[i][j] - 1]);
                    g2d.drawString(newstring, x - 20, y + 10);
                }
            }
        }



    }



    public int getOldX() {
        return oldX;
    }

    public boolean isRedMove() {
        return redMove;
    }

    public void setRedMove(boolean redMove) {
        this.redMove = redMove;
    }

    public void setOldX(int oldX) {
        this.oldX = oldX;
    }

    public int getOldY() {
        return oldY;
    }

    public void setOldY(int oldY) {
        this.oldY = oldY;
    }

    public int getNewX() {
        return newX;
    }

    public void setNewX(int newX) {
        this.newX = newX;
    }

    public int getNewY() {
        return newY;
    }

    public void setNewY(int newY) {
        this.newY = newY;
    }

    // 获取棋子对应的字符串
    public String[] getChessStr() {
        return chessStr;
    }

    // 获取棋盘中所有棋子的位置
    public int[][] getChessFlag() {
        return chessFlag;
    }

    // 设置棋子对应的字符串
    public void setChessFlag(int[][] chessFlag) {
        Man.chessFlag = chessFlag;
    }

    // 设置棋子的坐标
    public void setChessFlag(int i, int j, int z) {
        chessFlag[i][j] = z;
    }

    // 获取选中状态
    public boolean[][] getSelect() {
        return select;
    }

    // 设置选中状态
    public void setSelect(int i, int j) {
        select[i][j] = !select[i][j];
    }





}
