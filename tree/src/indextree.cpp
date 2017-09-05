/*

struct IndexedTree {
   vector<int> tree;
   int size;
   IndexedTree(int n, int *arr) :
          tree(4 * n, 987654321) {   //넉넉하게 4*n 사이즈 배열 생성, 초기값 지정
       size = 1;
       while (size < n) //2의 배수로 최저 깊이레벨 노드 개수 결정
          size *= 2;
       for (int i = 0; i < n; i++)
          tree[size + i] = arr[i];   //값 복사
       init(1);  //값들 다 계산.
   }
   /* 후라이빗 함수 */
   int init(int pos) {
       if (pos >= size) //단말 노드일 경우
          return tree[pos];
       return tree[pos] = min(init(pos * 2), init(pos * 2 + 1));
   }
   int query(int left, int right, int node, int nodeLeft, int nodeRight) {
       left = max(left, nodeLeft);
       right = min(right, nodeRight);
       if (left > right)
          return 987654321;   //초기값
       if (left == nodeLeft && right == nodeRight)
          return tree[node];
       int mid = (nodeLeft + nodeRight) / 2;
       return min(query(left, right, node * 2, nodeLeft, mid),
              query(left, right, node * 2 + 1, mid + 1, nodeRight));
   }
 
   void update(int pos) {
       if (pos < 1)
          return;   //루트까지만
       tree[pos] = min(tree[pos * 2], tree[pos * 2 + 1]);   //갱신
       update(pos / 2);   //부모 노드 따라 계속 올라감
   }
 
   /* 사용시 직접 호출할 함수 */
   int query(int left, int right) {  //left~right 사이의 대표값
       return query(left, right, 1, 0, size - 1);
   }
   void update(int index, int newValue) {   //index번 노드 값을 갱신
       tree[size + index] = newValue; //해당 노드 업데이트
       update((size + index) / 2); //부모 노드 재귀 업데이트
   }
};

*/

/*
a~b의 최대,최소 반환: a (왼쪽끝 노드)에 있는 노드가 오른쪽노드일때 그 부모노드가 구간을 대표하는 값을 가질 수 없다는점을 이용하여 노드의 위치가 오른쪽일때는 그 오른쪽에 에 위치하는 왼쪽노드  (이 두 노드는 서로 다른 부모노드를 가진다.) 로, 왼쪽노드일때는 부모노드로 위치를 옮겨가면서 리턴값을 갱신한다. 반대로 b(오른쪽끝 노드) 노드는 왼쪽노드일때 그 노드의 왼쪽에 있는 오른쪽노드, 오른쪽 노드일때 그 부모노드로 위치를 옮겨가면서 리턴값을 갱신한다. 두 위치가 교차되거나 겹칠때 루프를 종료한다.
*/

const int INF = 2e9;
struct Tree{
    int first;
    vector<int> tree;
    Tree(int n)
    {
        for(first=1;first<n;first<<=1);
        tree = vector<int>( n<<2, INF);
    }

    void update(int pos, int val)
    {
        pos += first;
        tree[pos] = val;
        while(pos>>1){
            tree[pos>>1] = min(tree[pos>>1],tree[pos]);
            pos>>=1;
        }
    }

    int query(int l, int r)
    {
        l += first;
        r += first;
        int ret = INF;
        while(l<=r){
            ret = min(ret, min(tree[l],tree[r]));
            l = (l+1)>>1;
            r = (r-1)>>1;
        }
        return ret;
    }

};