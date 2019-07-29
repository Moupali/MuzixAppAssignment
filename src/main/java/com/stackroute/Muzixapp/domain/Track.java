package com.stackroute.Muzixapp.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.apache.catalina.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class Track  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int trackId;
    @JsonProperty("name")
    String trackName;
    String trackComments;


}