package pro.sky;

import pro.sky.exception.IllegalEmailException;
import pro.sky.exception.SameLoginAndEmailException;

public class User {
    private String login;
    private String email;

    public User() {
    }

    public User(String login, String email) {
        if (login.equals(email)) {
            throw new SameLoginAndEmailException("Почта и логин не должны совпадать!");
        }
        if (!isEmailValid(email)){
            throw new IllegalEmailException("Укажите актуальную почту!");
        }
        this.login = login;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public void setLogin(String login) throws SameLoginAndEmailException{
        if (login.equals(this.email)){
            throw new SameLoginAndEmailException("Почта и логин не должны совпадать!");
        }
        this.login = login;
    }

    public void setEmail(String email) throws SameLoginAndEmailException, IllegalEmailException{
        if (email.equals(this.login)){
            throw new SameLoginAndEmailException("Почта и логин не должны совпадать!");
        } else if (!isEmailValid(email)) {
            throw new IllegalEmailException("Укажите актуальную почту!");
        }
        this.email = email;
    }

    private boolean isEmailValid(String email){
        return email.matches("^[a-zA-z0-9._-]+@[a-zA-z0-9-]+.[a-zA-z]{2,4}$");
    }
}