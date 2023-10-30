package com.comodif.challenge.service;

import com.comodif.challenge.repository.PaymentRepository;
import com.comodif.challenge.entity.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;


@Service
@Transactional
public class PaymentService {

    private Logger logger = LoggerFactory.getLogger(PaymentService.class);

    private BankService bankService;
    private PaymentRepository paymentRepository;

    public PaymentService(BankService bankService, PaymentRepository paymentRepository) {
        this.bankService = bankService;
        this.paymentRepository = paymentRepository;
    }

    public void pay(BigDecimal price) {
        logger.info("START - Payment process");
        //pay with bank
        BankPaymentRequest request = new BankPaymentRequest();
        request.setPrice(price);
        BankPaymentResponse response = bankService.pay(request);

        //insert records
        Payment payment = new Payment();
        payment.setBankResponse(response.getResultCode());
        payment.setPrice(price);
        paymentRepository.save(payment);

        logger.info("FINISH - Payment saved successfully!");
    }

}
