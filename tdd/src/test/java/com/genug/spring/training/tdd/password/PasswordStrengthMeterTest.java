package com.genug.spring.training.tdd.password;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *  > 테스트 순서
 *      1. 통과하는 코드 작성
 *      2. 길이만 8글자 미만이고 나머지 조건은 충족하는 경우
 *      3. 숫자를 포함하지 않고 나머지 조건을 충족하는 경우
 *      4. 입력된 값이 없는 경우 -> NULL, Empty value, Blank value
 *      5. 대문자를 포함하지 않고 나머지 조건을 충족하는 경우
 *
 */
public class PasswordStrengthMeterTest {

    private final PasswordStrengthMeter meter = new PasswordStrengthMeter();

    @Test
    void name() {
    }

    private void assertStrength(PasswordStrength excepted, String password) {
        PasswordStrength result = meter.meter(password);
        assertEquals(excepted, result);
    }

    @Test
    @DisplayName("1. 암호강도 측정 테스트 - 강함")
    void meetsAllCriteria_Then_Strong() {
        assertStrength(PasswordStrength.STRONG, "ab12!@AB");
        assertStrength(PasswordStrength.STRONG, "abc1!Add");
    }

    @Test
    @DisplayName("2. 암호강도 측정 테스트 - 보통 <길이 검사>")
    void meetsOtherCriteria_except_for_Length_Then_Normal() {
        assertStrength(PasswordStrength.NORMAL, "ab12!@A");
    }

    @Test
    @DisplayName("3. 암호강도 측정 테스트 - 보통 <숫자포함 여부>")
    void meetsOtherCriteria_except_for_number_Then_Normal() {
        assertStrength(PasswordStrength.NORMAL, "ab!@AABB!@");
    }

    @Test
    @DisplayName("4-1. 암호강도 측정 테스트 - 실패 <입력값이 NULL 인 경우>")
    void nullInput_Then_Invalid() {
        assertStrength(PasswordStrength.INVALID, null);
    }

    @Test
    @DisplayName("4-2. 암호강도 측정 테스트 - 실패 <입력값이 ''인 경우>")
    void emptyInput_Then_Invalid() {
        assertStrength(PasswordStrength.INVALID, "");
    }

    @Test
    @DisplayName("4-3. 암호강도 측정 테스트 - 실패 <입력값이 ' '(blank)인 경우>")
    void blankInput_Then_Invalid() {
        assertStrength(PasswordStrength.INVALID, " ");
        assertStrength(PasswordStrength.INVALID, "                                              ");
    }

    @Test
    @DisplayName("5. 암호강도 측정 테스트 - 보통 <대문자를 포함하지 않고 나머지 조건을 충족하는 경우>")
    void meetsOtherCriteria_except_for_Uppercase_Then_Norma() {
        assertStrength(PasswordStrength.WEAK, "ab!@ccdd@$");
    }

    @Test
    @DisplayName("6. 암호강도 측정 테스트 - 약함 <길이가 8글자 이상인 조건만 충족하는 경우>")
    void meetsOnlyLengthCritera_Then_Weak() {
        assertStrength(PasswordStrength.WEAK, "abcdefghijkl");
    }

    @Test
    @DisplayName("7. 암호강도 측정 테스트 - 약함 <숫자 포함 조건만 충족하는 경우>")
    void meetsOnlyNumCriteria_Then_Weak() {
        assertStrength(PasswordStrength.WEAK, "12345");
    }

    @Test
    @DisplayName("8. 암호강도 측정 테스트 - 약함 <대문자 포함 조건만 충족하는 경우>")
    void meetsOnlyUpperCriteria_Then_Weak() {
        assertStrength(PasswordStrength.WEAK, "ABCDEFG");
    }

    @Test
    @DisplayName("9. 암호강도 측정 테스트 - 약함 <아무것도 충족하지 않는 경우>")
    void meetsNoCriteria_Then_Weak() {
        assertStrength(PasswordStrength.WEAK, "abc");
    }

}
