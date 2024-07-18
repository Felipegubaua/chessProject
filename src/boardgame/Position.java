package boardgame;

public class Position {

	private int row;
	private int colunw;
	
	
	public Position(int row, int colunw) {
		this.row = row;
		this.colunw = colunw;
	}
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColunw() {
		return colunw;
	}
	public void setColunw(int colunw) {
		this.colunw = colunw;
	}

	@Override
	public String toString() {
		return row + ", " + colunw;
	}
}
