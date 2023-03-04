package com.example.backgammon;


import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import java.io.File;
import java.util.Random;
import javafx.scene.paint.Color;
import static java.lang.Math.abs;

public class HelloController extends HelloApplication{

    Random random = new Random();

    @FXML
    private ImageView diceImage1 ;

    @FXML
    private ImageView diceImage2 ;

    @FXML
    private GridPane gridPane ;

    @FXML
    private VBox blackOut;

    @FXML
    private VBox whiteOut;

    @FXML
    private VBox whiteOut2;

    @FXML
    private Text gameOver;

    @FXML
    private Circle id00;
    @FXML
    private Circle id01;
    @FXML
    private Circle id02;
    @FXML
    private Circle id03;
    @FXML
    private Circle id04;
    @FXML
    private Circle id05;
    @FXML
    private Circle id06;
    @FXML
    private Circle id07;
    @FXML
    private Circle id08;
    @FXML
    private Circle id09;
    @FXML
    private Circle id10;
    @FXML
    private Circle id11;
    @FXML
    private Circle id12;
    @FXML
    private Circle id13;
    @FXML
    private Circle id14;
    @FXML
    private Circle id20;
    @FXML
    private Circle id21;
    @FXML
    private Circle id22;
    @FXML
    private Circle id23;
    @FXML
    private Circle id24;
    @FXML
    private Circle id25;
    @FXML
    private Circle id26;
    @FXML
    private Circle id27;
    @FXML
    private Circle id28;
    @FXML
    private Circle id29;
    @FXML
    private Circle id30;
    @FXML
    private Circle id31;
    @FXML
    private Circle id32;
    @FXML
    private Circle id33;
    @FXML
    private Circle id34;
    @FXML
    private VBox v1;
    @FXML
    private VBox v2;
    @FXML
    private VBox v3;
    @FXML
    private VBox v4;
    @FXML
    private VBox v5;
    @FXML
    private VBox v6;
    @FXML
    private VBox v7;
    @FXML
    private VBox v8;



    private VBox vStart;
    private VBox vFinish;

    private int b_out = 0;
    private int w_out = 0;
    private int clickedVBox = -1;
    private Integer row ;
    private Integer column ;
    private int rowStart;
    private int colStart;

    private int enterButton = 0;
    private int die1;
    private int die2;
    private int dieContor = 0;
    private int decisionCounter = 0;
    private int playerCounter = 1; // 1 -> player1;   -1 -> player2
    /*decisionCounter = 0 -> player done with the move so the other player can role dice
                        1 -> the dice is rolled, now we wait for the player to make 1 move
                        2 -> the player makes the other move
      At start player1 will begin and he has white.
    */

    Board board = new Board();
    Player player1 = new Player();   // the player that plays with white
    Player player2 = new Player();   // the player that plays with black
    VirtualMoves vMove = new VirtualMoves();

    public void startNewGame(ActionEvent event){
        gameOver.setText(null);
        board.board = new int[26];
        board.grid = new int[5][26];
        board.initBoard();
        board.matching();
        enterButton = 1;
        decisionCounter = 0;
        playerCounter = 1;
        dieContor = 0;
        for(int i=1; i<=5; i++) {
            if (id00.getParent() != v1)
                movePiece((VBox) id00.getParent(), v1);
            if (id01.getParent() != v1)
                movePiece((VBox) id01.getParent(), v1);
            if (id02.getParent() != v1)
                movePiece((VBox) id02.getParent(), v1);
            if (id03.getParent() != v1)
                movePiece((VBox) id03.getParent(), v1);
            if (id04.getParent() != v1)
                movePiece((VBox) id04.getParent(), v1);
            if (id05.getParent() != v2)

                movePiece((VBox) id05.getParent(), v2);
            if (id06.getParent() != v2)
                movePiece((VBox) id06.getParent(), v2);
            if (id07.getParent() != v2)
                movePiece((VBox) id07.getParent(), v2);

            if (id08.getParent() != v3)
                movePiece((VBox) id08.getParent(), v3);
            if (id09.getParent() != v3)
                movePiece((VBox) id09.getParent(), v3);
            if (id10.getParent() != v3)
                movePiece((VBox) id10.getParent(), v3);
            if (id11.getParent() != v3)
                movePiece((VBox) id11.getParent(), v3);
            if (id12.getParent() != v3)
                movePiece((VBox) id12.getParent(), v3);

            if (id13.getParent() != v4)
                movePiece((VBox) id13.getParent(), v4);
            if (id14.getParent() != v4)
                movePiece((VBox) id14.getParent(), v4);

            if (id20.getParent() != v5)
                movePiece((VBox) id20.getParent(), v5);
            if (id21.getParent() != v5)
                movePiece((VBox) id21.getParent(), v5);
            if (id22.getParent() != v5)
                movePiece((VBox) id22.getParent(), v5);
            if (id23.getParent() != v5)
                movePiece((VBox) id23.getParent(), v5);
            if (id24.getParent() != v5)
                movePiece((VBox) id24.getParent(), v5);

            if (id25.getParent() != v6)
                movePiece((VBox) id25.getParent(), v6);
            if (id26.getParent() != v6)
                movePiece((VBox) id26.getParent(), v6);
            if (id27.getParent() != v6)
                movePiece((VBox) id27.getParent(), v6);

            if (id28.getParent() != v7)
                movePiece((VBox) id28.getParent(), v7);
            if (id29.getParent() != v7)
                movePiece((VBox) id29.getParent(), v7);
            if (id30.getParent() != v7)
                movePiece((VBox) id30.getParent(), v7);
            if (id31.getParent() != v7)
                movePiece((VBox) id31.getParent(), v7);
            if (id32.getParent() != v7)
                movePiece((VBox) id32.getParent(), v7);

            if (id33.getParent() != v8)
                movePiece((VBox) id33.getParent(), v8);
            if (id34.getParent() != v8)
                movePiece((VBox) id34.getParent(), v8);
        }
        int ok = 1;
        while(ok == 1) {
            int c1 = setcolor(v1, -1);
            int c2 = setcolor(v2, 1);
            int c3 =setcolor(v3, 1);
            int c4 =setcolor(v4, -1);
            int c5 =setcolor(v5, 1);
            int c6 =setcolor(v6, -1);
            int c7 =setcolor(v7, -1);
            int c8 =setcolor(v8, 1);
            ok = 0;
            VBox s = new VBox();
            VBox f = new VBox();
            if(c1 > 5) {
                ok = 1;
                s = v1;
            } else if(c1 < 5) {
                ok = 1;
                f = v1;
            }
            if(c2 > 3) {
                ok = 1;
                s = v2;
            } else if(c2 < 3) {
                ok = 1;
                f = v2;
            }
            if(c3 > 5) {
                ok = 1;
                s = v3;
            } else if(c3 < 5) {
                ok = 1;
                f = v3;
            }
            if(c4 > 2) {
                ok = 1;
                s = v4;
            } else if(c4 < 2) {
                ok = 1;
                f = v4;
            }
            if(c5 > 5) {
                ok = 1;
                s = v5;
            } else if(c5 < 5) {
                ok = 1;
                f = v5;
            }
            if(c6 > 3) {
                ok = 1;
                s = v6;
            } else if(c6 < 3) {
                ok = 1;
                f = v6;
            }
            if(c7 > 5) {
                ok = 1;
                s = v7;
            } else if(c7 < 5) {
                ok = 1;
                f = v7;
            }
            if(c8 > 2) {
                ok = 1;
                s = v8;
            } else if(c8 < 2) {
                ok = 1;
                f = v8;
            }
            if(ok == 1)
                movePiece(s, f);
        }
    }

    int setcolor(VBox v, int color){
        int counter = 0;
        if(color == 1){
            for(Node it: v.getChildren()){
                if(it instanceof Circle){
                    counter ++ ;
                    ((Circle) it).setFill(Color.WHITE);
                }
            }
        }
        else{
            for(Node it: v.getChildren()){
                if(it instanceof Circle){
                    counter ++ ;
                    ((Circle) it).setFill(Color.BLACK);
                }
            }
        }
        return counter;
    }

    public void buttonClicked(){
        if(enterButton == 1) {
            if (decisionCounter == 0) {
                for (int i = 0; i < 15; i++) {
                    die1 = random.nextInt(6) + 1;
                    die2 = random.nextInt(6) + 1;
                    File file1 = new File("src/main/resources/com/example/backgammon/DiceRolls/p" + die1 + ".png");
                    File file2 = new File("src/main/resources/com/example/backgammon/DiceRolls/p" + die2 + ".png");
                    diceImage1.setImage(new Image(file1.toURI().toString()));
                    diceImage2.setImage(new Image(file2.toURI().toString()));
                }
            }
            if (decisionCounter == 0 && vMove.impossibleToMove(board.board, die1, die2, playerCounter) && !vMove.canTakeOut(board.board, playerCounter)) {
                dieContor = 0;
                decisionCounter = 0;
                playerCounter = -playerCounter;
            } else
                decisionCounter = 1;
        }
    }

    public void selectVBox(MouseEvent mouseEvent) {
        if (decisionCounter == 1 || decisionCounter == 2) {
            if (vMove.impossibleToMove(board.board, die1, die2, playerCounter) && !vMove.canTakeOut(board.board, playerCounter)){
                decisionCounter = 0;
                dieContor = 0 ;
                playerCounter = -playerCounter;
            } else {
                Player player = null;
                if (playerCounter == 1) player = player1;
                else if (playerCounter == -1) player = player2;
                VBox vTarget = null;
                Node source = (Node) mouseEvent.getSource();
                row = GridPane.getRowIndex(source);
                column = GridPane.getColumnIndex(source);
                if (row == null) {
                    row = 0;
                }
                if (column == null) {
                    column = 0;
                }
                if (checkClickSelection()) {
                    if (mouseEvent.getPickResult().getIntersectedNode() instanceof Circle) {
                        vTarget = (VBox) mouseEvent.getPickResult().getIntersectedNode().getParent();
                    } else if (mouseEvent.getPickResult().getIntersectedNode() instanceof VBox) {
                        vTarget = (VBox) mouseEvent.getPickResult().getIntersectedNode();
                    }
                    if (clickedVBox == -1 && vTarget != null) {
                        rowStart = row;
                        colStart = column;
                        System.out.println("start: " + row + " " + column);
                        vStart = vTarget;
                        clickedVBox = 1;

                    } else if (clickedVBox == 1 && vTarget != null) {
                        System.out.println("end: " + row + " " + column);
                        clickedVBox = -1;
                        vFinish = vTarget;
                        if(vMove.isOut(board.board, playerCounter)){
                            if(die1 == die2 && die1 != 0){
                                int aux = die1;
                                die1 = decideMoveInside(die1, player);
                                if(die1 == 0){
                                    decisionCounter = 1 ;
                                    die1 = aux ;
                                    dieContor ++ ;
                                }
                                if(dieContor == 4){
                                    dieContor = 0;
                                    decisionCounter = 0;
                                    playerCounter = -playerCounter;
                                }
                            }
                            else {
                                die1 = decideMoveInside(die1, player);
                                if(vMove.isOut(board.board, playerCounter)){
                                    die2 = decideMoveInside(die2, player);
                                }
                            }
                        }

                        else {
                            if(vMove.canTakeOut(board.board, playerCounter) && row == rowStart && column == colStart){
                                if(vMove.isAbleToTakePiece(board.board, die1, board.grid[row][column], playerCounter)){
                                    takePieceOut(die1, player);
                                    if(die1 == die2 && die1 != 0)
                                        dieContor++;
                                    else
                                        die1 = 0;
                                }
                                else if(vMove.isAbleToTakePiece(board.board, die2, board.grid[row][column], playerCounter)){
                                    takePieceOut(die2, player);
                                    if(die1 == die2 && die2 != 0)
                                        dieContor ++ ;
                                    else
                                        die2 = 0;
                                }
                                if(dieContor == 4 || (die1 == die2 && die1 == 0)){
                                    dieContor = 0;
                                    decisionCounter = 0;
                                    playerCounter = -playerCounter;
                                    if(b_out == 15 || w_out == 15)
                                        decisionCounter = -100;
                                }
                            }
                            else {
                                if (die1 == die2 && die1 != 0) {
                                    int aux = die1;
                                    die1 = decideMove(die1, player);
                                    if (die1 == 0) {
                                        decisionCounter = 1;
                                        die1 = aux;
                                        dieContor++;
                                    }
                                    if (dieContor == 4) {
                                        dieContor = 0;
                                        decisionCounter = 0;
                                        playerCounter = -playerCounter;
                                    }
                                } else {
                                    die1 = decideMove(die1, player);
                                    die2 = decideMove(die2, player);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void movePiece (VBox start, VBox finish){
        Node target = start.getChildren().get(0);
        finish.getChildren().add(0, target);
    }

    public boolean checkClickSelection () {
        if(vMove.isOut(board.board, playerCounter)){
            if(clickedVBox == -1){
                if(column != 6)
                    return false ;
                if(playerCounter == 1 && row != 0)
                    return false ;
                if(playerCounter == -1 && row != 2)
                    return false ;
            }
            else if(clickedVBox == 1){
                if(column < 7 || column > 12)
                    return false ;
                if(playerCounter == 1 && row != 2)
                    return false ;
                if(playerCounter == -1 && row != 0)
                    return false ;
                if(playerCounter * board.board[board.grid[row][column]] >= 2)
                    return false ;
            }
        }
        else if (clickedVBox == -1) {
            if (board.board[board.grid[row][column]] * playerCounter >= 0)
                return false;
        }
        return true;
    }

    int decideMove(int die, Player player){
        if(playerCounter * (board.grid[row][column] - board.grid[rowStart][colStart] ) == -die && die != 0){
            if(vMove.testMove(board.board, board.grid[rowStart][colStart], die)){
                controlMove(die, player);
                player.makeMove(board.board, board.grid[rowStart][colStart], die) ;
                die = 0;
            }
        }
        return die;
    }

    int decideMoveInside(int die, Player player){
        if((playerCounter == 1 && 24 - board.grid[row][column] == die) || (playerCounter == -1 && board.grid[row][column] + 1 == die))
            if(vMove.testMoveInside(board.board, die, playerCounter)){
                int aux = playerCounter;
                controlMove(die, player);
                player.makeMoveInside(board.board, die, aux);
                die = 0;
            }
        return  die ;
    }

    void controlMove(int die, Player player){
        if(board.board[board.grid[row][column]] == playerCounter){
            Node node;
            if(playerCounter == 1){
                node = getNodeByCoord(2, 6);
                if(node != null);
                movePiece(vFinish, (VBox) node);
            }
            else {
                node = getNodeByCoord(0, 6);
                if(node != null)
                    movePiece(vFinish, (VBox) node);
            }
        }
        movePiece(vStart, vFinish);
        if(decisionCounter == 1)
            decisionCounter ++ ;
        else {
            decisionCounter = 0;
            dieContor = 0;
            playerCounter = -playerCounter;
        }
    }

    Node getNodeByCoord(Integer x, Integer y){
        for(Node node : gridPane.getChildren()) {
            Integer row =GridPane.getRowIndex(node) ;
            Integer column = GridPane.getColumnIndex(node);
            if(row == null)
                row = 0;
            if(x == row && y == column){
                return node;
            }
        }
        return null ;
    }

    void takePieceOut(int die, Player player){
        if(playerCounter == 1){
            if(b_out + w_out < 19)
                movePiece(vStart, whiteOut);
            else
                movePiece(vStart, whiteOut2);
            player.takePieceOut2(board.board, die, playerCounter);
            w_out ++ ;
            if(w_out == 15){
                gameOver.setText("WHITE WINS");
                gameOver.setFill(Color.GREENYELLOW);
                decisionCounter = -100;
            }
        }
        else{
            if(b_out + w_out < 19)
                movePiece(vStart, blackOut);
            else
                movePiece(vStart, whiteOut2);
            player.takePieceOut2(board.board, die, playerCounter);
            b_out ++ ;
            if(b_out == 15){
                gameOver.setText("BLACK WINS");
                gameOver.setFill(Color.GREENYELLOW);
                decisionCounter = -100;
            }
        }
    }

}