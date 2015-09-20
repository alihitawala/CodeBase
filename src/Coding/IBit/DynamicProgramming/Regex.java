package Coding.IBit.DynamicProgramming;

import java.util.Scanner;

/**
 * Created by aliHitawala on 9/17/15.
 */
public class Regex {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String p = in.next();
        System.out.println(new Regex().isMatch(s,p));
    }
    public int isMatch(final String s, final String p) {
        String x = p;
        while(x.contains("**")) {
            x = x.replaceAll("\\*\\*", "\\*");
        }
        boolean t = _match(s, x, 0, 0);
        return t ? 1 : 0;
    }

    private boolean _match(String s, String p, int i, int j) {
        if (p.length() == j)
            return s.length() == i || p.charAt(j-1) == '*';
        if (s.length() == i)
            return p.charAt(j) == '*' && j == p.length()-1;
        char c = s.charAt(i);
        char d = p.charAt(j);
        if (c == d || d == '?')
            return _match(s,p,i+1,j+1);
        else if (d == '*') {
            int a = i;
            while (a != s.length()) {
                if (_match(s, p, a, j + 1))
                    return true;
                a++;
            }
        }
        return false;
    }
}