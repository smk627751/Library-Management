package model

class Admin(
    username : String,
    password : String
)
    : User(username,password)
{
    private lateinit var adminAction : AdminAction

    fun setAction(adminAction: AdminAction)
    {
        this.adminAction = adminAction
    }

    fun getAction() = adminAction

    override fun toString(): String {
        return "Admin"
    }
}