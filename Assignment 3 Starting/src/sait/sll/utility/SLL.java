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
		
		
		if(index < 0 || index > size)
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
			currentNode.setData(data);

	}

	@Override
	public int size() 
	{
		return size;
	}

	@Override
	public void delete(int index)
	{
		if(index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			if(size == 1)
			{
				tail = head = null;
			}
			else if(index == 0)
			{
				head = head.getNext();
			}
			else if(index == size-1)
			{
				Node prevNode = head;
				int prevIndex = 0;
				while(prevIndex < index-1)
				{
					prevNode = prevNode.getNext();
					prevIndex++;
				}
				prevNode.setNext(null);
				tail = prevNode;
				
			}
			else
				{
					Node prevNode = head;
					int prevIndex = 0;
					while(prevIndex < index - 1)
					{
						prevNode = prevNode.getNext();
						prevIndex++;
					}
					prevNode.setNext(prevNode.getNext().getNext());
				}
			size--;
			
		}
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
		int currentIndex = 0;
		Node currentNode = head;
		while(currentNode.getData() != data)
		{
			currentNode = currentNode.getNext();
			currentIndex++;
		}
		return currentIndex;
	}

	@Override
	public boolean contains(Object data) 
	{
		
		Node currentNode = head;
		while(currentNode != data)
		{
			System.out.println(currentNode.getData());
			if(currentNode.getData().equals(data))
			{
				return true;
			}
			currentNode = currentNode.getNext();
		}
		return false;
	}
	@Override
	 public void display() {
	        if(size == 0) {
	            System.out.println("List is empty");
	            return;
	        }
	        
	        Node current = head;
	        System.out.println("List: ");
	        while(current != null) {
	            System.out.println(current.getData());
	            current = current.getNext();
	        }
	    }
	@Override
	public Node getHead()
	{
		return head;	
	}
}
