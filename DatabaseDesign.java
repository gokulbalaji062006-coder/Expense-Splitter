CREATE DATABASE expensesplitter;
USE expensesplitter;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE expenses (
    id INT PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(100),
    amount DOUBLE,
    paid_by INT,
    FOREIGN KEY (paid_by) REFERENCES users(id)
);

CREATE TABLE splits (
    id INT PRIMARY KEY AUTO_INCREMENT,
    expense_id INT,
    user_id INT,
    amount_owed DOUBLE,
    FOREIGN KEY (expense_id) REFERENCES expenses(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);
