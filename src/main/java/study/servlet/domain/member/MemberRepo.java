package study.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepo {

    //MemberRepo 객체가 생성 되더라도 static으로 인해 하나씩만 생성(밑에 단계로 인해 사실 없어도 됨)
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    // 싱글톤
    private static final MemberRepo instance = new MemberRepo();

    public static MemberRepo getInstance() {
        return instance;
    }

    private MemberRepo() {

    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
       return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }

}
