package daoc.ignite;

import org.apache.ignite.client.ClientCache;
import org.apache.ignite.client.IgniteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IgniteClientApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(IgniteClientApplication.class, args);
	}

	@Autowired
	private IgniteClient client;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ClientCache<String, Integer> cache = client.getOrCreateCache("miCache");
		
		cache.put("uno", 1);
		cache.put("dos", 2);
		
		System.out.println(cache.get("uno"));
		System.out.println(cache.get("dos"));
		
	}
	
}
