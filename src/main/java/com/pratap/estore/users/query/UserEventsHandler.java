package com.pratap.estore.users.query;

import com.pratap.estore.shared.model.PaymentDetails;
import com.pratap.estore.shared.model.User;
import com.pratap.estore.shared.query.FetchUserPaymentDetailsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class UserEventsHandler {

    @QueryHandler
    public User findUserPaymentDetails(FetchUserPaymentDetailsQuery query) {

        PaymentDetails paymentDetails = PaymentDetails.builder()
                .cardNumber("123Card")
                .cvv("123")
                .name("PRATAP NARAYAN")
                .validUntilMonth(12)
                .validUntilYear(2030)
                .build();

        return User.builder()
                .firstName("Pratap")
                .lastName("Narayan")
                .userId(query.getUserId())
                .paymentDetails(paymentDetails)
                .build();
    }
}
