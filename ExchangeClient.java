/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author atamarkin2
 */
public class ExchangeClient {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        String test[]= new String[5];
        
        test[0]="codebb.cloudapp.net";
        test[1]="17249";
        test[2]="404notfound";
        test[3]="12345678";
        test[4]="MY_CASH";
        
        if (test.length < 5) {
            System.out.println("Usage: \nclientTask <host> <port> <user> <password> <command...>");

        }
        Socket socket = new Socket(test[0], Integer.parseInt(test[1]));
        PrintWriter pout = new PrintWriter(socket.getOutputStream());
        BufferedReader bin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        pout.println(test[2] + " " + test[3]);
        for (int i = 4; i < args.length; i++) {
            pout.println(test[i]);
        }
        pout.println("CLOSE_CONNECTION");
        pout.flush();
        String line;
        while ((line = bin.readLine()) != null) {
            System.out.println(line);
        }
        pout.close();
        bin.close();
    }

}

 class Stock
{
    String ticker;
    double net_worth;
    double dividend_ratio;
    double votility;
    
    public Stock(String ticker)
    { this.ticker=ticker;}
    
    String getTicker()
    { return ticker;}
    
    double getNet_Worth()
    {return net_worth;}
    
    double getVotility()
    {return votility;}
    
    void setNet_worth(double nw)
    {net_worth=nw;}
    
    void setDividend_Ratio(double dr)
    {dividend_ratio=dr;}
    
    void setvotility(double vr)
    {votility=vr;}
    

}
