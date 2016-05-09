package flowctrl.sample.service.security;

import flowctrl.sample.entity.User;
import flowctrl.sample.module.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by allbegray on 2016-04-29.
 */
@Transactional
public class SampleUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLoginId(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return new SampleUserDetails(user);
    }

}
