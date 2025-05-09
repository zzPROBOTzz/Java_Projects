from matplotlib import pyplot as plt

def plot_data(x_data, y_data, title='Data Visualization', x_label='X-axis', y_label='Y-axis'):
    plt.figure(figsize=(10, 6))
    plt.plot(x_data, y_data, marker='o')
    plt.title(title)
    plt.xlabel(x_label)
    plt.ylabel(y_label)
    plt.grid()
    plt.show()

def bar_chart(categories, values, title='Bar Chart', x_label='Categories', y_label='Values'):
    plt.figure(figsize=(10, 6))
    plt.bar(categories, values, color='skyblue')
    plt.title(title)
    plt.xlabel(x_label)
    plt.ylabel(y_label)
    plt.xticks(rotation=45)
    plt.tight_layout()
    plt.show()

def pie_chart(labels, sizes, title='Pie Chart'):
    plt.figure(figsize=(8, 8))
    plt.pie(sizes, labels=labels, autopct='%1.1f%%', startangle=90)
    plt.axis('equal')
    plt.title(title)
    plt.show()