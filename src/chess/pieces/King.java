package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{

	public King(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
		
	}
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0,0);
		
		//above 
		p.setValues(position.getRow() - 1, position.getColunw());
		if(  getBoard().positionExists(p)  && canMove(p) ) {
			mat[p.getRow()][p.getColunw()] = true;
		}
		
		//above left
		p.setValues(position.getRow() - 1, position.getColunw() - 1);
		if(  getBoard().positionExists(p)  && canMove(p) ) {
			mat[p.getRow()][p.getColunw()] = true;
		}

		//above right
		p.setValues(position.getRow() - 1, position.getColunw() + 1);
		if(  getBoard().positionExists(p)  && canMove(p) ) {
			mat[p.getRow()][p.getColunw()] = true;
		}
		
		//bellow
		p.setValues(position.getRow() + 1, position.getColunw());
		if(  getBoard().positionExists(p)  && canMove(p)  ) {
			mat[p.getRow()][p.getColunw()] = true;
		}
		
		//bellow left
		p.setValues(position.getRow() + 1, position.getColunw() - 1);
		if(  getBoard().positionExists(p)  && canMove(p) ) {
			mat[p.getRow()][p.getColunw()] = true;
		}
		
		//bellow right
		p.setValues(position.getRow() + 1, position.getColunw() + 1);
		if(  getBoard().positionExists(p)  && canMove(p) ) {
			mat[p.getRow()][p.getColunw()] = true;
		}
		
		//left
		p.setValues(position.getRow(), position.getColunw() - 1);
		if(  getBoard().positionExists(p)  && canMove(p)  ) {
			mat[p.getRow()][p.getColunw()] = true;
		}
		
		//right
		p.setValues(position.getRow(), position.getColunw() + 1);
		if( getBoard().positionExists(p)  && canMove(p) ) {
			mat[p.getRow()][p.getColunw()] = true;
		}
		
		return mat;
	}
}
