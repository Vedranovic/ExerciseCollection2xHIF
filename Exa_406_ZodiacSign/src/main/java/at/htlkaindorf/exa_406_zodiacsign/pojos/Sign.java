package at.htlkaindorf.exa_406_zodiacsign.pojos;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Sign {
    private double latitude;
    private double longitude;
    private LocalDate birthDate;
    private LocalTime birthTime;

    public Sign(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Sign(LocalDate birthDate, LocalTime birthTime, double longitude, double latitude) {
        this.birthDate = birthDate;
        this.birthTime = birthTime;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public int getDays() {
        return (int) ChronoUnit.DAYS.between(birthDate, LocalDate.now());
    }

    public String calcZodiac() throws Exception {
        int day = birthDate.getDayOfMonth();
        int month = birthDate.getMonthValue();

        return switch (month) {
            case 1  -> (day < 20) ? "Capricorn" : "Aquarius";
            case 2  -> (day < 19) ? "Aquarius" : "Pisces";
            case 3  -> (day < 21) ? "Pisces" : "Aries";
            case 4  -> (day < 20) ? "Aries" : "Taurus";
            case 5  -> (day < 21) ? "Taurus" : "Gemini";
            case 6  -> (day < 21) ? "Gemini" : "Cancer";
            case 7  -> (day < 23) ? "Cancer" : "Leo";
            case 8  -> (day < 23) ? "Leo" : "Virgo";
            case 9  -> (day < 23) ? "Virgo" : "Libra";
            case 10 -> (day < 23) ? "Libra" : "Scorpio";
            case 11 -> (day < 22) ? "Scorpio" : "Sagittarius";
            case 12 -> (day < 22) ? "Sagittarius" : "Capricorn";
            default -> throw new Exception("No zodiac found!");
        };
    }

    public String calcAscendant() {
        double jd = toJulianDate(birthDate, birthTime);
        double gmst = calcGMST(jd);
        double lst = gmst + longitude / 15.0;
        lst = normaliseHours(lst);
        double degree = calcAscendantDegree(lst, latitude);

        return zodiacFromDegree(degree);
    }

    private double toJulianDate(LocalDate date, LocalTime time) {
        int Y = date.getYear();
        int M = date.getMonthValue();
        double D = date.getDayOfMonth() + (time.getHour() + time.getMinute() / 60.0
                + time.getSecond() / 3600.0) / 24.0;

        if (M <= 2) {
            Y -= 1;
            M += 12;
        }

        int A = Y / 100;
        int B = 2 - A + (A / 4);

        return Math.floor(365.25 * (Y + 4716))
                + Math.floor(30.6001 * (M + 1))
                + D + B - 1524.5;
    }

    private double calcGMST(double jd) {
        double T = (jd - 2451545.0) / 36525.0;
        double gmst = 280.46061837
                + 360.98564736629 * (jd - 2451545.0)
                + 0.000387933 * T * T
                - T * T * T / 38710000.0;

        gmst = (gmst % 360 + 360) % 360;

        return gmst / 15.0;
    }

    private double normaliseHours(double h) {
        h = h % 24.0;

        return (h < 0) ? h + 24.0 : h;
    }

    private double calcAscendantDegree(double lstHours, double latitude) {
        double lst = Math.toRadians(lstHours * 15.0);
        double lat = Math.toRadians(latitude);

        double e = Math.toRadians(23.4392911);

        double tanL = Math.tan(lat);
        double sinE = Math.sin(e);
        double cosE = Math.cos(e);

        double asc = Math.atan2(
                Math.cos(lst),
                -Math.sin(lst) * cosE - tanL * sinE
        );

        asc = Math.toDegrees(asc);
        if (asc < 0) asc += 360;

        return asc;
    }

    private static String zodiacFromDegree(double degree) {
        String[] signs = {
                "Aries", "Taurus", "Gemini", "Cancer",
                "Leo", "Virgo", "Libra", "Scorpio",
                "Sagittarius", "Capricorn", "Aquarius", "Pisces"
        };
        int index = (int) (degree / 30.0);

        return signs[index];
    }
}
