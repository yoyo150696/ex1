import observer.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupAdminTest {

    GroupAdmin gAdmin = new GroupAdmin();
    Member m1 = new ConcreteMember();
    Member m2 = new ConcreteMember();
    Member m3 = new ConcreteMember();
    @BeforeEach
    public void init() {
        gAdmin.register(m1);
        gAdmin.append("ABCD");
    }
    @Test
    void register() {
        gAdmin.register(m2);
        gAdmin.register(m3);
        assertEquals(3, gAdmin.getAllMembers().size());
    }

    @Test
    void unregister() {
        gAdmin.unregister(m1);
        assertEquals(0, gAdmin.getAllMembers().size());

    }
// dddd
    @Test
    void insert() {
        gAdmin.insert(4,"TEST");
        assertEquals("ABCDTEST", gAdmin.getUdoableStringBuilder().toString());


    }

    @Test
    void append() {

        assertNotEquals("hello", gAdmin.getUdoableStringBuilder().toString());
        gAdmin.append("hello");
        assertEquals("ABCDhello", gAdmin.getUdoableStringBuilder().toString());
    }

    @Test
    void delete() {

        gAdmin.delete(0,1);
        assertEquals("BCD",gAdmin.getUdoableStringBuilder().toString());
    }

    @Test
    void undo() {
        gAdmin.insert(1,"DD");
        assertEquals("ADDBCD",gAdmin.getUdoableStringBuilder().toString());
        gAdmin.undo();
        assertEquals("ABCD",gAdmin.getUdoableStringBuilder().toString());
    }
}