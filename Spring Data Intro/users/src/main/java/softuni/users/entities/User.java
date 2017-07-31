package softuni.users.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "users")
public class User {
    private Long id;
    private String userName;
    private String password;
    private String email;
    private byte[] profilePicture;
    private Date registerDate;
    private Date lastTimeLoggedIn;
    private Integer age;
    private Boolean isDeleted;
    private Town bornTown;
    private Town livingTown;
    private String firstName;
    private String lastName;
    private Set<User> friends;
    private Set<Album> albums;

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "username", nullable = false)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if (userName.length() < 4 || userName.length() > 30) {
            throw new IllegalArgumentException("Username length should be between 4 and 30 symbols!");
        }

        this.userName = userName;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() < 6 || password.length() > 50) {
            throw new IllegalArgumentException("Password length should be between 6 and 50 symbols!");
        }

        Pattern firstPattern = Pattern.compile("[a-z]");
        Matcher matcher = firstPattern.matcher(password);

        if (!matcher.find()) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter!");
        }

        Pattern secondPattern = Pattern.compile("[A-Z]");
        matcher = secondPattern.matcher(password);

        if(!matcher.find()) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter!");
        }

        Pattern thirdPattern = Pattern.compile("[0-9]");
        matcher = thirdPattern.matcher(password);

        if (!matcher.find()) {
            throw new IllegalArgumentException("Password should contain at least one digit!");
        }

        Pattern fourthPattern = Pattern.compile("[!@#$%^&*()_+<>?]");
        matcher = fourthPattern.matcher(password);

        if (!matcher.find()) {
            throw new IllegalArgumentException("Password should contain at least one of these (!, @, #, $, %, ^, &, *, (, ), _, +, <, >, ?) symbols!");
        }

        this.password = password;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!email.matches("^[a-zA-Z0-9]+([\\.\\-_]*[a-zA-Z0-9]+)*@[a-zA-Z]+(\\.[a-zA-Z]+)+$")) {
            throw new IllegalArgumentException("Invalid email!");
        }

        this.email = email;
    }

    @Column(name = "profile_picture", columnDefinition = "LONGBLOB")
    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        if (profilePicture.length > 1024 * 1024) {
            throw new IllegalArgumentException("Profile picture size shuld be maximum of 1 MB!");
        }

        this.profilePicture = profilePicture;
    }

    @Column(name = "registered_on")
    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Column(name = "last_time_logged_in")
    public Date getLastTimeLoggedIn() {
        return lastTimeLoggedIn;
    }

    public void setLastTimeLoggedIn(Date lastTimeLoggedIn) {
        this.lastTimeLoggedIn = lastTimeLoggedIn;
    }

    @Basic
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if (age < 1 || age > 120) {
            throw new IllegalArgumentException("Age should be between 1 and 120!");
        }
        this.age = age;
    }

    @Basic
    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @ManyToOne
    @JoinColumn(name = "born_town_id", referencedColumnName = "id")
    public Town getBornTown() {
        return bornTown;
    }

    public void setBornTown(Town bornTown) {
        this.bornTown = bornTown;
    }

    @ManyToOne
    @JoinColumn(name = "living_town_id", referencedColumnName = "id")
    public Town getLivingTown() {
        return livingTown;
    }

    public void setLivingTown(Town livingTown) {
        this.livingTown = livingTown;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Transient
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_friends",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id"))
    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    @OneToMany(mappedBy = "owner")
    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
}
