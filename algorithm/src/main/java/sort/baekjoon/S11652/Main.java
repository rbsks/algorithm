package sort.baekjoon.S11652;

import java.io.*;
import java.util.*;

public class Main {
    // 빠른 입력 (BufferedInputStream 기반)
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            do {
                c = readByte();
            } while (c <= ' ' && c != -1);

            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = readByte();
            }

            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return neg ? -val : val;
        }
    }

    public static void gptSolve() throws IOException {
        FastScanner fs = new FastScanner();
        int n = (int) fs.nextLong();

        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = fs.nextLong();

        Arrays.sort(a);

        long bestVal = a[0];
        int bestCnt = 1;

        long currVal = a[0];
        int currCnt = 1;

        for (int i = 1; i < n; i++) {
            if (a[i] == currVal) {
                currCnt++;
            } else {
                if (currCnt > bestCnt) {
                    bestCnt = currCnt;
                    bestVal = currVal;
                }
                currVal = a[i];
                currCnt = 1;
            }
        }

        // 마지막 구간 처리
        if (currCnt > bestCnt) {
            bestVal = currVal;
        }

        System.out.print(bestVal);
    }

    public static void mySolve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> cardMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            Long cardNumber = Long.parseLong(br.readLine());
            cardMap.put(cardNumber, cardMap.getOrDefault(cardNumber, 0) + 1);
        }

        cardMap.entrySet().stream()
                .min((e1, e2) -> {
                    int countCompare = e2.getValue().compareTo(e1.getValue());
                    if (countCompare == 0) {
                        return e1.getKey().compareTo(e2.getKey());
                    }
                    return countCompare;
                })
                .ifPresent(entry -> {
                    try {
                        bw.write(entry.getKey().toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        gptSolve();
    }
}
