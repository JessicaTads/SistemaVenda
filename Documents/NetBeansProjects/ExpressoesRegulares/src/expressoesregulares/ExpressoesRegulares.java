/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expressoesregulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jessica
 */
public class ExpressoesRegulares {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Pattern cep = Pattern.compile("\\d{5}-\\d{3}");
        Pattern email = Pattern.compile("[a-z A-Z 0-9-.\\d]{3,250}@[\\d\\w]+[\\w]+");
        String teste = "jeugbi_6@hotmail.com";
        
        Matcher busca = email.matcher(teste);
        
        if (busca.matches()){
          System.out.println("Achou! ");
        } else{
          System.out.println("Nao Achou!");
        }
    }
    
}
