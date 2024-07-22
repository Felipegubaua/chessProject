package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece{

	public Bishop(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "B";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0,0);
		
		//nw
		p.setValues(position.getRow() - 1, position.getColunw() - 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColunw()] = true;
			p.setValues(p.getRow() - 1, p.getColunw() - 1); 
		}
		if( getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColunw()] = true;
		}
		
		//ne
		p.setValues(position.getRow() - 1, position.getColunw() + 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColunw()] = true;
			p.setValues(p.getRow() - 1, p.getColunw() + 1); 
		}
		if( getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColunw()] = true;
		}
		
		//se
		p.setValues(position.getRow() + 1, position.getColunw() + 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColunw()] = true;
			p.setValues(p.getRow() + 1, p.getColunw() + 1); 
		}
		if( getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColunw()] = true;
		}
		
		//sw
		p.setValues(position.getRow() + 1, position.getColunw() - 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColunw()] = true;
			p.setValues(p.getRow() + 1, p.getColunw() - 1); 
		}
		if( getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColunw()] = true;
		}
		
		return mat;
	}
	
}
