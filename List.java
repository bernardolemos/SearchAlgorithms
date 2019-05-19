
public class List extends Node{
	private Node first,last;
	private int size;
	
	List(){
		first=last=null;
		size=0;
	}
	
	List(List l){
		first=l.getFirst();
	}
/**
 * size of list
 * @return size  size of list	
 */
	public int getSize(){
		return size;
	}
	
/**
 * empty list?
 * @return boolean
 */ 	
	public boolean isEmpty(){
		if(size==0)
			return true;
		return false;
	}

/**
* fisrt node	
*@return first	  
*/
	public Node getFirst() throws Error {	
		if(!isEmpty())
			return first;
		else
			throw new Error("Empty list!");
	}

/**
 * get last node	
 *@return last	 último nó da lista 
 */
	public Node getLast() throws Error{
		if(!isEmpty())
			return last;
		else
			throw new Error("Empty list!");
	}

/**
 * get depth of element
 * @return depth	 depth 
 */
	public int getDepth(){
		return first.depth;
	}

/**
 * get path
 * @return path
 */
	public String getPath(){
		return first.path;
	}
/**
 * get state
 * @return state
 */
	public int getCost(){
		return cost;
	}
	
/**
 * add last
 * @param t		table
 * @param d		depth
 * @param s		path
 */
	public void addLast(int t[][],int d,String s){
		Node aux=new Node(t,d,s,null);
		if(isEmpty())
			first=last=aux;
		else{
			if(getSize()==1){
				last=aux;
				first.next=aux;
			}
			else
				last.next=aux;
				last=aux;
		}
		size++;
	}
/**
 * add first
 * @param t		table
 * @param d		depth
 * @param s		path
 */
	public void addFirst(int t[][],int d, String s){
		Node aux=new Node(t,d,s,null);
		if(isEmpty())
			first=last=aux;
		else{
			if(getSize()==1){
				aux.next=last;
				first=aux;
			}
			else{
				aux.next=first;
				first=aux;
			}
				
		}
		size++;
	}
	
/**
 * remove first element
 *@return  	 
 */
	public int[][] remove() throws Error{
		if(!isEmpty()){
			Node aux=getFirst();
			first=first.next;
			size--;
			return aux.table;
		}
		else
			throw new Error("Empty list!");
	}

/**
 * verifica a exestência de um elemento(a[][])
 * @param t	 table
 * @return boolean
 */
	public boolean contains(int t[][]){
		Node pointer=this.first;
		while(pointer!=null){
			int dirty=0;
			for(int i=0;i<3;i++)
				for(int j=0;j<3;j++)
					if(t[i][j]!=pointer.table[i][j]){
						dirty=1;
						break;
					}
			if(dirty==0)
				return true;
			pointer=pointer.next;
		}
	return false;
	}
	
	/**
	 * print list
	 */
	public void printList(){
		Node pointer=first;
		while(pointer!=null){
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++)
					System.out.print(pointer.table[i][j]+" ");
				System.out.println();
			}
			System.out.println();
			pointer=pointer.next;
		}
	}
	
	/**
	 * add node first pos.
	 * @param t 	table
	 * @param d		depth
	 * @param s		path
	 * @param c		cost
	 */
	public void addFirst(int t[][],int d, String s,int c){
		Node aux=new Node(t,d,s,c,null);
		if(isEmpty())
			first=last=aux;
		else{
			if(getSize()==1){
				aux.next=last;
				first=aux;
			}
			else{
				aux.next=first;
				first=aux;
			}
				
		}
		size++;
	}
	
/**
 * 	adds node to end of list
 * @param t		table
 * @param d		depth
 * @param s		path
 * @param c		cost
 */
	public void addLast(int t[][],int d,String s,int c){
		Node aux=new Node(t,d,s,c,null);
		if(isEmpty())
			first=last=aux;
		else{
			if(getSize()==1){
				last=aux;
				first.next=aux;
			}
			else
				last.next=aux;
				last=aux;
		}
		size++;
	}
}
