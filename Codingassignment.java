public class MyClass {
     public static boolean CrossingChakra(int[] enemyPowers, int p, int a, int b) {
        int n = enemyPowers.length;
        int currentPower = p;
        int enemyIndex = 0;

        for (int circle = 1; circle <= n; circle++) {
            if (currentPower < enemyPowers[enemyIndex]) {
               
                if (a <= 0) {
                    return false;
                } else {
                    a--;
                    continue;
                }
            }

            currentPower -= enemyPowers[enemyIndex];

            if (enemyIndex == 2 || enemyIndex == 6) {
                enemyPowers[enemyIndex] /= 2;
                if (currentPower < enemyPowers[enemyIndex]) {
                    if (a <= 0) {
                        return false;
                    } else {
                        a--;
                        continue;
                    }
                }
                currentPower -= enemyPowers[enemyIndex];
            }
            if (b > 0) {
                currentPower += enemyPowers[enemyIndex];
                b--;
            }
            enemyIndex = (enemyIndex + 1) % n;
        }
        return true;
    }

    public static void main(String args[]) {
        //TestCase1
        int[] enemyPowers = { 15, 34, 6, 8, 3, 9, 10, 14, 17, 19, 24 };
        int p = 50;
        int a = 2;
        int b = 2;
        //TestCase2
        int[] enemyPowers2 = { 35, 12, 15, 8, 16, 19, 14, 11, 13, 22, 10 };
        int p2 = 50;
        int a2 = 5;
        int b2 = 5;
        boolean canCross = CrossingChakra(enemyPowers, p, a, b);
        boolean canCross2 = CrossingChakra(enemyPowers2, p2, a2, b2);
        System.out.println("Abhimanyu can cross the Chakravyuha: " + canCross);
        System.out.println("Abhimanyu can cross the Chakravyuha: " + canCross2);
    }
}