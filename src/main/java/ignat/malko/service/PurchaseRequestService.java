package ignat.malko.service;

import ignat.malko.model.PurchaseRequest;
import ignat.malko.repository.PurchaseRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseRequestService {
    private final PurchaseRequestRepository purchaseRequestRepository;

    public PurchaseRequestService(PurchaseRequestRepository purchaseRequestRepository) {
        this.purchaseRequestRepository = purchaseRequestRepository;
    }

    public PurchaseRequest createPurchaseRequest(PurchaseRequest request) {
        request.setStatus("NEW");
        request.setCreatedDate(java.time.LocalDate.now());
        return purchaseRequestRepository.save(request);
    }

    public List<PurchaseRequest> getAllPurchaseRequests() {
        return purchaseRequestRepository.findAll();
    }

    public Optional<PurchaseRequest> getPurchaseRequestById(Long id) {
        return purchaseRequestRepository.findById(id);
    }

    public PurchaseRequest updatePurchaseRequest(Long id, PurchaseRequest updatedRequest) {
        return purchaseRequestRepository.findById(id).map(existingRequest -> {
            existingRequest.setDescription(updatedRequest.getDescription());
            existingRequest.setStatus(updatedRequest.getStatus());
            return purchaseRequestRepository.save(existingRequest);
        }).orElseThrow(() -> new RuntimeException("Заявка не найдена"));
    }

    public void deletePurchaseRequest(Long id) {
        purchaseRequestRepository.deleteById(id);
    }
}

