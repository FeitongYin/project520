package upenn.cis550.groupf.shared;

import java.io.Serializable;

public class Board implements Serializable {
	
	int boardID;
	int userID;
	String boardName;
	
	public Board() {
		super();
		userID = 0;
		boardID = 0;
		boardName = "";
		
	}
	
	public Board(int userID, int boardID, String boardName) {
		super();
		this.userID = userID;
		this.boardID = boardID;
		this.boardName = boardName;
	}
	
	public int getUserID() {
		return this.userID;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public int getBoardID() {
		return this.userID;
	}
	
	public void setBoardID(int boardID) {
		this.boardID = boardID;
	}
	
	public String getName() {
		return boardName;
	}
	
	public void setName(String boardName) {
		this.boardName = boardName;
	}
	
	
}
