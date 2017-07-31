package softuni.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.users.entities.User;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u.userName, u.email FROM User AS u " +
            "WHERE u.email LIKE CONCAT('%', :provider)")
    List<Object[]> findUsersByEmailProvider(@Param("provider") String provider);

    Integer countByProfilePictureGreaterThan(byte[] length);

    @Query("UPDATE User AS u SET u.deleted = true WHERE u.lastTimeLoggedIn < :date OR u.lastTimeLoggedIn IS NULL")
    @Modifying
    Integer prepareInactiveUsersForRemove(@Param("date") Date date);


    @Query("DELETE FROM User AS u WHERE u.deleted = true")
    @Modifying
    void deleteInactiveUsers();

    @Query("SELECT u FROM User AS u WHERE u.profilePicture IS NOT NULL")
    List<User> findAllUsersWithProfilePictures();
}
