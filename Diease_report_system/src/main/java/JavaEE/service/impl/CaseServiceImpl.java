package JavaEE.service.impl;

import JavaEE.dao.CaseMapper;
import JavaEE.domain.Case;
import JavaEE.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("caseService")
public class CaseServiceImpl implements CaseService {

    @Autowired()
    private CaseMapper caseMapper;
    @Override
    public void addCase(Case the_case) {
        caseMapper.addCase(the_case);
    }

    @Override
    public void deleteCase(int case_id) {
        caseMapper.deleteCase(case_id);
    }

    @Override
    public void updateCase(Case the_case) {
        caseMapper.updateCase(the_case);
    }

    @Override
    public Case findCase(int case_id) {
        return caseMapper.findCase(case_id);
    }

    @Override
    public List<Case> findMultiCase(Map<String,String> map) {
        return caseMapper.findMultiCase(map);
    }

    @Override
    public List<Case> findAllCase() {
        return caseMapper.findAllCase();
    }
}
