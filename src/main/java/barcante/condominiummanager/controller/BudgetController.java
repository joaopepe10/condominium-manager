package barcante.condominiummanager.controller;

import barcante.condominiummanager.application.budget.BudgetService;
import condominiummanager.controller.BudgetsApi;
import condominiummanager.model.BudgetRequest;
import condominiummanager.model.BudgetsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class BudgetController implements BudgetsApi {

    private final BudgetService budgetService;

    @Override
    public ResponseEntity<Void> createBudget(BudgetRequest budgetRequest) {
        budgetService.createBudgetProposal(budgetRequest);
        return noContent().build();
    }

    @Override
    public ResponseEntity<List<BudgetsResponse>> findAll() {
        return ok(budgetService.findAll());
    }
}
