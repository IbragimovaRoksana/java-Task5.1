import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void ShouldCalculateforRegisterdAndUnderlimit() {
        BonusService service = new BonusService();
        //подготавливаем данные:
        long amount = 1000_00;
        boolean registered = true;
        long expected = 30;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        //производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @Test
    void ShouldCalculateforRegisterdAndOverlimit() {
        BonusService service = new BonusService();
        //подготавливаем данные:
        long amount = 100000_00;
        boolean registered = true;
        long expected = 500;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        //производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @Test
    void ShouldCalculateforNotRegisterdAndUnderlimit() {
        BonusService service = new BonusService();
        //подготавливаем данные:
        long amount = 1000_00;
        boolean registered = false;
        long expected = 10;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        //производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @Test
    void ShouldCalculateforNotRegisterdAndOverlimit() {
        BonusService service = new BonusService();
        //подготавливаем данные:
        long amount = 100000_00;
        boolean registered = false;
        long expected = 500;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        //производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @Test
    void ShouldCalculateforRegisterdNegativeAmount() {
        BonusService service = new BonusService();
        //подготавливаем данные:
        long amount = -1000_00;
        boolean registered = true;
        long expected = 0;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        //производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @Test
    void ShouldCalculateforNotRegisterdNegativeAmount() {
        BonusService service = new BonusService();
        //подготавливаем данные:
        long amount = -1000_00;
        boolean registered = false;
        long expected = 0;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        //производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }
}