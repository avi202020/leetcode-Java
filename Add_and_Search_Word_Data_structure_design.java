ipublic class WordDictionary {

  TrieTree tree;
  public WordDictionary() {
    tree = new TrieTree();
  }

  // Adds a word into the data structure.
  public void addWord(String word) {
    tree.insert(word);
  }

  // Returns if the word is in the data structure. A word could
  // contain the dot character '.' to represent any one letter.
  public boolean search(String word) {
    return tree.search(word);
  }

  public static void main(String[] argc) {
    WordDictionary wd = new WordDictionary();
    wd.addWord("bad");
    wd.addWord("dad");
    wd.addWord("mad");
    System.out.println(wd.search("pad")); // false
    System.out.println(wd.search("bad")); // true
    System.out.println(wd.search(".ad")); // true
    System.out.println(wd.search("b..")); // true
  }
}

class TrieTreeNode {
  // Initialize your data structure here.
  char val;
  boolean isKey;
  TrieTreeNode[] children;

  public TrieTreeNode() {
    children = new TrieTreeNode[26];
  }

  public TrieTreeNode(char ch) {
    this.val = ch;
    children = new TrieTreeNode[26];
  }
}

class TrieTree {
  private TrieTreeNode root;

  public TrieTree() {
    root = new TrieTreeNode();
  }

  // Inserts a word into the trie.
  public void insert(String word) {
    TrieTreeNode node = root;
    for (int i = 0; i < word.length(); ++i) {
      char cur = word.charAt(i);
      if (node.children[cur - 'a'] == null) {
        TrieTreeNode child = new TrieTreeNode(cur);
        node.children[cur - 'a'] = child;
      }
      node = node.children[cur - 'a'];
    }
    node.isKey = true;
  }

  // Returns if the word is in the trie.
  public boolean search(String word) {
    return searchHelper(word, root, 0);
  }

  private boolean searchHelper(String word, TrieTreeNode node, int depth) {
    if (node == null) {
      return false;
    }
    if (depth == word.length()) {
      return node.isKey;
    }

    if (word.charAt(depth) == '.') {
      boolean res = false;
      for (int i = 0; i < node.children.length; ++i) {
        boolean tmp = searchHelper(word, node.children[i], depth + 1);
        res = res || tmp;
      }
      return res;
    } else {
      TrieTreeNode child = node.children[word.charAt(depth) - 'a'];
      if (child == null) {
        return false;
      }
      return searchHelper(word, child, depth + 1);
    }
  }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
