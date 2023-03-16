import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pro.sky.User;
import pro.sky.exception.IllegalEmailException;
import pro.sky.exception.SameLoginAndEmailException;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    public static final String VALID_LOGIN = "login";
    public static final String VALID_EMAIL = "email@company.com";
    public static final String ILLEGAL_EMAIL = "email.com";
    public static final String LOGIN_EQUALS_EMAIL = "email@company.com";

    @Test
    @DisplayName("Пользователь успешно создан и поля инициализированы")
    public void shouldCreateUserWithAllArgs() {
        User user = new User(VALID_LOGIN, VALID_EMAIL);
        assertEquals(VALID_LOGIN, user.getLogin());
        assertEquals(VALID_EMAIL, user.getEmail());
    }

    @Test
    @DisplayName("Пользователь успешно создан без параметров и поля инициализированы null'ами")
    public void shouldCreateUserWithNoArgs() {
        User user = new User();
        assertNull(user.getEmail());
        assertNull(user.getLogin());
    }

    @Test
    @DisplayName("Ошибка при создании user'а с некорректной почтой")
    public void shouldThrowIllegalEmailExcWhenCreatingUser() {
        assertThrows(IllegalEmailException.class, () -> new User(VALID_LOGIN, ILLEGAL_EMAIL));
    }

    @Test
    @DisplayName("Ошибка при создании user'a с одинаковой почтой и логином")
    public void shouldThrowSameLoginAndEmailExcWhenCreatingUser() {
        assertThrows(SameLoginAndEmailException.class, () -> new User(LOGIN_EQUALS_EMAIL, VALID_EMAIL));
    }

    // Немного тестов от себя
    @Test()
    @DisplayName("Ошибка при установке некорректной почты")
    void shouldThrowIllegalEmailExcWhenSetupIllegalEmail() {
        User user = new User();
        assertThrows(IllegalEmailException.class, () -> user.setEmail(ILLEGAL_EMAIL));
    }

    @Test()
    @DisplayName("Ошибка при установке почты идентичной логину")
    void shouldThrowSameLoginAndEmailExcWhenSetupEmailSameToLogin() {
        User user = new User();
        user.setLogin(LOGIN_EQUALS_EMAIL);
        assertThrows(SameLoginAndEmailException.class, () -> user.setEmail(VALID_EMAIL));
    }

    @Test()
    @DisplayName("Ошибка при установке логина идентичного почте")
    void shouldThrowSameLoginAndEmailExcWhenSetupLoginSameToEmail() {
        User user = new User();
        user.setEmail(VALID_EMAIL);
        assertThrows(SameLoginAndEmailException.class, () -> user.setLogin(LOGIN_EQUALS_EMAIL));
    }

    @Test
    @DisplayName("Пользователь успешно создан без параметров и поля инициализированы с помощью setter'ов")
    public void shouldCreateUserWithNoArgsAndInitializeFieldsWithSetters() {
        User user = new User();
        user.setEmail(VALID_EMAIL);
        user.setLogin(VALID_LOGIN);
        assertEquals(VALID_EMAIL, user.getEmail());
        assertEquals(VALID_LOGIN, user.getLogin());
    }
}