package sjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    private AccountRepo repo;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("[start]");

        //repo.save(new Account(33l, "Charles"));
        //repo.save(new Account(44l, "David"));

        System.out.println("---find all---");
        repo.findAll().forEach(x -> System.out.println(x.getName()));
        System.out.println("---find one with custom query---");
        Optional.of(repo.customQuery("Alice")).ifPresent(x -> System.out.println(x));
        System.out.println("[end]");
    }
}
