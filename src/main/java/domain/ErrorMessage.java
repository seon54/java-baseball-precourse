

package domain;

import static domain.Constant.*;

public enum ErrorMessage {
    NUMBER_RANGE_ERROR(String.format("[ERROR] %d에서 %d사이의 숫자를 입력해주세요", MIN_NUMBER, MAX_NUMBER)),
    DUPLICATED_NUMBER_ERROR("[ERROR] 중복된 숫자가 있습니다"),
    NUMBER_SIZE_ERROR(String.format("[ERROR] %d자리의 숫자를 입력해주세요", NUMBER_SIZE));

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}