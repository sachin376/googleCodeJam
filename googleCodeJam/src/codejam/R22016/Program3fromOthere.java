package codejam.R22016;


import java.io.*;
import java.math.*;
import java.util.*;

public class Program3fromOthere{
public static void main(String[] args) {
     FasterScanner in = new FasterScanner();
      PrintWriter  out = new PrintWriter(System.out);
        int t = in.nextInt();
        int current_test = 0;
        for(int ii=0;ii<t;ii++) 
        {
            current_test++;
            int n = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            HashMap<String, Integer> mapA = new HashMap<>();
            HashMap<String, Integer> mapB = new HashMap<>();
            int countA = 0;
            int countB = 0;
            for(int i = 0; i < n; i++) {
                String x = in.nextString();
                String y = in.nextString();
                if (!mapA.containsKey(x)) {
                    mapA.put(x, countA++);
                }
                a[i] = mapA.get(x);
                if (!mapB.containsKey(y)) {
                    mapB.put(y, countB++);
                }
                b[i] = mapB.get(y);
            }
            int min = (int)1e7;
            lp:
            for(int val = 0; val < (1<<n); val++){
                boolean[] right1 = new boolean[countA];
                boolean[] right2 = new boolean[countB];
                int count = 0;
                
                for(int i = 0 ; i < n ; i ++ ){
                    
                	if((val & (1<<i)) != 0){
                        right1[a[i]] = true;
                        right2[b[i]] = true;
                        count++;
                    }
                }
                for(int i = 0 ; i < countA;i++){
                    if(!right1[i])
                        continue lp;
                }
                for(int i = 0 ; i < countB;i++){
                    if(!right2[i])
                        continue lp;
                }
                min = Math.min(min, count);
            }
            out.println("Case #"+current_test+": "+(n - min));

        }
        
        out.close();
    }

   static class FasterScanner {
        private byte[] buf = new byte[1024];
        private int curChar;
        private int snumChars;

        public int read() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = System.in.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        public long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
}