//*************************************************//
//          INTHER LOGISTICS ENGINEERING           //
//*************************************************//

package com.backend.collab_backend;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Group {
  @Id
  private Long groupId;
  private LocalDate startYear;
  private int freeTime;
  private int tripTime;
}
