import observer.Member;
import observer.UndoableStringBuilder;

public class ConcreteMember implements Member {
    public UndoableStringBuilder us;
    @Override
    public void update(UndoableStringBuilder usb) {
        us = usb;

    }


}
