package barcante.condominiummanager.domain.budget;

import barcante.condominiummanager.infra.exception.InvalidBudgetProposal;
import barcante.condominiummanager.infra.mapper.BudgetProposalMapper;
import barcante.condominiummanager.infra.repository.budget.BudgetProposalsRepository;
import condominiummanager.model.BudgetRequest;
import condominiummanager.model.BudgetsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static barcante.condominiummanager.core.utils.ValidationStringUtil.notNullAndNotBlank;

@Service
@RequiredArgsConstructor
public class BudgetProposalService {

    private final BudgetProposalsRepository budgeRepository;
    private final BudgetProposalMapper budgetProposalMapper;

    public void createBudgetProposal(BudgetRequest request){
        if (isNotValidBudgetProposal(request)){
            throw new InvalidBudgetProposal();
        }
        var entity = budgetProposalMapper.toEnity(request);
        budgeRepository.save(entity);
    }

    public List<BudgetsResponse> findAll(){
        var entities = budgeRepository.findAll();
        return budgetProposalMapper.toResponses(entities);
    }

    private boolean isNotValidBudgetProposal(BudgetRequest request){
        return !notNullAndNotBlank(request.getDescription()) &&
                isValueValid(request.getValue());
    }

    private boolean isValueValid(BigDecimal value){
        return !(value != null && value.compareTo(BigDecimal.ZERO) > 0);
    }


}
