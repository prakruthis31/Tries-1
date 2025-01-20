class Solution {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    private TrieNode root;
    String result;

    public String longestWord(String[] words) {

        this.root = new TrieNode();
        for (String w : words) {
            insert(w);
        }

        this.result = "";
        // once all the words are inserted, do dfs to search the longest word
        dfs(root, new StringBuilder());
        return result;

    }

    public void dfs(TrieNode curr, StringBuilder path) {
        // base case
        if (result.length() < path.length()) {
            result = path.toString();
        }

        // logic
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null && curr.children[i].isEnd) { // isWord=True
                int length = path.length();
                // action
                path.append((char) (i + 'a'));
                // recurse
                dfs(curr.children[i], path);
                // backtrack
                path.setLength(length);
            }
        }
    }
}