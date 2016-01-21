package abd;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import abd.tp1.FileTable;
import abd.tp1.TuplesIterator;

public class FileTableImpl implements FileTable {

	private Path path;
	private int artity;
	
	public FileTableImpl(Path p,int a) {
		this.artity=a;
		this.path=p;
	}
	
	@Override
	public int getArity() {
		return this.artity;
	}

	@Override
	public Path getPath() {
		return this.path;
	}

	@Override
	public void addTuple(String... tuple) throws IllegalArgumentException,
			IOException {
		if(tuple.length!=this.artity)
			throw new IllegalArgumentException();
		
		int i=0;
		String rslt="";
		
		for(String s : tuple){
			rslt +=s;
			i++;
			if(i!=this.artity)
				rslt+=";";
		}
		rslt+="\n";
		FileWriter f = new FileWriter(this.path.toString());
		f.write(rslt);
		f.close();
	}

	@Override
	public TuplesIterator tuplesIterator() throws IOException {
		FileReader f = new FileReader(this.path.toString());
		return new TuplesIteratorImpl(f);
	}

	@Override
	public FileTable select(Path resultPath, String contained, int columnRank)
			throws IllegalArgumentException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileTable project(Path resultPath, int... columnRanks)
			throws IllegalArgumentException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() throws IOException {
	}

}
