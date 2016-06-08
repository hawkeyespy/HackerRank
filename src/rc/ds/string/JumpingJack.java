package ds.string;

public class JumpingJack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(maxStep(2,2));
		System.out.println(maxStep(2,1));
	}

	static int maxStep(int N, int K) {
        int i=0;
        int max=0;
        while(i < N)
            {
            i++;
            if((max+i)==K)
            {
            	continue;
            }
            max=max+i;
            
            
        }
        return max;
    }

}
