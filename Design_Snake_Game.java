public class SnakeGame {

  private int width;
  private int height;
  private int score;
  private Deque<Integer> snake;
  private Set<Integer> body;
  private int[][] food;

  /** Initialize your data structure here.
   @param width - screen width
   @param height - screen height
   @param food - A list of food positions
   E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
  public SnakeGame(int width, int height, int[][] food) {
    this.width = width;
    this.height = height;
    this.food = food;
    this.score = 0;
    snake = new LinkedList<Integer>();
    snake.addFirst(0);
    body = new HashSet<Integer>();
    body.add(0);
  }

  /** Moves the snake.
   @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
   @return The game's score after the move. Return -1 if game over.
   Game over when snake crosses the screen boundary or bites its body. */
  public int move(String direction) {
    int head = snake.getFirst();
    int tail = snake.removeLast();
    body.remove(tail);
    int nx = head / width;
    int ny = head % width;
    if (direction.equals("L")) {
      ny = ny - 1;
    } else if (direction.equals("R")) {
      ny = ny + 1;
    } else if (direction.equals("U")) {
      nx = nx - 1;
    } else if (direction.equals("D")) {
      nx = nx + 1;
    }
    if (nx < 0 || nx >= height || ny < 0 || ny >= width) {
      return -1;
    }
    int nextHead = nx * width + ny;
    if (body.contains(nextHead)) {
      return -1;
    }
    snake.addFirst(nextHead);
    body.add(nextHead);
    if (score < food.length && nx == food[score][0] && ny == food[score][1]) {
      snake.addLast(tail);
      score++;
    }
    return score;
  }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
