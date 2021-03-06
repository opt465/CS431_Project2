public class VPT {

	protected PageTableEntry[] pgTable = new PageTableEntry[256];

	public VPT() {

	}

	//Use the virtual page number to index the entry
	protected void addEntry(PageTableEntry entry,int vPage){
		pgTable[vPage] = entry;
	}

	protected boolean isEntry(int index){
		if(pgTable[index] == null){
			return false;
		}

		return true;
	}
	
	public PageTableEntry getEntry(String vAddr){
		return pgTable[Integer.parseInt(vAddr,16)];
	}
	
	public int getVPage(String pgFrame){
		for(int i = 0; i < pgTable.length; i++){
			if(pgTable[i] != null && pgTable[i].getPageFrameNum().equals(pgFrame)){
				return i;
			}
		}
		return 0;
	}

	public boolean inPT(String vAddr) {
		if(pgTable[Integer.parseInt(vAddr,16)] != null ) {
			return true;
		}
		
		return false;
	}

	public void printTable() {
		for (int i = 0; i < pgTable.length; i++) {
			if(pgTable[i] != null){
				System.out.print(i + " ");
				pgTable[i].print();
			}
		}
	}

}
