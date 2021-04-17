package kg.aios.test.cassandra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import kg.aios.test.cassandra.model.User;
import kg.aios.test.cassandra.repo.UserRepository;

@Service
@GraphQLApi
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	@GraphQLQuery(name = "greeting")
	public String getGreeting() {
		return "Hello world!";
	}

	@GraphQLMutation(name = "createUser")
	public User createUser(@GraphQLArgument(name = "user") User user) {
		userRepository.save(user);
		
		return user;
	}
	
	@GraphQLQuery(name = "getUser")
	public User getUser(@GraphQLArgument(name = "email") String email) {
		return userRepository.findById(email).get();
	}
	
	@GraphQLQuery(name = "getAllUsers")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GraphQLQuery(name = "deleteUser")
	public void deleteUser(@GraphQLArgument(name = "email") String email) {
		userRepository.deleteById(email);
	}
	
	@GraphQLQuery(name="updateUser")
	public void updateUser(@GraphQLArgument(name = "email") String email, @GraphQLArgument(name = "user") User user) {
		userRepository.save(user);
	}
}
