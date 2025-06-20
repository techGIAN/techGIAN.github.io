class BankAccount:

    def __init__(self, balance=1000, interest_rate=0.05):
        self.balance = balance
        self.interest_rate = interest_rate

    def get_balance(self):
        return self.balance

    def get_interest_rate(self):
        return self.interest_rate

    def deposit(self, amt):
        self.balance += amt

    def withdraw(self, amt):
        self.balance = max(0, self.balance - amt)

    def withdraw_all(self):
        self.balance = 0
        # self.withdraw(self.balance)             # another way of doing it
        # self.withdraw(self.get_balance())       # another way of doing it

    def apply_interest(self):
        self.balance *= (1 + self.interest_rate)