package org.example.hw6.mapper;

import org.example.hw6.dto.SaveAccountRequest;
import org.example.hw6.dto.UpdateAccountRequest;
import org.example.hw6.model.Account;

import java.util.Random;

public class AccountMapper {
    Random random = new Random();

    public Account toAccount(final String account) {
        String[] cols = account.split(";");
        return Account.builder()
            .id(Long.parseLong(cols[0]))
            .number(cols[1])
            .userId(Long.parseLong(cols[2]))
            .build();
    }

    public String toCsvRow(final Account account) {
        return String.format("%s;%s;%s", account.getId(), account.getNumber(), account.getUserId());
    }

    public Account toAccount(final SaveAccountRequest request) {
        return Account.builder().id(random.nextLong(1000))
            .number(request.getNumber())
            .userId(request.getUserId())
            .build();
    }

    public void updateAccount(final UpdateAccountRequest request, final Account account) {
        account.setUserId(request.getUserId());
    }
}
