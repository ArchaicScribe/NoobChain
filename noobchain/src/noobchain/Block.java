package noobchain;

import java.util.Date;

/**
 * @author AlexRauenzahn/ArchaicScribe
 * 
 *         Practice from Medium on BlockChains
 */
public class Block {

  public String hash;
  public String previousHash;
  private String data;
  private long timeStamp;// This will be in milliseconds since 1/1//1970
  private int nonce;

  // Block Constructor
  public Block(String data, String previousHash) {
    this.data = data;
    this.previousHash = previousHash;
    this.timeStamp = new Date().getTime();
    this.hash = calculateHash();// Ensuring we do this after setting the other values.
  }

  public String calculateHash() {
    String calculatedHash = StringUtil.applySha256(previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + data);
    return calculatedHash;
  }

  public void mineBlock(int difficulty) {

    String target = new String(new char[difficulty]).replace('\0', '0');// Create a string with
                                                                        // difficulty * "0"
    while (!hash.substring(0, difficulty).equals(target)) {
      nonce++;
      hash = calculateHash();
    }
    System.out.println("Block Mined!!!  : " + hash);
  }
}


