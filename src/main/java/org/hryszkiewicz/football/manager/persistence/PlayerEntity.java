package org.hryszkiewicz.football.manager.persistence;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "players")
public class PlayerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(length = 1)
    private Date createTime;

    @Version
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(length = 1)
    private Date updateTime;

    private String firstName;

    private String lastName;

    private int age;

    private Date dateOfBirth;

//    private List<String> previousClubs;

    @NotNull
    @Column(unique = true)
    private String playerId;

    @OneToMany(targetEntity = GoalEntity.class,
            mappedBy = "scorer",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<GoalEntity> goals;

    @OneToMany(targetEntity = AssistEntity.class,
            mappedBy = "assistent",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<AssistEntity> assist;

//    @OneToMany(targetEntity = CardEntity.class,
//            mappedBy = "assistent",
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private List<CardEntity> cards;


//    @OneToMany
//            (targetEntity = AssistEntity.class,
//                    mappedBy = "assistent",
//                    fetch = FetchType.LAZY,
//                    cascade =
    @ManyToOne
    @JoinColumn(name = "club_Id")
    private ClubEntity club;

    public ClubEntity getClub() {
        return club;
    }

    public void setClub(ClubEntity club) {
        this.club = club;
    }

    public List<GoalEntity> getGoals() {
        return goals;
    }

    public void setGoals(List<GoalEntity> goals) {
        this.goals = goals;
    }

    public List<AssistEntity> getAssist() {
        return assist;
    }

    public void setAssist(List<AssistEntity> assist) {
        this.assist = assist;
    }

//    public List<CardEntity> getCards() {
//        return cards;
//    }
//
//    public void setCards(List<CardEntity> cards) {
//        this.cards = cards;
//    }
    //    @ManyToMany(fetch = FetchType.EAGER,
//            cascade = CascadeType.ALL)
//    @JoinTable(name = "player_team",
//            joinColumns = @JoinColumn(name = "playerId",
//                    referencedColumnName = "playerId"),
//            inverseJoinColumns = @JoinColumn(name = "teamId",
//                    referencedColumnName = "id"))
//    private Set<ClubEntity> teams;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

//    public List<String> getPreviousClubs() {
//        return previousClubs;
//    }
//
//    public void setPreviousClubs(List<String> previousClubs) {
//        this.previousClubs = previousClubs;
//    }
}
