/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Valids;

//import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;
import java.util.regex.Matcher;
import java.util.regex.*; 
/**
 *
 * @author Frederico
 */
public class ValEmail {
     public static boolean validaEmail(String email) {
        //System.out.println("Metodo de validacao de email");
        Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$"); 
        Matcher m = p.matcher(email); 
        if (m.find()){
          //System.out.println("O email "+email+" e valido");
          return true;
        }
        else{
         //System.out.println("O E-mail "+email+" é inválido");
          return false;
        }  
    }
}
