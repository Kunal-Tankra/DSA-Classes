package Graphs.Graphs3.practiceQ1;

import java.util.*;

import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

public class MinTmToRot {
    // minimum time required to rot all oranges.....
    static class Pair{
        int row;
        int col;
        int tm;   //time

        Pair(int row, int col, int tm){
            this.row = row;
            this.col = col;
            this.tm = tm;
        }
    }

    public static int minTimeToRot(int arr[][]){
        int n = arr.length;   //rows
        int m = arr[0].length; //cols

        Queue<Pair> q = new LinkedList<>();

        int ones = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 2){
                    q.add(new Pair(i, j, 0));  //initialy add
                }
                else if(arr[i][j] == 1){
                   ones++; 
                }
            }
            
        }

        // left, right, up, down
        int rows[] = {0, 0, 1, -1};  //neighbours 
        int cols[] = {-1, 1, 0, 0};

        int time = 0;
        int checkOnes = 0;
        while(!q.isEmpty()){
            Pair curr = q.remove();
            int x = curr.row;
            int y = curr.col;
            int tm = curr.tm;
            time = Math.max(time, tm);

            // left , right,  up, down
            for (int i = 0; i < cols.length; i++) {
                if(isSafe(x+rows[i], y+ cols[i], n, m) && arr[x+ rows[i]][y + cols[i]] == 1){
                    arr[x+ rows[i]][y + cols[i]]++;
                    checkOnes++;
                    q.add(new Pair(x+rows[i], y+ cols[i], tm+1));
                }
                
            }
        }

        if(ones != checkOnes){  //there is remaining fresh/1
            return -1;
        }

        return time;

        
    }

    public static boolean isSafe(int x, int y, int n, int m){
        return (x>=0 && x<n && y>=0 && y<m);
    }


    public static void main(String[] args) {
        int arr[][] = { {2,1,0,2,1},
                        {1,1,1,2,1},
                        {1,1,0,2,1}};

        System.out.println(minTimeToRot(arr));
    }
}
