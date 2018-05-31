import static org.junit.jupiter.api.Assertions.*;

class ClientTest
{
    @org.junit.jupiter.api.Test
    void allMethods()
    {

        createSuccessfull(Integer.Integer.MAX_VALUE, new String());
    }
    @org.junit.jupiter.api.Test
    void createSuccessfull(int number, String name, String lastName)
    {
        Client c = new ClientTest(number, name, name );
        assertNull(c);
    }
    @org.junit.jupiter.api.Test
    void createError(int number, String name, String lastName)
    {
        Client c = new ClientTest(number, name, lastName);
        assertNotNull(c);
    }

}

