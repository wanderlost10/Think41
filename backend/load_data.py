# Python script to load CSV data into MySQL
import pandas as pd
import mysql.connector

# ✅ Database credentials
db_config = {
    "host": "localhost",
    "user": "your_mysql_username",        # replace with your MySQL username
    "password": "your_mysql_password",    # replace with your MySQL password
    "database": "ecommerce_chatbot"       # make sure this DB exists
}

# ✅ Connect to MySQL
conn = mysql.connector.connect(**db_config)
cursor = conn.cursor()

# ✅ Create tables if not exist
cursor.execute("""
CREATE TABLE IF NOT EXISTS users (
    user_id VARCHAR(100) PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255)
);
""")

cursor.execute("""
CREATE TABLE IF NOT EXISTS products (
    product_id VARCHAR(100) PRIMARY KEY,
    product_name VARCHAR(255),
    category VARCHAR(100),
    price FLOAT,
    stock INT
);
""")

# ✅ Read CSV files
users_df = pd.read_csv("data/users.csv")
products_df = pd.read_csv("data/products.csv")

# ✅ Insert users
for _, row in users_df.iterrows():
    cursor.execute("""
        INSERT IGNORE INTO users (user_id, name, email)
        VALUES (%s, %s, %s)
    """, (row['user_id'], row['name'], row['email']))

# ✅ Insert products
for _, row in products_df.iterrows():
    cursor.execute("""
        INSERT IGNORE INTO products (product_id, product_name, category, price, stock)
        VALUES (%s, %s, %s, %s, %s)
    """, (row['product_id'], row['product_name'], row['category'], row['price'], row['stock']))

# ✅ Commit changes and close connection
conn.commit()
cursor.close()
conn.close()

print("✅ Data loaded successfully into the database.")
