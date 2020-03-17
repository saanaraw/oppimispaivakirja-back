package com.example.jatkuvaprojektijpa;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = SEQUENCE,
            generator = "topic_id_seq")
    @SequenceGenerator(name = "topic_id_seq",
            sequenceName = "topic_id_seq",
            allocationSize = 1)
    @Column(unique = true, nullable = false)
    private int id;
    private String title;
    private String description;
    private String additionalSource;
    private boolean complete;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate creationDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate completionDate;
    private LocalDate alarm;
    private boolean status;

    public Topic() {
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", additionalSource='" + additionalSource + '\'' +
                ", complete=" + complete +
                ", creationDate=" + creationDate +
                ", completionDate=" + completionDate +
                ", alarm=" + alarm +
                ", status=" + status +
                '}';
    }

    public LocalDate getAlarm() {
        return alarm;
    }

    public void setAlarm(LocalDate alarm) {
        this.alarm = alarm;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdditionalSource() {
        return additionalSource;
    }

    public void setAdditionalSource(String additionalSource) {
        this.additionalSource = additionalSource;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }
}

