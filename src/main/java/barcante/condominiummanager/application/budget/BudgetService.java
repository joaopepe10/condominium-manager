package barcante.condominiummanager.application.budget;

import barcante.condominiummanager.domain.budget.BudgetProposalService;
import condominiummanager.model.BudgetRequest;
import condominiummanager.model.BudgetsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BudgetService {

    private final BudgetProposalService budgetProposalService;

    public void createBudgetProposal(BudgetRequest request) {
        budgetProposalService.createBudgetProposal(request);
    }

    public List<BudgetsResponse> findAll(){
        return budgetProposalService.findAll();
    }
}
