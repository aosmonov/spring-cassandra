package kg.aios.test.cassandra.repo;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import kg.aios.test.cassandra.model.User;

@Repository
public interface UserRepository extends CassandraRepository<User, String> {
	
}
