class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            if (pile > high) {
                high = pile;
            }
        }
        while (low < high) {
            int speed = low + (high - low) / 2;
            long totalHours = 0;
            for (int pile : piles) {
                totalHours += (pile + speed - 1) / speed;
            }
            if (totalHours <= h) {
                high = speed; 
            } else {
                low = speed + 1; 
            }
        }
        return low;
    }
}