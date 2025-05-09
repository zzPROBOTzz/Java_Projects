import tkinter as tk
from security import register_user, login_user

def run_app():
    def login():
        uid = login_user(username_entry.get(), password_entry.get())
        if uid:
            msg_label.config(text="Login Successful!", fg="green")
        else:
            msg_label.config(text="Login Failed", fg="red")

    root = tk.Tk()
    root.title("Budget Manager Login")

    tk.Label(root, text="Username").pack()
    username_entry = tk.Entry(root)
    username_entry.pack()

    tk.Label(root, text="Password").pack()
    password_entry = tk.Entry(root, show="*")
    password_entry.pack()

    tk.Button(root, text="Login", command=login).pack()
    msg_label = tk.Label(root, text="")
    msg_label.pack()

    root.mainloop()
