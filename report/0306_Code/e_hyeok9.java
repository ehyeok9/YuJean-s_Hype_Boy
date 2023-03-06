import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


class Main{
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        long s = Long.parseLong(br.readLine());
        int i = 1;
        while (true){
            if (i+1 < s-i){
                i++;
                break;
            }
            s -= i;
            i++;
        }
        bw.write(i);
        
        bw.flush();
        bw.close();
    }
}