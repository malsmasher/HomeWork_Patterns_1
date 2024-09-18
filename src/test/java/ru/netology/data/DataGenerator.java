package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity(String locale) {
        String[] city = { "Москва", "Архангельск", "Санкт-Петербург", "Барнаул", "Якутск",
                "Липецк", "Новосибирск", "Великий Новгород", "Владивосток",
                "Киров", "Екатеринбург", "Волгоград", "Коломна", "Воронеж", "Пермь", "Ярославль",
                "Грозный", "Пенза", "Самара", "Рязань",
                "Йошкар-Ола", "Казань", "Калининград", "Орёл",
                "Уфа", "Тула", "Кострома", "Тамбов", "Тверь", "Курган"};

        return city[new Random().nextInt(city.length)];

    }

    //public static String generateCity(String local){
        //Faker faker = new Faker(new Locale(local));
        //return faker.address().city();
    //}

    public static String generateName(String locale) {
        String name = new Faker(new Locale(locale)).name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {
        String phone = new Faker(new Locale(locale)).phoneNumber().phoneNumber();
        return phone;
    }

    public static String generateWrongPhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.numerify("####");
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {

            String city = generateCity(locale);
            String name = generateName(locale);
            String phone = generatePhone(locale);
            UserInfo user = new UserInfo(city, name, phone);
            return user;
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}