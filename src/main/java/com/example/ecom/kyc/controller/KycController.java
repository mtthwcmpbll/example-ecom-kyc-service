package com.example.ecom.kyc.controller;

import com.example.ecom.common.dto.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kyc")
public class KycController {

    @PostMapping("/check")
    public ApiResponse<KycResponse> checkCustomer(@RequestBody KycRequest request) {
        // Mock implementation: Always allow
        return ApiResponse.success(new KycResponse(request.getCustomerId(), "ALLOW"));
    }

    public static class KycRequest {
        private Long customerId;

        public Long getCustomerId() {
            return customerId;
        }

        public void setCustomerId(Long customerId) {
            this.customerId = customerId;
        }
    }

    public static class KycResponse {
        private Long customerId;
        private String status;

        public KycResponse(Long customerId, String status) {
            this.customerId = customerId;
            this.status = status;
        }

        public Long getCustomerId() {
            return customerId;
        }

        public void setCustomerId(Long customerId) {
            this.customerId = customerId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
