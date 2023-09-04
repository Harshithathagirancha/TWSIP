#include <iostream>
#include <string>
#include <vector>

using namespace std;

class BankAccount {
private:
    string accountNumber;
    string accountHolderName;
    double balance;

public:
    BankAccount(string accNum, string accHolderName, double initialBalance) {
        accountNumber = accNum;
        accountHolderName = accHolderName;
        balance = initialBalance;
    }

    void deposit(double amount) {
        balance += amount;
        cout << "Deposit successful. New balance: " << balance << endl;
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            cout << "Withdrawal successful. New balance: " << balance << endl;
        } else {
            cout << "Insufficient balance. Withdrawal failed." << endl;
        }
    }

    void checkBalance() {
        cout << "Account balance: " << balance << endl;
    }

    void generateStatement() {
        cout << "Account Statement for " << accountHolderName << endl;
        cout << "Account Number: " << accountNumber << endl;
        cout << "Balance: " << balance << endl;
    }
};

int main() {
    vector<BankAccount> accounts;

    while (true) {
        cout << "Welcome to the Bank Management System!" << endl;
        cout << "1. Create Account" << endl;
        cout << "2. Deposit" << endl;
        cout << "3. Withdraw" << endl;
        cout << "4. Check Balance" << endl;
        cout << "5. Generate Account Statement" << endl;
        cout << "6. Exit" << endl;
        cout << "Enter your choice: ";

        int choice;
        cin >> choice;

        switch (choice) {
            case 1: {
                cout << "Enter account number: ";
                string accNum;
                cin >> accNum;

                cout << "Enter account holder name: ";
                string accHolderName;
                cin.ignore();
                getline(cin, accHolderName);

                cout << "Enter initial balance: ";
                double initialBalance;
                cin >> initialBalance;

                BankAccount newAccount(accNum, accHolderName, initialBalance);
                accounts.push_back(newAccount);

                cout << "Account created successfully!" << endl;
                break;
            }
            case 2: {
                cout << "Enter account number: ";
                string accNum;
                cin >> accNum;

                bool accountFound = false;
                for (BankAccount& account : accounts) {
                    if (account.getAccountNumber() == accNum) {
                        double amount;
                        cout << "Enter amount to deposit: ";
                        cin >> amount;
                        account.deposit(amount);
                        accountFound = true;
                        break;
                    }
                }

                if (!accountFound) {
                    cout << "Account not found." << endl;
                }
                break;
            }
            case 3: {
                cout << "Enter account number: ";
                string accNum;
                cin >> accNum;

                bool accountFound = false;
                for (BankAccount& account : accounts) {
                    if (account.getAccountNumber() == accNum) {
                        double amount;
                        cout << "Enter amount to withdraw: ";
                        cin >> amount;
                        account.withdraw(amount);
                        accountFound = true;
                        break;
                    }
                }

                if (!accountFound) {
                    cout << "Account not found." << endl;
                }
                break;
            }
            case 4: {
                cout << "Enter account number: ";
                string accNum;
                cin >> accNum;

                bool accountFound = false;
                for (BankAccount& account : accounts) {
                    if (account.getAccountNumber() == accNum) {
                        account.checkBalance();
                        accountFound = true;
                        break;
                    }
                }

                if (!accountFound) {
                    cout << "Account not found." << endl;
                }
                break;
            }
            case 5: {
                cout << "Enter account number: ";
                string accNum;
                cin >> accNum;

                bool accountFound = false;
                for (BankAccount& account : accounts) {
                    if (account.getAccountNumber() == accNum) {
                        account.generateStatement();
                        accountFound = true;
                        break;
                    }
                }

                if (!accountFound) {
                    cout << "Account not found." << endl;
                }
                break;
            }
            case 6: {
                cout << "Thank you for using the Bank Management System. Goodbye!" << endl;
                return 0;
            }
            default:
                cout << "Invalid choice. Please try again." << endl;
                break;
        }
    }

    return 0;
}