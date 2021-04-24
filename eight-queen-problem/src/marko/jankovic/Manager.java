package marko.jankovic;

import java.util.ArrayList;
import java.util.Arrays;

public class Manager {
    private int	n;
    private int	counter;
    private int[] board;
    private int[] queens;
    ArrayList<String> permutations = new ArrayList<>();

    public Manager(int n){
        this.n = n;
        this.counter = 1;
        board = new int[n];
        queens = new int[n];
        permuteQueens(0);
    }



    private void permuteQueens(int row){
        if(row == n){
            Worker worker = new Worker();
            if(worker.solve(board)) {
                permutations.add(Arrays.toString(board));
            }
        }else{
            for(int i = 0; i < n; i++){
                board[row] = i;
                if(queens[i]==0){
                    queens[i]=1;
                    permuteQueens(row+1);
                    queens[i]=0;
                }
            }
        }
    }
}
