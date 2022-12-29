package com.csc229labfiles.mavenproject6;

import java.io.IOException;

import java.util.Arrays;
import java.util.Random;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class PrimaryController {

    @FXML
    private Circle CircleOne;

    @FXML
    private Circle CircleTwo;

    @FXML
    private Circle CircleThree;

    @FXML
    private Circle CircleFour;

    @FXML
    private Circle CircleFive;

    @FXML
    private Circle CircleSix;

    @FXML
    private Circle CircleSeven;

    @FXML
    private Circle CircleEight;

    @FXML
    private Circle CircleNine;

    @FXML
    private Rectangle SqaureOne;

    @FXML
    private Rectangle SquareTwo;

    @FXML
    private Rectangle SquareThree;

    @FXML
    private Rectangle SqaureFour;

    @FXML
    private Rectangle SqaureFive;

    @FXML
    private Rectangle SqaureSix;

    @FXML
    private Rectangle SquareSeven;

    @FXML
    private Rectangle SqaureEight;

    @FXML
    private Rectangle SqaureNine;

    @FXML
    private Label gameresult;

    private int[] filledGameSlots = new int[9];//this integer array keeps track of how many tic tac toe cells have been filled in the game 
    private int[] filledSquares = new int[5];//this integer array keeps track of how many filled squares cells there are in the game board for player 1 
    private int[] filledCircles = new int[5];//this integer array keeps track of how many filled Circles cells there are in the game board for player 2

    private int filledGameSlotsCounter = 0;//this variable keeps track of how many tic tac toe cells have been filled in as the game is being played
    private int filledSqauresCounter = 0;//this variable keeps track of how many tic tac toe cells have been filled in with a squareas the game is being played
    private int filledCircleCounter = 0;//this variable keeps track of how many tic tac toe cells have been filled in as the game is being played
    public static int currentplayer = 1;//this variable keeps track of the player and whose turn it is 

    private char winningTeam;//depending on which player wins the game this char will be used to set the winner 

    final private int[][] winningPositions = {//this 2 dimensional array stores all of the possible winning combinations in the game for a win to be registered 
        {1, 5, 9},
        {3, 5, 7},
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9},
        {1, 4, 7},
        {2, 5, 8},
        {3, 6, 9}
    };

    private boolean allowMoves = true;///this boolean allows players to put shapes in the gameboard once the game has ended it will be set to false

    private boolean tie = false;// this boolean is used to register if a tie conditon has been meet in the game

    /**
     * This handleSquareOneClick event handler method is used during the game to
     * keep track of who owns the First top left Tic tac toe cell in the game
     * board depending on whose turn is being played and and will place a shape
     * on the board based on the turn
     *
     * @param event
     */
    @FXML
    public void handleSquareOneClick(MouseEvent event) {

        //these comments apply to all nine of the handleSquareClick methods and each of there correseponding cells
        if (currentplayer == 1) {//if it is player 1's turn and they click the first cell the event handler will call the handleSqaureclick method for the first cell and will place a square there
            handleSquareClick(1);

        } else if (currentplayer == 2) {//if it is player 2's turn and they click the first cell the event handler will call the handleCircleclick method for the first cell and will place a Circle there
            handleCircleClick(1);

        }
        checkVictory();//here the event handler Method will check if a victory condition has been meet for either player 1 or 2 by calling the CheckVictory method

        changePlayer();//if a victory has not been reigistered the event handler method will call the change player method to players 2 turn so that they can pick which cell they would like to place there next shape
    }

    /**
     * This handleSquareTwoClick event handler method is used during the game to
     * keep track of who owns the Second top MiddleTic tac toe cell in the game
     * board depending on whose turn is being played and will place a shape on
     * the board based on the turn
     *
     * @param event
     */
    @FXML
    public void handleSquareTwoClick(MouseEvent event) {
        if (currentplayer == 1) {
            handleSquareClick(2);

        } else if (currentplayer == 2) {
            handleCircleClick(2);

        }
        checkVictory();

        changePlayer();
    }

    /**
     * This handleSquareThreeClick event handler method is used during the game
     * to keep track of who owns the Third top right Tic tac toe cell in the
     * game board depending on whose turn is being played and will place a shape
     * on the board based on the turn
     *
     * @param event
     */
    @FXML
    public void handleSquareThreeClick(MouseEvent event) {
        if (currentplayer == 1) {
            handleSquareClick(3);

        } else if (currentplayer == 2) {
            handleCircleClick(3);

        }
        checkVictory();

        changePlayer();
    }

    /**
     * This handleSquareFourClick event handler method is used during the game
     * to keep track of who owns the first middle left Tic tac toe cell in the
     * game board depending on whose turn is being played and will place a shape
     * on the board based on the turn
     *
     * @param event
     */
    @FXML
    public void handleSquareFourClick(MouseEvent event) {
        if (currentplayer == 1) {
            handleSquareClick(4);

        } else if (currentplayer == 2) {
            handleCircleClick(4);

        }

        checkVictory();

        changePlayer();
    }

    /**
     * This handleSquareFiveClick event handler method is used during the game
     * to keep track of who owns the Second middle middle(the Cell in the middle
     * of the tic tac toe board) Tic tac toe cell in the game board depending on
     * whose turn is being played and will place a shape on the board based on
     * the turn
     *
     * @param event
     */
    @FXML
    public void handleSquareFiveClick(MouseEvent event) {
        if (currentplayer == 1) {
            handleSquareClick(5);

        } else if (currentplayer == 2) {
            handleCircleClick(5);

        }

        checkVictory();

        changePlayer();
    }

    /**
     * This handleSquareSixClick event handler method is used during the game
     * to keep track of who owns the Third middle right Tic tac toe cell in the
     * game board depending on whose turn is being played and will place a shape
     * on the board based on the turn
     *
     * @param event
     */
    @FXML
    public void handleSquareSixClick(MouseEvent event) {
        if (currentplayer == 1) {
            handleSquareClick(6);

        } else if (currentplayer == 2) {
            handleCircleClick(6);

        }

        checkVictory();

        changePlayer();
    }

    /**
     * This handleSquareSevenClick event handler method is used during the game
     * to keep track of who owns the First bottom left Tic tac toe cell in the
     * game board depending on whose turn is being played and will place a shape
     * on the board based on the turn
     * @param event
     */
    @FXML
    public void handleSquareSevenClick(MouseEvent event) {
        if (currentplayer == 1) {
            handleSquareClick(7);

        } else if (currentplayer == 2) {
            handleCircleClick(7);

        }

        checkVictory();

        changePlayer();
    }

  /**
     * This handleSquareEightClick event handler method is used during the game
     * to keep track of who owns the First bottom Middle Tic tac toe cell in the
     * game board depending on whose turn is being played and will place a shape
     * on the board based on the turn
     * @param event
     */
    @FXML
    public void handleSquareEightClick(MouseEvent event) {
        if (currentplayer == 1) {
            handleSquareClick(8);

        } else if (currentplayer == 2) {
            handleCircleClick(8);

        }

        checkVictory();
        changePlayer();
    }

  /**
     * This handleSquareNineClick event handler method is used during the game
     * to keep track of who owns the First bottom right Tic tac toe cell in the
     * game board depending on whose turn is being played and will place a shape
     * on the board based on the turn
     * @param event
     */
    @FXML
    public void handleSquareNineClick(MouseEvent event) {
        if (currentplayer == 1) {
            handleSquareClick(9);

        } else if (currentplayer == 2) {
            handleCircleClick(9);

        }

        checkVictory();

        changePlayer();
    }

    /**
     * This handleSquareClick method is responsible for placing a Square on the
     * gameboard depending on Which Tictace game Cell number is passed into the
     * method and will end the game if player 1(sqaures) has won the Tic-tac-toe
     * game or if a tie conditon is met
     *
     *
     * @param showSquareAtGameCell
     */
    public void handleSquareClick(int showSquareAtGameCell) {
        if (!IsGameSlotFilled(showSquareAtGameCell) && allowMoves == true) {/*this if statement is checking if the game cell at location being passed in is not already filled in 
            and if the player can still put shapes on the board which is only true if the game has not ended 
            */
            switch (showSquareAtGameCell) {/* if the cell is not filled in already,depending on the game cell location which was passed in,this switch statement will call the showSquare Method 
                Associated with that game cell in order to make a Square visbile in that game cell 
                 */
                case 1:
                    showSquareOne();
                    break;
                case 2:
                    showSquareTwo();
                    break;
                case 3:
                    showSquareThree();
                    break;
                case 4:
                    showSquareFour();
                    break;
                case 5:
                    showSquareFive();
                    break;
                case 6:
                  showSqaureSix();
                    break;
                case 7:
                    showSquareSeven();
                    break;
                case 8:
                    showSquareEight();
                    break;
                case 9:
                    showSqaureNine();
                    break;
                default:
                    System.out.println("Impossible choice");
                    break;
            }

            System.out.println("Player1's turn /Sqaures Information");
            System.out.println("the square was  placed at GameCell:" + showSquareAtGameCell);
            filledGameSlots[filledGameSlotsCounter] = showSquareAtGameCell;//in this line of code I am storing the location of the cell which was filled with a square into the filled game slots array so that it can not be used again 
            System.out.println("filledSlots at postion " + filledGameSlots[filledGameSlotsCounter]);
            filledSquares[filledSqauresCounter] = showSquareAtGameCell;//in this line of code I am updating the filledSquares array with the location of the game cell that I was just filled in with a sqaure so that I can keep track of how many cells sqaures
            System.out.println("this keeps track of which slots have a square so that a circle won't be palced there " + filledSquares[filledSqauresCounter]);
            filledGameSlotsCounter++;//this count keeps track of how many slots have already been filled for both sqaures and Circles counting from the first cell
            System.out.println("this count keeps track of how many slots have already been filled counting from 0 " + filledGameSlotsCounter);
            System.out.println("pre count of Sqaures placed for this turn " + filledSqauresCounter);
            filledSqauresCounter++;
            System.out.println("post count of Sqaures placed for this turn " + filledSqauresCounter);
            System.out.println("  ");
            if (checkVictory()) {//if a victory conditon has been meet based on the game cell locations filled in with sqaures the function will end the game
                endGame();

            } else if (filledGameSlotsCounter >= 9) {//else if the total number of filled game cell locations for either Sqaures(player1) or circles(player2) is greater than 9 
                //this means that a victory condition was not meet for either player but all of the board slots are still filled in meaning we have a tie 
                System.out.println("this is game Slot counter if a tie conditon is met" + filledGameSlotsCounter);

                tie = true;//this sets the tie variable to be true

                endGame();//then we end the game 
            }
        }
    }
    /**
     * This IsGameSlotFilled method will be used to check if the game cell location being
     * passed in as a parameter has already been filled in with a shape and will return true if that
     * slot has already been filled
     * 
     * @param GameSlot
     * @return
     */
    public boolean IsGameSlotFilled(int GameSlot) {
        boolean found = false;//here I iniatilze found to be false since it's not being compared yet

        for (int filledGameCell : filledGameSlots) {/*here I am using an enchanced for loop to iterate theough the filledGameSlots array 
            to see which slots have already been filled in with a shape and I am storing the slots in the variable called filledGameCell
            */
            if (GameSlot == filledGameCell) {//if the game cell location we are trying to place a shape in is equal to a slot that is already filled in the statement will return true
                //and we will not be allowed to place a shape at that postion 
                found = true;
            }
        }

        return found == true;//I return true here because when this method is used to check if a gameslot is already filled in wihtin the handleSqaureClick and handleCircleClick methods it will be negated in order to check if a slot is not filled in
        //if it is filled in the condtion will not be run 
    }

    /**
     * This changePlayer method is Responsible for changing the player after a
     * turn has been played
     *
     * @return
     */
    public int changePlayer() {

        if (currentplayer == 1) {//if the current player is player 1 then the method will switch to player 2
            currentplayer = 2;
            return currentplayer;
        }
        currentplayer = 1;//else if it's current player is 2 then it will be set back to 1 
        return currentplayer;

    }
    /**
     * This checkVictory() method is responsible for checking if a Victory
     * Condition has been meet within the Tic-Tac-toe game
     * @return
     */
    @FXML
    public boolean checkVictory() {
        System.out.println("This statement is checking if the number of sqaues filled sqaures is less than 3 which means a win has not yet been registred " + filledSqauresCounter);
        System.out.println("This statement is checking if the number of sqaues filled sqaures is less than 3 which means a win has not yet been registred " + filledCircleCounter);
        System.out.println(" ");
        if (filledSqauresCounter < 3 && filledCircleCounter < 3) {/*This statement is checking if the number of filled sqaures and filled circles is less than 3 
            which means a win has not yet been registred/meet since we can not have a winner if there are not 3 shapes in a row*/
            System.out.println("Win condition has not been meet");
            return false;//return false if there is no winner
        }

        for (int[] filledGameCellsforwin : winningPositions) {/*here I am using an enchanced for loop to iterate through the winningPostions 2D array 
            so that I can check to see if a shape is in the game cell locations that correspond with any the winning postion combimnations in the 2D array
            and I am storing the indvidual combinations in a 1d array  so that the method  will look at each array separtely to see if three of the same shapes are in any of the 3 locations assoicated 
            with a win */
            System.out.println("this is the winning postion " + Arrays.toString(filledGameCellsforwin));
            int identicalSlotCounter = 0;//this keeps track of how many of the same Identical shapes are on the game board in a row

            for (int filledSqauresForWin : filledGameCellsforwin) {/*here I am using an enchanced for loop to iterate through the filledGameCellsforwin array 
            so that I can check to see if the winning locations in the array are filled in with squares for a victory to be registered for player 1*/
        
                if (isOccupiedBySquare(filledSqauresForWin)) {//if each of the winning locations is fillled in with a square  identicalSlotCounter goes up 
                    identicalSlotCounter++;
                }
            }

            if (identicalSlotCounter == 3) {//if identicalSlotCounter equals 3 it means we found 3 sqaures in the any of winning combintations in the array 
                System.out.println("win conditon met");
                winningTeam = 'O';//this sets the char of the winning team to 'O" which means that player 1 has won the game and a player 1 wins message will be displayed by the endGame() method
                allowMoves = false;//and the players will no longer be allowed to play any moves on the board
                return true;//here we return true to signify that a Victory Conditon has been met 
            }

            identicalSlotCounter = 0;//here I am resetting identicalSlotCounter to keep track of how many game cells have Circles in a row on the game board 

            for (int filledCirclesForWin : filledGameCellsforwin) {/*here I am using an enchanced for loop to iterate through the filledGameCellsforwin array 
            so that I can check to see if the winning locations in the array are filled in with Circles for a victory to be registered for player 2*/
                if (isOccupiedByCircle(filledCirclesForWin)) {//if each of the winning locations is fillled in with a Circle,  identicalSlotCounter goes up 
                    identicalSlotCounter++;
                }
            }

            if (identicalSlotCounter == 3) {//if identicalSlotCounter equals 3 it means we found 3 Circles  in the any of winning combintations in the array 
                winningTeam = 'X';//this sets the char of the winning team to 'X' which means that player 2 has won the game and a player 2 wins message will be displayed by the endGame() method
                allowMoves = false;
                return true;//here we return true to signify that a Victory Conditon has been met 
            }

        }

        return false;//if none of the Shapes matched any of the winning postions then we don't have a victory 
    }
   
    /**
     * this isOccupiedBySquare method is used to check how many gameCells on the
     * board are filled in with squares and if a square is in any of the
     * correct winning positions in the filledGameCellsforwin Array
     *
     * @param sqaurePosition
     * @return
     */
    public boolean isOccupiedBySquare(int sqaurePosition) {
        boolean found = false;//here I iniatilze found to be false since the method is not comparing anything yet

        for (int filledSqaure : filledSquares) {/*here I am using an enchanced for loop to iterate theough the filledSqaures array 
            to check which game cells have been filled in with a square and I am storing the cells in the variable called filledSquare
            */
            if (filledSqaure == sqaurePosition) {/*if the gameCell filled in with a square is equal to one of  the winning locations in the filledGameCellsforwin array 
                (which is being passed in a parameter)  then it means that there is a square in one of the  winning locations of the array */
                System.out.println("Sqaure is in correct win postion " + filledSqaure);
                System.out.println(" ");
             
                found = true;//here I am setting found to true because it means that we found a sqaure in one of the winninglocations of the array 
            }
        }

        return found == true;//here I am setting found to true so that I can ensure that if the correct postion is found it will be reigstered in the checkvictory method
    }
   /**
    *  this isOccupiedByCircle method is used to check how many gameCells on the
     * board are filled in with Circles and if a Circle is in the any of the
     * correct winning positions in the filledGameCellsforwin Array
    * @param circlePosition
    * @return 
    */
    public boolean isOccupiedByCircle(int circlePosition) {
        boolean found = false;//here I iniatilze found to be false since the method is not comparing anything yet

        for (int filledCircle : filledCircles) {/*here I am using an enchanced for loop to iterate theough the filledCircles array 
            to check which game cells have been filled in with a Circle and I am storing the cells in the variable called filledCircle
            */
            if (filledCircle == circlePosition) {/*if the gameCell filled in with a circle is equal to one of  the winning locations in the filledGameCellsforwin array 
                (which is being passed in a parameter)  then it means that there is a Circle in one of the winning locations of the array */
                System.out.println("Circle is in correct win postion " + filledCircle);
                System.out.println(" ");
                found = true;//here I am setting found to true because it means that we found a Circle in one of the winninglocations of the array 
            }
        }

        return found == true;//here I am setting found to true so that I can ensure that if the correct postion is found it will be reigstered in the checkvictory method
    }

    
    
    /**
     * this endGame() method will end the Tic-Tac-Toe Game once a victory
     * condition has been meet for one of players and will play an animation
     * depending on the winner
     */
    public void endGame() {
        allowMoves = false;//since this method ends the game this means that we can no longer play any moves on the board 

        if (tie == true) {//if a tie conditon was met as the result of the game the Gameresult label will display it was a tie 
            gameresult.setText("It was a tie!");
        } else if (String.valueOf(winningTeam).equals("O")) {//this statement checks if the char assoicated with the winning team is equal to 'O" which means Player 1 has won the game

            gameresult.setText("Player1 wins!");
            
            //since player 1 has won,there ALL NINE OF shapes will be scaled Up by double there X and Y coordinates 
            ScaleTransition st = new ScaleTransition(Duration.seconds(3), SqaureOne);
            st.setToX(2);
            st.setToY(2);
            st.setCycleCount(2);
            st.setAutoReverse(true);
            st.play();
            
              //then The rotation transiton will be Played on ALL NINE of there shapes 
            RotateTransition rotateTransition = new RotateTransition(Duration.seconds(3), SqaureOne);
            rotateTransition.setCycleCount(2);//the Transtion will last for 2 cycles
            rotateTransition.setToAngle(180);//this will rotate Player1's shapes by 180 degrees 
            rotateTransition.setAutoReverse(true);//once the transtion is over it will be reverted towards it's orignal state 
            rotateTransition.play();

            ScaleTransition st2 = new ScaleTransition(Duration.seconds(3), SquareTwo);
            st2.setToX(2);
            st2.setToY(2);
            st2.setCycleCount(2);
            st2.setAutoReverse(true);
            st2.play();

            RotateTransition rotateTransition2 = new RotateTransition(Duration.seconds(3), SquareTwo);
            rotateTransition2.setCycleCount(2);
            rotateTransition2.setToAngle(180);
            rotateTransition2.setAutoReverse(true);
            rotateTransition2.play();

            ScaleTransition st3 = new ScaleTransition(Duration.seconds(3), SquareThree);
            st3.setToX(2);
            st3.setToY(2);
            st3.setCycleCount(2);
            st3.setAutoReverse(true);
            st3.play();

            RotateTransition rotateTransition3 = new RotateTransition(Duration.seconds(3), SquareThree);
            rotateTransition3.setCycleCount(2);
            rotateTransition3.setToAngle(180);
            rotateTransition3.setAutoReverse(true);
            rotateTransition3.play();

            ScaleTransition st4 = new ScaleTransition(Duration.seconds(3), SqaureFour);
            st4.setToX(2);
            st4.setToY(2);
            st4.setCycleCount(2);
            st4.setAutoReverse(true);
            st4.play();

            RotateTransition rotateTransition4 = new RotateTransition(Duration.seconds(3), SqaureFour);
            rotateTransition4.setCycleCount(2);
            rotateTransition4.setToAngle(180);
            rotateTransition4.setAutoReverse(true);
            rotateTransition4.play();

            ScaleTransition st5 = new ScaleTransition(Duration.seconds(3), SqaureFive);
            st5.setToX(2);
            st5.setToY(2);
            st5.setCycleCount(2);
            st5.setAutoReverse(true);
            st5.play();
            RotateTransition rotateTransition5 = new RotateTransition(Duration.seconds(3), SqaureFive);
            rotateTransition5.setCycleCount(2);
            rotateTransition5.setToAngle(180);
            rotateTransition5.setAutoReverse(true);
            rotateTransition5.play();

            ScaleTransition st6 = new ScaleTransition(Duration.seconds(3), SqaureSix);
            st6.setToX(2);
            st6.setToY(2);
            st6.setCycleCount(2);
            st6.setAutoReverse(true);
            st6.play();

            RotateTransition rotateTransition6 = new RotateTransition(Duration.seconds(3), SqaureSix);
            rotateTransition6.setCycleCount(2);
            rotateTransition6.setToAngle(180);
            rotateTransition6.setAutoReverse(true);
            rotateTransition6.play();

            ScaleTransition st7 = new ScaleTransition(Duration.seconds(3), SquareSeven);
            st7.setToX(2);
            st7.setToY(2);
            st7.setCycleCount(2);
            st7.setAutoReverse(true);
            st7.play();

            RotateTransition rotateTransition7 = new RotateTransition(Duration.seconds(3), SquareSeven);
            rotateTransition7.setCycleCount(2);
            rotateTransition7.setToAngle(180);
            rotateTransition7.setAutoReverse(true);
            rotateTransition7.play();

            ScaleTransition st8 = new ScaleTransition(Duration.seconds(3), SqaureEight);
            st8.setToX(2);
            st8.setToY(2);
            st8.setCycleCount(2);
            st8.setAutoReverse(true);
            st8.play();

            RotateTransition rotateTransition8 = new RotateTransition(Duration.seconds(3), SqaureEight);
            rotateTransition8.setCycleCount(2);
            rotateTransition8.setToAngle(180);
            rotateTransition8.setAutoReverse(true);
            rotateTransition8.play();

            ScaleTransition st9 = new ScaleTransition(Duration.seconds(3), SqaureNine);
            st9.setToX(2);
            st9.setToY(2);
            st9.setCycleCount(2);
            st9.setAutoReverse(true);
            st9.play();

            RotateTransition rotateTransition9 = new RotateTransition(Duration.seconds(3), SqaureNine);
            rotateTransition9.setCycleCount(2);
            rotateTransition9.setToAngle(180);
            rotateTransition9.setAutoReverse(true);
            rotateTransition9.play();

        } else if (String.valueOf(winningTeam).equals("X")) {//this statement checks if the char assoicated with the winning team is equal to 'X" which means Player 2 has won the game
            gameresult.setText("Player2 win!");
            
           //since player 2  has won,there ALL NINE OF shapes will be scaled Up by double there X and Y coordinates 
            ScaleTransition st = new ScaleTransition(Duration.seconds(3), CircleOne);
            st.setToX(2);
            st.setToY(2);
            st.setCycleCount(2);//this makes the transtion play for 2 cycles
            st.setAutoReverse(true);//this resets the transtion back to it's orignal state 
            st.play();
             
            //then The Fade transiton will be Played on ALL NINE of there shapes 
            FadeTransition fadeTransition
                    = new FadeTransition(Duration.seconds(4), CircleOne);
            fadeTransition.setFromValue(1.0);
            fadeTransition.setToValue(0.0);
            fadeTransition.setCycleCount(2);//this makes the transtion play for 2 cycles
            fadeTransition.setAutoReverse(true);//this resets the transtion back to it's orignal state 
            fadeTransition.play();

            ScaleTransition st2 = new ScaleTransition(Duration.seconds(3), CircleTwo);
            st2.setToX(2);
            st2.setToY(2);
            st2.setCycleCount(2);
            st2.setAutoReverse(true);
            st2.play();

            FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(4), CircleTwo);
            fadeTransition2.setFromValue(1.0);
            fadeTransition2.setToValue(0.0);
            fadeTransition2.setCycleCount(2);
            fadeTransition2.setAutoReverse(true);
            fadeTransition2.play();

            ScaleTransition st3 = new ScaleTransition(Duration.seconds(3), CircleThree);
            st3.setToX(2);
            st3.setToY(2);
            st3.setCycleCount(2);
            st3.setAutoReverse(true);
            st3.play();

            FadeTransition fadeTransition3 = new FadeTransition(Duration.seconds(4), CircleThree);
            fadeTransition3.setFromValue(1.0);
            fadeTransition3.setToValue(0.0);
            fadeTransition3.setCycleCount(2);
            fadeTransition3.setAutoReverse(true);
            fadeTransition3.play();

            ScaleTransition st4 = new ScaleTransition(Duration.seconds(3), CircleFour);
            st4.setToX(2);
            st4.setToY(2);
            st4.setCycleCount(2);
            st4.setAutoReverse(true);
            st4.play();

            FadeTransition fadeTransition4 = new FadeTransition(Duration.seconds(4), CircleFour);
            fadeTransition4.setFromValue(1.0);
            fadeTransition4.setToValue(0.0);
            fadeTransition4.setCycleCount(2);
            fadeTransition4.setAutoReverse(true);
            fadeTransition4.play();

            ScaleTransition st5 = new ScaleTransition(Duration.seconds(3), CircleFive);
            st5.setToX(2);
            st5.setToY(2);
            st5.setCycleCount(2);
            st5.setAutoReverse(true);
            st5.play();
            FadeTransition fadeTransition5 = new FadeTransition(Duration.seconds(4), CircleFive);
            fadeTransition5.setFromValue(1.0);
            fadeTransition5.setToValue(0.0);
            fadeTransition5.setCycleCount(2);
            fadeTransition5.setAutoReverse(true);
            fadeTransition5.play();

            ScaleTransition st6 = new ScaleTransition(Duration.seconds(3), CircleSix);
            st6.setToX(2);
            st6.setToY(2);
            st6.setCycleCount(2);
            st6.setAutoReverse(true);
            st6.play();

            FadeTransition fadeTransition6 = new FadeTransition(Duration.seconds(4), CircleSix);
            fadeTransition6.setFromValue(1.0);
            fadeTransition6.setToValue(0.0);
            fadeTransition6.setCycleCount(2);
            fadeTransition6.setAutoReverse(true);
            fadeTransition6.play();

            ScaleTransition st7 = new ScaleTransition(Duration.seconds(3), CircleSeven);
            st7.setToX(2);
            st7.setToY(2);
            st7.setCycleCount(2);
            st7.setAutoReverse(true);
            st7.play();

            FadeTransition fadeTransition7 = new FadeTransition(Duration.seconds(4), CircleSeven);
            fadeTransition7.setFromValue(1.0);
            fadeTransition7.setToValue(0.0);
            fadeTransition7.setCycleCount(2);
            fadeTransition7.setAutoReverse(true);
            fadeTransition7.play();

            ScaleTransition st8 = new ScaleTransition(Duration.seconds(3), CircleEight);
            st8.setToX(2);
            st8.setToY(2);
            st8.setCycleCount(2);
            st8.setAutoReverse(true);
            st8.play();

            FadeTransition fadeTransition8 = new FadeTransition(Duration.seconds(4), CircleEight);
            fadeTransition8.setFromValue(1.0);
            fadeTransition8.setToValue(0.0);
            fadeTransition8.setCycleCount(2);
            fadeTransition8.setAutoReverse(true);
            fadeTransition8.play();

            ScaleTransition st9 = new ScaleTransition(Duration.seconds(3), CircleNine);
            st9.setToX(2);
            st9.setToY(2);
            st9.setCycleCount(2);
            st9.setAutoReverse(true);
            st9.play();

            FadeTransition fadeTransition9 = new FadeTransition(Duration.seconds(4), CircleNine);
            fadeTransition9.setFromValue(1.0);
            fadeTransition9.setToValue(0.0);
            fadeTransition9.setCycleCount(2);
            fadeTransition9.setAutoReverse(true);
            fadeTransition9.play();

            tie = false;
        }
    }
   /**
     * this showSquareOne()  method will set the First Circle Visible
     */
    public void showCircleOne() {
        CircleOne.setVisible(true);
    }  
       /**
     * this showCircleTwo()  method will set the Second  Circle Visible
     */
    public void showCircleTwo() {
        CircleTwo.setVisible(true);
    }
   /**
     * this showCircleThree() method will set the Third  Circle Visible
     */
    public void showCircleThree() {
        CircleThree.setVisible(true);
    }
       /**
     * this  showCircleFour()   method will set the Fourth Circle Visible
     */
    public void showCircleFour() {
        CircleFour.setVisible(true);
    }
   /**
     * this showCircleFive()  method will set the  Fifth Circle Visible
     */
    public void showCircleFive() {
        CircleFive.setVisible(true);
    }
   /**
     * this showCircleSix() method will set the Sixth Circle Visible
     */
    public void showCircleSix() {
        CircleSix.setVisible(true);
    }
   /**
     * this showCircleSeven()  method will set the  Seventh CircleVisible
     */
    public void showCircleSeven() {
        CircleSeven.setVisible(true);
    }
   /**
     * this showCircleEight() method will set the Eighth Circle Visible
     */
    public void showCircleEight() {
        CircleEight.setVisible(true);
    }
   /**
     * this showCircleNine() method will set the Ninth Circle Visible
     */
    public void showCircleNine() {
        CircleNine.setVisible(true);
    }
/**
 * This handleCircleClick method is responsible for placing a Circle on the
     * gameboard depending on Which Tictace game Cell number is passed into the
     * method and will end the game if player 2(Circles) has won the Tic-tac-toe
     * game or if a tie conditon is met
     * This method Performs the exact same Functionality as handleSqaureClick() except it places Circles(for Player 2) at each gameCell Location instead of Squares
  @param showCircleAtGameCell 
 */
    public void handleCircleClick(int showCircleAtGameCell) {
        if (!IsGameSlotFilled(showCircleAtGameCell) && allowMoves == true) {/*this if statement is checking if the game cell at location being passed in is not already filled in 
            and if the player can still put shapes on the board which is only true if the game has not ended 
            */

            switch (showCircleAtGameCell) {/* if the cell is not filled in already,depending on the game cell location which was passed in,this switch statement will call the showCircle Method 
                Associated with that game cell in order to make a Square visbile in that game cell 
                 */
                case 1:
                    showCircleOne();

                    break;
                case 2:
                    showCircleTwo();

                    break;
                case 3:
                    showCircleThree();

                    break;
                case 4:
                    showCircleFour();

                    break;
                case 5:
                    showCircleFive();

                    break;
                case 6:
                    showCircleSix();

                    break;
                case 7:
                    showCircleSeven();

                    break;
                case 8:
                    showCircleEight();

                    break;
                case 9:
                    showCircleNine();

                    break;
                default:
                    System.out.println("Impossible choice");
                    break;
            }

            System.out.println("Player2/Circle Information");
            System.out.println("This the locoation where player 2 has selected there  circle to be placed in " + showCircleAtGameCell);
            filledGameSlots[filledGameSlotsCounter] = showCircleAtGameCell;//in this line of code I am storing the location of the cell which was filled with a square into the filled game slots array so that it can not be used again 
            System.out.println("filledSlots at postion " + filledGameSlots[filledGameSlotsCounter]);
            filledCircles[filledCircleCounter] = showCircleAtGameCell;;//in this line of code I am updating the filledCircles array with the location of the game cell that I was just filled in with a Circle so that I can keep track of how many cells have Circles
            System.out.println("this keeps track of which slots have a circle so that a square can't be palced there " + filledCircles[filledCircleCounter]);
            filledGameSlotsCounter++;
            System.out.println("this count keeps track of how many slots have already been filled counting from 0 " + filledGameSlotsCounter);
            System.out.println("pre count of squares placed for this turn " + filledCircleCounter);
            filledCircleCounter++;
            System.out.println("post count of sqaures placed for this turn " + filledCircleCounter);
            System.out.println("  ");
            if (checkVictory()) {
                endGame();

            } else if (filledGameSlotsCounter >= 9) {//else if the total number of filled game cell locations for either Sqaures(player1) or circles(player2) is greater than 9 
                //this means that a victory condition was not meet for either player but all of the board slots are still filled in meaning we have a tie 
                System.out.println("this is game Slot counter if a tie conditon is met" + filledGameSlotsCounter);
                tie = true;
                endGame();//then we end the game 

            }
        }

    }

    /**
     * this showSquareOne()  method will set the First Square Visible
     */
    public void showSquareOne() {
        SqaureOne.setVisible(true);

    }
   /**
     * this showSquareTwo()  method will set the Second Square Visible
     */
    public void showSquareTwo() {
        SquareTwo.setVisible(true);
    }
   /**
     * this showSquareThree()  method will set the Thrid Sqaure Visible
     */
    public void showSquareThree() {
        SquareThree.setVisible(true);
    }
   /**
     * this showSquareFour() method will set the fourth Square Visible
     */
    public void showSquareFour() {
        SqaureFour.setVisible(true);
    }
   /**
     * this showSquareFive() method will set the Fifth Square Visible
     */
    public void showSquareFive() {
        SqaureFive.setVisible(true);
    }
   /**
     * this showSqaureSix()  method will set the Sixth SquareVisible
     */
    public void showSqaureSix() {
        SqaureSix.setVisible(true);
    }
   /**
     * this showSquareSeven()   method will set the Seventh Square Visible
     */
    public void showSquareSeven() {
        SquareSeven.setVisible(true);
    }
   /**
     * this showSquareEight() method will set the Eighth Square Visible
     */
    public void showSquareEight() {
        SqaureEight.setVisible(true);
    }
   /**
     * this showSqaureNine() method will set the Ninth Square Visible
     */
    public void showSqaureNine() {
        SqaureNine.setVisible(true);
    }
    
    
    /**
     * this handleResetButton Event handler Method will reset all of the shapes associated with the game cells on board back to be invisible
     * and will reset all of the other game data like current player back to player 1 and allowMoves back to true so that the players can placed shapes onto the baord
     * so that a new game can be played
     * 
     * @param event 
     */

    @FXML
    public void handleResetButton(ActionEvent event) {
        currentplayer = 1;
        CircleOne.setVisible(false);
        CircleTwo.setVisible(false);
        CircleThree.setVisible(false);
        CircleFour.setVisible(false);
        CircleFive.setVisible(false);
        CircleSix.setVisible(false);
        CircleSeven.setVisible(false);
        CircleEight.setVisible(false);
        CircleNine.setVisible(false);

        SqaureOne.setVisible(false);
        SquareTwo.setVisible(false);
        SquareThree.setVisible(false);
        SqaureFour.setVisible(false);
        SqaureFive.setVisible(false);
        SqaureSix.setVisible(false);
        SquareSeven.setVisible(false);
        SqaureEight.setVisible(false);
        SqaureNine.setVisible(false);

        winningTeam = 0;//this resets the winning team variable back to zero for a new game

        allowMoves = true;
        tie = false;

        gameresult.setText("");//this resets the gameresult label back to an empty string for a new game

        filledGameSlots = new int[9];//here we create a new  filledGameSlots array so that a new game can be played
        filledSquares = new int[5];//here we create a new  filledSqaures array so that a new game can be played
        filledCircles = new int[5];//here we create a new  filledCircles arrayso that a new game can be played
        
        //here we reset all of the game data counters back to zero so that we can keep track of the new game 
        filledGameSlotsCounter = 0;
        filledSqauresCounter = 0;
        filledCircleCounter = 0;
    }

    /**
     * this exitApplication method will close the JavaFX tic tac toe Game 
     * @param event 
     */
    @FXML
    private void exitApplication(ActionEvent event) {
        Platform.exit();
    }

}
