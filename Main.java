import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {

	int n = 8;
	int row , col ;
	int counter ;
	int [] r,c = new int[8];
	
	
	public static void main(String[] args) {
		new Main().start();

	}
	
	void start(){
		Scanner reader =  new Scanner(System.in);
		boolean [] R ;
		boolean[] D1 ;
		boolean[] D2 ;
		int [][] board ;
		int[] rows ;
		int cases = reader.nextInt();
		while(cases-- != 0){
			row = ( reader.nextInt() )-1;
			col = ( reader.nextInt() )-1;
			R = new boolean[9];
			D1 = new boolean[16];
			D2 = new boolean[16];
			board = new int[8][8];
			rows = new int [8] ;
			counter = 1 ;
			System.out.println("SOLN       COLUMN");
			System.out.println(" #      1 2 3 4 5 6 7 8");
			System.out.println();
			NQueens(0,R,D1,D2,board,rows);
			if(cases != 0)
				System.out.println();
		}
		
	}
	
	void NQueens(int col,boolean [] R ,boolean[] D1,boolean[] D2,int [][] board , int[] rows){
		
	    if(col<n)
	    {
	        for(int row=0 ; row<n ; row++)
	        {
	            if(  R[row]==false && D1[col+row]==false && D2[col-row+7]==false )
	            {	
	                R[row]=true;
	                D1[col+row]=true;
	                D2[col-row+7]=true;
	                board[row][col]= 1;
	                if(col==n-1){
	                	if(board[this.row][this.col]==1)
	                		print(board);
//	                	return ;
	                }
	                NQueens(col+1,R,D1,D2,board,rows);
	                board[row][col]=0 ;
	                R[row]=false;
	                D1[col+row]=false;
	                D2[col-row+7]=false;
	            }
	        }

	    }
	    return;
	}
	
	void print(int[] [] board){
		if(counter<10)
			System.out.print(" "+counter+"      ");
		else
			System.out.print(counter+"      ");
		for(int i=0 ; i<8 ; i++){
			
			for(int j=0 ; j<8 ; j++){
				if(board[j][i]==1){
					if(i!=7)
						System.out.print((j+1)+" ");
					else
						System.out.print((j+1));
				}
			}
		}
			System.out.println();
			counter++ ;
	}

}
