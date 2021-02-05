package com.aleksei.controller;


import com.aleksei.api.BookphoneApi;
import com.aleksei.api.PhonesApi;
import com.aleksei.api.model.Phone;
import com.aleksei.api.model.PhoneUserIds;
import com.aleksei.exception.PhoneIsAlreadyBooked;
import com.aleksei.service.BookphoneService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class BookphoneApiController implements PhonesApi, BookphoneApi {

    BookphoneService bookphoneService;


    @Override
    public ResponseEntity<Void> bookPhone(@Valid PhoneUserIds phoneUserIds) {
        bookphoneService.bookPhone(phoneUserIds);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<Phone> exposePhoneById(Long phoneId) {
        return ResponseEntity.ok(bookphoneService.getPhoneById(phoneId));
    }
}
