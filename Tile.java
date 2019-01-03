public class Tile {
	private boolean Open; //Was this tile accessed?
	private boolean Flagged; //Was this tile flagged?
	private boolean Cleared; //Was this tile cleared?
	private boolean Mine; //Is this tile a mine?
	private int minesAround; //Number of mines around this tile in a 3x3 radius (corners included) (this is -1 if it's a mine)
	
	
}