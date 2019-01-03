public class Tile {
	private boolean Open; //Was this tile accessed?
	private boolean Flagged; //Was this tile flagged?
	private boolean Cleared; //Was this tile cleared?
	private boolean Mine; //Is this tile a mine?
	private int RowPos; //Row this tile is in
	private int ColPos; //Column this tile this in
	
	public Tile(boolean m, int rp, int cp) {
		Mine = m;
		RowPos = rp;
		ColPos = cp;
		Open = false;
		Cleared = false;
		Flagged = false;
	}
	public boolean isMine() {
		return m;
	}
	public void clear() {
		Open = true;
		Cleared = true;
		//not finished
	}
}