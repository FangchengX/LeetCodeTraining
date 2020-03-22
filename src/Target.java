/**
 * @author fangcheng
 * @since 2020-03-22 10:33
 */
public class Target {
    public static int[] createTargetArray(int[] nums, int[] index) {
        int length = nums.length;
        int[] target = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > index[i]; j--) {
                target[j] = target[j - 1];
            }
            target[index[i]] = nums[i];
        }
        return target;
    }

    public static int getResult(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result += getSums(num);
        }
        return result;
    }

    public static int getSums(int num) {
        int left = 2;
        int right = (int) Math.sqrt(num) + 1;
        int first = 0;
        int sum = num + 1;
        for (int i = left; i < right; i++) {
            if (num % i == 0) {
                if (num / i == i) {
                    return 0;
                }
                if (first == 0) {
                    sum += i;
                    sum += num / i;
                    first = i;
                } else {
                    return 0;
                }
            }
        }
        if (first == 0) {
            return 0;
        } else {
            return sum;
        }
    }

    public static boolean hasValidPath(int[][] grid) {
        int first = grid[0][0];
        if (first == 5) return false;
        else if (first == 1 || first == 6) return go(2, grid);
        else if (first == 2 || first == 3) return go(3, grid);
        else if (first == 4) {
            return go(2, grid) || go(3, grid);
        }
        return false;
    }

    private static boolean go(int to, int[][] grid) {
        int m = 0;
        int n = 0;
        int height = grid.length;
        int width = grid[0].length;
        while (true) {
            if (to == 1) {
                m = m - 1;
            } else if (to == 2) {
                n = n + 1;
            } else if (to == 3) {
                m = m + 1;
            } else if (to == 4) {
                n = n - 1;
            }
            boolean ava = m < height && n < width && m >= 0 && n >= 0;
            if (!ava) {
                break;
            }
            int next = grid[m][n];
            to = getTo(to, next);
            if (to == 0) {
                break;
            }
        }
        return m >= height - 1 && n >= width - 1;
    }

    private static int getTo(int to, int next) {
        if (to == 1) {
            if (next == 2) {
                return 1;
            } else if (next == 3) {
                to = 4;
            } else if (next == 4) {
                to = 2;
            } else {
                to = 0;
            }

        } else if (to == 2) {
            if (next == 1) {
                to = 2;
            } else if (next == 3) {
                to = 3;
            } else if (next == 5) {
                to = 1;
            } else {
                to = 0;
            }

        } else if (to == 3) {
            if (next == 2) {
                to = 3;
            } else if (next == 5) {
                to = 4;
            } else if (next == 6) {
                to = 2;
            } else {
                to = 0;
            }
        } else if (to == 4) {
            if (next == 1) {
                to = 4;
            } else if (next == 4) {
                to = 3;
            } else if (next == 6) {
                to = 1;
            } else {
                to = 0;
            }
        }
        return to;
    }
}
