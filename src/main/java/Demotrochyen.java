/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author lam
 */
import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.exceptions.OllamaBaseException;
import io.github.ollama4j.utils.Options;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Demotrochyen {
    public static String nhan(String tinnhan) throws OllamaBaseException, IOException, InterruptedException {
       OllamaAPI ollama = new OllamaAPI("http://localhost:11434");
Map<String, Object> options = new HashMap<>();
//String response = ollama.generate("llama3", tinnhan, options).getResponse();
        System.out.println("da nhan"+tinnhan);
        String response = ollama.generate("llama3", tinnhan, false, new Options(options), null).getResponse();

//System.out.println(response);
System.out.println("🧠 Phan hoi tu AI: " + response);
        System.out.println("phan hoi :"+ ollama.generate("llama3", tinnhan, options).toString());
return  response;
    }
}
