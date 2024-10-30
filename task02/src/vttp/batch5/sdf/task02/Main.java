package vttp.batch5.sdf.task02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

	static char[] board;
	static int utility;

	public static void main(String[] args) throws Exception {

		if (args.length == 0) {
            System.out.println("Usage: java task02.Main <board_file_name>");
            System.exit(1);
        }

		String boardFileName = args[0];
		System.out.println("Processing: " + boardFileName + "\n");

        File boardFile = new File (boardFileName);
		ArrayList<String> readBoard = new ArrayList<>();

		// read board config file
		try {
			FileReader fr = new FileReader(boardFile);
            BufferedReader br = new BufferedReader(fr);
            String line;

			while ((line = br.readLine()) != null) {
				char var1 = line.charAt(0);
				String v1 = String.valueOf(var1);
				readBoard.add(v1);

				char var2 = line.charAt(1);
				String v2 = String.valueOf(var2);
				readBoard.add(v2);

				char var3 = line.charAt(2);
				String v3 = String.valueOf(var3);
				readBoard.add(v3);
				
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println("Error reading board file." + e.getMessage());
		}

		String allVal = "";
		for (int i = 0; i < 9; i++) {
			String val = readBoard.get(i);
			allVal = allVal + val;
		}
		board = allVal.toCharArray();

		// print board
		System.out.println("Board: ");
		for (int i = 0; i < 9; i += 3) {
            System.out.println(board[i] + "" + board[i + 1] + "" + board[i + 2]);
        }
		System.out.println("-----------------------");

		char[] copyBoard = board;
		int countX = 0;
		int countO = 0;
		int countEmpty = 0;

		for (int i = 0; i < copyBoard.length; i++) {
			if (copyBoard[i] == 'X') {
				countX++;
			}
			if (copyBoard[i] == 'O') {
				countO++;
			}
			if (copyBoard[i] == '.') {
				countEmpty++;
			}
		}
		// System.out.println("No. of X: " + countX);
		// System.out.println("No. of O: " + countO);
		// System.out.println("No. of empty spaces: " + countEmpty);
		if (countO < countX) {
			System.out.println("Invalid board configuration. Next move is not 'X'. Exiting program.");
			System.exit(1);
		}

		int yCord = -99;
		int xCord = -99;
		int newUtility = -99;
		for (int i = 0; i < 9; i++) {
			if (copyBoard[i] == '.') {
				copyBoard[i] = 'X';
				newUtility = checkUtility(copyBoard);
				copyBoard[i] = '.';
			}

			if (0 <= i && i < 3) {
				yCord = 0;
				xCord = i;
			}

			if (3 <= i && i < 6) {
				yCord = 1;
				xCord = i - 3;
			}

			if (6 <= i && i < 9) {
				yCord = 2;
				xCord = i - 6;
			}

			if (newUtility != -99) {
				System.out.println("y=" + yCord + ", x=" + xCord + ", utility=" + newUtility);
			}

			yCord = -99;
			xCord = -99;
			newUtility = -99;
			
				
		}

	}


	static int checkUtility(char[] board) {
		// rows, cols, diagonals
		// {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, 
        // {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
        // {0, 4, 8}, {2, 4, 6}

		if (board[0] == 'X' && board[1] == 'X' && board[2] == 'X' || 
			board[3] == 'X' && board[4] == 'X' && board[5] == 'X' || 
			board[6] == 'X' && board[7] == 'X' && board[8] == 'X' || 

			board[0] == 'X' && board[3] == 'X' && board[6] == 'X' || 
			board[1] == 'X' && board[4] == 'X' && board[7] == 'X' || 
			board[2] == 'X' && board[5] == 'X' && board[8] == 'X' || 

			board[0] == 'X' && board[4] == 'X' && board[8] == 'X' || 
			board[2] == 'X' && board[4] == 'X' && board[6] == 'X' 
			) {
			return utility = 1;
		}

		else if ((board[0] == 'O' && board[1] == 'O' && board[2] == '.') || (board[1] == 'O' && board[2] == 'O' && board[0] == '.') || (board[0] == 'O' && board[2] == 'O' && board[1] == '.') ||
				(board[3] == 'O' && board[4] == 'O' && board[5] == '.') || (board[4] == 'O' && board[5] == 'O' && board[3] == '.') || (board[3] == 'O' && board[5] == 'O' && board[4] == '.') ||
				(board[6] == 'O' && board[7] == 'O' && board[8] == '.') || (board[7] == 'O' && board[8] == 'O' && board[6] == '.') || (board[6] == 'O' && board[8] == 'O' && board[7] == '.') ||

				(board[0] == 'O' && board[3] == 'O' && board[6] == '.') || (board[3] == 'O' && board[6] == 'O' && board[0] == '.') || (board[0] == 'O' && board[6] == 'O' && board[3] == '.') ||
				(board[1] == 'O' && board[4] == 'O' && board[7] == '.') || (board[4] == 'O' && board[7] == 'O' && board[1] == '.') || (board[1] == 'O' && board[7] == 'O' && board[4] == '.') ||
				(board[2] == 'O' && board[5] == 'O' && board[8] == '.') || (board[5] == 'O' && board[8] == 'O' && board[2] == '.') || (board[2] == 'O' && board[8] == 'O' && board[5] == '.') ||

				(board[0] == 'O' && board[4] == 'O' && board[8] == '.') || (board[4] == 'O' && board[8] == 'O' && board[0] == '.') || (board[0] == 'O' && board[8] == 'O' && board[4] == '.') ||
				(board[2] == 'O' && board[4] == 'O' && board[6] == '.') || (board[4] == 'O' && board[6] == 'O' && board[2] == '.') || (board[2] == 'O' && board[6] == 'O' && board[4] == '.')
				) {
					return utility = -1;
				}

		else {
			return utility = 0;
		}

    }

}
