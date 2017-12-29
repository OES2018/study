package com.zhouziyin.ChineseChess.controller;

import com.zhouziyin.ChineseChess.entity.Board;
import com.zhouziyin.ChineseChess.entity.Man;
import com.zhouziyin.ChineseChess.panel.GamePanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by zhouziyin on 2017/12/8.
 */
public class Controller extends MouseAdapter {

    private static Board chessBoard;
    private static Man chessMan;
    private static GamePanel gamePanel;
    private static boolean gameover = false;

    /*
     *重新显示游戏界面
     */
    public Controller(GamePanel gamePanel, Board chessBoard, Man chessMan) {
        Controller.chessBoard = chessBoard;
        Controller.chessMan = chessMan;
        Controller.gamePanel = gamePanel;

    }

    /*
       *功能：响应鼠标点击事件
     */
    public void mouseClicled(MouseEvent e) {
        //获取鼠标的位置，20代表的是菜单栏的高度
        int x = e.getX();
        int y = e.getY() - 20;

        //如果鼠标点击的坐标有效
        if ((x >= 40 && x <= 570) && (y >= 40 && y <= 630) && !gameover) {

            //把鼠标的坐标转换成棋子数组的下标，25代表棋子的半径
            int newi = (y + 25) / 60 - 1;
            int newj = (x + 25) / 60 - 1;

            //获取鼠标上一步点击位置数组的下标
            int oldi = chessMan.getOldX();
            int oldj = chessMan.getOldY();

            //获取保存棋子位置的数组
            int[][] chessFlag = chessMan.getChessFlag();

            //判断选中的地方是否有棋子
            if (chessFlag[newi][newj] == 0) {
                //判断上一步是否有选中棋子
                if (oldi != -1 && oldj != -1) {
                    //判断棋子能否移动
                    if (isChessManMove(chessFlag, newi, newj)) {
                        //移动棋子
                        chessMan.setChessFlag(newi, newj, chessFlag[oldi][oldj]);
                        chessMan.setChessFlag(oldi, oldj, 0);

                        //移动成功后，清除上一步选中的棋子
                        chessMan.setOldX(-1);
                        chessMan.setOldY(-1);
                        gamePanel.dispaly(chessBoard, chessMan);
                        //轮到对方下棋
                        chessMan.setRedMove(!chessMan.isRedMove());
                    }
                }
            } else {
                //判断上一步是否有棋子
                if (oldi == -1 && oldj == -1) { //上一步没有棋子
                    //如果有棋子，并且是自己
                    if (oldi == newi && oldj == newj) {
                    } else {
                        //把选中的棋子设为选中状态
                        chessMan.setSelect(newi, newj);

                        //并把其保存为上一颗棋子
                        chessMan.setOldX(newi);
                        chessMan.setOldY(newj);
                        showGame();

                    }

                } else {  //如果上一步有棋子

                    //判断是否吃得到下一步的棋子
                    if (isChessManMove(chessFlag, newi, newj)) {
                        //判断是否是自己一方的棋子
                        if ((chessFlag[oldi][oldj] >= 8 && chessFlag[newi][newj] < 8) || (chessFlag[oldi][oldj] < 8 && chessFlag[newi][newj] >= 8)) {
                            if (chessFlag[newi][newj] == 5) {
                                gamePanel.setMessage(1);
                                gameover = true;
                            }
                            //吃棋子
                            chessMan.setChessFlag(newi, newj, chessFlag[oldi][oldj]);
                            chessMan.setChessFlag(oldi, oldj, 0);
                            //轮到对方下棋
                            chessMan.setRedMove(!chessMan.isRedMove());
                        }
                    }

                    //并清除上一步棋子
                    chessMan.setOldY(-1);
                    chessMan.setOldY(-1);
                    //重新显示界面
                    showGame();

                }
            }

        }

    }


    /*
     *功能：重新显示界面
     */
    public static void showGame() {
        gamePanel.dispaly(chessBoard, chessMan);
    }


    /*
     *判断棋子是否能移动
     * chessFlag：棋盘棋子坐标
     * newi,newj：棋子下一步的坐标
     */
    public boolean isChessManMove(int[][] chessFlag, int newi, int newj) {

        //默认棋子不能移动
        boolean b = false;

        //获取上一步选中的棋子坐标
        int oldi = chessMan.getOldX();
        int oldj = chessMan.getOldY();

        //默认该棋子时红方的
        boolean redFlag = true;

        //棋子不是红方的
        if (chessFlag[oldi][oldj] >= 8) {
            redFlag = false;
        }

        //如果棋子时红方的且不是红方下棋，则返回
        if (redFlag != chessMan.isRedMove()) {
            System.out.println("还没轮到你下呢！");
            return false;
        }

        //获取棋盘中所有的棋子
        String[] chessStr = chessMan.getChessStr();

        //获取上一步选中的棋子
        String name = chessStr[chessFlag[oldi][oldj] - 1];

        //根据棋子名称选择棋子的走法
        if (name.equals("兵")) {
            if (oldi >= 5) {//没有过河
                if ((oldi - newi == 1) && (newj == oldj)) {
                    b = true;
                }
            } else {  //已过河
                if ((oldi - newi == 1) && (newj == oldj)) {
                    b = true;
                } else if ((Math.abs(newj - oldj) == 1) && (newi == oldi)) {
                    b = true;
                } else {
                    return false;
                }
            }
        }else if (name.equals("卒")) {
            if (oldi < 5) { //没有过河
                if ((newi - oldi == 1) && (newj == oldj)) {
                    b = true;
                }
            }else { //已过河
                if ((newi - oldi == 1) && (newj == oldj)) {
                    b = true;
                }else if ((Math.abs(newj - oldj) == 1) && (newi == oldi)){
                    b = true;
                }else {
                    return false;
                }
        }
    }
    else if (name.equals("车")) {
            if (newi == oldi) {
                int k = 0;
                if (newj > oldj) {  //红车水平向右移动
                    for (int i = oldj; i <= newj; i++) {
                        if (chessFlag[oldi][i] > 0) {
                            k++;
                        }
                    }

                } else {
                    for (int i = oldj; i >= newj; i--) {//红车水平向左方向移动
                        if (chessFlag[oldi][i] > 0) {
                            k++;
                        }
                    }
                }
                if (k <= 2) {
                    b = true;
                }
            } else if (newj == oldj) { //红车垂直下方向移动
                int k = 0;
                if (newi > oldi) {
                    for (int i = oldi; i <= newi; i++) {
                        if (chessFlag[i][oldj] > 0) {
                            k++;
                        }
                    }
                } else {
                    for (int i = oldi; i >= newi; i--) { // 红车垂直上方向移动
                        if (chessFlag[i][oldj] > 0) {
                            k++;
                        }
                    }
                }
                if (k <= 2) {
                    b = true;
                }
            }
        }
        else if (name.equals("炮")){
        int s =0;
        if (newi == oldi){
            if (newj > oldj) {
                for (int i = oldj; i <= newj; i++) {
                    if (chessFlag[oldi][i] > 0) {
                        s++;
                    }
                }
            } else {
                for (int i = oldj; i >= newj; i--) {
                    if (chessFlag[oldi][i] > 0) {
                        s++;
                    }
                }
            }
        } else if (newj == oldj) {
            if (newi > oldi) {
                for (int i = oldi; i <= newi; i++) {
                    if (chessFlag[i][oldj] > 0) {
                        s++;
                    }
                }
            } else {
                for (int i = oldi; i >= newi; i--) {
                    if (chessFlag[i][oldj] > 0) {
                        s++;
                    }
                }
            }
        }
            if (s == 1 || (s == 3 && chessFlag[newi][newj] > 0)) {
                b = true;
            }
        }
        else if(name.equals("帅")||name.equals("将")) {
            if (newj == oldj && (Math.abs(newi - oldi) >= 5)) {
                int flag = 0;
                if (newi > oldi) { // 将吃帅
                    for (int i = oldi; i <= newi; i++) {
                        if ((chessFlag[oldi][oldj] == 5)
                                && (chessFlag[newi][newj] == 14)) {
                            if (chessFlag[i][oldj] > 0) {
                                flag++;
                            }
                        }
                    }
                } else { // 帅吃将
                    for (int i = newi; i <= oldi; i++) {
                        if ((chessFlag[oldi][oldj] == 14)
                                && (chessFlag[newi][newj] == 5)) {
                            if (chessFlag[i][oldj] > 0) {
                                flag++;
                            }
                        }
                    }
                }
                if (flag == 2) {
                    b = true;
                }
            } else if (((newi <= 2 && redFlag == true) || (newi >= 7 && redFlag == false))
                    && (newj <= 5 && newj >= 3)) {
                if (Math.abs(newi - oldi) == 1 && newj == oldj) {
                    b = true;
                } else if (Math.abs(newj - oldj) == 1 && newi == oldi) {
                    b = true;
                }
            }
        }
        else if(name.equals("士")) {
            if (redFlag) { // 红方棋子
                if (newi <= 2 && newj <= 5 && newj >= 3) {
                    if (Math.abs(newi - oldi) == 1
                            && Math.abs(newj - oldj) == 1) {
                        b = true;
                    }
                }
            } else { // 黑方棋子
                if (newi >= 7 && newj <= 5 && newj >= 3) {
                    if (Math.abs(newi - oldi) == 1
                            && Math.abs(newj - oldj) == 1) {
                        b = true;
                    }
                }
            }
        }
        else if(name.equals("象")||name.equals("相")) {
            if ((newi >= 5 && redFlag == false)
                    || (newi < 5 && redFlag == true)) {
                if ((newi - oldi) == 2 && (newj - oldj) == 2) { // 移到右下方
                    if (chessFlag[oldi + 1][oldj + 1] == 0) {
                        b = true;
                    }
                } else if ((newi - oldi) == -2 && (newj - oldj) == 2) { // 移到右上方
                    if (chessFlag[oldi - 1][oldj + 1] == 0) {
                        b = true;
                    }
                } else if ((newi - oldi) == 2 && (newj - oldj) == -2) { // 移到左下方
                    if (chessFlag[oldi + 1][oldj - 1] == 0) {
                        b = true;
                    }
                } else if ((newi - oldi) == -2 && (newj - oldj) == -2) { // 移到左上方
                    if (chessFlag[oldi - 1][oldj - 1] == 0) {
                        b = true;
                    }
                }
            }
        }
        else if(name.equals("马")) {
            if ((newi - oldi) == -2 && (newj - oldj) == 1) { // 移到NE方
                if (chessFlag[oldi - 1][oldj] == 0) {
                    b = true;
                }
            } else if ((newi - oldi) == -2 && (newj - oldj) == -1) { // 移到NW方
                if (chessFlag[oldi - 1][oldj] == 0) {
                    b = true;
                }
            } else if ((newi - oldi) == 2 && (newj - oldj) == 1) { // 移到SE方
                if (chessFlag[oldi + 1][oldj] == 0) {
                    b = true;
                }
            } else if ((newi - oldi) == 2 && (newj - oldj) == -1) { // 移到SW方
                if (chessFlag[oldi + 1][oldj] == 0) {
                    b = true;
                }
            } else if ((newi - oldi) == -1 && (newj - oldj) == 2) { // 移到EN方
                if (chessFlag[oldi][oldj + 1] == 0) {
                    b = true;
                }
            } else if ((newi - oldi) == 1 && (newj - oldj) == 2) { // 移到ES方
                if (chessFlag[oldi][oldj + 1] == 0) {
                    b = true;
                }
            } else if ((newi - oldi) == -1 && (newj - oldj) == -2) { // 移到WN方
                if (chessFlag[oldi][oldj - 1] == 0) {
                    b = true;
                }
            } else if ((newi - oldi) == 1 && (newj - oldj) == -2) { // 移到WS方
                if (chessFlag[oldi][oldj - 1] == 0) {
                    b = true;
                }
            }
        }
        return b;
    }

    /*
     *功能：设置游戏状态
     */
    public  static void setGameover(boolean gameover){
        Controller.gameover = gameover;
        }
    }