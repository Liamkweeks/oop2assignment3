package sait.sll.utility;

import java.io.Serializable;

public class SLL implements LinkedListADT, Serializable
{
	private Node head, tail;
	private int size;
	/**
	 * 
	 */
	private static final long serialVersionUID = 4207147896437339801L;
	@Override
	public boolean isEmpty()
	{
		boolean isEmpty = false;
		if(size == 0)
		{
			isEmpty = true;
		}
		else if(size != 0)
		{
			isEmpty = false;
		}
		return isEmpty;
	}

	@Override
	public void clear() 
	{
		tail = head = null;
		size = 0;
	}

	@Override
	public void append(Object data) 
	{
		Node newNode = new Node(data);
		if (size == 0)
		{
			tail = head = newNode;
		}
		else
		{
			tail.setNext(newNode);
			tail = newNode;
		}
		size++;
	}

	@Override
	public void prepend(Object data) 
	{
		Node newNode = new Node(data);
		if (size == 0)
		{
			tail = head = newNode;
		}
		else
		{
			newNode.setNext(head);
			head = newNode;
		}
		size++;
	}

	@Override
	public void insert(Object data, int index) throws IndexOutOfBoundsException 
	{
		if(index < 0 || index > size)
		{
			throw new IndexOutOfBoundsException();
		}
		Node insertNode = new Node(data);
		if (size == 0)
		{
			tail = head = insertNode;
		}
		else if(index == 0)
		{
			insertNode.setNext(head);
			head = insertNode;
		}
		else if(index == size)
		{
			tail.setNext(insertNode);
			tail = insertNode;
		}
		else
		{
			Node prevNode = head;
			int currentIndex = 0;
			while(currentIndex < index-1)
			{
				prevNode = prevNode.getNext();
				currentIndex++;
			}
			insertNode.setNext(prevNode.getNext());
			prevNode.setNext(insertNode);
		}
		size++;
	}

	@Override
	public void replace(Object data, int index) throws IndexOutOfBoundsException 
	{
	
	}

	@Override
	public int size() 
	{
		return size;
	}

	@Override
	public void delete(int index) throws IndexOutOfBoundsException 
	{
	
	}

	@Override
	public Object retrieve(int index) throws IndexOutOfBoundsException 
	{
		if(index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException(); 
		}
		Node currentNode = head;
		int currentIndex = 0;
		while(currentIndex < index)
		{
			currentNode = currentNode.getNext();
			currentIndex++;
		}
		return currentNode.getData();
	}

	@Override
	public int indexOf(Object data) 
	{
		return 0;
	}

	@Override
	public boolean contains(Object data) 
	{
		return false;
	}

}
