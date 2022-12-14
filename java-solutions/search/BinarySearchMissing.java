package search;

public class BinarySearchMissing {
    
    // Prec: s[n]: for all (i, j): 0 <= i < j < n && s[i] <= s[j]
    // Post: if exists such i that: s[i] == x then Res = min(i: s[i] == x && 0 <= i <= n - 1) 
    // else Res = -min(i: s[i] > x) - 1

    public static int binarySearchIterative(final int[] s, final int x) {
        // s[n]: for all (i, j): 0 <= i < j < n && s[i] >= s[j]
        final int n = s.length;
        int l = -1;
        int r = n;
        // n >= 0 <===> -1 = l < r = n
        while (l + 1 < r) {
            // l + 1 < r  <===> l + 2 <= r
            int m = (r + l) / 2;
            // {*} -1 <= l < m < r <= n && m = (r + l) // 2 
            //   ===> m is always a valid array index

            /*  {*} Proof: 
                1. n = (n + n) // 2
                2. n >= r > l  ->  n + n > r + r - 1 > r + l
                3. n = (n + n) // 2 > (r + l) // 2 = m
                #    m < n

                1. r = (r + r) // 2
                2. (r + r) // 2 > (r + r - 2) // 2 >= (r + l) // 2 = m
                #    m < r

                1. l = (l + l) // 2
                2. (l + l) // 2 < (l + l + 2) // 2 <= (l + r) // 2 = m
                #    l < m
            */
            
            if (s[m] < x) {
                // {*} && s[m] < x
                // x > s[m] = max(s[0 : m])
                l = m; 
                // {*} && l = m < r
                // s[l] < min(s[l + 1 : n - 1])
            } else {
                // {*} && s[m] >= x
                // x <= s[m] == min(s[m : n - 1])
                r = m;
                // {*} && l < m = r
                // s[r] > max(s[0 : r - 1])
            }
            // (-1 <= l < r <= n) && (x > s[l] = max(s[0 : l])) && (x < s[r] = min(s[r : n - 1]))
            // Cycle isn't infinite due to the fact that on each iteration we move either l or r closer to each other (from {*})
        }
        // r = l + 1 && r > l

        // r = min(i: i <= 0 <= n - 1 && s[i] == x) || 
        // i: s' = s where x is inserted on pos i && 
        // for all (i, j): i <= j -> s[i] <= s[j]

        if (r < n && s[r] == x) {
            // r == l + 1 && r >= 0 && r < s.length && s[r] == x
            return r;
        } else {
            // r == -1 || r == s.length || s[r] > x
            return -r - 1;
        }
        // if exists such i that: s[i] == x then Res = min(i: s[i] == x && 0 <= i <= n - 1) 
        // else Res = -min(i: s[i] > x) - 1
    }
    
    // Prec: s[n]: for all (i, j): 0 <= i < j < n && s[i] <= s[j]
    // Post: if exists such i that: s[i] = x then Res = min(i: s[i] == x && 0 <= i <= n - 1) 
    // else Res = -min(i: s[i] > x) - 1
    
    public static int binarySearchRecursive(final int[] s, final int x) {
        // Prec: s[n]: for all (i, j): 0 <= i < j < n && s[i] <= s[j]
        return binarySearchRecursive(s, x, -1, s.length);
    }


    // Prec: s[n]: for all (i, j): 0 <= i < j < n && s[i] <= s[j] && l < r
    // Post: if exists such i that: s[i] = x then Res = min(i: s[i] == x && 0 <= i <= n - 1) 
    // else Res = -min(i: s[i] > x) - 1
    
    public static int binarySearchRecursive(final int[] s, final int x, final int l, final int r) {
        // Prec: s[n]: for all (i, j): 0 <= i < j < n && s[i] <= s[j] && l < r
        if (r == l + 1) {
            if (r >= 0 && r < s.length && s[r] == x) {
                // r == l + 1 && r >= 0 && r < s.length && s[r] == x
                return r;
            } else {
                // r == -1 || r == s.length || s[r] > x
                return -r - 1;
            }
            // if exists such i that: s[i] == x then Res = min(i: s[i] == x && 0 <= i <= n - 1) 
            // else Res = -min(i: s[i] > x) - 1
        } 
        // r >= l + 2
        final int m = (l + r) / 2;
        /*  {*} Proof: 
            1. n = (n + n) // 2
            2. n >= r > l  ->  n + n > r + r - 1 > r + l
            3. n = (n + n) // 2 > (r + l) // 2 = m
            #    m < n
    
            1. r = (r + r) // 2
            2. (r + r) // 2 > (r + r - 2) // 2 >= (r + l) // 2 = m
            #    m < r
    
            1. l = (l + l) // 2
            2. (l + l) // 2 < (l + l + 2) // 2 <= (l + r) // 2 = m
            #    l < m
        */
        if (s[m] < x) {
            // l' = m
            // {*} && s[m] < x
            // x > s[m] = max(s[0 : m])
            return binarySearchRecursive(s, x, m, r);
            // {*} && l' = m < r
            // s[l'] < min(s[l' + 1 : n - 1])
        } else {
            // r' = m
            // {*} && s[m] >= x
            // x <= s[m] == min(s[m : n - 1])
            return binarySearchRecursive(s, x, l, m);
            // {*} && l < m = r'
            // s[r'] > max(s[0 : r' - 1])
        }
    }

    public static void main(String[] args) {
        // {+}
        //      Prec: args[n] 
        //      args != null && for all (0 <= i <= n): args[i] != null
        //      args[i] >= args[j] for all (1 <= i < j <= n) 
        //      args[i] is integer for all 0 <= i <= n
        //      n >= 0
        final int n = args.length - 1;
        final int x = Integer.parseInt(args[0]);
        int[] s = new int[n];

        // {+}
        for (int i = 1; i <= n; i++) {
            // args[i] is integer, not-null args[i] exists
            // 1 <= i <= n
            s[i - 1] = Integer.parseInt(args[i]);
        }

        // s[n]: for all (i, j): 0 <= i < j < n && s[i] <= s[j]
        System.out.println(binarySearchRecursive(s, x));
        // if exists such i that: s[i] == x then Res = min(i: s[i] == x && 0 <= i <= n - 1) 
        // else Res = -min(i: s[i] > x) - 1
    }
}