import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		int [] intBook;
		int M=0;
		int x=0;
		int y=0;
		int a=0;
		int b=0;
		int pos=-1;
		int diff=100000;
		int i=0;
		int j=0;
		String[] bookArray;
		br.readLine();
		while(br.ready()){
			
			bookArray = br.readLine().split(" "); 
			intBook= new int[bookArray.length];
			for(int c=0;c<bookArray.length;c++) {
				intBook[c]=Integer.parseInt(bookArray[c]);
			}
			M= Integer.parseInt(br.readLine());
			i=0;
			j=0;
			Arrays.sort(intBook);
			int mid=0;
			diff=1000001;
			for(int c=0; c<intBook.length;c++) {
				x=intBook[c];
				y=M-x;
				a=0;
				b=intBook.length-1;
				pos=-1;
				while(a <= b && pos == -1) {
					mid=(a+b)/2;
					if(mid!=c && intBook[mid]==y&&Math.abs(x-intBook[mid])<diff) {
						i=x;
						j=y;						
						diff=Math.abs(x-intBook[mid]);
						pos=mid;
					}else if(intBook[mid]>y){
						b=mid-1;
					}else {  
						a=mid+1;
					}
				}
			}
			bw.write("Peter should buy books whose prices are "+i+" and "+j+".\n");
			bw.newLine();
			br.readLine();
			br.readLine();
		}
		bw.close();
		br.close();
	}

}
