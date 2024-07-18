package boardgame;

public class Board {

	private int rows;
	private int coluns;
	private Piece[][] pieces;
	
	public Board(int rows, int coluns) {
		this.rows = rows;
		this.coluns = coluns;
		pieces = new Piece[rows][coluns];
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColuns() {
		return coluns;
	}

	public void setColuns(int coluns) {
		this.coluns = coluns;
	}
	
	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColunw()];
	}
	
}
