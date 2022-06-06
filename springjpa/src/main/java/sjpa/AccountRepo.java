package sjpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepo extends CrudRepository<Account, Long> {
    List<Account> findByName(String name);

    @Query("select a.name from Account a where a.name = :name")
    String customQuery(String name);

}
