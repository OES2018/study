package com.zjw.chineseChess;
/**
 * 棋子点坐标类
 * @author jiawei
 *
 */
public class ChessPoint {
	int x,y;//棋子坐标；
	boolean hasChess;//该坐标是否有棋子；
	ChessPiece piece = null;
	ChessBoard board = null;
	public ChessPoint(int x, int y, boolean hasChess) {
		super();
		this.x = x;
		this.y = y;
		this.hasChess = hasChess;
	}
	public void setPiece(ChessPiece piece,ChessBoard board){
		this.board = board;
		this.piece = piece;
		//board.add();
		int w = board.unitWidth;
		int h = board.unitHeight;
		//piece.
		//board.
	}
	
}
