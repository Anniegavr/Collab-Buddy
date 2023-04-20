//*************************************************//
//          INTHER LOGISTICS ENGINEERING           //
//*************************************************//

package com.collab.buddy.student;

/**
 * @author agavrilita
 * @since 4/20/2023
 */
public class StudentDTO {
  public StudentDTO(Integer year, String specialty, String email) {
    this.year = year;
    this.specialty = specialty;
    this.email = email;
  }
  public String name;

  public StudentDTO(String name, Integer year, String specialty, String email) {
    this.name = name;
    this.year = year;
    this.specialty = specialty;
    this.email = email;
  }

  public Integer year;
  public String specialty;
  public String email;
}
