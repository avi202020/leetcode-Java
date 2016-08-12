public class WordDistance {

  private Map<String, List<Integer>> positions;

  public WordDistance(String[] words) {
    positions = new HashMap<String, List<Integer>>();
    for (int i = 0; i < words.length; ++i) {
      if (!positions.containsKey(words[i])) {
        positions.put(words[i], new ArrayList<Integer>());
      }
      positions.get(words[i]).add(i);
    }
  }

  public int shortest(String word1, String word2) {
    List<Integer> position1 = positions.get(word1);
    List<Integer> position2 = positions.get(word2);
    int min = Integer.MAX_VALUE;
    int p1 = 0;
    int p2 = 0;
    while (p1 < position1.size() && p2 < position2.size()) {
      int distance = Math.abs(position1.get(p1) - position2.get(p2));
      min = Math.min(min, distance);
      if (position1.get(p1) <= position2.get(p2)) {
        p1++;
      } else {
        p2++;
      }
    }
    return min;
  }
}
// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
