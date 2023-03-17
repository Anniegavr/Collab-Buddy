package com.collab.buddy.CollabBuddy.assignment;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AssignmentControllerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private AssignmentRepository assignmentRepository;

  @Before
  public void setUp() {
    assignmentRepository.deleteAll();
  }

  @Test
  public void shouldReturnAllAssignments() throws Exception {
    // Given
    Assignment assignment1 = new Assignment("Assignment 1", "Description 1", LocalDate.now().plusDays(7));
    Assignment assignment2 = new Assignment("Assignment 2", "Description 2", LocalDate.now().plusDays(14));
    assignmentRepository.saveAll(Arrays.asList(assignment1, assignment2));

    // When and Then
    mockMvc.perform(get("/assignments"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].name", is("Assignment 1")))
            .andExpect(jsonPath("$[1].name", is("Assignment 2")));
  }

  @Test
  public void shouldCreateAssignment() throws Exception {
    // Given
    Assignment assignment = new Assignment("Assignment 1", "Description 1", LocalDate.now().plusDays(7), "Daniel Defoe");

    // When and Then
    mockMvc.perform(post("/assignments")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(assignment)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name", is("Assignment 1")))
            .andExpect(jsonPath("$.description", is("Description 1")))
            .andExpect(jsonPath("$.dueDate", is(assignment.getDueDate().toString())))
            .andExpect(jsonPath("$.teacher", is("Daniel Defoe")))
            .andExpect(jsonPath("$.assignmentId", notNullValue()));
  }
}

