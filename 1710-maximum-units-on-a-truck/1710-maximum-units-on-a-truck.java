
import java.util.*;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        // Sort in descending order of units per box
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int totalUnits = 0;

        for (int[] box : boxTypes) {

            int boxUsed = Math.min(truckSize, box[0]);

            totalUnits += boxUsed * box[1];

            truckSize -= boxUsed;

            if (truckSize == 0) {
                break;
            }
        }

        return totalUnits;
    }
}
