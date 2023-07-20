package com.example.transaction;

public class AbcTest {

    @Mock
    private AacAuthorityProcessRepository aacAuthorityProcessRepository;

    @Spy
    private SaveAccountAuthorityService saveAccountAuthorityService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGenerateProcessId() {
        // Arrange
        Instant fixedTimestamp = Instant.parse("2022-01-01T00:00:00Z");
        UUID fixedUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");

        // Stub the Instant.now() and UUID.nameUUIDFromBytes() methods with fixed values
        doReturn(fixedTimestamp).when(saveAccountAuthorityService).getCurrentTimestamp();
        doReturn(fixedUUID).when(saveAccountAuthorityService).generateUUID();

        // Stub the behavior of calculateModValue()
        doReturn(1).when(saveAccountAuthorityService).calculateModValue("00000000000");

        // Act
        String processId = saveAccountAuthorityService.generateProcessId();

        // Assert
        assertEquals("AA00000000001", processId);
    }

    @Test
    public void testCalculateModValue() {
        // Act
        int modValue = saveAccountAuthorityService.calculateModValue("1234567890");

        // Assert
        assertEquals(1, modValue);
    }
}
In this example, we use @Spy to create a partial mock of SaveAccountAuthorityService, allowing us to stub the behavior of the private method calculateModValue(). We also stub the behavior of getCurrentTimestamp() and g