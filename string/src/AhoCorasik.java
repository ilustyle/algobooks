// Aho-Corasik 구현하기
import java.util.*;

public class AhoCorasik {

	static final int MAXS = 500; // 최대 상태수 = 패턴들의 길이의 합
	static final int MAXC = 26;  // 문자집합의 최대 크기

	static int[] out = new int[MAXS];	// 출력 함수
	static int[] f = new int[MAXS]; 	// 실패(failure) 함수
	static int[][] g = new int[MAXS][MAXC + 1]; // goto 함수(트라이): g[상태번호][문자]

	static int buildMatchingMachine(String[] arr, int k) // 상태수 반환
	{
	    int states = 1;

	    // goto 함수 생성, k: 패턴 수
	    for (int i = 0; i < k; ++i)
	    {
	        String word = arr[i];
	        int currentState = 0;

	        for (int j = 0; j < word.length(); ++j)
	        {
	            int ch = word.charAt(j) - 'a';

	            if (g[currentState][ch] == -1)
	                g[currentState][ch] = states++;

	            currentState = g[currentState][ch];
	        }
	        out[currentState] |= (1 << i);    
	    }
	    
	    for (int ch = 0; ch < MAXC; ++ch)
	        if (g[0][ch] == -1)
	            g[0][ch] = 0;


	    Queue<Integer> Q = new LinkedList<Integer>();      
	    for (int ch = 0; ch < MAXC; ++ch)  
	    {
	        if (g[0][ch] != 0)
	        {
	            f[g[0][ch]] = 0;
	            Q.add(g[0][ch]);
	        }
	    }
	    // Now queue has states 1 and 3
	    while (!Q.isEmpty())
	    {
	        int state = Q.remove();

	        for (int ch = 0; ch < MAXC; ++ch)
	        {
	        
	            if (g[state][ch] != -1)
	            {
	                int failure = f[state]; // Find failure state of removed state

	                while (g[failure][ch] == -1)
	                      failure = f[failure];

	                failure = g[failure][ch];
	                f[g[state][ch]] = failure;

	                // 출력 함수에 결과 추가
	                out[g[state][ch]] |= out[failure];

	                Q.add(g[state][ch]);
	            }
	        }
	    }
	    return states;
	}
	static int findNextState(int currentState, char nextInput)
	{
	    int answer = currentState;
	    int ch = nextInput - 'a';
	    
	    while (g[answer][ch] == -1) // 실패함수 값 설정
	        answer = f[answer];

	    return g[answer][ch];
	}
	
	static void searchWords(String[] arr, int k, String text)
	{

	    buildMatchingMachine(arr, k);
	    int currentState = 0;       // 초기 상태

	    for (int i = 0; i < text.length(); ++i)
	    {
	        currentState = findNextState(currentState, text.charAt(i));
	        
	        if (out[currentState] == 0)  // 매칭 실패 시, 다음 문자로
	             continue;

	        for (int j = 0; j < k; ++j)
	        {
	            if ((out[currentState] & (1 << j)) != 0)
	            {
	            	System.out.println("문자열 " + arr[j]);
	                System.out.printf(" %d 부터 %d 까지 포함\n" , i - arr[j].length() + 1, i);
	            }
	        }
	    }
	}

	public static void main(String[] args)
	{
	    String[] arr = new String[]{"he", "she", "hers", "his"};
	    String text = "ahishers";
	    
	    System.out.println("패턴들> ");
	    int len = 0;
	    for(String str: arr)
	    {
	    	System.out.print(str + " ");
	    	len += str.length();
	    }
	    System.out.println("\n텍스트> " + text + "\n------------------");
	    for(int i = 0; i <= len; i++)
	    	for(int j = 0; j < MAXC; j++)
	    		g[i][j] = -1;
	    
	    searchWords(arr, arr.length, text);
	    
	}

}
