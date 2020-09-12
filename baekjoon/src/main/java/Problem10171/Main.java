package Problem10171;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String cat = "\\    /\\\n" +
				" )  ( ')\n" +
				"(  /  )\n" +
				" \\(__)|";

		bw.write(cat);
		bw.flush();
	}
}
