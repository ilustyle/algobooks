package Day05;

public class SegmentTree0 {
	static int[] arr = {2, 6, 4, 5, 7, 9, 10, 1, 9};
	static int N = arr.length;
	static int[] st;
	
	static void build(int id, int l, int r){		
		if(l == r) {
			st[id] = arr[l]; return;		
		}
		
		int mid = (l + r)/2;
		build(id * 2, l, mid);
		build(id*2 + 1, mid + 1, r);
		
		st[id] = st[id*2] + st[id*2 + 1]; 
	}
	// [s, e]: 쿼리 구간
	static int query(int id, int l, int r, int s, int e){
		
		if(s <= l && r <= e) return st[id];
		if(r < s || e < l) return 0;
		
		int mid = (l + r)/2;
		return query(id * 2, l, mid, s, e) +  query(id*2 + 1, mid + 1, r, s, e);
	}
	// p: 갱신할 자료의 인덱스, v: 갱신 값
	static void update(int id, int l, int r, int p, int v){
		
		if(r < p || p < l) return;
		if(p <= l && r <= p) {
			st[id] = v; return;
		}
		int mid = (l + r)/2;
		update(id * 2, l, mid, p, v);
		update(id*2 + 1, mid + 1, r, p, v);
		st[id] = st[id*2] + st[id*2 + 1];
	}
	public static void main(String[] args){
		int size = 1;
		while(size < N)
			size = size * 2;
		st = new int[size * 2 + 1];
		
		build(1, 0, N - 1);
		update(1, 0, N - 1, 4, 3); 	// arr[4] <= 3
		System.out.println(query(1, 0, N - 1, 0, 5));
		System.out.println(query(1, 0, N - 1, 3, 8));
	}
}
