package com.sophos.gft.models;

import com.sophos.gft.models.builder.EmpleadoBuilder;

public class Empleado {

  private String name;
  private String job;

  public Empleado(EmpleadoBuilder empleadoBuilder) {
    this.name = empleadoBuilder.getName();
    this.job = empleadoBuilder.getJob();
  }

  public String getName() {
    return name;
  }

  public String getJob() {
    return job;
  }
}
