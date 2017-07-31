package softuni.users.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.users.entities.User;
import softuni.users.repositories.UserRepository;
import softuni.users.services.UserService;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void persist(User user) {
        this.userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public List<Object[]> findUsersByEmailProvider(String provider) {
        return this.userRepository.findUsersByEmailProvider(provider);
    }

    @Override
    public Integer countByProfilePictureGreaterThan(byte[] length) {
        return this.userRepository.countByProfilePictureGreaterThan(length);
    }

    @Override
    public Integer prepareInactiveUsersForRemove(Date date) {
        return this.userRepository.prepareInactiveUsersForRemove(date);
    }

    @Override
    public void deleteInactiveUsers() {
        this.userRepository.deleteInactiveUsers();
    }

    @Override
    public List<User> findAllUsersWithProfilePictures() {
        return this.userRepository.findAllUsersWithProfilePictures();
    }
}
