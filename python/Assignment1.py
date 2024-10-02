class ATMMACHINE:
    def __init__(self):
        self.balance = 1000.00  
        self.pin="1234"
    def run(self):
        Enterpin=input("ENTER YOUR PIN: ")
        if(Enterpin==self.pin):
            while True:
                print("\nATM Menu:")
                print("1. Check Balance")
                print("2. Withdraw Money")
                print("3. Deposit Money")
                print("4. Change PIN")
                print("5. Exit")

                choice=input("ENTER YOUT CHOICE")

                if choice == '1':
                    self.check_balance()
                elif choice == '2':
                    self.withdraw_money()
                elif choice == '3':
                    self.money_deposite()
                elif choice == '4':
                    self.change_pin()
                elif choice == '5':
                    print("Thank you for using the ATM. Goodbye!")
                    break
                else:
                    print("Invalid option. Please try again.")
        else:
            print("Incorrect PIN.")
    
    def check_balance(self):
        print(f"Your balance is: ${self.balance:.2f}")

    def withdraw_money(self):
        amount=float(input("Enter amount to withdraw: $"))
        if(amount > self.balance):
            print("Insufficient balance")
        else:
            self.balance -= amount
            print(f"Withdrawal successful. New balance: ${self.balance:.2f}")

    def money_deposite(self):
        amount = float(input("Enter amount to deposit: $"))
        self.balance += amount
        print(f"Deposit successful. New balance: ${self.balance:.2f}")

    def change_pin(self):
        new_pin = input("Enter new PIN: ")
        self.pin = new_pin
        print("PIN changed successfully.")


if __name__=="__main__":
    atm=ATMMACHINE()
    atm.run()