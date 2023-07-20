import java.util.Scanner;
public class tictak {
    char board[][]=new char[3][3];

    public static void Display(char board[][]) {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++){
                System.out.print(board[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public static void Replace(char board[][],char find, char replace)
    {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++){
                if(board[i][j] == find)
                {
                    board[i][j] = replace;
                    return;
                }
            }
        }
    }
    public boolean checkForWin(){
        return(checkForRow() || checkForColomn() || checkForDiagnol());
    }

    public boolean checkForRow() {
        for(int i=0;i<3;i++) {
            if(check(board[i][0],board[i][1],board[i][2])==true)
                return true;
        }
            return false;
    }
    //checkForColomn function
    public boolean checkForColomn() {
        for(int i=0;i<3;i++) {
            if(check(board[0][i],board[1][i],board[2][i])==true)
                return true;
        }
            return false;
    }
    //checkForDiagnol function
    public boolean checkForDiagnol() {
        return ((check (board[0][0],board[1][1],board[2][2])==true) || (check (board[0][2],board[1][1],board[2][0])==true));

    }
    //check function
    public boolean check(char c1,char c2,char c3)
    {
        return(c1==c2) && (c2==c3);
    }

    //main function
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String player1,player2;
        System.out.print("Enter player 1 name:");
        player1=in.nextLine();
        System.out.print("Enter player 2 name:");
        player2=in.nextLine();
        //take Player Marker
        char player1Marker, player2Marker;
        System.out.print(player1+" select Marker (x or o): ");
        player1Marker=in.nextLine().charAt(0);
        while(player1Marker != 'x' && player1Marker != 'X' && player1Marker != 'o' && player1Marker != 'O' )
        {
            System.out.print("Invalid Input, Enter Correct Marker Symbol:");
            player1Marker=in.nextLine().charAt(0);
        }
        if(player1Marker == 'x' || player1Marker =='X')
            player2Marker ='o';
        else
            player2Marker ='X';      
        //System.out.print(player2Marker+" select Marker (x or o): ");
        //player2Marker=in.nextLine().charAt(0);
        tictak game=new tictak();
        int counter=0;    
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
               game.board[i][j]=Character.forDigit(counter++,10);
            }   
             }
             Display(game.board);
             char choice;
             for(int i=0;i<3;i++) {
                System.out.print(player1+" Turn: ");
                choice=in.next().charAt(0);
                Replace(game.board,choice,player1Marker);
                Display(game.board);

                System.out.print(player2+" Turn: ");
                choice=in.next().charAt(0);
                Replace(game.board,choice,player2Marker);
                Display(game.board);
             }
             System.out.print(player1+" Turn: ");
                choice=in.next().charAt(0);
                Replace(game.board,choice,player1Marker);
                Display(game.board);
                if(game.checkForWin())
                   System.out.println("we have a winner");
                else
                    System.out.println("Match is draw");   
    } 
}
