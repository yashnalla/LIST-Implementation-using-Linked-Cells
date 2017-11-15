/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
*/
package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
  Node sentinel; //this will be the entry point to your linked list (the head)
  int numElts;
  
  public LinkedListImpl(){//this constructor is needed for testing purposes. Please don't modify!
    sentinel=new Node(0); //Note that the root's data is not a true part of your data set!
  }
  
  //implement all methods in interface, and include the getRoot method we made for testing purposes. Feel free to implement private helper methods!
  
  public Node getRoot(){ //leave this method as is, used by the grader to grab your linkedList easily.
    return sentinel;
  }

@Override
public boolean insert(double elt, int index) {
	// TODO Auto-generated method stub
	int size = this.size();
	Node node1 = new Node(elt);
	
	if(index > size || index< 0){
		
		return false;
	}
	if(size ==  0){
		
		sentinel.next = node1;
		node1.next = sentinel;
		sentinel.prev = node1;
		node1.prev = sentinel;
		numElts ++;
		
		return true;
	}else{
		Node temp = sentinel;
		int count = 0;
		while(count < index){
			temp = temp.next;
			count++;
		}
		Node tempnext = temp.next;
		temp.next = node1;
		node1.prev = temp;
		node1.next = tempnext;
		tempnext.prev = node1;
		numElts ++;
		return true;
	}
	
}

@Override
public boolean remove(int index) {
	// TODO Auto-generated method stub
	int size = this.size();
	if(index > size || index< 0){
		return false;
	}
	if(size== 0){
		return false;
	}else{
		Node temp = sentinel;
		int count = 0;
		while(count<index){
			temp = temp.next;
			count++;
		}
		Node rem = temp.next;
		Node remprev = rem.prev;
		Node remnext = rem.next;
		rem.next = null;
		rem.prev = null;
		remprev.next = remnext;
		remnext.prev = remprev;
		numElts--;
		return true;
		
			
	}
	
}

@Override
public double get(int index) {
	int size = this.size();
	if(index> size || index < 0){
		return Double.NaN;
	}
	if(size == 0){
		return Double.NaN;
	}else{
		Node temp = sentinel;
		int count =0;
		while(count < index){
			temp = temp.next;
			count++;
		}
		Node data = temp.next;
		return data.data;
	}
	
	
	// TODO Auto-generated method stub
	
}

@Override
public int size() {
	// TODO Auto-generated method stub
	if(sentinel.getNext() == null && sentinel.getPrev()== null){
		return 0;
	}
	return numElts;
}

@Override
public boolean isEmpty() {
	// TODO Auto-generated method stub
	if(sentinel.getNext() == null && sentinel.getPrev()== null){
		return true;
	}
	if(numElts == 0){
		return true;
	}
	return false;
}

@Override
public void clear() {
	// TODO Auto-generated method stub
	int size = this.size();
	for(int i =0; i<size; i++){
		remove(i);
		
	}
	sentinel.next = null;
	sentinel.prev = null;
	numElts = 0;
}
}
