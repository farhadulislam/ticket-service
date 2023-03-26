package Model;

import Utility.Constants;
import lombok.*;

import java.io.Serial;
import java.util.HashMap;
import java.util.Map;

@Builder
@NonNull
@ToString
@NoArgsConstructor

public class Account {
    @NonNull
    @Serial
    @Getter
    private Long accountId;

    Account (Long accountId){
        if (accountId < 1){
            throw new IllegalArgumentException("Account ID must be greater than zero:");
        } else {
            this.accountId = accountId;
        }
    }

}
