package search;

public class BinarySearch {

    // Prec: s[n]: for all (i, j): 0 <= i < j < n && s[i] <= s[j]
    // Post: Res = min(i: s[i] <= x && 0 <= i <= n - 1)
    
    public static int binarySearchIterative(final int[] s, final int x) {
        // s[n]: for all (i, j): 0 <= i < j < n && s[i] >= s[j]
        final int n = s.length;
        int l = -1;
        int r = n;
        // n >= 0 <===> -1 = l < r = n
        // l < r
        while (l + 1 < r) {
            // l + 1 < r  <===> l + 2 <= r
            int m = (r + l) / 2;
            // {*} -1 <= l < m < r <= n && m = (r + l) // 2 
            //      ===> m is always a valid array index

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
            
            if (s[m] <= x) {
                // {*} && s[m] <= x
                // x >= s[m] = max(s[m : n - 1])
                r = m;
                // {*} && l < m = r
                // s[r] = max(s[r : n - 1])
            } else {
                // {*} && s[m] > x
                // x < s[m] < min(s[0 : m - 1])
                l = m; 
                // {*} && l = m < r
                // s[l] = min(s[0 : l])
            }
            // (-1 <= l < r <= n) && (x < s[l] = min(s[0 : l])) && (x >= s[r] = max(s[r : n - 1]))
            // Cycle isn't infinite due to the fact that on each iteration we move either l or r closer to each other (from {*})
        }
        // r = l + 1 && r > l
        // r = min(i: s[i] <= x && 0 <= i <= n - 1)
        return r;
    }
    

    // Prec: s[n]: for all (i, j): 0 <= i < j < n && s[i] >= s[j]
    // Post: Res = min(i: s[i] <= x && 0 <= i <= n - 1)

    public static int binarySearchRecursive(final int[] s, final int x) {
        // s[n]: for all (i, j): 0 <= i < j < n && s[i] >= s[j]
        return binarySearchRecursive(s, x, -1, s.length);
    }


    // Prec: s[n]: for all (i, j): l < i < j < r && s[i] >= s[j]
    // -1 <= l < r <= n
    // Post: Res = min(i: s[i] <= x && l < i < r)

    public static int binarySearchRecursive(final int[] s, final int x, final int l, final int r) {
        // s[n]: for all (i, j): 0 <= i < j < n && s[i] >= s[j]
        if (r == l + 1) {
            return r;
            // s[r] > s[l]
        }
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
        if (s[m] <= x) {
            // s[n]: for all (i, j): l < i < j < r && s[i] >= s[j]
            // -1 < l < r <= n
            return binarySearchRecursive(s, x, m, r);
            // Res = min(i: s[i] <= x && l < i < m)
        } else {
            // s[n]: for all (i, j): l < i < j < r && s[i] >= s[j]
            // -1 <= l < r <= n
            return binarySearchRecursive(s, x, l, m);
            // Res = min(i: s[i] <= x && m < i < r)
        }
    }

    public static void main(String[] args) {
        // {+}
        // Prec: args[n] 
        // n > 0
        // args != null && for all (0 <= i <= n): args[i] != null
        // args[i] is integer for all 0 <= i <= n
        // args[i] >= args[j] for all (1 <= i < j <= n)
        final int n = args.length - 1;
        final int x = Integer.parseInt(args[0]);
        int[] s = new int[n];

        // {+}
        for (int i = 1; i <= n; i++) {
            // args[i] is integer, not-null args[i] exists
            // 1 <= i <= n
            s[i - 1] = Integer.parseInt(args[i]);
        }

        // s[n]: for all (i, j): 0 <= i < j < n && s[i] >= s[j]
        // :NOTE: only one method is tested
        System.out.println(binarySearchIterative(s, x));
        // Post: Res = min(i: s[i] <= x && 0 <= i <= n - 1)
    }
}