package app.slt.soa.filereader.services;

import app.slt.soa.filereader.model.MyUserDetails;
import app.slt.soa.filereader.model.User;
import app.slt.soa.filereader.model.UserPrincipal;
import app.slt.soa.filereader.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("User not found!");
        }
        return new UserPrincipal(user);

    }
}


