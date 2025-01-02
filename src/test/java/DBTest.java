import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DBTest {

    private static DB database;

    @BeforeAll //Setting up DB

    public static void setUpBeforeClass() {
        DB database = new DB();
        database.connect();
    }

    @BeforeEach //Inserting Elements
    public void setUp() {
        database.insert("Element 1");
        database.insert("Element 2");
    }

    @Order(1)
    @Test //
    public void testGetMethod() {
        assertEquals(database.get(1), "Element 2");
    }


    @Order(2)
    @Test //
    public void testInsert() {
        database.insert("Element 3");
        assertEquals(3, database.count());
        assertEquals(database.get(2), "Element 3");
    }

    @Order(3)
    @Test
    public void tesGetOutBorders(){
        Exception e = assertThrows(IndexOutOfBoundsException.class, ()->{
            String element =database.get(10);
        });

        assertEquals("Index 10 out of bounds for length 2" , e.getMessage());
    }



    @AfterEach //Cleaning DB
    public void tearDown() {
        database.clear();
    }

    @AfterAll //Disconection from DB
    public static void tearDownAfterClass() {
        database.disconnect();
    }

}