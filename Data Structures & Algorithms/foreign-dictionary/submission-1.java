class Solution {
    public String foreignDictionary(String[] words) {
      List<Integer>[] adj = new ArrayList[26];
      for(int i = 0; i < 26; i++) {
        adj[i] = new ArrayList<>();
      }

      boolean[] seen = new boolean[26];
      for(String s : words) {
        for(char c : s.toCharArray()) {
            int i = c - 'a';
            if(!seen[i]) {
                seen[i] = true;
            }
        }
      }
      
      int[] indegree = new int[26];
      for(int i = 1; i < words.length; i++) {
        String s1 = words[i - 1];
        String s2 = words[i];

        if(s1.length() > s2.length() && s1.startsWith(s2)) {
            return "";
        }

        for(int j = 0; j < Math.min(s1.length(), s2.length()); j++) {
            if(s1.charAt(j) != s2.charAt(j)) {
                adj[s1.charAt(j) - 'a'].add(s2.charAt(j) - 'a');
                indegree[s2.charAt(j) - 'a']++;
                break;
            }
        }
      }
      
      Queue<Integer> q = new LinkedList();
      for(int i = 0; i < 26; i++) {
        if(seen[i] && indegree[i] == 0) {
            q.add(i);
        }
      }

      StringBuilder sb = new StringBuilder();
      while(q.size() > 0) {
        int curr = q.remove();
        sb.append((char)(curr + 'a'));
        for(int neighbour : adj[curr]) {
            if(--indegree[neighbour] == 0) {
                q.add(neighbour);
            }
        }
      }

      for(int i = 0; i < 26; i++) {
        if(seen[i] && indegree[i] > 0) {
            return "";
        }
      }

      return sb.toString();
    }
}
