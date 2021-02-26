package ood.snakeladder.service;

import ood.snakeladder.model.Ladder;
import ood.snakeladder.model.Player;
import ood.snakeladder.model.Snake;
import ood.snakeladder.model.SnakeAndLadderBoard;

import java.util.*;

public class SnakeAndLadderService {
    private SnakeAndLadderBoard snakeAndLadderBoard;
    private int initialNumberOfPlayers;
    private Queue<Player> players;
    private boolean isGameCompleted;
    private static final int DEFAULT_BOARD_SIZE = 100; //The board will have 100 cells numbered from 1 to 100.
    private static final int DEFAULT_NO_OF_DICES = 1;
    private int noOfDices; //Optional Rule 1

    public SnakeAndLadderService(int boardSize) {
        this.snakeAndLadderBoard = new SnakeAndLadderBoard(boardSize);  //Optional Rule 2
        this.players = new LinkedList<Player>();
        this.noOfDices = SnakeAndLadderService.DEFAULT_NO_OF_DICES;
    }


    public void startGame() {
        while (!isGameCompleted()) {
            int totalDiceValue = getTotalValueAfterDiceRolls(); // Each player rolls the dice when their turn comes.
            Player currentPlayer = players.poll();
            movePlayer(currentPlayer, totalDiceValue);
            if (hasPlayerWon(currentPlayer)) {
                System.out.println(currentPlayer.getName() + " wins the game");
                snakeAndLadderBoard.getPlayerPieces().remove(currentPlayer.getId());
            } else {
                players.add(currentPlayer);
            }
        }

    }

    private boolean hasPlayerWon(Player currentPlayer) {
        int playerPosition = snakeAndLadderBoard.getPlayerPieces().get(currentPlayer.getId());
        int winningPosition = snakeAndLadderBoard.getSize();
        return playerPosition == winningPosition; // A player wins if it exactly reaches the position 100 and the game ends there.
    }

    private void movePlayer(Player player, int steps) {
        int oldPosition = snakeAndLadderBoard.getPlayerPieces().get(player.getId());
        int newPosition = oldPosition + steps; // Based on the dice value, the player moves their piece forward that number of cells.

        int boardSize = snakeAndLadderBoard.getSize();

        // Can modify this logic to handle side case when there are multiple dices (Optional requirements)
        if (newPosition > boardSize) {
            newPosition = oldPosition; // After the dice roll, if a piece is supposed to move outside position 100, it does not move.
        } else {
            newPosition = getNewPositionAfterGoingThroughSnakesAndLadders(newPosition);
        }

        snakeAndLadderBoard.getPlayerPieces().put(player.getId(), newPosition);

        System.out.println(player.getName() + " rolled a " + steps + " and moved from " + oldPosition +" to " + newPosition);
    }

    private int getNewPositionAfterGoingThroughSnakesAndLadders(int newPosition) {
        int previousPosition;

        do {
            previousPosition = newPosition;
            for (Snake snake : snakeAndLadderBoard.getSnakes()) {
                if (snake.getStart() == newPosition) {
                    newPosition = snake.getEnd(); // Whenever a piece ends up at a position with the head of the snake, the piece should go down to the position of the tail of that snake.
                }
            }

            for (Ladder ladder : snakeAndLadderBoard.getLadders()) {
                if (ladder.getStart() == newPosition) {
                    newPosition = ladder.getEnd(); // Whenever a piece ends up at a position with the start of the ladder, the piece should go up to the position of the end of that ladder.
                }
            }
        } while (newPosition != previousPosition); // There could be another snake/ladder at the tail of the snake or the end position of the ladder and the piece should go up/down accordingly.
        return newPosition;
    }

    private int getTotalValueAfterDiceRolls() {
        return DiceService.roll();
    }

    private boolean isGameCompleted() {
        int currentNumberOfPlayers = players.size();
        return currentNumberOfPlayers < initialNumberOfPlayers;
    }


    public void setPlayers(List<Player> players) {
        this.players = new LinkedList<>();
        this.initialNumberOfPlayers = players.size();
        Map<String, Integer> playerPieces = new HashMap<>();
        for (Player player : players) {
            this.players.add(player);
            playerPieces.put(player.getId(), 0); //Each player has a piece which is initially kept outside the board (i.e., at position 0).
        }
        snakeAndLadderBoard.setPlayerPieces(playerPieces); //  Add pieces to board
    }
    public void setSnakes(List<Snake> snakes) {
        snakeAndLadderBoard.setSnakes(snakes); // Add snakes to board
    }

    public void setLadders(List<Ladder> ladders) {
        snakeAndLadderBoard.setLadders(ladders); // Add ladders to board
    }

    public void setNoOfDices(int noOfDices) {
        this.noOfDices = noOfDices;
    }
}
