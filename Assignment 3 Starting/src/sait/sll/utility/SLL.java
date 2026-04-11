package sait.sll.utility;

import java.io.Serializable;

public class SLL implements LinkedListADT, Serializable
{
	private Node head, tail;
	private int size;
	/**
	 * Serialization ID for saving/loading list objects.
	 */
	private static final long serialVersionUID = 4207147896437339801L;

	/**
	 * Checks whether the list currently has zero elements.
	 */
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

	/**
	 * Removes all nodes from the list and resets size to 0.
	 */
	@Override
	public void clear() 
	{
		tail = head = null;
		size = 0;
	}

	/**
	 * Adds a new node containing data to the end (tail) of the list.
	 */
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

	/**
	 * Adds a new node containing data to the front (head) of the list.
	 */
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

	/**
	 * Inserts a new node at the given index and shifts later elements right.
	 * If index is out of bounds, throws IndexOutOfBoundsException.
	 */
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

	/**
	 * Replaces the data at the given index with the provided value.
	 * If index is out of bounds, throws IndexOutOfBoundsException.
	 */
	@Override
	public void replace(Object data, int index) throws IndexOutOfBoundsException 
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
			currentNode.setData(data);

	}

	/**
	 * Returns the number of elements currently in the list.
	 */
	@Override
	public int size() 
	{
		return size;
	}

	/**
	 * Deletes the node at the given index and reconnects list links.
	 * If index is out of bounds, throws IndexOutOfBoundsException.
	 */
	@Override
	public void delete(int index) throws IndexOutOfBoundsException
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

	/**
	 * Retrieves and returns the data stored at the given index.
	 * If index is out of bounds, throws IndexOutOfBoundsException.
	 * Note: this method does not remove the node from the list.
	 */
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

	/**
	 * Finds the first index containing data, or returns -1 if not found.
	 * If data is null, throws IllegalArgumentException.
	 */
	@Override
	public int indexOf(Object data)
	{
		int currentIndex = 0;
		Node currentNode = head;
		while(currentNode != null && currentNode.getData() != data)
		{
			currentNode = currentNode.getNext();
			currentIndex++;
		}
		if (currentNode == null) {
			currentIndex = -1;
		}
		return currentIndex;
	}

	/**
	 * Returns true if any node in the list contains matching data.
	 */
	@Override
	public boolean contains(Object data) 
	{
		
		Node currentNode = head;
		while(currentNode != null)
		{
			if(currentNode.getData().equals(data))
			{
				return true;
			}
			currentNode = currentNode.getNext();
			
		}
		return false;
	}
	
	/**
	 * Prints all list elements from head to tail to the console.
	 */
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
	
	/**
	 * Returns the head node reference of the list.
	 */
	@Override
	public Node getHead()
	{
		return head;	
	}
}
