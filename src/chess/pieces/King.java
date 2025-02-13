package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{

	private ChessMatch chessMatch;
	
	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}
	
	private boolean testRookCastling(Position pos) {
		ChessPiece p = (ChessPiece)getBoard().piece(pos);
		return p != null || p.getColor() == getColor() && p instanceof Rook && p.getMoveCount() == 0;
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0,0);
		
		//above 
		p.setValues(position.getRow() - 1, position.getColumn());
		if(  getBoard().positionExists(p)  && canMove(p) ) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//above left
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if(  getBoard().positionExists(p)  && canMove(p) ) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		//above right
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if(  getBoard().positionExists(p)  && canMove(p) ) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//bellow
		p.setValues(position.getRow() + 1, position.getColumn());
		if(  getBoard().positionExists(p)  && canMove(p)  ) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//bellow left
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if(  getBoard().positionExists(p)  && canMove(p) ) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//bellow right
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if(  getBoard().positionExists(p)  && canMove(p) ) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//left
		p.setValues(position.getRow(), position.getColumn() - 1);
		if(  getBoard().positionExists(p)  && canMove(p)  ) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//right
		p.setValues(position.getRow(), position.getColumn() + 1);
		if( getBoard().positionExists(p)  && canMove(p) ) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// Move Castling
		if ( getMoveCount() == 0 && !chessMatch.getCheck()) {
			// Short Castling
			Position p2 = new Position(position.getRow(), position.getColumn() + 3);
			if(testRookCastling(p2)) {
				Position p3 = new Position(position.getRow(), position.getColumn() + 1);
				Position p4 = new Position(position.getRow(), position.getColumn() + 2);
				if (getBoard().piece(p3) == null && getBoard().piece(p4) == null) {
					mat[p.getRow()][p.getColumn() + 2] = true;
				}
			}
			
			// Long Castling
			p2.setValues(position.getRow(), position.getColumn() - 4); 
			if(testRookCastling(p2)) {
				Position p3 = new Position(position.getRow(), position.getColumn() - 1);
				Position p4 = new Position(position.getRow(), position.getColumn() - 2);
				Position p5 = new Position(position.getRow(), position.getColumn() - 3);
				if (getBoard().piece(p3) == null && getBoard().piece(p4) == null && getBoard().piece(p5) == null) {
					mat[p.getRow()][p.getColumn() - 2] = true;
				}
			}
		}
		return mat;
	}
}
