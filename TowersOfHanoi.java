public class Main {
    int[][] board = {{3,2,1}, new int[3], new int[3]};

    public static void main(String[] args) {
	// write your code here
        Main game = new Main();
        game.play();
    };

    public void play() {
        while (this.isGameOver() == false) {
            this.makeTurn();
        }
        System.out.println("You won the game");
        this.printBoard();
    }

    public boolean isValidMove(int start,int end) {
        if (lastElement(this.board[start]) == 0) return false;
        if (lastElement(this.board[end]) == 0) return true;
        return lastElement(this.board[start]) < lastElement(this.board[end]);
    }

    public boolean isGameOver() {
        if (this.board[2][0] == 3 && this.board[2][1] == 2 && this.board[2][2] == 1) return true;
        return false;
    }

    public void makeTurn() {
        Scanner sc = new Scanner(System.in);
        this.printBoard();
        int i = -1;
//        System.out.println("Choose From");
        while (i < 0 || i > 2 || lastElement(this.board[i]) == 0) {
            System.out.println("Choose From");
            i = sc.nextInt();
        };
//        System.out.println("Move To");
        int j = -1;
        while (j < 0 || j > 2) {
            System.out.println("Move To");
            j = sc.nextInt();
        };
        if (this.isValidMove(i,j)) {
            this.moveRings(i,j);
        } else {
            System.out.println("Invalid Move");
        };
    }

    public void moveRings(int i, int j) {
        int ring = lastElement(this.board[i]);
        int lastIdx = lastElIdx(this.board[i]);
        this.board[i][lastIdx] = 0;
        lastIdx = lastElIdx(this.board[j]);
        if (this.board[j][lastIdx] == 0) {
            this.board[j][lastIdx] = ring;
        } else {
            this.board[j][lastIdx+1] = ring;
        }
    }

    public void printBoard() {
        System.out.print("|");
        System.out.print(this.board[0][2]);
        System.out.print("__");
        System.out.print(this.board[1][2]);
        System.out.print("__");
        System.out.print(this.board[2][2]);
        System.out.println("|");
        System.out.print("|");
        System.out.print(this.board[0][1]);
        System.out.print("__");
        System.out.print(this.board[1][1]);
        System.out.print("__");
        System.out.print(this.board[2][1]);
        System.out.println("|");
        System.out.print("|");
        System.out.print(this.board[0][0]);
        System.out.print("__");
        System.out.print(this.board[1][0]);
        System.out.print("__");
        System.out.print(this.board[2][0]);
        System.out.println("|");
    }

    public static int lastElement(int[] array) {
        for (int i = 2; i >= 0; i--) {
            if (array[i] != 0) return array[i];
        };
        return 0;
    }

    public static int lastElIdx(int[] array) {
        for (int i = 2; i > 0; i--) {
            if (array[i] != 0) return i;
        }
        return 0;
    }

}