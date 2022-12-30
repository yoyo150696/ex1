import observer.Member;
import observer.UndoableStringBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ConcreteMemberTest {
    Member member = new ConcreteMember();
    @Test
    void update() {
        UndoableStringBuilder undoableStringBuilder = new UndoableStringBuilder();
        undoableStringBuilder.append("ABCD");

        member.update(undoableStringBuilder);
        Assertions.assertNotNull(((ConcreteMember)member).us);
        
        System.out.println(JvmUtilities.jvmInfo());
        System.out.println(JvmUtilities.objectFootprint(member));
        System.out.println(JvmUtilities.objectTotalSize(member));
        System.out.println(JvmUtilities.memoryStats(member));
    }
}
