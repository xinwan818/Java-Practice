public class HelloWorld {
	public static void drawTriangle(int n) {
		for(int j = 0;j<n;j++){
			for(int i = j;i>=0;i--){
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static int max(int[] m){
		int res = m[0];
		for(int i = 1;i<m.length;i++){
				if(m[i]>res) {
					res = m[i];
				}	
		}
		return res;
	}

	public static void main(String[] args) {
		//drawTriangle(5);
		int[] numbers = new int[]{9,2,15,2,22,10,6};
		System.out.print(max(numbers));
	}

}
	

