package main;

import java.util.*;

public class TopK {

    public static List<Long> calculateTopK(int k, long[] A, long[] B, long[] C) {
        List<Long> AB = new ArrayList<>();
        for (long a : A) {
            for (long b : B) {
                AB.add(a + b);
            }
        }

        Collections.sort(AB, Collections.reverseOrder());

        int w = Math.min(k, AB.size());
        List<Long> ABC = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            for (long c : C) {
                ABC.add(AB.get(i) + c);
            }
        }

        Collections.sort(ABC, Collections.reverseOrder());

        return ABC.subList(0, Math.min(k, ABC.size()));
    }

}

// import java.io.*;
// import java.util.*;

// public class TopK {
//     public static void main(String[] args) throws IOException {
//         // 使用 BufferedReader 加速输入
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         int x = Integer.parseInt(st.nextToken());
//         int y = Integer.parseInt(st.nextToken());
//         int z = Integer.parseInt(st.nextToken());
//         int k = Integer.parseInt(st.nextToken());

//         // 读取 A, B, C 数组
//         long[] A = readArray(br, x);
//         long[] B = readArray(br, y);
//         long[] C = readArray(br, z);

//         // 生成 AB 数组并排序（降序）
//         long[] sumAB = generateSumArray(A, B);
//         Arrays.sort(sumAB);
//         reverseArray(sumAB);

//         // 使用优先队列维护前 k 个最大值
//         PriorityQueue<Long> pq = new PriorityQueue<>();
//         int minK = Math.min(k, sumAB.length);
//         for (int i = 0; i < minK; i++) {
//             for (long c : C) {
//                 long sum = sumAB[i] + c;
//                 if (pq.size() < k) {
//                     pq.offer(sum);
//                 } else if (sum > pq.peek()) {
//                     pq.poll();
//                     pq.offer(sum);
//                 }
//             }
//         }

//         // 将优先队列中的结果排序并输出
//         long[] result = new long[pq.size()];
//         int idx = 0;
//         while (!pq.isEmpty()) {
//             result[idx++] = pq.poll();
//         }
//         Arrays.sort(result);
//         reverseArray(result);

//         // 使用 StringBuilder 加速输出
//         StringBuilder sb = new StringBuilder();
//         for (long num : result) {
//             sb.append(num).append("\n");
//         }
//         System.out.print(sb);
//     }

//     // 读取数组
//     private static long[] readArray(BufferedReader br, int size) throws IOException {
//         long[] array = new long[size];
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         for (int i = 0; i < size; i++) {
//             array[i] = Long.parseLong(st.nextToken());
//         }
//         return array;
//     }

//     // 生成 A 和 B 的和数组
//     private static long[] generateSumArray(long[] A, long[] B) {
//         long[] sumAB = new long[A.length * B.length];
//         int idx = 0;
//         for (long a : A) {
//             for (long b : B) {
//                 sumAB[idx++] = a + b;
//             }
//         }
//         return sumAB;
//     }

//     // 反转数组
//     private static void reverseArray(long[] arr) {
//         int i = 0, j = arr.length - 1;
//         while (i < j) {
//             long temp = arr[i];
//             arr[i] = arr[j];
//             arr[j] = temp;
//             i++;
//             j--;
//         }
//     }
// }