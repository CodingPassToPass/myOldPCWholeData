package Java.javaDatastructure;

public class Backtracking {
    public static void changeArr1(int arr[], int si, int value){
        //base case
        if(arr.length==si){
            return;
        }
        //recursion
        arr[si] = value;
        changeArr1( arr, si+1, value+1); //fnx call step
        arr[si] = arr[si]-2; //backtracking step
    }
    public static void findSubsets2( String str, String ans, int i){
        //base case
        if(str.length()==i){
            System.out.println(ans);
            return;
        }
        findSubsets2(str, ans+str.charAt(i), i+1); //recursion
        findSubsets2(str, ans, i+1); //backtracking
    }
    public static void findPerm3( String str, String ans){
        if(str.length()==0){
            System.out.println(ans);
        }
        for( int i=0; i<str.length();i++){
            String newStr = str.substring(0, i) + str.substring(i+1);
            findPerm3( newStr, ans+str.charAt(i));
        }
    }
    public static void printBoard(char board[][]){
        System.out.println("----chessboard----");

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(" "+board[i][j]+" " );
            }
            System.out.println();
        }
    }
    public static boolean isSafeForQueen(char board[][], int row, int col){

        //vertical up
        for(int i=row-1; i>=0; i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        //diagonal left up
        for(int i=row-1,j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        //diagonal right up
        for(int i=row-1,j=col+1; i>=0 && board.length>j; i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static void nQueens4(char board[][], int row){
        if(board.length==row){
           printBoard(board);
           return;
        }
        for(int j=0; j<board.length; j++){
            if( isSafeForQueen(board, row, j)){
            board[row][j] = 'Q';
            nQueens4( board, row+1);         //function call
            board[row][j] = '.';            //backtracking step
            }
        }
    }
    public static Boolean isSafeForKnights(char board[][],int i,int j){

        // upper top left side
        if( i-2>=0 && j-1>=0 && board[i-2][j-1]=='K'){
            return false;
        }
        // upper top right side
        if( i-2>=0 && j+1<board.length && board[i-2][j+1]=='K'){
            return false;
        }
        // upper left side
        if( i-1>=0 && j-2>=0 && board[i-1][j-2]=='K'){
            return false;
        }
        // upper right side
        if( i-1>=0 && j+2<board.length && board[i-1][j+2]=='K'){
            return false;
        }

        return true;
      
    }
    public static void nKnights5(char board[][] ,int row){
        if(board.length==row){
            printBoard(board);
            return;
        }
        for(int j=0;j<board.length;j++){
            if(isSafeForKnights( board, row, j)){
                board[row][j] = 'K';
                nKnights5(board, row+1);
                board[row][j] = '.';
            }
        }
    }

    public static int gridWays6(int i,int j,int m, int n){
        if(i==m || j==n){
            return 0;
        }
        if(i==m-1 && j==n-1){
            return 1;
        }
        return gridWays6(i+1,j,m,n)+gridWays6(i,j+1,m,n);
    }
    public static void printSudoku(int sudoku[][]){
        for(int i=0; i< sudoku.length; i++){
            for(int j=0; j< sudoku[0].length; j++){
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean isSafeForSudoku(int sudoku[][], int row, int col, int digit){

        //check full column[ | ]
        for(int i=0; i<=8; i++){
            if(sudoku[i][col]==digit){
                return false;
            }
        }

        //check full row[-------] 
        for(int j=0; j<=8; j++){
            if(sudoku[row][j]==digit){
                return false;
            }
        }

        //grid
        int sr = (row/3)*3;
        int sc = (col/3)*3;

        //3*3 grid
        for(int i=sr; i<sr+3;i++){
            for(int j=sc; j<sc+3; j++){
                if(sudoku[i][j]==digit){
                    return false;
                }
            }
        }

        return true;

    }
    public static void sudokuSolver( int sudoku[][], int row, int col){

        //base case
        if(row==9){
            System.out.println("print it");
            printSudoku(sudoku);
            return;
        }
       
        //increment
        int newRow, newCol;
        if(col+1==9){
            newRow = row+1;
            newCol = 0;
        }
        else{
            newRow=row;
            newCol=col+1;
        }

        if(sudoku[row][col] != 0){
            sudokuSolver(sudoku, newRow, newCol);
        }
        else{
        for(int digit=1; digit<=9; digit++){
            if(isSafeForSudoku( sudoku, row, col, digit)){
                sudoku[row][col] = digit;
                sudokuSolver(sudoku, newRow, newCol);
                sudoku[row][col] = 0;
            }
          }
        }
       
    }
    public static Boolean isSafe77(int sudoku[][], int i, int j,int num){
        for(int x=0; x<9; x++){
            if(sudoku[x][j]==num){
                return false;
            }
        }
        for(int y=0; y<9; y++){
            if(sudoku[i][y]==num){
                return false;
            }
        }
        int xi = (i/3)*3;
        int yi = (j/3)*3;
        for(int x=xi; x<3;x++){
            for(int y=yi; y<3; y++){
                if(sudoku[x][y]==num){
                    return false;
                }
            }
        }
        return true;
    }
    public static void sudokuSolver77(int sudoku[][], int row, int col ){

        if(row==9){
            printSudoku(sudoku);
            return;
        }

        int newCol, newRow;
        if(col+1==9){
            newCol=0;
            newRow=row+1;
        }
        else{
            newCol=col+1;
            newRow=row;
        }

        if(sudoku[row][col] !=0){
            sudokuSolver(sudoku, newRow, newCol);
        }

        for(int num=1;num<10;num++){
            if(isSafe77(sudoku, row, col, num)){
                sudoku[row][col]=num;
                sudokuSolver77(sudoku, newRow, newCol);
                sudoku[row][col]=0;
            }
        }
    }
    public static void main(String args[]){
        //1. Initialize array with increment of 1 (1,2,3,4,5) and then decrement from each element by 2.(-1,0,1,2,3)
        // int arr[] = new int[5];
        // changeArr1( arr, 0, 1);
        // for(int i=0;i<arr.length;i++){
        //     System.out.print(arr[i]+" ");
        // }

        //2. find and print all subsets of a given string
        // String str = "abc";
        // findSubsets2(str, "", 0);

        //3. find and print all permutations of a String
        // String str = "abc";
        // findPerm3(str, "");

        //4. [N-Queens][ place N queens on an N*N chessboard such that no 2 queens can attack each other]
        // int n=4;
        // char board[][] = new char[n][n];
        // for(int i=0;i<board.length;i++){
        //     for(int j=0;j<board.length;j++){
        //         board[i][j] = '.';
        //     }
        // }
        // nQueens4( board, 0);

        //5. [N-Knights][ place N knights(horse) on an N*N chessborad such that no 2 knights attack each other][one knight in one row]
        // int n=3;
        // char board[][] = new char[n][n];
        // for(int i=0;i<board.length;i++){
        //     for(int j=0;j<board.length;j++){
        //         board[i][j] = '.';
        //     }
        // }

        // nKnights5( board, 0);

        //6. [grid-Ways][ find Number of ways to reach from (0,0) to (N-1,M-1) Grid. Allowed moves:- right or down]
        // int m=4,n=4;

        // int ways = gridWays6(0,0,m,n);
        // System.out.println("Total ways are: "+ways);

        //7. [ Sudoku ]
        int sudoku[][] = { 
            {0, 0, 8, 0, 0, 0, 0, 0, 0},
            {4, 9, 0, 1, 5, 7, 0, 0, 2},
            {0, 0, 3, 0, 0, 4, 1, 9, 0},
            {1, 8, 5, 0, 6, 0, 0, 2, 0},
            {0, 0, 0, 0, 2, 0, 0, 6, 0},
            {9, 6, 0, 4, 0, 5, 3, 0, 0},
            {0, 3, 0, 0, 7, 2, 0, 0, 4},
            {0, 4, 9, 0, 3, 0, 0, 5, 7},
            {8, 2, 7, 0, 0, 9, 0, 1, 3} };

        //--// if(sudokuSolver7(sudoku, 0, 0)){
        //--//     System.out.println("solution exists");
        //--//     printSudoku(sudoku);
        //--// }
        //--// else{
        //--//     System.out.println("soluton does not exists");
        //--// }

        sudokuSolver77(sudoku, 0, 0);

    }
}
