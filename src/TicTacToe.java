import java.util.*;

public class TicTacToe {

    static ArrayList<Integer> humanPosition = new ArrayList<Integer>();
    static ArrayList<Integer> computerPosition = new ArrayList<Integer>();

    public static void main(String[] args) {
        //Board game
        char [][] gameBoard = {
                {' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '},
                };

        printBoard(gameBoard);

        while(true) {
            Scanner innoza = new Scanner(System.in);

            System.out.print("Enter your position (1 - 9): ");
            int userPosition = innoza.nextInt();

            while(humanPosition.contains(userPosition) || computerPosition.contains(userPosition)){
                System.out.println("Enter a valid position");
                userPosition = innoza.nextInt();
            }
            placePiceOnBoard(gameBoard, userPosition, "human");
            String winner = checkWinner();
            Random placeOnBoard = new Random();
            int pcposition = placeOnBoard.nextInt(9) + 1;
            while(computerPosition.contains(pcposition) || humanPosition.contains(pcposition)){
                pcposition = innoza.nextInt();
            }
            placePiceOnBoard(gameBoard, pcposition, "PC");

            printBoard(gameBoard);
            System.out.println(winner);
        }
    }

    public static void printBoard(char [][] gameBoard){
        for(char [] row:gameBoard){
            for(char c: row){
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void placePiceOnBoard(char [][] gameBoard, int position, String player){
       char symbol = ' ';

        if(player.equals("human")){
           symbol = 'X';
           humanPosition.add(position);
       }
        else if(player.equals("PC")){
            symbol = '0';
            computerPosition.add(position);
        }
        switch(position){
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }
    public static String checkWinner(){
        List topRow = Arrays.asList(1,2,3);
        List middleRow  = Arrays.asList(4,5,6);
        List bottomRow = Arrays.asList(7,8,9);

        List diagonal1  = Arrays.asList(7,5,3);
        List diagonal2 = Arrays.asList(1,5,9);

        List leftCol = Arrays.asList(1,4,7);
        List middleCol  = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);

        List<List> winnerConditions = new ArrayList<List>();
        winnerConditions.add(topRow);
        winnerConditions.add(middleRow);
        winnerConditions.add(bottomRow);
        winnerConditions.add(diagonal1);
        winnerConditions.add(diagonal2);
        winnerConditions.add(leftCol);
        winnerConditions.add(middleCol);
        winnerConditions.add(rightCol);

        for (List list: winnerConditions){

            if(humanPosition.containsAll(list)){

                return "congratulations you won!";
            }
            else if (computerPosition.containsAll(list)){

                return "COMPUTER Wins!";
            }
            else if (computerPosition.size() + humanPosition.size() == 9){

                return "Draw";
            }
        }
        return "";
    }
}
