package softuni.users.terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.users.entities.User;
import softuni.users.services.UserService;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Component
public class Terminal implements CommandLineRunner {
    private final UserService userService;

    @Autowired
    public Terminal(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... strings) throws Exception {
        // seed database
        //seed();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 16. get users by email provider
//        String emailProvider = reader.readLine();
//        List<Object[]> usernamesByEmailProvider = this.userService.findUsersByEmailProvider(emailProvider);
//        if (usernamesByEmailProvider.isEmpty()) {
//            System.out.println(String.format("No users found with email domain %s", emailProvider));
//        } else {
//            usernamesByEmailProvider.forEach(u -> System.out.println(String.format("%s %s", u[0], u[1])));
//        }

        // 17. count users with bigger pictures
        int width = Integer.parseInt(reader.readLine());
        List<User> users = this.userService.findAllUsersWithProfilePictures();
        int count = 0;

        for (User user : users) {
            InputStream inputStream = new ByteArrayInputStream(user.getProfilePicture());
            BufferedImage currentPictureReader = ImageIO.read(inputStream);
            int imageWidth = currentPictureReader.getWidth();

            if (imageWidth > width) {
                count++;
            }
        }

        if (count > 0) {
            System.out.println(String.format("%d users have profile pictures wider than %d pixels", count, width));
        } else {
            System.out.println(String.format("No users have profile picture wider than %d pixels", width));
        }

        // 18.remove inactive users
//        String dateAsString = reader.readLine();
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);
//        LocalDate localDate = LocalDate.parse(dateAsString, formatter);
//        Date date = java.sql.Date.valueOf(localDate);
//
//        Integer deletedUsers = this.userService.prepareInactiveUsersForRemove(date);
//        if (deletedUsers == 0) {
//            System.out.println("No users have been deleted");
//        } else {
//            System.out.println(deletedUsers == 1 ? String.format("%d user has been deleted", deletedUsers) : String.format("%d users have been deleted", deletedUsers));
//            this.userService.deleteInactiveUsers();
//        }
    }

    private void seed() throws IOException {
        User firstUser = new User();
        firstUser.setUserName("misho");
        firstUser.setPassword("misHo4?");
        firstUser.setEmail("misho@misho.bg");
        firstUser.setAge(3);
        BufferedImage firstPictureReader = ImageIO.read(new File("src/main/resources/images/little dog.jpg"));
        ByteArrayOutputStream firstUserData = new ByteArrayOutputStream();
        ImageIO.write(firstPictureReader, "jpg", firstUserData);
        byte[] firstUserImg = firstUserData.toByteArray();
        firstUser.setProfilePicture(firstUserImg);
        userService.persist(firstUser);

        User secondUser = new User();
        secondUser.setUserName("pesho");
        secondUser.setPassword("pE123!g");
        secondUser.setEmail("pesho@pesho.com");
        secondUser.setAge(40);
        BufferedImage secondPictureReader = ImageIO.read(new File("src/main/resources/images/sweet dog.jpg"));
        ByteArrayOutputStream secondUserData = new ByteArrayOutputStream();
        ImageIO.write(secondPictureReader, "jpg", secondUserData);
        byte[] secondUserImg = secondUserData.toByteArray();
        secondUser.setProfilePicture(secondUserImg);
        userService.persist(secondUser);

        User thirdUser = new User();
        thirdUser.setUserName("gosho");
        thirdUser.setPassword("GoS45@!");
        thirdUser.setEmail("gosho@gosho.com");
        thirdUser.setAge(60);
        BufferedImage thirdPictureReader = ImageIO.read(new File("src/main/resources/images/two dogs.jpg"));
        ByteArrayOutputStream thirdUserData = new ByteArrayOutputStream();
        ImageIO.write(thirdPictureReader, "jpg", thirdUserData);
        byte[] thirdUserImg = thirdUserData.toByteArray();
        thirdUser.setProfilePicture(thirdUserImg);
        userService.persist(thirdUser);
    }
}
