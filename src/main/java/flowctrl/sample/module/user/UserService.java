package flowctrl.sample.module.user;

import flowctrl.sample.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by allbegray on 2016-04-29.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public User findByLoginId(String loginId) {
        return userRepository.findByLoginId(loginId);
    }

}
