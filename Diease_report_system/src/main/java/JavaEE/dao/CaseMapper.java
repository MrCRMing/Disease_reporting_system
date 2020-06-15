package JavaEE.dao;

import JavaEE.domain.Case;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CaseMapper {
    //增加案例
    public void addCase(Case the_case);

    //删除案例
    public void deleteCase(int case_id);

    //修改案例
    public void updateCase(Case the_case);

    //单案例查询
    public Case findCase(int case_id);

    //多案例查询--按查询条件查询
    public List<Case> findMultiCase(Map<String,String>map);

    //全案例查询
    public List<Case> findAllCase();
}
