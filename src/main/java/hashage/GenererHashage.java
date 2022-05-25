package hashage;

import org.bouncycastle.util.encoders.Hex;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GenererHashage {
 private String motDepasse ;
 private String typehashage="SHA-256";
 public GenererHashage(String motDepasse){
     this.motDepasse=motDepasse;
 }
 public String RécupereHashage() throws NoSuchAlgorithmException {
     MessageDigest digest = MessageDigest.getInstance(typehashage);
     byte[] hash = digest.digest(motDepasse.getBytes(StandardCharsets.UTF_8));
     String sha256hex = new String(Hex.encode(hash));
     return sha256hex;
 }

}
