package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

	public BufferedReader br;
	public BufferedWriter bw;

	public Main() {
		br= new BufferedReader(new InputStreamReader(System.in));
		bw= new BufferedWriter(new OutputStreamWriter(System.out));
	}
	public static void main(String[] args) {

		Main ui=new Main();
		int N=0;
		String book="";
		String[] bookArray;
		int [] intBook;
		int M=0;
		ArrayList<String> print=new ArrayList<>();
		try {
			String first= ui.br.readLine();
			while(first !=null){  
				N= Integer.parseInt(first);
				book=ui.br.readLine();
				bookArray=book.split(" ");
				intBook= new int[N];
				for(int c=0; c<N;c++) {
					intBook[c]=Integer.parseInt(bookArray[c]);
				}
				M= Integer.parseInt(ui.br.readLine());
				int i=0;
				int j=0;
				for(int c=0; c<intBook.length;c++) {
					int x=intBook[c];
					int y=M-x;
					for( int z=0;z<N;z++) {
						if(intBook[z]==y && z!=c) {
							if(i==0 && j==0 ) {
								i=x;
								j=y;
							}else if(Math.abs(i-j)>Math.abs(x-y)){
								i=x;
								j=y;
							}
						}
					}
				}
				ui.bw.write("\n");
				ui.bw.flush();
				print.add("Peter should buy books whose prices are "+i+" and "+j+".");
				first= ui.br.readLine();
			}
			for(int c=0;c <print.size();c++) {
				ui.bw.write(print.get(c)+"\n \n");
				ui.bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
