import java.util.*;

public class RecursionEx {

    // Q1 Solution ===========================================================================
    public static void q1() {
        int[] A = {25, 38, 97, 41, 69, 46, 70, 31};
        mergeSort(A, 0, A.length - 1);
        for (int num : A) {
            System.out.print(num + " ");
        }
    }
    
    public static void mergeSort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    public static void merge(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = A[p + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = A[q + 1 + j];
        }

        int i = 0, j = 0;
        int k = p;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            A[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            A[k] = R[j];
            j++;
            k++;
        }
    }
    
	// Q2 Solution ===========================================================================
	public static void q2a() {
        String start = "c", mid = "a", end = "r";
        int k = 4;
        System.out.println(genMidString(start, mid, end, k));
    }

    public static void q2b() {
        String s = "Hello World";
        System.out.println(reverseString(s));
    }

    public static void q2c() {
        String s = "The dog is barking";
        System.out.println(reverseWords(s));
    }
    
	public static String genMidString(String start, String mid, String end, int k) {
        if (k == 1) {
            return start + mid + end;
        } else {
            String middleString = genMidString(start, mid, end, k - 1);
            middleString = mid + middleString.substring(1, middleString.length() - 1);
            return start + middleString + end;
        }
    }

    public static String reverseString(String s) {
        if (s.length() == 1) {
            return s;
        } else {
            return s.charAt(s.length() - 1) + reverseString(s.substring(0, s.length() - 1));
        }
    }

    public static String reverseWords(String s) {
        if (!s.contains(" ")) {
            return s;
        } else {
            String[] arr = s.split(" ");
            String newS = String.join(" ", Arrays.copyOfRange(arr, 0, arr.length - 1));
            return arr[arr.length - 1] + " " + reverseWords(newS);
        }
    }

    
	// Q3 Solution ===========================================================================
    public static void q3() {
        int[] A = {88, 88, 34, 56, 11, 56, 34, 87};
        int maxLength = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (isPalindrome(Arrays.copyOfRange(A, i, j))) {
                    maxLength = Math.max(maxLength, j - i);
                }
            }
        }
        System.out.println(maxLength);
    }
    
    public static boolean isPalindrome(int[] A) {
        if (A.length == 1) {
            return true;
        }
        if (A.length == 2) {
            return A[0] == A[1];
        } else {
            return A[0] == A[A.length - 1] && isPalindrome(Arrays.copyOfRange(A, 1, A.length - 1));
        }
    }
    
    
    
    // Q4 Solution ===========================================================================
    public static void q4() {
        char[] T = { '\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0',
                     'O', 'M', 'I', 'R', 'G', 'C', 'L', 'P', 'A', 'N', 'S',
                     '\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0' };
        String code = "0010";
        int i = 0;   // start exploration at node rooted at 0
        System.out.println(decode(T, i, code));
    }
    
    public static char decode(char[] tree, int i, String code) {
        if (code.equals("0")) {
            return tree[2*i + 1];
        } else if (code.equals("1")) {
            return tree[2*i + 2];
        } else {
            if (code.charAt(0) == '0') {
                return decode(tree, 2*i + 1, code.substring(1));
            } else {
                return decode(tree, 2*i + 2, code.substring(1));
            }
        }
    }
    
	
	// Q5 Solution ===========================================================================
	public static void q5() {
        List<Integer> L = Arrays.asList(58, 34, 100, 62, 77, 19, 83);
        System.out.println(recMaxNum(L));
    }
	
	public static int recMaxNum(List<Integer> L) {
        if (L.size() == 1) {
            return L.get(0);
        }

        int mid = L.size() / 2;
        int subL1 = recMaxNum(L.subList(0, mid));
        int subL2 = recMaxNum(L.subList(mid + 1, L.size()));

        return (subL1 > subL2 ? subL1 : subL2);
    }

    
	
	// Q6 Solution ===========================================================================
	public static void q6() {
		int[][] grid = {
                {0, 7, 1, 3},
                {4, 5, 8, 0},
                {9, 3, -6, 0}
        };
        List<List<int[]>> paths = findPaths(grid);
        int maxScore = Integer.MIN_VALUE;
        for (List<int[]> path : paths) {
            int score = computeScore(grid, path);
            maxScore = Math.max(maxScore, score);
        }
        System.out.println(maxScore);
    }
	
	public static void findPathsHelper(int[][] grid, int m, int n, List<int[]> path, int i, int j, List<List<int[]>> paths) {
        if (i == m - 1 && j == n - 1) {
            path.add(new int[]{i, j});
            paths.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == Integer.MIN_VALUE || grid[i][j] == -1) {
            return;
        }

        int temp = grid[i][j];
        grid[i][j] = Integer.MIN_VALUE;
        path.add(new int[]{i, j});

        findPathsHelper(grid, m, n, path, i, j + 1, paths); // Move right
        findPathsHelper(grid, m, n, path, i + 1, j, paths); // Move down
        findPathsHelper(grid, m, n, path, i, j - 1, paths); // Move left
        findPathsHelper(grid, m, n, path, i - 1, j, paths); // Move up

        grid[i][j] = temp;
        path.remove(path.size() - 1);
    }

    public static int computeScore(int[][] grid, List<int[]> path) {
        int score = 0;
        for (int[] p : path) {
            score += grid[p[0]][p[1]];
        }
        return score;
    }
	
	public static List<List<int[]>> findPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<List<int[]>> paths = new ArrayList<>();
        findPathsHelper(grid, m, n, new ArrayList<>(), 0, 0, paths);
        return paths;
    }
	
	
	
	// Q7 Solution ===========================================================================
	public static void q7() {
        List<Object> nestedList = new ArrayList<>();
        nestedList.add(1);
        List<Object> innerList1 = new ArrayList<>();
        innerList1.add(2);
        innerList1.add(3);
        nestedList.add(innerList1);
        List<Object> innerList2 = new ArrayList<>();
        innerList2.add(4);
        List<Object> innerInnerList = new ArrayList<>();
        innerInnerList.add(5);
        innerInnerList.add(6);
        innerList2.add(innerInnerList);
        nestedList.add(innerList2);
        nestedList.add(7);
        
        List<Object> flattenedList = flattenList(nestedList);
        System.out.println(nestedList);
        System.out.println(flattenedList); // Output: [1, 2, 3, 4, 5, 6, 7]
    }
	
	public static List<Object> flattenList(List<Object> nestedList) {
        List<Object> flattenedList = new ArrayList<>();
        for (Object item : nestedList) {
            if (item instanceof List<?>) {
                flattenedList.addAll(flattenList((List<Object>) item));
            } else {
                flattenedList.add(item);
            }
        }
        return flattenedList;
    }
	
	// Q8 Solution ===========================================================================
	public static void q8() {
		Map<String, List<String>> adjList = new HashMap<>();
        adjList.put("A", Arrays.asList("B", "C", "D", "E"));
        adjList.put("B", Arrays.asList("A", "C", "D", "E"));
        adjList.put("C", Arrays.asList("A", "B", "D", "E"));
        adjList.put("D", Arrays.asList("A", "B", "C", "E"));
        adjList.put("E", Arrays.asList("A", "B", "C", "D"));
        adjList.put("F", Arrays.asList("G"));
        adjList.put("G", Arrays.asList("F"));
        adjList.put("H", new ArrayList<>());

        List<String> seeds = new ArrayList<>();
        seeds.add("A");
        Map<String, Boolean> infectedDict = infectionSpread(adjList, seeds);
        System.out.println(infectedDict);
    }

	public static Map<String, Boolean> infectionSpread(Map<String, List<String>> A, List<String> seeds) {
        Map<String, Boolean> infectedDict = new HashMap<>();
        for (String node : A.keySet()) {
            infectedDict.put(node, false);
        }

        infectionHelper(A, seeds, infectedDict);
        return infectedDict;
    }

    private static void infectionHelper(Map<String, List<String>> A, List<String> seeds, Map<String, Boolean> infectedDict) {
        if (seeds.isEmpty()) {
            return;
        }

        List<String> nextSeeds = new ArrayList<>();
        for (String seed : seeds) {
            if (!infectedDict.get(seed)) {
                infectedDict.put(seed, true);
                for (String friend : A.getOrDefault(seed, Collections.emptyList())) {
                    if (!infectedDict.get(friend)) {
                        nextSeeds.add(friend);
                    }
                }
            }
        }

        infectionHelper(A, nextSeeds, infectedDict);
    }
    
    
 // Main Method ===========================================================================
	public static void main(String[] args) {
		q1();
//		q2a();
//		q2b();
//		q2c();
//		q3();
//		q4();
//		q5();
//		q6();
//		q7();
//		q8();
	}

}
