package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Course {
  private final UUID id;
  private final String name;
  private final String par;
  private final String holes;

  public Course(@JsonProperty("id") UUID id,
                @JsonProperty("name")String name,
                @JsonProperty("par")String par,
                @JsonProperty("holes")String holes) {
    this.id = id;
    this.name = name;
    this.par = par;
    this.holes = holes;
  }

  public String getPar() {
    return par;
  }

  public String getName() {
    return name;
  }

  public UUID getId() {
    return id;
  }

  public String getHoles() {
    return holes;
  }
}