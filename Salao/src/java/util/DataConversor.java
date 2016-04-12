package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import servlet.AppServletProduto;

public class DataConversor {
    
    public Date formatoData(String data) {
        DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        Date d = null;
        try {
            d = (java.util.Date) formatoData.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(AppServletProduto.class.getName()).log(Level.SEVERE, null, ex);

        }
        return d;
    }
    
    public String UStoBRdate(Date data) {
        String d = "";
        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

        try {
            d = out.format(in.parse(data.toString()));
        } catch (ParseException ex) {
            Logger.getLogger(AppServletProduto.class.getName()).log(Level.SEVERE, null, ex);
        }

        return d;
    }
    
}
