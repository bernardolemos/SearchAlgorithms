import java.util.*;
//import java.util.PriorityQueue;
//import java.util.Date;

public class AppliedSearch extends Search{

	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int final_table[][]=new int[3][3];
		System.out.println("JOGO DOS 8");
		System.out.println();
		System.out.println("Table configuration is a flatten 3x3 matrix, where '0' is the empty cell. Integers from 0 to 8.");
		System.out.println("Example: 1 2 3 8 0 4 7 6 5 is\n1 2 3\n8 0 4\n7 6 5");
		System.out.println("Please enter a initial configuration");
		System.out.println("-----------------------------------");
		System.out.println("Initial table (3x3):");
		int initial_table[][]=new int[3][3];
		//read initial table
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				initial_table[i][j]=in.nextInt();
		System.out.println("\n-----------------------------------");
		//read final table
		System.out.println("Target table (3x3):");
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				final_table[i][j]=in.nextInt();
		System.out.println("\n-----------------------------------");
		if(hasSolution(initial_table, final_table)){
			//list of visited tables
			List visited_tables=new List();
			System.out.println("Select a search algorithm");
			System.out.println();
			System.out.println("-DFS: 1\n-BFS: 2\n-Iterative DFS: 3\n-Greedy: 4\n-A*: 5");
			System.out.println("\n-----------------------------------");
			System.out.print("Search: ");
			int search=in.nextInt();
			Node n=new Node();
			double start=new Date().getTime();
			if(search==1){
				List table_list=new List();
				//adds table to list
				table_list.addFirst(initial_table,0,"");
				System.out.println("You've selected: DFS");
				n=depthFirstSearch(table_list, visited_tables, final_table);
			}
			else if(search==2){
				List table_list=new List();
				//adds table to list
				table_list.addFirst(initial_table,0,"");
				System.out.println("You've selected: BFS");
				n=breadthFirstSearch(table_list, visited_tables, final_table);
		}
			else if(search==3){
				List table_list=new List();
				//adds table to list
				table_list.addFirst(initial_table,0,"");
				System.out.println("You've selected: Iterative DFS");
				n=iterativeDepthFirstSearch(initial_table, final_table, 0);
			}
			else if(search==4){
				PriorityQueue<Node> table_list=new PriorityQueue<Node>();
				//adds table to list
				Node initial_node=new Node(initial_table,0,"",getDistanceTo(initial_table, final_table),null);	
				table_list.add(initial_node);
				System.out.println("You've selected: Pesquisa Gulosa");
				n=greedySearch(table_list, visited_tables, final_table);
			}
			else if(search==5){
				PriorityQueue<Node> table_list=new PriorityQueue<Node>();
				//adds table to list
				Node initial_node=new Node(initial_table,0,"",getDistanceTo(initial_table, final_table),null);	
				table_list.add(initial_node);
				System.out.println("You've selected: Pesquisa A*");
				n=aStarSearch(table_list, final_table);
			}
			else
				System.out.println("Invalid option!\nPlease select a valid search");
			if(search==1 || search==2 || search==3 || search==4 || search==5){
				System.out.println("-----------------------------------");
				double end=new Date().getTime();
				System.out.println("Depth of solution: "+n.getDepth());
				System.out.println("Plays: "+n.getPath());
				System.out.println("Execution time: "+((end-start)/1000)+"s ("+(end-start)+"ms)");
				double used_memory=Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
				System.out.printf("Memory used: %dkb (%.3fMB)\n",((int)used_memory/(1024)),(used_memory/(1024*1024)));
			}
		}
		else
			System.out.println("No solution!");
	}
			
/**
 * check if problem has solution
 * @param initial_table	 initial table	 
 * @param final_table	 target table
 * @return boolean	
 */
	static public boolean hasSolution(int[][] initial_table,int[][] final_table){
		int init_count=0,final_count=0;
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				for(int k=i;k<3;k++)
					for(int t=0;t<3;t++){
						if(initial_table[i][j]>initial_table[k][t] && (i<k || j<t) && initial_table[k][t]!=0)
							init_count++;
						if(final_table[i][j]>final_table[k][t] && (i<k || j<t) && final_table[k][t]!=0)
							final_count++;
					}
		//check tables' parity
		if((final_count%2==0 && init_count%2!=0) || (init_count%2==0 && final_count%2!=0))
			return false;
		return true;
	}
}