package JavaEE.dao;

import JavaEE.domain.Case;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CaseMapper {
    //增加案例
    public int addCase(Case the_case);

    //删除案例
    public int deleteCase(@Param("case_id") int case_id, @Param("uid")int uid);

    //修改案例
    public int updateCase(@Param("case")Case the_case, @Param("uid")int uid);

    //单案例查询
    public Case findCase(int case_id);

    //多案例查询--按查询条件查询
    public List<Case> findMultiCase(Map<String,String>map);

    //全案例查询
    public List<Case> findAllCase();
}
