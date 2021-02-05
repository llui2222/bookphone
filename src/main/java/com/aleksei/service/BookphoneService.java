package com.aleksei.service;

import com.aleksei.api.model.Phone;
import com.aleksei.api.model.PhoneUserIds;
import com.aleksei.api.model.User;
import com.aleksei.exception.PhoneIsAlreadyBooked;
import com.aleksei.repository.PhoneRepository;
import com.aleksei.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Date;

@Service
@AllArgsConstructor
public class BookphoneService {
    PhoneRepository phoneRepository;
    UserRepository userRepository;

    public Phone getPhoneById(Long phoneId) {
        com.aleksei.entity.Phone phone = phoneRepository.findById(phoneId)
                .orElseThrow(
                        ()-> new EntityNotFoundException("no such phone with id: " + phoneId)
                );

        User user = new User();
        Phone response = new Phone();
        response.setId(phone.getId());
        response.setName(phone.getPhonename());
        if(phone.getBooktimestamp()!=null){
            response.setBookedAt(phone.getBooktimestamp().toInstant().atOffset(ZoneOffset.UTC));
        }
        if(phone.getUser()!=null){
            user.setId(phone.getUser().getId());
            user.setName(phone.getUser().getUsername());
            response.setUser(user);
        }

        return response;

    }

    public void bookPhone(PhoneUserIds phoneUserIds) {
        @NotNull Long phoneId = phoneUserIds.getPhoneid();
        @NotNull Long userId = phoneUserIds.getUserid();

        com.aleksei.entity.Phone phone = phoneRepository.findById(phoneId)
                .orElseThrow(
                        ()-> new EntityNotFoundException("no such phone with id: " + phoneId)
                );
        if(phone.getUser()!=null){
            throw new PhoneIsAlreadyBooked(
                    "the phone with id: " + phoneId + " is already booked by the user  " + phone.getUser().getUsername()
            );
        }
        com.aleksei.entity.User user = userRepository.findById(userId)
                .orElseThrow(
                        ()-> new EntityNotFoundException("no such user with id: " + userId)
                );
        phone.setUser(user);
        phone.setBooktimestamp(Date.from(Instant.now()));
        phoneRepository.save(phone);
    }
}
