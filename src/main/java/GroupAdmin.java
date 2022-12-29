import observer.Member;
import observer.Sender;
import observer.UndoableStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class GroupAdmin implements Sender {
    private List<Member> mems = new ArrayList<>();
    private UndoableStringBuilder us = new UndoableStringBuilder();

    @Override
    public void register(Member obj) {
        this.mems.add(obj);
    }

    @Override
    public void unregister(Member obj) {
        this.mems.remove(obj);

    }

    @Override
    public void insert(int offset, String obj) {
        us.insert(offset,obj);
        for (int i=0;i<mems.size();i++){
            mems.get(i).update(us);
        }
    }
//
    @Override
    public void append(String obj) {
        us.append(obj);
        for (int i=0;i<mems.size();i++){
            mems.get(i).update(us);
        }

    }

    @Override
    public void delete(int start, int end) {
        us.delete(start, end);
        for (int i = 0; i < mems.size(); i++) {
            mems.get(i).update(us);
        }
    }

    @Override
    public void undo() {
            us.undo();
            for (int i=0;i<mems.size();i++){
                mems.get(i).update(us);
        }



    }

    public UndoableStringBuilder getUdoableStringBuilder() {
        return this.us;
    }
    public List<Member> getAllMembers() {
        return mems;
    }
}
