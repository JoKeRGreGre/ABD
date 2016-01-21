package tp2;

import java.nio.ByteBuffer;

public class PageRandomAccessimpl extends Pageimpl implements PageRandomAccess {
	
	public PageRandomAccessimpl(ByteBuffer b, int e) {
		super(b, e);
	}

	@Override
	public byte[] getRecord(Comparable key) {
		byte[] rslt;
		do{
			rslt= getNextRecord();
		}while(!getKey(rslt).equals(key));
			return rslt;

	}

	@Override
	public boolean removeRecord(Comparable key) {
		byte[] rslt;
		do{
			rslt= getNextRecord();
		}while(getKey(rslt).equals(key));
		if(rslt.length!=0){
			remove();
			return true;
		}
		else
			return false;
	}

	@Override
	public Comparable getKey(byte[] record) {
		// TODO Auto-generated method stub
		return null;
	}


}
