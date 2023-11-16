package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Easy_2048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(move(board, n, 0, new Stack<>()));
    }

    public static int move(int[][] board, int n, int cnt, Stack<Integer> stack) {
        if(cnt > 4) {
            int max = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(max < board[i][j]) {
                        max = board[i][j];
                    }
                }
            }
            return max;
        }

        int[][] temp = deepCopy(board);
        moveToUp(temp, n, stack);
        int n1 = move(temp, n, cnt+1, stack);

        temp = deepCopy(board);
        moveToDown(temp, n, stack);
        int n2 = move(temp, n, cnt+1, stack);

        temp = deepCopy(board);
        moveToLeft(temp, n, stack);
        int n3 = move(temp, n, cnt+1, stack);

        temp = deepCopy(board);
        moveToRight(temp, n, stack);
        int n4 = move(temp, n, cnt+1, stack);

        return Math.max(Math.max(n1, n2), Math.max(n3, n4));
    }

    public static void moveToUp(int[][] board, int n, Stack<Integer> stack) {
        for(int i = 0; i < n; i++) {
            for(int j = (n-1); j >= 0; j--) {
                if(board[j][i] > 0) {
                    stack.push(board[j][i]);
                }
            }

            for(int j = 0; j < n; j++) {
                if(!stack.isEmpty()) {
                    int number = stack.pop();
                    if(!stack.isEmpty()) {
                        number = (stack.peek() == number) ? stack.pop() + number : number;
                    }
                    board[j][i] = number;
                } else {
                    board[j][i] = 0;
                }
            }
        }
    }

    public static void moveToDown(int[][] board, int n, Stack<Integer> stack) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[j][i] > 0) {
                    stack.push(board[j][i]);
                }
            }


            for(int j = (n-1); j >= 0; j--) {
                if(!stack.isEmpty()) {
                    int number = stack.pop();
                    if(!stack.isEmpty()) {
                        number = (stack.peek() == number) ? stack.pop() + number : number;
                    }
                    board[j][i] = number;
                } else {
                    board[j][i] = 0;
                }
            }
        }
    }

    public static void moveToLeft(int[][] board, int n, Stack<Integer> stack) {
        for(int i = 0; i < n; i++) {
            for(int j = (n-1); j >= 0; j--) {
                if(board[i][j] > 0) {
                    stack.push(board[i][j]);
                }
            }

            for(int j = 0; j < n; j++) {
                if(!stack.isEmpty()) {
                    int number = stack.pop();
                    if(!stack.isEmpty()) {
                        number = (stack.peek() == number) ? stack.pop() + number : number;
                    }
                    board[i][j] = number;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void moveToRight(int[][] board, int n, Stack<Integer> stack) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] > 0) {
                    stack.push(board[i][j]);
                }
            }

            for(int j = (n-1); j >= 0; j--) {
                if(!stack.isEmpty()) {
                    int number = stack.pop();
                    if(!stack.isEmpty()) {
                        number = (stack.peek() == number) ? stack.pop() + number : number;
                    }
                    board[i][j] = number;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }

    public static int[][] deepCopy(int[][] original) {
        if (original == null) {
            return null;
        }

        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = Arrays.copyOf(original[i], original[i].length);
        }

        return copy;
    }
}
