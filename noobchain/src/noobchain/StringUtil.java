package noobchain;

import java.security.MessageDigest;

/**
 * 
 * @author AlexRauenzahn/ArchaicScribe
 * 
 * Practice from Medium on BlockChains
 * 
 * @param input
 */

public class StringUtil {

  public static String applySha256(String input) {
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      //This will apply SHA256 to our input
      byte [] hash = digest.digest(input.getBytes("UTF-8"));
      StringBuffer hexString = new StringBuffer();
      for ( int i = 0; i <hash.length; i++) {
        String hex = Integer.toOctalString(0Xff & hash[i]);
        if(hex.length() == 1) hexString.append('0');
        hexString.append(hex);
      }
      return hexString.toString();
    }
    catch(Exception e) {
      throw new RuntimeException(e);
      
    }
  }
}
