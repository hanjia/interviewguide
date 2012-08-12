/**
 * User: haozhou
 * Date: 8/11/12
 * Time: 12:03 PM
 */
public class Test {

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5, 8, 11};

        System.out.println(ArraySum.sum(a, a.length));
        System.out.println(ArrayFindOccurMoreThanHalf.find(new int[]{2, 3, 3, 3, 2, 2, 2, 2}));
        System.out.println(ArrayFindMinAbs.findMinAbs(new int[]{1, 5, 7, 11, 23, 9, 30}, 7));

        ArrayFindCommonElements.findCommon(new int[]{1, 2, 4, 6, 8, 11}, new int[]{2, 3, 6, 8, 9});

        System.out.println(ArrayFindElementOccurOdd.find(new int[]{1, 1, 2, 2, 2, 2, 3, 4, 4, 4, 4}));
        ArrayFindFixedSum.findInTwoArray(new int[]{1, 3, 5, 6, 7}, new int[]{2, 4, 9, 11, 12}, 14);
        ArrayFindFixedSum.findThreeTupleSumEqFixedNum(new int[]{5, 1, 23, 4, 6, 8, 11, 34, 2, 9}, 37);
        System.out.println("Max sum  is " + ArrayFindMaxSub.findMaxSum(new int[]{1, 2, -5, 6, 8}));
        System.out.println("Max multiply is " + ArrayFindMaxSub.findMaxMultiply(new int[]{1, 2, -8, 12, 7}));

        ArrayRotate.rotate(a, 2);
        printArray(a);

        printArray(ArrayMerge.merge(new int[]{1, 2, 4, 5}, new int[]{1, 3, 5, 8, 11, 15}));
        printArray(ArraySort.zeroFirst(new int[]{2, 0, 3, 0, 1, 0, 0, 4}));
        printArray(ArraySort.oddLeftEvenRight(new int[]{1, 6, 2, 4, 3, 11, 56, 7, 9, 12, 46}));

        System.out.println(ArrayFindElement.findMinAbsElement(new int[]{-5, -3, -1, 2,3,4, 8}));

        //-5, -3, -1, 2, 3, 4, 8
        System.out.println(ArrayFindElement.findKSmallestElement(new int[]{8, -3, 4, 2, -1, 3, -5},4));

        System.out.println(StringRelated.reverseString("Apple".toCharArray()));
        System.out.println(StringRelated.isCharAllUnique("Apple"));
        System.out.println(StringRelated.isCharAllUnique("Aple"));

        System.out.println(StringRelated.reverseSentence("This is a sentence".toCharArray()));
    }

    public static void printArray(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
