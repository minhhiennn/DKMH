package code.webdkmh.dao.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Sub_Pass")
public class SubPass {
    @EmbeddedId
    private SubPassId id;

    @Column(name = "Score", nullable = false)
    private Double score;

    @Column(name = "Score_System_4", nullable = false)
    private Double scoreSystem4;

    @Column(name = "Rated", nullable = false, length = 10)
    private String rated;

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public Double getScoreSystem4() {
        return scoreSystem4;
    }

    public void setScoreSystem4(Double scoreSystem4) {
        this.scoreSystem4 = scoreSystem4;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public SubPassId getId() {
        return id;
    }

    public void setId(SubPassId id) {
        this.id = id;
    }
}