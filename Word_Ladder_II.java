

// TLE on the large test ... T_T
public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict) {
		// Start typing your Java solution below
		// DO NOT write main() function
		HashSet<String> visited = new HashSet<String>();
		visited.add(start);
		ArrayList<String> path = new ArrayList<String>();
		path.add(start);
		ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
		dfs(dict, visited, path, ans, start, end);
		int max = Integer.MAX_VALUE;
		ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < ans.size(); ++i) {
			if (ans.get(i).size() < max) {
				max = ans.get(i).size();
				ret.clear();
				ret.add(ans.get(i));
			} else if (ans.get(i).size() == max) {
				ret.add(ans.get(i));
			}
		}
		return ret;
	}

	public void dfs(HashSet<String> dict, HashSet<String> visited,
			ArrayList<String> path, ArrayList<ArrayList<String>> ans,
			String cur, String end) {
		if (cur.equals(end)) {
			ArrayList<String> newpath = new ArrayList<String>(path);
			ans.add(newpath);
			return;
		}
		StringBuilder sb = null;
		for (int i = 0; i < cur.length(); ++i) {
			for (int j = 0; j < 26; ++j) {
				char ch = (char) ('a' + j);
				sb = new StringBuilder(cur);
				sb.setCharAt(i, ch);
				String candidate = sb.toString();
				if (candidate.equals(end)) {
					path.add(end);
					ArrayList<String> newpath = new ArrayList<String>(path);
					ans.add(newpath);
					path.remove(end);
					return;
				}
				if (dict.contains(candidate)) {
					if (visited.contains(candidate))
						continue;
					path.add(candidate);
					visited.add(candidate);
					dfs(dict, visited, path, ans, candidate, end);
					path.remove(path.size() - 1);
					visited.remove(candidate);
				}
			}
		}
	}
}
