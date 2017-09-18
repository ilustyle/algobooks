// 최소값 >> https://www.acmicpc.net/problem/10868
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] st;
    
    static void build(int id, int l, int r){
        if(l == r){
            st[id] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        
        build(id * 2, l, mid);
        build(id * 2 + 1, mid  +1, r);
        
        st[id] = Math.min(st[id * 2], st[id* 2 + 1]);
    }
    static int query(int id, int l, int r, int s, int e){
        if(s <= l && r <= e) return st[id];
        if(r< s || e < l) return 0x7ffffff0;
        
        int mid = (l + r) / 2;      
        return Math.min(query(id * 2, l, mid, s, e), query(id * 2 + 1, mid  +1, r, s, e));
    }
    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N + 1];
        for(int i = 1; i <= N; i++)
            arr[i] = sc.nextInt();
        
        int size = 1;
        while(size < N) size <<= 1;
        size <<= 1;
        
        st = new int[size + 10];
        
        build(1, 1, N);
        
        for(int i = 0; i < M; i++)
        {
            int s = sc.nextInt(); 
            int e = sc.nextInt();
            
            System.out.println(query(1, 1, N, s, e));
        }
        sc.close();
    }
}
