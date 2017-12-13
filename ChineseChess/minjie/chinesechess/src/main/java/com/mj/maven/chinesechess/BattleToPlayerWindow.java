package com.mj.maven.chinesechess;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

/**
*@auther minjie 
*@E-mail jie_min_jimmy@163.com
*@version 创建时间：2017年12月10日
**/

public class BattleToPlayerWindow {

	private JFrame battleToPlayerFrame;

	private JPanel playerInfoPanel;
	private ChessBoard chessBoard;
	private JPanel undoAndOptionsFatherPanel;
	private JPanel undoAndOptionsChildPanel;
	
	private int CHESS_BOARD_WEDTH=558;
	private int CHESS_BOARD_HEIGHT=620;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BattleToPlayerWindow battleToPlayerWindow = new BattleToPlayerWindow();
					battleToPlayerWindow.battleToPlayerFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public BattleToPlayerWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBattleToPlayerFrame();
		
		addPlayerInfoPanel();
		addPlayerOneInfoPanel();
		addPlayerTwoInfoPanel();
		
		
		addChessBoard();

		
		addUndoAndOptionsFatherPanel();
		addUndoAndOptionsChildPanel();
		addUndoButton();
		addOptionsButton();
	}
	
	public JFrame getBattleToPlayerFrame() {
		return battleToPlayerFrame;
	}
	
	private void setBattleToPlayerFrame() {
		battleToPlayerFrame = new JFrame();
		battleToPlayerFrame.setTitle("双人对战");
		battleToPlayerFrame.setBounds(400, 100, 699, 648);
		battleToPlayerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		battleToPlayerFrame.getContentPane().setLayout(new BorderLayout(0, 0));	
		battleToPlayerFrame.setResizable(false);
	}
	
	private void addPlayerInfoPanel() {
		playerInfoPanel = new JPanel();
		battleToPlayerFrame.getContentPane().add(playerInfoPanel, BorderLayout.WEST);
		playerInfoPanel.setLayout(new GridLayout(0, 1, 0, 0));
	}
	
	private void addPlayerOneInfoPanel() {
		JPanel playerOneInfoPanel = new JPanel();
		playerOneInfoPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Player 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		playerInfoPanel.add(playerOneInfoPanel);
		playerOneInfoPanel.setLayout(new BorderLayout(0, 0));
	}
	
	private void addPlayerTwoInfoPanel() {
		JPanel playerTwoInfoPanel = new JPanel();
		playerTwoInfoPanel.setBorder(new TitledBorder(null, "Player 2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		playerInfoPanel.add(playerTwoInfoPanel);
		playerTwoInfoPanel.setLayout(new BorderLayout(0, 0));		
	}
	
	private void addChessBoard() {
		chessBoard = new ChessBoard();
		chessBoard.setPreferredSize(new Dimension(CHESS_BOARD_WEDTH,CHESS_BOARD_HEIGHT));
		chessBoard.setLayout(null);
		battleToPlayerFrame.getContentPane().add(chessBoard, BorderLayout.CENTER);
	}
	

	
	private void addUndoAndOptionsFatherPanel() {
		undoAndOptionsFatherPanel = new JPanel();
		playerInfoPanel.add(undoAndOptionsFatherPanel);
		undoAndOptionsFatherPanel.setLayout(new BorderLayout(0, 0));
	}
	
	private void addUndoAndOptionsChildPanel() {
		undoAndOptionsChildPanel = new JPanel();
		undoAndOptionsFatherPanel.add(undoAndOptionsChildPanel, BorderLayout.SOUTH);
		undoAndOptionsChildPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));		
	}

	private void addUndoButton() {
		JButton undoButton = new JButton("悔棋");
		undoAndOptionsChildPanel.add(undoButton);		
	}

	private void addOptionsButton() {
		JButton optionsButton = new JButton("选项");
		undoAndOptionsChildPanel.add(optionsButton);		
	}

}
