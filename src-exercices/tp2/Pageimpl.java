package tp2;

import java.nio.ByteBuffer;

public class Pageimpl implements Page {

	private ByteBuffer buffer;
	private int entrysize;
	private int nbRecord;
	
	public Pageimpl(ByteBuffer b,int e) {
		this.buffer = b;
		this.entrysize = e;
		this.nbRecord=0;
	}
	
	@Override
	public long getNbRecords() {
		return nbRecord;
	}

	@Override
	public byte[] getNextRecord() {
		String rslt="";
		int idx=0;
	    while (idx<0) {
	    	rslt += (char) buffer.get();
	    	idx++;
	    }
	    return rslt.getBytes();
	}

	@Override
	public void remove() {
		int idx=0;
	    while (idx<this.entrysize) {
	    	buffer.put((byte)0);
	    	idx++;
	    }
	    nbRecord--;
	}

	@Override
	public void resetPosition() {
		this.buffer.clear();
		this.buffer.rewind();
		this.buffer.reset();
	}

	@Override
	public void setRecord(byte[] newRecord) {
		int idx=0;
	    for(Byte b : newRecord){
	    	buffer.put(b);
	    	idx++;
	    	if(idx==entrysize)
	    		return;
	    }
	}

	@Override
	public boolean addRecord(byte[] newRecord) {
		if(getNextRecord().length==0){
			setRecord(newRecord);
			nbRecord++;
			return true;
		}
		return false;
	}

}
