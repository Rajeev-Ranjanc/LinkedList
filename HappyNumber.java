//https://leetcode.com/problems/happy-number/
/*
    Asked in google its marked easy still in google because we can not guess that here fast and slow pointer
    concept of linked list will be used none can guess once you know it is easy problem then it is easy
    we have to apply the slow and fast pointer logic which is not understandable by just seeing the question
 */
public class HappyNumber {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappy(n));
    }

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findsquare(slow);
            fast = findsquare(findsquare(fast));
        } while (slow != fast);

        return slow == 1;
    }

    public static int findsquare(int n) {
        int ans = 0;
        while (n > 0) {
            int rem = n % 10;
            ans += rem * rem;
            n /= 10;
        }
        return ans;
    }
}
