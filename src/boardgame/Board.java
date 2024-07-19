package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if (rows<1 || columns<1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("That position: (" + row + ", " + column + ")  does not exists on the board");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("That position: (" + position + ")  does not exists on the board");
		}
		return pieces[position.getRow()][position.getColunw()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("That position: (" + position + ") already have a piece");
		}
		pieces[position.getRow()][position.getColunw()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("That position: (" + position + ")  does not exists on the board");
		}
		if (piece(position) == null) {
			return null;
		}
		Piece p = piece(position);
		p.position = null;
		pieces[position.getRow()][position.getColunw()] = null;
		return p;
	}
	
	public boolean positionExists(int row, int column) {
		return row>=0 && row<rows && column>=0 && column<columns; 
	}
			
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColunw());
	}
	
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("That position: (" + position + ")  does not exists on the board");
		}
		return piece(position) != null;
	}
	
}
