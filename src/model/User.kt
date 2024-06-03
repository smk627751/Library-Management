package model

abstract class User(
    private var username : String,
    private var password : String
) {
    fun getUsername() = username
    fun checkPassword(password: String) = this.password == password
}