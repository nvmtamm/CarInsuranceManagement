/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

/**
 *
 * @author khach
 */
public interface Acceptable {
 

    public final String DATE_VALID =
            "^(0[1-9]|[12][0-9]|3[01])/"
          + "(0[1-9]|1[0-2])/"
          + "\\d{4}$";

    public final String POSITIVE_INT_VALID = "^[1-9]\\d*$";
    
      // ===== VEHICLE =====

    // License plate: 50-59 + chữ + số (1-9) + 5 số
    public static final String LICENSE_PLATE = "^5[0-9][A-Z][1-9]\\d{5}$";

    // Car owner: 2-25 ký tự (chữ + khoảng trắng)
    public static final String CAR_OWNER = "^[A-Za-z ]{2,25}$";

    // Phone: 10 số, bắt đầu bằng 0
    public static final String PHONE = "^0\\d{9}$";

    // Car brand: 5-12 ký tự, không rỗng
    public static final String CAR_BRAND = "^.{5,12}$";

    // Vehicle value: > 999
    public static final String VEHICLE_VALUE = "^[1-9]\\d{3,}$";

    // Number of seats: 4 → 36
    public static final String SEATS = "^(?:[4-9]|[1-2]\\d|3[0-6])$";
    
    public static final String PLACE =
        "^[A-Za-z ]{3,20}$";


    // ===== INSURANCE =====

    // Insurance ID: 4 ký tự chữ hoặc số
    public static final String INSURANCE_ID = "^[A-Za-z0-9]{4}$";

    // License plate (reuse)
    public static final String INS_LICENSE_PLATE = "^5[0-9][A-Z][1-9]\\d{5}$";

    // Insurance period: 12, 24, 36
    public static final String PERIOD = "^(12|24|36)$";

    // Fees: số nguyên dương
    public static final String FEES = "^[1-9]\\d*$";

    // Insurance owner: 2-25 ký tự
    public static final String INS_OWNER = "^[A-Za-z ]{2,25}$";
    
    /**
     * Kiểm tra tính hợp lệ của dữ liệu đầu vào dựa vào một pattern regex
     * @param data chuỗi dữ liệu cần kiểm tra
     * @param pattern regex pattern để kiểm tra
     * @return true nếu dữ liệu hợp lệ (khớp với pattern), false nếu không
     */
    public static boolean isValid(String data, String pattern) {
        return data.matches(pattern);
    }
}
