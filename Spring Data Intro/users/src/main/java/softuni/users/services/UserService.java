package softuni.users.services;

import softuni.users.entities.User;

import java.util.Date;
import java.util.List;

public interface UserService {
    void persist(User user);
    List<User> findAll();
    List<Object[]> findUsersByEmailProvider(String provider);
    Integer countByProfilePictureGreaterThan(byte[] length);
    Integer prepareInactiveUsersForRemove(Date date);
    void deleteInactiveUsers();
    List<User> findAllUsersWithProfilePictures();



}
