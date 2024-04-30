classDiagram
direction BT
class Bank {
  + Bank() 
  + getUser(String) User
}
class BankAuthorization {
  + BankAuthorization() 
  + enterUser(String, String) boolean
  + registrationUser(String, String) boolean
}
class BankOperation {
  + BankOperation() 
  + deposit(User, Double) void
  + takeCredit(User, Double) void
  + getHistory(User) void
  + getBalance(User) void
  + withdraw(User, Double) boolean
}
class BankTransaction {
  + BankTransaction() 
  + BankTransaction(Double, String, User) 
  - generateTransactionNumber() String
  + getInfoTransaction() void
}
class DbConnection {
  + DbConnection() 
}
class Main {
  + Main() 
  + main(String[]) void
}
class User {
  + User() 
  + User(String, String) 
  + setLogin(String) void
  + getHistoryTransactions() List~BankTransaction~
  + getCreditDebt() Double
  + setCreditDebt(Double) void
  + setMoney(Double) void
  + getPassword() String
  + addTransaction(BankTransaction) void
  + getUserId() int
  + getLogin() String
  + setPassword(String) void
  + getMoney() Double
}
class UserActions {
  + UserActions() 
  + authorizationAction() boolean
  + basicActions() void
}
class WorkProgramme {
  + WorkProgramme() 
  + startProgramme() void
}
class WorkWithData {
  + WorkWithData() 
  + saveUser(User) boolean
  + updateUser(User) boolean
  + getAllUsers() List~User~
  + saveTransact(BankTransaction) boolean
  + findUser(String) User?
}

Bank "1" *--> "transactionHashMap *" BankTransaction 
Bank "1" *--> "users *" User 
BankAuthorization  -->  Bank 
BankAuthorization  ..>  User : «create»
BankAuthorization  ..>  WorkWithData 
BankOperation  -->  Bank 
BankOperation  ..>  BankTransaction : «create»
BankOperation  ..>  User 
BankTransaction  -->  BankOperation 
BankTransaction "1" *--> "user 1" User 
DbConnection  ..>  BankTransaction 
DbConnection  ..>  User 
Main  ..>  DbConnection : «create»
Main  ..>  WorkProgramme 
User "1" *--> "transactions *" BankTransaction 
User  ..>  WorkWithData 
UserActions  ..>  Bank 
UserActions  ..>  BankAuthorization : «create»
UserActions  ..>  BankOperation : «create»
UserActions "1" *--> "user 1" User 
UserActions  ..>  WorkWithData 
WorkProgramme  -->  UserActions 
WorkProgramme  ..>  UserActions : «create»
WorkWithData  ..>  BankTransaction 
WorkWithData  ..>  DbConnection 
WorkWithData  ..>  User 
