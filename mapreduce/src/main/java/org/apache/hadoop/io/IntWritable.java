package org.apache.hadoop.io;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Represents int primitive type
 * @author kovit
 *
 */
@SuppressWarnings("serial")
public class IntWritable implements Writable{

	private int value;
	
	public IntWritable(int value) {
		this.value = value;
	}
	
	public IntWritable(String value) {
		this.value =  Integer.parseInt(value);
	}
	
	public IntWritable() {
	}

	public int get() {
		return this.value;
	}

	public synchronized IntWritable increment(int i) {
		this.value += i;
		return this;
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
	
	@Override
	public void write(DataOutput out) throws IOException {
		out.writeInt(value);;
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		this.value = in.readInt();
	}

	public void set(int value) {
		this.value = value;
	}
}
