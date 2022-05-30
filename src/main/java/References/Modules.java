package References;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.scene.control.PasswordField;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

   public class Modules {
    public static String Word="ABCDEFGHIJKLMNOPQRSTEUVWXYZ123456789";
    public static ArrayList<String> propositions;
    private Trie trie;
    public Modules() throws IOException {
        Reader reader ;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        reader = Files.newBufferedReader(Paths.get("References/modules.json"));
        trie = gson.fromJson(reader,Trie.class);
    }
    public ArrayList<String> RecherchModules(String motclé){
       propositions =new ArrayList<>();
       trie.RecherchModule(motclé);
       return propositions;
    }
    public void AjouteModule(String module) throws IOException {
      trie.insert(module.toUpperCase(Locale.ROOT));
      Writer writer=null;
      Gson gson =new GsonBuilder().setPrettyPrinting().create();
        writer =Files.newBufferedWriter(Paths.get("References/modules.json"));
        gson.toJson(trie, writer);
        writer.close();
    }
   }
   class Trie
   {
    private boolean isLeaf;
    private Map<Character,Trie> children;
    private String module;

    // Constructor
    Trie()
    {
        isLeaf = false;
        children = new HashMap<>();
    }
    public void RecherchModule(String key){
       Trie curr = this;
       key=key.toUpperCase(Locale.ROOT);
        for (char c: key.toCharArray())
        {
            System.out.println(c);
            curr = curr.children.get(c);
            if (curr == null) {
                System.out.println("fin");
                break;
            }
        }
        if (curr !=null) {
            if(curr.isLeaf&&curr.module.equals(key))
            {
                Modules.propositions.add(curr.module);
                System.out.println("perfect");
            }
            parcours(curr);
        }
    }

    public void insert(String key)
    {
        // start from the root node
        Trie curr = this;
        // do for each character of the key
        for (char c: key.toCharArray())
        {
            // create a new node if the path doesn't exist
            curr.children.putIfAbsent(c, new Trie());
            // go to the next node
            curr = curr.children.get(c);
        }
        // mark the current node as a leaf
        curr.isLeaf = true;
        curr.module=key;
    }
    public void parcours(Trie curr){
        Trie curr1;
        if(curr !=null) {
            for (char c : Modules.Word.toCharArray()) {
                curr1 = curr.children.get(c);
                if (curr1 != null) {
                    if (curr1.isLeaf) {
                        Modules.propositions.add(curr1.module);
                    }
                    parcours(curr1);
                }

            }
        }
    }

}