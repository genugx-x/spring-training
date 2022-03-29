package com.genug.spring.training.tdd.password;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String password) {
        // return null;                         // 1. 컴파일 에러 제거
        // return PasswordStrength.STRONG;      // 2. 첫 테스트로 가장 쉬운 테스트 코드 작성

        // 공백만(공백수는 상관없음) 있는 문자열인 경우 isEmpty : true, isEmpty : false
        // 공백이 없는 길이가 0인 문자열인 경우 isEmpty : true, isEmpty : true
        // System.out.println("Is blank? " + password.isBlank() + ", Is empty? " + password.isEmpty());
        if (password == null || password.isBlank() || password.isEmpty()) {
            return PasswordStrength.INVALID;
        }

        int strengthCounts = countStrength(password);
        if (strengthCounts <= 1)
            return PasswordStrength.WEAK;
        if (strengthCounts == 2)
            return PasswordStrength.NORMAL;
        /*
        if (lengthEnough && !doNumsExist && !doUpperExist) {
            return PasswordStrength.WEAK;
        }
        if (!lengthEnough && doNumsExist && !doUpperExist) {
            return PasswordStrength.WEAK;
        }
        if (!lengthEnough && !doNumsExist && doUpperExist) {
            return PasswordStrength.WEAK;
        }
        // 문자 길이 8글자 미만
        if (!lengthEnough)
            return PasswordStrength.NORMAL;
        // 숫자 포함 여부 확인
        if (!doNumsExist)
            return PasswordStrength.NORMAL;
        // 대문자 포함 여부 확인
        if (!doUpperExist)
            return PasswordStrength.NORMAL;

         */

        return PasswordStrength.STRONG;
    }

    private int countStrength(String password) {
        int strengthCounts = 0;
        if (password.length() >= 8)
            strengthCounts++;
        if (meetsContainingNumberCriteria(password))
            strengthCounts++;
        if (meetsContainingUpperCaseCriteria(password))
            strengthCounts++;
        return strengthCounts;
    }

    // 대문자 포함 여부 확인 및 결과값 응답 - 포함 'true' 미포함 'false' 리턴
    private boolean meetsContainingUpperCaseCriteria(String password) {
        boolean doUpperExist = false;
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                doUpperExist = true;
                break;
            }
        }
        return doUpperExist;
    }

    // 숫자 포함 여부 확인 및 결과값 응답 - 포함은 'true' 미포함은 'false' 리턴
    private boolean meetsContainingNumberCriteria(String password) {
        boolean doNumsExist = false;
        for (char ch : password.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                doNumsExist = true;
                break;
            }
        }
        return doNumsExist;
    }

}
