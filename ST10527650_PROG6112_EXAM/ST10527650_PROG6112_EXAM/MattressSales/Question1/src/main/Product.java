package main;

public class Product implements IProduct {
    private String[] names;
    private int[][] sales;

    public Product(String[] names, int[][] sales) {
        this.names = names;
        this.sales = sales;
    }

    public int GetTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                total += sales[i][j];
            }
        }
        return total;
    }

    public double GetAverageProductSold() {
        int count = 0;
        for (int i = 0; i < sales.length; i++) {
            count += sales[i].length;
        }
        if (count == 0) {
            return 0;
        }
        return (double) GetTotalProductsSold() / count;
    }

    public int GetProductTotal(int index) {
        int total = 0;
        for (int j = 0; j < sales[index].length; j++) {
            total += sales[index][j];
        }
        return total;
    }

    public int GetMostPopularTotal() {
        int best = 0;
        for (int i = 1; i < sales.length; i++) {
            if (GetProductTotal(i) > GetProductTotal(best)) {
                best = i;
            }
        }
        return GetProductTotal(best);
    }

    public String GetMostPopularProduct() {
        int best = 0;
        for (int i = 1; i < sales.length; i++) {
            if (GetProductTotal(i) > GetProductTotal(best)) {
                best = i;
            }
        }
        return names[best];
    }
}
