package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece{

	public Queen(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "Q";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0,0);
		
		//above 
		p.setValues(position.getRow() - 1, position.getColunw());
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColunw()] = true;
			p.setRow(p.getRow() - 1);
		}
		if( getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColunw()] = true;
		}
		
		//bellow
		p.setValues(position.getRow() + 1, position.getColunw());
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColunw()] = true;
			p.setRow(p.getRow() + 1);
		}
		if( getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColunw()] = true;
		}
		
		//left
		p.setValues(position.getRow(), position.getColunw() - 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColunw()] = true;
			p.setColunw(p.getColunw() - 1);
		}
		if( getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColunw()] = true;
		}
		
		//right
		p.setValues(position.getRow(), position.getColunw() + 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColunw()] = true;
			p.setColunw(p.getColunw() + 1);
		}
		if( getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColunw()] = true;
		}
		
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
