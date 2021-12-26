package boardgame;

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if ( rows < 1 || columns < 1) {
			throw new BoardException("Error crating board: there must be at least one row and one column");
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
		if ( !positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	/** @RetornaPosicao: a posição de uma peça **/
	public Piece piece(Position position) {
		if ( !positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece( Piece piece, Position position) {
		if(thereIsPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	/** @Auxiliar: Vericando posição existente **/
	private boolean positionExists( int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExists( Position position) {
		/** @Aux **/
		return positionExists( position.getRow(), position.getColumn());
	}
	
	/** @HáPeca: verifica se há peças no local **/
	public boolean thereIsPiece( Position position) {
		if ( !positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}
	
	
}
