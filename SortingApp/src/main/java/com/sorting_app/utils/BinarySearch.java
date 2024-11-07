package com.sorting_app.utils;

import java.util.List;

public final class BinarySearch {

    private BinarySearch(){
        throw new RuntimeException();
    }

    public static <T extends Comparable<T>> int binarySearch(List<T> list, T key) {
        MergeSort.mergeSort(list);
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = list.get(mid).compareTo(key);

            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}