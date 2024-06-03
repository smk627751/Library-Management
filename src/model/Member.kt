package model

class Member(
    username : String,
    password : String,
    private var name : String,
    private var contactInfo : String
)
    :User(username,password)
{
    private lateinit var memberAction : MemberAction
    val borrowedItems = mutableListOf<LibraryItem>()

    fun setAction(memberAction: MemberAction)
    {
        this.memberAction = memberAction
    }
    fun getAction() = memberAction

    override fun toString(): String {
        return "name: ${name}\n" +
                "username: ${getUsername()}\n" +
                "contactInfo: ${contactInfo}\n"
    }
}