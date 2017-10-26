package org.hryszkiewicz.football.manager.persistence;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "clubs")
public class ClubEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String name;

    private String city;

    private String street;

    private String localNumber;

    private String history;

    @NotNull
    @Column(unique = true)
    private String clubId;


//    @OneToMany(targetEntity = PlayerEntity.class,
//            mappedBy = "club",
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "club")
    private Set<PlayerEntity> players;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLocalNumber() {
        return localNumber;
    }

    public void setLocalNumber(String localNumber) {
        this.localNumber = localNumber;
    }

    public Set<PlayerEntity> getPlayers() {
        return players;
    }

    public void setPlayers(Set<PlayerEntity> players) {
        this.players = players;
    }

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

//    @OneToMany(targetEntity = TrainerEntity.class,
//            mappedBy = "trainer",
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private List<TrainerEntity> trainers;


}
