package com.example.Greedy;

import java.util.Arrays;

public class 부분배낭문제 {
    private static class Item {
        int value, weight;
        double valuePerWeight;
        public Item(int value, int weight, double valuePerWeight) {
            this.value = value;
            this.weight = weight;
            this.valuePerWeight = valuePerWeight;
        }
    }

    private static double solution(int[][] items, int weight_limit) {
        Item[] item = new Item[items.length];
        for (int i = 0; i < items.length; i++) {
            item[i] = new Item(items[i][0], items[i][0],(double)items[i][1] / items[i][0]);
        }

        // 단위 무게당 가치가 높은 순으로 물건을 정렬
        Arrays.sort(item, (o1, o2) -> Double.compare(o2.valuePerWeight, o1.valuePerWeight));

        double totalValue = 0;
        int remainingWeight = weight_limit;

        for (Item i : item) {
            if (i.weight <= remainingWeight) {
                totalValue += i.value;
                remainingWeight -= i.weight;
            }
            else {
                double fraction = (double) remainingWeight / i.weight;
                totalValue += i.value * fraction;
                break;
            }
        }
        return totalValue;
    }
}
