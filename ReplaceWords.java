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

    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();
        for (String s : dictionary) {
            insert(s);
        }

        StringBuilder result = new StringBuilder();
        String[] str = sentence.split(" ");
        for (int i = 0; i < str.length; i++) {
            String word = str[i];
             if (i != 0) {
                    result.append(" ");
                }
            StringBuilder replc = new StringBuilder();
            TrieNode curr = root;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
               
                if(curr.children[c-'a']==null|| curr.isEnd) break;
                curr = curr.children[c-'a'];
                replc.append(c);


            } 
            if(curr.isEnd){
                result.append(replc);
            }else{
                result.append(word);
            }
            

        }
        return result.toString();

    }
}