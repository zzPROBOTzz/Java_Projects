import bcrypt
from database import create_connection

def register_user(username, password):
    hashed_pw = bcrypt.hashpw(password.encode(), bcrypt.gensalt())
    conn = create_connection()
    cur = conn.cursor()
    try:
        cur.execute("INSERT INTO users (username, password) VALUES (?, ?)", (username, hashed_pw))
        conn.commit()
        return True
    except:
        return False
    finally:
        conn.close()

def login_user(username, password):
    conn = create_connection()
    cur = conn.cursor()
    cur.execute("SELECT id, password FROM users WHERE username = ?", (username,))
    user = cur.fetchone()
    conn.close()
    if user and bcrypt.checkpw(password.encode(), user[1]):
        return user[0]  # Return user ID
    return None
