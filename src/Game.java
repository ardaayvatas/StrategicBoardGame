
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		char Board [][] = new char [7][7];
		char ComputerBoard [][] = new char [7][7];
		BoardStart(Board);
		String mySymbols = "";
		String myWays = "";
		String [] symbols;
		String [] ways;
		int i;
		int choice;
		int x;
		int y;
		int mx;
		int my;
		int cx=0;
		int cy=0;
		int cmx=0;
		int cmy=0;
		int player;
		int computer;
		int playerPiece;
		int computerPiece;
		String playerFirstChoice ="";
		String computerFirstChoice ="";
		int pNum=4;
		int cNum=4;
		int max=-10000;
		int rNum=4;
		int min;
		int control=0;
		int moves = 0;
		System.out.println();
		System.out.println("GAME START");
		System.out.println();
		BoardPrint(Board);
		Random rand = new Random();
		int ranNum;
		int gamestop=0;
		float computerScoreAll=0;
		float playerScoreAll=0;
		float computerScore=0;
		float playerScore=0;
		while(true)
		{
			//if(moves==50)
			//{
			//	break;
			//}
			
			if(gamestop==1)
			{
				if(playerScore>computerScore)
				{
					playerScoreAll = playerScoreAll + 2 + playerScore;
					computerScoreAll = computerScoreAll -2 + computerScore;
				}
				
				else if(playerScore==computerScore)
				{
					playerScoreAll = (float) (playerScoreAll + 0.5 + playerScore);
					computerScoreAll = (float) (computerScoreAll +0.5 + computerScore);
				}
				
				else
				{
					playerScoreAll = playerScoreAll - 2 + playerScore;
					computerScoreAll = computerScoreAll + 2 + computerScore;
				}
				System.out.println();
				System.out.println("OVERALL SCORE\nPLAYER: "+playerScoreAll+"\nCOMPUTER: "+computerScoreAll);
				
				gamestop=0;
				moves=0;
				BoardStart(Board);
				System.out.println();
				System.out.println("NEW GAME STARTING... WAIT A SECOND");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println();
				BoardPrint(Board);
				cx=0;
				cy=0;
				cmx=0;
				cmy=0;
				playerFirstChoice ="";
				computerFirstChoice ="";
				pNum=4;
				cNum=4;
				max=-10000;
				control=0;
			}
			
			for(computer=0;computer<2;computer++)
			{
				if(moves==50)
				{
					gamestop = 1;
					break;
				}
				moves++;
				pNum=howMany('P',Board);
				cNum=howMany('C',Board);
				if(pNum==0 || cNum==0)
				{
					gamestop = 1;
					break;
				}
				//System.out.println(moves + ". move for C");
				
				//BoardPrint(Board);
				mySymbols = FindMySymbols(Board,computerFirstChoice,'C');
				symbols = mySymbols.split(",");
				for (i = 0; i<symbols.length;i++ )
				{
					//System.out.print(i + ":" + symbols[i].charAt(0) + symbols[i].charAt(1) + " ");
				}
				computerPiece=i;
				if(computerPiece==1)
				{
					computer=2;
				}
				System.out.println();
					for(int ii = 0 ; ii<computerPiece; ii++)
					{
						x = Integer.parseInt(symbols[ii].substring(0, 1));
						y = Integer.parseInt(symbols[ii].substring(1));
						//System.out.println(x);
						myWays = FindWays(x,y,Board);
						ways = myWays.split(",");
						for(int jj = 0; jj<ways.length; jj++)
						{
							boardEqual(ComputerBoard, Board);
							mx = Integer.parseInt(ways[jj].substring(0, 1));
							my = Integer.parseInt(ways[jj].substring(1));
							min = MoveComputer(x,y,mx,my,ComputerBoard);
							//BoardPrint(ComputerBoard);
							//System.out.println(min+"A");
							ranNum = rand.nextInt(4);
							//System.out.println();
							//System.out.println("ranNum:"+ ranNum);
							if (max < min)
							{
								max = min;
								cx = x;
								cy = y;
								cmx = mx;
								cmy = my;
								control = 1;
								//System.out.println("AAAAA");
								//System.out.println(max);
								//System.out.println("AAAA");
								//computerFirstChoice = mx + "" +my ; 
								//boardEqual(Board, ComputerBoard);
								
							}
							
							else if(max == min && ranNum>1)
							{
								max = min;
								cx = x;
								cy = y;
								cmx = mx;
								cmy = my;
								control = 1;
							}
							
						}
						
					}
					boardEqual(ComputerBoard, Board);
					if(control == 1)
					{
						control = 0;
						MoveComputer(cx,cy,cmx,cmy,ComputerBoard);
						boardEqual(Board,ComputerBoard);
						computerFirstChoice = cmx + "" + cmy;
					}
					max = -1000;
					System.out.println("OVERALL SCORE\nPLAYER: "+playerScoreAll+"\nCOMPUTER: "+computerScoreAll);
					System.out.println(moves + ". move for C");
					BoardPrint(Board);
					System.out.println();
					computerScore = (float) ((rNum - howMany('C', Board))*(0.5)*-1+(rNum-howMany('P', Board))*(0.5));
					playerScore = (float) ((rNum - howMany('P', Board))*(0.5)*-1+(rNum-howMany('C', Board))*(0.5));
					System.out.println("Computer: "+computerScore + "\nPlayer: "+playerScore);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			}
			computerFirstChoice = "";
			playerFirstChoice = "";
			
			pNum = howMany('P',Board);
			cNum = howMany('C',Board);
			//if(pNum==0 || cNum==0)
			//{
			//	break;
			//}
			
			for(player=0;player<2;player++)
			{
				if(moves==50)
				{
					gamestop = 1;
					break;
				}
				moves++;
				pNum=howMany('P',Board);
				cNum=howMany('C',Board);
				if(pNum==0 || cNum==0)
				{
					gamestop = 1;
					break;
				}
				System.out.println();
				
				System.out.println(moves + ". moves, for P please select!");
				BoardPrint(Board);
				System.out.println("Which one do you want to play");
				mySymbols = FindMySymbols(Board,playerFirstChoice,'P');
				symbols = mySymbols.split(",");
				for (i = 0; i<symbols.length;i++ )
				{
					System.out.print(i + ":" + symbols[i].charAt(0) + symbols[i].charAt(1) + " ");
				}
				playerPiece=i;
				if(playerPiece==1)
				{
					player=2;
				}
				System.out.println();
				choice = sc.nextInt();
				while(true)
				{
					if(choice>=0 && choice<symbols.length)
					{
						break;
					}
					System.out.println("Wrong choice");
					choice = sc.nextInt();
				}
				x = Integer.parseInt(symbols[choice].substring(0, 1));
				y = Integer.parseInt(symbols[choice].substring(1));
				myWays = FindWays(x,y,Board);
				ways = myWays.split(",");
				for (i = 0; i<ways.length;i++)
				{
					System.out.print(i + ":" + ways[i].charAt(0) + ways[i].charAt(1)  + " ");
				}
				System.out.println();
				choice = sc.nextInt();
				while(true)
				{
					if(choice>=0 && choice<ways.length)
					{
						break;
					}
					System.out.println("Wrong choice!");
					choice = sc.nextInt();
				}
				mx = Integer.parseInt(ways[choice].substring(0, 1));
				my = Integer.parseInt(ways[choice].substring(1));
				playerFirstChoice = mx + "" +my ;
				//System.out.println(playerFirstChoice);
				System.out.println("...PLAYING...");
				MovePlayer(x,y,mx,my,Board);
				System.out.println(moves + ". move for P");
				BoardPrint(Board);
				computerScore = (float) ((rNum - howMany('C', Board))*(0.5)*-1+(rNum-howMany('P', Board))*(0.5));
				playerScore = (float) ((rNum - howMany('P', Board))*(0.5)*-1+(rNum-howMany('C', Board))*(0.5));
				System.out.println("Computer: "+computerScore + "\nPlayer: "+playerScore);
				System.out.println("OVERALL SCORE\nPLAYER: "+playerScoreAll+"\nCOMPUTER: "+computerScoreAll);
			}
			playerFirstChoice ="";
			pNum = howMany('P',Board);
			cNum = howMany('C',Board);
			/*if(pNum==0 || cNum==0)
			{
				break;
			}*/
		}
			
	}
	
	
	
	
	public static void BoardStart(char[][] Board)
	{
		for(int i = 0; i<7 ;i++)
		{
			for (int j = 0; j<7 ;j++)
			{
				Board[i][j] = '*';
				if((i==0 && j==0)||(i==2 && j==0)||(i==4 && j==6)||(i==6 && j==6))
				{
					Board[i][j] = 'C';
				}
				
				if((i==0 && j==6)||(i==2 && j==6)||(i==4 && j==0)||(i==6 && j==0))
				{
					Board[i][j] = 'P';
				}
				
			}
		}
	}
	
	
	public static void BoardPrint(char[][] Board)
	{
		System.out.println("  0  1  2  3  4  5  6");
		for(int i = 0; i<7 ;i++)
		{
			System.out.print(i);
			for (int j = 0; j<7 ;j++)
			{
				System.out.print(" " +Board[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static String FindWays(int x,int y,char[][] Board)
	{
		String z = "";
		if(y<6)
		{
			if(Board[x][y+1] == '*')
			{
				z = z + (x) + (y+1) +",";
			}
		}
		
		if(y>0)
		{
			if(Board[x][y-1] == '*')
			{
				z = z + (x) + (y-1)+",";
			}
		}
		
		if(x<6)
		{
			if(Board[x+1][y] == '*')
			{
				z = z + (x+1) + (y)+",";
			}
		}
		
		if(x>0)
		{
			if(Board[x-1][y] == '*')
			{
				z = z + (x-1) + (y)+",";
			}
		}
		return z.substring(0, z.length()-1);	
	}
	
	public static String FindMySymbols(char[][] Board,String str,char ch)
	{
		String symbols = "";
		for(int i = 0; i<7 ;i++)
		{
			for (int j = 0; j<7 ;j++)
			{
				if(Board[i][j] == ch)
				{
					String s = j+""+i;
					String ss="";
					if(str.length()>1)
					{
						ss = Integer.parseInt(str.charAt(1)+"")+""+Integer.parseInt(str.charAt(0)+"");	
					}
					if(!ss.equals(s))
					{
						symbols = symbols + (i) + (j) + ",";
					}
				}
			}
		}
		
		
		return symbols.substring(0, symbols.length()-1);
	}
	
	public static void MovePlayer(int i, int j, int x, int y, char[][] Board)
	{
		Board[i][j] = '*';
		Board[x][y] = 'P';
		String str = "";
		//YATAY
		//P fonks çaðýr
		str = str + MoveHorizontalForP(x,Board);
		//System.out.println(str);
		//C fonks çaðýr
		str = str + MoveHorizontalForC(x,Board);
		//System.out.println(str);
		//Köþe fonks çaðýr
		str = str + MoveHorizontalForCorner(x, Board);
		//System.out.println(str);
		//Dikey
		//P fonks çaðýr
		str = str + MoveVerticalForP(y, Board);
		//System.out.println(str);
		//C fonks çaðýr
		str = str + MoveVerticalForC(y, Board);
		//System.out.println(str);
		//Köþe fonks çaðýr
		str = str + MoveVerticalForCorner(y, Board);
		//System.out.println(str);
		delete(Board,str);
		
	}
	
	public static String MoveHorizontalForP(int x,char[][] Board)
	{
		String boardDeleted = "";
		int pControl=0;
		int cControl=0;
		int px = 0;
		int cx = 0;
		for(int a = 0 ; a<7; a++)
		{
			
			if(Board[x][a]=='*')
			{
				pControl = 0;
				cControl = 0;
				//System.out.println(x + " " + a + " " + " pcontrol ccontrol = 0");
			}
			
			if(Board[x][a]=='P' && a+1<7 && Board[x][a+1]=='C')
			{
				pControl = 1;
				cControl = 1;
				cx = a+1;
				a++;
				//System.out.println(x + " " + a + " " + " pcontrol ccontrol = 1");
			}
			
			if(pControl == 1 && cControl == 1)
			{
				if(Board[x][a]=='P')
				{
					px = a;
					//System.out.println(px + " " + cx);
					//System.out.println(x + " " + a + " " + " Pnin yeri");
					pControl = 0;
					cControl = 0;
					break;
				}
			}
		}
		if(px != 0 && cx != 0)
		{
			for(int b=cx;b<px;b++)
			{
				//Board[x][b]='*';
				boardDeleted = boardDeleted + x + "" + b +"";
				//System.out.println(boardDeleted +" yýldýzlancak yerler");
			}
		}
		return boardDeleted;
	}
	
	public static String MoveHorizontalForC(int x,char[][] Board)
	{
		String boardDeleted = "";
		int pControl=0;
		int cControl=0;
		int px = 0;
		int cx = 0;
		for(int a = 0 ; a<7; a++)
		{
			
			if(Board[x][a]=='*')
			{
				pControl = 0;
				cControl = 0;
				//System.out.println(x + " " + a + " " + " pcontrol ccontrol = 0");
			}
			
			if(Board[x][a]=='C' && a+1<7 && Board[x][a+1]=='P')
			{
				pControl = 1;
				cControl = 1;
				px = a+1;
				a++;
				//System.out.println(x + " " + a + " " + " pcontrol ccontrol = 1");
			}
			
			if(pControl == 1 && cControl == 1)
			{
				if(Board[x][a]=='C')
				{
					cx = a;
					//System.out.println(cx + " " + px);
					//System.out.println(x + " " + a + " " + " Cnin yeri");
					pControl = 0;
					cControl = 0;
					break;
				}
			}
		}
		if(px != 0 && cx != 0)
		{
			for(int b=px;b<cx;b++)
			{
				//Board[x][b]='*';
				boardDeleted = boardDeleted + x + "" + b +"";
				//System.out.println(boardDeleted +" yýldýzlancak yerler");
			}
		}
		return boardDeleted;
	}
	
	public static String MoveHorizontalForCorner(int x,char[][] Board)
	{
		String boardDeletedFirst = "";
		String boardDeletedSec = "";
		
		char ch = Board[x][0];
		boardDeletedFirst = boardDeletedFirst + x + "0";
		for(int i = 1; i<4;i++)
		{	
			if(Board[x][i]=='*' || ch=='*')
			{
				boardDeletedFirst = "";
				break;
			}
			if(Board[x][i]!=ch && Board[x][i]!='*')
			{
				break;
			}
			if(Board[x][i]==ch)
			{
				boardDeletedFirst = boardDeletedFirst + x + "" + i +"";
			}
		}
		
		ch = Board[x][6];
		boardDeletedSec = boardDeletedSec + x + "6";
		for(int i=5;i>1;i--)
		{
			if(Board[x][i]=='*' || ch=='*')
			{
				boardDeletedSec = "";
				break;
			}
			if(Board[x][i]!=ch && Board[x][i]!='*')
			{
				break;
			}
			if(Board[x][i]==ch)
			{
				boardDeletedSec = boardDeletedSec + x + "" + i +"";
			}
		}
		return boardDeletedFirst + boardDeletedSec;
	}
	
	public static String MoveVerticalForP(int y,char[][] Board)
	{
		String boardDeleted = "";
		int pControl=0;
		int cControl=0;
		int py = 0;
		int cy = 0;
		//System.out.println(y);
		for(int a = 0 ; a<7; a++)
		{
			
			if(Board[a][y]=='*')
			{
				pControl = 0;
				cControl = 0;
				//System.out.println(y + " " + a + " " + " pcontrol ccontrol = 0");
			}
			
			if(Board[a][y]=='P' && a+1<7 && Board[a+1][y]=='C')
			{
				pControl = 1;
				cControl = 1;
				cy = a+1;
				a++;
				//System.out.println(y + " " + a + " " + " pcontrol ccontrol = 1");
			}
			
			if(pControl == 1 && cControl == 1)
			{
				if(Board[a][y]=='P')
				{
					py = a;
					//System.out.println(py + " " + cy);
					//System.out.println(y + " " + a + " " + " Pnin yeri");
					pControl = 0;
					cControl = 0;
					break;
				}
			}
		}
		if(py != 0 && cy != 0)
		{
			for(int b=cy;b<py;b++)
			{
				//Board[x][b]='*';
				boardDeleted = boardDeleted + b + "" + y +"";
				//System.out.println(boardDeleted +" yýldýzlancak yerler");
			}
		}
		return boardDeleted;
	}
	
	public static String MoveVerticalForC(int y,char[][] Board)
	{
		String boardDeleted = "";
		int pControl=0;
		int cControl=0;
		int py = 0;
		int cy = 0;
		//System.out.println(y);
		for(int a = 0 ; a<7; a++)
		{
			if(Board[a][y]=='*')
			{
				pControl = 0;
				cControl = 0;
				//System.out.println(y + " " + a + " " + " pcontrol ccontrol = 0");
			}
			
			if(Board[a][y]=='C' && a+1<7 && Board[a+1][y]=='P')
			{
				pControl = 1;
				cControl = 1;
				py = a+1;
				a++;
				//System.out.println(y + " " + a + " " + " pcontrol ccontrol = 1");
			}
			
			if(pControl == 1 && cControl == 1)
			{
				if(Board[a][y]=='C')
				{
					cy = a;
					//System.out.println(cy + " " + py);
					//System.out.println(y + " " + a + " " + " Cnin yeri");
					pControl = 0;
					cControl = 0;
					break;
				}
			}
		}
		if(py != 0 && cy != 0)
		{
			for(int b=py;b<cy;b++)
			{
				//Board[x][b]='*';
				boardDeleted = boardDeleted + b + "" + y +"";
				//System.out.println(boardDeleted +" yýldýzlancak yerler");
			}
		}
		return boardDeleted;
	}
	
	public static String MoveVerticalForCorner(int y,char[][] Board)
	{
		String boardDeletedFirst = "";
		String boardDeletedSec = "";
		
		char ch = Board[0][y];
		boardDeletedFirst = boardDeletedFirst + "0" + y;
		for(int i = 1; i<4;i++)
		{	
			if(Board[i][y]=='*' || ch=='*')
			{
				boardDeletedFirst = "";
				break;
			}
			if(Board[i][y]!=ch && Board[i][y]!='*')
			{
				break;
			}
			if(Board[i][y]==ch)
			{
				boardDeletedFirst = boardDeletedFirst + i + "" + y +"";
			}
		}
		
		ch = Board[6][y];
		boardDeletedSec = boardDeletedSec + "6" + y;
		for(int i=5;i>1;i--)
		{
			if(Board[i][y]=='*' || ch=='*')
			{
				boardDeletedSec = "";
				break;
			}
			if(Board[i][y]!=ch && Board[i][y]!='*')
			{
				break;
			}
			if(Board[i][y]==ch)
			{
				boardDeletedSec = boardDeletedSec + i + "" + y +"";
			}
		}
		return boardDeletedFirst + boardDeletedSec;
	}
	
	public static void delete (char Board[][],String str)
	{

		for(int i=0;i<str.length();i++)
		{
			Board[Integer.parseInt(str.charAt(i)+"")][Integer.parseInt(str.charAt(i+1)+"")] = '*';
			i++;
		}
	}
	
	public static int howMany (char x,char Board[][])
	{
		int n=0;
		for(int i = 0; i<7 ;i++)
		{
			for (int j = 0; j<7 ;j++)
			{
				if(Board[i][j] == x)
				{
					n++;
				}
			}
		}
		return n;
	}
	
	public static int MoveComputer(int i, int j, int x, int y, char[][] Board)
	{
		int cNumber = howMany('C', Board);
		int pNumber = howMany('P', Board);
		Board[i][j] = '*';
		Board[x][y] = 'C';
		String str = "";
		//YATAY
		//P fonks çaðýr
		str = str + MoveHorizontalForP(x,Board);
		//System.out.println(str);
		//C fonks çaðýr
		str = str + MoveHorizontalForC(x,Board);
		//System.out.println(str);
		//Köþe fonks çaðýr
		str = str + MoveHorizontalForCorner(x, Board);
		//System.out.println(str);
		//Dikey
		//P fonks çaðýr
		str = str + MoveVerticalForP(y, Board);
		//System.out.println(str);
		//C fonks çaðýr
		str = str + MoveVerticalForC(y, Board);
		//System.out.println(str);
		//Köþe fonks çaðýr
		str = str + MoveVerticalForCorner(y, Board);
		//System.out.println(str);
		delete(Board,str);
		int cNewNumber = howMany('C', Board);
		int pNewNumber = howMany('P', Board);
		int result = 0;
		result = (cNewNumber-cNumber)*5;
		result = result + (pNumber-pNewNumber)*5;
		
		return result;
	}
	
	public static void boardEqual(char[][] ComputerBoard,char[][] Board)
	{
		for(int i=0;i<7;i++)
		{
			for(int j=0;j<7;j++)
			{
				ComputerBoard[i][j] = Board[i][j];
			}
		}
	}
	
}
