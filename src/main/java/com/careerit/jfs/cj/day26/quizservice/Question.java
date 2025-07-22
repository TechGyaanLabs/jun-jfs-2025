package com.careerit.jfs.cj.day26.quizservice;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,      // Use simple names
        include = JsonTypeInfo.As.PROPERTY, // Include type info in JSON as property
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = McqQuestion.class, name = "MCQ"),
        @JsonSubTypes.Type(value = MatchTheFollowingQuestion.class, name = "MTF"),
        @JsonSubTypes.Type(value = PairsQuestion.class, name = "Pairs"),
        @JsonSubTypes.Type(value = TrueOrFalse.class, name = "TOF")
})
@Getter
@Setter
public abstract class Question {
    long id;
    String question;
}
