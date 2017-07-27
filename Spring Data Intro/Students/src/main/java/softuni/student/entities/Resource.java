package softuni.student.entities;

import softuni.student.enums.MyResourceType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "resources")
public class Resource {
    private Long id;
    private String name;
    private MyResourceType resourceType;
    private String url;
    private Course course;
    private Set<License> licenses;

    public Resource() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "resource_type", nullable = false)
    public MyResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(MyResourceType resourceType) {
        this.resourceType = resourceType;
    }

    @Column(name = "url", nullable = false)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @OneToMany(mappedBy = "resource")
    public Set<License> getLicenses() {
        return licenses;
    }

    public void setLicenses(Set<License> licenses) {
        this.licenses = licenses;
    }
}
