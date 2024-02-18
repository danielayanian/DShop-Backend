package ar.danielayanian.dshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.danielayanian.dshop.entities.User;
import ar.danielayanian.dshop.repositories.UserRepository;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User userRegist(User user) {
    	
    	User userCreated = userRepository.save(user);
    	
    	userCreated.setEmail("");
    	userCreated.setPassword("");
    	userCreated.setRoles("");
    	
    	return userCreated;
    	
    }
    
    @Override
    public Optional<User> findByEmail(String username){
    	
    	Optional<User> userOptResult = null;
    	
    	User user = new User();
    	
    	Optional<User> userOpt = userRepository.findByEmail(username);
    	if(userOpt.isPresent()) {
        	user.setId(userOpt.get().getId());
        	user.setNombre(userOpt.get().getNombre());
        	user.setApellido(userOpt.get().getApellido());
        	user.setDni(userOpt.get().getDni());
        	user.setEmail(userOpt.get().getEmail());
        	user.setDireccion(userOpt.get().getDireccion());
        	user.setTelefono(userOpt.get().getTelefono());
        	user.setRoles(userOpt.get().getRoles());
        	
        	userOptResult = Optional.ofNullable(user);
        	return userOptResult;
    	}
    	
    	userOptResult = Optional.ofNullable(null);
    	
    	return userOptResult;
    	
    }
    
    @Override
    public void userUpdate(User user) {
    	
    	User userResult = new User();
    	userResult = userRepository.findById(user.getId()).get();
    	
    	userResult.setNombre(user.getNombre());
    	userResult.setApellido(user.getApellido());
    	userResult.setDni(user.getDni());
    	userResult.setTelefono(user.getTelefono());
    	userResult.setDireccion(user.getDireccion());
    	
    	userRepository.save(userResult);
    	
    }
    
}