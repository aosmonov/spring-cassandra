package kg.aios.test.cassandra.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = "kg.test.aios.cassandra.repo")
public class CassandraConfig extends AbstractCassandraConfiguration {

	@Value("${cassandra.keyspace}")
	private String keyspace;

	@Override
	protected String getKeyspaceName() {
		return keyspace;
	}

	@Override
	protected String getContactPoints() {
		return "localhost";
	}

}
