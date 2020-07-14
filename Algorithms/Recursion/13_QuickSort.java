// https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2870/
/*
given a list of values to sort, the quick sort algorithm works in the following steps:

First, it selects a value from the list, which serves as a pivot value to divide the list into two sublists. One sublist contains all the values that are less than the pivot value, while the other sublist contains the values that are greater than or equal to the pivot value. This process is also called partitioning. The strategy of choosing a pivot value can vary. Typically, one can choose the first element in the list as the pivot, or randomly pick an element from the list.

After the partitioning process, the original list is then reduced into two smaller sublists. We then recursively sort the two sublists.

After the partitioning process, we are sure that all elements in one sublist are less or equal than any element in another sublist. Therefore, we can simply concatenate the two sorted sublists that we obtain in step [2] to obtain the final sorted list. 
The base cases of the recursion in step [2] are either when the input list is empty or the empty list contains only a single element. In either case, the input list can be considered as sorted already.
*/

// QUICK SORT
// TC : O(nlogn)

public class Solution {

  public void quickSort(int [] lst) {
   /* Sorts an array in the ascending order in O(n log n) time */
    int n = lst.length;
    qSort(lst, 0, n - 1);
  }

  private void qSort(int [] lst, int lo, int hi) {
    if (lo < hi) {
      int p = partition(lst, lo, hi);
      qSort(lst, lo, p - 1);
      qSort(lst, p + 1, hi);
    }
  }

  private int partition(int [] lst, int lo, int hi) {
    /*
      Picks the last element hi as a pivot
      and returns the index of pivot value in the sorted array */
    int pivot = lst[hi];
    int i = lo;
    for (int j = lo; j < hi; ++j) {
      if (lst[j] < pivot) {
        int tmp = lst[i];
        lst[i] = lst[j];
        lst[j] = tmp;
        i++;
      }
    }
    int tmp = lst[i];
    lst[i] = lst[hi];
    lst[hi] = tmp;
    return i;
  }

}
