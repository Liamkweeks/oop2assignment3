package sait.sll.utility;

import java.io.Serializable;

public class SLL implements LinkedListADT, Serializable
{
	//Constructor, should implement node and link(?) 
	public SLL()
	{
		
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 4207147896437339801L;
	@Override
	public boolean isEmpty() {
		if(size() != 0)
			return false;
		else
			return true;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void append(Object data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void prepend(Object data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Object data, int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void replace(Object data, int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object retrieve(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(Object data) {
		// TODO Auto-generated method stub
		return false;
	}

}
