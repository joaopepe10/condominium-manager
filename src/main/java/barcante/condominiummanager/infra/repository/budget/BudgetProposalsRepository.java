package barcante.condominiummanager.infra.repository.budget;

import barcante.condominiummanager.infra.repository.budget.model.BudgetProposalsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BudgetProposalsRepository extends JpaRepository<BudgetProposalsEntity, UUID> {
}
